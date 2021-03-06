/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
   import java.sql.*;
/**
 *
 * @author Jose
 */
public class ConexionModel {
    
    //Miembros
    public Connection connect = null;
    private Statement statement = null;
    public PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    private boolean resultado=false;
    
    
   public ConexionModel() throws SQLException{
        try
        {
                //obtenemos el driver de para mysql
                Class.forName("com.mysql.jdbc.Driver");
                // Se obtiene una conexión con la base de datos. 
                connect = DriverManager.getConnection (
                "jdbc:mysql://localhost:3306/sanramon","root", "");

                // Permite ejecutar sentencias SQL sin parámetros
                statement = connect.createStatement();
        }
        catch (ClassNotFoundException e1) {
                //Error si no puedo leer el driver de MySQL
            System.out.println("ERROR:No encuentro el driver de la BD: " +e1.getMessage());
        }
    }
    
    
    //Set query resulset
    public void setRs(PreparedStatement statementParam) throws SQLException{
          resultSet = statementParam.executeQuery();
    }
    
    //get query results
    public ResultSet getRs() throws SQLException{
        return this.resultSet;
    }
    
    
    public boolean executeQuery(PreparedStatement statementParam) throws SQLException{
        resultado=false;
      
        if(statementParam.executeUpdate() > 0){  
        resultado=true;
        }
        this.close();
        return resultado;
    }
    
    
   // Cerrar conexion
    public void close() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }

            if (statement != null) {
                statement.close();
            }

            if (connect != null) {
                connect.close();
            }
        } catch (Exception e) {

        }
    }
}
    
    
    
    
    
  
