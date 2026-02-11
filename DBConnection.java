import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    public static Connection getConnection() {
        try {
            Connection c = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/staffstudentdb",
                "root",
                "0103"
            );
            return c;
        } catch (Exception e) {
            System.out.println("Connection Error: " + e);
            return null;
        }
    }
}
