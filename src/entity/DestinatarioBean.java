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
public class DestinatarioBean {

    /**
     * @return the idDestinatario
     */
    public int getIdDestinatario() {
        return idDestinatario;
    }

    /**
     * @param idDestinatario the idDestinatario to set
     */
    public void setIdDestinatario(int idDestinatario) {
        this.idDestinatario = idDestinatario;
    }

    /**
     * @return the nombreDestinatario
     */
    public String getNombreDestinatario() {
        return nombreDestinatario;
    }

    /**
     * @param nombreDestinatario the nombreDestinatario to set
     */
    public void setNombreDestinatario(String nombreDestinatario) {
        this.nombreDestinatario = nombreDestinatario;
    }

    /**
     * @return the descripcionDestintario
     */
    public String getDescripcionDestintario() {
        return descripcionDestintario;
    }

    /**
     * @param descripcionDestintario the descripcionDestintario to set
     */
    public void setDescripcionDestintario(String descripcionDestintario) {
        this.descripcionDestintario = descripcionDestintario;
    }

    /**
     * @return the estadoDestinatario
     */
    public int getEstadoDestinatario() {
        return estadoDestinatario;
    }

    /**
     * @param estadoDestinatario the estadoDestinatario to set
     */
    public void setEstadoDestinatario(int estadoDestinatario) {
        this.estadoDestinatario = estadoDestinatario;
    }
    private int idDestinatario;
    private String nombreDestinatario;
    private String descripcionDestintario;
    private int estadoDestinatario;
}
