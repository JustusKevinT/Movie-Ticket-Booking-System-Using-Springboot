package com.bontonfelixvivid.movieticketbookingsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bontonfelixvivid.movieticketbookingsystem.entity.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Integer>{

}
