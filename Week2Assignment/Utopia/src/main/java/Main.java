import java.sql.SQLException;
import com.ss.training.utopia.ui.*;

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
	 * @throws SQLException
	 */
	public static void main(String[] args) throws SQLException {
		ViewHandler.getInstance().start();
	}
}
