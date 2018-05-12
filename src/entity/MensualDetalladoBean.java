/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alvin
 */
public class MensualDetalladoBean {

    public ProductoBean getId_producto() {
        return id_producto;
    }

    public void setId_producto(ProductoBean id_producto) {
        this.id_producto = id_producto;
    }

    public List<Float> getCantidades() {
        return cantidades;
    }

    public void setCantidades(List<Float> cantidades) {
        this.cantidades = cantidades;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }
    ProductoBean id_producto;
    List<Float> cantidades = new ArrayList<Float>();
    float total;
}
