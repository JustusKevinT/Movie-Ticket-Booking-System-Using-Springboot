package com.bontonfelixvivid.movieticketbookingsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bontonfelixvivid.movieticketbookingsystem.requestdto.UserRequestDTO;
import com.bontonfelixvivid.movieticketbookingsystem.service.UserService;

import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/addNewUser")
	public ResponseEntity<String> addNewUser(@RequestBody UserRequestDTO userRequestDTO){
		try {
			String result = userService.addUser(userRequestDTO);
			return new ResponseEntity<>(result, HttpStatus.CREATED);
		}
		catch(Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
}
