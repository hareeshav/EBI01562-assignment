package com.hareesh.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hareesh.demo.dto.ApiResponse;
import com.hareesh.demo.dto.PersonDto;
import com.hareesh.demo.model.Person;
import com.hareesh.demo.service.PersonService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/persons")
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping
    public ApiResponse<Person> savePerson(@RequestBody PersonDto person){
        return new ApiResponse<>(HttpStatus.OK.value(), "Person saved successfully.",personService.save(person));
    }

    @GetMapping
    public ApiResponse<List<Person>> listPerson(){
        return new ApiResponse<>(HttpStatus.OK.value(), "Person list fetched successfully.",personService.findAll());
    }

    @GetMapping("/{id}")
    public ApiResponse<Person> getOne(@PathVariable int id){
        return new ApiResponse<>(HttpStatus.OK.value(), "Person fetched successfully.",personService.findById(id));
    }

    @PutMapping("/{id}")
    public ApiResponse<PersonDto> update(@PathVariable int id, @RequestBody PersonDto personDto) {
    	personDto.setId(id);
        return new ApiResponse<>(HttpStatus.OK.value(), "Person updated successfully.",personService.update(personDto));
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Void> delete(@PathVariable int id) {
    	personService.delete(id);
        return new ApiResponse<>(HttpStatus.OK.value(), "Person: "+id+ " deleted successfully.", null);
    }



}
