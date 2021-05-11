<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Blog de Salud</h1>
        <p><a href="inicio?action=add">Nuevo</a></p>
        <table border="1">
            <tr>
                <th>ID</th>
                <th>FECHA</th>
                <th>TITULO</th>
                <th>CONTENIDO</th>
                <th></th>
                <th></th>
            </tr>

        
        <c:forEach var="item" items="${posts}">
        <tr>
            <td>${item.id}</td>
            <td>${item.fecha}</td>       
            <td>${item.titulo}</td>
            <td>${item.contenido}</td>
            <td><a href="inicio?action=edit&id=${item.id}">Editar</a></td>
            <td><a href="inicio?action=delete&id=${item.id}" onclick="return(confirm('Esta seguro'))">Eliminar</a></td>
        </tr>
        </c:forEach>
        </table>  
    </body>
</html>
