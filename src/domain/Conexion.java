/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import utis.Mensajes;

/**
 *
 * @author Super
 */
public class Conexion {
    
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/recursos_humanos_iud?serverTimezone=UTC";
    private static final String USUARIO = "root";
    private static final String PASSWORD = "12345678";
    
    private Connection con;

    public Conexion() {
        try {
            con = DriverManager.getConnection(URL, USUARIO, PASSWORD);
            con.createStatement();
        } catch (SQLException ex) {
            Mensajes.mensajeError("Error conexión", ex.getMessage());
        }
    }
    
    

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }
    
    
    
}
