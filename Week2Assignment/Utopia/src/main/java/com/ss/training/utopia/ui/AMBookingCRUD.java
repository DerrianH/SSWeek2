/**
 * 
 */
package com.ss.training.utopia.ui;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

import com.ss.training.utopia.entity.Booking;

/**
 * @author derrianharris
 *
 */
public class AMBookingCRUD extends BaseMenu {
	public AMBookingCRUD() {
		super();
	}

	@Override
	public void display() {
		try {
			List<Booking> bookings = service.getAllBookings();
			List<String> output = bookings.stream().map(Booking::toString)
					.collect(Collectors.toList());

			if (bookings.size() < 1) {
				System.out.println("No Bookings found!");
			}

			output.add("Add Booking");
			output.add("Quit to previous");
			System.out.println(Utils.FormatOptions(output));
			String input = Utils.getInputRange(1, output.size());
			Integer outputSize = Integer.valueOf(output.size());
			if (input.equals(outputSize.toString())) {
				ViewHandler.getInstance().goBack();
				return;
			}

			if (input.equals(Integer.valueOf(outputSize - 1).toString())) {
				ViewHandler.getInstance().goToMenu(new AMBookingCRUDAdd());
				return;
			}
			ViewHandler.getInstance().goToMenu(new AMBookingCRUDEdit(
					bookings.get(Integer.parseInt(input) - 1)));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void fetchUpdatedData() {
		// TODO Auto-generated method stub

	}

}
