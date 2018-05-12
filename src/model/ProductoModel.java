/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import entity.EntradaBean;
import entity.ProductoBean;
import entity.UnidadMedidaBean;
import model.ConexionModel;
import model.ProveedorModel;
import model.utilModel;
import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import entity.UnidadMedidaBean;
import java.util.ArrayList;
import java.util.List;

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
        ps.setInt(5, productoData.getId_unidadMedida().getIdUnidadMedida());
       
        
        if (conexion.executeQuery(ps)) {
            return true;
        }
        return false;
    }

    public  boolean updateProducto(ProductoBean productoBean) throws SQLException
    {
        query ="update producto set " +
               "nombreProducto = ?," +
               "nivelUsoProducto = ?," +
               "descripcionProducto = ?," +
               "id_UnidadMedida = ? " +
               "where codigoProducto = ?";
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
        query = "UPDATE producto SET estadoProducto=? where codigoProducto = ?";
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
    
    public List<ProductoBean> consultarTodo() throws SQLException
    {
       List<ProductoBean> resp = new ArrayList<ProductoBean>();
       conexion = new ConexionModel();
       query = "select * from producto order by codigoProducto asc";
       PreparedStatement ps = conexion.connect.prepareStatement(query);
       conexion.setRs(ps);
       rs=conexion.getRs();
       while(rs.next())
       {
           ProductoBean objeProducto = new ProductoBean();
           objeProducto.setIdProducto(rs.getInt("idProducto"));
           objeProducto.setCodigoProducto(rs.getString("codigoProducto"));
           objeProducto.setNombreProducto(rs.getString("nombreProducto"));
           objeProducto.setDescripcionProducto(rs.getString("descripcionProducto"));
           objeProducto.setNivelUsoProducto(rs.getString("nivelUsoProducto"));
           objeProducto.setId_unidadMedida(new UnidadMedidaModel().getUnidadMedidaById(rs.getInt("id_UnidadMedida")));
           resp.add(objeProducto);
       }
       if(resp.size()==0) resp= null;
       return resp;
    }

    public  JTable cargarTabla() throws SQLException
    {
        conexion = new ConexionModel();
        utilidades = new utilModel();
        JTable tablaResultado;
        query = "select p.idProducto, p.codigoProducto, p.nombreProducto, p.descripcionProducto, p.nivelUsoProducto, um.nombreUnidadMedida from producto as p inner join unidadMedida as um on um.idUnidadMedida=p.id_UnidadMedida";
        PreparedStatement ps = conexion.connect.prepareStatement(query);
        conexion.setRs(ps);
        rs=conexion.getRs();
        String[] columnas = new String[]{"#","Codigo","Nombre","Descripcion","Nivel Uso", "Unidad de Medida"};
        tablaResultado=utilidades.cargarTabla(columnas, rs);
        conexion.close();
        return tablaResultado;

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

    public  JTable cargarTablaBusqueda(ProductoBean productoBean) throws SQLException
    {
        conexion = new ConexionModel();
        utilidades = new utilModel();
        JTable tablaResultado;
        query = "select * from producto where producto.codigoProducto=?";
        PreparedStatement ps = conexion.connect.prepareStatement(query);
        ps.setString(1,productoBean.getCodigoProducto());
        
        conexion.setRs(ps);
        rs=conexion.getRs();
        String[] columnas = new String[]{"#","Codigo","Nombre","Descripcion","Nivel Uso"," Unidad de Medida, "
                                         + "Entrada"};
        
 
        tablaResultado=utilidades.cargarTabla(columnas, rs);
        conexion.close();


        return tablaResultado;

    }

    public ProductoBean getProductoBeanById(int idProducto) throws SQLException
    {
        ProductoBean objProducto = null;
        EntradaBean entrada = new EntradaBean();
        query = "SELECT * FROM producto WHERE idProducto = ?";
        conexion = new ConexionModel();
        PreparedStatement ps = conexion.connect.prepareStatement(query);
        ps.setInt(1, idProducto);
        conexion.setRs(ps);
        rs = conexion.getRs();
        while(rs.next()){
        objProducto = new ProductoBean();
        objProducto.setIdProducto(rs.getInt("idProducto"));
        objProducto.setCodigoProducto(rs.getString("codigoProducto"));
        objProducto.setNombreProducto(rs.getString("nombreProducto"));
        objProducto.setDescripcionProducto(rs.getString("descripcionProducto"));
        objProducto.setNivelUsoProducto(rs.getString("nivelUsoProducto"));
        objProducto.setId_unidadMedida(new UnidadMedidaModel().getUnidadMedidaById(rs.getInt("id_UnidadMedida")));
        objProducto.setEstadoProducto(rs.getInt("estadoProducto"));
        entrada.setIdEntrada(rs.getInt("Id_EntradaProducto"));
        objProducto.setId_EntradaProducto(entrada);
        objProducto.setSaldoEntradaProducto(rs.getFloat("saldoEntradaProducto"));
        }
        return objProducto;
    }
    
    public boolean updateBandera(EntradaBean entrada) throws SQLException{
        query = "UPDATE producto SET Id_EntradaProducto=?, saldoEntradaProducto=? where idProducto=?";
        conexion = new ConexionModel();
        PreparedStatement ps = conexion.connect.prepareStatement(query);
        ps.setInt(1, entrada.getIdEntrada());
        ps.setFloat(2, entrada.getCantidadEntrada());
        ps.setInt(3, entrada.getId_Producto().getIdProducto());
        System.out.println(ps.toString());
        return conexion.executeQuery(ps);
    }
        /*
           public ProductoBean getBandera(ProductoBean producto) throws SQLException{
            query = "SELECT idProducto, Id_EntradaProducto, saldoEntradaProducto, saldoTotalProducto FROM producto WHERE 1";
            conexion = new ConexionModel();
            return conexion.executeQuery(ps);
        }
        */

}
