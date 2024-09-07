package com.tawgl.fitnessslot.entity;

import java.io.Serializable;
import java.util.List;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class UserEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String name;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
//	@JsonManagedReference
	private List<UserBooking> bookings;

	public UserEntity() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<UserBooking> getBookings() {
		return bookings;
	}

	public void setBookings(List<UserBooking> bookings) {
		this.bookings = bookings;
	}

}
