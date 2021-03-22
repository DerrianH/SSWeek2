/**
 * 
 */
package com.ss.training.utopia.ui;

/**
 * @author derrianharris
 *
 */
public class EMMain extends BaseMenu {
	public EMMain() {
		super();
	}

	@Override
	public void display() {
		System.out.println(Utils.FormatOptions("Enter Flights You Manage",
				"Quit to previous"));

		String input = Utils.getInputRange(1, 2);

		switch (input) {
			case "1" :
				ViewHandler.getInstance().goToMenu(new EMFlightList());
				break;
			case "2" :
				ViewHandler.getInstance().goBack();
				break;
		}
	}

	@Override
	public void fetchUpdatedData() {
		// TODO Auto-generated method stub

	}

}
