/**
 * 
 */
package com.ss.training.utopia.ui;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

import com.ss.training.utopia.entity.Booking;
import com.ss.training.utopia.entity.Passenger;

/**
 * @author derrianharris
 *
 */
public class AMPassCRUD extends AMBookingCRUDEdit {

	public AMPassCRUD(Booking booking) {
		super(booking);
	}

	@Override
	public void display() {
		fetchUpdatedData(booking);
		List<String> output = booking.getPassengers().stream()
				.map(Passenger::toString).collect(Collectors.toList());

		if (booking.getPassengers().size() < 1) {
			System.out.println("No Passengers found!");
		}

		output.add("Add Passenger");
		output.add("Quit to previous");
		System.out.println(Utils.FormatOptions(output));
		String input = Utils.getInputRange(1, output.size());
		Integer outputSize = Integer.valueOf(output.size());
		if (input.equals(outputSize.toString())) {
			ViewHandler.getInstance().goBack();
			return;
		}

		if (input.equals(Integer.valueOf(outputSize - 1).toString())) {
			ViewHandler.getInstance().goToMenu(new AMPassCRUDAdd(booking));
			return;
		}
		ViewHandler.getInstance().goToMenu(new AMPassCRUDEdit(
				booking.getPassengers().get(Integer.parseInt(input) - 1)));
	}

	@Override
	public void fetchUpdatedData(Booking booking) {
		try {
			this.booking = service.getBookingFromId(booking.getId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
