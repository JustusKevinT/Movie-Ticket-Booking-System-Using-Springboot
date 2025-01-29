package com.bontonfelixvivid.movieticketbookingsystem.repository;

import java.sql.Date;
import java.sql.Time;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bontonfelixvivid.movieticketbookingsystem.entity.Movie;
import com.bontonfelixvivid.movieticketbookingsystem.entity.Show;
import com.bontonfelixvivid.movieticketbookingsystem.entity.Theater;

public interface ShowRepository extends JpaRepository<Show, Integer>{
	
	@Query(value = "select movie_id from `show` group by movie_id order by count(*) desc limit 1" , nativeQuery = true)
    public Integer getMostShowsMovie();
	
	@Query(value = "select * from `show` where movie_id = :movieId" , nativeQuery = true)
    public List<Show> getAllShowsOfMovie(@Param("movieId")Integer movieId);
	
	@Query(value = "select show_time from `show` where show_date = :showDate and movie_id = :movieId and theater_id = :theaterId" , nativeQuery = true)
    public List<Time> getShowTimingsOnDate(@Param("showDate")Date showDate, @Param("theaterId")Integer theaterId, @Param("movieId")Integer movieId);
	
	public Optional<Show> findByShowTimeAndShowDateAndMovieAndTheater(Time showTime, Date showDate, Movie movie, Theater theater);

}
