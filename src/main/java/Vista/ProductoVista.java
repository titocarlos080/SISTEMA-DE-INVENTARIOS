package Vista;

import Controlador.Ctrl_Producto;
import Database.conectorDB;
import java.awt.Frame;
import java.awt.Image;
import java.awt.TrayIcon;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;
import modelo.Categoria;
import modelo.Producto;

/**
 *
 * @author hp
 */
public class ProductoVista extends javax.swing.JPanel {

    private Producto producto = new Producto();

    private File archivoImagen = null;

    public ProductoVista() {

        initComponents();
        txtCodigo.requestFocus();
        llenarBox();
    }

    private void llenarBox() {

        String sql = "SELECT DESCRIPCION FROM CATEGORIA";
        Connection cn = new conectorDB().concectar();
        try {
            PreparedStatement stmt = cn.prepareStatement(sql);
            ResultSet res = stmt.executeQuery();
            while (res.next()) {

                boxCategorias.addItem(res.getString("DESCRIPCION"));
            }
            stmt.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel1 = new java.awt.Panel();
        lblcodigo = new java.awt.Label();
        lblcodigo1 = new java.awt.Label();
        lblcodigo2 = new java.awt.Label();
        lblcodigo3 = new java.awt.Label();
        txtNombre = new javax.swing.JTextField();
        txtPrecio = new javax.swing.JTextField();
        txtCodigo = new javax.swing.JTextField();
        txtCantidad = new javax.swing.JTextField();
        btnAgregarACarrito = new javax.swing.JButton();
        boxCategorias = new javax.swing.JComboBox<>();
        lblImagenProducto = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(93, 141, 132));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        panel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblcodigo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblcodigo.setText("CODIGO");
        panel1.add(lblcodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 30, 129, -1));

