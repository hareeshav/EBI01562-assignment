package com.hareesh.demo.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hareesh.demo.model.Person;

@Repository
public interface PersonDao extends CrudRepository<Person, Integer> {

    Person findByFirstName(String firstname);
}
