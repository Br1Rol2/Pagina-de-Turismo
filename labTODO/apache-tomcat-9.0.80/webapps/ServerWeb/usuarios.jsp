
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="Components/header.jsp"%>
<%@include file="Components/bodyPrincipal.jsp"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Usuarios</title>
    </head>
    <body>
        <h1>Usuarios</h1>
        <ol>
            <%
                List <DataUsuario> usrs = sys.getUsuarios();
                int i = 0;
                for (DataUsuario usr : usrs) {
                    String nickUsr = usr.getNick();

            %>
            <li><%= nickUsr%></li><a href="usuario?nick=<%=usr.getNick() %>"> +Info</a>
                <%i++;
                    }%>


        </ol>
    </body>

</html>

<%@include file="Components/bodyFinal.jsp"%>
