<%-- 
    Document   : index
    Created on : 24/06/2020, 12:47:45 PM
    Author     : xdook
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>MiniProyecto2.0</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    </head>
    <body>
        <div class="container">
            <div class="row align-items-center h-100 justify-content-center text-center mt-4">
                <div class="col-4">
                    <div class="card mt-4">
                        <div class="card-body">
                            <h4 class="card-title">Iniciar sesión</h4>
                            <form class="row" action="Controlador" method="POST">
                                <div class="col-12">
                                    <div class="form-group">
                                      <label for="">Usuario</label>
                                      <input type="text" name="user" id="user" class="form-control" required>
                                    </div>
                                </div>
                                <div class="col-12">
                                      <label for="">Contraseña</label>
                                      <input type="password" name="pass" id="pass" class="form-control" required>
                                </div>
                                <input type="hidden" name="accion" value="login">
                            <div class="col-12 my-3">
                                <% 
                                   if(request.getParameter("status") == "failed") {
                                       out.print("<small> Usuario o contraseña erroneos</small>");
                                   } 
                                %>
                                <button type="submit" class="btn btn-dark btn-block">Entrar</button>
                            </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
