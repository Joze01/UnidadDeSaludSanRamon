/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import model.ProveedorModel;
import entity.ProveedorBean;
import java.sql.SQLException;
import javax.swing.*;
/**
 *
 * @author Jose
 */
public class ProveedorController {
    ProveedorModel modelo = new ProveedorModel();
    boolean resultado=false;
    
    public boolean newProveedor(ProveedorBean proveedorData) throws SQLException{
    resultado=false;
        if(modelo.newProveedor(proveedorData)){
        return true;
        }
    return resultado;
    }
    
    
    public JTable cargarTabla() throws SQLException{
        JTable tablacompleta = modelo.cargarTabla();
       
        return  tablacompleta;
    }
    
}
