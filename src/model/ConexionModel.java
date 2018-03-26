/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
    import java.sql.Connection;
    import java.sql.DriverManager;
    import java.sql.PreparedStatement;
    import java.sql.ResultSet;
    import java.sql.SQLException;
    import java.sql.Statement;
    import java.util.Date;
/**
 *
 * @author Jose
 */
public class ConexionModel {
    
    //Miembros
    private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    private boolean resultado=false;
    
   public void open() throws SQLException{
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
        this.open();
          ResultSet executeQuery = statementParam.executeQuery();
        this.close();
    }
    
    //get query results
    public ResultSet getRs() throws SQLException{
        return this.resultSet;
    }
    
    
    public boolean executeQuery(PreparedStatement statementParam) throws SQLException{
        resultado=false;
        this.open();
        if(statementParam.executeUpdate()>0){  
        resultado=true;
        }
        this.close();
        return resultado;
    }
    
    
   // Cerrar conexion
    private void close() {
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
