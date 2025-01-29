package com.bontonfelixvivid.movieticketbookingsystem.convertor;

import com.bontonfelixvivid.movieticketbookingsystem.entity.User;
import com.bontonfelixvivid.movieticketbookingsystem.requestdto.UserRequestDTO;

public class UserConvetor {

	public static User userDTOToUserObject(UserRequestDTO userRequestDTO) {
		User userObject = User.builder().userName(userRequestDTO.getUserName()).userAge(userRequestDTO.getUserAge())
				.userAddress(userRequestDTO.getUserAddress()).userGender(userRequestDTO.getUserGender())
				.userMobileNumber(userRequestDTO.getUserMobileNumber()).userEmailId(userRequestDTO.getUserEmailId())
				.userRoles(userRequestDTO.getUserRoles()).userPassword(userRequestDTO.getUserPassword()).build();
		return userObject;
	}

}
