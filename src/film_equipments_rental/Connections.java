
package film_equipments_rental;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Connections {
    static Connection con;
    public static Connection getConnetion(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:MySQL://localhost:3306/user_database", "root", "");
            Statement st = con.createStatement();
        } catch (Exception ex) {
            System.out.println(""+ex);
        }
        return con;
    }
}
