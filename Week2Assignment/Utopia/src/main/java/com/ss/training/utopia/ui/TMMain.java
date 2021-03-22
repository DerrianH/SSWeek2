/**
 * 
 */
package com.ss.training.utopia.ui;

import java.sql.SQLException;

import com.ss.training.utopia.entity.User;

/**
 * @author derrianharris
 *
 */
public class TMMain extends BaseMenu {
	User user = null;
	public TMMain() {
		super();
	}

	@Override
	public void display() {
		if (user == null) {
			System.out.println("Enter you Username and Password: ");
			System.out.print("Username: ");
			String username = Utils.getInput();
			System.out.print("Password: ");
			String password = Utils.getPassInput();

			try {
				user = service.getUserFromUserAndPass(username, password);
			} catch (SQLException | IndexOutOfBoundsException e) {
				System.out.println("Username or Password are incorrect.");
				ViewHandler.getInstance().goBack();
			}
		}

		System.out.println(Utils.FormatOptions("Book a Ticket",
				"Cancel an Upcoming Trip", "Quit to Previous"));
		String input = Utils.getInputRange(1, 3);
		switch (input) {
			case "1" :
				ViewHandler.getInstance().goToMenu(new TMBookTicketList(user));
				break;
			case "2" :
				ViewHandler.getInstance()
						.goToMenu(new TMCancelTicketList(user));
				break;
			case "3" :
				ViewHandler.getInstance().goBack();
				break;
		}
	}

	@Override
	public void fetchUpdatedData() {

	}

}
