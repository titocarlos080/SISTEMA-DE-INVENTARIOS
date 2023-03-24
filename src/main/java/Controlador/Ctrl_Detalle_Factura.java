package Controlador;

import Database.conectorDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.DetallesDeFactura;
import modelo.Factura;

/**
 *
 * @author hp
 */
public class Ctrl_Detalle_Factura {

    DetallesDeFactura detallesDeFactura;

    public Ctrl_Detalle_Factura() {
        this.detallesDeFactura = new DetallesDeFactura();
    }

    public Ctrl_Detalle_Factura(DetallesDeFactura detallesDeFactura) {
        this.detallesDeFactura = detallesDeFactura;
    }

    public static void realizarDetalleFactura(DetallesDeFactura detallesDeFactura) {
        Connection con = new conectorDB().concectar();
        String sql = "INSERT INTO DETALLEFACTURA VALUES (?,?,?,?,?)";

        try {
             PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, detallesDeFactura.getFactura().getCodigo());
            stmt.setString(2, detallesDeFactura.getProducto().getCodigo());
            stmt.setInt(3, detallesDeFactura.getCantidad());
            stmt.setDouble(4, detallesDeFactura.getPrecioVenta());
            stmt.setDouble(5, detallesDeFactura.getTotalParcial());
            stmt.executeUpdate();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "\n" + ex.getErrorCode() + "\n" + ex.getMessage());
        }

    }

}
