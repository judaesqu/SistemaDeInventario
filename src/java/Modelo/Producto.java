/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Espinosa Beltran
 */
public class Producto {
    int id;
    String Nombres;
    String Precio;
    int Stock;
    String Estado;
        
    public Producto(){
}

public Producto(int id, String Nombres, String Precio, int Stock, String Estado){
this.id = id;
this.Nombres = Nombres;
this.Precio = Precio;
this.Stock = Stock;
this.Estado = Estado;
}

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    public String getNombres() {
	return Nombres;
    }

    public void setNombres(String Nombres) {
	this.Nombres = Nombres;
    }

    public String getPrecio() {
	return Precio;
    }

    public void setPrecio(String Precio) {
	this.Precio = Precio;
    }

    public int getStock() {
	return Stock;
    }

    public void setStock(int Stock) {
	this.Stock = Stock;
    }

    public String getEstado() {
	return Estado;
    }

    public void setEstado(String Estado) {
	this.Estado = Estado;
    }

    
}




