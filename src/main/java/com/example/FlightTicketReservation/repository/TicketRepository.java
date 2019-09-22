package com.example.FlightTicketReservation.repository;

import com.example.FlightTicketReservation.model.Ticket;
import org.springframework.data.repository.CrudRepository;

public interface TicketRepository extends CrudRepository<Ticket, Long> {
}
