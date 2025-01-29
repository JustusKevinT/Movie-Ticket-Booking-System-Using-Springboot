package com.bontonfelixvivid.movieticketbookingsystem.entity;

import java.sql.Date;

import org.hibernate.annotations.CreationTimestamp;

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
@Table(name = "ticket")
public class Ticket {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ticket_id")
	private Integer ticketId;
	
	@Column(name = "total_tickets_price")
	private Integer totalTicketsPrice;

	@Column(name = "booked_seats")
	private String bookedSeats;
	
	@Column(name = "booked_at_date")
	@CreationTimestamp
	private Date bookedAtDate;
	
	@Column(name = "seat_type")
	@Enumerated( value = EnumType.STRING)
	private SeatType seatType;
	
	@ManyToOne
	@JoinColumn(name = "show_id")
	private Show show;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	public Ticket(Integer totalTicketsPrice, String bookedSeats, Date bookedAtDate, Show show, User user, SeatType seatType) {
		super();
		this.totalTicketsPrice = totalTicketsPrice;
		this.bookedSeats = bookedSeats;
		this.bookedAtDate = bookedAtDate;
		this.seatType = seatType;
		this.show = show;
		this.user = user;
	}

	public Integer getTicketId() {
		return ticketId;
	}

	public void setTicketId(Integer ticketId) {
		this.ticketId = ticketId;
	}

	public Integer getTotalTicketsPrice() {
		return totalTicketsPrice;
	}

	public void setTotalTicketsPrice(Integer totalTicketsPrice) {
		this.totalTicketsPrice = totalTicketsPrice;
	}

	public String getBookedSeats() {
		return bookedSeats;
	}

	public void setBookedSeats(String bookedSeats) {
		this.bookedSeats = bookedSeats;
	}

	public Date getBookedAtDate() {
		return bookedAtDate;
	}

	public void setBookedAtDate(Date bookedAtDate) {
		this.bookedAtDate = bookedAtDate;
	}

	public Show getShow() {
		return show;
	}

	public void setShow(Show show) {
		this.show = show;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
