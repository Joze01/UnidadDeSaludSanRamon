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
public class ProveedorBean {

    /**
     * @return the idProveedor
     */
    public int getIdProveedor() {
        return idProveedor;
    }

    /**
     * @param idProveedor the idProveedor to set
     */
    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    /**
     * @return the nombreProveedor
     */
    public String getNombreProveedor() {
        return nombreProveedor;
    }

    /**
     * @param nombreProveedor the nombreProveedor to set
     */
    public void setNombreProveedor(String nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }

    /**
     * @return the descripcionProveedor
     */
    public String getDescripcionProveedor() {
        return descripcionProveedor;
    }

    /**
     * @param descripcionProveedor the descripcionProveedor to set
     */
    public void setDescripcionProveedor(String descripcionProveedor) {
        this.descripcionProveedor = descripcionProveedor;
    }

    /**
     * @return the estadoProveedor
     */
    public int getEstadoProveedor() {
        return estadoProveedor;
    }

    /**
     * @param estadoProveedor the estadoProveedor to set
     */
    public void setEstadoProveedor(int estadoProveedor) {
        this.estadoProveedor = estadoProveedor;
    }
    private int idProveedor;
    private String nombreProveedor;
    private String descripcionProveedor;
    private int estadoProveedor;
}
