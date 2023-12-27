<%-- 
    Document   : Registrar Venta
    Created on : 18/12/2023, 05:07:27 PM
    Author     : Espinosa Beltran
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
				<input type="text" name="codigoproducto" value="${producto.getId()}" class="form-control" placeholder="Producto">
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
			    <input type="text" name="NroSerie" class="form-control">
			</div>
			<table class="table table-hover">
			    <thead>
				<tr>
				    <th>Nro</th>
				    <th>Código</th>
				    <th>Descripción</th>
				    <th>Precio</th>
				    <th>Cantidad</th>
				    <th>SubTotal</th>
				    <th>Acciones</th>
				</tr>
			    </thead>
			    <tbody>
				<tr>
				    <td></td>
				    <td></td>
				    <td></td>
				    <td></td>
				    <td></td>
				    <td></td>
				    <td></td>
				</tr>
			    </tbody>
			</table>
	    </div>
		    <div class="card-footer">
			<div>
			    <input type="submit" name="accion" value="Generar Venta" class="btn btn-success">
			    <input type="submit" name="accion" value="Cancelar" class="btn btn-danger">
			</div>
		    </div>
	</div>
	    </div>
	</div>
    </body>
</html>
