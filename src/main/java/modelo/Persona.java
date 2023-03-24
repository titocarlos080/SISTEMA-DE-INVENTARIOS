 
package modelo;

import java.io.File;

/**
 *
 * @author hp
 */
public class Persona {
    protected Integer ci;
    protected String nombre;
    protected String sexo;
    protected String telefono;
    protected File fileFoto;
    protected Boolean tipoCliente;
    protected Boolean tipoVendedor;
     
    public Persona() {
        this.ci=null;
        this.nombre="";
        this.sexo="";
        this.telefono="";
        this.fileFoto=null;
        this.tipoCliente=false;
        this.tipoVendedor=false;
    }

    public Persona(Integer ci, String nombre, String sexo, String telefono, File fileFoto, Boolean tipoCliente, Boolean tipoVendedor) {
        this.ci = ci;
        this.nombre = nombre;
        this.sexo = sexo;
        this.telefono = telefono;
        this.fileFoto = fileFoto;
        this.tipoCliente = tipoCliente;
        this.tipoVendedor = tipoVendedor;
    }

    public Integer getCi() {
        return ci;
    }

    public void setCi(Integer ci) {
        this.ci = ci;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public File getFileFoto() {
        return fileFoto;
    }

    public void setFileFoto(File fileFoto) {
        this.fileFoto = fileFoto;
    }

    public Boolean getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(Boolean tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    public Boolean getTipoVendedor() {
        return tipoVendedor;
    }

    public void setTipoVendedor(Boolean tipoVendedor) {
        this.tipoVendedor = tipoVendedor;
    }
    
}
