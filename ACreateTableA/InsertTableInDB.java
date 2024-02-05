// package AAACreateTable;

// import java.sql.Connection;
// import java.sql.DriverManager;
// import java.sql.SQLException;
// import java.sql.Statement;
import java.sql.*;

public class InsertTableInDB {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Load to driver
            String url = "jdbc:mysql://localhost:3306/aazaddb";
            String username = "root";
            String password = "root";
            Connection con = DriverManager.getConnection(url, username, password); // create connction
            String q = "create table bable(tId int(20) primary key auto_increment, tName varchar(200) not null, tCity varchar(400))";
            Statement stmt = con.createStatement(); // Create Statement
            stmt.executeUpdate(q);
            System.out.println("Table1 is created in database.....");
            con.close();
        } catch (ClassNotFoundException e) { // for load Driver
            e.printStackTrace();
        } catch (SQLException e) { // for DriverManager
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
