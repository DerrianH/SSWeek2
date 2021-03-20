/**
 * 
 */
package com.ss.training.utopia.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import com.ss.training.utopia.entity.User;

/**
 * @author derrianharris
 *
 */
public class UserDOA extends BaseDAO<User> {

	public UserDOA(Connection conn) {
		super(conn);
	}

	public void addData(User user)
			throws ClassNotFoundException, SQLException {
		executeQuery("insert into user values (?, ?, ?, ?, ?, ?, ?)",
				new Object[]{user.getRoleId(), user.getFirstName(), user.getLastName(), user.getUsername(), user.getEmail(),user.getPassword(),user.getPhone()});
	}

	public void updateData(User user)
			throws ClassNotFoundException, SQLException {
		executeQuery(
				"update user set role_id = ?,given_name = ?,family_name = ?,username = ?,email = ?,password = ?,phone = ? where id = ?",
				new Object[]{user.getRoleId(), user.getFirstName(), user.getLastName(), user.getUsername(), user.getEmail(),user.getPassword(),user.getPhone(), user.getId()});
	}

	public void deleteData(User user)
			throws ClassNotFoundException, SQLException {
		executeQuery("delete from user where id = ?",
				new Object[]{user.getId()});
	}

	@Override
	protected List<User> extractData(ResultSet rs)
			throws ClassNotFoundException, SQLException {
		List<User> users = new ArrayList<User>();
		System.out.println("extractData");

		while (rs.next()) {
			Integer id = rs.getInt("id");
			Integer roleId = rs.getInt("booking_id");
			String firstName = rs.getString("given_name");
			String lastName = rs.getString("family_name");
			String username = rs.getString("username");
			String email = rs.getString("email");
			String password = rs.getString("password");
			String phone = rs.getString("phone");
			User user = new User(id, roleId, firstName, lastName, username, email, password,phone);
			users.add(user);
		}
		return users;
	}
}
