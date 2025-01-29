package com.bontonfelixvivid.movieticketbookingsystem.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Table(name = "theater")
public class Theater {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "theater_id")
	private Integer theaterId;
	
	@Column(name = "theater_address", unique = true)
	private String theaterAddress;
	
	@Column(name = "theater_name")
	private String theaterName;
	
	@OneToMany(mappedBy = "theater", cascade = CascadeType.ALL)
	@Builder.Default
	private List<TheaterSeat> theaterSeatList = new ArrayList<>();
	
	@OneToMany(mappedBy = "theater", cascade = CascadeType.ALL)
	@Builder.Default
	private List<Show> showList = new ArrayList<>();

	public Integer getTheaterId() {
		return theaterId;
	}

	public void setTheaterId(Integer theaterId) {
		this.theaterId = theaterId;
	}

	public String getTheaterAddress() {
		return theaterAddress;
	}

	public void setTheaterAddress(String theaterAddress) {
		this.theaterAddress = theaterAddress;
	}

	public String getTheaterName() {
		return theaterName;
	}

	public void setTheaterName(String theaterName) {
		this.theaterName = theaterName;
	}

	public List<TheaterSeat> getTheaterSeatList() {
		return theaterSeatList;
	}

	public void setTheaterSeatList(List<TheaterSeat> theaterSeatList) {
		this.theaterSeatList = theaterSeatList;
	}

	public List<Show> getShowList() {
		return showList;
	}

	public void setShowList(List<Show> showList) {
		this.showList = showList;
	}
	
	public Theater(String theaterAddress, String theaterName, List<TheaterSeat> theaterSeatList, List<Show> showList) {
		super();
		this.theaterAddress = theaterAddress;
		this.theaterName = theaterName;
		this.theaterSeatList = theaterSeatList;
		this.showList = showList;
	}

}
