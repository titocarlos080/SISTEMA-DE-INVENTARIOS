package Vista;

import Controlador.Ctrl_Categoria;
import Database.conectorDB;
 
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hp
 */
public class CategoriaVista extends javax.swing.JPanel {

    public CategoriaVista() {
        initComponents();
        llenarTablaCategoria();
        mouseListener();

    }

    private void mouseListener() {
        tblCategoria.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent evt) {
                JTable tabla = (JTable) evt.getSource();
                Point poin = evt.getPoint();
                int fila = tabla.rowAtPoint(poin);
                if (evt.getClickCount() == 1) {
                    txtID.setText(tblCategoria.getValueAt(fila, 0).toString());
                    txtDescripcion.setText(tblCategoria.getValueAt(fila, 1).toString());
                }
            }

        });
    }

    private void llenarTablaCategoria() {

        conectorDB conector = new conectorDB();
        Connection con = conector.concectar();
        try {
            Statement stmt = con.createStatement();
            String sql = "SELECT ID,DESCRIPCION FROM CATEGORIA";
            ResultSet Respuesta = stmt.executeQuery(sql);
            DefaultTableModel model = (DefaultTableModel) tblCategoria.getModel();
            model.setRowCount(0);
            while (Respuesta.next()) {
                String Producto[] = new String[2];
                Producto[0] = String.valueOf(Respuesta.getInt("ID"));
                Producto[1] = Respuesta.getString("DESCRIPCION");

                model.addRow(Producto);
            }

            stmt.close();

        } catch (SQLException ex) {
            System.out.println(ex + "En Categoria");
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblCategoria = new javax.swing.JTable();
        btnEliminar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnAgregar1 = new javax.swing.JButton();
        txtID = new javax.swing.JTextField();
        txtDescripcion = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(93, 141, 132));
        setPreferredSize(new java.awt.Dimension(790, 610));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblCategoria.setBackground(new java.awt.Color(0, 153, 153));
        tblCategoria.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tblCategoria.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        tblCategoria.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "DESCRIPCION"
            }
        ));
        tblCategoria.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tblCategoria.setRowHeight(30);
        tblCategoria.setShowHorizontalLines(true);
        tblCategoria.getTableHeader().setReorderingAllowed(false);
        tblCategoria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCategoriaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tblCategoriaMouseEntered(evt);
            }
        });
        jScrollPane1.setViewportView(tblCategoria);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 290));

        btnEliminar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/eliminar_ico_azul.png"))); // NOI18N
        btnEliminar.setText("ELIMINAR");
        btnEliminar.setPreferredSize(null);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 220, 190, -1));

        btnEditar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/editar.png"))); // NOI18N
        btnEditar.setText("EDITAR");
        btnEditar.setPreferredSize(null);
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 130, 190, 70));

        btnAgregar1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnAgregar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/agregar_categoria_ico.png"))); // NOI18N
        btnAgregar1.setText("AGREGAR");
        btnAgregar1.setPreferredSize(null);
        btnAgregar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregar1ActionPerformed(evt);
            }
        });
        add(btnAgregar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(479, 40, 190, -1));

        txtID.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtID.setText(" ");
        add(txtID, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 340, 70, -1));

        txtDescripcion.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtDescripcion.setText(" ");
        txtDescripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDescripcionActionPerformed(evt);
            }
        });
        add(txtDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 340, 270, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("ID");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 310, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("DESCRIPCION");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 310, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/fondo3.jpg"))); // NOI18N
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 690, 410));
    }// </editor-fold>//GEN-END:initComponents

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed

        if (!(txtDescripcion.getText().toString().compareTo("") == 0) && !(txtID.getText().toString().compareTo("") == 0)) {
            Integer Id = Integer.parseInt(txtID.getText().trim());
            String Descripcion = txtDescripcion.getText().toString().trim();

            Ctrl_Categoria cat = new Ctrl_Categoria(Id, Descripcion);
            String sql = "DELETE FROM CATEGORIA WHERE ID=?";
            Connection cn = new conectorDB().concectar();

            try {
                PreparedStatement stmt = cn.prepareStatement(sql);
                stmt.setInt(1, Integer.parseInt(tblCategoria.getValueAt(tblCategoria.getSelectedRow(), 0).toString()));
                int p = stmt.executeUpdate();

                JOptionPane.showMessageDialog(null, "REALIZADO :" + p);

                stmt.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error: " + ex);
            }

            llenarTablaCategoria();
        } else {
            JOptionPane.showMessageDialog(null, "DATOS VACIOS");

        }
// TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed

        if (!(txtDescripcion.getText().toString().compareTo("") == 0) && !(txtID.getText().toString().compareTo("") == 0)) {
            Integer Id = Integer.parseInt(txtID.getText().trim());
            String Descripcion = txtDescripcion.getText().toString().trim();

            Ctrl_Categoria cat = new Ctrl_Categoria(Id, Descripcion);
            String sql = "UPDATE CATEGORIA SET ID=?,DESCRIPCION =? WHERE ID=?";
            Connection cn = new conectorDB().concectar();

            try {
                PreparedStatement stmt = cn.prepareStatement(sql);
                stmt.setInt(1, cat.getID());
                stmt.setString(2, cat.getDescripcion());
                stmt.setInt(3, Integer.parseInt(tblCategoria.getValueAt((int)tblCategoria.getSelectedRow(), 0).toString()));
                int p = stmt.executeUpdate();

                JOptionPane.showMessageDialog(null, "REALIZADO :" + p);

                stmt.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error: \n" + ex.getErrorCode()+"\n"+ex.getMessage());
            }

            llenarTablaCategoria();
        } else {
            JOptionPane.showMessageDialog(null, "DATOS VACIOS");

        }

        // TODO add your handling code here:
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnAgregar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregar1ActionPerformed

        if (!(txtDescripcion.getText().toString().compareTo("") == 0) && !(txtID.getText().toString().compareTo("") == 0)) {
            Integer Id = Integer.parseInt(txtID.getText().trim());
            String Descripcion = txtDescripcion.getText().toString().trim();

            Ctrl_Categoria cat = new Ctrl_Categoria(Id, Descripcion);

            String sql = "INSERT INTO CATEGORIA VALUES(?,?)";
            Connection cn = new conectorDB().concectar();

            try {
                PreparedStatement stmt = cn.prepareStatement(sql);
                stmt.setInt(1, cat.getID());
                stmt.setString(2, cat.getDescripcion());
                int p = stmt.executeUpdate();

                JOptionPane.showMessageDialog(null, "REALIZADO :" + p);

                stmt.close();
            } catch (SQLException ex) {
                
              
                JOptionPane.showMessageDialog(null, "Error: \n" + ex.getErrorCode()+"\n"+ex.getMessage());
            }

            llenarTablaCategoria();
        } else {
            JOptionPane.showMessageDialog(null, "DATOS VACIOS");

        }

// TODO add your handling code here:
    }//GEN-LAST:event_btnAgregar1ActionPerformed

    private void txtDescripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescripcionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDescripcionActionPerformed

    private void tblCategoriaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCategoriaMouseEntered

        // TODO add your handling code here:
    }//GEN-LAST:event_tblCategoriaMouseEntered

    private void tblCategoriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCategoriaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblCategoriaMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar1;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblCategoria;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtID;
    // End of variables declaration//GEN-END:variables
}
