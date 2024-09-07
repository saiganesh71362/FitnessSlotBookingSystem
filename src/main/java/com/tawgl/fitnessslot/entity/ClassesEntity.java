package com.tawgl.fitnessslot.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class ClassesEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String classType; // yoga, gym, dance
	private int capacity;
	private int enrolledCount;
	private LocalDate startTime;
	@OneToMany(mappedBy = "bookedClass", cascade = CascadeType.ALL)
//	@JsonManagedReference
	private List<UserBooking> bookings;

	public ClassesEntity() {
	}

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getClassType() {
		return classType;
	}

	public void setClassType(String classType) {
		this.classType = classType;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public int getEnrolledCount() {
		return enrolledCount;
	}

	public void setEnrolledCount(int enrolledCount) {
		this.enrolledCount = enrolledCount;
	}

	public LocalDate getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalDate startTime) {
		this.startTime = startTime;
	}

	public List<UserBooking> getBookings() {
		return bookings;
	}

	public void setBookings(List<UserBooking> bookings) {
		this.bookings = bookings;
	}

	@Override
	public String toString() {
		return "ClassesEntity [id=" + id + ", classType=" + classType + ", capacity=" + capacity + ", enrolledCount="
				+ enrolledCount + ", startTime=" + startTime + ", bookings=" + bookings + "]";
	}
	
	

}
