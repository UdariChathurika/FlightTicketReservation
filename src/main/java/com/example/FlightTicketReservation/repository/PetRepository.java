package com.example.FlightTicketReservation.repository;

import com.example.FlightTicketReservation.model.Meal;
import com.example.FlightTicketReservation.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
