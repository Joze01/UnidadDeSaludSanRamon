/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.EntradaBean;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author alvin
 */
public class EntradaModel {
    
    static boolean resultado=false;
    static String query="";
    static ConexionModel conexion;
    static utilModel utilidades;
    static ResultSet rs;
    
    public EntradaBean getById(int idEntrada) throws SQLException
    {
        EntradaBean objEntrada = new EntradaBean();
        query = "SELECT * FROM entrada WHERE idEntrada = ?";
        conexion = new ConexionModel();
        PreparedStatement ps = conexion.connect.prepareStatement(query);
        ps.setInt(1, idEntrada);
        conexion.setRs(ps);
        rs = conexion.getRs();
        objEntrada.setIdEntrada(rs.getInt("idUnidadMedida"));  
        return objEntrada;
    }
    
}
