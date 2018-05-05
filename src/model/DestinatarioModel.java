
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.DestinatarioBean;
import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author hilde
 */
public class DestinatarioModel {
    boolean resultado = false;
    String query = "";
    ConexionModel conexion;
    utilModel utilidades;
    ResultSet rs;

    public boolean newDestinatario(DestinatarioBean destinatarioData) throws SQLException {

        resultado = false;
        query = "INSERT INTO destinatario(nombreDestinatario, descripcionDestinatario, estadoDestinatario) VALUES (?,?,?)";
        conexion = new ConexionModel();
        PreparedStatement ps = conexion.connect.prepareStatement(query);
        ps.setString(1, destinatarioData.getNombreDestinatario());
        ps.setString(2, destinatarioData.getDescripcionDestintario());
        ps.setInt(3, destinatarioData.getEstadoDestinatario());
        System.out.println(ps.toString());
        if (conexion.executeQuery(ps)) {
            resultado = true;
        }

        return resultado;
    }

    public boolean updateDestinatario(DestinatarioBean destinatarioData) throws SQLException {
        resultado = false;
        conexion = new ConexionModel();
        query = "UPDATE destinatario SET nombreDestinatario=?,"
                + "descripcionDestinatario=? "                
                + "WHERE idDestinatario=?";
        PreparedStatement ps = conexion.connect.prepareStatement(query);
        ps.setString(1, destinatarioData.getNombreDestinatario());
        ps.setString(2, destinatarioData.getDescripcionDestintario());        
        ps.setInt(3, destinatarioData.getIdDestinatario());
        System.out.println(ps.toString());
        if (conexion.executeQuery(ps)) {
            resultado = true;
        }
        return resultado;
    }

    public boolean deleteDestinatario(DestinatarioBean destinatarioData) throws SQLException {
        resultado = false;
        conexion = new ConexionModel();
        query = "update destinatario set estadoDestinatario=0 WHERE idDestinatario=?";
        PreparedStatement ps = conexion.connect.prepareStatement(query);
        ps.setInt(1, destinatarioData.getIdDestinatario());
        System.out.println(ps.toString());
        if (conexion.executeQuery(ps)) {
            resultado = true;
        }
        return resultado;
    }

    public JTable cargarTabla() throws SQLException {
        utilidades = new utilModel();
        JTable tablaResultado;
        query = "select * from destinatario where estadoDestinatario=1";
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
        query = "select * from destinatario where (nombreDestinatario like '"+valor+"%' or "
                + "descripcionDestinatario like '"+valor+"%') and estadoDestinatario=1";
        conexion = new ConexionModel();
        PreparedStatement ps = conexion.connect.prepareStatement(query);
        conexion.setRs(ps);
        rs = conexion.getRs();
        String[] columnas = new String[]{"#", "Nombre", "Descripcion"};
        tablaResultado = utilidades.cargarTabla(columnas, rs);
        conexion.close();

        return tablaResultado;
    }
}
