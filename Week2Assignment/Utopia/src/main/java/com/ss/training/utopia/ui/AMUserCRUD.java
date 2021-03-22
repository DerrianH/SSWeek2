/**
 * 
 */
package com.ss.training.utopia.ui;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

import com.ss.training.utopia.entity.User;

/**
 * @author derrianharris
 *
 */
public class AMUserCRUD extends BaseMenu {
	Integer roleId;

	public AMUserCRUD(Integer roleID) {
		this.roleId = roleID;
	}

	@Override
	public void display() {
		try {
			List<User> users = service.getAllUserByRoleId(roleId);
			List<String> output = users.stream().map(User::toString)
					.collect(Collectors.toList());

			if (users.size() < 1) {
				System.out.println("No Users found!");
			}

			output.add("Add User");
			output.add("Quit to previous");
			System.out.println(Utils.FormatOptions(output));
			String input = Utils.getInputRange(1, output.size());
			Integer outputSize = Integer.valueOf(output.size());
			if (input.equals(outputSize.toString())) {
				ViewHandler.getInstance().goBack();
				return;
			}

			if (input.equals(Integer.valueOf(outputSize - 1).toString())) {
				ViewHandler.getInstance().goToMenu(new AMUserCRUDAdd(roleId));
				return;
			}
			ViewHandler.getInstance().goToMenu(
					new AMUserCRUDEdit(users.get(Integer.parseInt(input) - 1)));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void fetchUpdatedData() {
		// TODO Auto-generated method stub

	}

}
