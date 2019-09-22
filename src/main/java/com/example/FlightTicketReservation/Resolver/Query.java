package com.example.FlightTicketReservation.Resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.FlightTicketReservation.model.*;
import com.example.FlightTicketReservation.repository.*;

public class Query implements GraphQLQueryResolver {
    private TicketRepository ticketRepository;
    private FlightRepository flightRepository;
    private PassengerRepository passengerRepository;
    private MealRepository mealRepository;
    private PetRepository petRepository;
    private LuggageRepository luggageRepository;
    private UnderAgrChildrenRepository underAgrChildrenRepository;

    public Query(TicketRepository ticketRepository, FlightRepository flightRepository, PassengerRepository passengerRepository, MealRepository mealRepository, PetRepository petRepository, LuggageRepository luggageRepository,UnderAgrChildrenRepository underAgrChildrenRepository){
        this.ticketRepository = ticketRepository;
        this.flightRepository = flightRepository;
        this.passengerRepository = passengerRepository;
        this.mealRepository = mealRepository;
        this.petRepository = petRepository;
        this.luggageRepository = luggageRepository;
        this.underAgrChildrenRepository = underAgrChildrenRepository;
    }

    public Iterable<Ticket> findAllTickets() {
        return ticketRepository.findAll();
    }

    public long countTickets() {
        return ticketRepository.count();
    }

    public Iterable<Flight> findAllFlights() {
        return flightRepository.findAll();
    }

    public long countFlights() {
        return flightRepository.count();
    }

    public Iterable<Passenger> findAllPassengers() {
        return passengerRepository.findAll();
    }

    public long countPassengers() {
        return passengerRepository.count();
    }

    public Iterable<Meal> findAllMeals() {
        return mealRepository.findAll();
    }

    public long countMeals() {
        return mealRepository.count();
    }

    public Iterable<Pet> findAllPets() {
        return petRepository.findAll();
    }

    public long countPets() {
        return petRepository.count();
    }

    public Iterable<Luggage> findAllLuggages() {
        return luggageRepository.findAll();
    }

    public long countLuggages() {
        return luggageRepository.count();
    }

    public Iterable<UnderAgeChildren> findAllUnderAgeChildren() {
        return underAgrChildrenRepository.findAll();
    }

    public long countUnderAgeChildren() {
        return underAgrChildrenRepository.count();
    }
}