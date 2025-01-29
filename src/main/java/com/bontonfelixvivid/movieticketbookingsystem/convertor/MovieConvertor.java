package com.bontonfelixvivid.movieticketbookingsystem.convertor;

import com.bontonfelixvivid.movieticketbookingsystem.entity.Movie;
import com.bontonfelixvivid.movieticketbookingsystem.requestdto.MovieRequestDTO;

public class MovieConvertor {

	public static Movie movieDTOToMovieObject(MovieRequestDTO movieRequestDTO) {
		Movie movieObject = Movie.builder().movieName(movieRequestDTO.getMovieName()).movieDuration(movieRequestDTO.getMovieDuration())
				.movieGenre(movieRequestDTO.getMovieGenre()).movieLanguage(movieRequestDTO.getMovieLanguage())
				.movieReleaseDate(movieRequestDTO.getMovieReleaseDate()).movieRating(movieRequestDTO.getMovieRating()).build();
		return movieObject;
	}

}
