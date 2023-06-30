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
public class Proveedor {
    int ID_proveedor;
    String Nombre_proveedor;
    String NIT;
    String Direccion;
    String Nombre_contacto;
    String Telefono;
    String Correo_electronico;
    String Forma_de_pago;
    String Medio_de_pago;
    String Numero_de_cuenta;
    String Banco;
    String Plazo_pago;
    
    public Proveedor(){
   }
    
    public Proveedor (int ID_proveedor,String Nombre_proveedor,String NIT, String Direccion,String Nombre_contacto, String Telefono, String Correo_electronico, String Forma_de_pago, String Medio_de_pago, String Numero_de_cuenta, String Banco, String Plazo_pago){
        this.ID_proveedor=ID_proveedor;
        this.Nombre_proveedor=Nombre_proveedor;
        this.NIT=NIT;
        this.Direccion=Direccion;
        this.Nombre_contacto=Nombre_contacto;
        this.Telefono=Telefono;
        this.Correo_electronico=Correo_electronico;
        this.Forma_de_pago=Forma_de_pago;
        this.Medio_de_pago=Medio_de_pago;
        this.Banco=Banco;
        this.Plazo_pago=Plazo_pago;
    }

    public int getID_proveedor() {
        return ID_proveedor;
    }

    public void setID_proveedor(int ID_proveedor) {
        this.ID_proveedor = ID_proveedor;
    }

    public String getNombre_proveedor() {
        return Nombre_proveedor;
    }

    public void setNombre_proveedor(String Nombre_proveedor) {
        this.Nombre_proveedor = Nombre_proveedor;
    }

    public String getNIT() {
        return NIT;
    }

    public void setNIT(String NIT) {
        this.NIT = NIT;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getNombre_contacto() {
        return Nombre_contacto;
    }

    public void setNombre_contacto(String Nombre_contacto) {
        this.Nombre_contacto = Nombre_contacto;
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

    public String getForma_de_pago() {
        return Forma_de_pago;
    }

    public void setForma_de_pago(String Forma_de_pago) {
        this.Forma_de_pago = Forma_de_pago;
    }

    public String getMedio_de_pago() {
        return Medio_de_pago;
    }

    public void setMedio_de_pago(String Medio_de_pago) {
        this.Medio_de_pago = Medio_de_pago;
    }

    public String getNumero_de_cuenta() {
        return Numero_de_cuenta;
    }

    public void setNumero_de_cuenta(String Numero_de_cuenta) {
        this.Numero_de_cuenta = Numero_de_cuenta;
    }

    public String getBanco() {
        return Banco;
    }

    public void setBanco(String Banco) {
        this.Banco = Banco;
    }

    public String getPlazo_pago() {
        return Plazo_pago;
    }

    public void setPlazo_pago(String Plazo_pago) {
        this.Plazo_pago = Plazo_pago;
    }
    
    
}

    