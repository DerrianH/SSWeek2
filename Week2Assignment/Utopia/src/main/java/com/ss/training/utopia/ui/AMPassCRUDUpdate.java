/**
 * 
 */
package com.ss.training.utopia.ui;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.stream.Collectors;

import com.ss.training.utopia.entity.Booking;
import com.ss.training.utopia.entity.Passenger;

/**
 * @author derrianharris
 *
 */
public class AMPassCRUDUpdate extends AMPassCRUDEdit {

	public AMPassCRUDUpdate(Passenger passenger) {
		super(passenger);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void display() {
		fetchUpdatedData();
		List<Booking> bookings;
		try {
			bookings = service.getAllActiveBookings();
			List<String> bookingStr = bookings.stream().map(n -> n.toString())
					.collect(Collectors.toList());

			System.out.println(
					"You have chosen to update the Passenger with Flight Id: "
							+ passenger.getId() + " and Name: "
							+ passenger.getFirstName() + " "
							+ passenger.getLastName());

			System.out
					.println("Enter ‘quit’ at any prompt to cancel operation.");
			System.out.println("");

			String input = "";

			String firstName = "";
			String lastName = "";
			String dob = "";
			String address = "";
			String gender = "";
			String booking = "";

			Integer step = 0;
			while (!input.equals("quit")) {
				switch (step) {
					case 0 :
						System.out.println(
								"Please enter new First Name or enter N/A for no change:");
						input = Utils.getInput();
						firstName = input;
						step++;
						break;

					case 1 :
						System.out.println(
								"Please enter new Last Name or enter N/A for no change:");
						input = Utils.getInput();
						lastName = input;
						step++;
						break;

					case 2 :
						System.out.println(
								"Please enter new Date of Birth or enter N/A for no change (ex. yyyy-mm-dd):");
						input = Utils.getInput();
						dob = input;
						step++;
						break;

					case 3 :
						System.out.println("Please enter new gender: ");
						input = Utils.getInput();
						gender = input;
						step++;
						break;

					case 4 :
						System.out.println(
								"Please enter new Address or enter N/A for no change:");
						input = Utils.getInput();
						address = input;
						step++;
						break;

					case 5 :
						System.out.println(
								"Select new Booking or enter N/A for no change:");

						System.out.println(Utils.FormatOptions(bookingStr));
						bookingStr.add("n/a");
						bookingStr.add("quit");
						input = Utils.getInput();
						booking = input;
						step++;
						break;

					case 6 :
						if (!firstName.toLowerCase().equals("n/a")) {
							passenger.setFirstName(firstName);
						}
						if (!lastName.toLowerCase().equals("n/a")) {
							passenger.setLastName(lastName);
						}
						if (!dob.toLowerCase().equals("n/a")) {

							try {
								LocalDate date = LocalDate.parse(dob);
								passenger.setDob(date);
							} catch (DateTimeParseException e) {
								System.out.println("Error parsing date.");
							}
						}
						if (!gender.toLowerCase().equals("n/a")) {
							passenger.setGender(gender);
						}
						if (!address.toLowerCase().equals("n/a")) {
							passenger.setAddress(address);
						}
						if (!booking.toLowerCase().equals("n/a")) {

							try {
								passenger.setBookingId(bookings
										.get(Integer.parseInt(booking) - 1)
										.getId());

							} catch (NumberFormatException e) {
								System.out.println("Error parsing booking id.");
							}
						}
						try {
							service.updatePassenger(passenger);
							ViewHandler.getInstance().goBack();
						} catch (SQLIntegrityConstraintViolationException e) {
							System.out.println("");
							System.out.println("Duplicate entry.");
						}

						break;
				}

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ViewHandler.getInstance().goBack();
	}
}
