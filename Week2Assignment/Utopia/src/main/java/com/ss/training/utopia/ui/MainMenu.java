/**
 * 
 */
package com.ss.training.utopia.ui;

/**
 * @author derrianharris
 *
 */
public class MainMenu extends BaseMenu {
	public MainMenu() {
		super();
	}

	@Override
	public void display() {
		System.out.println("Welcome to the Utopia Airlines Management System.");
		System.out.println("Which category of a user are you: ");
		System.out.println(Utils.FormatOptions(
				new String[]{"Employee", "Administrator", "Traveler", "Quit"}));
		String input = Utils.getInputRange(1, 4);
		switch (input) {
			case "1" :
				ViewHandler.getInstance().goToMenu(new EMMain());
				break;
			case "2" :
				ViewHandler.getInstance().goToMenu(new AMMain());
				break;
			case "3" :
				ViewHandler.getInstance().goToMenu(new TMMain());
				break;
		}
	}

	@Override
	public void fetchUpdatedData() {
		// TODO Auto-generated method stub

	}

}
