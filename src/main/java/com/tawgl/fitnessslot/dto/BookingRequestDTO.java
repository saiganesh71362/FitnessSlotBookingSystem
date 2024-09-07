package com.tawgl.fitnessslot.dto;

public class BookingRequestDTO {
	private Long userId;
    private Long classId;
    
    BookingRequestDTO(){
    	
    }

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getClassId() {
		return classId;
	}

	public void setClassId(Long classId) {
		this.classId = classId;
	}

}
