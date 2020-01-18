package com.hareesh.demo.service;

import java.util.List;

import com.hareesh.demo.dto.UserDto;
import com.hareesh.demo.model.User;

public interface UserService {

	User save(UserDto user);

	List<User> findAll();

	void delete(int id);

	User findOne(String username);

	User findById(int id);

	UserDto update(UserDto userDto);
}
