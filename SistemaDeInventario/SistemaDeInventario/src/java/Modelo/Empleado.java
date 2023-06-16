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
    int ID_empleado;
    String Nombre_empleado;
    String Cargo;
    String Fecha_contratacion;
    String User;
    String Password;
    String Email;

    public Empleado(){
}
    
    public Empleado (int ID_empleado, String Nombre_empleado, String Cargo, String Fecha_contratacion, String User, String Password, String Email){
        this.ID_empleado=ID_empleado;
        this.Nombre_empleado=Nombre_empleado;
        this.Cargo=Cargo;
        this.Fecha_contratacion=Fecha_contratacion;
        this.User=User;
        this.Password=Password;
        this.Email=Email;
        
    }

    public int getID_empleado() {
        return ID_empleado;
    }

    public void setID_empleado(int ID_empleado) {
        this.ID_empleado = ID_empleado;
    }

    public String getNombre_empleado() {
        return Nombre_empleado;
    }

    public void setNombre_empleado(String Nombre_empleado) {
        this.Nombre_empleado = Nombre_empleado;
    }

    public String getCargo() {
        return Cargo;
    }

    public void setCargo(String Cargo) {
        this.Cargo = Cargo;
    }

    public String getFecha_contratacion() {
        return Fecha_contratacion;
    }

    public void setFecha_contratacion(String Fecha_contratacion) {
        this.Fecha_contratacion = Fecha_contratacion;
    }

    public String getUser() {
        return User;
    }

    public void setUser(String User) {
        this.User = User;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    
}
