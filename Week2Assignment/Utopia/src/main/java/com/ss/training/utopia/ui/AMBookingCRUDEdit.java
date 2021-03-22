/**
 * 
 */
package com.ss.training.utopia.ui;

import java.sql.SQLException;

import com.ss.training.utopia.entity.Booking;

/**
 * @author derrianharris
 *
 */
public class AMBookingCRUDEdit extends BaseMenu {

	Booking booking;
	public AMBookingCRUDEdit(Booking booking) {
		super();
		this.booking = booking;
	}

	@Override
	public void display() {
		fetchUpdatedData(booking);
		System.out.println(Utils.FormatOptions("View passengers",
				"Update Booking", "Delete Booking", "Quit to previous"));
		String input = Utils.getInputRange(1, 4);

		switch (input) {
			case "1" :
				ViewHandler.getInstance().goToMenu(new AMPassCRUD(booking));
				break;
			case "2" :
				ViewHandler.getInstance()
						.goToMenu(new AMBookingCRUDUpdate(booking));
				break;
			case "3" :
				ViewHandler.getInstance()
						.goToMenu(new AMBookingCRUDDelete(booking));
				break;
			case "4" :
				ViewHandler.getInstance().goBack();
				break;
		}
	}

	@Override
	public void fetchUpdatedData() {
		// TODO Auto-generated method stub

	}

	public void fetchUpdatedData(Booking booking) {
		try {
			this.booking = service.getBookingFromId(booking.getId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
