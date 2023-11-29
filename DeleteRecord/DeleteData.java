import java.io.FileReader;
import java.sql.*;
import java.util.*;

public class DeleteData {
	public static void main(String[] args) {
		Properties pr = new Properties();
		String query = "delete from kadeerdb.kadeer where kproduct<4";
		try {
			FileReader fr = new FileReader("RawData/props.properties");
			pr.load(fr);
			String url = pr.getProperty("URL");
			String userN = pr.getProperty("userName");
			String pass = pr.getProperty("password");
			String drc = pr.getProperty("driveClass");
			Class.forName(drc);
			Connection con = DriverManager.getConnection(url, userN, pass);
			PreparedStatement pstmt = con.prepareStatement(query);
			int res = pstmt.executeUpdate();
			System.out.println(res + " Records deleted");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}