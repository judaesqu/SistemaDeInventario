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
public class ClienteDAO {
    Conexion cn=new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;
    
    public Cliente buscar(String CC){
	Cliente c=new Cliente();
	String sql = "SELECT * FROM cliente WHERE CC="+CC;
	try{
	    con=cn.Conexion();
	    ps=con.prepareStatement(sql);
	    rs=ps.executeQuery();
	    while (rs.next()){
		c.setId(rs.getInt(1));
		c.setCC(rs.getString(2));
		c.setNombres(rs.getString(3));
		c.setDireccion(rs.getString(4));
		c.setEstado(rs.getString(5));
	    }
	}catch (Exception e){
	}
	
	return c;
    }
    
    public List listar() throws SQLException{
	String sql = "SELECT * FROM cliente";
	List<Cliente>lista = new ArrayList<>();
	try{
	    con=cn.Conexion();
	    ps=con.prepareStatement(sql);
	    rs=ps.executeQuery();
	    while(rs.next()){
		Cliente cl = new Cliente();
		cl.setId(rs.getInt(1));
		cl.setCC(rs.getString(2));
		cl.setNombres(rs.getString(3));
		cl.setDireccion(rs.getString(4));
		cl.setEstado(rs.getString(5));
		lista.add(cl);
	    }
	}catch (Exception e){
	}
	return lista;
    }
    public int agregar (Cliente cl){
	String sql = "INSERT INTO cliente (CC, Nombres, Direccion, Estado) VALUES (?,?,?,?)";
	try{
	    con=cn.Conexion();
	    ps=con.prepareStatement(sql);
	    ps.setString(1, cl.getCC());
	    ps.setString(2, cl.getNombres());
	    ps.setString(3, cl.getDireccion());
	    ps.setString(4, cl.getEstado());
	    ps.executeUpdate();
	}catch (Exception e){
	}
	return r;
    }
    
    public Cliente listarId(int id) throws SQLException{
	Cliente cli=new Cliente();
	String sql = "SELECT * FROM cliente WHERE IdCliente="+id;
	try{
	    con = cn.Conexion();
	    ps = con.prepareStatement(sql);
	    rs = ps.executeQuery();
	    while(rs.next()){
		cli.setCC(rs.getString(2));
		cli.setNombres(rs.getString(3));
		cli.setDireccion(rs.getString(4));
		cli.setEstado(rs.getString(5));
	    }
	}catch (Exception e){
	}
	return cli;
    }
    
    public int actualizar(Cliente cl){
	String sql = "UPDATE cliente SET CC=?, Nombres=?, Direccion=?, Estado=? WHERE IdCliente=?";
	try{
	    con=cn.Conexion();
	    ps=con.prepareStatement(sql);
	    ps.setString(1, cl.getCC());
	    ps.setString(2, cl.getNombres());
	    ps.setString(3, cl.getDireccion());
	    ps.setString(4, cl.getEstado());
	    ps.executeUpdate();
	}catch (Exception e){
	}
	return r;
    }
    
    public void delete(int id){
	String sql = "DELETE FROM cliente WHERE IdCliente="+id;
	try{
	    con=cn.Conexion();
	    ps=con.prepareStatement(sql);
	    ps.executeUpdate();
	}catch(Exception e){
	}
    }
}
