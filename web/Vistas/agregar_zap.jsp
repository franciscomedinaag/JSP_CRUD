<%-- 
    Document   : agregar_zap
    Created on : 1/07/2020, 01:42:19 PM
    Author     : pabca
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <title>Agregar Zapato</title>
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
            <h2 class="mt-4 mb-4">Agregar Sucursal</h2>
            <form action="Controlador" method="GET">
            <!-- formulario va a doGet de controlador, y controlador manda a llamar add en UsuarioDAO para que haga la consulta -->
            Modelo:<br>
            <input type="text" name="txtModelo"><br>
            Talla:<br>
            <input type="number" name="numTalla"><br>
            Precio:<br>
            <input type="number" name="numPrecio"><br>
            Sucursal:<br>
            <input type="text" name="txtSucursal"><br>
            
            <button class="btn btn-primary my-3" type="submit" name="accion" value="AgregarZapato">Agregar</button><br>
            <a href="Controlador?accion=listarZapatos">Regresar</a>
            </form>
        </div>
        
    </body>
</html>

