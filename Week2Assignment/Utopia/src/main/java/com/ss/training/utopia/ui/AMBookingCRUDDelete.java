package com.ss.training.utopia.ui;

import java.sql.SQLException;

import com.ss.training.utopia.entity.Booking;

public class AMBookingCRUDDelete extends AMBookingCRUDEdit {

	public AMBookingCRUDDelete(Booking booking) {
		super(booking);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void display() {
		fetchUpdatedData(booking);
		System.out.println("Are you sure: Y or N");

		String input = Utils.getInput(false, "y", "n").toLowerCase();

		switch (input) {
			case "y" :
				try {
					service.deleteBooking(booking);
					System.out.println("Booking Deleted!");
					ViewHandler.getInstance().goBack(2);
				} catch (SQLException e) {
					ViewHandler.getInstance().goBack();
					e.printStackTrace();
				}
				break;
			case "n" :
				ViewHandler.getInstance().goBack();
				break;
		}
	}
}
