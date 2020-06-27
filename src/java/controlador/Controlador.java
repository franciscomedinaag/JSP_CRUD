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
import modelo.Usuario;
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
    UsuarioDAO userDAO=new UsuarioDAO();
    
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
            userDAO.add(u);
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
            userDAO.edit(u);
            acceso=listarUsuario;
        }
        
        
        else if(action.equalsIgnoreCase("deleteUser")){
            int id=Integer.parseInt(request.getParameter("id"));
            u.setId(id);
            userDAO.delete(id);
            acceso=listarUsuario;
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
            if (this.userDAO.login(user, pass)) {
                System.out.println("Entramos");
                response.sendRedirect(listarUsuario);
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
