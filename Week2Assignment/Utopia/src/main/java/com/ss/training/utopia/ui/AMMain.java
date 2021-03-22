/**
 * 
 */
package com.ss.training.utopia.ui;

/**
 * @author derrianharris
 *
 */
public class AMMain extends BaseMenu {
	public AMMain() {
		super();
	}

	@Override
	public void display() {
		System.out.println(Utils.FormatOptions("Add/Update/Delete/Read Flights",
				"Add/Update/Delete/Read Tickets and Passengers",
				"Add/Update/Delete/Read Airports",
				"Add/Update/Delete/Read Travelers",
				"Add/Update/Delete/Read Employees", "Quit to previous"));

		String input = Utils.getInputRange(1, 8);

		switch (input) {
			case "1" :
				ViewHandler.getInstance().goToMenu(new AMFlightCRUD());
				break;
			case "2" :
				ViewHandler.getInstance().goToMenu(new AMBookingCRUD());
				break;
			case "3" :
				ViewHandler.getInstance().goToMenu(new AMAirportCRUD());
				break;
			case "4" :
				ViewHandler.getInstance().goToMenu(new AMUserCRUD(1));
				break;
			case "5" :
				ViewHandler.getInstance().goToMenu(new AMAgentCRUD(2));
				break;
			case "6" :
				ViewHandler.getInstance().goBack();
				break;
		}
	}

	@Override
	public void fetchUpdatedData() {
		// TODO Auto-generated method stub

	}

}
