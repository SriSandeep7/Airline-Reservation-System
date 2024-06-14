Airline Reservation System
Description
This project is a simple Airline Reservation System implemented in Java. It allows users to manage flights, make reservations, and cancel reservations. The system tracks passengers, tickets, and flight details.

Features
Add Flights: Add new flights with specified flight numbers, origin, destination, and capacity.
Make Reservations: Reserve a seat for a passenger on a specified flight.
Cancel Reservations: Cancel an existing reservation using the ticket number.
Check Available Seats: Check the number of available seats on a specific flight.
Display Flight Information: Display all passengers on each flight.
Prerequisites
Java Development Kit (JDK) installed on your machine.
An IDE like Eclipse or IntelliJ IDEA (optional but recommended for ease of development).
Installation
Clone the repository:
sh
Copy code
git clone https://github.com/yourusername/airline-reservation-system.git
Navigate to the project directory:
sh
Copy code
cd airline-reservation-system
Usage
Open the project in your IDE: Import the project if necessary.

Compile and Run the Main class:

In Eclipse, right-click on Main.java and select Run As > Java Application.
In IntelliJ IDEA, right-click on Main.java and select Run 'Main'.
Interacting with the System:

The program will output various messages to the console based on the operations performed.
The default operations in the Main class include adding flights, making reservations, displaying flight information, cancelling a reservation, and checking available seats.
Example
Here's a brief example of what the console output might look like:

yaml
Copy code
Flight F101 added successfully.
Flight F102 added successfully.
Reservation successful. Ticket number: 123e4567-e89b-12d3-a456-556642440000
Reservation successful. Ticket number: 123e4567-e89b-12d3-a456-556642440001

Flight: F101
Passengers:
- John Doe (30)

Flight: F102
Passengers:
- Jane Smith (25)

Reservation cancelled successfully.
Available seats for Flight F101: 150
Project Structure
Passenger: Class representing a passenger with name and age attributes.
Ticket: Class representing a ticket with a unique ticket number, associated passenger, and flight.
Flight: Class representing a flight with flight number, origin, destination, capacity, and a list of passengers.
AirlineReservationSystem: Class managing flights and reservations, providing methods to add flights, make and cancel reservations, check available seats, and retrieve flight and ticket information.
Main: The main class demonstrating the functionality of the system.
Contributing
Contributions are welcome! Please fork the repository and create a pull request with your changes.

