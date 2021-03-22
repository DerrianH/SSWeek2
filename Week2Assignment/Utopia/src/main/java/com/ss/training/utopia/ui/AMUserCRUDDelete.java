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
public class AMUserCRUDDelete extends AMUserCRUDEdit {

	public AMUserCRUDDelete(User User) {
		super(User);
	}

	@Override
	public void display() {
		fetchUpdatedData();
		System.out.println("Are you sure: Y or N");

		String input = Utils.getInput(false, "y", "n").toLowerCase();

		switch (input) {
			case "y" :
				try {
					service.deleteUser(user);
					System.out.println("User Deleted!");
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
}
