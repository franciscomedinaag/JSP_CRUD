<%-- 
    Document   : listar
    Created on : 24/06/2020, 12:50:07 PM
    Author     : xdook
--%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="modelo.Usuario"%>
<%@page import="modeloDAO.UsuarioDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listar</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    </head>
    <body style="background-color: #cccccc">
        <nav class="navbar navbar-expand-lg navbar-dark bg-primary">
            <a class="navbar-brand" href="#">MiniProyecto 2.0</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="Controlador?accion=listarUsuarios">Usuarios</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="Controlador?accion=listarSucursales">Sucursales</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Zapatos</a>
                    </li> 
                </ul>
             </div>
        </nav>
        <div style="background-color: white; min-height: 100vh;" class="container">
            
            <a class="btn btn-primary mb-3 mr-5 mt-3" style="float:right; width: 300px" href="Controlador?accion=goToAdd">Agregar Nuevo</a> 
             <!--  va a doGet de controlador Y te lleva al formulario -->
            <table class="table table-hover">
                <thead class="thead-dark">
                    <tr>
                        <th style="text-align:center;">ID</th>
                        <th style="text-align:center;">Nombre</th>
                        <th style="text-align:center;">Email</th>
                        <th style="text-align:center;">Acciones</th>
                    </tr>
                </thead>
                <%
                    UsuarioDAO dao=new UsuarioDAO();
                    List<Usuario>list=dao.listar();
                    Iterator<Usuario>iter=list.iterator();
                    Usuario user=null;
                    while(iter.hasNext()){
                        user=iter.next();
                    
                %>
                <tbody>
                    <tr> 
                        <td style="text-align:center;"><%=user.getId()%></td>
                        <td style="text-align:center;"><%=user.getUsername()%></td>
                        <td style="text-align:center;"><%=user.getEmail()%></td>
                        <td style="text-align:center;">
                            <a class="btn btn-danger" href="Controlador?accion=goToEdit&id=<%=user.getId()%>">Editar</a>
                            <a class="btn btn-secondary" href="Controlador?accion=deleteUser&id=<%=user.getId()%>">Borrar</a>
                        </td>
                    </tr>
                    <%}%>
                </tbody>
            </table>

        </div>
    </body>
</html>
