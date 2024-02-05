package AInsertData;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertDetailsDynamicaly1 {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Load the driver
            String url = "jdbc:mysql://localhost:3306/aazaddb";
            String username = "root";
            String password = "root";
            Connection con = DriverManager.getConnection(url, username, password); // connection stablise
            String q = "insert into bable(tName, tCity) values(?, ?)"; // create a dynamic query
            PreparedStatement pstmt = con.prepareStatement(q); // get the PreparedStatement object
            Scanner sc = new Scanner(System.in); // Create object
            System.out.println("Enter Name : ");
            String name = sc.next();
            System.out.println("Enter City : ");
            String city = sc.next();
            pstmt.setString(1, name); // enter data from user
            pstmt.setString(2, city);
            pstmt.executeUpdate();
            System.out.println("Inserted.....");
            con.close();
            sc.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
