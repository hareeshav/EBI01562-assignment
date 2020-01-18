package com.hareesh.demo.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hareesh.demo.dao.PersonDao;
import com.hareesh.demo.dto.PersonDto;
import com.hareesh.demo.exception.UserNotFoundException;
import com.hareesh.demo.model.Person;
import com.hareesh.demo.service.PersonService;

@Transactional
@Service(value = "personService")
public class PersonServiceImpl implements PersonService {
	
	@Autowired
	private PersonDao personDao;

	public List<Person> findAll() {
		List<Person> list = new ArrayList<>();
		personDao.findAll().iterator().forEachRemaining(list::add);
		return list;
	}

	@Override
	public void delete(int id) {
		personDao.deleteById(id);
	}

	/*@Override
	public Person findOne(String personname) {
		return personDao.findByPersonname(personname);
	}*/

	@Override
	public Person findById(int id) {
		Optional<Person> optionalUser = personDao.findById(id);
		Person person = optionalUser.isPresent() ? optionalUser.get() : null;
		if(null == person) {
			throw new UserNotFoundException("Person not found in Database");
		}
		return person;
	}

    @Override
    public PersonDto update(PersonDto personDto) {
    	Person person = findById(personDto.getId());
        if(person != null) {
            BeanUtils.copyProperties(personDto, person, "id");
            person.setHobbies(personDto.getHobbies().toArray(new String[0]));
            personDao.save(person);
        }
        return personDto;
    }

    @Override
    public Person save(PersonDto person) {
	    Person newPerson = new Person();
	    newPerson.setFirstName(person.getFirstName());
	    newPerson.setLastName(person.getLastName());
	    newPerson.setHobbies(person.getHobbies().toArray(new String[0]));
	    newPerson.setAge(person.getAge());
	    newPerson.setFavColour(person.getFavColour());
        return personDao.save(newPerson);
    }
}
