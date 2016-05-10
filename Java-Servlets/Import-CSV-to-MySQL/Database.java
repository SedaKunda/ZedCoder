import java.sql.*;
import javax.servlet.http.HttpServlet;

public class Database extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection dataSource;

	public Connection dbConn() throws SQLException  {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			dataSource = DriverManager.getConnection("jdbc:mysql://localhost:3306/yourdb", "yourusername", "yourpassword");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return dataSource;
	}
	}
