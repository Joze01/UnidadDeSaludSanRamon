
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.DestinatarioModel;
import entity.DestinatarioBean;
import java.sql.SQLException;
import javax.swing.*;

/**
 *
 * @author hilde
 */
public class DestinatarioController {
    DestinatarioModel modelo = new DestinatarioModel();
    boolean resultado=false;
    
    public boolean newDestinatario(DestinatarioBean destinatarioData) throws SQLException{
    resultado=false;
        if(modelo.newDestinatario(destinatarioData)){
        return true;
        }
    return resultado;
    }
    
    public boolean updateDestinatario(DestinatarioBean destinatarioData) throws SQLException{
    resultado=false;
        if(modelo.updateDestinatario(destinatarioData)){
        return true;
        }
    return resultado;
    }
    
    public boolean deleteDestinatario(DestinatarioBean destinatarioData) throws SQLException{
    resultado=false;
        if(modelo.deleteDestinatario(destinatarioData)){
        return true;
        }
    return resultado;
    }
    
    public JTable cargarTabla() throws SQLException{
        JTable tablacompleta = modelo.cargarTabla();
       
        return  tablacompleta;
    }
    
    public JTable busqueda(String valor) throws SQLException{
        JTable tablacompleta = modelo.busqueda(valor);
       
        return  tablacompleta;
    }
}

