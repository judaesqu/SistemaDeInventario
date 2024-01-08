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
	<style>
	    @media print{
		.parte01, .btn{
		    display:none;
		}
	    }
	</style>
    </head>
    <body>
        <div class="d-flex">
	    <div class="col-sm-5 parte01">
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
				<input type="text" name="NroSerie" value="${sessionScope.numeroserie}" class="form-control">
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
			    <a href="Controlador?menu=NuevaVenta&accion=GenerarVenta" onclick="print()" class="btn btn-success" type="submit">
				Generar Venta <svg xmlns="http://www.w3.org/2000/svg" height="16" width="18" viewBox="0 0 576 512"><!--!Font Awesome Free 6.5.1 by @fontawesome - https://fontawesome.com License - https://fontawesome.com/license/free Copyright 2024 Fonticons, Inc.--><path d="M64 64C28.7 64 0 92.7 0 128V384c0 35.3 28.7 64 64 64H512c35.3 0 64-28.7 64-64V128c0-35.3-28.7-64-64-64H64zm64 320H64V320c35.3 0 64 28.7 64 64zM64 192V128h64c0 35.3-28.7 64-64 64zM448 384c0-35.3 28.7-64 64-64v64H448zm64-192c-35.3 0-64-28.7-64-64h64v64zM176 256a112 112 0 1 1 224 0 112 112 0 1 1 -224 0zm76-48c0 9.7 6.9 17.7 16 19.6V276h-4c-11 0-20 9-20 20s9 20 20 20h24 24c11 0 20-9 20-20s-9-20-20-20h-4V208c0-11-9-20-20-20H272c-11 0-20 9-20 20z"/></svg> </a>
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
            $.ajax({
                type: "POST",
                url: "Controlador?menu=NuevaVenta&accion=LimpiarLista",
                success: function (response) {
                    // Actualizar la vista o realizar otras acciones necesarias
                    $('#tablaProductos tbody').empty();
                    $('input[name="txtTotal"]').val('$0.00');
                    console.log("Cancelar y limpiar la tabla");
                },
                error: function (xhr, status, error) {
                    // Manejar errores si es necesario
                    console.error("Error en la solicitud AJAX:", status, error);
                }
            });

            return false;
        });
    });
</script>




    </body>
</html>
