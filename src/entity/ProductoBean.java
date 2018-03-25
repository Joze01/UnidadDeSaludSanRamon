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
public class ProductoBean {

    /**
     * @return the idProducto
     */
    public int getIdProducto() {
        return idProducto;
    }

    /**
     * @param idProducto the idProducto to set
     */
    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    /**
     * @return the codigoProducto
     */
    public String getCodigoProducto() {
        return codigoProducto;
    }

    /**
     * @param codigoProducto the codigoProducto to set
     */
    public void setCodigoProducto(String codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    /**
     * @return the nombreProducto
     */
    public String getNombreProducto() {
        return nombreProducto;
    }

    /**
     * @param nombreProducto the nombreProducto to set
     */
    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    /**
     * @return the descripcionProducto
     */
    public String getDescripcionProducto() {
        return descripcionProducto;
    }

    /**
     * @param descripcionProducto the descripcionProducto to set
     */
    public void setDescripcionProducto(String descripcionProducto) {
        this.descripcionProducto = descripcionProducto;
    }

    /**
     * @return the nivelUsoProducto
     */
    public String getNivelUsoProducto() {
        return nivelUsoProducto;
    }

    /**
     * @param nivelUsoProducto the nivelUsoProducto to set
     */
    public void setNivelUsoProducto(String nivelUsoProducto) {
        this.nivelUsoProducto = nivelUsoProducto;
    }

    /**
     * @return the id_unidadMedida
     */
    public int getId_unidadMedida() {
        return id_unidadMedida;
    }

    /**
     * @param id_unidadMedida the id_unidadMedida to set
     */
    public void setId_unidadMedida(int id_unidadMedida) {
        this.id_unidadMedida = id_unidadMedida;
    }

    /**
     * @return the id_EntradaProducto
     */
    public int getId_EntradaProducto() {
        return id_EntradaProducto;
    }

    /**
     * @param id_EntradaProducto the id_EntradaProducto to set
     */
    public void setId_EntradaProducto(int id_EntradaProducto) {
        this.id_EntradaProducto = id_EntradaProducto;
    }

    /**
     * @return the saldoEntradaProducto
     */
    public float getSaldoEntradaProducto() {
        return saldoEntradaProducto;
    }

    /**
     * @param saldoEntradaProducto the saldoEntradaProducto to set
     */
    public void setSaldoEntradaProducto(float saldoEntradaProducto) {
        this.saldoEntradaProducto = saldoEntradaProducto;
    }

    /**
     * @return the estadoProducto
     */
    public int getEstadoProducto() {
        return estadoProducto;
    }

    /**
     * @param estadoProducto the estadoProducto to set
     */
    public void setEstadoProducto(int estadoProducto) {
        this.estadoProducto = estadoProducto;
    }

    /**
     * @return the saldoTotalProducto
     */
    public float getSaldoTotalProducto() {
        return saldoTotalProducto;
    }

    /**
     * @param saldoTotalProducto the saldoTotalProducto to set
     */
    public void setSaldoTotalProducto(float saldoTotalProducto) {
        this.saldoTotalProducto = saldoTotalProducto;
    }
    private int idProducto;
    private String codigoProducto;
    private String nombreProducto;
    private String descripcionProducto;
    private String nivelUsoProducto;
    private int id_unidadMedida;
    private int id_EntradaProducto;
    private float saldoEntradaProducto; //Bandera;
    private int estadoProducto;
    private float saldoTotalProducto;
    
    
}
