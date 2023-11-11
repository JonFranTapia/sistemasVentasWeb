<%-- 
    Document   : Usuario
    Created on : 20/10/2023, 01:13:45
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
            <div class="card col-sm-4">
                <div class="card-body">
                    <form action="Controlador?menu=Empleado" method="POST">
                        <div class="form-goup">
                            <label>Dpi</label>
                            <input type="text" value="${empleado.getDpi()}" name="txtdpi" class="form-control">
                        </div>
                        <div class="form-goup">
                            <label>Nombres</label>
                            <input type="text" value="${empleado.getNom()}" name="txtnom" class="form-control">
                        </div>
                        <div class="form-goup">
                            <label>Telefono</label>
                            <input type="text" value="${empleado.getTel()}" name="txttel" class="form-control">
                        </div>
                        <div class="form-goup">
                            <label>Estado</label>
                            <input type="text" value="${empleado.getEstado()}" name="txtest" class="form-control">
                        </div>
                        <div class="form-goup">
                            <label>Usuario</label>
                            <input type="text" value="${empleado.getUser()}" name="txtusr" class="form-control">
                        </div>
                        <br>
                        <input type="submit" name="accion" value="Agregar" class="btn btn-info">
                        <input type="submit" name="accion" value="Actualizar" class="btn btn-success">
                    </form>
                </div> 
            </div>
            <div class="col-sm-8">
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>DPI</th>
                        <th>NOMBRES</th>
                        <th>TELEFONO</th>
                        <th>ESTADO</th>
                        <th>USUARIO</th>
                        <th>ACCIONES</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="em" items="${empleados}">
                     <tr>
                        <td>${em.getId()}</td>
                        <td>${em.getDpi()}</td>
                        <td>${em.getNom()}</td>
                        <td>${em.getTel()}</td>
                        <td>${em.getEstado()}</td>
                        <td>${em.getUser()}</td>
                        <td>
                            <a class="btn btn-warning" href="Controlador?menu=Empleado&accion=Editar&id=${em.getId()}">Editar</a>
                            <a class="btn btn-danger" href="Controlador?menu=Empleado&accion=Eliminar&id=${em.getId()}">Eliminar</a>
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
