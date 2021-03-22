/**
 * 
 */
package com.ss.training.utopia.ui;

import java.sql.SQLException;
import com.ss.training.utopia.entity.Flight;

/**
 * @author derrianharris
 *
 */
public class EMFlightEdit extends EMMain {

	Flight flight;
	public EMFlightEdit(Flight flight) {
		super();
		this.flight = flight;
	}

	@Override
	public void display() {
		fetchUpdatedData(flight);
		System.out.println(
				Utils.FormatOptions("View more details about the flight",
						"Update the details of the Flight ",
						"Add Seats to Flight", "Quit to previous"));
		String input = Utils.getInputRange(1, 4);

		switch (input) {
			case "1" :
				ViewHandler.getInstance().goToMenu(new EMFlightDetails(flight));
				break;
			case "2" :
				ViewHandler.getInstance().goToMenu(new EMFlightUpdate(flight));
				break;
			case "3" :
				ViewHandler.getInstance()
						.goToMenu(new EMFlightAddSeats(flight));
				break;
			case "4" :
				ViewHandler.getInstance().goBack();
				break;
		}
	}

	public void fetchUpdatedData(Flight flight) {
		try {
			this.flight = service.getFlight(flight.getId());
		} catch (IndexOutOfBoundsException | SQLException e) {
			System.out
					.println("Error retrieving flight. Contact Administrator.");
			ViewHandler.getInstance().goBack();
		}
	}

}
