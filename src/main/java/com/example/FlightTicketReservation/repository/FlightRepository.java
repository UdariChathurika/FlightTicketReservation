package com.example.FlightTicketReservation.repository;

import com.example.FlightTicketReservation.model.Flight;
import org.springframework.data.repository.CrudRepository;

public interface FlightRepository extends CrudRepository<Flight, Long> {
}
