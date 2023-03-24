/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Database.conectorDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.Persona;

/**
 *
 * @author hp
 */
public class Ctrl_Persona {

    private Persona persona;

    public Ctrl_Persona(Persona persona) {
        this.persona = persona;
    }
    public static Integer buscarCiEnDB(String nombre){
        String sql="SELECT CI FROM PERSONA WHERE NOMBRE="+'"'+nombre+'"';
        Integer ci=null;
        Connection con= new conectorDB().concectar();
        try {
            PreparedStatement stmt= con.prepareStatement(sql);
            ResultSet res= stmt.executeQuery();
            if (res.next()) {
               ci=res.getInt("CI");
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "\n" + ex.getErrorCode() + "\n" + ex.getMessage());
        }
        return ci;
        
    }
}
