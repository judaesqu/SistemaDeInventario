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
    int ID_cliente;
    String Nombre_cliente;
    String Direccion;
    String Telefono;
    String Correo_electronico;

    public Cliente(){
    }
    
    public Cliente (int ID_cliente, String Nombre_cliente, String Direccion, String Telefono, String Correo_electronico){
        this.ID_cliente=ID_cliente;
        this.Nombre_cliente=Nombre_cliente;
        this.Direccion=Direccion;
        this.Telefono=Telefono;
        this.Correo_electronico=Correo_electronico;
    }

    public int getID_cliente() {
        return ID_cliente;
    }

    public void setID_cliente(int ID_cliente) {
        this.ID_cliente = ID_cliente;
    }

    public String getNombre_cliente() {
        return Nombre_cliente;
    }

    public void setNombre_cliente(String Nombre_cliente) {
        this.Nombre_cliente = Nombre_cliente;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public String getCorreo_electronico() {
        return Correo_electronico;
    }

    public void setCorreo_electronico(String Correo_electronico) {
        this.Correo_electronico = Correo_electronico;
    }
    
    
}
