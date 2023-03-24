/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hp
 */
public class conectorDB {
/*
    host:"localhost",
    user:"root",
    database:"contacto",
    password:"root12",
    */
    private String name="ventas";
    private String url="jdbc:mysql://localhost/SISTEMADEINVENTARIO";
    private String user="root";
    private String password="root12";
    private String driver="com.mysql.cj.jdbc.Driver";
    private Connection cx;

    public conectorDB() {
        
    }
    public Connection concectar(){
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex ) {
            Logger.getLogger(conectorDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            cx= DriverManager.getConnection(url, user, password);
           
           
            
        } catch (SQLException ex) {
            Logger.getLogger(conectorDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cx;
    }
    
}
