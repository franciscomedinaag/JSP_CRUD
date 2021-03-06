/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Sucursal;
import modelo.Usuario;
import modelo.Zapato;
import modeloDAO.UsuarioDAO;

/**
 *
 * @author xdook
 */
@WebServlet(name = "Controlador", urlPatterns = {"/Controlador"})
public class Controlador extends HttpServlet {

    String listarUsuario="Vistas/listar.jsp";
    String addUsuario="Vistas/agregar.jsp";
    String editUsuario="Vistas/editar.jsp";
    Usuario u= new Usuario();
    UsuarioDAO dao=new UsuarioDAO();
    
    String listarSucursal="Vistas/listar_suc.jsp";
    String addSucursal="Vistas/agregar_suc.jsp";
    String editSucursal="Vistas/editar_suc.jsp";
    Sucursal s=new Sucursal();
    
    String listarZapatos="Vistas/listar_zap.jsp";
    String addZapato="Vistas/agregar_zap.jsp";
    String editZapato="Vistas/editar_zap.jsp";
    Zapato z = new Zapato();
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Controlador</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Controlador at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        //processRequest(request, response);
        String acceso="";
        String action=request.getParameter("accion");
        
        
        if(action.equalsIgnoreCase("listarUsuarios")){
            acceso=listarUsuario;
        }       
        else if(action.equalsIgnoreCase("goToAdd")){
            acceso=addUsuario;
        }
        else if(action.equalsIgnoreCase("AgregarUsuario")){
            String username=request.getParameter("txtUsername");
            String email=request.getParameter("txtEmail");
            String password=request.getParameter("txtPassword");
            u.setUsername(username);
            u.setEmail(email);
            u.setPassword(password);
            dao.add(u);
            acceso=listarUsuario;
        }   
        else if(action.equalsIgnoreCase("goToEdit")){
            request.setAttribute("idUser",request.getParameter("id"));
            acceso=editUsuario;
        }
        else if(action.equalsIgnoreCase("ActualizarUsuario")){
            int id=Integer.parseInt(request.getParameter("txtId"));
            String username=request.getParameter("txtUsername");
            String email=request.getParameter("txtEmail");
            String password=request.getParameter("txtPassword");
            u.setId(id);
            u.setUsername(username);
            u.setEmail(email);
            u.setPassword(password);
            dao.edit(u);
            acceso=listarUsuario;
        }   
        else if(action.equalsIgnoreCase("deleteUser")){
            int id=Integer.parseInt(request.getParameter("id"));
            u.setId(id);
            dao.delete(id);
            acceso=listarUsuario;
        }
        
        
        else if(action.equalsIgnoreCase("listarSucursales")){
            acceso=listarSucursal;
        }
        else if(action.equalsIgnoreCase("goToAddSucursal")){
            acceso=addSucursal;
        }
        else if(action.equalsIgnoreCase("AgregarSucursal")){
            String nombre=request.getParameter("txtNombre");
            String domicilio=request.getParameter("txtDomicilio");
            String usuario=request.getParameter("txtUsuario");
            s.setNombre(nombre);
            s.setDomicilio(domicilio);
            s.setUsuario(usuario);
            dao.addSucursal(s);
            acceso=listarSucursal;
        }  
        else if(action.equalsIgnoreCase("goToEditSucursal")){
            request.setAttribute("idSucursal",request.getParameter("id"));
            acceso=editSucursal;
        }
        else if(action.equalsIgnoreCase("ActualizarSucursal")){
            int id=Integer.parseInt(request.getParameter("txtId"));
            String nombre=request.getParameter("txtNombre");
            String domicilio=request.getParameter("txtDomicilio");
            String usuario=request.getParameter("txtUsuario");
            s.setId(id);
            s.setNombre(nombre);
            s.setDomicilio(domicilio);
            s.setUsuario(usuario);
            dao.editSucursal(s);
            acceso=listarSucursal;
        } 
        else if(action.equalsIgnoreCase("deleteSucursal")){
            int id=Integer.parseInt(request.getParameter("id"));
            s.setId(id);
            dao.deleteSucursal(id);
            acceso=listarSucursal;
        }
        else if (action.equalsIgnoreCase("AgregarZapato")){
            String modelo=request.getParameter("txtModelo");
            int talla =Integer.parseInt(request.getParameter("numTalla"));
            int precio =Integer.parseInt(request.getParameter("numPrecio"));
            String sucursal=request.getParameter("txtSucursal");
            
            z.setModelo(modelo);
            z.setTalla(talla);
            z.setPrecio(precio);
            z.setSucursal(sucursal);
            dao.addZapato(z);
            acceso=listarZapatos;
        }
        else if(action.equalsIgnoreCase("listarZapatos")){
            acceso=listarZapatos;
        } 
        else if( action.equalsIgnoreCase("goToEditZapato")){
            request.setAttribute("idZapato",request.getParameter("id"));
            acceso=editZapato;
        }
        else if(action.equalsIgnoreCase("deleteZapato")){
            int id=Integer.parseInt(request.getParameter("id"));
            z.setId(id);
            dao.deleteZapato(id);
            acceso=listarZapatos;
        }
        else if(action.equalsIgnoreCase("ActualizarZapato")){
            int id=Integer.parseInt(request.getParameter("txtId"));
            String modelo=request.getParameter("txtModelo");
            int talla=Integer.parseInt(request.getParameter("numTalla"));
            int precio=Integer.parseInt(request.getParameter("numPrecio"));
            String sucursal=request.getParameter("txtSucursal");
            z.setId(id);
            z.setModelo(modelo);
            z.setTalla(talla);
            z.setPrecio(precio);
            z.setSucursal(sucursal);
            dao.editZapato(z);
            acceso=listarZapatos;
        } else if(action.equalsIgnoreCase("goToAddZapato")){
            acceso=addZapato;
        }
        
        RequestDispatcher vista=request.getRequestDispatcher(acceso);//ir a la url de acceso
        vista.forward(request, response);
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

        String action=request.getParameter("accion");
        if(action.equalsIgnoreCase("login")){
            String user = request.getParameter("user");
            String pass = request.getParameter("pass");
            if (this.dao.login(user, pass)) {
                System.out.println("Entramos");
                RequestDispatcher vista=request.getRequestDispatcher(listarUsuario);
                vista.forward(request, response);
            } else {
                response.sendRedirect("index.jsp?status=failed");
            }
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
