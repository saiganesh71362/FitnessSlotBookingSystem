package com.tawgl.fitnessslot.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.tawgl.fitnessslot.entity.UserBooking;
import com.tawgl.fitnessslot.exception.IdNotFoundException;
import com.tawgl.fitnessslot.exception.NewRecordCreationException;
import com.tawgl.fitnessslot.repository.UserBookingRepository;
import com.tawgl.fitnessslot.service.UserBookingService;

@Service
public class UserBookingServiceImpl implements UserBookingService {

	UserBookingRepository userBookingRepository;

	public UserBookingServiceImpl(UserBookingRepository userBookingRepository) {
		super();
		this.userBookingRepository = userBookingRepository;
	}

	@Override
	public UserBooking newUserBookingCreate(UserBooking userBooking) throws NewRecordCreationException {
		if (userBooking != null) {
			userBookingRepository.save(userBooking);

		}
		throw new NewRecordCreationException("The User provided is null and cannot be created.");
	}

	@Override
	public UserBooking getUserBookingById(Long id) throws IdNotFoundException {
		Optional<UserBooking> findById = userBookingRepository.findById(id);
		if (findById.isPresent()) {
			return findById.get();
		}
		throw new IdNotFoundException("Id Not Found :" + id);
	}

	@Override
	public List<UserBooking> getAllUsersBooking() {
		return userBookingRepository.findAll();
	}

	@Override
	public UserBooking updateUserBookingById(Long id, UserBooking userBooking) throws IdNotFoundException {
		if (userBookingRepository.existsById(id)) {
			UserBooking existingUserBooking = userBookingRepository.findById(id)
					.orElseThrow(() -> new IdNotFoundException("Id Not Found :" + id));

			existingUserBooking.setUser(userBooking.getUser());
			existingUserBooking.setBookedClass(userBooking.getBookedClass());
			existingUserBooking.setWaitlisted(userBooking.getWaitlisted());
			return userBookingRepository.save(existingUserBooking);
		} else {
			throw new IdNotFoundException("Id Not Found :" + id);
		}
	}

	@Override
	public boolean deleteUserBookingById(Long id) throws IdNotFoundException {
		Optional<UserBooking> findById = userBookingRepository.findById(id);

		if (findById.isPresent()) {
			userBookingRepository.deleteById(id);
			return true;
		}
		throw new IdNotFoundException("Id Not Found :" + id);
	}

}
