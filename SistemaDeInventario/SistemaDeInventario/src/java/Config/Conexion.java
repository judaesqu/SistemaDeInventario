/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Config;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Espinosa Beltran
 */
public class Conexion {
    
    private static Connection con;
    
    //Declaracion de Datos de conexion a la red
    
    private static final String driver="com.mysql.jdbc.Driver";
    private static final String user = "root";
    private static final String pass ="";
    private static final String url = "jdbc:mysql://localhost:3307/inventario";
    
    //Función que conecta la base de datos 
    
    public Connection conector (){
        
        Connection con = null;
        try{
            Class.forName(driver);
            //Conexion a la base de datos
            con = (Connection)DriverManager.getConnection(url,user,pass);
            
        }
        catch (ClassNotFoundException | SQLException e){ 
        }
        return con;
    }    
}
