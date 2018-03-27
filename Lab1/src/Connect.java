import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {
	
	public static Connection connect() {
		
		Connection con = null;
		
        String password = "1234567890";
        String user = "Lab1";
        String url = "jdbc:mysql://localhost:3306/Lab1?user=" + user 
        		+ "&password=" + password;
        try {
        	con = DriverManager.getConnection(url);		
        	if (con != null) {
        		System.out.println("Connected");
        	}
		} catch (SQLException e) {
			System.out.println("Database Connection Failed");
        }
        return con;
	}
}
