package com.bontonfelixvivid.movieticketbookingsystem.requestdto;

import java.util.Date;

import com.bontonfelixvivid.movieticketbookingsystem.enums.Genre;
import com.bontonfelixvivid.movieticketbookingsystem.enums.Language;

import lombok.Data;

@Data
public class MovieRequestDTO {

	private String movieName;
	private Integer movieDuration;
	private Double movieRating;
	private Date movieReleaseDate;
	private Genre movieGenre;
	private Language movieLanguage;
	
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public Integer getMovieDuration() {
		return movieDuration;
	}
	public void setMovieDuration(Integer movieDuration) {
		this.movieDuration = movieDuration;
	}
	public Double getMovieRating() {
		return movieRating;
	}
	public void setMovieRating(Double movieRating) {
		this.movieRating = movieRating;
	}
	public Date getMovieReleaseDate() {
		return movieReleaseDate;
	}
	public void setMovieReleaseDate(Date movieReleaseDate) {
		this.movieReleaseDate = movieReleaseDate;
	}
	public Genre getMovieGenre() {
		return movieGenre;
	}
	public void setMovieGenre(Genre movieGenre) {
		this.movieGenre = movieGenre;
	}
	public Language getMovieLanguage() {
		return movieLanguage;
	}
	public void setMovieLanguage(Language movieLanguage) {
		this.movieLanguage = movieLanguage;
	}
	
}
