<%-- 
    Document   : Registrar Venta
    Created on : 18/12/2023, 05:07:27 PM
    Author     : Espinosa Beltran
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <title>VENTAS</title>
    </head>
    <body>
        <div class="d-flex">
	    <div class="col-sm-5">
		<div class="card">
		    <form action="Controlador?menu=NuevaVenta" method="POST">
		    <div class="card-body">
			<!---Formulario de datos del cliente--->
			<div class="form-group">
			    <label>Datos del Cliente</label>
			</div>
			<div class="form-group d-flex">
			    <div class="col-sm-6 d-flex">
				<input type="text" name="codigocliente" value="${c.getCC()}" class="form-control" placeholder="Código">
				<input type ="submit" name ="accion" value="BuscarCliente" class="btn btn-outline-info">
			    </div>
			    <div class="col-sm-6">
				<input type ="text" name="nombrescliente" value ="${c.getNombres()}" class="form-control">
			    </div>
			</div>
			    <!---Formulario de datos del producto--->
			<div class="form-group">
			    <label>Datos Producto</label>
			</div>
			<div class="form-group d-flex">
			    <div class="col-sm-6 d-flex">
				<input type="text" name="codigoproducto" value="${producto.getId()}" class="form-control col-sm-4" placeholder="Producto">
				<Button type ="submit" name ="accion" value="BuscarProducto" class="btn btn-outline-info">Buscar</button>
			    </div>
			    <div class="col-sm-6">
				<input type ="text" name="nombreproducto" value="${producto.getNombres()}" class="form-control" placeholder="Datos producto">
			    </div>
			</div>
			<div class="form-group d-flex">
			    <div class="col-sm-6 d-flex">
				<input type="text" name="precio" value="${producto.getPrecio()}" class="form-control" placeholder="$/0.00">
			    </div>
			    <div class="col-sm-3">
				<input type ="number" name="cant" value="1" placeholder="" class="form-control">
			    </div>
			    <div class="col-sm-3">
				<input type ="text" name="stock" value="${producto.getStock()}" class="form-control" placeholder="Stock">
			    </div>
			</div>
			<div class="form-group">
			    <input type="submit" name="accion" value="Agregar" class="btn btn-outline-info">
			</div>
		    </div>
			</form>
		</div>	
	    </div>
	    <div class="col-sm-7">
		<div class="card">
		    <div class="card-body">
			<div class="d-flex col-sm-5 ml-auto">
			    <label>Nro. Serie:</label>
			    <input type="text" name="NroSerie" value="${nserie}" class="form-control">
			</div>
			<table class="table table-hover" id="tablaProductos">
			    <thead>
				    <th>Nro</th>
				    <th>Código</th>
				    <th>Descripción</th>
				    <th>Precio</th>
				    <th>Cantidad</th>
				    <th>SubTotal</th>
				</tr>
			    </thead>
			    <tbody>
				<c:forEach var="lista" items="${lista}" varStatus="status">
				    <tr data-idproducto="${lista.getIdproducto()}">
				    <td>${lista.getItem()}</td>
				    <td>${lista.getIdproducto()}</td>
				    <td>${lista.getDescripcionP()}</td>
				    <td>${lista.getPrecio()}</td>
				    <td>${lista.getCantidad()}</td>
				    <td>${lista.getSubtotal()}</td>
				</tr>
			    </c:forEach>
			    </tbody>
			</table>
	    </div>
		    <div class="card-footer d-flex">
			<div class="col-sm-6">
			    <a href="Controlador?menu=NuevaVenta&accion=GenerarVenta" class="btn btn-success" type="submit">Generar Venta</a>
			    <input type="submit" name="accion" value="Cancelar" class="btn btn-danger">
			</div>
			<div class="col-sm-4 ml-auto">
			    <input type="text" name="txtTotal" value="$${totalpagar}0" class="form-control">
			</div>
		    </div>
	</div>
	    </div>
	</div>
			<% 
			    //Verificamos si la venta fue exitosa
			    Boolean compraExitosa = (Boolean) request.getAttribute("compraExitosa");
			    if(compraExitosa != null && compraExitosa){
				%>
				
				<script type="text/javascript">
				    alert("La venta fue satisfactoria");
				    </script>
				    
			<%
			    }
			%>
			
			<script>
    $(document).ready(function () {
             
        // Evento de click para el botón "Cancelar"
        $('input[name="accion"][value="Cancelar"]').on('click', function () {
            // Lógica para limpiar la tabla
            $('#tablaProductos tbody').empty();
	    $('input[name="txtTotal"]').val('$0.00');
            console.log("Cancelar y limpiar la tabla");
        });
    });
</script>


    </body>
</html>
