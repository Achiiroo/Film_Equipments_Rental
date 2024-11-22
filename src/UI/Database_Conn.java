
package UI;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database_Conn {
    private static final String URL = "jdbc:mysql://localhost:3306/fers";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    
    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("Database driver not found: " + e.getMessage());
        }

        // Return the connection
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
