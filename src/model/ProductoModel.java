/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
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
        conexion = new ConexionModel();
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

    public ProductoBean getById(int idProducto) throws SQLException
    {
        ProductoBean objProducto = new ProductoBean();
        query = "SELECT * FROM producto WHERE idProducto = ?";
        conexion = new ConexionModel();
        PreparedStatement ps = conexion.connect.prepareStatement(query);
        ps.setInt(1, idProducto);
        conexion.setRs(ps);
        rs = conexion.getRs();
        objProducto.setIdProducto(rs.getInt("idProducto"));
        objProducto.setCodigoProducto(rs.getString("codigoProducto"));
        objProducto.setNombreProducto(rs.getString("nombreProducto"));
        objProducto.setDescripcionProducto(rs.getString("descripcionProducto"));
        objProducto.setNivelUsoProducto(rs.getString("nivelUsoProducto"));
        objProducto.setId_unidadMedida(new UnidadMedidaModel().getById(rs.getInt("id_UnidadMedida")));

        return objProducto;
    }

    public static boolean newProducto(ProductoBean productoData) throws SQLException
}
