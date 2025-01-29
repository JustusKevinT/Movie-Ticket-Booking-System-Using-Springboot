package com.bontonfelixvivid.movieticketbookingsystem.entity;

import java.util.ArrayList;
import java.util.List;

import com.bontonfelixvivid.movieticketbookingsystem.enums.Gender;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Integer userId;
	
	@Column(name = "user_name", nullable = false)
	private String userName;
	
	@Column(name = "user_age")
	private Integer userAge;
	
	@Column(name = "user_address")
	private String userAddress;
	
	@Enumerated(value = EnumType.STRING)
	@Column(name = "user_gender")
	private Gender userGender;
	
	@Column(name = "user_mobile_number")
	private String userMobileNumber;
	
	@Column(unique = true, name = "user_email_id")
	private String userEmailId;
	
	@Column(name = "user_password")
	private String userPassword;
	
	@Column(name = "user_roles")
	private String userRoles;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	@Builder.Default
	private List<Ticket> ticketList = new ArrayList<>();

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getUserAge() {
		return userAge;
	}

	public void setUserAge(Integer userAge) {
		this.userAge = userAge;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public String getUserMobileNumber() {
		return userMobileNumber;
	}

	public void setUserMobileNumber(String userMobileNumber) {
		this.userMobileNumber = userMobileNumber;
	}

	public List<Ticket> getTicketList() {
		return ticketList;
	}

	public void setTicketList(List<Ticket> ticketList) {
		this.ticketList = ticketList;
	}

	public User(String userName, Integer userAge, String userAddress, Gender userGender, String userMobileNumber,
			String userEmailId, String userPassword, String userRoles, List<Ticket> ticketList) {
		super();
		this.userName = userName;
		this.userAge = userAge;
		this.userAddress = userAddress;
		this.userGender = userGender;
		this.userMobileNumber = userMobileNumber;
		this.userEmailId = userEmailId;
		this.userPassword = userPassword;
		this.userRoles = userRoles;
		this.ticketList = ticketList;
	}

}
