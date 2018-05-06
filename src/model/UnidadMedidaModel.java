/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.UnidadMedidaBean;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author alvin
 */
public class UnidadMedidaModel {
    
    static boolean resultado=false;
    static String query="";
    static ConexionModel conexion;
    static utilModel utilidades;
    static ResultSet rs;
    
    public UnidadMedidaBean getById(int idUnidadMedida) throws SQLException
    {
        UnidadMedidaBean objUnidadMedida = new UnidadMedidaBean();
        query = "SELECT * FROM unidadmedida WHERE idUnidadMedida = ?";
        conexion = new ConexionModel();
        PreparedStatement ps = conexion.connect.prepareStatement(query);
        ps.setInt(1, idUnidadMedida);
        conexion.setRs(ps);
        rs = conexion.getRs();
        objUnidadMedida.setIdUnidadMedida(rs.getInt("idUnidadMedida"));  
        objUnidadMedida.setNombreUnidadMedida(  rs.getString("nombreUnidadMedida"));
        objUnidadMedida.setDescripcionUnidadMedida(rs.getString("descripcionUnidadMedida"));
        objUnidadMedida.setEstadoUnidadMedida(rs.getInt("estadoUnidadMedida"));
        return objUnidadMedida;
    }
}
