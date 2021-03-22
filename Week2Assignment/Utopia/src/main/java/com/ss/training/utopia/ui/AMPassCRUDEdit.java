/**
 * 
 */
package com.ss.training.utopia.ui;

import java.sql.SQLException;

import com.ss.training.utopia.entity.Passenger;

/**
 * @author derrianharris
 *
 */
public class AMPassCRUDEdit extends BaseMenu {

	Passenger passenger;
	public AMPassCRUDEdit(Passenger passenger) {
		super();
		fetchUpdatedData(passenger);
	}

	@Override
	public void display() {
		fetchUpdatedData(passenger);
		System.out.println(Utils.FormatOptions("Update Passenger",
				"Delete Passenger", "Quit to previous"));
		String input = Utils.getInputRange(1, 4);

		switch (input) {
			case "1" :
				ViewHandler.getInstance()
						.goToMenu(new AMPassCRUDUpdate(passenger));
				break;
			case "2" :
				ViewHandler.getInstance()
						.goToMenu(new AMPassCRUDDelete(passenger));
				break;
			case "3" :
				ViewHandler.getInstance().goBack();
				break;
		}
	}

	@Override
	public void fetchUpdatedData() {
		// TODO Auto-generated method stub

	}

	public void fetchUpdatedData(Passenger passenger) {
		try {
			this.passenger = service.getPassengerFromId(passenger.getId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
