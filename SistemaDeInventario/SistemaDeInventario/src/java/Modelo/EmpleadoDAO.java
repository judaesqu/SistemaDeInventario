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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Espinosa Beltran
 */
public class EmpleadoDAO {
    Conexion cn=new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;
    
    public Empleado validar(String User, String Password){
        Empleado em=new Empleado();
        String sql = "SELECT * FROM empleado WHERE User=? AND Password=?";
        try{
            con=cn.conector();
            ps=con.prepareStatement(sql);
            ps.setString(1, User);
            ps.setString(2, Password);
            rs=ps.executeQuery();
            while (rs.next()){
                em.setID_empleado(rs.getInt("ID_empleado"));
                em.setNombre_empleado(rs.getString("Nombre_empleado"));
                em.setCargo(rs.getString("Cargo"));
                em.setUser(rs.getString("User"));
                em.setPassword(rs.getString("Password"));
                em.setEmail(rs.getString("Email"));         
            }
        }catch (Exception e){
        }
        return em;
    }
    
    //Operaciones del CRUD
    
    public List listar (){
        String sql = "SELECT * FROM empleado";
        List <Empleado> lista = new ArrayList<>();
        try{
            con=cn.conector();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()){
                Empleado em=new Empleado();
                em.setID_empleado(rs.getInt(1));
                em.setNombre_empleado(rs.getString(2));
                em.setCargo(rs.getString(3));
                em.setFecha_contratacion(rs.getString(4));
                em.setUser(rs.getString(5));
                em.setPassword(rs.getString(6));
                em.setEmail(rs.getString(7));
                lista.add(em);
            }
        }catch(Exception e){   
        }
        return lista;
    }
    public int agregar (Empleado em){
        String sql = "INSERT INTO empleado (Nombre_empleado, Cargo, Fecha_contratacion, User, Password, Email) VALUES (?,?,?,?,?,?)";
        try{
            con=cn.conector();
            ps=con.prepareStatement(sql);
            ps.setString(1, em.getNombre_empleado());
            ps.setString(2, em.getCargo());
            ps.setString(3, em.getFecha_contratacion());
            ps.setString(4, em.getUser());
            ps.setString(5, em.getPassword());
            ps.setString(6, em.getEmail());
            ps.executeUpdate();
        }catch (Exception e){
        }
        return r;
    }
    public Empleado listarId(int id){
        Empleado emp=new Empleado();
        String sql = "SELECT * FROM empleado WHERE ID_empleado="+id;
        try{
            con=cn.conector();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                emp.setNombre_empleado(rs.getString(2));
                emp.setCargo(rs.getString(3));
                emp.setFecha_contratacion(rs.getString(4));
                emp.setUser(rs.getString(5));
                emp.setPassword(rs.getString(6));
                emp.setEmail(rs.getString(7));
            }
        }catch (Exception e){
        }
        return emp;
    }
    public int actualizar (Empleado em){
        String sql = "UPDATE empleado SET Nombre_empleado=?, Cargo=?, Fecha_contratacion=?, User=?, Password=?, Email=? WHERE ID_empleado=?";
        try{
            con=cn.conector();
            ps=con.prepareStatement(sql);
            ps.setString(1, em.getNombre_empleado());
            ps.setString(2, em.getCargo());
            ps.setString(3, em.getFecha_contratacion());
            ps.setString(4, em.getUser());
            ps.setString(5, em.getPassword());
            ps.setString(6, em.getEmail());
            ps.setInt(6, em.getID_empleado());
            ps.executeUpdate();
        }catch (Exception e){
        }
        return r;
    }
    public void delete(int id){
        String sql = "DELETE from empleado WHERE ID_empleado="+id;
        try{
            con=cn.conector();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        }catch (Exception e){
            
        }
    }
}
