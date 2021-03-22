/**
 * 
 */
package com.ss.training.utopia.ui;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

import com.ss.training.utopia.entity.Flight;

/**
 * @author derrianharris
 *
 */
public class EMFlightList extends EMMain {

	@Override
	public void display() {
		try {
			List<Flight> flights = service.getAllFlights();
			List<String> output = flights.stream()
					.map(n -> n.getRoute().toString())
					.collect(Collectors.toList());

			if (flights.size() < 1) {
				System.out.println("No Flights found!");
			}

			output.add("Quit to previous");
			System.out.println(
					Utils.FormatOptions(output.toArray(String[]::new)));
			String input = Utils.getInputRange(1, output.size());
			String outputSize = Integer.valueOf(output.size()).toString();
			if (input.equals(outputSize)) {
				ViewHandler.getInstance().goBack();
				return;
			}
			ViewHandler.getInstance().goToMenu(
					new EMFlightEdit(flights.get(Integer.parseInt(input) - 1)));
		} catch (SQLException e) {
			System.out.println(
					"Error retrieving flights. Contact Administrator.");
			e.printStackTrace();
		}

	}

}
