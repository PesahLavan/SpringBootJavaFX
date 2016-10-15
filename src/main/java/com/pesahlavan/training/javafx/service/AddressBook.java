package com.pesahlavan.training.javafx.service;

import com.pesahlavan.training.javafx.entity.Person;
import javafx.collections.ObservableList;

public interface AddressBook {
    void add(Person person);

    void update(Person person);

    void delete(Person person);

    ObservableList<Person> findAll();

    ObservableList<Person> find(String text);
}
