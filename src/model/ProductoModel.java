/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import entity.ProductoBean;
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
 * @author Edu
 */
public class ProductoModel {
    
    static boolean resultado=false;
    static String query="";
    static ConexionModel conexion;
    static utilModel utilidades;
    static ResultSet rs;
    
    public  boolean newProducto(ProductoBean productoData) throws SQLException 
    {
        query = "insert into producto (producto.codigoProducto, producto.nombreProducto,producto.nivelUsoProducto,producto.descripcionProducto,producto.id_UnidadMedida) " +
                "values (?,?,?,?,?);";
        conexion = new ConexionModel();
        PreparedStatement ps = conexion.connect.prepareStatement(query);
        ps.setString(1, productoData.getCodigoProducto());
        ps.setString(2,productoData.getNombreProducto());
        ps.setString(3,productoData.getNivelUsoProducto());
        ps.setString(4,productoData.getDescripcionProducto());
        ps.setInt(5,productoData.getId_EntradaProducto().getIdEntrada());
        System.out.println(ps.toString());
        
        if (conexion.executeQuery(ps)) {
            return true;
        }
        return false;
    }
    
    public  boolean updateProducto(ProductoBean productoBean) throws SQLException
    {
        query ="update producto set" +
               "producto.nombreProducto = ?," +
               "producto.nivelUsoProducto = ?," +
               "producto.descripcionProducto = ?," +
               "producto.id_UnidadMedida = ?" +
               "where producto.codigoProducto = ?";
        conexion = new ConexionModel();
        PreparedStatement ps = conexion.connect.prepareStatement(query);
        ps.setString(1,productoBean.getNombreProducto());
        ps.setString(2,productoBean.getNivelUsoProducto());
        ps.setString(3,productoBean.getDescripcionProducto());
        ps.setInt(4,productoBean.getId_unidadMedida().getIdUnidadMedida());
        ps.setString(5,productoBean.getCodigoProducto());
        
        if (conexion.executeQuery(ps)) {
            return true;
        }
        return false;
        
    }
    
    public  boolean deleteProducto(ProductoBean productoBean) throws SQLException
    {
        query = "UPDATE producto SET  where estadoProducto=? where codigoProducto = ?";
        conexion = new ConexionModel();
        PreparedStatement ps = conexion.connect.prepareStatement(query);
        ps.setInt(1, productoBean.getEstadoProducto());
        ps.setString(2, productoBean.getCodigoProducto());
        System.out.println(ps.toString());
        
        if (conexion.executeQuery(ps)) {
            return true;
        }
        return false;
    }
    
    public  JTable cargarTabla() throws SQLException
    {
        utilidades = new utilModel();
        JTable tablaResultado;
        query = "select * from producto";
        PreparedStatement ps = conexion.connect.prepareStatement(query);
        conexion.setRs(ps);
        rs=conexion.getRs();
        String[] columnas = new String[]{"#","Codigo","Nombre","Descripcion,Nivel Uso, Unidad de Medida, "
                                         + "Entrada, Saldo,Estado,Saldo total"};
        tablaResultado=utilidades.cargarTabla(columnas, rs);
        conexion.close();
                
        
        return tablaResultado;
        
    }
    
    public  JTable cargarTablaBusqueda(ProductoBean productoBean) throws SQLException
    {
        utilidades = new utilModel();
        JTable tablaResultado;
        query = "select * from producto where producto.codigoProducto=?";
        PreparedStatement ps = conexion.connect.prepareStatement(query);
        ps.setString(1,productoBean.getCodigoProducto());
        conexion.setRs(ps);
        rs=conexion.getRs();
        String[] columnas = new String[]{"#","Codigo","Nombre","Descripcion,Nivel Uso, Unidad de Medida, "
                                         + "Entrada, Saldo,Estado,Saldo total"};
        tablaResultado=utilidades.cargarTabla(columnas, rs);
        conexion.close();
                
        
        return tablaResultado;
        
    }
}
