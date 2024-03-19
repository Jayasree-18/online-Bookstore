package test;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class OrderBookDAO {
	public int k = 0;
	public int order(BookBean bb) {
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement
				("Update BookDetails57 set qty=? where code=?");
			ps.setInt(1, bb.getQty());
			ps.setString(2, bb.getCode());
			k = ps.executeUpdate();
		}catch(Exception e) {e.printStackTrace();}
		return k;
	}
}
