/**
 * 
 */
package com.ss.training.utopia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @author derrianharris
 *
 */
public abstract class BaseDAO<T> {
	protected Connection conn = null;

	public BaseDAO(Connection conn) {
		this.conn = conn;
	}
	
	public abstract void addData(T data) throws ClassNotFoundException, SQLException ;

	public abstract void updateData(T data) throws ClassNotFoundException, SQLException ;

	public abstract void deleteData(T data) throws ClassNotFoundException, SQLException ;

	public void executeQuery(String sql, Object[] vals)
			throws ClassNotFoundException, SQLException {
		PreparedStatement pstmt = conn.prepareStatement(sql);
		int count = 1;
		for (Object o : vals) {
			pstmt.setObject(count, o);
			count++;
		}
		pstmt.executeUpdate();
	}
	
	public List<T> readDataQuery(String sql, Object[] vals)
			throws ClassNotFoundException, SQLException {
		PreparedStatement pstmt = conn.prepareStatement(sql);
		int count = 1;
		for (Object o : vals) {
			pstmt.setObject(count, o);
			count++;
		}
		ResultSet rs = pstmt.executeQuery();
		return extractData(rs);
	}
	
	public List<T> readDataQuery(String sql)
			throws ClassNotFoundException, SQLException {
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		return extractData(rs);
	}

	abstract protected List<T> extractData(ResultSet rs)
			throws ClassNotFoundException, SQLException;

}
