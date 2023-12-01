
<%@page import="java.util.List"%>
<%@page import="webservice.SalidasTuristicas"%>
<%@page import="webservice.ActividadTuristica"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="Components/header.jsp"%>
<%@include file="Components/bodyPrincipal.jsp"%>
<%
    String actividad = request.getParameter("actividad");
    if (actividad == null) {
        response.sendRedirect("salidasturisticas");
    }
    System.out.println(actividad);
    ActividadTuristica act = sys.selectActividad(actividad);
    if (act == null) {
        response.sendError(400, "Actividad inexistente papu");
    }
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Salidas de <%=actividad%></h1>
        <ul>
            <%
                
                List<String> salidasAct = sys.getAllSaldeActFromBD(act.getNombre());;

                for (String nombreSalida: salidasAct) {

            %>
            <li>
                <a href="salida?nombre=<%=nombreSalida%>"><%=nombreSalida%></a> 
            </li>
            <%}%>
        </ul>




    </body>

</html>

<%@include file="Components/bodyFinal.jsp"%>
