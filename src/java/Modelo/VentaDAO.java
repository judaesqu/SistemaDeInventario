/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Controlador.Controlador;
import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Espinosa Beltran
 */
public class VentaDAO {
    Connection con;
    Conexion cn=new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    int r;
    
    public String GenerarSerie() throws SQLException{
	String numeroserie="";
	String sql = "SELECT MAX(NumeroSerie) FROM ventas";
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
    
    public String IdVentas() {
    String idventas = null; // Iniciar con un valor que indique ausencia de resultados
    String sql = "SELECT MAX(IdVentas) FROM ventas";

    try (Connection con = cn.Conexion(); // Usar try-with-resources
         PreparedStatement ps = con.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {

        if (rs.next()) {
            idventas = rs.getString(1);
        }

    } catch (SQLException e) {
        // Manejar la excepción aquí
    }

    return idventas;
}
    
    public int guardarVenta(Venta ve){
	String sql = "INSERT INTO ventas (IdCliente, IdEmpleado, NumeroSerie, FechaVentas, Monto, Estado) VALUES (?,?,?,?,?,?)";
	try{
	    con=cn.Conexion();
	    ps=con.prepareStatement(sql);
	    ps.setInt(1, ve.getIdcliente());
	    ps.setInt(2, ve.getIdempleado());
	    ps.setString(3, ve.getNumserie());
	    ps.setString(4, ve.getFecha());
	    ps.setDouble(5, ve.getPrecio());
	    ps.setString(6, ve.getEstado());
	    ps.executeUpdate();
	    
	}catch (SQLException e){
	    System.err.println("Error al guardar la venta:"+ e.getMessage());
	}
	return r;
	
    }	
    public int guardarDetalleventas(Venta venta){
	    int r = 0;
	try {
        // Validar datos
        if (venta.getId() <= 0) {
            throw new IllegalArgumentException("El ID de la venta debe ser mayor que 0");
        }
        if (venta.getIdproducto() <= 0) {
            throw new IllegalArgumentException("El ID del producto debe ser un número entero positivo");
        }
        if (venta.getCantidad() <= 0) {
            throw new IllegalArgumentException("La cantidad debe ser un número entero positivo");
        }

        // Obtener el ID de la venta recién insertada
        int idventas = venta.getId();
        if (idventas == 0) {
            idventas = getLastInsertId();
        }

        // Ejecutar la consulta SQL
        String sql = "INSERT INTO detalle_ventas (IdVentas, IdProducto, Cantidad, PrecioVenta) VALUES (?,?,?,?)";
        con = cn.Conexion();
        ps = con.prepareStatement(sql);
        ps.setInt(1, idventas);
        ps.setInt(2, venta.getIdproducto());
        ps.setInt(3, venta.getCantidad());
        ps.setDouble(4, venta.getPrecio());
        r = ps.executeUpdate();
    } catch (Exception e) {
        // Manejar excepciones
    }

    return r;
}

    private int getLastInsertId() {
	throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
