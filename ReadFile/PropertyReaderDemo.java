import java.io.FileReader;
import java.util.Properties;

public class PropertyReaderDemo {
    public static void main(String[] args) {
        Properties props = new Properties();
        try {
            FileReader reader = new FileReader("RawData/LoginData.properties");
            props.load(reader);
            String userName = props.getProperty("user");
            System.out.println("DB user name : " + userName);
            String password = props.getProperty("password");
            System.out.println("DB password : " + password);
            String port = props.getProperty("port");
            System.out.println("DB port : " + port);
            String cloudPath = props.getProperty("cloudPath");
            System.out.println("DB port : " + cloudPath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /*
     * Output :
     * DB user name : scott
     * DB password : tiger
     * DB port : 1521
     * DB port : null
     */
}
