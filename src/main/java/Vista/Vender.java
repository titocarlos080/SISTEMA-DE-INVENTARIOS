package Vista;

import Controlador.*;
import Database.conectorDB;
import com.itextpdf.awt.geom.Dimension;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfBody;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.PdfPTable;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.FocusEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import modelo.Cliente;
import modelo.DetallesDeFactura;
import modelo.Factura;
import modelo.Persona;
import modelo.Producto;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author hp
 */
public class Vender extends javax.swing.JPanel {

    /**
     * Creates new form panel1
     */
    public Vender() {
        initComponents();
        this.setVisible(true);

        personalizarInconos();

        personaliszarTableHeader();
        actualizarTotal();
        llenarBoxClientes();
        eventListenerKey();
    }

    private void llenarBoxClientes() {
        String sql = "SELECT NOMBRE FROM CLIENTE,PERSONA WHERE CI=CIPERSONA";
        Connection cn = new conectorDB().concectar();
        try {
            PreparedStatement stmt = cn.prepareStatement(sql);
            ResultSet res = stmt.executeQuery();
            while (res.next()) {

                boxClientes.addItem(res.getString("NOMBRE"));
            }
            stmt.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "\n" + ex.getErrorCode() + "\n" + ex.getMessage());
        }
    }

    private void personaliszarTableHeader() {
        JTableHeader jTableHeader = new JTableHeader();
        jTableHeader.setFont(txtCantidad.getFont());
        jTableHeader.setColumnModel(tblResultadoVenta.getColumnModel());
        jTableHeader.setReorderingAllowed(false);

        tblResultadoVenta.setTableHeader(jTableHeader);
    }

    private void actualizarTabla() {
        DefaultTableModel model = (DefaultTableModel) tblResultadoVenta.getModel();
        Object fila[] = {(int) tblResultadoVenta.getRowCount() + 1, txtCodigo.getText().toString().trim(),
            txtNombre.getText(), Integer.parseInt(txtCantidad.getText()), Double.valueOf(txtPrecio.getText()), "dedfaul"};
        model.addRow(fila);
    }

    private void actualizarTotal() {
        txtTotal.setText(String.format("%.2f", sumaProducto(3, 4)));
    }

    private Double sumaProducto(int colCantidad, int colPrecio) {
        Double suma = 0.0;
        int lon = tblResultadoVenta.getRowCount();
        for (int i = 0; i < lon; i++) {
            Double can = Double.valueOf(String.valueOf(tblResultadoVenta.getValueAt(i, colCantidad)));
            Double precio = Double.valueOf(String.valueOf(tblResultadoVenta.getValueAt(i, colPrecio)));
            suma += (can * precio);
        }
        return suma;
    }

    private boolean validarCampos() {
        if (Integer.parseInt(txtCantidad.getText()) == 0) {
            return false;
        } else if (txtCodigo.getText().trim().length() == 0 || txtNombre.getText().trim().length() == 0
                || txtPrecio.getText().trim().length() == 0 || txtCantidad.getText().trim().length() == 0) {

            return false;
        }
        return true;
    }

    private void personalizarInconos() {
        ImageIcon icono = new ImageIcon(ClassLoader.getSystemResource("images/cerrar.png"));
        btncerrar.setIcon(icono);
        txtCodigo.setCaretPosition(0);

        ImageIcon iconos = new ImageIcon(ClassLoader.getSystemResource("images/bienes.png"));
        Image imagen = iconos.getImage();

        System.out.println(lblImagen.getPreferredSize());
        System.out.println(this.getWidth() + " " + this.getHeight());
        ImageIcon iconoEscalado = new ImageIcon(imagen.getScaledInstance(231, 225, Image.SCALE_SMOOTH));
        lblImagen.setIcon(iconoEscalado);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuPopup = new javax.swing.JPopupMenu();
        opcEliminar = new javax.swing.JMenuItem();
        opcEditar = new javax.swing.JMenuItem();
        btncerrar = new javax.swing.JButton();
        lblImagen = new javax.swing.JLabel();
        panel1 = new java.awt.Panel();
        txtNombre = new javax.swing.JTextField();
        lblcodigo = new java.awt.Label();
        lblcodigo1 = new java.awt.Label();
        lblcodigo2 = new java.awt.Label();
        lblDescuento = new java.awt.Label();
        txtPrecio = new javax.swing.JTextField();
        txtCodigo = new javax.swing.JTextField();
        txtCantidad = new javax.swing.JTextField();
        btnAgregarACarrito = new javax.swing.JButton();
        boxClientes = new javax.swing.JComboBox<>();
        btnDescuento = new javax.swing.JRadioButton();
        txtDescuento = new javax.swing.JTextField();
        lblcodigo5 = new java.awt.Label();
        lblcodigo4 = new java.awt.Label();
        FONDO = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblResultadoVenta = new javax.swing.JTable();
        txtTotal = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnFacturar = new javax.swing.JButton();

        menuPopup.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        menuPopup.setForeground(new java.awt.Color(0, 204, 204));
        menuPopup.setBorderPainted(false);
        menuPopup.setName("menuPopup"); // NOI18N

        opcEliminar.setText("Eliminar");
        opcEliminar.setName("opcEliminar"); // NOI18N
        opcEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcEliminarActionPerformed(evt);
            }
        });
        menuPopup.add(opcEliminar);

        opcEditar.setText("Editar");
        opcEditar.setName("opcEditar"); // NOI18N
        menuPopup.add(opcEditar);

        setBackground(new java.awt.Color(93, 141, 132));
        setToolTipText("Realizar venta");
        setName("Form"); // NOI18N
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btncerrar.setName("btncerrar"); // NOI18N
        btncerrar.setOpaque(false);
        btncerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncerrarActionPerformed(evt);
            }
        });
        add(btncerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1625, 6, 31, -1));

        lblImagen.setBackground(new java.awt.Color(255, 102, 51));
        lblImagen.setForeground(new java.awt.Color(255, 51, 51));
        lblImagen.setName("lblImagen"); // NOI18N
        add(lblImagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(2087, 59, 231, 233));

        panel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        panel1.setName("panel1"); // NOI18N
        panel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtNombre.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtNombre.setName("txtNombre"); // NOI18N
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
        panel1.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 70, 266, -1));

        lblcodigo.setBackground(new java.awt.Color(60, 63, 65));
        lblcodigo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblcodigo.setForeground(new java.awt.Color(187, 187, 187));
        lblcodigo.setName("lblcodigo"); // NOI18N
        lblcodigo.setText("CODIGO");
        panel1.add(lblcodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 30, 129, -1));

        lblcodigo1.setBackground(new java.awt.Color(60, 63, 65));
        lblcodigo1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblcodigo1.setForeground(new java.awt.Color(187, 187, 187));
        lblcodigo1.setName("lblcodigo1"); // NOI18N
        lblcodigo1.setText("NOMBRE");
        panel1.add(lblcodigo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 129, -1));

        lblcodigo2.setBackground(new java.awt.Color(60, 63, 65));
        lblcodigo2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblcodigo2.setForeground(new java.awt.Color(187, 187, 187));
        lblcodigo2.setName(""); // NOI18N
        lblcodigo2.setText("PRECIO ");
        panel1.add(lblcodigo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 129, -1));

        lblDescuento.setBackground(new java.awt.Color(60, 63, 65));
        lblDescuento.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblDescuento.setForeground(new java.awt.Color(187, 187, 187));
        lblDescuento.setName("lblDescuento"); // NOI18N
        lblDescuento.setText("%");
        panel1.add(lblDescuento, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 220, 30, -1));

        txtPrecio.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtPrecio.setName("txtPrecio"); // NOI18N
        txtPrecio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPrecioKeyPressed(evt);
            }
        });
        panel1.add(txtPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 110, 266, -1));

        txtCodigo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtCodigo.setName("txtCodigo"); // NOI18N
        txtCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCodigoKeyPressed(evt);
            }
        });
        panel1.add(txtCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 30, 266, -1));

        txtCantidad.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtCantidad.setText("1");
        txtCantidad.setName("txtCantidad"); // NOI18N
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
        panel1.add(txtCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 150, 266, -1));

        btnAgregarACarrito.setBackground(new java.awt.Color(60, 63, 65));
        btnAgregarACarrito.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnAgregarACarrito.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/agregar _a_carrito_ico.png"))); // NOI18N
        btnAgregarACarrito.setToolTipText("AGREGAR A CARRITO");
        btnAgregarACarrito.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAgregarACarrito.setName("btnAgregarACarrito"); // NOI18N
        btnAgregarACarrito.setPreferredSize(new java.awt.Dimension(64, 64));
        btnAgregarACarrito.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAgregarACarritoMouseClicked(evt);
            }
        });
        btnAgregarACarrito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarACarritoActionPerformed(evt);
            }
        });
        btnAgregarACarrito.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnAgregarACarritoKeyPressed(evt);
            }
        });
        panel1.add(btnAgregarACarrito, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 120, 64, 64));

        boxClientes.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        boxClientes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- default --" }));
        boxClientes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        boxClientes.setName("boxClientes"); // NOI18N
        panel1.add(boxClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 200, 180, -1));

        btnDescuento.setText("DESCUENTO");
        btnDescuento.setName("btnDescuento"); // NOI18N
        btnDescuento.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                btnDescuentoItemStateChanged(evt);
            }
        });
        btnDescuento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDescuentoActionPerformed(evt);
            }
        });
        panel1.add(btnDescuento, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, -1, -1));

        txtDescuento.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtDescuento.setName("txtDescuento"); // NOI18N
        txtDescuento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDescuentoActionPerformed(evt);
            }
        });
        txtDescuento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDescuentoKeyPressed(evt);
            }
        });
        panel1.add(txtDescuento, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 220, 100, -1));

        lblcodigo5.setBackground(new java.awt.Color(60, 63, 65));
        lblcodigo5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblcodigo5.setForeground(new java.awt.Color(187, 187, 187));
        lblcodigo5.setName("lblcodigo5"); // NOI18N
        lblcodigo5.setText("CLIENTE");
        panel1.add(lblcodigo5, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 200, 110, -1));

        lblcodigo4.setBackground(new java.awt.Color(60, 63, 65));
        lblcodigo4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblcodigo4.setForeground(new java.awt.Color(187, 187, 187));
        lblcodigo4.setName("lblcodigo4"); // NOI18N
        lblcodigo4.setText("CANTIDAD");
        panel1.add(lblcodigo4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 129, -1));

        FONDO.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/fondo3.jpg"))); // NOI18N
        FONDO.setName("FONDO"); // NOI18N
        panel1.add(FONDO, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 680, 270));

        add(panel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, 670, -1));

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        tblResultadoVenta.setBackground(new java.awt.Color(0, 153, 153));
        tblResultadoVenta.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tblResultadoVenta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "N°", "CODIGO", "NOMBRE", "CANTIDAD", "PRECIO", "CATEGORIA"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Double.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblResultadoVenta.setComponentPopupMenu(menuPopup);
        tblResultadoVenta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tblResultadoVenta.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        tblResultadoVenta.setFocusable(false);
        tblResultadoVenta.setInheritsPopupMenu(true);
        tblResultadoVenta.setName("tblResultadoVenta"); // NOI18N
        tblResultadoVenta.setOpaque(false);
        tblResultadoVenta.setRowHeight(30);
        tblResultadoVenta.setSelectionBackground(new java.awt.Color(0, 0, 51));
        tblResultadoVenta.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tblResultadoVenta.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tblResultadoVenta.setShowHorizontalLines(true);
        tblResultadoVenta.getTableHeader().setReorderingAllowed(false);
        tblResultadoVenta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tblResultadoVentaMouseEntered(evt);
            }
        });
        tblResultadoVenta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tblResultadoVentaKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tblResultadoVentaKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(tblResultadoVenta);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 870, 240));

        txtTotal.setEditable(false);
        txtTotal.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtTotal.setText("0.00");
        txtTotal.setName("txtTotal"); // NOI18N
        txtTotal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTotalKeyPressed(evt);
            }
        });
        add(txtTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 540, 240, 40));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText(" TOTAL   $");
        jLabel1.setName("jLabel1"); // NOI18N
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 540, 120, -1));

        btnFacturar.setBackground(new java.awt.Color(93, 141, 132));
        btnFacturar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/caja_ico.png"))); // NOI18N
        btnFacturar.setToolTipText("REALIZAR VENTA");
        btnFacturar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnFacturar.setName("btnFacturar"); // NOI18N
        btnFacturar.setPreferredSize(new java.awt.Dimension(64, 64));
        btnFacturar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnFacturarMouseClicked(evt);
            }
        });
        btnFacturar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFacturarActionPerformed(evt);
            }
        });
        btnFacturar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnFacturarKeyPressed(evt);
            }
        });
        add(btnFacturar, new org.netbeans.lib.awtextra.AbsoluteConstraints(827, 590, 64, 64));
    }// </editor-fold>//GEN-END:initComponents


    private void btncerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncerrarActionPerformed

        this.setVisible(false);// TODO add your handling code here:
    }//GEN-LAST:event_btncerrarActionPerformed

    private void txtCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCantidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCantidadActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void txtCodigoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoKeyPressed
        switch (evt.getKeyCode()) {
            case KeyEvent.VK_ENTER:
                if (txtCodigo.getText().trim().length() > 0) {
                    llenarTxtBusqueda(txtCodigo.getText().trim());
                    if (Integer.valueOf(txtCantidad.getText()) > 0) {
                        txtCantidad.setText("1");
                        actualizarTabla();
                        actualizarTotal();

                    }

                }
                txtCodigo.setText("");
                txtCodigo.requestFocus();

                break;
            case KeyEvent.VK_DOWN:
                txtNombre.requestFocus();
                break;
            case KeyEvent.VK_RIGHT:
                btnAgregarACarrito.requestFocus();
                break;
            default:
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoKeyPressed
    private void llenarTxtBusqueda(String Cod) {
        String sql = "SELECT * FROM PRODUCTO WHERE CODIGO=" + '"' + Cod + '"';
        Connection connection = new conectorDB().concectar();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet respuesta = stmt.executeQuery();
            if (respuesta.next()) {
                llenar(respuesta);
            } else {
                JOptionPane.showMessageDialog(null, "\n\tNO EXISTE EL PRODUCTO: " + Cod + "\n");

            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "\n" + ex.getErrorCode() + "\n" + ex.getMessage());

        }

    }

    private void llenar(ResultSet respuesta) {
        try {
            txtNombre.setText(respuesta.getString("NOMBRE"));
            txtPrecio.setText(String.valueOf(respuesta.getDouble("PRECIO")));
            txtCantidad.setText(String.valueOf(respuesta.getInt("CANTIDAD")));

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "\n" + ex.getErrorCode() + "\n" + ex.getMessage());
        }

    }
    private void txtNombreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyPressed
        switch (evt.getKeyCode()) {
            case KeyEvent.VK_ENTER:
                txtPrecio.requestFocus();
                break;
            case KeyEvent.VK_DOWN:
                txtPrecio.requestFocus();
                break;
            case KeyEvent.VK_RIGHT:
                btnAgregarACarrito.requestFocus();
                break;
            case KeyEvent.VK_UP:
                txtCodigo.requestFocus();
                break;
            default:
        }
