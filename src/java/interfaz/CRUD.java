/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import java.util.List;
import modelo.Sucursal;
import modelo.Usuario;
import modelo.Zapato;

/**
 *
 * @author xdook
 */
public interface CRUD {
    public List listar();
    public Usuario list(int id);
    public boolean add(Usuario per);
    public boolean edit(Usuario per);
    public boolean delete(int id);
    
    public List listarSucursal();
    public Sucursal listSucursal(int id);
    public boolean addSucursal(Sucursal suc);
    public boolean editSucursal(Sucursal suc);
    public boolean deleteSucursal(int id);
    
    public List listarZapatos();
    public Zapato listZapato(int id);
    public boolean addZapato(Zapato zap);
    public boolean editZapato(Zapato zap);
    public boolean deleteZapato(int id);
    
}
