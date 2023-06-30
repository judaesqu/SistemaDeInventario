<%-- 
    Document   : Proveedores
    Created on : 14/06/2023, 10:52:56 PM
    Author     : Espinosa Beltran
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <title>JSP Page</title>
    </head>
    <body>
        <body>
        <div class="d-flex">
         <div class="card col-sm-3">
            <div class="card-body">
                <form action="Controlador?menu=Proveedor" method="POST">
                    <div class="form-group">
                        <label>Razón Social</label>
                        <input type="text" value="${proveedor.getNombre_proveedor()}" name="txtnombre" class="form-control">
                    </div>
                    <div class="form-group">
                        <label>NIT</label>
                        <input type="text" value="${proveedor.getNIT()}" name="txtnit" class="form-control">
                    </div>
                    <div class="form-group">
                        <label>Direccion</label>
                        <input type="text" value="${proveedor.getDireccion()}" name="txtdireccion" class="form-control">
                    </div>
                    <div class="form-group">
                        <label>Nombre Contacto</label>
                        <input type="text" value="${proveedor.getNombre_contacto()}" name="txtcontacto" class="form-control">
                    </div>
                    <div class="form-group">
                        <label>Telefono</label>
                        <input type="text" value="${proveedor.getTelefono()}" name="txttelefono" class="form-control">
                    </div>
                    <div class="form-group">
                        <label>Email</label>
                        <input type="text" value="${proveedor.getCorreo_electronico()}" name="txtemail" class="form-control">
                    </div>
                    <div class="form-group">
                        <label>Forma Pago</label>
                        <input type="text" value="${proveedor.getForma_de_pago()}" name="txtforma" class="form-control">
                    </div>
                    <div class="form-group">
                        <label>Medio Pago</label>
                        <input type="text" value="${proveedor.getMedio_de_pago()}" name="txtmedio" class="form-control">
                    </div>
                    <div class="form-group">
                        <label>Cuenta No.</label>
                        <input type="text" value="${proveedor.getNumero_de_cuenta()}" name="txtcuenta" class="form-control">
                    </div>
                    <div class="form-group">
                        <label>Banco</label>
                        <input type="text" value="${proveedor.getBanco()}" name="txtbanco" class="form-control">
                    </div>
                    <div class="form-group">
                        <label>Plazo pago</label>
                        <input type="text" value="${proveedor.getPlazo_pago()}" name="txtplazo" class="form-control">
                    </div>
                    <input type ="submit" name="accion" value="Agregar" class="btn btn-info">
                    <input type ="submit" name="accion" value="Actualizar" class="btn btn-success">
                </form>                
            </div>
        </div>   
            <div class="col-sm-6">
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th>Id</th>
                            <th>Razon Social</th>
                            <th>NIT</th>
                            <th>Direccion</th>
                            <th>Nombre contacto</th>
                            <th>Telefono</th>
                            <th>Email</th>
                            <th>Forma de pago</th>
                            <th>Medio de pago</th>
                            <th>Cuenta No.</th>
                            <th>Banco</th>
                            <th>Plazo de pago</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="pr" items="${proveedores}">
                        <tr>
                            <td>${pr.getID_proveedor()}</td>
                            <td>${pr.getNombre_proveedor()}</td>
                            <td>${pr.getNIT()}</td>
                            <td>${pr.getDireccion()}</td>
                            <td>${pr.getNombre_contacto()}</td>
                            <td>${pr.getTelefono()}</td>
                            <td>${pr.getCorreo_electronico()}</td>
                            <td>${pr.getForma_de_pago()}</td>
                            <td>${pr.getMedio_de_pago()}</td>
                            <td>${pr.getNumero_de_cuenta()}</td>
                            <td>${pr.getBanco()}</td>
                            <td>${pr.getPlazo_pago()}</td>
                            <td>
                                <a class="btn btn-warning" href="Controlador?menu=Proveedor&accion=Editar&id=${pr.getID_proveedor()}">Editar</a>
                                <br>
                                <a class="btn btn-danger" href="Controlador?menu=Proveedor&accion=Delete&id=${pr.getID_proveedor()}">Delete</a>
                            </td>
                        </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>
