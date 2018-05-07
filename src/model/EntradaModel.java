/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.EntradaBean;
import entity.ProductoBean;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import static model.ProductoModel.query;

/**
 *
 * @author alvin
 */
public class EntradaModel {
    
    static boolean resultado=false;
    static String query="";
    static ConexionModel conexion;
    static utilModel utilidades;
    static ResultSet rs;
    
    public EntradaBean getEntradaById(int idEntrada) throws SQLException
    {
        EntradaBean objEntrada = new EntradaBean();
        LoteModel modeloLote = new LoteModel();
        ProductoModel modeloProducto = new ProductoModel();
        query = "SELECT * FROM entrada WHERE idEntrada = ?";
        conexion = new ConexionModel();
        PreparedStatement ps = conexion.connect.prepareStatement(query);
        ps.setInt(1, idEntrada);
        conexion.setRs(ps);
        rs = conexion.getRs();
        while(rs.next()){
        objEntrada.setIdEntrada(rs.getInt("idEntrada")); 
        objEntrada.setId_Lote(modeloLote.getLoteById(rs.getInt("id_Lote")));
        objEntrada.setId_Producto(modeloProducto.getProductoBeanById(rs.getInt("id_Producto")));
        objEntrada.setCantidadEntrada(rs.getFloat("cantidadEntrada"));
        objEntrada.setCostoEntrada(rs.getFloat("costoEntrada"));
        objEntrada.setFechaVencimientoEntrada(rs.getDate("fechaVencimientoEntrada"));
        }
        
      
        
        
        
        return objEntrada;
    }
    
    public boolean newEntrada(EntradaBean entradaData) throws SQLException{
         boolean primero=false;
         if(lastEntradaByProducto(entradaData.getId_Producto())==null){
         primero=true;
         }     
        query = "INSERT INTO entrada(id_Lote, id_Producto, cantidadEntrada, costoEntrada,fechaVencimientoEntrada ) VALUES (?,?,?,?,?)";
        conexion = new ConexionModel();
        PreparedStatement ps = conexion.connect.prepareStatement(query);
        ps.setInt(1, entradaData.getId_Lote().getIdLote());
        ps.setInt(2, entradaData.getId_Producto().getIdProducto());
        ps.setFloat(3, entradaData.getCantidadEntrada());
        ps.setFloat(4, entradaData.getCostoEntrada());
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentTime = sdf.format(entradaData.getFechaVencimientoEntrada());
        System.out.println(currentTime);
        ps.setString(5, currentTime);
       
        if(conexion.executeQuery(ps)){
            if(primero){
                EntradaBean entradaconId = lastEntradaByProducto(entradaData.getId_Producto());
                ProductoModel producto = new ProductoModel();
                producto.updateBandera(entradaconId);
            }  
        }         
        return false;
    }
    
    
    
    public ArrayList<EntradaBean> listEntradaByProducto(ProductoBean producto) throws SQLException{
        ArrayList<EntradaBean> listaEntradas=new ArrayList<EntradaBean>();
        query = "";
        conexion = new ConexionModel();
        PreparedStatement ps = conexion.connect.prepareStatement(query);
        //ps.setInt(1, idEntrada);
        conexion.setRs(ps);
        rs = conexion.getRs();
        
        
    return listaEntradas;
    }
       
    public EntradaBean lastEntradaByProducto(ProductoBean producto) throws SQLException{
        EntradaBean entradaRespuesta=null;
        LoteModel modelolote = new LoteModel();
        
        
        query = "select * from entrada where entrada.id_Producto=? order by entrada.idEntrada desc limit 1";
        conexion = new ConexionModel();
        PreparedStatement ps = conexion.connect.prepareStatement(query);
        ps.setInt(1, producto.getIdProducto());
        conexion.setRs(ps);
        rs = conexion.getRs();
        
        while(rs.next()){
            entradaRespuesta=new EntradaBean();
            entradaRespuesta.setIdEntrada(rs.getInt(1));
            entradaRespuesta.setId_Lote(modelolote.getLoteById(rs.getInt(2)));
            entradaRespuesta.setId_Producto(producto);
            entradaRespuesta.setCantidadEntrada(rs.getFloat(4));
            entradaRespuesta.setCostoEntrada(rs.getFloat(5));
        }
        
    return entradaRespuesta;
    }
    
    public EntradaBean getNextEntrada(EntradaBean currentEntrada) throws SQLException
    {
        EntradaBean objeEntrada = null;
        
        query = "select * from entrada where entrada.idEntrada>? and entrada.id_Producto = ? order by entrada.idEntrada asc limit 1";
        conexion = new ConexionModel();
        PreparedStatement ps = conexion.connect.prepareStatement(query);
        ps.setInt(1, currentEntrada.getIdEntrada());
        ps.setInt(2, currentEntrada.getId_Producto().getIdProducto());
        conexion.setRs(ps);
        rs = conexion.getRs();
        
        while(rs.next()){
            objeEntrada=new EntradaBean();
            objeEntrada.setIdEntrada(rs.getInt(1));
            objeEntrada.setId_Lote(new LoteModel().getLoteById(rs.getInt(2)));
            objeEntrada.setId_Producto(new ProductoModel().getProductoBeanById(rs.getInt("id_Producto")));
            objeEntrada.setCantidadEntrada(rs.getFloat(4));
            objeEntrada.setCostoEntrada(rs.getFloat(5));
        }
        
        return objeEntrada;
    }
    
}
