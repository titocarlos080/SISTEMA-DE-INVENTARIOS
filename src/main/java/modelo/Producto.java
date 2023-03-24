package modelo;

import java.awt.Image;
import java.io.File;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

/**
 *
 * @author hp
 */
public class Producto {

    private String codigo;
    private String nombre;
    private Integer cantidad;
    private Double precio;
    private File imagen;

    public Producto(String codigo, String nombre, Integer cantidad, Double precio, File imagen) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
        this.imagen = imagen;
    }

    public Producto() {
         this.codigo = null;
         this.nombre = "";
        this.cantidad = 0;
        this.precio = 0.0;
        this.imagen = null;
    }
     
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public File getImagen() {
        return imagen;
    }

    public void setImagen(File imagen) {
        this.imagen = imagen;
    }
   

}
