/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.LoteBean;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static model.ProductoModel.query;
/**
 *
 * @author Jose
 */
public class LoteModel {
    static boolean resultado=false;
    static String query="";
    static ConexionModel conexion;
    static utilModel utilidades;
    static ResultSet rs;
    
    public LoteBean getLoteById(int Idlote) throws SQLException{
        
        ProveedorModel proveedormodel = new ProveedorModel();
        LoteBean nuevoLote = null;
        query = "SELECT * FROM lote WHERE idLote = ?";
        conexion = new ConexionModel();
        PreparedStatement ps = conexion.connect.prepareStatement(query);
        ps.setInt(1, Idlote);
        conexion.setRs(ps);
        rs = conexion.getRs();
        if(rs.next()){
            nuevoLote = new LoteBean();
            nuevoLote.setIdLote(Idlote);
            nuevoLote.setCodigoLote(rs.getString(2));
            nuevoLote.setFechaEntradaLote(rs.getDate(3));
            nuevoLote.setId_proveedor(proveedormodel.getProveedorById(rs.getInt(4)));
        }
        
        return nuevoLote;
    }
    
    
    
}
