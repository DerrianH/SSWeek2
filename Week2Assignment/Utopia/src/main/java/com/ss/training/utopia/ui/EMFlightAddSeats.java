/**
 * 
 */
package com.ss.training.utopia.ui;

import java.sql.SQLException;
import com.ss.training.utopia.entity.AirplaneType;
import com.ss.training.utopia.entity.Flight;

/**
 * @author derrianharris
 *
 */
public class EMFlightAddSeats extends EMFlightEdit {

	public EMFlightAddSeats(Flight flight) {
		super(flight);
	}

	@Override
	public void display() {
		fetchUpdatedData(flight);
		System.out.println(
				"Pick the Seat Class you want to add seats of, to your flight: ");
		System.out.println(Utils.FormatOptions("First", "Business", "Economy",
				"Quit to cancel operation"));

		String input = Utils.getInputRange(1, 4);
		AirplaneType type = flight.getAirplane().getAirplaneType();
		switch (input) {
			case "1" :
				System.out.println("Existing number of First class seats: "
						+ type.getFirstClassCapacity());
				System.out.println("Enter new number of seats: ");
				while (true) {
					input = Utils.getInput();
					try {
						Integer numSeats = Integer.parseInt(input);
						type.setFirstClassCapacity(numSeats);
						break;
					} catch (NumberFormatException e) {
						System.out.println("Input is not a number. Try again.");
					}
				}
				try {
					service.updateAirplaneType(type);
				} catch (SQLException e) {
					System.out.println(
							"Error updating Airplane Seats. Contact Administrator.");
					e.printStackTrace();
				}
				ViewHandler.getInstance().goBack();
				break;
			case "2" :
				System.out.println("Existing number of Business class seats: "
						+ type.getBusinessCapacity());
				System.out.println("Enter new number of seats: ");
				while (true) {
					input = Utils.getInput();
					try {
						Integer numSeats = Integer.parseInt(input);
						type.setBusinessCapacity(numSeats);
						break;
					} catch (NumberFormatException e) {
						System.out.println("Input is not a number. Try again.");
					}
				}
				try {
					service.updateAirplaneType(type);
				} catch (SQLException e) {
					System.out.println(
							"Error updating Airplane Seats. Contact Administrator.");
					e.printStackTrace();
				}
				ViewHandler.getInstance().goBack();
				break;
			case "3" :
				System.out.println("Existing number of Economy class seats: "
						+ type.getEconomyCapacity());
				System.out.println("Enter new number of seats: ");
				while (true) {
					input = Utils.getInput();
					try {
						Integer numSeats = Integer.parseInt(input);
						type.setEconomyCapacity(numSeats);
						break;
					} catch (NumberFormatException e) {
						System.out.println("Input is not a number. Try again.");
					}
				}
				try {
					service.updateAirplaneType(type);
				} catch (SQLException e) {
					System.out.println(
							"Error updating Airplane Seats. Contact Administrator.");
					e.printStackTrace();
				}
				ViewHandler.getInstance().goBack();
				break;
			case "4" :
				ViewHandler.getInstance().goBack();
				break;
		}
	}

}
