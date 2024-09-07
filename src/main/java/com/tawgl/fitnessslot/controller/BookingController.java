package com.tawgl.fitnessslot.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tawgl.fitnessslot.dto.BookingRequestDTO;
import com.tawgl.fitnessslot.dto.BookingResponseDTO;
import com.tawgl.fitnessslot.serviceimpl.BookingServiceImpl;

@RestController
@RequestMapping("/bookings")
public class BookingController {

	BookingServiceImpl bookingServiceImpl;

	public BookingController() {
	}

	public BookingController(BookingServiceImpl bookingServiceImpl) {
		this.bookingServiceImpl = bookingServiceImpl;
	}

	@PostMapping("/book")
	public ResponseEntity<BookingResponseDTO> bookClass(@RequestBody BookingRequestDTO bookingRequestDTO) {
		BookingResponseDTO bookClass = bookingServiceImpl.bookClass(bookingRequestDTO);
		return new ResponseEntity<>(bookClass, HttpStatus.CREATED);
	}

	@DeleteMapping("/cancel/{bookingId}")
	public BookingResponseDTO cancelBooking(@PathVariable Long bookingId) {
		return bookingServiceImpl.cancelBooking(bookingId);
	}

}
