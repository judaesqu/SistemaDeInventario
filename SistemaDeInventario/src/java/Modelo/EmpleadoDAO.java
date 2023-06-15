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

/**
 *
 * @author Espinosa Beltran
 */
public class EmpleadoDAO {
    Conexion cn=new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
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
}
