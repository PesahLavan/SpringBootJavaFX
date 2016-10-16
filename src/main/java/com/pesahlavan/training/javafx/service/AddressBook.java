package com.pesahlavan.training.javafx.service;

import com.pesahlavan.training.javafx.entity.Person;
import javafx.collections.ObservableList;
import org.springframework.data.domain.Page;

public interface AddressBook {

    void add(Person person);

    void update(Person person);

    void delete(Person person);

    ObservableList<Person> findAll();

    ObservableList<Person> find(String text);

    Page<Person> findAll(int from, int count);

    Page<Person> findAll(int from, int count, String... text);


}

