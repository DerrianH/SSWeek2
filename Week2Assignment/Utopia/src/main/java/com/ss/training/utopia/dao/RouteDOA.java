/**
 * 
 */
package com.ss.training.utopia.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.ss.training.utopia.entity.Route;

/**
 * @author derrianharris
 *
 */
public class RouteDOA extends BaseDAO<Route> {

	public RouteDOA(Connection conn) {
		super(conn);
	}

	public void addData(Route route) throws ClassNotFoundException, SQLException {
		executeQuery("insert into route values (?, ?)", new Object[] { route.getOriginIataId(), route.getDestinationIataId()});
	}

	public void updateData(Route route) throws ClassNotFoundException, SQLException {
		executeQuery("update route set origin_id = ?, destination_id = ? where id = ?", new Object[] {route.getOriginIataId(), route.getDestinationIataId(), route.getId()});
	}

	public void deleteData(Route route) throws ClassNotFoundException, SQLException {
		executeQuery("delete from route where id = ?", new Object[] {route.getId()});
	}
	
	@Override
	protected List<Route> extractData(ResultSet rs)
			throws ClassNotFoundException, SQLException {
		List<Route> routes = new ArrayList<Route>();
		System.out.println("extractData");
		
		while(rs.next()) {
			Integer id = rs.getInt("id");
			String originIataId = rs.getString("origin_id");
			String destinationIataId = rs.getString("destination_id");
			Route bookingGuest = new Route(id, originIataId, destinationIataId);
			
			routes.add(bookingGuest);
		}
		return routes;
	}
}
