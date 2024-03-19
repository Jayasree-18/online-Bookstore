package test;
import static test.DBInfo.*;
import java.sql.Connection;
import java.sql.DriverManager;
public class DBConnection {
	private static Connection con = null;
	private DBConnection() {}
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection(dbUrl,uName,pWord);
		}catch(Exception e) {e.printStackTrace();}
	}
	public static Connection getCon() {
		return con;
	}
}
