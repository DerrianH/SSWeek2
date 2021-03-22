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
public class AMFlightCRUD extends BaseMenu {
	public AMFlightCRUD() {
		super();
	}

	@Override
	public void display() {
		try {
			List<Flight> flights = service.getAllFlights();
			List<String> output = flights.stream()
					.map(n -> n.getRoute().toString())
					.collect(Collectors.toList());
			output.add("Add new Flight");
			output.add("Quit to previous");
			System.out.println(
					Utils.FormatOptions(output.toArray(String[]::new)));
			String input = Utils.getInputRange(1, output.size());
			Integer outputSize = Integer.valueOf(output.size());

			if (input.equals(outputSize.toString())) {
				ViewHandler.getInstance().goBack();
				return;
			}
			if (input.equals(String.valueOf(outputSize - 1))) {
				ViewHandler.getInstance().goToMenu(new AMFlightCRUDAdd());;
				return;
			}
			ViewHandler.getInstance().goToMenu(new AMFlightCRUDEdit(
					flights.get(Integer.parseInt(input) - 1)));
		} catch (SQLException e) {
			System.out.println(
					"Error retrieving flights. Contact Administrator.");
			e.printStackTrace();
		}

	}

	@Override
	public void fetchUpdatedData() {
		// TODO Auto-generated method stub

	}

}
