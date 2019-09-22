package com.example.FlightTicketReservation;

import com.example.FlightTicketReservation.Resolver.Mutation;
import com.example.FlightTicketReservation.Resolver.Query;
import com.example.FlightTicketReservation.Resolver.TicketResolver;
import com.example.FlightTicketReservation.model.*;
import com.example.FlightTicketReservation.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class FlightTicketReservationApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlightTicketReservationApplication.class, args);
	}

	@Bean
	public TicketResolver ticketResolver(FlightRepository flightRepository, PassengerRepository passengerRepository, MealRepository mealRepository) {
		return new TicketResolver(flightRepository, passengerRepository,mealRepository);
	}

	@Bean
	public Query query(TicketRepository ticketRepository, FlightRepository flightRepository, PassengerRepository passengerRepository, MealRepository mealRepository, PetRepository petRepository,LuggageRepository luggageRepository,UnderAgrChildrenRepository underAgrChildrenRepository){
		return new Query(ticketRepository,flightRepository, passengerRepository,mealRepository,petRepository,luggageRepository,underAgrChildrenRepository);
	}

	@Bean
	public Mutation mutation(TicketRepository ticketRepository, FlightRepository flightRepository, PassengerRepository passengerRepository, MealRepository mealRepository, PetRepository petRepository,LuggageRepository luggageRepository,UnderAgrChildrenRepository underAgrChildrenRepository) {
		return new Mutation(ticketRepository,flightRepository, passengerRepository,mealRepository,petRepository,luggageRepository,underAgrChildrenRepository);
	}

	@Bean
	public CommandLineRunner demo(TicketRepository ticketRepository, FlightRepository flightRepository, PassengerRepository passengerRepository, MealRepository mealRepository, PetRepository petRepository,LuggageRepository luggageRepository,UnderAgrChildrenRepository underAgrChildrenRepository) {
		return (args) -> {

			Flight flight1 = new Flight("234N","22-01-2015 10:15:55 AM","Sri Lanka","India");
            flightRepository.save(flight1);

			Flight flight2 = new Flight("232N","22-01-2015 10:40:55 AM","India","NewYork");
			flightRepository.save(flight2);

			List<Flight> flightList = new ArrayList<>();
			flightList.add(flight1);
			flightList.add(flight2);

			Passenger passenger = new Passenger("Ann","Williams","12345321V","ann@gmail.com");
            passengerRepository.save(passenger);

            Meal meal = new Meal("Vege");
            mealRepository.save(meal);

			Ticket ticket = new Ticket(1L,"To NewYork",50000,"22-01-2015 10:15:55 AM",flightList, passenger,meal);
			ticketRepository.save(ticket);

            Pet pet1 = new Pet("Cat",ticket);
            petRepository.save(pet1);

            Pet pet2 = new Pet("Rabbit",ticket);
            petRepository.save(pet2);

			Luggage luggage1 = new Luggage("1Kg",ticket);
			luggageRepository.save(luggage1);

			Luggage luggage2 = new Luggage("2Kg",ticket);
			luggageRepository.save(luggage2);

			UnderAgeChildren underAgeChildren1 = new UnderAgeChildren("Shaun","williams",4,ticket);
			underAgrChildrenRepository.save(underAgeChildren1);

			UnderAgeChildren underAgeChildren2 = new UnderAgeChildren("Edward","williams",5,ticket);;
			underAgrChildrenRepository.save(underAgeChildren2);



		};
	}

}
