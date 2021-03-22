/**
 * 
 */
package com.ss.training.utopia.ui;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.UUID;

import com.ss.training.utopia.entity.Booking;
import com.ss.training.utopia.entity.Flight;

/**
 * @author derrianharris
 *
 */
public class AMBookingCRUDAdd extends BaseMenu {

	@Override
	public void display() {
		try {
			Booking booking = new Booking(null, false,
					UUID.randomUUID().toString(), null);

			System.out
					.println("Enter ‘quit’ at any prompt to cancel operation.");
			System.out.println("");

			String input = "";

			String is_active = "";
			String seatType = "";

			Integer step = 0;
			while (!input.equals("quit")) {
				switch (step) {
					case 0 :
						System.out.println("Is this an active booking?");
						System.out.println("Please enter Y or N:");
						input = Utils.getInput(false, "y", "n");
						is_active = input;
						step++;
						break;
					case 1 :
						System.out.println("Select seat type:");

						System.out.println(Utils.FormatOptions("First Class",
								"Business Class", "Economy Class"));
						input = Utils.getInput();
						seatType = input;
						step++;
						break;
					case 2 :
						is_active = is_active.toLowerCase();
						switch (is_active) {
							case "y" :
								booking.setActive(true);
								break;
							case "n" :
								booking.setActive(false);
								break;
							default :
								System.out
										.println("Error parsing cancelation.");
						}

						switch (Integer.parseInt(seatType)) {
							case Flight.FIRST :
								booking.setSeatType(Flight.FIRST);
								break;
							case Flight.BUSINESS :
								booking.setSeatType(Flight.BUSINESS);
								break;
							case Flight.ECONOMY :
								booking.setSeatType(Flight.ECONOMY);
								break;
							default :
								System.out.println("Error parsing seat type.");
						}

						try {
							service.addBooking(booking);
							System.out.println("Booking Added!");
						} catch (SQLIntegrityConstraintViolationException e) {
							System.out.println("");
							System.out.println("Duplicate entry.");
						}
						input = "quit";
						ViewHandler.getInstance().goBack();
						break;
				}

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void fetchUpdatedData() {
		// TODO Auto-generated method stub

	}

}
