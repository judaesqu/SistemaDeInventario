/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Espinosa Beltran
 */
public class VentaDAO {
    Connection con;
    Conexion cn=new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    
    public String GenerarSerie() throws SQLException{
	String numeroserie="";
	String sql = "SELECT max(NumeroSerie) FROM ventas";
	try{
	    con=cn.Conexion();
	    ps=con.prepareStatement(sql);
	    rs=ps.executeQuery();
	    while(rs.next()){
		numeroserie=rs.getString(1);
	    }
	}catch (Exception e){
	}
	
	return numeroserie;
    }
}
