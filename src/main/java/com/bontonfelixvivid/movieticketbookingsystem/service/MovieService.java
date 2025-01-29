package com.bontonfelixvivid.movieticketbookingsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bontonfelixvivid.movieticketbookingsystem.convertor.MovieConvertor;
import com.bontonfelixvivid.movieticketbookingsystem.entity.Movie;
import com.bontonfelixvivid.movieticketbookingsystem.exceptions.MovieAlreadyExistException;
import com.bontonfelixvivid.movieticketbookingsystem.repository.MovieRepository;
import com.bontonfelixvivid.movieticketbookingsystem.requestdto.MovieRequestDTO;

@Service
public class MovieService {
	
	@Autowired
	private MovieRepository movieReposiotry;
	
	public String addMovie(MovieRequestDTO movieRequestDTO) {
		System.out.println(movieRequestDTO);
		Movie movieObject = movieReposiotry.findMovieByMovieName(movieRequestDTO.getMovieName());
		if(movieObject != null && movieObject.getMovieLanguage().equals(movieRequestDTO.getMovieLanguage())) {
			throw new MovieAlreadyExistException();
		}
		Movie movieRequestDTOConvertedObject = MovieConvertor.movieDTOToMovieObject(movieRequestDTO);
		movieReposiotry.save(movieRequestDTOConvertedObject);
		return "Movie Added Successfully";
	}

}
