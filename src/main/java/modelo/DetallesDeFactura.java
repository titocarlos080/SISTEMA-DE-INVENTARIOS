
package modelo;

/**
 *
 * @author hp
 */
public class DetallesDeFactura {
    private Producto producto;
    private Factura factura;
    private Double precioVenta;
    private Integer cantidad;
    private Double totalParcial;

    public DetallesDeFactura() {
      this.producto = new Producto();
        this.factura = new Factura();
        this.precioVenta = 0.0;
        this.cantidad = 0;
        this.totalParcial=0.0;
    }
     
    public DetallesDeFactura(Producto producto, Factura factura, Double precioVenta, Integer cantidad,Double totalParcial) {
        this.producto = producto;
        this.factura = factura;
        this.precioVenta = precioVenta;
        this.cantidad = cantidad;
        this.totalParcial=totalParcial;
    }

    public Double getTotalParcial() {
        return totalParcial;
    }

    public void setTotalParcial(Double totalParcial) {
        this.totalParcial = totalParcial;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public Double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(Double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
    
    
    
}
