/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import entity.RecetaBean;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author alvin
 */
public class RecetaModel {
    static boolean resultado=false;
    static String query="";
    static ConexionModel conexion;
    static utilModel utilidades;
    static ResultSet rs;
    
    public RecetaBean getLastReceta() throws SQLException{
        
        RecetaBean objeReceta = null;
        query = "SELECT * FROM receta ORDER BY idReceta DESC LIMIT 1";
        conexion = new ConexionModel();
        PreparedStatement ps = conexion.connect.prepareStatement(query);
        conexion.setRs(ps);
        rs = conexion.getRs();
        if(rs.next()){
            objeReceta = new RecetaBean();
            objeReceta.setIdReceta(rs.getInt("idReceta"));
            objeReceta.setCodigoReceta(rs.getString("codigoReceta"));
            objeReceta.setFechaEntrega(rs.getDate("fechaEntrega"));
        }
        return objeReceta;
    }
    
    public RecetaBean getRecetaById(int idReceta) throws SQLException{
        
        RecetaBean objeReceta = null;
        query = "SELECT * FROM receta WHERE idReceta = ?";
        conexion = new ConexionModel();
        PreparedStatement ps = conexion.connect.prepareStatement(query);
        ps.setInt(1, idReceta);
        conexion.setRs(ps);
        rs = conexion.getRs();
        if(rs.next()){
            objeReceta = new RecetaBean();
            objeReceta.setIdReceta(rs.getInt("idReceta"));
            objeReceta.setCodigoReceta(rs.getString("codigoReceta"));
            objeReceta.setFechaEntrega(rs.getDate("fechaEntrega"));
        }
        return objeReceta;
    }
    
    public Boolean newReceta(RecetaBean objeReceta) throws SQLException
    {
        resultado = false;
        query = "INSERT INTO receta(codigoReceta, fechaEntrega) VALUES (?,?)";
        conexion = new ConexionModel();
        PreparedStatement ps = conexion.connect.prepareStatement(query);
        ps.setString(1, objeReceta.getCodigoReceta());
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String myDate = sdf.format(objeReceta.getFechaEntrega());
        ps.setString(2, myDate);
        System.out.println(ps.toString());
        return conexion.executeQuery(ps);
    }
}
