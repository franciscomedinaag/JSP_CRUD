/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author pabca
 */
public class Zapato {
    int id;
    String modelo;
    int talla;
    int precio;
    String sucursal;

    public Zapato(int id, String modelo, int talla, int precio, String sucursal) {
        this.modelo = modelo;
        this.talla = talla;
        this.precio = precio;
        this.sucursal = sucursal;
    }

    public Zapato(){}

    public void setId(int id) {
        this.id = id;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setTalla(int talla) {
        this.talla = talla;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }

    public int getId() {
        return id;
    }

    public String getModelo() {
        return modelo;
    }

    public int getTalla() {
        return talla;
    }

    public int getPrecio() {
        return precio;
    }

    public String getSucursal() {
        return sucursal;
    }
            
    
    
}
