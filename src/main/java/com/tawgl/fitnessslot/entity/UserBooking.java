package com.tawgl.fitnessslot.entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class UserBooking implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "user_id")
//	@JsonManagedReference
	private UserEntity user;

	@ManyToOne
	@JoinColumn(name = "classes_id")
//	@JsonBackReference
	private ClassesEntity bookedClass;

	private boolean isWaitlisted;

	public UserBooking() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	public ClassesEntity getBookedClass() {
		return bookedClass;
	}

	public void setBookedClass(ClassesEntity bookedClass) {
		this.bookedClass = bookedClass;
	}

	public boolean getWaitlisted() {
		return isWaitlisted;
	}

	public void setWaitlisted(boolean isWaitlisted) {
		this.isWaitlisted = isWaitlisted;
	}

}
