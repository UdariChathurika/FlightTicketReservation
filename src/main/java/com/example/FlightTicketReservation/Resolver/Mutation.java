package com.example.FlightTicketReservation.Resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.example.FlightTicketReservation.model.*;
import com.example.FlightTicketReservation.repository.*;

import java.util.List;

public class Mutation implements GraphQLMutationResolver {
    private TicketRepository ticketRepository;
    private FlightRepository flightRepository;
    private PassengerRepository passengerRepository;
    private MealRepository mealRepository;
    private PetRepository petRepository;
    private LuggageRepository luggageRepository;
    private UnderAgrChildrenRepository underAgrChildrenRepository;

    public Mutation(TicketRepository ticketRepository, FlightRepository flightRepository, PassengerRepository passengerRepository, MealRepository mealRepository, PetRepository petRepository, LuggageRepository luggageRepository, UnderAgrChildrenRepository underAgrChildrenRepository) {
        this.ticketRepository = ticketRepository;
        this.flightRepository = flightRepository;
        this.passengerRepository = passengerRepository;
        this.mealRepository = mealRepository;
        this.petRepository = petRepository;
        this.luggageRepository = luggageRepository;
        this.underAgrChildrenRepository = underAgrChildrenRepository;
    }

    public Ticket newTicket(Long id, String description, int price, String ticketDate, List<Flight> flights, Passenger passenger, Meal meal) {
        Ticket ticket = new Ticket();
        ticket.setId(id);
        ticket.setDescription(description);
        ticket.setPrice(price);
        ticket.setTicketDate(ticketDate);
        ticket.setFlights(flights);
        ticket.setPassenger(passenger);
        ticket.setMeal(meal);

        ticketRepository.save(ticket);

        return ticket;
    }

    public boolean cancelTicket(Long id) {
        Ticket ticket = ticketRepository.findOne(id);
        if(ticket.getFlights()!= null) {
            ticket.getFlights().clear();
        }
        ticketRepository.delete(id);

        return true;
    }

    public Ticket updateTicketDescription(String description, Long id) {
        Ticket ticket = ticketRepository.findOne(id);
        if(ticket == null) {
            System.out.println("The ticket to be updated was found");
        }
        ticket.setDescription(description);

        ticketRepository.save(ticket);

        return ticket;
    }

    public Flight newFlight(String number, String departureDate, String fromLocation, String toLocation)  {
        Flight flight = new Flight();
        flight.setNumber(number);
        flight.setDepartureDate(departureDate);
        flight.setFromLocation(fromLocation);
        flight.setToLocation(toLocation);

        flightRepository.save(flight);

        return flight;
    }

    public boolean cancelFlight(Long id) {
        Flight flight = flightRepository.findOne(id);
        if(flight.getTickets()!= null) {
            flight.getTickets().clear();
        }
        flightRepository.delete(id);
        return true;
    }

    public Flight updateFlightNumber(String number, Long id) {
        Flight flight = flightRepository.findOne(id);
        if(flight == null) {
            System.out.println("The ticket to be updated was found");
        }
        flight.setNumber(number);

        flightRepository.save(flight);

        return flight;
    }

    public Passenger newPassenger(String firstName, String lastName, String nic, String email)  {
        Passenger passenger = new Passenger();
        passenger.setFirstName(firstName);
        passenger.setLastName(lastName);
        passenger.setNIC(nic);
        passenger.setEmail(email);

        passengerRepository.save(passenger);

        return passenger;
    }

    public boolean cancelPassenger(Long id) {
        passengerRepository.delete(id);
        return true;
    }

    public Passenger updatePassengerFirstName(String firstName, Long id) {
        Passenger passenger = passengerRepository.findOne(id);
        if(passenger == null) {
            System.out.println("The Passenger to be updated was found");
        }
        passenger.setFirstName(firstName);

        passengerRepository.save(passenger);

        return passenger;
    }

    public Meal newMeal(String type)  {
        Meal meal = new Meal();
        meal.setType(type);

        mealRepository.save(meal);

        return meal;
    }

    public boolean cancelMeal(Long id) {
        mealRepository.delete(id);
        return true;
    }

    public Meal updateMealType(String type, Long id) {
        Meal meal = mealRepository.findOne(id);
        if(meal == null) {
            System.out.println("The meal to be updated was found");
        }
        meal.setType(type);

        mealRepository.save(meal);

        return meal;
    }

    public Pet newPet(String type,Long ticket_id){
        Pet pet = new Pet();
        pet.setType(type);
        pet.setTicket(new Ticket(ticket_id));

        petRepository.save(pet);

        return pet;
    }

    public boolean cancelPet(Long id) {
        petRepository.delete(id);
        return true;
    }

    public Pet updatePetType(String type, Long id) {
        Pet pet = petRepository.findOne(id);
        if(pet == null) {
            System.out.println("The pet to be updated was found");
        }
        pet.setType(type);

        petRepository.save(pet);

        return pet;
    }

    public Luggage newLuggage(String weight,Long ticket_id){

        Luggage luggage = new Luggage();
        luggage.setWeight(weight);
        luggage.setTicket(new Ticket(ticket_id));

        luggageRepository.save(luggage);

        return luggage;
    }

    public boolean cancelLuggage(Long id) {
        luggageRepository.delete(id);
        return true;
    }

    public Luggage updateLuggageWeight(String weight, Long id) {
        Luggage luggage = luggageRepository.findOne(id);
        if(luggage == null) {
            System.out.println("The luggage to be updated was found");
        }
        luggage.setWeight(weight);

        luggageRepository.save(luggage);

        return luggage;
    }

    public UnderAgeChildren newUnderAgeChildren(String firstName, String lastName, int age,Long ticket_id)  {
        UnderAgeChildren underAgeChildren = new UnderAgeChildren();
        underAgeChildren.setFirstName(firstName);
        underAgeChildren.setLastName(lastName);
        underAgeChildren.setAge(age);
        underAgeChildren.setTicket(new Ticket(ticket_id));

        underAgrChildrenRepository.save(underAgeChildren);

        return underAgeChildren;
    }

    public boolean cancelUnderAgeChildren(Long id) {
        underAgrChildrenRepository.delete(id);
        return true;
    }

    public UnderAgeChildren updateUnderAgeChildrenFirstName(String firstName, Long id) {
        UnderAgeChildren underAgeChildren = underAgrChildrenRepository.findOne(id);
        if(underAgeChildren == null) {
            System.out.println("The UnderAgeChildren to be updated was found");
        }
        underAgeChildren.setFirstName(firstName);

        underAgrChildrenRepository.save(underAgeChildren);

        return underAgeChildren;
    }
}