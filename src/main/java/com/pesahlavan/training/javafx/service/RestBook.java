package com.pesahlavan.training.javafx.service;


import com.pesahlavan.training.javafx.entity.Person;
import javafx.collections.ObservableList;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Logger;

@Service
public class RestBook implements AddressBook {

    private static final String REST_URL = "http://localhost:8080//rest_adrbook_springboot_jfx-0.0.1-SNAPSHOT/addressbook";

    @Override
    public void add(Person person) {
        addOrUpdate(person);
    }

    @Override
    public void update(Person person) {
        addOrUpdate(person);
    }

    private boolean addOrUpdate(Person person){
        RestTemplate restTemplate = new RestTemplate();

        try {

            ResponseEntity<Boolean> responseEntity = restTemplate.exchange(REST_URL+"/addOrUpdate", HttpMethod.POST, new HttpEntity<Person>(person), new ParameterizedTypeReference<Boolean>() {
            });


            if (responseEntity.getStatusCode() == HttpStatus.OK) {
                Boolean result = responseEntity.getBody();
                if (!result){
                    throw new Exception("not added or updated");
                }
            }

        } catch (Exception e) {
            Logger.getLogger(RestBook.class.getName(), e.getMessage());
            return false;
        }

        return true;
    }

    @Override
    public void delete(Person person) {
        RestTemplate restTemplate = new RestTemplate();

        try {

            ResponseEntity<Boolean> responseEntity = restTemplate.exchange(REST_URL+"/delete?id="+person.getId(), HttpMethod.GET, null, new ParameterizedTypeReference<Boolean>() {
            });

            if (responseEntity.getStatusCode() == HttpStatus.OK) {
                Boolean result = responseEntity.getBody();
                if (!result){
                    throw new Exception("not deleted");
                }
            }

        } catch (Exception e) {
            Logger.getLogger(RestBook.class.getName(), e.getMessage());
        }


    }

    @Override
    public ObservableList<Person> findAll() {
        return null;
    }

    @Override
    public ObservableList<Person> find(String text) {
        return null;
    }

    @Override
    public Page<Person> findAll(int from, int count) {
        return createPage(REST_URL + "/all?from=" + from + "&count=" + count, from, count);
    }

    @Override
    public Page findAll(int from, int count, String... text) {
        return createPage(REST_URL + "/search?from=" + from + "&count=" + count + "&text=" + text[0], from, count);
    }

    private Page createPage(String url, int from, int count) {
        PageRequest pageRequest = new PageRequest(from, count, Sort.Direction.ASC, "fio");

        PageImpl<Person> page = null;
        RestTemplate restTemplate = new RestTemplate();

        try {

            ResponseEntity<ListWrapper> responseEntity = restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<ListWrapper>() {
            });

            if (responseEntity.getStatusCode() == HttpStatus.OK) {
                ListWrapper wrapper = responseEntity.getBody();
                page = new PageImpl<>(wrapper.getList(), pageRequest, wrapper.getTotalCount());
            }

        } catch (Exception e) {
            Logger.getLogger(RestBook.class.getName(), e.getMessage());
        }


        return page;

    }


}