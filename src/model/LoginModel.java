/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import entity.UsuarioBean;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.ConexionModel;

/**
 *
 * @author Edu
 */
public class LoginModel {
    
    static boolean resultado=false;
    static String query="";
    static ConexionModel conexion;
    static ResultSet rs;
    
    static public boolean CheckPassword (UsuarioBean InfoUser) throws SQLException
    {
        String user;
        String password;
        user = InfoUser.getLoginUsuario();
        password = InfoUser.getPasswordUsuario();
        conexion = new ConexionModel();
        query = "SELECT EXISTS(SELECT * FROM usuario WHERE loginUsuario = ? AND passwordUsuario = ?)";
        PreparedStatement ps = conexion.connect.prepareStatement(query);
        ps.setString(1,user);
        ps.setString(2, password);
        conexion.setRs(ps);
        rs = conexion.getRs();
        rs.next();
        int resultadoQuery = Integer.parseInt(rs.getString(1));
        
        if (resultadoQuery == 1) {
            
            resultado = true;
            return resultado;
            
        }
        else
        {
            resultado = false;
            return resultado;
        }
    }
    
}
