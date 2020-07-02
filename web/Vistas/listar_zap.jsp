<%-- 
    Document   : listar_zap
    Created on : 1/07/2020, 02:20:00 PM
    Author     : pabca
--%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="modelo.Zapato"%>
<%@page import="modeloDAO.UsuarioDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <title>Listar Zapatos</title>
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
        <div style="background-color: white; min-height: 100vh;" class="container">
            
            <a class="btn btn-primary mb-3 mr-5 mt-3" style="float:right; width: 300px" href="Controlador?accion=goToAddZapato">Agregar Zapato</a> 
             <!--  va a doGet de controlador Y te lleva al formulario -->
            <table class="table table-hover">
                <thead class="thead-dark">
                    <tr>
                        <th style="text-align:center;">ID</th>
                        <th style="text-align:center;">Modelo</th>
                        <th style="text-align:center;">Talla</th>
                        <th style="text-align:center;">Precio</th>
                        <th style="text-align:center;">Sucursal</th>
                        <th style="text-align:center;">Acciones</th>
                    </tr>
                </thead>
                <%
                    UsuarioDAO dao=new UsuarioDAO();
                    List<Zapato>list=dao.listarZapatos();
                    Iterator<Zapato>iter=list.iterator();
                    Zapato zap=null;
                    while(iter.hasNext()){
                        zap=iter.next();
                %>
                <tbody>
                    <tr> 
                        <td style="text-align:center;"><%=zap.getId()%></td>
                        <td style="text-align:center;"><%=zap.getModelo()%></td>
                        <td style="text-align:center;"><%=zap.getTalla()%></td>
                        <td style="text-align:center;"><%=zap.getPrecio()%></td>
                        <td style="text-align:center;"><%=zap.getSucursal()%></td>
                        <td style="text-align:center;">
                            <a class="btn btn-secondary" href="Controlador?accion=goToEditZapato&id=<%=zap.getId()%>">Editar</a>
                            <a class="btn btn-danger" href="Controlador?accion=deleteZapato&id=<%=zap.getId()%>">Borrar</a>
                        </td>
                    </tr>
                    <%}%>
                </tbody>
            </table>

        </div>
    </body>
</html>
