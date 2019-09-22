# FlightTicketReservation

#Following queries and mutations are tested at http://localhost:8080/graphiql

#DB link: http://localhost:8080/h2-console/login.jsp
#JDBC URL: jdbc:h2:mem:testdb
#User Name: sa
#Password: (empty)

################################################---Ticket---###########################################################

query{
  findAllTickets {
    id 
    description 
    price 
    ticketDate  
    passenger{
       id
    }
    meal{
           id
    }
  }
}
-------------------------------------------------------------------------------------------------------------------------
query{
  countTickets
}
-------------------------------------------------------------------------------------------------------------------------
mutation{
  newTicket(id:2,description:"To England",price:100000,ticketDate:"30-01-2015 10:15:55 AM",flights:[{number:"500",departureDate: "31-01-2015 10:15:55 AM",fromLocation: "Sri Lanka",toLocation: "Malaysia"},{number:"468",departureDate: "30-01-2015 10:15:55 AM",fromLocation: "Malaysia",toLocation: "England"}],passenger:{firstName: "Harminy",lastName: "Granger",nic: "7884433239V",email: "granger@yahoo.com"},meal:{type:"caramel"}) {
    id
  }
}
----------------------------------------------------------------------------------------------------------------------
mutation{
  cancelTicket(id:1)
}
------------------------------------------------------------------------------------------------------------------------
mutation{
  updateTicketDescription(description:"To Sydney",id:1){
    id
    description
  }
}
-------------------------------------------------------------------------------------------------------------------------
###################################################---Flight---########################################################
query{
  findAllFlights{
    id
    number
    departureDate
    fromLocation
    toLocation
  }
}
------------------------------------------------------------------------------------------------------------------------
query{
  countFlights
}
------------------------------------------------------------------------------------------------------------------------
mutation{
  newFlight(number:"556A",departureDate:"28-01-2015 10:15:55 AM",fromLocation:"India",toLocation:"Africa") {
    id
  }
}
-------------------------------------------------------------------------------------------------------------------------
mutation{
  cancelFlight(id:3)
}
-------------------------------------------------------------------------------------------------------------------------
mutation{
    updateFlightNumber(number:"222C",id:1){
    id
  }
}
-------------------------------------------------------------------------------------------------------------------------
###################################################---Pessenger---#####################################################

query{
  findAllPassengers{
    id
    firstName
    lastName
    nic
    email
 }
}

-------------------------------------------------------------------------------------------------------------------------

query{
  countPassengers
}
-------------------------------------------------------------------------------------------------------------------------
mutation{
  newPassenger(firstName: "Harry",lastName: "Potter",nic: "123422111V",email: "potter@yahoo.com"){
    id
    firstName
    lastName
    nic
    email
  }
}
-------------------------------------------------------------------------------------------------------------------------
/*mutation{
   cancelPassenger(id: 2)
}*/
-------------------------------------------------------------------------------------------------------------------------
mutation{
  updatePassengerFirstName(firstName: "Rose",id:1) {
    id
  }
}
-------------------------------------------------------------------------------------------------------------------------
###############################################---Meal---###############################################################
query{
  findAllMeals{
    id
    type
 }
}
-------------------------------------------------------------------------------------------------------------------------
query{
  countMeals
}
-------------------------------------------------------------------------------------------------------------------------
mutation{
   newMeal(type: "SeaFood"){
     id
  }
}
-------------------------------------------------------------------------------------------------------------------------
/*mutation{
   cancelMeal(id: 1)
}*/
-------------------------------------------------------------------------------------------------------------------------
mutation{
  updateMealType(type:"Veggy",id:1) {
    id
  }
}
-------------------------------------------------------------------------------------------------------------------------
###############################################---Pet---#################################################################
query{
  findAllPets{
    id
    type
	ticket{
	   id
	}
 }
}
------------------------------------------------------------------------------------------------------------------------
query{
  countPets
}
-------------------------------------------------------------------------------------------------------------------------
mutation{
    newPet(type: "Dog",ticket: 2){
     id
  }
}
-------------------------------------------------------------------------------------------------------------------------
mutation{
   cancelPet(id: 4)
}
-------------------------------------------------------------------------------------------------------------------------
mutation{
  updatePetType(type:"Parrot",id:1) {
    id
  }
}
-------------------------------------------------------------------------------------------------------------------------
###############################################---Luggage---#############################################################
query{
  findAllLuggages{
    id
    weight
	  ticket{
	   id
	  }
 }
}
------------------------------------------------------------------------------------------------------------------------
query{
  countLuggages
}
-------------------------------------------------------------------------------------------------------------------------
mutation{
    newLuggage(weight: "4Kg",ticket:2){
     id
  }
}
-------------------------------------------------------------------------------------------------------------------------
mutation{
   cancelLuggage(id: 4)
}
-------------------------------------------------------------------------------------------------------------------------
mutation{
    updateLuggageWeight(weight:"6Kg",id:1){
    id
  }
}
-------------------------------------------------------------------------------------------------------------------------
###############################################---UnderAgeChildren---#############################################################
query{
  findAllUnderAgeChildren{
    id
    firstName
    lastName
    age
    ticket{
	   id
	}
 }
}
------------------------------------------------------------------------------------------------------------------------
query{
  countUnderAgeChildren
}
-------------------------------------------------------------------------------------------------------------------------
mutation{
  newUnderAgeChildren(firstName: "Ron",lastName: "Weesly",age:16,id:2){
     id
	 firstName
     lastName
     age
  }
}
-------------------------------------------------------------------------------------------------------------------------
mutation{
   cancelUnderAgeChildren(id: 4)
}
-------------------------------------------------------------------------------------------------------------------------
mutation{
    updateUnderAgeChildrenFirstName(firstName:"Hagred",id:1){
    id
  }
}

