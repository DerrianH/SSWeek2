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
public class AMUserCRUDAdd extends AMUserCRUD {

	public AMUserCRUDAdd(Integer roleID) {
		super(roleID);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void display() {

		User user = new User(0, roleId, null, null, null, null, null, null);
		System.out.println("Enter ‘quit’ at any prompt to cancel operation.");
		System.out.println("");

		String input = "";
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
					System.out.println("Please enter First Name: ");
					input = Utils.getInput();
					firstName = input;
					step++;
					break;

				case 1 :
					System.out.println("Please enter Last Name: ");
					input = Utils.getInput();
					lastName = input;
					step++;
					break;

				case 2 :
					System.out.println("Please enter Username:");
					input = Utils.getInput();
					username = input;
					step++;
					break;

				case 3 :
					System.out.println("Please enter Password:");
					input = Utils.getPassInput();
					password = input;
					step++;
					break;
				case 4 :
					System.out.println("Please enter email: ");
					input = Utils.getInput();
					email = input;
					step++;
					break;

				case 5 :
					System.out.println("Please enter Address: ");
					input = Utils.getInput();
					phone = input;
					step++;
					break;
				case 6 :
					user.setFirstName(firstName);
					user.setLastName(lastName);
					user.setUsername(username);
					user.setPassword(password);
					user.setEmail(email);
					user.setPhone(phone);
					try {
						service.addUser(user);
						System.out.println("User Added!");
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
		ViewHandler.getInstance().goBack();
	}

	@Override
	public void fetchUpdatedData() {
		// TODO Auto-generated method stub

	}

}
