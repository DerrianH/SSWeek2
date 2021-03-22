/**
 * 
 */
package com.ss.training.utopia.dao;

import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Savepoint;

import org.junit.Test;

import com.ss.training.utopia.entity.AirplaneType;
import com.ss.training.utopia.service.Utils;

/**
 * @author derrianharris
 *
 */
public class AirplaneTypeDAOTest extends BaseDAOTest{

	@Override
	@Test(expected = Exception.class)
	public void DataBaseTest() {
			Utils util = new Utils();
			Connection conn = null;
			try {
				conn = util.getConnection();
				Savepoint savePoint = conn.setSavepoint();
				AirplaneTypeDAO airplaneTypeDAO = new AirplaneTypeDAO(conn, "airplane_type");
				AirplaneType test1 = new AirplaneType(0, 0, 0, 0);
				AirplaneType test2;
				
				Integer id = airplaneTypeDAO.addData(test1);
				test1.setId(id);
				
				test2 = airplaneTypeDAO.getAirplaneTypeById(id);
				assertEquals(test1, test2);

				test1.setFirstClassCapacity(333);
				airplaneTypeDAO.updateData(test1);

				test2 = airplaneTypeDAO.getAirplaneTypeById(id);
				
				assertEquals(test1, test2);

				airplaneTypeDAO.deleteData(test1);
				test2 = airplaneTypeDAO.getAirplaneTypeById(id);
				
				conn.rollback(savePoint);

			} catch (ClassNotFoundException | SQLException e) {
				try {
					conn.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} finally {
				if (conn != null) {
					try {
						conn.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
		}
		
	}

}
