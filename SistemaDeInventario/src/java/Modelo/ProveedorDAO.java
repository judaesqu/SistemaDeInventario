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
public class ProveedorDAO {
    Conexion cn=new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;
    
    public List listar(){
        String sql = "SELECT * FROM proveedor";
        List <Proveedor> lista = new ArrayList<>();
        try{
            con = cn.conector();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                Proveedor pr=new Proveedor();
                pr.setID_proveedor(rs.getInt(1));
                pr.setNombre_proveedor(rs.getString(2));
                pr.setNIT(rs.getString(3));
                pr.setDireccion(rs.getString(4));
                pr.setNombre_contacto(rs.getString(5));
                pr.setTelefono(rs.getString(6));
                pr.setCorreo_electronico(rs.getString(7));
                pr.setForma_de_pago(rs.getString(8));
                pr.setMedio_de_pago(rs.getString(9));
                pr.setNumero_de_cuenta(rs.getString(10));
                pr.setBanco(rs.getString(11));
                pr.setPlazo_pago(rs.getString(12));
                lista.add(pr);
            }
        }catch(Exception e){
        }
        return lista;
    }
    public int agregar (Proveedor pr){
        String sql = "INSERT INTO proveedor (Nombre_proveedor, NIT, Direccion, Nombre_contacto, Telefono, Correo_electronico, Forma_de_pago, Medio_de_pago, Numero_de_cuenta, Banco, Plazo_pago) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        try{
            con=cn.conector();
            ps=con.prepareStatement(sql);
            ps.setString(1, pr.getNombre_proveedor());
            ps.setString(2, pr.getNIT());
            ps.setString(3, pr.getDireccion());
            ps.setString(4, pr.getNombre_contacto());
            ps.setString(5, pr.getTelefono());
            ps.setString(6, pr.getCorreo_electronico());
            ps.setString(7, pr.getForma_de_pago());
            ps.setString(8, pr.getMedio_de_pago());
            ps.setString(9, pr.getNumero_de_cuenta());
            ps.setString(10, pr.getBanco());
            ps.setString(11, pr.getPlazo_pago());
            ps.executeUpdate();
        }catch (Exception e){
        }
        return r;
    }
    public Proveedor listarId(int id){
        Proveedor pr=new Proveedor();
        String sql = "SELECT * FROM proveedor WHERE ID_proveedor="+id;
        try{
            con=cn.conector();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                pr.setNombre_proveedor(rs.getString(2));
                pr.setNIT(rs.getString(3));
                pr.setDireccion(rs.getString(4));
                pr.setNombre_contacto(rs.getString(5));
                pr.setTelefono(rs.getString(6));
                pr.setCorreo_electronico(rs.getString(7));
                pr.setForma_de_pago(rs.getString(8));
                pr.setMedio_de_pago(rs.getString(9));
                pr.setNumero_de_cuenta(rs.getString(10));
                pr.setBanco(rs.getString(11));
                pr.setPlazo_pago(rs.getString(12));
            }
        }catch (Exception e){
        }
        return pr;
    }
    public int actualizar (Proveedor pr){
        String sql = "UPDATE proveedor SET Nombre_proveedor=?, NIT=?, Direccion=?, Nombre_contacto=?, Telefono=?, Correo_electronico=?, Forma_de_pago=?, Medio_de_pago=?, Numero_de_cuenta=?, Banco=?, Plazo_pago=? WHERE ID_proveedor=?";
        try{
            con=cn.conector();
            ps=con.prepareStatement(sql);
            ps.setString(1, pr.getNombre_proveedor());
            ps.setString(2, pr.getNIT());
            ps.setString(3, pr.getDireccion());
            ps.setString(4, pr.getNombre_contacto());
            ps.setString(5, pr.getTelefono());
            ps.setString(6, pr.getCorreo_electronico());
            ps.setString(7, pr.getForma_de_pago());
            ps.setString(8, pr.getMedio_de_pago());
            ps.setString(9, pr.getNumero_de_cuenta());
            ps.setString(10, pr.getBanco());
            ps.setString(11, pr.getPlazo_pago());
            ps.setInt(12, pr.getID_proveedor());
            ps.executeUpdate();
        }catch (Exception e){
        }
        return r;
    }
    public void delete (int id){
        String sql = "DELETE from proveedor WHERE ID_proveedor="+id;
        try{
            con=cn.conector();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        }catch (Exception e){
        }
    }
}
