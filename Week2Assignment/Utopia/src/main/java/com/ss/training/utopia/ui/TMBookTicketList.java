/**
 * 
 */
package com.ss.training.utopia.ui;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

import com.ss.training.utopia.entity.Flight;
import com.ss.training.utopia.entity.User;

/**
 * @author derrianharris
 *
 */
public class TMBookTicketList extends TMMain {
	public TMBookTicketList(User user) {
		super();
	}

	@Override
	public void display() {
		fetchUpdatedData(user);
		List<Flight> flights;
		try {
			flights = service.getAllFlights();
			List<String> output = flights.stream()
					.map(n -> n.getRoute().toString())
					.collect(Collectors.toList());
			output.add("Quit to previous");
			System.out.println(
					Utils.FormatOptions(output.toArray(String[]::new)));
			String input = Utils.getInputRange(1, output.size());
			String outputSize = Integer.valueOf(output.size()).toString();
			if (input.equals(outputSize)) {
				ViewHandler.getInstance().goBack();
				return;
			}
			ViewHandler.getInstance().goToMenu(new TMBookTicketSeatSelect(user,
					flights.get(Integer.parseInt(input) - 1)));
		} catch (SQLException e) {
			System.out.println(
					"Error retrieving flights. Contact Administrator.");
			ViewHandler.getInstance().goBack();
			e.printStackTrace();
		}

	}

	public void fetchUpdatedData(User user) {
		try {
			this.user = service.getUserFromId(user.getId());
		} catch (IndexOutOfBoundsException | SQLException e) {
			System.out.println("Error retrieving user. Contact Administrator.");
		}
	}

}
