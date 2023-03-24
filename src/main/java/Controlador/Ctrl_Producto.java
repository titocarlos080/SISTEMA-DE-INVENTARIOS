/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Database.conectorDB;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.Categoria;
import modelo.Producto;

/**
 *
 * @author hp
 */
public class Ctrl_Producto {

    private Producto producto;
    private Categoria categoria;

    public Ctrl_Producto(Producto producto, Categoria categoria) {
        this.producto = producto;
        this.categoria = categoria;
        cargarDB();
    }

    public Integer buscarIdCategoria() {
        String sql = "SELECT ID FROM CATEGORIA WHERE DESCRIPCION=?";
        Connection con = new conectorDB().concectar();
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, categoria.getDescripcion());
            ResultSet resp = stmt.executeQuery();
            if (resp.next()) {
                return resp.getInt("ID");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex);

        }
        return Integer.MIN_VALUE;
    }

    public void cargarDB() {
        File file = producto.getImagen();
        String sql = "INSERT INTO PRODUCTO VALUES (?,?,?,?,?,?);";
        Connection con = new conectorDB().concectar();
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, producto.getCodigo());
            stmt.setString(2, producto.getNombre());
            stmt.setInt(3, producto.getCantidad());
            stmt.setDouble(4, producto.getPrecio());

            if (producto.getImagen() != null) {
                FileInputStream fs = null;
                try {
                    fs = new FileInputStream(file);

                } catch (FileNotFoundException ex) {
                    JOptionPane.showMessageDialog(null, "Error: " + ex);
                }
                stmt.setBinaryStream(5, fs, file.length());

            } else {
                stmt.setBinaryStream(5, null);
            }
             stmt.setInt(6, buscarIdCategoria());
            stmt.executeUpdate();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex);
        }
    }
    public static int cantidad(Producto producto){
        int nro=0;
           String sql = "SELECT CANTIDAD FROM PRODUCTO WHERE CODIGO=?";
        Connection cn = new conectorDB().concectar();

        try {
            PreparedStatement stmt = cn.prepareStatement(sql);
             stmt.setString(1, producto.getCodigo());
           
           ResultSet res=  stmt.executeQuery();
            if (res.next()) {
                nro=res.getInt("CANTIDAD");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: \n" + ex.getErrorCode() + "\n" + ex.getMessage());
        }
      return nro;
    }
    public static void actualizarProducto(Producto producto, Integer cantidadADisminuir) {
        String sql = "UPDATE PRODUCTO SET CANTIDAD=? WHERE CODIGO=?";
        Connection cn = new conectorDB().concectar();

        try {
            PreparedStatement stmt = cn.prepareStatement(sql);
            stmt.setInt(1, Ctrl_Producto.cantidad(producto)-cantidadADisminuir);
            stmt.setString(2, producto.getCodigo());
            stmt.executeUpdate();
          
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: \n" + ex.getErrorCode() + "\n" + ex.getMessage());
        }

    }
    
    

}
