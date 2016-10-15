package com.pesahlavan.training.javafx.repository;

import com.pesahlavan.training.javafx.entity.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends CrudRepository<Person, Integer> {
    List<Person> findByFioContainingIgnoreCase(String fio);
}
