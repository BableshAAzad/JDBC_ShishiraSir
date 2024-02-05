package AInsertImagaeInDataBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ImageSaveInDB {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/aazaddb";
            String username = "root";
            String password = "root";
            Connection con = DriverManager.getConnection(url, username, password);
            String q = "insert into images(pic) values(?)";
            PreparedStatement pstmt = con.prepareStatement(q);
            // pstmt .setString(1, "value");
            FileInputStream fis = new FileInputStream("./RawData/mypic.jpg");
            pstmt.setBinaryStream(1, fis, fis.available());
            pstmt.executeUpdate();
            System.out.println("Image Inserted.....");
            con.close();
        } catch (ClassNotFoundException e) { // for Driver class
            e.printStackTrace();
        } catch (SQLException e) { // For DriverManager
            e.printStackTrace();
        } catch (FileNotFoundException e) { // for FileInputStream
            e.printStackTrace();
        } catch (IOException e) { // for setBinarInputStream
            e.printStackTrace();
        }
    }
}
