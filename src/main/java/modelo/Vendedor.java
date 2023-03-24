/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.File;

/**
 *
 * @author hp
 */
public class Vendedor extends Persona {

    private String codigo;
    private String contraseña;
    private Categoria categoria;
    public Vendedor() {
        super();
         this.codigo = "";
        this.contraseña = "";
        this.categoria=null;
    }

    public Vendedor(String codigo, String contraseña,Categoria categoria) {
        this.codigo = codigo;
        this.contraseña = contraseña;
        this.categoria=categoria;
    }

    public Vendedor(Integer ci, String nombre, String sexo, String telefono, File fileFoto, Boolean tipoCliente, Boolean tipoVendedor,String codigo, String contraseña,Categoria categoria) {
        
        super(ci, nombre, sexo, telefono, fileFoto, tipoCliente, tipoVendedor);
        this.codigo = codigo;
        this.contraseña = contraseña;
        this.categoria=categoria;
    }
 
  
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
