package com.example.FlightTicketReservation.Resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.example.FlightTicketReservation.model.Flight;
import com.example.FlightTicketReservation.model.Meal;
import com.example.FlightTicketReservation.model.Passenger;
import com.example.FlightTicketReservation.model.Ticket;
import com.example.FlightTicketReservation.repository.FlightRepository;
import com.example.FlightTicketReservation.repository.MealRepository;
import com.example.FlightTicketReservation.repository.PassengerRepository;

import java.util.ArrayList;
import java.util.List;

public class TicketResolver implements GraphQLResolver<Ticket> {
    private FlightRepository flightRepository;
    private PassengerRepository passengerRepository;
    private MealRepository mealRepository;

    public TicketResolver(FlightRepository flightRepository, PassengerRepository passengerRepository, MealRepository mealRepository) {
        this.flightRepository = flightRepository;
        this.passengerRepository = passengerRepository;
        this.mealRepository = mealRepository;
    }

    public List<Flight> getFlight(Ticket ticket) {
        List<Flight> flightList = new ArrayList<>();
        for(Flight flight:ticket.getFlights()){
            flightList.add(flightRepository.findOne(flight.getId()));
        }
        return flightList;
    }

    public Passenger getPassenger(Ticket ticket){ return passengerRepository.findOne(ticket.getPassenger().getId());}

    public Meal getMeal(Ticket ticket){ return  mealRepository.findOne(ticket.getMeal().getId());}
}