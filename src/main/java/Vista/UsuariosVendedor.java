/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Vista;

import Database.conectorDB;
import com.sun.tools.javac.Main;
import java.awt.BorderLayout;
import java.awt.Point;
import java.awt.ScrollPane;
import java.awt.Scrollbar;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.management.modelmbean.ModelMBean;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hp
 */
public class UsuariosVendedor extends javax.swing.JPanel {

    private DefaultTableModel model1 = new DefaultTableModel();
    private JTable tablaVendedores;
    private JScrollPane js;

    public UsuariosVendedor() {
        initComponents();
        llenarTablaUsuarios();
        mouseListener();
          cargarBox();
        panelEditor.setVisible(false);
    }
    private void cargarBox(){
        
        
        String sql = "SELECT DESCCRIPCION FROM CATEGORIAVENDEDOR";
        Connection cn = new conectorDB().concectar();
        try {
            PreparedStatement stmt = cn.prepareStatement(sql);
            ResultSet res = stmt.executeQuery();
            while (res.next()) {

                boxRolUsuario.addItem(res.getString("DESCCRIPCION"));
            }
            stmt.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "\n" + ex.getErrorCode() + "\n" + ex.getMessage());
        }
    }
    private void mouseListener() {
        tblUsuarios.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent evt) {

                if (evt.getClickCount() == 1) {
                    int fila = tblUsuarios.getSelectedRow();
                    txtCI.setText(tblUsuarios.getValueAt(fila, 0).toString());
                    txtCodigo.setText(tblUsuarios.getValueAt(fila, 1).toString());
                    txtNombre.setText(tblUsuarios.getValueAt(fila, 2).toString());
                   

                    panelEditor.setVisible(true);

                }
                if (evt.getClickCount() == 2) {
                    panelEditor.setVisible(false);
                }
            }

        });
    }

    private void llenarTablaUsuarios() {
        String sql = "SELECT CI,CODIGO,NOMBRE,DESCCRIPCION \n"
                + "FROM PERSONA,VENDEDOR,CATEGORIAVENDEDOR\n"
                + "WHERE PERSONA.CI=VENDEDOR.CIPERSONA AND VENDEDOR.IDCATEGORIAVENDEDOR=CATEGORIAVENDEDOR.ID";
        ResultSet respuesta = consultas(sql);
        DefaultTableModel model = (DefaultTableModel) tblUsuarios.getModel();
        try {
            while (respuesta.next()) {
                Object fila[] = new Object[4];
                fila[0] = respuesta.getInt("CI");
                fila[1] = respuesta.getString("CODIGO");
                fila[2] = respuesta.getString("NOMBRE");
                fila[3] = respuesta.getString("DESCCRIPCION");
                model.addRow(fila);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "\n" + ex.getErrorCode() + "\n" + ex.getMessage());
        }
    }

    private ResultSet consultas(String sql) {
        ResultSet respuesta = null;
        conectorDB con = new conectorDB();
        try {
            Statement stmt = con.concectar().createStatement();
            respuesta = stmt.executeQuery(sql);

        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return respuesta;

    }

    private void crearTabla() {
        model1.addColumn("CI");
        model1.addColumn("CODIGO");
        model1.addColumn("NOMBRE");
        model1.addColumn("ROL");
        tablaVendedores = new JTable(model1);
        js = new JScrollPane(tablaVendedores);
        js.setSize(600, 400);
        this.add(js);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblUsuarios = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        panelEditor = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtCI = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtCodigo = new javax.swing.JTextField();
        boxRolUsuario = new javax.swing.JComboBox<>();
        btnGuardar = new javax.swing.JButton();
        lblFoto = new javax.swing.JLabel();

        setBackground(new java.awt.Color(93, 141, 132));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblUsuarios.setBackground(new java.awt.Color(0, 153, 153));
        tblUsuarios.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tblUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CI", "CODIGO", "NOMBRE", "ROL"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblUsuarios.setRowHeight(30);
        tblUsuarios.setSelectionBackground(new java.awt.Color(0, 0, 0));
        tblUsuarios.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tblUsuarios.setShowHorizontalLines(true);
        tblUsuarios.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblUsuarios);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 570, 450));

        jLabel1.setText("USUARIOS ");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 40, 80, 20));

        btnEditar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/editar.png"))); // NOI18N
        btnEditar.setText("EDITAR");
        btnEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEditar.setPreferredSize(null);
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 150, 190, 70));

        btnEliminar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/eliminar_ico_azul.png"))); // NOI18N
        btnEliminar.setText("ELIMINAR");
        btnEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminar.setPreferredSize(null);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 70, 190, -1));

        btnAgregar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/agregar_categoria_ico.png"))); // NOI18N
        btnAgregar.setText("AGREGAR");
        btnAgregar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAgregar.setPreferredSize(null);
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 70, 190, -1));

        panelEditor.setBackground(new java.awt.Color(204, 204, 255));
        panelEditor.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("CEDULA IDENTIDAD");
        panelEditor.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 6, 194, 30));

        txtCI.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtCI.setText(" ");
        panelEditor.add(txtCI, new org.netbeans.lib.awtextra.AbsoluteConstraints(217, 6, 270, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("NOMBRE");
        panelEditor.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 98, 140, 30));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("ROL");
        panelEditor.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 146, 140, 30));

        jLabel8.setBackground(new java.awt.Color(0, 102, 204));
        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("CODIGO ");
        panelEditor.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 164, 30));

        txtNombre.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtNombre.setText(" ");
        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });
        panelEditor.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(217, 97, 270, -1));

        txtCodigo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtCodigo.setText(" ");
        txtCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoActionPerformed(evt);
            }
        });
        panelEditor.add(txtCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(217, 49, 270, -1));

        boxRolUsuario.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        panelEditor.add(boxRolUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(217, 146, 270, -1));

        btnGuardar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/agregar_categoria_ico.png"))); // NOI18N
        btnGuardar.setText("GUARDAR");
        btnGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        panelEditor.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 189, 190, -1));

        lblFoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cliente_ico.png"))); // NOI18N
        lblFoto.setText("jLabel3");
        lblFoto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panelEditor.add(lblFoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 182, 69, 89));

        add(panelEditor, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 250, 490, 270));
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed

        // TODO add your handling code here:
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed

        // TODO add your handling code here:
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed

        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void txtCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnGuardarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> boxRolUsuario;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblFoto;
    private javax.swing.JPanel panelEditor;
    private javax.swing.JTable tblUsuarios;
    private javax.swing.JTextField txtCI;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
