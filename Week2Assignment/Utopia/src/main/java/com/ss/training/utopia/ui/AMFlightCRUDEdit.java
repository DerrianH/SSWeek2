/**
 * 
 */
package com.ss.training.utopia.ui;

import com.ss.training.utopia.entity.Flight;

/**
 * @author derrianharris
 *
 */
public class AMFlightCRUDEdit extends EMFlightEdit {

	public AMFlightCRUDEdit(Flight flight) {
		super(flight);
	}

	@Override
	public void display() {
		fetchUpdatedData(flight);
		System.out.println(Utils.FormatOptions(
				"View more details about the flight",
				"Update the details of the Flight ", "Add Seats to Flight",
				"Delete Flight", "Quit to previous"));
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
				ViewHandler.getInstance()
						.goToMenu(new AMFlightCRUDDelete(flight));
				break;
			case "5" :
				ViewHandler.getInstance().goBack();
				break;
		}

	}
}
