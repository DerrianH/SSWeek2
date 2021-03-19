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
import com.ss.training.utopia.entity.AirplaneType;

/**
 * @author derrianharris
 *
 */
public class AirplaneDAO extends BaseDAO<Airplane> {

	public AirplaneDAO(Connection conn) {
		super(conn);
	}

	@Override
	public List<Airplane> extractData(ResultSet rs)
			throws ClassNotFoundException, SQLException {
		List<Airplane> airplanes = new ArrayList<Airplane>();
		System.out.println("extractData");
		
		while(rs.next()) {
			Integer id = rs.getInt(1);
			
			AirplaneType airportType = new AirplaneType(,);
			System.out.println(obj.getClass());
			
			//airplanes.add(new Airplane(,));
		}
		return airplanes;
	}

}
