package com.tawgl.fitnessslot.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.tawgl.fitnessslot.entity.UserEntity;
import com.tawgl.fitnessslot.exception.IdNotFoundException;
import com.tawgl.fitnessslot.exception.NewRecordCreationException;
import com.tawgl.fitnessslot.repository.UserEntityRepository;
import com.tawgl.fitnessslot.service.UserEntityService;

@Service
public class UserEntityServiceImpl implements UserEntityService {

	UserEntityRepository userEntityRepository;

	public UserEntityServiceImpl(UserEntityRepository userEntityRepository) {
		super();
		this.userEntityRepository = userEntityRepository;
	}

	@Override
	public UserEntity newUserCreate(UserEntity userEntity) throws NewRecordCreationException {
		if (userEntity != null) {
			userEntityRepository.save(userEntity);
		}
		throw new NewRecordCreationException("The User provided is null and cannot be created.");
	}

	@Override
	public UserEntity getUserById(Long id) throws IdNotFoundException {
		Optional<UserEntity> findById = userEntityRepository.findById(id);
		if (findById.isPresent()) {
			return findById.get();
		}
		throw new IdNotFoundException("Id Not Found");
	}

	@Override
	public List<UserEntity> getAllUsers() {

		return userEntityRepository.findAll();
	}

	@Override
	public UserEntity updateUserById(Long id, UserEntity userEntity) throws IdNotFoundException {
		if (userEntityRepository.existsById(id)) {
			UserEntity existingUser = userEntityRepository.findById(id)
					.orElseThrow(() -> new IdNotFoundException("Id Not Found :" + id));
			existingUser.setName(userEntity.getName());
			existingUser.setBookings(userEntity.getBookings());
			return userEntityRepository.save(existingUser);
		} else {
			throw new IdNotFoundException("Id Not Found :" + id);
		}
	}

	@Override
	public boolean deleteUserById(Long id) throws IdNotFoundException {
		Optional<UserEntity> findById = userEntityRepository.findById(id);
		if (findById.isPresent()) {
			userEntityRepository.deleteById(id);
			return true;
		}
		throw new IdNotFoundException("Id Not Found :" + id);
	}

}
