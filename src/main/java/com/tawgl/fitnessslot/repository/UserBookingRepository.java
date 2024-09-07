package com.tawgl.fitnessslot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tawgl.fitnessslot.entity.UserBooking;

public interface UserBookingRepository extends JpaRepository<UserBooking, Long> {

}
