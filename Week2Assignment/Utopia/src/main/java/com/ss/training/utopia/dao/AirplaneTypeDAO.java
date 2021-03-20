/**
 * 
 */
package com.ss.training.utopia.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.training.utopia.entity.AirplaneType;

/**
 * @author derrianharris
 *
 */
public class AirplaneTypeDAO extends BaseDAO<AirplaneType> {

	public AirplaneTypeDAO(Connection conn) {
		super(conn);
	}
	
	public void addData(AirplaneType type) throws ClassNotFoundException, SQLException {
		executeQuery("insert into airplane_type values (?)", new Object[] {type.getMaxCapacity()});
	}

	public void updateData(AirplaneType type) throws ClassNotFoundException, SQLException {
		executeQuery("update airplane_type set max_capacity = ? where id = ?", new Object[] {type.getMaxCapacity(),type.getId()});
	}

	public void deleteData(AirplaneType type) throws ClassNotFoundException, SQLException {
		executeQuery("delete from airplane_type where id = ?", new Object[] {type.getId()});
	}
	
	@Override
	protected List<AirplaneType> extractData(ResultSet rs)
			throws ClassNotFoundException, SQLException {
		List<AirplaneType> airplaneTypes = new ArrayList<AirplaneType>();
		System.out.println("extractData");
		
		while(rs.next()) {
			Integer id = rs.getInt("id");
			Integer maxCapacity = rs.getInt("max_capacity");
			AirplaneType airplaneType = new AirplaneType(id,maxCapacity);
			
			airplaneTypes.add(airplaneType);
		}
		return airplaneTypes;
	}

}
