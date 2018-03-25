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
public class SalidaBean {

    /**
     * @return the idSalida
     */
    public int getIdSalida() {
        return idSalida;
    }

    /**
     * @param idSalida the idSalida to set
     */
    public void setIdSalida(int idSalida) {
        this.idSalida = idSalida;
    }

    /**
     * @return the id_Entrada
     */
    public int getId_Entrada() {
        return id_Entrada;
    }

    /**
     * @param id_Entrada the id_Entrada to set
     */
    public void setId_Entrada(int id_Entrada) {
        this.id_Entrada = id_Entrada;
    }

    /**
     * @return the cantidadSalida
     */
    public float getCantidadSalida() {
        return cantidadSalida;
    }

    /**
     * @param cantidadSalida the cantidadSalida to set
     */
    public void setCantidadSalida(float cantidadSalida) {
        this.cantidadSalida = cantidadSalida;
    }

    /**
     * @return the tipoSalida
     */
    public int getTipoSalida() {
        return tipoSalida;
    }

    /**
     * @param tipoSalida the tipoSalida to set
     */
    public void setTipoSalida(int tipoSalida) {
        this.tipoSalida = tipoSalida;
    }

    /**
     * @return the id_receta
     */
    public int getId_receta() {
        return id_receta;
    }

    /**
     * @param id_receta the id_receta to set
     */
    public void setId_receta(int id_receta) {
        this.id_receta = id_receta;
    }

    /**
     * @return the id_vale
     */
    public int getId_vale() {
        return id_vale;
    }

    /**
     * @param id_vale the id_vale to set
     */
    public void setId_vale(int id_vale) {
        this.id_vale = id_vale;
    }
    private int idSalida;
    private int id_Entrada;
    private float cantidadSalida;
    private int tipoSalida;
    private int id_receta;
    private int id_vale;
    
}
