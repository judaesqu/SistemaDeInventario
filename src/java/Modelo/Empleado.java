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
public class Empleado {
    int id;
    String CC;
    String Nombres;
    String Telefono;
    String Estado;
    String User;
    
    public Empleado(){
    }
    
    public Empleado(int id, String CC, String Nombres, String Telefono, String Estado, String User){
        this.id = id;
        this.CC = CC;
        this.Nombres = Nombres;
        this.Telefono = Telefono;
        this.Estado = Estado;
        this.User = User;
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

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public String getUser() {
        return User;
    }

    public void setUser(String User) {
        this.User = User;
    }
            
    
}
