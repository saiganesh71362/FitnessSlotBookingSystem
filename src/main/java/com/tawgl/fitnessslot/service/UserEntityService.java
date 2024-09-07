package com.tawgl.fitnessslot.service;

import java.util.List;

import com.tawgl.fitnessslot.entity.UserEntity;
import com.tawgl.fitnessslot.exception.IdNotFoundException;
import com.tawgl.fitnessslot.exception.NewRecordCreationException;

public interface UserEntityService {
	public UserEntity newUserCreate(UserEntity userEntity) throws NewRecordCreationException;

	public UserEntity getUserById(Long id) throws IdNotFoundException;

	public List<UserEntity> getAllUsers();

	public UserEntity updateUserById(Long id, UserEntity userEntity) throws IdNotFoundException;

	public boolean deleteUserById(Long id) throws IdNotFoundException;

}
