/**
 * 
 */
package com.ss.training.utopia.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.training.utopia.entity.Airport;

/**
 * @author derrianharris
 *
 */
public class AirportDAO extends BaseDAO<Airport> {

	public AirportDAO(Connection conn) {
		super(conn);
	}

	public void addData(Airport airport) throws ClassNotFoundException, SQLException {
		executeQuery("insert into airport values (?, ?)", new Object[] { airport.getIataId(), airport.getCity()});
	}

	public void updateData(Airport airport) throws ClassNotFoundException, SQLException {
		executeQuery("update airport set city = ? where id = ?", new Object[] {airport.getCity(),airport.getIataId()});
	}

	public void deleteData(Airport airport) throws ClassNotFoundException, SQLException {
		executeQuery("delete from airport where iata_id = ?", new Object[] {airport.getIataId()});
	}
	
	@Override
	protected List<Airport> extractData(ResultSet rs)
			throws ClassNotFoundException, SQLException {
		List<Airport> airports = new ArrayList<Airport>();
		System.out.println("extractData");
		
		while(rs.next()) {
			String id = rs.getString("iata_id");
			String city = rs.getString("city");
			Airport airport = new Airport(id,city);
			
			airports.add(airport);
		}
		return airports;
	}
}
