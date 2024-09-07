package com.tawgl.fitnessslot.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tawgl.fitnessslot.entity.UserEntity;
import com.tawgl.fitnessslot.serviceimpl.UserEntityServiceImpl;

@RestController
public class UserEntityController {

	UserEntityServiceImpl userEntityServiceImpl;

	public UserEntityController(UserEntityServiceImpl userEntityServiceImpl) {
		super();
		this.userEntityServiceImpl = userEntityServiceImpl;

	}

	@PostMapping("/newUser")
	public ResponseEntity<UserEntity> newUserCreate(@RequestBody UserEntity userEntity) throws Exception {
		UserEntity newUserCreate = userEntityServiceImpl.newUserCreate(userEntity);
		return new ResponseEntity<>(newUserCreate, HttpStatus.CREATED);
	}

	@GetMapping("/user/{id}")
	public ResponseEntity<UserEntity> getUserById(@PathVariable Long id) throws Exception {
		UserEntity userById = userEntityServiceImpl.getUserById(id);
		return new ResponseEntity<>(userById, HttpStatus.FOUND);
	}

	@GetMapping("/allUsers")
	public ResponseEntity<List<UserEntity>> getAllUsers() {
		List<UserEntity> allUsers = userEntityServiceImpl.getAllUsers();
		return new ResponseEntity<>(allUsers, HttpStatus.FOUND);
	}

	@PutMapping("/updateUser/{id}")
	public ResponseEntity<UserEntity> updateUserById(@PathVariable Long id, @RequestBody UserEntity userEntity)
			throws Exception {
		UserEntity updateUserById = userEntityServiceImpl.updateUserById(id, userEntity);
		return new ResponseEntity<>(updateUserById, HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/deleteUser/{id}")
	public ResponseEntity<Boolean> deleteUserById(@PathVariable Long id) throws Exception {
		boolean deleteUserById = userEntityServiceImpl.deleteUserById(id);
		return new ResponseEntity<Boolean>(deleteUserById, HttpStatus.OK);
	}

}
