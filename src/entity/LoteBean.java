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

    /**
     * @return the fechaEntradaLote
     */
    public String getFechaEntradaLote() {
        return fechaEntradaLote;
    }

    /**
     * @param fechaEntradaLote the fechaEntradaLote to set
     */
    public void setFechaEntradaLote(String fechaEntradaLote) {
        this.fechaEntradaLote = fechaEntradaLote;
    }

    /**
     * @return the id_proveedor
     */
    public int getId_proveedor() {
        return id_proveedor;
    }

    /**
     * @param id_proveedor the id_proveedor to set
     */
    public void setId_proveedor(int id_proveedor) {
        this.id_proveedor = id_proveedor;
    }
    private int idLote;
    private String codigoLote;
    private String fechaEntradaLote;
    private int id_proveedor;
    
   
}
