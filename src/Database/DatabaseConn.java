/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;

import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConn {
    public static Connection connect(){
        String url = "jdbc:MySQL://localhost:3306/fers";
        String user = "root";
        String pass = "";
        try {
            return DriverManager.getConnection(url,user,pass);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error connecting to the Database: " + e.getMessage());
            return null;
        }
    }
}
