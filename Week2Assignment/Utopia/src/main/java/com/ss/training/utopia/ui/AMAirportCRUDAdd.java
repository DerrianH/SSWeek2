/**
 * 
 */
package com.ss.training.utopia.ui;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import com.ss.training.utopia.entity.Airport;

/**
 * @author derrianharris
 *
 */
public class AMAirportCRUDAdd extends BaseMenu {

	@Override
	public void display() {
		try {
			Airport airport = new Airport(null, null);

			System.out
					.println("Enter ‘quit’ at any prompt to cancel operation.");
			System.out.println("");

			String input = "";

			String iataCode = "";
			String city = "";

			Integer step = 0;
			while (!input.equals("quit")) {
				switch (step) {
					case 0 :
						System.out.println(
								"Enter IATA Code (ex. ATL) HAS TO BE 3 CHARACTERS:");
						input = Utils.getInput();
						iataCode = input;
						step++;
						break;

					case 1 :
						System.out.println("Please enter City (ex. Atlanta):");
						input = Utils.getInput();
						city = input;
						step++;
						break;

					case 2 :
						if (iataCode.length() == 3
								&& iataCode.matches("[a-zA-Z]+")) {
							airport.setIataId(iataCode.toUpperCase());
							airport.setCity(city);

							try {
								service.addAirport(airport);
								System.out.println("Airport Added!");
							} catch (SQLIntegrityConstraintViolationException e) {
								System.out.println("");
								System.out.println("Duplicate entry.");
							}
							ViewHandler.getInstance().goBack();
						} else {
							System.out.println("Error parsing airport.");
						}
						ViewHandler.getInstance().goBack();
						break;
				}

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ViewHandler.getInstance().goBack();
	}

	@Override
	public void fetchUpdatedData() {
		// TODO Auto-generated method stub

	}

}
