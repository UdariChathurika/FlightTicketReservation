package com.example.FlightTicketReservation.repository;

import com.example.FlightTicketReservation.model.Passenger;
import org.springframework.data.repository.CrudRepository;

public interface PassengerRepository extends CrudRepository<Passenger, Long> {
}
