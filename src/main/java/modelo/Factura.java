/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import Database.conectorDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import javax.swing.JOptionPane;

/**
 *
 * @author hp
 */
public class Factura {
    
    private Integer codigo;
    private String data;
    private Double monto;
    private Boolean estadoPago;
    private Cliente cliente;
    private String time;
    
    public Factura() {
        this.codigo = null;
        this.data = "";
        this.monto = 0.0;
        this.estadoPago = false;
        this.cliente = new Cliente();
        this.time="";
        
    }
    
    public Factura(Integer codigo, String data,String time ,Double monto, Boolean estadoPago, Cliente cliente) {
        this.codigo = codigo;
        this.data = data;
        this.time=time;
        this.monto = monto;
        this.estadoPago = estadoPago;
        this.cliente = cliente;
    }
    
    public Integer getCodigo() {
        return codigo;
    }
    
    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }
    
    public String getData() {
        return data;
    }
    
    public void setData(String data) {
        this.data = data;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
    
    public Double getMonto() {
        return monto;
    }
    
    public void setMonto(Double monto) {
        this.monto = monto;
    }
    
    public Boolean getEstadoPago() {
        return estadoPago;
    }
    
    public void setEstadoPago(Boolean estadoPago) {
        this.estadoPago = estadoPago;
    }
    
    public Cliente getCliente() {
        return cliente;
    }
    
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    private int cantidadDeFacturas() {
        int n = 0;
        String sql = "SELECT  count(*) AS CANTIDAD FROM FACTURA";
        Connection con = new conectorDB().concectar();
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet res = stmt.executeQuery();
            if (res.next()) {
                n = res.getInt("CANTIDAD");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "\n" + ex.getErrorCode() + "\n" + ex.getMessage());
        }
        
        return n;
    }

    public static void main(String[] args) {
 
    LocalDate m= LocalDate.now();
 
        System.out.println(LocalTime.now().toString());
    }
}
