/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import entity.ProveedorBean;
import model.ConexionModel;
import model.ProveedorModel;
import model.utilModel;
import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jose
 */
public class ProveedorModel {
    boolean resultado=false;
    String query="";
    ConexionModel conexion;
    utilModel utilidades;
    ResultSet rs;
    
    public boolean newProveedor(ProveedorBean provedorData) throws SQLException{
       
        resultado=false;
         query = "INSERT INTO proveedor(nombreProveedor, descripcionProveedor, estadoproveedor) VALUES (?,?,?)";
        conexion = new ConexionModel();
        PreparedStatement ps = conexion.connect.prepareStatement(query);
        ps.setString(1, provedorData.getNombreProveedor());
        ps.setString(2, provedorData.getDescripcionProveedor());
        ps.setInt(3, provedorData.getEstadoProveedor());
        System.out.println(ps.toString());
        if(conexion.executeQuery(ps)){
         resultado=true;
        }
        
        return resultado;
    }
    
    public boolean updateProveedor(ProveedorBean provedorData) throws SQLException{
        resultado=false;
        conexion = new ConexionModel();
         query = "UPDATE proveedor SET nombreProveedor=?,"
                + "descripcionProveedor=?,"
                + "estadoproveedor=? "
                + "WHERE idProveedor=?";
        PreparedStatement ps = conexion.connect.prepareStatement(query);
        ps.setString(1, provedorData.getNombreProveedor());
        ps.setString(2, provedorData.getDescripcionProveedor());
        ps.setInt(3, provedorData.getEstadoProveedor());
        ps.setInt(4, provedorData.getIdProveedor());
        System.out.println(ps.toString());
        if(conexion.executeQuery(ps)){
         resultado=true;
        }
        return resultado;
    }
    
    public boolean deleteProveedor(ProveedorBean provedorData) throws SQLException{
        resultado=false;
        conexion = new ConexionModel();
         query = "DELETE FROM proveedor WHERE idProveedor?";
        PreparedStatement ps = conexion.connect.prepareStatement(query);
        System.out.println(ps.toString());
        if(conexion.executeQuery(ps)){
         resultado=true;
        }
        return resultado;
    }
    public JTable cargarTabla() throws SQLException{
        utilidades=new utilModel();
        JTable tablaResultado;
         query = "select * from proveedor";
        conexion = new ConexionModel();
        PreparedStatement ps = conexion.connect.prepareStatement(query);
        conexion.setRs(ps);
        rs=conexion.getRs();
        String[] columnas = new String[]{"#","Nombre","Descripcion","Estado"};
        tablaResultado=utilidades.cargarTabla(columnas, rs);
        conexion.close();
                
        
        return tablaResultado;
    }
}
