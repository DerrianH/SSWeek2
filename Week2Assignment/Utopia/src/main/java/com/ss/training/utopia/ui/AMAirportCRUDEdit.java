/**
 * 
 */
package com.ss.training.utopia.ui;

import java.sql.SQLException;

import com.ss.training.utopia.entity.Airport;

/**
 * @author derrianharris
 *
 */
public class AMAirportCRUDEdit extends BaseMenu {

	Airport airport;
	public AMAirportCRUDEdit(Airport airport) {
		super();
		this.airport = airport;
	}

	@Override
	public void display() {
		fetchUpdatedData(airport);
		System.out.println(Utils.FormatOptions("Update Airport",
				"Delete Airport", "Quit to previous"));
		String input = Utils.getInputRange(1, 3);

		switch (input) {
			case "1" :
				ViewHandler.getInstance()
						.goToMenu(new AMAirportCRUDUpdate(airport));
				break;
			case "2" :
				ViewHandler.getInstance()
						.goToMenu(new AMAirportCRUDDelete(airport));
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

	public void fetchUpdatedData(Airport airport) {
		try {
			this.airport = service.getAirportFromCode(airport.getIataId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
