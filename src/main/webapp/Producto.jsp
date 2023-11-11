<%-- 
    Document   : Producto
    Created on : 20/10/2023, 01:13:13
    Author     : JTC
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="d-flex">
            <div class="card col-sm-3">
                <div class="card-body">
                    <form action="Controlador?menu=Producto" method="POST">
                        <div class="form-goup">
                            <label>Codigo</label>
                            <input type="text" value="${producto.getCodigo()}" name="txtcod" class="form-control">
                        </div>
                        <div class="form-goup">
                            <label>Nombre</label>
                            <input type="text" value="${producto.getNombre()}" name="txtnom" class="form-control">
                        </div>
                        <div class="form-goup">
                            <label>Precio</label>
                            <input type="text" value="${producto.getPrecio()}" name="txtpre" class="form-control">
                        </div>
                        <div class="form-goup">
                            <label>Cantidad</label>
                            <input type="text" value="${producto.getCantidad()}" name="txtcan" class="form-control">
                        </div>
                        <br>
                        <input type="submit" name="accion" value="Agregar" class="btn btn-info">
                        <input type="submit" name="accion" value="Actualizar" class="btn btn-success">
                    </form>
                </div> 
            </div>
            <div class="col-sm-9">
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>CODIGO</th>
                        <th>NOMBRE</th>
                        <th>PRECIO</th>
                        <th>CANTIDAD</th>
                        <<th>FECHA</th>
                        <<th>ACCIONES</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="prod" items="${productos}">
                     <tr>
                        <td>${prod.getCodigo()}</td>
                        <td>${prod.getNombre()}</td>
                        <td>${prod.getPrecio()}</td>
                        <td>${prod.getCantidad()}</td>
                        <td>${prod.getFehca()}</td>
                        <td>
                            <a class="btn btn-warning" href="Controlador?menu=Producto&accion=Editar&id=${prod.getCodigo()}">Editar</a>
                            <a class="btn btn-danger" href="Controlador?menu=Producto&accion=Eliminar&id=${prod.getCodigo()}">Eliminar</a>
                        </td>
                    </tr>   
                    </c:forEach>
                    
                </tbody>     
            </table>
            </div>
        </div>
        
        <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
    </body>
</html>
