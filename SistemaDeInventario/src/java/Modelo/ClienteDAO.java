/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Config.Conexion;
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
    
    //Operaciones del CRUD
    
    public List listar (){
        String sql = "SELECT * FROM cliente";
        List <Cliente> lista = new ArrayList<>();
        try{
            con=cn.conector();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()){
                Cliente c=new Cliente();
                c.setID_cliente(rs.getInt(1));
                c.setNombre_cliente(rs.getString(2));
                c.setDireccion(rs.getString(3));
                c.setTelefono(rs.getString(4));
                c.setCorreo_electronico(rs.getString(5));
                
                lista.add(c);
            }
        }catch(Exception e){   
        }
        return lista;
    }
    public int agregar (Cliente c){
        String sql = "INSERT INTO cliente (Nombre_cliente, Direccion, Telefono, Correo_electronico) VALUES (?,?,?,?)";
        try{
            con=cn.conector();
            ps=con.prepareStatement(sql);
            ps.setString(1, c.getNombre_cliente());
            ps.setString(2, c.getDireccion());
            ps.setString(3, c.getTelefono());
            ps.setString(4, c.getCorreo_electronico());
            ps.executeUpdate();
        }catch (Exception e){
        }
        return r;
    }
    public Cliente listarId(int id){
        Cliente c =new Cliente();
        String sql = "SELECT * FROM cliente WHERE ID_cliente="+id;
        try{
            con=cn.conector();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()){
             c.setNombre_cliente(rs.getString(2));
             c.setDireccion(rs.getString(3));
             c.setTelefono(rs.getString(4));
             c.setCorreo_electronico(rs.getString(5));
            }
        }catch (Exception e){
        }
        return c;
    }
    public int actualizar (Cliente c){
        String sql = "UPDATE cliente SET Nombre_cliente=?, Direccion=?, Telefono=?, Correo_electronico=? WHERE ID_cliente=?";
        try{
            con=cn.conector();
            ps=con.prepareStatement(sql);
            ps.setString(1, c.getNombre_cliente());
            ps.setString(2, c.getDireccion());
            ps.setString(3, c.getTelefono());
            ps.setString(4, c.getCorreo_electronico());
            ps.setInt(5, c.getID_cliente());
            ps.executeUpdate();
        }catch (Exception e){
        }
        return r;
    }
    public void delete(int id){
        String sql = "DELETE from cliente WHERE ID_cliente="+id;
        try{
            con=cn.conector();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        }catch (Exception e){
        }
    }
}
