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
public class RecetaBean {

    /**
     * @return the IdReceta
     */
    public int getIdReceta() {
        return IdReceta;
    }

    /**
     * @param IdReceta the IdReceta to set
     */
    public void setIdReceta(int IdReceta) {
        this.IdReceta = IdReceta;
    }

    /**
     * @return the codigoReceta
     */
    public String getCodigoReceta() {
        return codigoReceta;
    }

    /**
     * @param codigoReceta the codigoReceta to set
     */
    public void setCodigoReceta(String codigoReceta) {
        this.codigoReceta = codigoReceta;
    }

    /**
     * @return the fechaEntrega
     */
    public String getFechaEntrega() {
        return fechaEntrega;
    }

    /**
     * @param fechaEntrega the fechaEntrega to set
     */
    public void setFechaEntrega(String fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }
    private int IdReceta;
    private String codigoReceta;
    private String fechaEntrega;
}
