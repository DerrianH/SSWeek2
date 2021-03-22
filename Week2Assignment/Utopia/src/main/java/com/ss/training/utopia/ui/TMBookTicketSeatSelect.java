/**
 * 
 */
package com.ss.training.utopia.ui;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.training.utopia.entity.BookingBaseUser;
import com.ss.training.utopia.entity.Flight;
import com.ss.training.utopia.entity.User;

/**
 * @author derrianharris
 *
 */
public class TMBookTicketSeatSelect extends TMMain {

	Flight flight;
	public TMBookTicketSeatSelect(User user, Flight flight) {
		super();
		fetchUpdatedData(user, flight);
	}

	@Override
	public void display() {
		fetchUpdatedData(user, flight);
		List<String> options = new ArrayList<String>();
		options.add("View Flight Details");

		if (flight.getAvailibleFirstSeats() > 0) {
			options.add("First");
		}
		if (flight.getAvailibleBusinessSeats() > 0) {
			options.add("Business");
		}
		if (flight.getAvailibleEconomySeats() > 0) {
			options.add("Economy");
		}

		options.add("Quit to cancel operation");

		System.out.println(Utils.FormatOptions(options));
		String input = options.get(
				Integer.parseInt(Utils.getInputRange(1, options.size())) - 1);

		switch (input) {
			case "View Flight Details" :
				ViewHandler.getInstance().goToMenu(new TMFlightDetails(flight));
				break;
			case "First" :
				tryBookFlight(user, flight, Flight.FIRST);
				break;
			case "Business" :
				tryBookFlight(user, flight, Flight.BUSINESS);
				break;
			case "Economy" :
				tryBookFlight(user, flight, Flight.ECONOMY);
				break;
			case "Quit to cancel operation" :
				ViewHandler.getInstance().goBack(2);
				break;
		}
		ViewHandler.getInstance().goBack(2);
	}

	public void fetchUpdatedData(User user, Flight flight) {
		try {
			this.flight = service.getFlight(flight.getId());
			this.user = service.getUserFromId(user.getId());
		} catch (IndexOutOfBoundsException | SQLException e) {
			System.out.println("Error retrieving data. Contact Administrator.");
		}
	}

	public void tryBookFlight(User user, Flight flight, Integer seatType) {
		try {
			service.bookFlight(user, flight, seatType, BookingBaseUser.USER);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

}
