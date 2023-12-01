<%-- 
    Document   : index
    Created on : 11 nov. 2023, 20:02:54
    Author     : samuel
--%>
<%@page import="controladores.Fabrica"%>
<%@page import="controladores.ISistema"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%ISistema sys = new Fabrica().getSistema();%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
    </body>
</html>
