/**
 * 
 */
package com.ss.training.utopia.ui;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import com.ss.training.utopia.entity.Airplane;
import com.ss.training.utopia.entity.Airport;
import com.ss.training.utopia.entity.Flight;
import com.ss.training.utopia.entity.Route;

/**
 * @author derrianharris
 *
 */
public class AMFlightCRUDAdd extends BaseMenu {
	public AMFlightCRUDAdd() {
		super();
	}

	@Override
	public void display() {
		try {
			System.out
					.println("Enter ‘quit’ at any prompt to cancel operation.");
			System.out.println("");
			List<Airport> airports = service.getAllAirports();
			List<String> airportIATA = airports.stream().map(n -> n.getIataId())
					.collect(Collectors.toList());
			List<Airplane> airplanes = service.getAllAirplanes();
			airportIATA.add("quit");
			airportIATA.add("n/a");
			String input = "";
			String originAirport = "";
			String destAirport = "";
			String departureDate = "";
			String departureTime = "";

			String arrivalDate = "";
			String arrivalTime = "";
			String plane = "";
			String fSeatPrice = "";
			String bSeatPrice = "";
			String eSeatPrice = "";
			Integer step = 0;
			while (!input.equals("quit")) {

				switch (step) {
					case 0 :
						System.out.println(
								"Please enter new Origin Airport code (ex. ATL):");
						input = Utils.getInput(false,
								airportIATA.toArray(String[]::new));
						originAirport = input;
						step++;
						break;
					case 1 :
						System.out.println(
								"Please enter new Destination Airport code(ex. ATL):");
						input = Utils.getInput(false,
								airportIATA.toArray(String[]::new));
						destAirport = input;
						step++;
						break;
					case 2 :
						System.out.println(
								"Please enter new Departure Date (ex. yyyy-mm-dd):");
						input = Utils.getInput();
						departureDate = input;
						step++;
						break;
					case 3 :
						System.out.println(
								"Please enter new Departure Time (ex. hh:mm:ss):");
						input = Utils.getInput();
						departureTime = input;
						step++;
						break;

					case 4 :
						System.out.println(
								"Please enter new Arrival Date (ex. yyyy-mm-dd):");
						input = Utils.getInput();
						arrivalDate = input;
						step++;
						break;
					case 5 :
						System.out.println(
								"Please enter new Arrival Time(ex. hh:mm:ss):");
						input = Utils.getInput();
						arrivalTime = input;
						step++;
						break;
					case 6 :
						System.out.println("Please select plane (ex. 1):");
						System.out.print(Utils.FormatOptions(
								airplanes.stream().map(Airplane::toString)
										.toArray(String[]::new)));
						input = Utils.getInputRange(1, airplanes.size());
						plane = input;
						step++;
						break;

					case 7 :
						System.out.println(
								"Please enter First Class seat price (ex. 220.0 or 220):");
						input = Utils.getInput();
						fSeatPrice = input;
						step++;
						break;

					case 8 :
						System.out.println(
								"Please enter Business Class seat price (ex. 220.0 or 220):");
						input = Utils.getInput();
						bSeatPrice = input;
						step++;
						break;

					case 9 :
						System.out.println(
								"Please enter Economy Class seat price (ex. 220.0 or 220):");
						input = Utils.getInput();
						eSeatPrice = input;
						step++;
						break;
					case 10 :
						Route route = service.getRouteFromOrgDest(originAirport,
								destAirport);
						Flight flight = new Flight(0, route.getId(), 0,
								LocalDateTime.now(), LocalDateTime.now(), 0,
								0.0f, 0, 0.0f, 0, 0.0f);

						route.setOriginIataId(originAirport.toUpperCase());
						route.setDestinationIataId(destAirport.toUpperCase());
						try {
							LocalDate date = LocalDate.parse(departureDate);
							LocalTime time = LocalTime.parse(departureTime);
							LocalDateTime dt = LocalDateTime.of(date, time);
							if (!dt.isBefore(LocalDateTime.now())) {
								flight.setDepartureTime(dt);
							}

							date = LocalDate.parse(arrivalDate);
							time = LocalTime.parse(arrivalTime);
							dt = LocalDateTime.of(date, time);
							if (!dt.isBefore(flight.getDepartureTime())) {
								flight.setArrivalTime(dt);
							}

							flight.setAirplane(
									airplanes.get(Integer.parseInt(plane) - 1));
							flight.setFirstSeatPrice(
									Float.parseFloat(fSeatPrice));
							flight.setBusinessSeatPrice(
									Float.parseFloat(bSeatPrice));
							flight.setEconomySeatPrice(
									Float.parseFloat(eSeatPrice));

						} catch (DateTimeParseException
								| NumberFormatException e) {
							System.out.println("Error parsing date.");
						}
						try {
							Random rand = new Random();
							rand.setSeed(LocalDateTime.now()
									.toEpochSecond(ZoneOffset.UTC));
							flight.setId(rand.nextInt(Integer.MAX_VALUE));
							flight.setRoute(service.getRouteFromOrgDest(
									route.getOriginIataId(),
									route.getDestinationIataId()));
							service.addFlight(flight);
							System.out.println("Flight Added!");
						} catch (SQLIntegrityConstraintViolationException e) {
							System.out.println("Duplicate Entry.");
						}
						ViewHandler.getInstance().goBack();
						break;
				}
				if (input.toLowerCase().equals("quit")) {
					ViewHandler.getInstance().goBack();
				}

			}
		} catch (SQLException e) {
			System.out.println("Error retrieving data. Contact Administrator.");
			e.printStackTrace();
		}
		System.out.println("Flight Added!");
		ViewHandler.getInstance().goBack();
	}

	@Override
	public void fetchUpdatedData() {
		// TODO Auto-generated method stub

	}

}
