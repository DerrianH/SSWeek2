/**
 * 
 */
package com.ss.training.utopia.dao;

import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Savepoint;

import org.junit.Test;

import com.ss.training.utopia.entity.Airplane;
import com.ss.training.utopia.service.Utils;

/**
 * @author derrianharris
 *
 */

public class AirplaneDAOTest extends BaseDAOTest {

	@Override
	@Test//(expected = Exception.class)
	public void DataBaseTest() {
		Utils util = new Utils();
		Connection conn = null;
		try {
			conn = util.getConnection();
			Savepoint savePoint = conn.setSavepoint();
			AirplaneDAO airplaneDAO = new AirplaneDAO(conn, "airplane");
			Airplane test1 = new Airplane(0, 0);
			Airplane test2;
			Integer id = airplaneDAO.addData(test1);

			test2 = airplaneDAO.getAirplaneById(id);
			assertEquals(test1, test2);

			test1.setTypeId(444);
			airplaneDAO.updateData(test1);

			test2 = airplaneDAO.getAirplaneById(id);
			assertEquals(test1, test2);

			airplaneDAO.deleteData(test1);
			test2 = airplaneDAO.getAirplaneById(id);

			conn.rollback(savePoint);

		} catch (ClassNotFoundException | SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
