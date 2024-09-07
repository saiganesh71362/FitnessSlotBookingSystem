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

import com.tawgl.fitnessslot.entity.UserBooking;
import com.tawgl.fitnessslot.serviceimpl.UserBookingServiceImpl;

@RestController
public class UserBookingController {
	UserBookingServiceImpl userBookingServiceImpl;

	public UserBookingController(UserBookingServiceImpl userBookingServiceImpl) {
		super();
		this.userBookingServiceImpl = userBookingServiceImpl;
	}

	@PostMapping("/newUserBooking")
	public ResponseEntity<UserBooking> newUserBookingCreate(@RequestBody UserBooking userBooking) throws Exception {
		UserBooking newUserBookingCreate = userBookingServiceImpl.newUserBookingCreate(userBooking);
		return new ResponseEntity<UserBooking>(newUserBookingCreate, HttpStatus.CREATED);
	}

	@GetMapping("/userBooking/{id}")
	public ResponseEntity<UserBooking> getUserBookingById(@PathVariable Long id) throws Exception {

		UserBooking userBookingById = userBookingServiceImpl.getUserBookingById(id);
		return new ResponseEntity<UserBooking>(userBookingById, HttpStatus.FOUND);
	}

	@GetMapping("/allBookingUsers")
	public ResponseEntity<List<UserBooking>> getAllUsersBooking()

	{
		List<UserBooking> allUsersBooking = userBookingServiceImpl.getAllUsersBooking();
		return new ResponseEntity<>(allUsersBooking, HttpStatus.FOUND);

	}

	@PutMapping("/updateBookingUser/{id}")
	public ResponseEntity<UserBooking> updateUserBookingById(@PathVariable Long id,
			@RequestBody UserBooking userBooking) throws Exception {
		UserBooking updateUserBookingById = userBookingServiceImpl.updateUserBookingById(id, userBooking);
		return new ResponseEntity<>(updateUserBookingById, HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/deleteBookingUser/{id}")
	public ResponseEntity<Boolean> deleteUserBookingById(@PathVariable Long id) throws Exception {
		boolean deleteUserBookingById = userBookingServiceImpl.deleteUserBookingById(id);
		return new ResponseEntity<>(deleteUserBookingById, HttpStatus.OK);

	}
}
