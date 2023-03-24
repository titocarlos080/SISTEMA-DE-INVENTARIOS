/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Vista;

import Controlador.Ctrl_Cliente;
import Database.conectorDB;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.Cliente;

/**
 *
 * @author hp
 */
public class ClenteVista extends javax.swing.JPanel {

    private Integer opcion = null;

    /**
     * Creates new form ClenteVista
     */
    public ClenteVista() {
        initComponents();

        panelEditor.setVisible(false);
        cargarTabla();
    }

    private void mouseListener() {
        tblClientes.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent evt) {
                if (evt.getClickCount() == 1) {

                }
            }

        });
    }

    private void cargarTabla() {

        String sql = "SELECT CI,NOMBRE,CUOTA FROM  CLIENTE,PERSONA WHERE CI=CIPERSONA";
        Connection cn = new conectorDB().concectar();
        PreparedStatement stmt;
        try {
            stmt = cn.prepareStatement(sql);
            ResultSet respuesta = stmt.executeQuery(sql);
            DefaultTableModel model = (DefaultTableModel) tblClientes.getModel();
            model.setRowCount(0);
            Integer i = 1;
            while (respuesta.next()) {
                Object fila[] = new Object[4];
                fila[0] = (Object) i.toString();
                fila[1] = (Object)respuesta.getInt("CI");
                fila[2] = (Object)respuesta.getString("NOMBRE");
                fila[3] = (Object)respuesta.getDouble("CUOTA");

                model.addRow(fila);
                i++;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "\n" + ex.getErrorCode() + "\n" + ex.getMessage());

        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupoBtn = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblClientes = new javax.swing.JTable();
        btnAgregar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        panelEditor = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtCI = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtCouta = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        rbtnHombre = new javax.swing.JRadioButton();
        rbtnMujer = new javax.swing.JRadioButton();
        lblFoto = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(93, 141, 132));
        setForeground(new java.awt.Color(0, 0, 0));
        setToolTipText("");
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblClientes.setBackground(new java.awt.Color(0, 153, 153));
        tblClientes.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tblClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "N°", "CI", "NOMBRE", "CUOTA"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblClientes.setRowHeight(30);
        tblClientes.setSelectionBackground(new java.awt.Color(0, 0, 0));
        tblClientes.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tblClientes.setShowHorizontalLines(true);
        tblClientes.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblClientes);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 61, 477, 450));

        btnAgregar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/agregar_categoria_ico.png"))); // NOI18N
        btnAgregar.setText("AGREGAR");
        btnAgregar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAgregar.setPreferredSize(null);
        btnAgregar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAgregarMouseClicked(evt);
            }
        });
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 60, 190, -1));

        btnEditar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/editar.png"))); // NOI18N
        btnEditar.setText("EDITAR");
        btnEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEditar.setPreferredSize(null);
        btnEditar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEditarMouseClicked(evt);
            }
        });
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 130, 190, 70));

        btnEliminar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/eliminar_ico_azul.png"))); // NOI18N
        btnEliminar.setText("ELIMINAR");
        btnEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminar.setPreferredSize(null);
        btnEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEliminarMouseClicked(evt);
            }
        });
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 60, 190, -1));

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
        jLabel6.setText("CUOTA");
        panelEditor.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 98, 140, 30));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("SEXO");
        panelEditor.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 146, 140, 30));

        jLabel8.setBackground(new java.awt.Color(0, 102, 204));
        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("NOMBRE ");
        panelEditor.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 49, 164, 30));

        txtCouta.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtCouta.setText(" ");
        txtCouta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCoutaActionPerformed(evt);
            }
        });
        panelEditor.add(txtCouta, new org.netbeans.lib.awtextra.AbsoluteConstraints(217, 97, 270, -1));

        txtNombre.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtNombre.setText(" ");
        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });
        panelEditor.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(217, 49, 270, -1));

        btnGuardar.setBackground(new java.awt.Color(204, 204, 255));
        btnGuardar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/guardar_ico.png"))); // NOI18N
        btnGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        panelEditor.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(423, 208, 64, 64));

        rbtnHombre.setBackground(new java.awt.Color(204, 204, 255));
        grupoBtn.add(rbtnHombre);
        rbtnHombre.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        rbtnHombre.setForeground(new java.awt.Color(0, 0, 0));
        rbtnHombre.setText("HOMBRE");
        rbtnHombre.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panelEditor.add(rbtnHombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(217, 147, -1, -1));

        rbtnMujer.setBackground(new java.awt.Color(204, 204, 255));
        grupoBtn.add(rbtnMujer);
        rbtnMujer.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        rbtnMujer.setForeground(new java.awt.Color(0, 0, 0));
        rbtnMujer.setText("MUJER");
        rbtnMujer.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panelEditor.add(rbtnMujer, new org.netbeans.lib.awtextra.AbsoluteConstraints(332, 147, -1, -1));

        lblFoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cliente_ico.png"))); // NOI18N
        lblFoto.setText("jLabel3");
        lblFoto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panelEditor.add(lblFoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(82, 183, 69, 89));

        add(panelEditor, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 210, 500, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setText("CLIENTES");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, -1, -1));
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

    private void txtCoutaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCoutaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCoutaActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        switch (opcion) {
            case 1://agregar nuevo
                agregarNuevo();
                break;
            case 2://editar
                editar();
                break;
            case 3://eliminar
                eliminar();
                break;
            default:
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btnGuardarActionPerformed
    private void agregarNuevo() {
        if (txtCI.getText().trim().length() != 0 &&grupoBtn.getSelection()!=null && txtCouta.getText().trim().length() != 0 && txtNombre.getText().trim().length() != 0) {
            Cliente cliente = new Cliente();
            cliente.setCi(Integer.valueOf(txtCI.getText().trim()));
            cliente.setNombre(txtNombre.getText().trim());
            cliente.setCouta(Double.valueOf(txtCouta.getText().trim()));
            if (rbtnHombre.isSelected()) {
                cliente.setSexo("M");
            } 
            if (rbtnMujer.isSelected()) {
                cliente.setSexo("F");
            }
            
           new Ctrl_Cliente(cliente);
           cargarTabla();
        }else{
  JOptionPane.showMessageDialog(null, "\n\tDATOS INCOMPLETOS  "+opcion);

        }
        

    }

    private void editar() {
        Cliente cliente = new Cliente();
          JOptionPane.showMessageDialog(null, "\n\tDATOS INCOMPLETOS  "+opcion);

    }

    private void eliminar() {
  JOptionPane.showMessageDialog(null, "\n\tDATOS INCOMPLETOS  "+opcion);

    }

    private void btnAgregarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgregarMouseClicked
        if (panelEditor.isVisible()) {
            panelEditor.setVisible(false);
            opcion = null;
        } else {
            panelEditor.setVisible(true);
            opcion = 1;
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_btnAgregarMouseClicked

    private void btnEliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarMouseClicked
        if (panelEditor.isVisible()) {
            panelEditor.setVisible(false);
            opcion = null;
        } else {
            panelEditor.setVisible(true);
            opcion = 3;

        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarMouseClicked

    private void btnEditarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditarMouseClicked
        if (panelEditor.isVisible()) {
            panelEditor.setVisible(false);
            opcion = null;
        } else {
            panelEditor.setVisible(true);
            opcion = 2;
        }   // TODO add your handling code here:
    }//GEN-LAST:event_btnEditarMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.ButtonGroup grupoBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblFoto;
    private javax.swing.JPanel panelEditor;
    private javax.swing.JRadioButton rbtnHombre;
    private javax.swing.JRadioButton rbtnMujer;
    private javax.swing.JTable tblClientes;
    private javax.swing.JTextField txtCI;
    private javax.swing.JTextField txtCouta;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
