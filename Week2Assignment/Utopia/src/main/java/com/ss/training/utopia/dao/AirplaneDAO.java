/**
 * 
 */
package com.ss.training.utopia.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.training.utopia.entity.Airplane;

/**
 * @author derrianharris
 *
 */
public class AirplaneDAO extends BaseDAO<Airplane> {

	public AirplaneDAO(Connection conn) {
		super(conn);
	}
	
	public void addData(Airplane airplane) throws ClassNotFoundException, SQLException {
		executeQuery("insert into airplane values (?)", new Object[] { airplane.getTypeId()});
	}

	public void updateData(Airplane airplane) throws ClassNotFoundException, SQLException {
		executeQuery("update airplane set type_id = ? where id = ?", new Object[] {airplane.getTypeId(),airplane.getId()});
	}

	public void deleteData(Airplane airport) throws ClassNotFoundException, SQLException {
		executeQuery("delete from airplane where id = ?", new Object[] {airport.getId()});
	}
	
	@Override
	protected List<Airplane> extractData(ResultSet rs)
			throws ClassNotFoundException, SQLException {
		List<Airplane> airplanes = new ArrayList<Airplane>();
		System.out.println("extractData");
		
		while(rs.next()) {
			Integer id = rs.getInt("id");
			Integer airplaneType = rs.getInt("type_id");
			Airplane airplane = new Airplane(id,airplaneType);
			
			airplanes.add(airplane);
		}
		return airplanes;
	}

}
