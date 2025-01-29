package com.bontonfelixvivid.movieticketbookingsystem.entity;

import java.sql.Time;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "`show`")
public class Show {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "show_id")
	private Integer showId;
	
	@Column(name = "show_time")
	private Time showTime;
	
	@Column(name = "show_date")
	private Date showDate;
	
	@ManyToOne
	@JoinColumn(name = "movie_id")
	private Movie movie;
	
	@ManyToOne
	@JoinColumn(name = "theater_id")
	private Theater theater;
	
	@OneToMany(mappedBy = "show", cascade = CascadeType.ALL)
	@Builder.Default
	private List<ShowSeat> showSeatList = new ArrayList<>();
	
	@OneToMany(mappedBy = "show", cascade = CascadeType.ALL)
	@Builder.Default
	private List<Ticket> ticketList = new ArrayList<>();

	public Integer getShowId() {
		return showId;
	}

	public void setShowId(Integer showId) {
		this.showId = showId;
	}

	public Time getShowTime() {
		return showTime;
	}

	public void setShowTime(Time showTime) {
		this.showTime = showTime;
	}

	public Date getShowDate() {
		return showDate;
	}

	public void setShowDate(Date showDate) {
		this.showDate = showDate;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public Theater getTheater() {
		return theater;
	}

	public void setTheater(Theater theater) {
		this.theater = theater;
	}

	public List<ShowSeat> getShowSeatList() {
		return showSeatList;
	}

	public void setShowSeatList(List<ShowSeat> showSeatList) {
		this.showSeatList = showSeatList;
	}

	public List<Ticket> getTicketList() {
		return ticketList;
	}

	public void setTicketList(List<Ticket> ticketList) {
		this.ticketList = ticketList;
	}

	public Show(Time showTime, Date showDate, Movie movie, Theater theater, List<ShowSeat> showSeatList,
			List<Ticket> ticketList) {
		super();
		this.showTime = showTime;
		this.showDate = showDate;
		this.movie = movie;
		this.theater = theater;
		this.showSeatList = showSeatList;
		this.ticketList = ticketList;
	}

}