// TODO add your handling code here:
    }//GEN-LAST:event_txtNombreKeyPressed

    private void txtPrecioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioKeyPressed
        switch (evt.getKeyCode()) {
            case KeyEvent.VK_ENTER:
                txtCantidad.requestFocus();
                break;
            case KeyEvent.VK_DOWN:
                txtCantidad.requestFocus();
                break;
            case KeyEvent.VK_RIGHT:
                btnAgregarACarrito.requestFocus();
                break;
            case KeyEvent.VK_UP:
                txtNombre.requestFocus();
                break;
            default:
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecioKeyPressed

    private void txtCantidadKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadKeyPressed
        switch (evt.getKeyCode()) {
            case KeyEvent.VK_ENTER:
                txtDescuento.requestFocus();
                break;
            case KeyEvent.VK_DOWN:
                txtDescuento.requestFocus();
                break;
            case KeyEvent.VK_RIGHT:
                btnAgregarACarrito.requestFocus();
                break;
            case KeyEvent.VK_UP:
                txtPrecio.requestFocus();
                break;
            default:
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCantidadKeyPressed

    private void btnAgregarACarritoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnAgregarACarritoKeyPressed
        switch (evt.getKeyCode()) {
            case KeyEvent.VK_ENTER:
                if (validarCampos()) {
                    actualizarTabla();
                    actualizarTotal();
                    txtCodigo.requestFocus();
                } else {

                    JOptionPane.showMessageDialog(null, "\n\tDATOS INCOMPLETOS \n");
                }

                break;
            case KeyEvent.VK_DOWN:
                txtCantidad.requestFocus();
                break;
            case KeyEvent.VK_LEFT:
                txtPrecio.requestFocus();
                break;
            case KeyEvent.VK_UP:
                txtCantidad.requestFocus();
                break;
            default:
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_btnAgregarACarritoKeyPressed

    private void txtTotalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTotalKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalKeyPressed

    private void txtDescuentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescuentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDescuentoActionPerformed

    private void btnAgregarACarritoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarACarritoActionPerformed

// TODO add your handling code here:
    }//GEN-LAST:event_btnAgregarACarritoActionPerformed

    private void btnDescuentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDescuentoActionPerformed

        // TODO add your handling code here:
    }//GEN-LAST:event_btnDescuentoActionPerformed

    private void btnDescuentoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_btnDescuentoItemStateChanged

        // TODO add your handling code here:
    }//GEN-LAST:event_btnDescuentoItemStateChanged

    private void btnFacturarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFacturarMouseClicked
        if (evt.getClickCount() == 2 && tblResultadoVenta.getRowCount() > 0) {
            realizarTransaccion();
            JOptionPane.showMessageDialog(null, "FACTURA REALIZADO");
            DefaultTableModel model = (DefaultTableModel) tblResultadoVenta.getModel();
            model.setRowCount(0);

        }

        // TODO add your handling code here:
    }//GEN-LAST:event_btnFacturarMouseClicked

    private void btnFacturarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFacturarActionPerformed

        // TODO add your handling code here:
    }//GEN-LAST:event_btnFacturarActionPerformed

    private void btnFacturarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnFacturarKeyPressed
        switch (evt.getKeyCode()) {
            case KeyEvent.VK_ENTER:
                if (tblResultadoVenta.getRowCount() > 0) {
                    realizarTransaccion();
                    JOptionPane.showMessageDialog(null, "FACTURA REALIZADO");
                    DefaultTableModel model = (DefaultTableModel) tblResultadoVenta.getModel();
                    model.setRowCount(0);
                }
                break;
            case KeyEvent.VK_UP:
                txtDescuento.requestFocus();
                break;
            case KeyEvent.VK_DOWN:
                txtCodigo.requestFocus();
                break;

            default:

        }

        // TODO add your handling code here:
    }//GEN-LAST:event_btnFacturarKeyPressed

    private void txtDescuentoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescuentoKeyPressed
        switch (evt.getKeyCode()) {
            case KeyEvent.VK_ENTER:
                btnAgregarACarrito.requestFocus();
                break;
            case KeyEvent.VK_DOWN:
                btnFacturar.requestFocus();
                break;
            case KeyEvent.VK_RIGHT:
                btnAgregarACarrito.requestFocus();
                break;
            case KeyEvent.VK_UP:
                txtCantidad.requestFocus();
                break;
            default:
        }

