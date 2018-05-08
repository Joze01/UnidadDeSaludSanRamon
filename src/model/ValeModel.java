/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.RecetaBean;
import entity.ValeBean;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import static model.RecetaModel.resultado;

/**
 *
 * @author Jose
 */
public class ValeModel {
     static boolean resultado=false;
    static String query="";
    static ConexionModel conexion;
    static utilModel utilidades;
    static ResultSet rs;
    
    public boolean newVale(ValeBean valeData) throws SQLException{
        resultado = false;
        query = "INSERT INTO vale(codigovale, id_destinatario) VALUES (?,?)";
        conexion = new ConexionModel();
        PreparedStatement ps = conexion.connect.prepareStatement(query);
        ps.setString(1, valeData.getCodigoVale());
        ps.setInt(2, valeData.getId_destinatario().getIdDestinatario());
        System.out.println(ps.toString());
        return conexion.executeQuery(ps);
        
    
    }
    
    
        public ValeBean getLastReceta() throws SQLException{
        
        ValeBean objVale = null;
        query = "SELECT * FROM Vale ORDER BY idVale DESC LIMIT 1";
        conexion = new ConexionModel();
        PreparedStatement ps = conexion.connect.prepareStatement(query);
        conexion.setRs(ps);
        rs = conexion.getRs();
        if(rs.next()){
            objVale = new ValeBean();
            objVale.setIdVale(rs.getInt(1));
            objVale.setCodigoVale(rs.getString(2));
            
        }
        return objVale;
    }
    
    
    
    
}
