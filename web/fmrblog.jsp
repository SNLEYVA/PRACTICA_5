<%-- 
    Document   : fmrblog
    Created on : 10-may-2021, 16:28:51
    Author     : Intel i5
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       <h1>
            <c:if test="${posts.id==0}">Nuevo</c:if>
            <c:if test="${posts.id!=0}">Editar</c:if>
            posts
        </h1>
            
            <form action="inicio" method="POST">
                <input type="hidden" name="id" value="${posts.id}" />
            <table border="1">
                <tr>
                    <td>FECHA:</td>
                    <td><input type="date" name="fecha" value="${posts.fecha}" /></td>
                </tr>
                <tr>
                    <td>TITULO:</td>
                    <td><input type="text" name="titulo" value="${posts.titulo}" /></td>
                </tr>
                <tr>
                    <td>CONTENIDO:</td>
                    <td><textarea name="contenido" rows="4" cols="20">${posts.contenido}</textarea></td>
                </tr>  
                
                <tr>
                    <td></td>
                    <td><input type="submit" value="Guardar" /></td>
                </tr>                
            </table>

            
            
            </form>
    </body>
</html>
