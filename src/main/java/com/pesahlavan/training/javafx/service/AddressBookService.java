package com.pesahlavan.training.javafx.service;

import com.google.common.collect.Lists;
import com.pesahlavan.training.javafx.entity.Person;
import com.pesahlavan.training.javafx.repository.PersonRepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class AddressBookService implements AddressBook {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public void add(Person person) {
        personRepository.save(person);
    }

    @Override
    public void update(Person person) {
        personRepository.save(person);
    }

    @Override
    public void delete(Person person) {
        personRepository.delete(person);
    }

    @Override
    public ObservableList<Person> findAll() {
        return FXCollections.observableArrayList(Lists.newArrayList(personRepository.findAll()));
    }

    @Override
    public ObservableList<Person> find(String text) {
        return FXCollections.observableArrayList(Lists.newArrayList(personRepository.findByFioContainingIgnoreCase(text)));
    }

    @Override
    public Page<Person> findAll(int from, int count) {
        return personRepository.findAll(new PageRequest(from, count, Sort.Direction.ASC, "fio"));
    }

    @Override
    public Page<Person> findAll(int from, int count, String... text) {
        return personRepository.findByFioContainingIgnoreCase(text[0], new PageRequest(from, count, Sort.Direction.ASC, "fio"));
    }


}


