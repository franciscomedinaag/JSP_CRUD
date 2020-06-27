/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author xdook
 */
public class Conexion {
    Connection con;
    
    /**
     * Se activa el conector y se instancia la conexión con la base de datos
     */
    public Conexion() {
        try { 
            Class.forName("com.mysql.jdbc.Driver"); 
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/miniproyecto2.0", "root", "");
        } catch (ClassNotFoundException ex) { 
            System.out.println("Error al cargar el driver " + ex.getMessage()); 
        } catch (SQLException e){
            System.out.println("Error al cargar la base de datos" + e.getMessage());
        }
    }
    
    public Connection getConnection(){
        return con;
    }
}
