/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package report;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import model.ConexionModel;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;
 
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Jose
 */
public class generarReporte {
    
    
    
    public void generarSalidasByProducto(String idProducto,String fechaInicial,String FechaFinal) throws JRException, SQLException{
        ConexionModel conec = new ConexionModel();
        File reportFile = new File("/Users/Jose/Desktop/San ramon/UnidadDeSaludSanRamon/src/report/salidaProducto.jasper");
         Map parameters = new HashMap();
         parameters.put("productID", idProducto);
         parameters.put("initialDate", fechaInicial);
         parameters.put("finalDate", FechaFinal);
          try {
            JasperPrint print = JasperFillManager.fillReport(reportFile.getPath(), parameters, conec.connect );
            JasperViewer.viewReport(print);
        } catch (JRException ex) {
              System.out.println(ex.toString());
        }

       
    }
    public void generarEntradaByProducto(String idProducto,String fechaInicial,String FechaFinal) throws JRException, SQLException{
        ConexionModel conec = new ConexionModel();
        File reportFile = new File("/Users/Jose/Desktop/San ramon/UnidadDeSaludSanRamon/src/report/entradaProducto.jasper");
         Map parameters = new HashMap();
         parameters.put("productID", idProducto);
         parameters.put("initialDate", fechaInicial);
         parameters.put("finalDate", FechaFinal);
          try {
            JasperPrint print = JasperFillManager.fillReport(reportFile.getPath(), parameters, conec.connect );
            JasperViewer.viewReport(print);
        } catch (JRException ex) {
              System.out.println(ex.toString());
        }

       
    }
    
    
}
