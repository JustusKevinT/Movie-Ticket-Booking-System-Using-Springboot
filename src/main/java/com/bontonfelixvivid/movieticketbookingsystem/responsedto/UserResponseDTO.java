package com.bontonfelixvivid.movieticketbookingsystem.responsedto;

import com.bontonfelixvivid.movieticketbookingsystem.enums.Gender;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDTO {

	private String userName;
	private Integer userAge;
	private Gender userGender;
	private String userAddress;

}
