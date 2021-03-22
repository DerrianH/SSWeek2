/**
 * 
 */
package com.ss.training.utopia.ui;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import com.ss.training.utopia.entity.Booking;
import com.ss.training.utopia.entity.Passenger;

/**
 * @author derrianharris
 *
 */
public class AMPassCRUDAdd extends AMPassCRUD {

	public AMPassCRUDAdd(Booking Booking) {
		super(Booking);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void display() {
		fetchUpdatedData(booking);

		try {
			Passenger passenger = new Passenger(null, null, null, null, null,
					null, null);
			System.out
					.println("Enter ‘quit’ at any prompt to cancel operation.");
			System.out.println("");

			String input = "";

			String firstName = "";
			String lastName = "";
			String dob = "";
			String gender = "";
			String address = "";

			Integer step = 0;
			while (!input.equals("quit")) {
				switch (step) {
					case 0 :
						System.out.println("Please enter First Name: ");
						input = Utils.getInput();
						firstName = input;
						step++;
						break;

					case 1 :
						System.out.println("Please enter Last Name: ");
						input = Utils.getInput();
						lastName = input;
						step++;
						break;

					case 2 :
						System.out.println(
								"Please enter Date of Birth (ex. yyyy-mm-dd):");
						input = Utils.getInput();
						dob = input;
						step++;
						break;
					case 3 :
						System.out.println("Please enter gender: ");
						input = Utils.getInput();
						gender = input;
						step++;
						break;

					case 4 :
						System.out.println("Please enter Address: ");
						input = Utils.getInput();
						address = input;
						step++;
						break;
					case 5 :

						passenger.setFirstName(firstName);

						passenger.setLastName(lastName);
						passenger.setGender(gender);

						try {
							LocalDate date = LocalDate.parse(dob);
							passenger.setDob(date);
						} catch (DateTimeParseException e) {
							System.out.println("Error parsing date.");
						}

						passenger.setAddress(address);
						passenger.setBookingId(booking.getId());

						try {
							service.addPassenger(passenger);
							System.out.println("Passenger Added.");
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
}
