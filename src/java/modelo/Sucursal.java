/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author xdook
 */
public class Sucursal {
    int id;
    String nombre;
    String domicilio;
    String usuario;

    public Sucursal() {
    }

    public Sucursal( String nombre, String domicilio, String usuario) {
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.usuario = usuario;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDomicilio() {
        return domicilio;
    }
    
    public String getUsuario() {
        return usuario;
    }

   

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    
    
    
    
}
