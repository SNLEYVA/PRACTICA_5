
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>LOGGIN</h1>
        <form action="LoginController" method="POST">
            Usuario: <input type="text" name="usuario" />
            <br>
            Clave: <input type="text" name="clave" />
            <br>
            <input type="submit" name="btn-login" value="Ingresar" />
        </form>
    </body>
</html>
