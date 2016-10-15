package com.pesahlavan.training.javafx.repository;

import com.pesahlavan.training.javafx.entity.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {

    List<Person> findByFioContainingIgnoreCase(String fio);

    Page<Person> findByFioContainingIgnoreCase(String fio, Pageable pageable);


}
