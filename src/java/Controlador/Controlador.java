/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Cliente;
import Modelo.ClienteDAO;
import Modelo.Empleado;
import Modelo.EmpleadoDAO;
import Modelo.Producto;
import Modelo.ProductoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Espinosa Beltran
 */
public class Controlador extends HttpServlet {

    Empleado em=new Empleado();
    EmpleadoDAO edao= new EmpleadoDAO();
    Producto p=new Producto();
    ProductoDAO pdao= new ProductoDAO();
    Cliente c=new Cliente();
    ClienteDAO cdao= new ClienteDAO();
    int ide;
    int idp;
    int idc;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");
        
        if(menu.equals("Principal")){
            request.getRequestDispatcher("Principal.jsp").forward(request, response);
        }
        if(menu.equals("Producto")){
	switch (accion){
                case "Listar":
                    List lista=pdao.listar();
                    request.setAttribute("productos", lista);
                    break;
                case "Agregar":
                    String Nombres=request.getParameter("txtNombre");
                    String Precio=request.getParameter("txtPrecio");
                    String Stock=request.getParameter("txtStock");
                    String Estado = request.getParameter("txtEstado");
                    p.setNombres(Nombres);
                    p.setPrecio(Precio);
                    p.setStock(Stock);
                    p.setEstado(Estado);
                    pdao.agregar(p);
                    request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    idp = Integer.parseInt(request.getParameter("id"));
                    Producto pr=pdao.listarId(idp);
                    request.setAttribute("producto", pr);
                    request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    String Nombres1=request.getParameter("txtNombre");
                    String Precio1=request.getParameter("txtPrecio");
                    String Stock1=request.getParameter("txtStock");
                    String Estado1=request.getParameter("txtEstado");
                    p.setNombres(Nombres1);
                    p.setPrecio(Precio1);
                    p.setStock(Stock1);
                    p.setEstado(Estado1);
                    p.setId(idp);
                    pdao.actualizar(p);
                    request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                    break;
                case "Delete":
                    idp=Integer.parseInt(request.getParameter("id"));
                    pdao.delete(idp);
                    request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                    break;
                default:
                    throw new AssertionError();
              }
            request.getRequestDispatcher("Producto.jsp").forward(request, response);
                }
        if(menu.equals("Clientes")){
	    switch (accion){
                case "Listar":
                    List lista=cdao.listar();
                    request.setAttribute("clientes", lista);
                    break;
                case "Agregar":
                    String CC = request.getParameter("txtCC");
                    String Nombres=request.getParameter("txtNombres");
                    String Direccion=request.getParameter("txtDireccion");
                    String Estado = request.getParameter("txtEstado");
                    c.setCC(CC);
                    c.setNombres(Nombres);
                    c.setDireccion(Direccion);
                    c.setEstado(Estado);
                    cdao.agregar(c);
                    request.getRequestDispatcher("Controlador?menu=Clientes&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    idc = Integer.parseInt(request.getParameter("id"));
                    Cliente cl=cdao.listarId(idc);
                    request.setAttribute("cliente", cl);
                    request.getRequestDispatcher("Controlador?menu=Clientes&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    String CC1=request.getParameter("txtCC");
                    String Nombres1=request.getParameter("txtNombres");
                    String Direccion1=request.getParameter("txtTel");
                    String Estado1=request.getParameter("txtEstado");
                    c.setCC(CC1);
                    c.setNombres(Nombres1);
                    c.setDireccion(Direccion1);
                    c.setEstado(Estado1);
                    c.setId(idc);
                    cdao.actualizar(c);
                    request.getRequestDispatcher("Controlador?menu=Clientes&accion=Listar").forward(request, response);
                    break;
                case "Delete":
                    idc=Integer.parseInt(request.getParameter("id"));
                    cdao.delete(idc);
                    request.getRequestDispatcher("Controlador?menu=Clientes&accion=Listar").forward(request, response);
                    break;
                default:
                    throw new AssertionError();
            }
            request.getRequestDispatcher("Clientes.jsp").forward(request, response);
                }
        if(menu.equals("Empleado")){
            switch (accion){
                case "Listar":
                    List lista=edao.listar();
                    request.setAttribute("empleados", lista);
                    break;
                case "Agregar":
                    String CC=request.getParameter("txtCC");
                    String Nombres=request.getParameter("txtNombres");
                    String Telefono=request.getParameter("txtTel");
                    String Estado = request.getParameter("txtEstado");
                    String User = request.getParameter("txtUser");
                    em.setCC(CC);
                    em.setNombres(Nombres);
                    em.setTelefono(Telefono);
                    em.setEstado(Estado);
                    em.setUser(User);
                    edao.agregar(em);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    ide = Integer.parseInt(request.getParameter("id"));
                    Empleado e=edao.listarId(ide);
                    request.setAttribute("empleado", e);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                    break;
                    
                case "Actualizar":
                    String CC1=request.getParameter("txtCC");
                    String Nombres1=request.getParameter("txtNombres");
                    String Telefono1=request.getParameter("txtTel");
                    String Estado1=request.getParameter("txtEstado");
                    String User1=request.getParameter("txtUser");
                    em.setCC(CC1);
                    em.setNombres(Nombres1);
                    em.setTelefono(Telefono1);
                    em.setEstado(Estado1);
                    em.setUser(User1);
                    em.setId(ide);
                    edao.actualizar(em);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                    break;
                    
                case "Delete":
                    ide=Integer.parseInt(request.getParameter("id"));
                    edao.delete(ide);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                    break;
                default:
                    throw new AssertionError();
            }
            request.getRequestDispatcher("Empleado.jsp").forward(request, response);
                }
        if(menu.equals("NuevaVenta")){
	    switch (accion){
		case "BuscarCliente":
		    String CC = request.getParameter("codigocliente");
		    c.setCC(CC);
		    c=cdao.buscar(CC);
		    request.setAttribute("c", c);
		    break;
		    
		    case "BuscarProducto":
		    int id = Integer.parseInt(request.getParameter("codigoproducto"));
		    p = pdao.listarId(id);
		    request.setAttribute("producto", p);
		    break;
  		default:
		    break;
	    }
            request.getRequestDispatcher("RegistrarVenta.jsp").forward(request, response);
                }
	
        
        switch(accion){
            case "Principal":
                request.getRequestDispatcher("Principal.jsp").forward(request, response);
                break;
                
            case "Clientes":
                request.getRequestDispatcher("Clientes.jsp").forward(request,response);
                break;
            case "Empleado":
                request.getRequestDispatcher("Empleado.jsp").forward(request,response);
                break;
            case "NuevaVenta":
                request.getRequestDispatcher("RegistrarVenta.jsp").forward(request,response);
                break;
                
            default:
                throw new AssertionError();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
	try {
	    processRequest(request, response);
	} catch (SQLException ex) {
	    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
	}
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
	try {
	    processRequest(request, response);
	} catch (SQLException ex) {
	    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
	}
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    }


