package com.pesahlavan.training.javafx.service;

import com.pesahlavan.training.javafx.entity.Person;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ListWrapper {

    private List<Person> list;
    private long totalCount;


}