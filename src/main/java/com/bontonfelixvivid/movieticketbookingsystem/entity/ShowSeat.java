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
@Table(name = "show_seat")
public class ShowSeat {

	public ShowSeat(String seatNumber, SeatType seatType, Integer seatPrice, Boolean isAvailable,
			Boolean isFoodContains, Show show) {
		super();
		this.seatNumber = seatNumber;
		this.seatType = seatType;
		this.seatPrice = seatPrice;
		this.isAvailable = isAvailable;
		this.isFoodContains = isFoodContains;
		this.show = show;
	}

	public Integer getShowSeatId() {
		return showSeatId;
	}

	public void setShowSeatId(Integer showSeatId) {
		this.showSeatId = showSeatId;
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

	public Integer getSeatPrice() {
		return seatPrice;
	}

	public void setSeatPrice(Integer seatPrice) {
		this.seatPrice = seatPrice;
	}

	public Boolean getIsAvailable() {
		return isAvailable;
	}

	public void setIsAvailable(Boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public Boolean getIsFoodContains() {
		return isFoodContains;
	}

	public void setIsFoodContains(Boolean isFoodContains) {
		this.isFoodContains = isFoodContains;
	}

	public Show getShow() {
		return show;
	}

	public void setShow(Show show) {
		this.show = show;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "show_seat_id")
	private Integer showSeatId;
	
	@Column(name = "seat_number")
	private String seatNumber;
	
	@Column(name = "seat_type")
	@Enumerated( value = EnumType.STRING)
	private SeatType seatType;
	
	@Column(name = "seat_price")
	private Integer seatPrice;
	
	@Column(name = "is_available")
	private Boolean isAvailable;
	
	@Column(name = "is_food_contains")
	private Boolean isFoodContains;
	
	@ManyToOne
	@JoinColumn(name = "show_id")
	private Show show;
	
}
