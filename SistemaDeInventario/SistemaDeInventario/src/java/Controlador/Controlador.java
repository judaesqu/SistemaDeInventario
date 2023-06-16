/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Empleado;
import Modelo.EmpleadoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Espinosa Beltran
 */
public class Controlador extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    Empleado em=new Empleado();
    EmpleadoDAO edao=new EmpleadoDAO();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            String menu=request.getParameter("menu");
            String accion=request.getParameter("accion");
            if(menu.equals("Principal")){
                request.getRequestDispatcher("Principal.jsp").forward(request, response);
            }
            if(menu.equals("Empleado")){
                switch (accion){
                    case "Listar":
                        List lista=edao.listar();
                        request.setAttribute("empleados", lista);
                        break;
                    case "Agregar":
                        String Nombre_empleado = request.getParameter("txtnombre");
                        String Cargo = request.getParameter("txtcargo");
                        String Fecha_contratacion = request.getParameter("txtfecha");
                        String User = request.getParameter("txtuser");
                        String Password = request.getParameter("txtpass");
                        String Email = request.getParameter("txtemail");
                        em.setNombre_empleado(Nombre_empleado);
                        em.setCargo(Cargo);
                        em.setFecha_contratacion(Fecha_contratacion);
                        em.setUser(User);
                        em.setPassword(Password);
                        em.setEmail(Email);
                        edao.agregar(em);
                        request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                        break;
                    case "Editar":
                        break;
                    case "Delete":
                        break;
                    default:
                        throw new AssertionError();
                }
                request.getRequestDispatcher("Empleados.jsp").forward(request, response);
            }
            if(menu.equals("Clientes")){
                request.getRequestDispatcher("Clientes.jsp").forward(request, response);
                switch (accion){
                    case "Listar":
                        break;
                    case "Agregar":
                        break;
                    case "Editar":
                        break;
                    case "Delete":
                        break;
                    default:
                        throw new AssertionError();
                }
            }
            if(menu.equals("Catalogo")){
                request.getRequestDispatcher("Catalogo.jsp").forward(request, response);
            }
            if(menu.equals("Ordenes")){
                request.getRequestDispatcher("Ordenes.jsp").forward(request, response);
                switch (accion){
                    case "Listar":
                        break;
                    case "Agregar":
                        break;
                    case "Editar":
                        break;
                    case "Delete":
                        break;
                    default:
                        throw new AssertionError();
                }
            }
            if(menu.equals("Productos")){
                request.getRequestDispatcher("Productos.jsp").forward(request, response);
                switch (accion){
                    case "Listar":
                        break;
                    case "Agregar":
                        break;
                    case "Editar":
                        break;
                    case "Delete":
                        break;
                    default:
                        throw new AssertionError();
                }
            }
            if(menu.equals("Transacciones")){
                request.getRequestDispatcher("Transacciones.jsp").forward(request, response);
                switch (accion){
                    case "Listar":
                        break;
                    case "Agregar":
                        break;
                    case "Editar":
                        break;
                    case "Delete":
                        break;
                    default:
                        throw new AssertionError();
                }
            }
            if(menu.equals("Proveedores")){
                request.getRequestDispatcher("Proveedores.jsp").forward(request, response);
                switch (accion){
                    case "Listar":
                        break;
                    case "Agregar":
                        break;
                    case "Editar":
                        break;
                    case "Delete":
                        break;
                    default:
                        throw new AssertionError();
                }
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
        processRequest(request, response);
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
        processRequest(request, response);
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
