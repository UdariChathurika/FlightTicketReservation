package com.example.FlightTicketReservation.repository;

import com.example.FlightTicketReservation.model.Flight;
import com.example.FlightTicketReservation.model.Meal;
import org.springframework.data.repository.CrudRepository;

public interface MealRepository extends CrudRepository<Meal, Long> {
}
