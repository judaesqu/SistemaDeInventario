<%-- 
    Document   : Empleados
    Created on : 2/06/2023, 01:44:11 PM
    Author     : EspinosaBeltran
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
        <div class="d-flex">
         <div class="card col-sm-4">
            <div class="card-body">
                <form action="Controlador?menu=Empleado">
                    <div class="form-group">
                        <label>Nombre empleado</label>
                        <input type="text" name="txtnombre" class="form-control">
                    </div>
                    <div class="form-group">
                        <label>Cargo</label>
                        <input type="text" name="txtcargo" class="form-control">
                    </div>
                    <div class="form-group">
                        <label>Fecha Contratación</label>
                        <input type="text" name="txtfecha" class="form-control">
                    </div>
                    <div class="form-group">
                        <label>User</label>
                        <input type="text" name="txtuser" class="form-control">
                    </div>
                    <div class="form-group">
                        <label>Password</label>
                        <input type="text" name="txtpass" class="form-control">
                    </div>
                    <div class="form-group">
                        <label>Email</label>
                        <input type="text" name="txtemail" class="form-control">
                    </div>
                    <input type ="submit" name="accion" value="Agregar" class="btn btn-info">
                </form>                
            </div>
        </div>   
            <div class="col-sm-8">
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th>Id</th>
                            <th>Nombre</th>
                            <th>Cargo</th>
                            <th>Fecha Contrato</th>
                            <th>Usuario</th>
                            <th>Password</th>
                            <th>Correo</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="em" items="${empleados}">
                        <tr>
                            <td>${em.getID_empleado()}</td>
                            <td>${em.getNombre_empleado()}</td>
                            <td>${em.getCargo()}</td>
                            <td>${em.getFecha_contratacion()}</td>
                            <td>${em.getUser()}</td>
                            <td>${em.getPassword()}</td>
                            <td>${em.getEmail()}</td>
                            <td>
                                <a>Editar</a>
                                <a>Delete</a>
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
