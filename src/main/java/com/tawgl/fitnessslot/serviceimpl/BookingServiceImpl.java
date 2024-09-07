package com.tawgl.fitnessslot.serviceimpl;

import java.util.Optional;

import com.tawgl.fitnessslot.dto.BookingRequestDTO;
import com.tawgl.fitnessslot.dto.BookingResponseDTO;
import com.tawgl.fitnessslot.entity.ClassesEntity;
import com.tawgl.fitnessslot.entity.UserBooking;
import com.tawgl.fitnessslot.repository.ClassesRepository;
import com.tawgl.fitnessslot.repository.UserBookingRepository;
import com.tawgl.fitnessslot.service.BookingService;

public class BookingServiceImpl implements BookingService {

	ClassesRepository classesRepository;

	UserBookingRepository userBookingRepository;

	public BookingServiceImpl(ClassesRepository classesRepository, UserBookingRepository userBookingRepository) {
		super();
		this.classesRepository = classesRepository;
		this.userBookingRepository = userBookingRepository;
	}

	@Override
	public BookingResponseDTO bookClass(BookingRequestDTO bookingRequest) {
		Optional<ClassesEntity> classEntityOpt = classesRepository.findById(bookingRequest.getClassId());
		if (classEntityOpt.isPresent()) {
			ClassesEntity classEntity = classEntityOpt.get();

			if (classEntity.getEnrolledCount() < classEntity.getCapacity()) {
				// Book a slot
				UserBooking booking = new UserBooking();
				booking.setWaitlisted(false);
				// Save booking
				classEntity.setEnrolledCount(classEntity.getEnrolledCount() + 1);
				userBookingRepository.save(booking);

				return new BookingResponseDTO("SUCCESS", "Class booked successfully.");
			} else {
				// Add to waitlist
				UserBooking waitlistBooking = new UserBooking();
				waitlistBooking.setWaitlisted(true);
				userBookingRepository.save(waitlistBooking);

				return new BookingResponseDTO("WAITLISTED", "Class is full. You've been added to the waitlist.");
			}
		}

		return new BookingResponseDTO("FAILED", "Class not found.");
	}

	@Override
	public BookingResponseDTO cancelBooking(Long bookingId) {
		// TODO Auto-generated method stub
		return new BookingResponseDTO("SUCCESS", "Booking cancelled and waitlist adjusted.");
	}

}
