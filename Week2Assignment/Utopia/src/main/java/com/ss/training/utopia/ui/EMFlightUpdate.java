/**
 * 
 */
package com.ss.training.utopia.ui;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.stream.Collectors;

import com.ss.training.utopia.entity.Airport;
import com.ss.training.utopia.entity.Flight;
import com.ss.training.utopia.entity.Route;

/**
 * @author derrianharris
 *
 */
public class EMFlightUpdate extends EMFlightEdit {

	public EMFlightUpdate(Flight flight) {
		super(flight);
	}

	@Override
	public void display() {
		fetchUpdatedData(flight);
		try {
			System.out.println(
					"You have chosen to update the Flight with Flight Id: "
							+ flight.getId() + " and Departure Airport: "
							+ flight.getRoute().getOriginIataId()
							+ " and Arrival Airport: "
							+ flight.getRoute().getDestinationIataId());
			System.out
					.println("Enter ‘quit’ at any prompt to cancel operation.");
			System.out.println("");
			List<Airport> airports = service.getAllAirports();
			List<String> airportIATA = airports.stream().map(n -> n.getIataId())
					.collect(Collectors.toList());
			airportIATA.add("quit");
			airportIATA.add("n/a");
			String input = "";
			String originAirport = "";
			String destAirport = "";
			String departureDate = "";
			String departureTime = "";

			String arrivalDate = "";
			String arrivalTime = "";
			Integer step = 0;
			while (!input.equals("quit")) {

				switch (step) {
					case 0 :
						System.out.println(
								"Please enter new Origin Airport code or enter N/A for no change (ex. ATL):");
						input = Utils.getInput(false,
								airportIATA.toArray(String[]::new));
						originAirport = input;
						step++;
						break;
					case 1 :
						System.out.println(
								"Please enter new Destination Airport code or enter N/A for no change (ex. ATL):");
						input = Utils.getInput(false,
								airportIATA.toArray(String[]::new));
						destAirport = input;
						step++;
						break;
					case 2 :
						System.out.println(
								"Please enter new Departure Date or enter N/A for no change (ex. yyyy-mm-dd):");
						input = Utils.getInput();
						departureDate = input;
						step++;
						break;
					case 3 :
						System.out.println(
								"Please enter new Departure Time or enter N/A for no change (ex. hh:mm:ss):");
						input = Utils.getInput();
						departureTime = input;
						step++;
						break;

					case 4 :
						System.out.println(
								"Please enter new Arrival Date or enter N/A for no change (ex. yyyy-mm-dd):");
						input = Utils.getInput();
						arrivalDate = input;
						step++;
						break;
					case 5 :
						System.out.println(
								"Please enter new Arrival Time or enter N/A for no change (ex. hh:mm:ss):");
						input = Utils.getInput();
						arrivalTime = input;
						step++;
						break;
					case 6 :

						Route route = flight.getRoute();

						if (!originAirport.toLowerCase().equals("n/a")) {
							route.setOriginIataId(originAirport.toUpperCase());
						}

						if (!destAirport.toLowerCase().equals("n/a")) {
							route.setDestinationIataId(
									destAirport.toUpperCase());
						}

						if (!departureDate.toLowerCase().equals("n/a")) {
							try {
								LocalDate date = LocalDate.parse(departureDate);
								if (date.isAfter(LocalDate.now())) {
									flight.setDepartureTime(flight
											.getDepartureTime().with(date));
								} else {
									System.out.println(
											"Departure Date should be after current date. Try again");
								}
							} catch (DateTimeParseException e) {
								System.out.println("Error parsing date.");
							}
						}

						if (!departureDate.toLowerCase().equals("n/a")) {
							try {
								LocalTime time = LocalTime.parse(departureTime);
								if (time.isAfter(LocalTime.now())) {
									flight.setDepartureTime(flight
											.getDepartureTime().with(time));
								} else {
									System.out.println(
											"Departure Time should be after current time. Try again");
								}
							} catch (DateTimeParseException e) {
								System.out.println("Error parsing time.");
							}
						}

						if (!arrivalDate.toLowerCase().equals("n/a")) {
							try {
								LocalDate date = LocalDate.parse(arrivalDate);
								if (date.isAfter(flight.getDepartureTime()
										.toLocalDate())) {
									flight.setArrivalTime(
											flight.getArrivalTime().with(date));
								} else {
									System.out.println(
											"Arrival Date should be after departure date. Try again");
								}
							} catch (DateTimeParseException e) {
								System.out.println("Error parsing date.");
							}
						}

						if (!arrivalTime.toLowerCase().equals("n/a")) {
							try {
								LocalTime time = LocalTime.parse(arrivalTime);
								LocalDateTime newArrivalTime = flight
										.getArrivalTime()
										.withHour(time.getHour())
										.withMinute(time.getMinute())
										.withSecond(time.getSecond());
								if (newArrivalTime
										.isAfter(flight.getDepartureTime())) {
									flight.setArrivalTime(newArrivalTime);
								} else {
									System.out.println(
											"Arrival Time should be after departure time. Try again");
								}
							} catch (DateTimeParseException e) {
								System.out.println("Error parsing time.");
							}
						}
						try {
							flight.setRoute(service.getRouteFromOrgDest(
									route.getOriginIataId(),
									route.getDestinationIataId()));
							service.updateFlight(flight);
						} catch (SQLIntegrityConstraintViolationException e) {
							System.out.println("");
							System.out.println("Duplicate Entry.");
						}
						input = "quit";
						ViewHandler.getInstance().goBack();
						break;
				}

			}
		} catch (SQLException e) {
			System.out.println("Error retrieving data. Contact Administrator.");
			e.printStackTrace();
		}
		ViewHandler.getInstance().goBack();
	}

}
