/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Date;

/**
 *
 * @author Jose
 */
public class RecetaBean {

    /**
     * @return the fechaEntrega
     */
    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    /**
     * @param fechaEntrega the fechaEntrega to set
     */
    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

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


    private int IdReceta;
    private String codigoReceta;
    private Date fechaEntrega;
}
