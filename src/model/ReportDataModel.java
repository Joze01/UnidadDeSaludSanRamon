/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.MensualDetalladoBean;
import entity.ProductoBean;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

/**
 *
 * @author alvin
 */
public class ReportDataModel {
    
    boolean resultado = false;
    String query = "";
    ConexionModel conexion;
    utilModel utilidades;
    ResultSet rs;

    public List<MensualDetalladoBean> reporteMensualDetallado(int month, int year) throws SQLException
    {
        List<MensualDetalladoBean> resp= null;
        boolean resultado=false;
        
        List<ProductoBean> listProductos = new ProductoModel().consultarTodo();
        for(ProductoBean objeProducto: listProductos)
        {
            
        }
        
        query = "INSERT INTO salida(id_entrada, cantidadSalida, tipoSalida, id_receta, id_vale, fechaSalida) VALUES(?,?,?,?,?,?)";
        conexion = new ConexionModel();
        PreparedStatement ps = conexion.connect.prepareStatement(query);
        
        
        return resp;
    }
}