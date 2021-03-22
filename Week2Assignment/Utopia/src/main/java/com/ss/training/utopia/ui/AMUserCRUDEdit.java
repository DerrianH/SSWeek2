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
public class AMUserCRUDEdit extends BaseMenu {

	User user;
	public AMUserCRUDEdit(User user) {
		super();
		this.user = user;
	}

	@Override
	public void display() {
		fetchUpdatedData(user);
		System.out.println(Utils.FormatOptions("Update User", "Delete User",
				"Quit to previous"));
		String input = Utils.getInputRange(1, 3);

		switch (input) {
			case "1" :
				ViewHandler.getInstance().goToMenu(new AMUserCRUDUpdate(user));
				break;
			case "2" :
				ViewHandler.getInstance().goToMenu(new AMUserCRUDDelete(user));
				break;
			case "3" :
				ViewHandler.getInstance().goBack();
				break;
		}
	}

	@Override
	public void fetchUpdatedData() {
		// TODO Auto-generated method stub

	}

	public void fetchUpdatedData(User user) {
		try {
			this.user = service.getUserFromId(user.getId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
