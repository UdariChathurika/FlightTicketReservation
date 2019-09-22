package com.example.FlightTicketReservation.repository;

import com.example.FlightTicketReservation.model.Flight;
import com.example.FlightTicketReservation.model.UnderAgeChildren;
import org.springframework.data.repository.CrudRepository;

public interface UnderAgrChildrenRepository extends CrudRepository<UnderAgeChildren, Long> {
}
