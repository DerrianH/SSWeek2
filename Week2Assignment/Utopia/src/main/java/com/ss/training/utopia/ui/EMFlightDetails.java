/**
 * 
 */
package com.ss.training.utopia.ui;

import com.ss.training.utopia.entity.Flight;

/**
 * @author derrianharris
 *
 */
public class EMFlightDetails extends EMFlightEdit {

	public EMFlightDetails(Flight flight) {
		super(flight);
	}

	@Override
	public void display() {
		fetchUpdatedData(flight);
		System.out.println("You have chosen to view the Flight with Flight Id: "
				+ flight.getId() + " and Departure Airport: "
				+ flight.getRoute().getOriginIataId() + " and Arrival Airport: "
				+ flight.getRoute().getDestinationIataId());
		System.out.println("Departure Airport: "
				+ flight.getRoute().getOriginIataId() + " | Arrival Airport: "
				+ flight.getRoute().getDestinationIataId() + " |");
		System.out.println(
				"Departure Date:  " + flight.getDepartureTime().toLocalDate()
						+ " | Departure Time: "
						+ flight.getDepartureTime().toLocalTime() + " |");
		System.out.println("Arrival Date:  "
				+ flight.getArrivalTime().toLocalDate() + " | Arrival Time: "
				+ flight.getArrivalTime().toLocalTime() + " |");
		System.out.println("");

		System.out.println("Available Seats by Class: ");
		System.out.println(Utils.FormatOptions(
				"First -> " + flight.getAvailibleFirstSeats(),
				"Business -> " + flight.getAvailibleBusinessSeats(),
				"Economy -> " + flight.getAvailibleEconomySeats(),
				"Return to previous menu"));

		String input = Utils.getInputRange(1, 4);

		switch (input) {
			default :
				ViewHandler.getInstance().goBack();
		}
	}

}
