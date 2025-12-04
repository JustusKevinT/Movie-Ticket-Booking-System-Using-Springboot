package com.bontonfelixvivid.movieticketbookingsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bontonfelixvivid.movieticketbookingsystem.entity.ShowSeat;

public interface ShowSeatRepository extends JpaRepository<ShowSeat, Integer> {

	@Query(value = "select case when count(*) > 0 then true else false end from `show_seat` where show_id = :showId", nativeQuery = true)
	public Long getIsShowSeatExist(@Param("showId") Integer showId);

}
