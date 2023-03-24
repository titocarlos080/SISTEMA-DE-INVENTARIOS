package Controlador;

import Database.conectorDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.Factura;

/**
 *
 * @author hp
 */
public class Ctrl_Factura {

    private Factura factura;

    public Ctrl_Factura() {
        this.factura = new Factura();

    }

    public Ctrl_Factura(Factura factura) {
        this.factura = factura;
    }

    

    public static void realizarFactura(Factura factura) {
//        insert into FACTURA VALUES (NULL,"2023-03-17 22:43:45",24.2,TRUE,9441550);

        String sql = "INSERT INTO FACTURA VALUES (?,?,?,?,?,?)";
        Connection con = new conectorDB().concectar();
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, factura.getCodigo());
            stmt.setString(2, factura.getData());
            stmt.setDouble(3, factura.getMonto());
            stmt.setBoolean(4, factura.getEstadoPago());
            stmt.setInt(5, factura.getCliente().getCi());
            stmt.setString(6, factura.getTime());
            stmt.executeUpdate();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "\n" + ex.getErrorCode() + "\n" + ex.getMessage());
        }

    }
       public static Integer ultimaFactura() {
        int n = 0;
        String sql = "SELECT  CODIGO AS CANTIDAD FROM FACTURA ORDER BY CODIGO DESC LIMIT 1";
        Connection con = new conectorDB().concectar();
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet res = stmt.executeQuery();
            if (res.next()) {
                n = res.getInt("CANTIDAD");
            }else{
                n=0;
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "\n" + ex.getErrorCode() + "\n" + ex.getMessage());
        }
            
        return n;
    }

}
