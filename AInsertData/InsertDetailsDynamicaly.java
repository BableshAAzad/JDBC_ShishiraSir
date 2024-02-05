package AInsertData;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertDetailsDynamicaly {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Load the driver
            String url = "jdbc:mysql://localhost:3306/aazaddb";
            String username = "root";
            String password = "root";
            Connection con = DriverManager.getConnection(url, username, password); // connection stablise
            String q = "insert into bable(tName, tCity) values(?, ?)"; // create a dynamic query
            PreparedStatement pstmt = con.prepareStatement(q); // get the PreparedStatement object
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // Create object
            System.out.println("Enter Name : ");
            String name = br.readLine();
            System.out.println("Enter City : ");
            String city = br.readLine();
            pstmt.setString(1, name); // enter data from user 
            pstmt.setString(2, city);
            pstmt.executeUpdate();
            System.out.println("Inserted.....");
            con.close();
        } catch (ClassNotFoundException e) { // for Driver class
            e.printStackTrace();
        } catch (SQLException e) {  // for DriverManager
            e.printStackTrace();
        } catch (IOException e) {  // for BufferedReader
            e.printStackTrace();
        }
    }
}
