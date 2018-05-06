/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import entity.ProductoBean;
import entity.SalidaBean;
import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author alvin
 */
public class SalidaModel {
    boolean resultado = false;
    String query = "";
    ConexionModel conexion;
    utilModel utilidades;
    ResultSet rs;

    public boolean newSalida(SalidaBean salidaData) throws SQLException {   
        resultado = false;
        
        
        query = "INSERT INTO salida(id_entrada,cantidadSalida,tipoSalida, id_receta,id_vale) VALUES(?,?,?,?,?)";
        conexion = new ConexionModel();
        PreparedStatement ps = conexion.connect.prepareStatement(query);
        ps.setInt(1, salidaData.getId_Entrada().getIdEntrada());
        ps.setFloat(2, salidaData.getCantidadSalida());
        ps.setInt(3, salidaData.getTipoSalida());
        ps.setInt(4, salidaData.getId_receta().getIdReceta());
        ps.setInt(5, salidaData.getId_vale().getIdVale());
        return conexion.executeQuery(ps);
    }
}
