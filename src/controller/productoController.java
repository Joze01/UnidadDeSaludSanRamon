/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.ProductoBean;
import entity.UnidadMedidaBean;
import java.sql.SQLException;
import javax.swing.*;
import model.ProductoModel;

/**
 *
 * @author Jose
 */
public class productoController {
    ProductoModel modelo = new ProductoModel();
    boolean resultado=false;
    
    public boolean newProducto(ProductoBean productoData) throws SQLException{
    resultado=false;
        if(modelo.newProducto(productoData)){
        return true;
        }
    return resultado;
    }
    
    public boolean updateProducto(ProductoBean productoData) throws SQLException{
    resultado=false;
        if(modelo.updateProducto(productoData)){
        return true;
        }
    return resultado;
    }
    
    public boolean deleteProducto(ProductoBean productoData) throws SQLException{
    resultado=false;
        if(modelo.deleteProducto(productoData)){
        return true;
        }
    return resultado;
    }
    
    public JTable cargarTabla() throws SQLException{
        JTable tablacompleta = modelo.cargarTabla();
       
        return  tablacompleta;
    }
    
    public JTable busqueda(ProductoBean productoData) throws SQLException{
        JTable tablacompleta = modelo.cargarTablaBusqueda(productoData);
        return  tablacompleta;
    }
    
    public DefaultComboBoxModel<UnidadMedidaBean> cargarComboUnidadMedida() throws SQLException{
        
        DefaultComboBoxModel<UnidadMedidaBean> modeloCombo = new DefaultComboBoxModel<>();
        modeloCombo = (DefaultComboBoxModel<UnidadMedidaBean>) modelo.cargarComboUnidadMedida();
        
        return modeloCombo;
    }
}
