/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author hp
 */
public class Categoria {

    private Integer ID;
    private String Descripcion;

    public Categoria() {
        this.ID = null;
        this.Descripcion = "";
    }

    public Categoria(Integer ID, String Descripcion) {
        this.ID = ID;
        this.Descripcion = Descripcion;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

}
