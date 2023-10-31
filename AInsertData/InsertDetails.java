package AInsertData;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertDetails {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Load the driver
            String url = "jdbc:mysql://localhost:3306/aazaddb";
            String username = "root";
            String password = "AAzad@12345";
            Connection con = DriverManager.getConnection(url, username, password); // connection stablise
            String q = "insert into bable(tName, tCity) values(?, ?)"; // create a dynamic query
            PreparedStatement pstmt = con.prepareStatement(q); // get the PreparedStatement object
            pstmt.setString(1, "Durgesh"); // set the values to query
            pstmt.setString(2, "Bhilai"); // tName and tCity both are string then setString mehtod
            pstmt.executeUpdate();
            System.out.println("Inserted.....");
            con.close();
        } catch (ClassNotFoundException e) { 
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
