package com.tawgl.fitnessslot.dto;

public class BookingResponseDTO {

	private String status;
	private String message;

	public BookingResponseDTO() {

	}

	public BookingResponseDTO(String status, String message) {
		super();
		this.status = status;
		this.message = message;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
