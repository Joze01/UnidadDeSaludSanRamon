/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.LoteBean;
import entity.ProveedorBean;
import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import static model.LoteModel.query;

/**
 *
 * @author Jose
 */
public class ProveedorModel {

    boolean resultado = false;
    String query = "";
    ConexionModel conexion;
    utilModel utilidades;
    ResultSet rs;

    public boolean newProveedor(ProveedorBean provedorData) throws SQLException {

        resultado = false;
        query = "INSERT INTO proveedor(nombreProveedor, descripcionProveedor, estadoproveedor) VALUES (?,?,?)";
        conexion = new ConexionModel();
        PreparedStatement ps = conexion.connect.prepareStatement(query);
        ps.setString(1, provedorData.getNombreProveedor());
        ps.setString(2, provedorData.getDescripcionProveedor());
        ps.setInt(3, provedorData.getEstadoProveedor());
        System.out.println(ps.toString());
        if (conexion.executeQuery(ps)) {
            resultado = true;
        }

        return resultado;
    }

    public boolean updateProveedor(ProveedorBean provedorData) throws SQLException {
        resultado = false;
        conexion = new ConexionModel();
        query = "UPDATE proveedor SET nombreProveedor=?,"
                + "descripcionProveedor=? "                
                + "WHERE idProveedor=?";
        PreparedStatement ps = conexion.connect.prepareStatement(query);
        ps.setString(1, provedorData.getNombreProveedor());
        ps.setString(2, provedorData.getDescripcionProveedor());        
        ps.setInt(3, provedorData.getIdProveedor());
        System.out.println(ps.toString());
        if (conexion.executeQuery(ps)) {
            resultado = true;
        }
        return resultado;
    }

    public boolean deleteProveedor(ProveedorBean provedorData) throws SQLException {
        resultado = false;
        conexion = new ConexionModel();
        query = "update proveedor set estadoProveedor=0 WHERE idProveedor=?";
        PreparedStatement ps = conexion.connect.prepareStatement(query);
        ps.setInt(1, provedorData.getIdProveedor());
        System.out.println(ps.toString());
        if (conexion.executeQuery(ps)) {
            resultado = true;
        }
        return resultado;
    }

    public JTable cargarTabla() throws SQLException {
        utilidades = new utilModel();
        JTable tablaResultado;
        query = "select * from proveedor where estadoproveedor=1";
        conexion = new ConexionModel();
        PreparedStatement ps = conexion.connect.prepareStatement(query);
        conexion.setRs(ps);
        rs = conexion.getRs();
        String[] columnas = new String[]{"#", "Nombre", "Descripcion"};
        tablaResultado = utilidades.cargarTabla(columnas, rs);
        conexion.close();

        return tablaResultado;
    }
    
    public JTable busqueda(String valor) throws SQLException {
        utilidades = new utilModel();
        JTable tablaResultado;
        query = "select * from proveedor where (nombreProveedor like '"+valor+"%' or "
                + "descripcionProveedor like '"+valor+"%') and estadoProveedor=1";
        conexion = new ConexionModel();
        PreparedStatement ps = conexion.connect.prepareStatement(query);
        conexion.setRs(ps);
        rs = conexion.getRs();
        String[] columnas = new String[]{"#", "Nombre", "Descripcion"};
        tablaResultado = utilidades.cargarTabla(columnas, rs);
        conexion.close();

        return tablaResultado;
    }
    
        public ProveedorBean getProveedorById(int idProveedor) throws SQLException{
        ProveedorBean nuevoProveedor = new ProveedorBean();
        query = "SELECT * FROM proveedor WHERE idProveedor = ?";
        conexion = new ConexionModel();
        PreparedStatement ps = conexion.connect.prepareStatement(query);
        ps.setInt(1, idProveedor);
        conexion.setRs(ps);
        rs = conexion.getRs();
        if(rs.next()){
           nuevoProveedor.setIdProveedor(rs.getInt(1));
           nuevoProveedor.setNombreProveedor(rs.getString(2));
           nuevoProveedor.setDescripcionProveedor(rs.getString(3));
           nuevoProveedor.setEstadoProveedor(rs.getInt(4));
        }
        return nuevoProveedor;
        
    }
    
    
    
    
}
