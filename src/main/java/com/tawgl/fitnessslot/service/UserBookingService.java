package com.tawgl.fitnessslot.service;

import java.util.List;

import com.tawgl.fitnessslot.entity.UserBooking;
import com.tawgl.fitnessslot.exception.IdNotFoundException;
import com.tawgl.fitnessslot.exception.NewRecordCreationException;

public interface UserBookingService {

	public UserBooking newUserBookingCreate(UserBooking userBooking) throws NewRecordCreationException;

	public UserBooking getUserBookingById(Long id) throws IdNotFoundException;

	public List<UserBooking> getAllUsersBooking();

	public UserBooking updateUserBookingById(Long id, UserBooking userBooking) throws IdNotFoundException;

	public boolean deleteUserBookingById(Long id) throws IdNotFoundException;
}
