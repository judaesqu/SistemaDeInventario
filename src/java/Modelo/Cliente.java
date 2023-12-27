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
public class Cliente {
    int id;
    String CC;
    String Nombres;
    String Direccion;
    String Estado;
    
    public Cliente(){
    }
    
    public Cliente(int id, String CC, String Nombres, String Direccion, String Estado){
	this.id = id;
	this.CC = CC;
	this.Nombres=Nombres;
	this.Direccion=Direccion;
	this.Estado=Estado;
    }

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    public String getCC() {
	return CC;
    }

    public void setCC(String CC) {
	this.CC = CC;
    }

    public String getNombres() {
	return Nombres;
    }

    public void setNombres(String Nombres) {
	this.Nombres = Nombres;
    }

    public String getDireccion() {
	return Direccion;
    }

    public void setDireccion(String Direccion) {
	this.Direccion = Direccion;
    }

    public String getEstado() {
	return Estado;
    }

    public void setEstado(String Estado) {
	this.Estado = Estado;
    }
    
    
}