/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Database.conectorDB;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.Cliente;

/**
 *
 * @author hp
 */
public class Ctrl_Cliente {

    private Cliente cliente;

    public Ctrl_Cliente(Cliente cliente) {
        this.cliente = cliente;
        insertar();
    }

    /*CI INT NOT NULL,
NOMBRE VARCHAR(150) NOT NULL,
SEXO VARCHAR(1) NOT NULL,
TELEFONO INT NOT NULL,
FOTO BLOB,
TIPOCLIENTE BOOLEAN NOT NULL,
TIPOVENDEDOR BOOLEAN NOT NULL,*/
    private void insertar() {
        insertarPersona();
        insertaCliente();

    }

    private void insertarPersona() {
        String sql = "INSERT INTO PERSONA VALUES (?,?,?,?,?,?,?)";

        Connection con = new conectorDB().concectar();
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, cliente.getCi());
            stmt.setString(2, cliente.getNombre());
            stmt.setString(3, cliente.getSexo());
            stmt.setString(4, cliente.getTelefono());
            stmt.setBinaryStream(5, null);
            stmt.setBoolean(6, cliente.getTipoCliente());
            stmt.setBoolean(7, cliente.getTipoVendedor());
            if (cliente.getFileFoto() != null) {
                FileInputStream fs = null;
                try {
                    fs = new FileInputStream(cliente.getFileFoto());

                } catch (FileNotFoundException ex) {
                    JOptionPane.showMessageDialog(null, "Error: " + ex);
                }
                stmt.setBinaryStream(5, fs, cliente.getFileFoto().length());

            } else {
                stmt.setBinaryStream(5, null);
            }

            stmt.executeUpdate();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "\n" + ex.getErrorCode() + "\n" + ex.getMessage());
        }
    }

    private void insertaCliente() {
        String sql = "INSERT INTO CLIENTE VALUES (?,?)";
        Connection con = new conectorDB().concectar();
        PreparedStatement stmt;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, cliente.getCi());
            stmt.setDouble(2, cliente.getCouta());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "\n" + ex.getErrorCode() + "\n" + ex.getMessage());
        }

    }

    public static Double getCuota(Integer ci) {
        Double n = 0.0;
        String sql = "SELECT CUOTA FROM CLIENTE,PERSONA WHERE CI=CIPERSONA AND CI="+ci;
        Connection con = new conectorDB().concectar();
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet res = stmt.executeQuery();
            if (res.next()) {
                n = res.getDouble("CUOTA");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "\n" + ex.getErrorCode() + "\n" + ex.getMessage());
        }

        return n;
    }
}
