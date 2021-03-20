import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.ss.training.utopia.dao.AirplaneDAO;
import com.ss.training.utopia.entity.Airplane;
import com.ss.training.utopia.service.Utils;

/**
 * 
 */

/**
 * @author derrianharris
 *
 */
public class Main {

	/**
	 * 
	 */
	public Main() {
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
			List<Airplane> planes = adao.readDataQuery("select * from airplane");
			
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
