/**
 * 
 */
package com.ss.training.utopia.ui;

import java.sql.SQLException;

import com.ss.training.utopia.entity.Flight;

/**
 * @author derrianharris
 *
 */
public class AMFlightCRUDDelete extends EMFlightEdit {

	public AMFlightCRUDDelete(Flight flight) {
		super(flight);
	}

	@Override
	public void display() {
		fetchUpdatedData();
		System.out.println("Are you sure: Y or N");

		String input = Utils.getInput(false, "y", "n").toLowerCase();

		switch (input) {
			case "y" :
				try {
					service.deleteFlight(flight);
					System.out.println("Flight Deleted!");
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
