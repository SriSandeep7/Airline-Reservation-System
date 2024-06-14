import java.util.*;

// Class to represent a Passenger
class Passenger {
    private String name;
    private int age;

    public Passenger(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

// Class to represent a Ticket
class Ticket {
    private String ticketNumber;
    private Passenger passenger;
    private Flight flight;

    public Ticket(String ticketNumber, Passenger passenger, Flight flight) {
        this.ticketNumber = ticketNumber;
        this.passenger = passenger;
        this.flight = flight;
    }

    public String getTicketNumber() {
        return ticketNumber;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public Flight getFlight() {
        return flight;
    }
}

// Class to represent a Flight
class Flight {
    private String flightNumber;
    private String origin;
    private String destination;
    private int capacity;
    private List<Passenger> passengers;

    public Flight(String flightNumber, String origin, String destination, int capacity) {
        this.flightNumber = flightNumber;
        this.origin = origin;
        this.destination = destination;
        this.capacity = capacity;
        this.passengers = new ArrayList<>();
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public String getOrigin() {
        return origin;
    }

    public String getDestination() {
        return destination;
    }

    public int getCapacity() {
        return capacity;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public boolean addPassenger(Passenger passenger) {
        if (passengers.size() < capacity) {
            passengers.add(passenger);
            return true;
        } else {
            return false; // Flight is full
        }
    }

    public boolean removePassenger(Passenger passenger) {
        return passengers.remove(passenger);
    }
}

// Class to represent the Airline Reservation System
class AirlineReservationSystem {
    private Map<String, Flight> flights;
    private List<Ticket> tickets;

    public AirlineReservationSystem() {
        this.flights = new HashMap<>();
        this.tickets = new ArrayList<>();
    }

    public void addFlight(String flightNumber, String origin, String destination, int capacity) {
        if (!flights.containsKey(flightNumber)) {
            flights.put(flightNumber, new Flight(flightNumber, origin, destination, capacity));
            System.out.println("Flight " + flightNumber + " added successfully.");
        } else {
            System.out.println("Flight " + flightNumber + " already exists.");
        }
    }

    public boolean makeReservation(String flightNumber, Passenger passenger) {
        Flight flight = flights.get(flightNumber);
        if (flight != null) {
            if (flight.addPassenger(passenger)) {
                Ticket ticket = new Ticket(generateTicketNumber(), passenger, flight);
                tickets.add(ticket);
                System.out.println("Reservation successful. Ticket number: " + ticket.getTicketNumber());
                return true;
            } else {
                System.out.println("Reservation failed. Flight " + flightNumber + " is full.");
                return false;
            }
        } else {
            System.out.println("Flight " + flightNumber + " not found.");
            return false;
        }
    }

    public boolean cancelReservation(String ticketNumber) {
        for (Iterator<Ticket> iterator = tickets.iterator(); iterator.hasNext();) {
            Ticket ticket = iterator.next();
            if (ticket.getTicketNumber().equals(ticketNumber)) {
                iterator.remove();
                ticket.getFlight().removePassenger(ticket.getPassenger());
                System.out.println("Reservation cancelled successfully.");
                return true;
            }
        }
        System.out.println("Ticket " + ticketNumber + " not found.");
        return false;
    }

    public int getAvailableSeats(String flightNumber) {
        Flight flight = flights.get(flightNumber);
        if (flight != null) {
            return flight.getCapacity() - flight.getPassengers().size();
        } else {
            System.out.println("Flight " + flightNumber + " not found.");
            return -1;
        }
    }

    public Collection<Flight> getFlights() {
        return flights.values();
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    private String generateTicketNumber() {
        // Generate a unique ticket number (can be implemented according to specific requirements)
        return UUID.randomUUID().toString();
    }
}

// Main class to run the program
public class Main {
    public static void main(String[] args) {
        AirlineReservationSystem airlineSystem = new AirlineReservationSystem();

        // Adding flights
        airlineSystem.addFlight("F101", "New York", "Los Angeles", 150);
        airlineSystem.addFlight("F102", "Los Angeles", "Chicago", 200);

        // Making reservations
        Passenger passenger1 = new Passenger("John Doe", 30);
        Passenger passenger2 = new Passenger("Jane Smith", 25);

        airlineSystem.makeReservation("F101", passenger1);
        airlineSystem.makeReservation("F102", passenger2);

        // Displaying passenger information
        for (Flight flight : airlineSystem.getFlights()) {
            System.out.println("Flight: " + flight.getFlightNumber());
            System.out.println("Passengers:");
            for (Passenger passenger : flight.getPassengers()) {
                System.out.println("- " + passenger.getName() + " (" + passenger.getAge() + ")");
            }
            System.out.println();
        }

        // Assuming we have a ticket number to cancel
        String ticketToCancel = airlineSystem.getTickets().get(0).getTicketNumber();
        // Cancelling a reservation
        airlineSystem.cancelReservation(ticketToCancel);

        // Checking available seats
        int availableSeats = airlineSystem.getAvailableSeats("F101");
        if (availableSeats != -1) {
            System.out.println("Available seats for Flight F101: " + availableSeats);
        }
    }
}
