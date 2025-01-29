package com.bontonfelixvivid.movieticketbookingsystem.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.bontonfelixvivid.movieticketbookingsystem.enums.Genre;
import com.bontonfelixvivid.movieticketbookingsystem.enums.Language;

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
@Table(name = "movie")
public class Movie {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "movie_id")
	private Integer movieId;

	@Column(name = "movie_name", nullable = false)
	private String movieName;
	
	@Column(name = "movie_duration")
	private Integer movieDuration;
	
	@Column(scale = 2, name = "movie_rating")
	private Double movieRating;
	
	@Column(name = "movie_release_date")
	private Date movieReleaseDate;
	
	@Enumerated(value = EnumType.STRING)
	@Column(name = "movie_genre")
	private Genre movieGenre;
	
	@Enumerated(value = EnumType.STRING)
	@Column(name = "movie_language")
	private Language movieLanguage;
	
	@OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
	@Builder.Default
	private List<Show> shows = new ArrayList<>();
	
	public Date getMovieReleaseDate() {
		return movieReleaseDate;
	}
	
	public void setMovieReleaseDate(Date movieReleaseDate) {
		this.movieReleaseDate = movieReleaseDate;
	}

	public Integer getMovieId() {
		return movieId;
	}

	public void setMovieId(Integer movieId) {
		this.movieId = movieId;
	}

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

	public List<Show> getShows() {
		return shows;
	}

	public void setShows(List<Show> shows) {
		this.shows = shows;
	}

	public Movie(String movieName, Integer movieDuration, Double movieRating, Date movieReleaseDate, Genre movieGenre,
			Language movieLanguage, List<Show> shows) {
		super();
		this.movieName = movieName;
		this.movieDuration = movieDuration;
		this.movieRating = movieRating;
		this.movieReleaseDate = movieReleaseDate;
		this.movieGenre = movieGenre;
		this.movieLanguage = movieLanguage;
		this.shows = shows;
	}
	
}
