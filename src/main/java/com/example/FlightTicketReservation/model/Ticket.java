package com.example.FlightTicketReservation.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Ticket {

    @Id
//    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String description;

    private int price;

    private String ticketDate;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name="flight_ticket",
            joinColumns = @JoinColumn(name="ticket_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name="flight_id",referencedColumnName = "id")
    )
    List<Flight> flights;

    @OneToOne(orphanRemoval = true,cascade = CascadeType.ALL)
    @JoinColumn(name = "pessenger_id")
    private Passenger passenger;

    @OneToOne(orphanRemoval = true,cascade = CascadeType.ALL)
    @JoinColumn(name = "meal_id")
    private Meal meal;

    @OneToMany(orphanRemoval = true,mappedBy = "ticket",cascade = CascadeType.ALL)
    List<Pet> pets;

    @OneToMany(orphanRemoval = true,mappedBy = "ticket",cascade = CascadeType.ALL)
    List<Luggage> luggages;

    @OneToMany(orphanRemoval = true,mappedBy = "ticket",cascade = CascadeType.ALL)
    List<UnderAgeChildren> underAgeChildren;

    public Ticket() {}

    public Ticket(Long id) {
        this.id = id;
    }

    public Ticket(Long id, String description, int price, String ticketDate, List<Flight> flights, Passenger passenger, Meal meal) {
        this.id = id;
        this.description = description;
        this.price = price;
        this.ticketDate = ticketDate;
        this.flights = flights;
        this.passenger = passenger;
        this.meal = meal;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getTicketDate() {
        return ticketDate;
    }

    public void setTicketDate(String ticketDate) {
        this.ticketDate = ticketDate;
    }

    public List<Flight> getFlights() {
        return flights;
    }

    public void setFlights(List<Flight> flights) {
        this.flights = flights;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public Meal getMeal() {
        return meal;
    }

    public void setMeal(Meal meal) {
        this.meal = meal;
    }

}
