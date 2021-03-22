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
public class AMAirportCRUDUpdate extends AMAirportCRUDEdit {
	public AMAirportCRUDUpdate(Airport airport) {
		super(airport);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void display() {
		try {
			fetchUpdatedData(airport);
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
								"Enter IATA Code (ex. ATL) HAS TO BE 3 CHARACTERS or n/a:");
						input = Utils.getInput();
						iataCode = input;
						step++;
						break;

					case 1 :
						System.out.println(
								"Please enter City or n/a (ex. Atlanta):");
						input = Utils.getInput();
						city = input;
						step++;
						break;

					case 2 :
						String oldIata = airport.getIataId();
						if (!iataCode.equals("n/a") && iataCode.length() == 3
								&& iataCode.matches("[a-zA-Z]+")) {
							airport.setIataId(iataCode.toUpperCase());
						}
						if (!city.equals("n/a")) {
							airport.setCity(city);
						}

						try {
							service.updateAirportFromOldIata(airport, oldIata);
							ViewHandler.getInstance().goBack(2);
						} catch (SQLIntegrityConstraintViolationException e) {
							System.out.println("");
							System.out.println("Duplicate entry.");
						}
						input = "quit";
						ViewHandler.getInstance().goBack();
						break;
				}

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

	@Override
	public void fetchUpdatedData() {
		// TODO Auto-generated method stub

	}

}
