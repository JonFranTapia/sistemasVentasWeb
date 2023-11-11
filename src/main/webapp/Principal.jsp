<%-- 
    Document   : Principal
    Created on : 19/10/2023, 18:48:10
    Author     : JTC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
       <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

        <title>JSP Page</title>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg bg-info ">
        
            <div class="collapse navbar-collapse" id="navbarNav">
              <ul class="navbar-nav">
                <li class="nav-item">
                  <a style="margin-left: 10px; border: none"class="btn btn-outline-light" href="#">Home</a>
                </li>
                <li class="nav-item">
                  <a style="margin-left: 10px; border: none"class="btn btn-outline-light" href="Controlador?menu=Producto&accion=Listar"target="myFrame">Producto</a>
                </li>
                <li class="nav-item">
                  <a style="margin-left: 10px; border: none"class="btn btn-outline-light" href="Controlador?menu=Empleado&accion=Listar"target="myFrame">Empleado</a>
                </li>
                <li class="nav-item">
                  <a style="margin-left: 10px; border: none"class="btn btn-outline-light" href="Controlador?menu=Clientes&accion=Listar"target="myFrame">Clientes</a>
                </li>
                <li class="nav-item">
                  <a style="margin-left: 10px; border: none"class="btn btn-outline-light" href="Controlador?menu=NuevaVenta&accion=default"target="myFrame">Nueva Venta</a>
                </li>
              </ul> 
            </div>    
           <div class="dropdown">
                <button style="border: none"class="btn btn-outline-light dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                  ${usuario.getNom()}
                </button>
                <div class="dropdown-menu text-center" >
                    <a class="dropdown-item" href="#">
                        <img src="img/user-tag.png" alt="60"width="60"/>
                    </a>
                  <a class="dropdown-item" href="#">${usuario.getUser()}</a>
                  <a class="dropdown-item" href="#">usergmail.com</a>
                  <div class="dropdown-divider"></div>
                  <form action="Validar1" method="POST">
                      <button name="accion" value="Salir"class="dropdown-item" href="#">Salir</button>
                  </form>
                  
                  
                </div>
              </div>
               
        </nav>
        <div class="m-4" style="height: 550px">
            <iframe name="myFrame" style="height: 100%; width:100%;border:none"></iframe>              
        </div>    
        <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>

    </body>
</html>
