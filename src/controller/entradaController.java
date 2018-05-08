/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.EntradaBean;
import java.sql.SQLException;
import model.EntradaModel;

/**
 *
 * @author Jose
 */
public class entradaController {
    EntradaModel modelo = new EntradaModel();
    
    public boolean newEntrada(EntradaBean entradaData) throws SQLException{
            return modelo.newEntrada(entradaData);
    }
    
}
