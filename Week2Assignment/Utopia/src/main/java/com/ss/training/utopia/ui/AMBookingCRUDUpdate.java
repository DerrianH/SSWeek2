/**
 * 
 */
package com.ss.training.utopia.ui;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import com.ss.training.utopia.entity.Booking;
import com.ss.training.utopia.entity.Flight;

/**
 * @author derrianharris
 *
 */
public class AMBookingCRUDUpdate extends AMBookingCRUDEdit {

	public AMBookingCRUDUpdate(Booking booking) {
		super(booking);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void display() {
		fetchUpdatedData(booking);
		try {

			System.out.println("You have chosen to update the Booking with Id: "
					+ booking.getId() + " and Confirmation Code: "
					+ booking.getConfirmationCode());

			System.out
					.println("Enter ‘quit’ at any prompt to cancel operation.");
			System.out.println("");

			String input = "";

			String is_active = "";
			String confirmationCode = "";
			String seatType = "";

			Integer step = 0;
			while (!input.equals("quit")) {
				switch (step) {
					case 0 :
						System.out.println("Cancel Booking?");
						System.out.println(
								"Please enter Y or N or enter N/A for no change:");
						input = Utils.getInput();
						is_active = input;
						step++;
						break;

					case 1 :
						System.out.println(
								"Please enter new  Confirmation Code or enter N/A for no change:");
						input = Utils.getInput();
						confirmationCode = input;
						step++;
						break;

					case 2 :
						System.out.println(
								"Select new seat type or enter N/A for no change:");
						System.out.println(Utils.FormatOptions("First Class",
								"Business Class", "Economy Class"));
						input = Utils.getInput();
						seatType = input;
						step++;
						break;
					case 3 :
						is_active = is_active.toLowerCase();
						switch (is_active) {
							case "y" :
								booking.setActive(false);
								break;
							case "n" :
								booking.setActive(false);
								break;
							case "n/a" :
								break;
							default :
								System.out
										.println("Error parsing cancelation.");
						}
						booking.setConfirmationCode(confirmationCode);

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
							service.updateBooking(booking);
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
		ViewHandler.getInstance().goBack();
	}

	@Override
	public void fetchUpdatedData() {
		// TODO Auto-generated method stub

	}

}
