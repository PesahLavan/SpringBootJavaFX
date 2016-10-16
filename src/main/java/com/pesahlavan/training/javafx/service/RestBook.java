package com.pesahlavan.training.javafx.service;


import javafx.collections.ObservableList;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.pesahlavan.training.javafx.entity.Person;

import java.util.List;

@Service
public class RestBook implements AddressBook{

    private static final String REST_URL = "http://localhost:8080/addressbookservice-0.0.1-SNAPSHOT/addressbook/";

    @Override
    public void add(Person person) {

    }

    @Override
    public void update(Person person) {

    }

    @Override
    public void delete(Person person) {

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
    public Page findAll(int from, int count) {

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<List<Person>> responseEntity = restTemplate.exchange(REST_URL+"/all", HttpMethod.GET, null, new ParameterizedTypeReference<List<Person>>(){});

        if (responseEntity.getStatusCode() == HttpStatus.OK) {
            List<Person> list = responseEntity.getBody();
            System.out.println("list.get(0).getFio() = " + list.get(0).getFio());
        }

        return null;
    }

    @Override
    public Page findAll(int from, int count, String... text) {
        return null;
    }
}
