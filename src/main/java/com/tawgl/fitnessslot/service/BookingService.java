package com.tawgl.fitnessslot.service;

import com.tawgl.fitnessslot.dto.BookingRequestDTO;
import com.tawgl.fitnessslot.dto.BookingResponseDTO;

public interface BookingService 
{
	BookingResponseDTO bookClass(BookingRequestDTO bookingRequest);

	BookingResponseDTO cancelBooking(Long bookingId);

}
