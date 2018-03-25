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
public class UnidadMedidaBean {

    /**
     * @return the idUnidadMedida
     */
    public int getIdUnidadMedida() {
        return idUnidadMedida;
    }

    /**
     * @param idUnidadMedida the idUnidadMedida to set
     */
    public void setIdUnidadMedida(int idUnidadMedida) {
        this.idUnidadMedida = idUnidadMedida;
    }

    /**
     * @return the nombreUnidadMedida
     */
    public String getNombreUnidadMedida() {
        return nombreUnidadMedida;
    }

    /**
     * @param nombreUnidadMedida the nombreUnidadMedida to set
     */
    public void setNombreUnidadMedida(String nombreUnidadMedida) {
        this.nombreUnidadMedida = nombreUnidadMedida;
    }

    /**
     * @return the descripcionUnidadMedida
     */
    public String getDescripcionUnidadMedida() {
        return descripcionUnidadMedida;
    }

    /**
     * @param descripcionUnidadMedida the descripcionUnidadMedida to set
     */
    public void setDescripcionUnidadMedida(String descripcionUnidadMedida) {
        this.descripcionUnidadMedida = descripcionUnidadMedida;
    }

    /**
     * @return the estadoUnidadMedida
     */
    public int getEstadoUnidadMedida() {
        return estadoUnidadMedida;
    }

    /**
     * @param estadoUnidadMedida the estadoUnidadMedida to set
     */
    public void setEstadoUnidadMedida(int estadoUnidadMedida) {
        this.estadoUnidadMedida = estadoUnidadMedida;
    }
    private int idUnidadMedida;
    private String nombreUnidadMedida;
    private String descripcionUnidadMedida;
    private int estadoUnidadMedida;
}
