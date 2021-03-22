package com.ss.training.utopia.ui;

import java.sql.SQLException;

import com.ss.training.utopia.entity.Airport;

public class AMAirportCRUDDelete extends AMAirportCRUDEdit {

	public AMAirportCRUDDelete(Airport airport) {
		super(airport);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void display() {
		fetchUpdatedData(airport);
		System.out.println("Are you sure: Y or N");

		String input = Utils.getInput(false, "y", "n").toLowerCase();

		switch (input) {
			case "y" :
				try {
					service.deleteAirport(airport);
					System.out.println("Airport Deleted!");
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

	@Override
	public void fetchUpdatedData() {
		// TODO Auto-generated method stub

	}

}
