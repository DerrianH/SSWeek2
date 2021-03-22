/**
 * 
 */
package com.ss.training.utopia.ui;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import com.ss.training.utopia.entity.User;

/**
 * @author derrianharris
 *
 */
public class AMUserCRUDUpdate extends AMUserCRUDEdit {

	public AMUserCRUDUpdate(User user) {
		super(user);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void display() {
		fetchUpdatedData(user);
		System.out.println("Enter ‘quit’ at any prompt to cancel operation.");
		System.out.println("");

		String input = "";
		String roleId = "";
		String firstName = "";
		String lastName = "";
		String username = "";
		String password = "";
		String email = "";
		String phone = "";

		Integer step = 0;
		while (!input.equals("quit")) {
			switch (step) {
				case 0 :
					System.out.println(
							"Please enter Role Id or enter N/A for no change (ex. 1 for Travaler, 2 for Employee): ");
					input = Utils.getInput();
					roleId = input;
					step++;
					break;
				case 1 :
					System.out.println(
							"Please enter First Name or enter N/A for no change: ");
					input = Utils.getInput();
					firstName = input;
					step++;
					break;

				case 2 :
					System.out.println(
							"Please enter Last Name or enter N/A for no change: ");
					input = Utils.getInput();
					lastName = input;
					step++;
					break;

				case 3 :
					System.out.println(
							"Please enter Username or enter N/A for no change:");
					input = Utils.getInput();
					username = input;
					step++;
					break;

				case 4 :
					System.out.println(
							"Please enter Password or enter N/A for no change:");
					input = Utils.getPassInput();
					password = input;
					step++;
					break;
				case 5 :
					System.out.println(
							"Please enter email or enter N/A for no change: ");
					input = Utils.getInput();
					email = input;
					step++;
					break;

				case 6 :
					System.out.println(
							"Please enter Address or enter N/A for no change: ");
					input = Utils.getInput();
					phone = input;
					step++;
					break;
				case 7 :
					if (!roleId.toLowerCase().equals("n/a")) {
						user.setRoleId(Integer.parseInt(roleId));
					}
					if (!firstName.toLowerCase().equals("n/a")) {
						user.setFirstName(firstName);
					}

					if (!lastName.toLowerCase().equals("n/a")) {
						user.setLastName(lastName);
					}

					if (!username.toLowerCase().equals("n/a")) {
						user.setUsername(username);
					}

					if (!password.toLowerCase().equals("n/a")) {
						user.setPassword(password);
					}

					if (!email.toLowerCase().equals("n/a")) {
						user.setEmail(email);
					}

					if (!phone.toLowerCase().equals("n/a")) {
						user.setPhone(phone);
					}

					try {
						service.updateUser(user);
					} catch (SQLIntegrityConstraintViolationException e) {
						System.out.println("");
						System.out.println("Duplicate entry.");
					} catch (SQLException e) {
						e.printStackTrace();
					}
					input = "quit";
					ViewHandler.getInstance().goBack();
					break;
			}
		}
	}

}