        lblcodigo1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblcodigo1.setText("NOMBRE");
        panel1.add(lblcodigo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 94, 129, -1));

        lblcodigo2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblcodigo2.setText("PRECIO");
        panel1.add(lblcodigo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 164, 129, -1));

        lblcodigo3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblcodigo3.setText("CANTIDAD");
        panel1.add(lblcodigo3, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 237, 129, -1));

        txtNombre.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNombreKeyPressed(evt);
            }
        });
        panel1.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 92, 266, -1));

        txtPrecio.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtPrecio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPrecioKeyPressed(evt);
            }
        });
        panel1.add(txtPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 164, 266, -1));

        txtCodigo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCodigoKeyPressed(evt);
            }
        });
        panel1.add(txtCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 28, 266, -1));

        txtCantidad.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtCantidad.setText("1");
        txtCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCantidadActionPerformed(evt);
            }
        });
        txtCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCantidadKeyPressed(evt);
            }
        });
        panel1.add(txtCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 237, 266, -1));

        btnAgregarACarrito.setBackground(new java.awt.Color(60, 63, 65));
        btnAgregarACarrito.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnAgregarACarrito.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nuevo_producto_ico.png"))); // NOI18N
        btnAgregarACarrito.setText("AGREGAR");
        btnAgregarACarrito.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnAgregarACarrito.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAgregarACarrito.setPreferredSize(new java.awt.Dimension(64, 64));
        btnAgregarACarrito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarACarritoActionPerformed(evt);
            }
        });
        panel1.add(btnAgregarACarrito, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 290, 220, -1));

        boxCategorias.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        boxCategorias.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        boxCategorias.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        boxCategorias.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                boxCategoriasKeyPressed(evt);
            }
        });
        panel1.add(boxCategorias, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 50, 230, 34));

        lblImagenProducto.setBackground(new java.awt.Color(255, 153, 51));
        lblImagenProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/imagen_ico.png"))); // NOI18N
        lblImagenProducto.setText("jLabel2");
        lblImagenProducto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblImagenProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblImagenProductoMouseClicked(evt);
            }
        });
        panel1.add(lblImagenProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 110, 128, 128));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("CATEGORIA");
        panel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 20, 120, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/xlsx_ico.png"))); // NOI18N
        jLabel2.setText("jLabel2");
        jLabel2.setToolTipText("Subir productos masivamente");
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        panel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 290, 64, 64));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/fondo3.jpg"))); // NOI18N
        panel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 720, -1));

        add(panel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 720, 400));
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void txtCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCantidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCantidadActionPerformed

    private void lblImagenProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblImagenProductoMouseClicked
        JFileChooser file = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("png,jpg & gif", "jpg", "png", "gif");
        file.addChoosableFileFilter(filter);
        int respuesta = file.showOpenDialog(this);
        if (respuesta == JFileChooser.APPROVE_OPTION) {
            String path = file.getSelectedFile().getAbsolutePath();
            archivoImagen = new File(path);
            ImageIcon icono = new ImageIcon(path);
            Image imagen = icono.getImage();
            ImageIcon imagenIco = new ImageIcon(imagen.getScaledInstance(lblImagenProducto.getWidth(), lblImagenProducto.getHeight(), Image.SCALE_SMOOTH));
            lblImagenProducto.setIcon(imagenIco);
            JOptionPane.showMessageDialog(null, path);
        }
        JOptionPane.showMessageDialog(null, respuesta);

        // TODO add your handling code here:
    }//GEN-LAST:event_lblImagenProductoMouseClicked

    private void btnAgregarACarritoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarACarritoActionPerformed
        if (verificarEntradas()) {
            producto.setCodigo(txtCodigo.getText());
            producto.setNombre(txtNombre.getText());
            producto.setCantidad(Integer.parseInt(txtCantidad.getText()));
            producto.setPrecio(Double.parseDouble(txtPrecio.getText()));
            producto.setImagen(archivoImagen);
            Categoria categoria = new Categoria();
            categoria.setDescripcion(boxCategorias.getSelectedItem().toString());
            Ctrl_Producto ctrl = new Ctrl_Producto(producto, categoria);
            // TODO add your handling code here:
            JOptionPane.showMessageDialog(null, "Realizado");
        } else {
            JOptionPane.showMessageDialog(null, "Intente nuevamente.", "DATOS INCOMPLETOS", JOptionPane.ERROR_MESSAGE);

        }

    }//GEN-LAST:event_btnAgregarACarritoActionPerformed

    private void txtCodigoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtNombre.requestFocus();
        }
        if (evt.getKeyCode() == KeyEvent.VK_RIGHT) {
            boxCategorias.requestFocus();
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoKeyPressed

    private void txtNombreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtPrecio.requestFocus();
        }
        if (evt.getKeyCode() == KeyEvent.VK_RIGHT) {
            boxCategorias.requestFocus();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreKeyPressed

    private void txtPrecioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtCantidad.requestFocus();
        }
        if (evt.getKeyCode() == KeyEvent.VK_RIGHT) {
            boxCategorias.requestFocus();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecioKeyPressed

    private void txtCantidadKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnAgregarACarrito.requestFocus();
        }
        if (evt.getKeyCode() == KeyEvent.VK_RIGHT) {
            boxCategorias.requestFocus();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCantidadKeyPressed

    private void boxCategoriasKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_boxCategoriasKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_DOWN) {
            lblImagenProducto.requestFocus();
        }
        if (evt.getKeyCode() == KeyEvent.VK_LEFT) {
            txtCodigo.requestFocus();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_boxCategoriasKeyPressed

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        JFileChooser file = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos de excel","xlsx");
        file.addChoosableFileFilter(filter);
        int respuesta = file.showOpenDialog(this);
        if (respuesta == JFileChooser.APPROVE_OPTION) {
            String path = file.getSelectedFile().getAbsolutePath();
            try {
                FileInputStream xlsx= new FileInputStream(new File(path));
                
                
            } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex);
            }
             
            
            JOptionPane.showMessageDialog(null, path);
        }
        JOptionPane.showMessageDialog(null, respuesta);

        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel2MouseClicked
    private boolean verificarEntradas() {

        String codigo = txtCodigo.getText().toString().trim();
        String nombre = txtNombre.getText().toString().trim();
        String precio = txtPrecio.getText().toString().trim();
        String cantidad = txtCantidad.getText().toString().trim();

        if (codigo.isEmpty() || nombre.isEmpty() || precio.isEmpty() || cantidad.isEmpty()) {
            return false;
        }
        return true;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> boxCategorias;
    private javax.swing.JButton btnAgregarACarrito;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lblImagenProducto;
    private java.awt.Label lblcodigo;
    private java.awt.Label lblcodigo1;
    private java.awt.Label lblcodigo2;
    private java.awt.Label lblcodigo3;
    private java.awt.Panel panel1;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPrecio;
    // End of variables declaration//GEN-END:variables
}
