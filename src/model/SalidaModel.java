/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import entity.EntradaBean;
import entity.ProductoBean;
import entity.SalidaBean;
import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import static model.ProductoModel.query;

/**
 *
 * @author alvin
 */
public class SalidaModel {
    boolean resultado = false;
    String query = "";
    ConexionModel conexion;
    utilModel utilidades;
    ResultSet rs;

    public boolean insertSalida(SalidaBean salidaData) throws SQLException
    {
        boolean resultado=false;
        query = "INSERT INTO salida(id_entrada, cantidadSalida, tipoSalida, id_receta, id_vale, fechaSalida) VALUES(?,?,?,?,?,?)";
        conexion = new ConexionModel();
        PreparedStatement ps = conexion.connect.prepareStatement(query);
        ps.setInt(1,salidaData.getId_Entrada().getIdEntrada());
        ps.setFloat(2, salidaData.getCantidadSalida());
        ps.setInt(3, salidaData.getTipoSalida());
        if(salidaData.getId_receta()==null)
        {
            ps.setNull(4, java.sql.Types.INTEGER);
        }
        else
        {
            ps.setInt(4, salidaData.getId_receta().getIdReceta());
        }
        if(salidaData.getId_vale()==null)
        {
            ps.setNull(5, java.sql.Types.INTEGER);
        }
        else
        {
            ps.setInt(5, salidaData.getId_vale().getIdVale());
        }java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentDate = sdf.format(new java.util.Date());
        ps.setString(6, currentDate);
        return conexion.executeQuery(ps);
    }
    
    public boolean newSalida(SalidaBean salidaData) throws SQLException {   
        resultado = false;
        
        if(isSuficente(salidaData)){
        
            ProductoBean objeProducto = new ProductoModel().getProductoBeanById(salidaData.getId_producto().getIdProducto());
            if(objeProducto.getSaldoEntradaProducto()>=salidaData.getCantidadSalida())
            {
                salidaData.setId_Entrada(new EntradaModel().getEntradaById(objeProducto.getId_EntradaProducto().getIdEntrada()));
                insertSalida(salidaData);
                objeProducto.setSaldoEntradaProducto(objeProducto.getSaldoEntradaProducto()-salidaData.getCantidadSalida());
                EntradaBean objeEntrada = new EntradaModel().getEntradaById(objeProducto.getId_EntradaProducto().getIdEntrada());
                objeEntrada.setCantidadEntrada(objeProducto.getSaldoEntradaProducto());
                new ProductoModel().updateBandera(objeEntrada);
            }
            else
            {
                float cantidadRestante = salidaData.getCantidadSalida();
                while(cantidadRestante>0)
                {
                    System.out.println("Cantidad Restante " +cantidadRestante);
                    System.out.println("Saldo Producto " +objeProducto.getSaldoEntradaProducto() + " ENTRADA " + objeProducto.getId_EntradaProducto().getIdEntrada());
                    if(cantidadRestante>objeProducto.getSaldoEntradaProducto())
                    {
                        cantidadRestante-=objeProducto.getSaldoEntradaProducto();
                        EntradaBean objeEntrada = new EntradaModel().getEntradaById(objeProducto.getId_EntradaProducto().getIdEntrada());
                        objeEntrada.setCantidadEntrada(objeProducto.getSaldoEntradaProducto());
                        salidaData.setId_Entrada(new EntradaModel().getEntradaById(objeProducto.getId_EntradaProducto().getIdEntrada()));
                        salidaData.setCantidadSalida(objeProducto.getSaldoEntradaProducto());
                        insertSalida(salidaData);
                        objeEntrada = new EntradaModel().getNextEntrada(objeEntrada);
                        System.out.println("NEXT ID ENTRADA " + objeEntrada.getIdEntrada());
                        objeProducto.setId_EntradaProducto(objeEntrada);
                        objeProducto.setSaldoEntradaProducto(objeEntrada.getCantidadEntrada());
                        new ProductoModel().updateBandera(objeEntrada);
                    }
                    else
                    {
                        salidaData.setCantidadSalida(cantidadRestante);
                        salidaData.setId_Entrada(new EntradaModel().getEntradaById(objeProducto.getId_EntradaProducto().getIdEntrada()));
                        insertSalida(salidaData);
                        objeProducto.setSaldoEntradaProducto(objeProducto.getSaldoEntradaProducto()-cantidadRestante);
                        System.out.println("pupu" + objeProducto.getSaldoEntradaProducto());
                        EntradaBean objeEntrada = new EntradaModel().getEntradaById(objeProducto.getId_EntradaProducto().getIdEntrada());
                        objeEntrada.setCantidadEntrada(objeProducto.getSaldoEntradaProducto());
                        objeEntrada.setIdEntrada(objeProducto.getId_EntradaProducto().getIdEntrada());
                        System.out.println("SALDO ENTRADA BANDERA " +objeEntrada.getCantidadEntrada() );
                        new ProductoModel().updateBandera(objeEntrada);
                        cantidadRestante=0;
                    }

                }
            }


            /*query = "INSERT INTO salida(id_entrada,cantidadSalida,tipoSalida, id_receta,id_vale) VALUES(?,?,?,?,?)";
            conexion = new ConexionModel();
            PreparedStatement ps = conexion.connect.prepareStatement(query);
            ps.setInt(1, salidaData.getId_Entrada().getIdEntrada());
            ps.setFloat(2, salidaData.getCantidadSalida());
            ps.setInt(3, salidaData.getTipoSalida());
            ps.setInt(4, salidaData.getId_receta().getIdReceta());
            ps.setInt(5, salidaData.getId_vale().getIdVale());
            return conexion.executeQuery(ps);*/
        return true;
        }
        System.out.println("No son suficentes");
        return false;
    }
    
    
    public boolean isSuficente(SalidaBean salidaData) throws SQLException{
      
        float cantidadActual=0;
        float restoEntradas=0;
        float totales=0;
        int idEntradaActual=0;
        
        query = "SELECT Id_EntradaProducto, saldoEntradaProducto FROM producto WHERE idProducto=?";
        conexion = new ConexionModel();
        PreparedStatement ps = conexion.connect.prepareStatement(query);
        ps.setInt(1, salidaData.getId_producto().getIdProducto());
        conexion.setRs(ps);
        rs = conexion.getRs();
        while(rs.next()){
            cantidadActual=rs.getFloat("saldoEntradaProducto");
            idEntradaActual=rs.getInt("Id_EntradaProducto");
        }
        
        
        conexion = new ConexionModel();
        query = "SELECT sum(cantidadEntrada) FROM entrada WHERE id_Producto>?";
        conexion = new ConexionModel();
        ps = conexion.connect.prepareStatement(query);
        ps.setInt(1, idEntradaActual);
        conexion.setRs(ps);
        rs = conexion.getRs();
        while(rs.next()){
          restoEntradas=rs.getFloat(1);
        }
        totales=cantidadActual+restoEntradas;
        
        if(totales>=salidaData.getCantidadSalida()){
            System.out.println("SUFIENTES");
        return true;
        }
        System.out.println("NO ALCANZAN");
        return false;
    }
    
}
