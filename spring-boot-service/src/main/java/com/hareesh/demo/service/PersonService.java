package com.hareesh.demo.service;

import java.util.List;

import com.hareesh.demo.dto.PersonDto;
import com.hareesh.demo.model.Person;

public interface PersonService {

	Person save(PersonDto user);

	List<Person> findAll();

	void delete(int id);

	//Person findOne(String username);

	Person findById(int id);

	PersonDto update(PersonDto personDto);
}
