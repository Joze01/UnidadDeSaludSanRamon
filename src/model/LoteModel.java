/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.LoteBean;
import entity.UnidadMedidaBean;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;

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
    
        public LoteBean getLastLote() throws SQLException{
        
        ProveedorModel proveedormodel = new ProveedorModel();
        LoteBean nuevoLote = null;
        query = "select * from Lote ORDER by lote.idLote desc LIMIT 1";
        conexion = new ConexionModel();
        PreparedStatement ps = conexion.connect.prepareStatement(query);
        conexion.setRs(ps);
        rs = conexion.getRs();
        if(rs.next()){
            nuevoLote = new LoteBean();
            nuevoLote.setIdLote(rs.getInt(1));
            nuevoLote.setCodigoLote(rs.getString(2));
            nuevoLote.setFechaEntradaLote(rs.getDate(3));
            nuevoLote.setId_proveedor(proveedormodel.getProveedorById(rs.getInt(4)));
        }
        
        return nuevoLote;
    }
    
    
     public ComboBoxModel<UnidadMedidaBean> cargarComboUnidadMedida() throws SQLException{
        conexion = new ConexionModel();
        DefaultComboBoxModel<UnidadMedidaBean> modelo = new DefaultComboBoxModel<UnidadMedidaBean>();
        query = "select idUnidadMedida, nombreUnidadMedida from unidadmedida";
        PreparedStatement ps = conexion.connect.prepareStatement(query);
        conexion.setRs(ps);
        rs=conexion.getRs();
        ArrayList<UnidadMedidaBean>listadeMedidas = new ArrayList<UnidadMedidaBean>();
        while(rs.next()){

            UnidadMedidaBean leido = new UnidadMedidaBean();
            leido.setIdUnidadMedida(rs.getInt(1));
            leido.setNombreUnidadMedida(rs.getString(2));
            listadeMedidas.add(leido);
        }
        for(UnidadMedidaBean obj:listadeMedidas){
            modelo.addElement(obj);
            System.out.println(obj.toString());
        }


        return modelo;
    }
     
    public JTable GetTablaDetalleLote(LoteBean loteEntrada) throws SQLException{
        utilidades = new utilModel();
        JTable tablaResultado;
        query = "select p.nombreProducto,en.cantidadEntrada from entrada as en inner join producto as p on p.idProducto = en.id_Producto where id_Lote=?";
        conexion = new ConexionModel();
        PreparedStatement ps = conexion.connect.prepareStatement(query);
        ps.setInt(1, loteEntrada.getIdLote());
        conexion.setRs(ps);
        rs = conexion.getRs();
        String[] columnas = new String[]{"Nombre", "Cantidad Entrada"};
        tablaResultado = utilidades.cargarTabla(columnas, rs);
        conexion.close();

        return tablaResultado;
    }
    
    public boolean  newLote(LoteBean loteData) throws SQLException{
        utilidades = new utilModel();
        
        query = "INSERT INTO lote(codigoLote, id_proveedor) VALUES (?,?)";
        conexion = new ConexionModel();
        PreparedStatement ps = conexion.connect.prepareStatement(query);
        ps.setString(1, loteData.getCodigoLote());
        ps.setInt(2, loteData.getId_proveedor().getIdProveedor());
      
       return conexion.executeQuery(ps);
    
    }
    
}
