package com.bontonfelixvivid.movieticketbookingsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bontonfelixvivid.movieticketbookingsystem.convertor.UserConvetor;
import com.bontonfelixvivid.movieticketbookingsystem.entity.User;
import com.bontonfelixvivid.movieticketbookingsystem.exceptions.UserAlreadyExistException;
import com.bontonfelixvivid.movieticketbookingsystem.repository.UserRepository;
import com.bontonfelixvivid.movieticketbookingsystem.requestdto.UserRequestDTO;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;

	public String addUser(UserRequestDTO userRequestDTO) {
		// TODO Auto-generated method stub
		if(userRepository.findByUserEmailId(userRequestDTO.getUserEmailId()).isPresent()) {
			throw new UserAlreadyExistException();
		}
		
		User userObject = UserConvetor.userDTOToUserObject(userRequestDTO);
		
		userRepository.save(userObject);
		
		return "User Saved Successfully";
	}

}
