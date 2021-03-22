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
public class AMPassCRUDDelete extends AMPassCRUDEdit {

	public AMPassCRUDDelete(Passenger passenger) {
		super(passenger);
	}

	@Override
	public void display() {
		fetchUpdatedData();
		System.out.println("Are you sure: Y or N");

		String input = Utils.getInput(false, "y", "n").toLowerCase();

		switch (input) {
			case "y" :
				try {
					service.deletePassenger(passenger);
					System.out.println("Passenger Deleted!");
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
