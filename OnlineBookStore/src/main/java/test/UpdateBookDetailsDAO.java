package test;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UpdateBookDetailsDAO {
	public int k=0;
	public int update(BookBean bb) {
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement
					("update BookDetails57 set price=?,qty=? where code=?");
			ps.setFloat(1, bb.getPrice());
			ps.setInt(2, bb.getQty());
			ps.setString(3, bb.getCode());
			k=ps.executeUpdate();
		}catch(Exception e) {e.printStackTrace();}
		return k;
		
	}
}
