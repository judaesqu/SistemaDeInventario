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
import Modelo.Proveedor;
import Modelo.ProveedorDAO;
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
    Cliente c =new Cliente();
    ClienteDAO cdao=new ClienteDAO();
    Proveedor pr = new Proveedor();
    ProveedorDAO pdao=new ProveedorDAO();
    int ide;
    int idc;
    int idp;
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
                        ide=Integer.parseInt(request.getParameter("id"));
                        Empleado e=edao.listarId(ide);
                        request.setAttribute("empleado", e);
                        request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                        break;
                    case "Actualizar":
                        String Nombre_empleado1 = request.getParameter("txtnombre");
                        String Cargo1 = request.getParameter("txtcargo");
                        String Fecha_contratacion1 = request.getParameter("txtfecha");
                        String User1 = request.getParameter("txtuser");
                        String Password1 = request.getParameter("txtpass");
                        String Email1 = request.getParameter("txtemail");
                        em.setNombre_empleado(Nombre_empleado1);
                        em.setCargo(Cargo1);
                        em.setFecha_contratacion(Fecha_contratacion1);
                        em.setUser(User1);
                        em.setPassword(Password1);
                        em.setEmail(Email1);
                        em.setID_empleado(ide);
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
                request.getRequestDispatcher("Empleados.jsp").forward(request, response);
            }
            if(menu.equals("Cliente")){
                switch (accion){
                    case "Listar":
                        List lista=cdao.listar();
                        request.setAttribute("clientes", lista);
                        break;
                    case "Agregar":
                        String Nombre_cliente = request.getParameter("txtnombre");
                        String Direccion = request.getParameter("txtdireccion");
                        String Telefono = request.getParameter("txttelefono");
                        String Correo_electronico = request.getParameter("txtemail");
                        c.setNombre_cliente(Nombre_cliente);
                        c.setDireccion(Direccion);
                        c.setTelefono(Telefono);
                        c.setCorreo_electronico(Correo_electronico);
                        cdao.agregar(c);
                        request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request, response);
                        break;
                    case "Editar":
                        idc=Integer.parseInt(request.getParameter("id"));
                        Cliente cl=cdao.listarId(idc);
                        request.setAttribute("cliente", cl);
                        request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request, response);
                        break;
                    case "Actualizar":
                        String Nombre_cliente1 = request.getParameter("txtnombre");
                        String Direccion1 = request.getParameter("txtdireccion");
                        String Telefono1 = request.getParameter("txttelefono");
                        String Correo_electronico1 = request.getParameter("txtemail");
                        c.setNombre_cliente(Nombre_cliente1);
                        c.setDireccion(Direccion1);
                        c.setTelefono(Telefono1);
                        c.setCorreo_electronico(Correo_electronico1);
                        c.setID_cliente(idc);
                        cdao.actualizar(c);
                        request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request, response);
                        break;
                    case "Delete":
                        idc=Integer.parseInt(request.getParameter("id"));
                        cdao.delete(idc);
                        request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request, response);
                        break;
                    default:
                        throw new AssertionError();
                }
                request.getRequestDispatcher("Clientes.jsp").forward(request, response);
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
            if(menu.equals("Proveedor")){
                switch (accion){
                    case "Listar":
                        List lista=pdao.listar();
                        request.setAttribute("proveedores", lista);
                        break;
                    case "Agregar":
                        String Nombre_proveedor = request.getParameter("txtnombre");
                        String NIT = request.getParameter("txtnit");
                        String Direccion = request.getParameter("txtdireccion");
                        String Nombre_contacto = request.getParameter("txtcontacto");
                        String Telefono = request.getParameter ("txttelefono");
                        String Correo_electronico = request.getParameter ("txtemail");
                        String Forma_de_pago = request.getParameter ("txtforma");
                        String Medio_de_pago = request.getParameter ("txtmedio");
                        String Numero_de_cuenta = request.getParameter ("txtcuenta");
                        String Banco = request.getParameter ("txtbanco");
                        String Plazo_pago = request.getParameter ("txtplazo");
                        pr.setNombre_proveedor(Nombre_proveedor);
                        pr.setNIT(NIT);
                        pr.setDireccion(Direccion);
                        pr.setNombre_contacto(Nombre_contacto);
                        pr.setTelefono(Telefono);
                        pr.setCorreo_electronico(Correo_electronico);
                        pr.setForma_de_pago(Forma_de_pago);
                        pr.setMedio_de_pago(Medio_de_pago);
                        pr.setNumero_de_cuenta(Numero_de_cuenta);
                        pr.setBanco(Banco);
                        pr.setPlazo_pago(Plazo_pago);
                        pdao.agregar(pr);
                        request.getRequestDispatcher("Controlador?menu=Proveedor&accion=Listar").forward(request, response);
                        break;
                    case "Editar":
                        idp=Integer.parseInt(request.getParameter("id"));
                        Proveedor pro=pdao.listarId(idp);
                        request.setAttribute("proveedor", pro);
                        request.getRequestDispatcher("Controlador?menu=Proveedor&accion=Listar").forward(request, response);
                        break;
                    case "Delete":
                        idp=Integer.parseInt(request.getParameter("id"));
                        pdao.delete(idp);
                        request.getRequestDispatcher("Controlador?menu=Proveedor&accion=Listar").forward(request, response);
                        break;
                    default:
                        throw new AssertionError();
                }
                request.getRequestDispatcher("Proveedores.jsp").forward(request, response);
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
