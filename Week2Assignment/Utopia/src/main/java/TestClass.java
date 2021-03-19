import java.sql.Connection;
import java.sql.SQLException;

import com.ss.training.utopia.dao.AirplaneDAO;
import com.ss.training.utopia.service.Utils;

/**
 * 
 */

/**
 * @author derrianharris
 *
 */
public class TestClass {

	/**
	 * 
	 */
	public TestClass() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Utils util = new Utils();
		try {
			Connection conn = util.getConnection();
			AirplaneDAO adao = new AirplaneDAO(conn);
			
			adao.readDataQuery("select * from airplane");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			System.out.println("Done");
		}
	}

}