// TODO add your handling code here:
    }//GEN-LAST:event_txtDescuentoKeyPressed

    private void btnAgregarACarritoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgregarACarritoMouseClicked
        if (validarCampos()) {
            actualizarTabla();
            actualizarTotal();
            txtCodigo.requestFocus();
        } else {

            JOptionPane.showMessageDialog(null, "\n\tDATOS INCOMPLETOS \n");
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAgregarACarritoMouseClicked

    private void opcEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcEliminarActionPerformed
        eliminarSelecion();
        // TODO add your handling code here:
    }//GEN-LAST:event_opcEliminarActionPerformed

    private void eventListenerKey() {
        tblResultadoVenta.addMouseListener(new MouseAdapter() {
            public void mousePressed(KeyEvent evt) {
                JTable tabla = (JTable) evt.getSource();
                if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                    actualizarTotal();
                }
            }

        });
    }
    private void tblResultadoVentaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblResultadoVentaKeyTyped
        switch (evt.getKeyCode()) {
            case KeyEvent.VK_ENTER:
                actualizarTotal();
                break;

            default:
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_tblResultadoVentaKeyTyped

    private void tblResultadoVentaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblResultadoVentaKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tblResultadoVentaKeyPressed

    private void tblResultadoVentaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblResultadoVentaMouseEntered
        actualizarTotal();
        // TODO add your handling code here:
    }//GEN-LAST:event_tblResultadoVentaMouseEntered

    private void eliminarSelecion() {
        int filas[] = tblResultadoVenta.getSelectedRows();
        DefaultTableModel model = (DefaultTableModel) tblResultadoVenta.getModel();
        while (filas.length > 0) {
            model.removeRow(tblResultadoVenta.convertRowIndexToModel(filas[0]));
            filas = tblResultadoVenta.getSelectedRows();
        }
        tblResultadoVenta.clearSelection();
    }

    private void realizarTransaccion() {
        Factura factura = new Factura();
        Cliente cliente = new Cliente();
        cliente.setCi(Ctrl_Persona.buscarCiEnDB(boxClientes.getSelectedItem().toString()));
        cliente.setNombre(boxClientes.getSelectedItem().toString());

        factura.setData(LocalDate.now().toString());
        factura.setTime(LocalTime.now().toString());
        factura.setCliente(cliente);
        /*ACTUALIZAR CUOTA*/
        cliente.setCouta(Ctrl_Cliente.getCuota(cliente.getCi()));
        factura.setEstadoPago(Boolean.TRUE);
        factura.setMonto(sumaProducto(3, 4));
        factura.setCodigo(Ctrl_Factura.ultimaFactura() + 1);
        Ctrl_Factura.realizarFactura(factura);
        JOptionPane.showMessageDialog(null, "El CODIGO FACTURA GENERADO\n\t " + factura.getCodigo());

        realizarDetalles(factura);
    }

    private void realizarDetalles(Factura factura) {
        int cantProd = tblResultadoVenta.getRowCount();
        for (int i = 0; i < cantProd; i++) {
            DetallesDeFactura detallesDeFactura = new DetallesDeFactura();
            Producto producto = new Producto();

            producto.setCodigo(tblResultadoVenta.getValueAt(i, 1).toString());
            producto.setNombre(tblResultadoVenta.getValueAt(i, 2).toString());
            JOptionPane.showMessageDialog(null, factura.getCodigo() + "  " + producto.getCodigo());

            detallesDeFactura.setProducto(producto);
            detallesDeFactura.setFactura(factura);
            detallesDeFactura.setCantidad(Integer.valueOf(tblResultadoVenta.getValueAt(i, 3).toString()));
            detallesDeFactura.setPrecioVenta(Double.valueOf(tblResultadoVenta.getValueAt(i, 4).toString()));
            detallesDeFactura.setTotalParcial(detallesDeFactura.getPrecioVenta() * detallesDeFactura.getCantidad());

            Ctrl_Detalle_Factura.realizarDetalleFactura(detallesDeFactura);
            Ctrl_Producto.actualizarProducto(producto, detallesDeFactura.getCantidad());

            imprimirFactura(detallesDeFactura);
        }

    }

    private void imprimirFactura(DetallesDeFactura ddf) {
        DefaultTableModel model = (DefaultTableModel) tblResultadoVenta.getModel();

        Document document = new Document();
        String ruta = System.getProperty("user.home");

        OutputStream outputStream;
        try {
            outputStream = new FileOutputStream(new File(ruta + "/Desktop/factura" + ddf.getFactura().getCliente().getNombre() + ".pdf"));
            try {
                PdfWriter.getInstance(document, outputStream);
                document.open();
                PdfPTable tabla = new PdfPTable(6);
                tabla.setHeaderRows(0);
                llenarEncabezado(tabla,tblResultadoVenta);
               
                
                 llenarTabla(tabla, tblResultadoVenta);

                document.add(new Paragraph("\n\t\tFACTURACION EMPRESA-X\t"+LocalDate.now().toString(), new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.COURIER, 24, WHEN_FOCUSED)));
                document.add(new Paragraph("\n\n\n"));
                 document.add(tabla);
                document.add(new Paragraph(""));
                 document.add(new Paragraph("\n\n\n"));

                document.add(new Paragraph(" Fecha: "+LocalDate.now().format(DateTimeFormatter.ISO_DATE)+"\nHora: "+LocalTime.now().toString()));

                document.close();
                JOptionPane.showMessageDialog(null, "Documento creado");
            } catch (DocumentException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }

        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
private void llenarEncabezado(PdfPTable table,JTable tablaR){
     
    table.addCell(tablaR.getModel().getColumnName(0).toString());
    table.addCell(tablaR.getModel().getColumnName(1).toString());
    table.addCell(tablaR.getModel().getColumnName(2).toString());
    table.addCell(tablaR.getModel().getColumnName(3).toString());
    table.addCell(tablaR.getModel().getColumnName(4).toString());
     table.addCell(tablaR.getModel().getColumnName(5).toString());
 
}
    private void llenarTabla(PdfPTable tabla, JTable tblResultadoVenta) {
        DefaultTableModel model = (DefaultTableModel) tblResultadoVenta.getModel();

        for (int i = 0; i < model.getRowCount(); i++) {

            for (int j = 0; j < model.getColumnCount(); j++) {
                tabla.addCell(model.getValueAt(i, j).toString());
            }
        }

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel FONDO;
    private javax.swing.JComboBox<String> boxClientes;
    private javax.swing.JButton btnAgregarACarrito;
    private javax.swing.JRadioButton btnDescuento;
    private javax.swing.JButton btnFacturar;
    private javax.swing.JButton btncerrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private java.awt.Label lblDescuento;
    private javax.swing.JLabel lblImagen;
    private java.awt.Label lblcodigo;
    private java.awt.Label lblcodigo1;
    private java.awt.Label lblcodigo2;
    private java.awt.Label lblcodigo4;
    private java.awt.Label lblcodigo5;
    private javax.swing.JPopupMenu menuPopup;
    private javax.swing.JMenuItem opcEditar;
    private javax.swing.JMenuItem opcEliminar;
    private java.awt.Panel panel1;
    private javax.swing.JTable tblResultadoVenta;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtDescuento;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables

}
