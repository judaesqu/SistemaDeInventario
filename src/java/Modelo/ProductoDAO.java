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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Espinosa Beltran
 */
public class ProductoDAO {
    Conexion cn=new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;
    
    public List listar(){
	String sql = "SELECT * FROM producto";
	List<Producto>lista=new ArrayList<>();
	try{
	    con=cn.Conexion();
	    ps=con.prepareStatement(sql);
	    rs=ps.executeQuery();
	    while(rs.next()){
		Producto pr = new Producto();
		pr.setId(rs.getInt(1));
		pr.setNombres(rs.getString(2));
		pr.setPrecio(rs.getString(3));
		pr.setStock(rs.getString(4));
		pr.setEstado(rs.getString(5));
		lista.add(pr);
	    }
	}catch(Exception e){
	}
	return lista;
    }
    public int agregar(Producto pr){
	String sql="INSERT INTO producto(Nombres, Precio, Stock, Estado) VALUES (?,?,?,?)";
	try{
	    con=cn.Conexion();
	    ps=con.prepareStatement(sql);
	    ps.setString(1, pr.getNombres());
	    ps.setString(2, pr.getPrecio());
	    ps.setString(3, pr.getStock());
	    ps.setString(4, pr.getEstado());
	    ps.executeUpdate();
	}catch (Exception e){
	}
	return r;
    }
    
    public Producto listarId(int id){
	Producto pro=new Producto();
	String sql = "SELECT * FROM producto WHERE IdProducto="+id;
	try{
	    con = cn.Conexion();
	    ps = con.prepareStatement(sql);
	    rs = ps.executeQuery();
	    while(rs.next()){
		pro.setNombres(rs.getString(2));
		pro.setPrecio(rs.getString(3));
		pro.setStock(rs.getString(4));
		pro.setEstado(rs.getString(5));
	    }
	}catch (Exception e){
	}
	return pro;
    }
    
    public int actualizar (Producto pr){
	String sql = "UPDATE producto SET Nombres=?, Precio=?, Stock=?, Estado=? WHERE IdProducto=?";
	try{
	    con=cn.Conexion();
	    ps=con.prepareStatement(sql);
	    ps.setString(1, pr.getNombres());
	    ps.setString(2, pr.getPrecio());
	    ps.setString(3, pr.getStock());
	    ps.setString(4, pr.getEstado());
	    ps.setInt(5, pr.getId());
	    ps.executeUpdate();
	}catch (Exception e){
	}
	return r;
    }
    
    public void delete(int id){
	String sql = "DELETE FROM producto WHERE IdProducto="+id;
	try{
	    con=cn.Conexion();
	    ps=con.prepareStatement(sql);
	    ps.executeUpdate();
	}catch (Exception e){
	    
	}
    }
}
