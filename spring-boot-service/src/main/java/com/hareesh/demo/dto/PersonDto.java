package com.hareesh.demo.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PersonDto {

	private int id;
	//@JsonProperty("first_name")
    private String firstName;
	//@JsonProperty("last_name")
    private String lastName;
	//@JsonProperty("favourite_colour")
    private String favColour;
	//@JsonProperty("hobby")
    private List<String> hobbies;
    private int age;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFavColour() {
		return favColour;
	}
	public void setFavColour(String favColour) {
		this.favColour = favColour;
	}
	public List<String> getHobbies() {
		return hobbies;
	}
	public void setHobbies(List<String> hobbies) {
		this.hobbies = hobbies;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
   
}
