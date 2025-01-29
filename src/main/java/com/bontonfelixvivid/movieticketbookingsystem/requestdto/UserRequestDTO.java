package com.bontonfelixvivid.movieticketbookingsystem.requestdto;

import com.bontonfelixvivid.movieticketbookingsystem.enums.Gender;

import lombok.Data;

@Data
public class UserRequestDTO {

	private String userName;
	private Integer userAge;
	private String userAddress;
	private String userMobileNumber;
	private String userEmailId;
	private Gender userGender;
	private String userRoles;
	private String userPassword;
	public String getUserEmailId() {
		// TODO Auto-generated method stub
		return userEmailId;
	}
	
}
