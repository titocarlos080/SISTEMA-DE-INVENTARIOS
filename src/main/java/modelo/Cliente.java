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
public class Cliente extends Persona{
    private Double couta ;
    public Cliente() {
        
    }
   public Cliente(Integer ci, String nombre, String sexo, String telefono, File fileFoto, Boolean tipoCliente, Boolean tipoVendedor) {
        super(ci, nombre, sexo, telefono, fileFoto, tipoCliente, tipoVendedor);
    }

    public Double getCouta() {
        return couta;
    }

    public void setCouta(Double couta) {
        this.couta = couta;
 
    }

 
     
    
 
}
