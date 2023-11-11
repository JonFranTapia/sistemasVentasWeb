<%-- 
    Document   : Clientes
    Created on : 20/10/2023, 01:13:29
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
                    <form action="Controlador?menu=Clientes" method="POST">
                        <div class="form-goup">
                            <label>Id</label>
                            <input type="text" value="${cliente.getId()}" name="txtid" class="form-control">
                        </div>
                        <div class="form-goup">
                            <label>Dpi</label>
                            <input type="text" value="${cliente.getDpi()}" name="txtdpi" class="form-control">
                        </div>
                        <div class="form-goup">
                            <label>Nombre</label>
                            <input type="text" value="${cliente.getNombre()}" name="txtnom" class="form-control">
                        </div>
                        <div class="form-goup">
                            <label>Direccion</label>
                            <input type="text" value="${cliente.getDirec()}" name="txtdir" class="form-control">
                        </div>
                        <div class="form-goup">
                            <label>Estado</label>
                            <input type="text" value="${cliente.getEstado()}" name="txtest" class="form-control">
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
                        <th>ID</th>
                        <th>DPI</th>
                        <th>NOMBRE</th>
                        <th>DIRECCION</th>
                        <th>ESTADO</th>
                        <th>ACCIONES</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="cl" items="${clientes}">
                     <tr>
                        <td>${cl.getId()}</td>
                        <td>${cl.getDpi()}</td>
                        <td>${cl.getNombre()}</td>
                        <td>${cl.getDirec()}</td>
                        <td>${cl.getEstado()}</td>
                        <td>
                            <a class="btn btn-warning" href="Controlador?menu=Clientes&accion=Editar&id=${cl.getId()}">Editar</a>
                            <a class="btn btn-danger" href="Controlador?menu=Clientes&accion=Eliminar&id=${cl.getId()}">Eliminar</a>
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
