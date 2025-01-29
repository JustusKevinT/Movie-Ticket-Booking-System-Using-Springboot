package com.bontonfelixvivid.movieticketbookingsystem.entity;

import com.bontonfelixvivid.movieticketbookingsystem.enums.SeatType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "theater_seat")
public class TheaterSeat {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "theater_seat_id")
	private Integer theaterSeatId;
	
	@Column(name = "seat_number")
	private String seatNumber;
	
	@Enumerated(value = EnumType.STRING)
	@Column(name = "seat_type")
	private SeatType seatType;
	
	@ManyToOne
	@JoinColumn(name = "theater_id")
	private Theater theater;

	public TheaterSeat(String seatNumber, SeatType seatType, Theater theater) {
		super();
		this.seatNumber = seatNumber;
		this.seatType = seatType;
		this.theater = theater;
	}

	public Integer getTheaterSeatId() {
		return theaterSeatId;
	}

	public void setTheaterSeatId(Integer theaterSeatId) {
		this.theaterSeatId = theaterSeatId;
	}

	public String getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(String seatNumber) {
		this.seatNumber = seatNumber;
	}

	public SeatType getSeatType() {
		return seatType;
	}

	public void setSeatType(SeatType seatType) {
		this.seatType = seatType;
	}

	public Theater getTheater() {
		return theater;
	}

	public void setTheater(Theater theater) {
		this.theater = theater;
	}
}
