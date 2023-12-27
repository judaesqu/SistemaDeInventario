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
public class EmpleadoDAO {
    Conexion cn=new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;
    
    public Empleado validar(String User, String CC) throws SQLException{
        Empleado em=new Empleado();
        String sql="SELECT * FROM empleado WHERE User=? and CC=?";
        try{
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setString(1, User);
            ps.setString(2, CC);
            rs=ps.executeQuery();
            while (rs.next()){
                em.setId(rs.getInt("IdEmpleado"));
                em.setUser(rs.getString("User"));
                em.setCC(rs.getString("CC"));
                em.setNombres(rs.getString("Nombres"));
            }

        }catch (Exception e){
        }
        
        return em;
    }
    
    //Operaciones del CRUD
    
    public List listar(){
        String sql = "SELECT * FROM empleado";
        List<Empleado>lista=new ArrayList<>();
        try{
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()){
                Empleado em= new Empleado();
                em.setId(rs.getInt(1));
                em.setCC(rs.getString(2));
                em.setNombres(rs.getString(3));
                em.setTelefono(rs.getString(4));
                em.setEstado(rs.getString(5));
                em.setUser(rs.getString(6));
                lista.add(em);
            }
        }catch (Exception e){
        }
        return lista;
    }
    public int agregar(Empleado em){
        String sql="INSERT INTO empleado (CC, Nombres, Telefono, Estado, User) VALUES (?,?,?,?,?)";
                try{
                    con=cn.Conexion();
                    ps=con.prepareStatement(sql);
                    ps.setString(1, em.getCC());
                    ps.setString(2, em.getNombres());
                    ps.setString(3, em.getTelefono());
                    ps.setString(4, em.getEstado());
                    ps.setString(5, em.getUser());
                    ps.executeUpdate();
                }catch (Exception e){
                }
                return r;
    }
    
    public Empleado listarId(int id){
        Empleado emp=new Empleado();
        String sql = "SELECT * FROM empleado WHERE IdEmpleado="+id;
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                emp.setCC(rs.getString(2));
                emp.setNombres(rs.getString(3));
                emp.setTelefono(rs.getString(4));
                emp.setEstado(rs.getString(5));
                emp.setUser(rs.getString(6));
            }
        }catch (Exception e){
            
        }
        return emp;
    }
    
    public int actualizar(Empleado em){
        String sql="UPDATE empleado SET CC=?, Nombres=?, Telefono=?, Estado=?, User=? WHERE IdEmpleado=?";
                try{
                    con=cn.Conexion();
                    ps=con.prepareStatement(sql);
                    ps.setString(1, em.getCC());
                    ps.setString(2, em.getNombres());
                    ps.setString(3, em.getTelefono());
                    ps.setString(4, em.getEstado());
                    ps.setString(5, em.getUser());
                    ps.setInt(6, em.getId());
                    ps.executeUpdate();
                }catch (Exception e){
                }
                return r;
    }
    
    
    public void delete(int id){
        String sql = "DELETE FROM empleado WHERE IdEmpleado="+id;
        try{
        con=cn.Conexion();
        ps=con.prepareStatement(sql);
        ps.executeUpdate();
    }catch (Exception e){
}
}
}


