import java.sql.Connection;
import java.sql.DriverManager;

class FirstJDBC {
    public static void main(String[] args) {
        try {
            // ! Load the driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // ! Create a connetion
            String url = "jdbc:mysql://localhost:3306/aazaddb";
            String username = "root";
            String password = "root";
            Connection con = DriverManager.getConnection(url, username, password);
            if (con.isClosed()) {
                System.out.println("Connection is Closed");
            } else {
                System.out.println("Connection created ............");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
