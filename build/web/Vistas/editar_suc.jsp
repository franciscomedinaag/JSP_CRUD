<%-- 
    Document   : editar
    Created on : 24/06/2020, 12:50:38 PM
    Author     : xdook
--%>

<%@page import="modelo.Sucursal"%>
<%@page import="modelo.Usuario"%>
<%@page import="modeloDAO.UsuarioDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Sucursal</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-dark bg-primary">
            <a class="navbar-brand" href="#">MiniProyecto 2.0</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="./Controlador?accion=listarUsuarios">Usuarios</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="./Controlador?accion=listarSucursales">Sucursales</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="./Controlador?accion=listarZapatos">Zapatos</a>
                    </li> 
                </ul>
             </div>
        </nav>
        
        <div class="container text-center">    
            <%
             UsuarioDAO  dao=new UsuarioDAO();
             int id=Integer.parseInt((String)request.getAttribute("idSucursal"));
             Sucursal s=(Sucursal)dao.listSucursal(id);
            %>
        <h2 class="mt-4 mb-4">Editar sucursal</h2>
        <form action="Controlador">
            <!-- formulario va a doGet de controlador, y controlador manda a llamar add en UsuarioDAO para que haga la consulta -->
            Nombre de la sucursal:<br>
            <input class="form-group" type="text" name="txtNombre" value="<%= s.getNombre()%>"><br>
            Domicilio:<br>
            <input class="form-group" type="text" name="txtDomicilio" value="<%= s.getDomicilio()%>"><br>
            Encargado:<br>
            <input class="form-group" type="text" name="txtUsuario" value="<%= s.getUsuario()%>"><br>
            
            <input type="hidden" name="txtId" value="<%=s.getId()%>">
            
            <input class="btn btn-primary my-3" type="submit" name="accion" value="ActualizarSucursal"><br>
            <a href="Controlador?accion=listarSucursales">Regresar</a>
        </form>
        </div>
    </body>
</html>
