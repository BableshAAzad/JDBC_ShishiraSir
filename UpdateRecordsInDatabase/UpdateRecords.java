package UpdateRecordsInDatabase;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;

import AInsertLongImagaeInDataBase.ConnectionProvider;

public class UpdateRecords {
    public static void main(String[] args) {
        try {

            Connection con = ConnectionProvider.getConnectionN();
            String q = "update bable set tName = ?, tCity = ? where tId = ?";
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Enter new Name : ");
            String name = br.readLine();

            System.out.println("Enter City : ");
            String city = br.readLine();

            System.out.println("Inter Id : ");
            int id = Integer.parseInt(br.readLine());

            PreparedStatement pstmt = con.prepareStatement(q);
            pstmt.setString(1, name);
            pstmt.setString(2, city);
            pstmt.setInt(3, id);

            pstmt.executeUpdate();
            System.out.println("Record updated ......... ");
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
