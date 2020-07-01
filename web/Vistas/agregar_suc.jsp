<%-- 
    Document   : agregar
    Created on : 24/06/2020, 12:50:23 PM
    Author     : xdook
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agregar Sucursal</title>
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
<<<<<<< HEAD
                        <a class="nav-link" href="./Controlador?accion=listarUsuarios">Usuarios</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="./Controlador?accion=listarSucursales">Sucursales</a>
=======
                        <a class="nav-link" href="Controlador?accion=listarUsuarios">Usuarios</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="Controlador?accion=listarSucursales">Sucursales</a>
>>>>>>> 41bd2e973045653646e015d62998c3a360c0c834
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Zapatos</a>
                    </li> 
                </ul>
             </div>
        </nav>
        <div class="container text-center">
            <h2 class="mt-4 mb-4">Agregar Sucursal</h2>
            <form action="Controlador">
            <!-- formulario va a doGet de controlador, y controlador manda a llamar add en UsuarioDAO para que haga la consulta -->
            Nombre de sucursal:<br>
            <input type="text" name="txtNombre"><br>
            Domicilio:<br>
            <input type="text" name="txtDomicilio"><br>
            Encargado:<br>
            <input type="text" name="txtUsuario"><br>
            
            <input class="btn btn-primary my-3" type="submit" name="accion" value="AgregarSucursal"><br>
            <a href="Controlador?accion=listarSucursales">Regresar</a>
            </form>
        </div>
        
    </body>
</html>
