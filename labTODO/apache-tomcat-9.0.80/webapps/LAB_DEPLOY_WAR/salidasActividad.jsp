
<%@page import="logica.SalidasTuristicas"%>
<%@page import="logica.ActividadTuristica"%>
<%@page import="controladores.ISistema"%>
<%@page import="controladores.Fabrica"%>
<%@page import="datatypes.DataUsuario"%>
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
                SalidasTuristicas[] salidasAct = act.devolverSalidas();

                for (int i = 0; i < salidasAct.length; i++) {
                    String nombreSalida = salidasAct[i].getNombreSalida();
            %>
            <li>
                <a href="salida?nombre=<%=nombreSalida%>"><%=nombreSalida%></a> 
            </li>
            <%}%>
        </ul>




    </body>

</html>

<%@include file="Components/bodyFinal.jsp"%>
