/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jose
 */
public class utilModel {
    DefaultTableModel modelotabla;
    
    public JTable cargarTabla(String[] columnas,ResultSet rs) throws SQLException{
        JTable tabla = null; 
        modelotabla=new DefaultTableModel(null,columnas);
        //tabla.setModel(modelotabla);
        ResultSetMetaData rsmd = rs.getMetaData();
        int cantidadColumnas = rsmd.getColumnCount();
        Object datos[] = new Object[cantidadColumnas];
        while(rs.next()){//recorrer registros
            for(int i=0;i<cantidadColumnas;i++){ //cargar datos
                datos[i]=rs.getString(i+1);
            }
            modelotabla.addRow(datos);
            
        }
        tabla=new JTable(modelotabla);
        tabla.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        return tabla;
    }
    
    
    
    
    
}
