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
public class LoteBean {

    /**
     * @return the idLote
     */
    public int getIdLote() {
        return idLote;
    }

    /**
     * @param idLote the idLote to set
     */
    public void setIdLote(int idLote) {
        this.idLote = idLote;
    }

    /**
     * @return the codigoLote
     */
    public String getCodigoLote() {
        return codigoLote;
    }

    /**
     * @param codigoLote the codigoLote to set
     */
    public void setCodigoLote(String codigoLote) {
        this.codigoLote = codigoLote;
    }


   
    private int idLote;
    private String codigoLote;
    private Date fechaEntradaLote;
    private ProveedorBean id_proveedor;

    /**
     * @return the fechaEntradaLote
     */
    public Date getFechaEntradaLote() {
        return fechaEntradaLote;
    }

    /**
     * @param fechaEntradaLote the fechaEntradaLote to set
     */
    public void setFechaEntradaLote(Date fechaEntradaLote) {
        this.fechaEntradaLote = fechaEntradaLote;
    }

    /**
     * @return the id_proveedor
     */
    public ProveedorBean getId_proveedor() {
        return id_proveedor;
    }

    /**
     * @param id_proveedor the id_proveedor to set
     */
    public void setId_proveedor(ProveedorBean id_proveedor) {
        this.id_proveedor = id_proveedor;
    }
    
   
}
