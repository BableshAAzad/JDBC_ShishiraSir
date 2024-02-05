package ASelectDataAndPrint;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SelectDataPrint {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/aazaddb";
            String username = "root";
            String password = "root";
            Connection con = DriverManager.getConnection(url, username, password);
            String query = "select * from bable";
            Statement stmt = con.createStatement();
            ResultSet set = stmt.executeQuery(query);
            while (set.next()) {
                int id = set.getInt(1);
                String name = set.getString(2);
                String address = set.getString(3);
                System.out.println("Id : " + id + ", Name : " + name + ", Address : " + address);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
