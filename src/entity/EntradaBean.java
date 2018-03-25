/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Jose
 */
public class EntradaBean {

    /**
     * @return the idEntrada
     */
    public int getIdEntrada() {
        return idEntrada;
    }

    /**
     * @param idEntrada the idEntrada to set
     */
    public void setIdEntrada(int idEntrada) {
        this.idEntrada = idEntrada;
    }

    /**
     * @return the id_Lote
     */
    public int getId_Lote() {
        return id_Lote;
    }

    /**
     * @param id_Lote the id_Lote to set
     */
    public void setId_Lote(int id_Lote) {
        this.id_Lote = id_Lote;
    }

    /**
     * @return the id_Producto
     */
    public int getId_Producto() {
        return id_Producto;
    }

    /**
     * @param id_Producto the id_Producto to set
     */
    public void setId_Producto(int id_Producto) {
        this.id_Producto = id_Producto;
    }

    /**
     * @return the cantidadEntrada
     */
    public float getCantidadEntrada() {
        return cantidadEntrada;
    }

    /**
     * @param cantidadEntrada the cantidadEntrada to set
     */
    public void setCantidadEntrada(float cantidadEntrada) {
        this.cantidadEntrada = cantidadEntrada;
    }

    /**
     * @return the costoEntrada
     */
    public float getCostoEntrada() {
        return costoEntrada;
    }

    /**
     * @param costoEntrada the costoEntrada to set
     */
    public void setCostoEntrada(float costoEntrada) {
        this.costoEntrada = costoEntrada;
    }

    /**
     * @return the fechaVencimientoEntrada
     */
    public String getFechaVencimientoEntrada() {
        return fechaVencimientoEntrada;
    }

    /**
     * @param fechaVencimientoEntrada the fechaVencimientoEntrada to set
     */
    public void setFechaVencimientoEntrada(String fechaVencimientoEntrada) {
        this.fechaVencimientoEntrada = fechaVencimientoEntrada;
    }
    private int idEntrada;
    private int id_Lote;
    private int id_Producto;
    private float cantidadEntrada;
    private float costoEntrada;
    private String fechaVencimientoEntrada;
        
}
