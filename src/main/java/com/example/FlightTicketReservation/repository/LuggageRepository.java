package com.example.FlightTicketReservation.repository;

import com.example.FlightTicketReservation.model.Flight;
import com.example.FlightTicketReservation.model.Luggage;
import org.springframework.data.repository.CrudRepository;

public interface LuggageRepository extends CrudRepository<Luggage, Long> {
}
