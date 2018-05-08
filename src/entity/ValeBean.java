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
public class ValeBean {

    /**
     * @return the idVale
     */
    public int getIdVale() {
        return idVale;
    }

    /**
     * @param idVale the idVale to set
     */
    public void setIdVale(int idVale) {
        this.idVale = idVale;
    }

    /**
     * @return the codigoVale
     */
    public String getCodigoVale() {
        return codigoVale;
    }

    /**
     * @param codigoVale the codigoVale to set
     */
    public void setCodigoVale(String codigoVale) {
        this.codigoVale = codigoVale;
    }



    private int idVale;
    private String codigoVale;
    private Date fechaEntrega;
    private DestinatarioBean id_destinatario;

    /**
     * @return the id_destinatario
     */
    public DestinatarioBean getId_destinatario() {
        return id_destinatario;
    }

    /**
     * @param id_destinatario the id_destinatario to set
     */
    public void setId_destinatario(DestinatarioBean id_destinatario) {
        this.id_destinatario = id_destinatario;
    }

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
    
}
