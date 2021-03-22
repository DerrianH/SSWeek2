/**
 * 
 */
package com.ss.training.utopia.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.training.utopia.entity.UserRole;

/**
 * @author derrianharris
 *
 */
public class UserRoleDAO extends BaseDAO<UserRole> {

	public UserRoleDAO(Connection conn, String tableName) {
		super(conn, tableName);
	}

	@Override
	public Integer addData(UserRole role)
			throws ClassNotFoundException, SQLException {
		return executeQueryPk("insert into user_role values (?)",
				new Object[]{role.getName()});
	}

	@Override
	public void deleteData(UserRole role)
			throws ClassNotFoundException, SQLException {
		executeQuery("delete from user_role where id = ?",
				new Object[]{role.getId()});
	}

	@Override
	protected List<UserRole> extractData(ResultSet rs)
			throws ClassNotFoundException, SQLException {
		List<UserRole> roles = new ArrayList<UserRole>();

		while (rs.next()) {
			Integer id = rs.getInt("id");
			String name = rs.getString("name");
			UserRole role = new UserRole(id, name);

			roles.add(role);
		}
		return roles;
	}

	@Override
	public void updateData(UserRole role)
			throws ClassNotFoundException, SQLException {
		executeQuery("update user_role set name = ? where id = ?",
				new Object[]{role.getName(), role.getId()});
	}
}
