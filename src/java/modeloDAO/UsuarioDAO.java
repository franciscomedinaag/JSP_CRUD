/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloDAO;

import config.Conexion;
import interfaz.CRUD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Sucursal;
import modelo.Usuario;
import modelo.Zapato;

/**
 *
 * @author xdook
 */
public class UsuarioDAO implements CRUD{
//la interfaz CRUD dice que estos metodos se van a usar, pero cada clase hace cosas diferentes con estos metodos
    Conexion cn=new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Usuario u=new Usuario();
    Sucursal s=new Sucursal();
    Zapato z=new Zapato();
    
//////////////////////////////////////// Modelo  Usuario //////////////////////////////////////////////////////////////////
    @Override
    public List listar() {
        ArrayList<Usuario>list=new ArrayList();
        String sql="select * from usuario";
        
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Usuario user=new Usuario();
                user.setId(rs.getInt("id"));
                user.setEmail(rs.getString("email"));
                user.setUsername(rs.getString("username"));
                list.add(user);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
      return list;
    }
    
    @Override
    public Usuario list(int id) {
       String sql="select * from usuario where id="+id;
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                u.setId(rs.getInt("id"));
                u.setEmail(rs.getString("email"));
                u.setUsername(rs.getString("username"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

      return u;
    }

    @Override
    public boolean add(Usuario user) {
        String sql="insert into usuario (username, email, password) values ('"+user.getUsername()+"','"+user.getEmail()+"','"+user.getPassword()+"')";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
       return false;
    }

    @Override
    public boolean edit(Usuario user) {
        String sql="update usuario set username='"+user.getUsername()+"', email='"+user.getEmail()+"', password='"+user.getPassword()+"' where id="+user.getId();
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
       String sql="delete from usuario where id="+id;
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
       
       return false;
    }
    
    public boolean login(String usuario, String pass) {
        String sql="select * from usuario where username = ? AND password = ?";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.setString(1, usuario);
            ps.setString(2, pass);
            rs=ps.executeQuery();
            if(rs.next()) {
                System.out.println("Hay respuesta");
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public List listarSucursal() {
        ArrayList<Sucursal>list=new ArrayList();
        String sql="select * from sucursal";
        
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Sucursal suc= new Sucursal();
                suc.setId(rs.getInt("id"));
                suc.setDomicilio(rs.getString("domicilio"));
                suc.setNombre(rs.getString("nombre"));
                suc.setUsuario(rs.getString("usuario"));
                list.add(suc);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
      return list;
    }

    @Override
    public Sucursal listSucursal(int id) {
        String sql="select * from sucursal where id="+id;
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                s.setId(rs.getInt("id"));
                s.setDomicilio(rs.getString("domicilio"));
                s.setNombre(rs.getString("nombre"));
                s.setUsuario(rs.getString("usuario"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

      return s;
    }

    @Override
    public boolean addSucursal(Sucursal suc) {
       String sql="insert into sucursal (nombre, domicilio, usuario) values ('"+suc.getNombre()+"','"+suc.getDomicilio()+"','"+suc.getUsuario()+"')";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException e) {
        }
       return false;
    }

    @Override
    public boolean editSucursal(Sucursal suc) {
        String sql="update sucursal set nombre='"+suc.getNombre()+"', domicilio='"+suc.getDomicilio()+"', usuario='"+suc.getUsuario()+"' where id="+suc.getId();
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException e) {
        }
        return false;
    }

    @Override
    public boolean deleteSucursal(int id) {
       String sql="delete from sucursal where id="+id;
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
       
       return false;
    }
    
    @Override
    public List listarZapatos() {
        ArrayList<Zapato>list=new ArrayList();
        String sql="select * from zapatos";
        
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Zapato zap= new Zapato();
                zap.setId(rs.getInt("id"));
                zap.setModelo(rs.getString("modelo"));
                zap.setPrecio(rs.getInt("precio"));
                zap.setTalla(rs.getInt("talla"));
                zap.setSucursal(rs.getString("sucursal"));
                list.add(zap);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
      return list;
    }
    
    @Override
    public Zapato listZapato(int id){
        String sql="select * from zapatos where id="+id;
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                z.setId(rs.getInt("id"));
                z.setModelo(rs.getString("modelo"));
                z.setPrecio(rs.getInt("precio"));
                z.setTalla(rs.getInt("talla"));
                z.setSucursal(rs.getString("sucursal"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

      return z;
    }
    
    @Override
    public boolean addZapato(Zapato zap){
        String sql="insert into zapatos (modelo, talla, precio, sucursal) values ('"+zap.getModelo()+"','"+zap.getTalla()+"','"+zap.getPrecio()+"','"+zap.getSucursal()+"')";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException e) {
        }
       return false;
    }
    
    @Override
    public boolean editZapato(Zapato zap){
        String sql="update zapatos set modelo='"+zap.getModelo()+"', talla='"+zap.getTalla()+"', precio='"+zap.getPrecio()+ "', sucursal='" + zap.getSucursal() + "' where id="+zap.getId();
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException e) {
        }
        return false;
    }
    
    @Override
    public boolean deleteZapato(int id){
        String sql="delete from zapatos where id="+id;
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
       
       return false;
    }
}
