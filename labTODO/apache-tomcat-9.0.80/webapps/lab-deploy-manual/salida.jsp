<%@page import="java.time.LocalTime"%>
<%@page import="logica.SalidasTuristicas"%>
<%@page import="logica.ActividadTuristica"%>
<%@page import="java.util.Collection"%>
<%@page import="logica.Proveedor"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.time.LocalDate"%>
<%@page import="controladores.ISistema"%>
<%@page import="controladores.Fabrica"%>
<%@page import="datatypes.DataUsuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="Components/header.jsp"%>
<%@include file="Components/bodyPrincipal.jsp"%>
<%
    String nombreS = request.getParameter("nombre");
    SalidasTuristicas salida = sys.getSalidaFromBD(nombreS);
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Salida <%= nombreS%></title>
    </head>
    <body>

        <h1><%= nombreS%></h1>

        <% if (salida != null) { %>
        <% if (salida.getImagenSalida() != null) {%>
        <img class="imgPerfil" src="<%= salida.getImagenSalida()%>"/>
        <%}%>
        <%
    DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String fecha = salida.getFechaSalida().format(formato);
        int cantInscritos = salida.getCantInscritos();
        int cantMax = salida.getCantidadMaximaTuristas();
        String lugar = salida.getLugar();
        String actividad = salida.getActividadAsociada().getNombre();
       LocalTime hora = salida.getHora();
        %>
        <ul>
            <li>Actividad: <%=actividad%></li>
            <li>Lugar: <%=lugar%></li>
            <li>Fecha: <%=fecha%></li>
            <li>Hora: <%=hora%></li>
            <li>Inscritos: <%=cantInscritos%> de <%=cantMax%></li>
        </ul>
        <%if(logged && sys.getTipo(usuarioLoggeado.getNick()).equals("turista") && salida.estaVigente()){
        System.out.println("?????");%>
        <a href="inscripcionsalida?nombre=<%=nombreS%>">Inscribirse</a>
        <%}%>
        
        
        
        
        
        
        
        <% } else { %>
        La salida especificada no fue encontrada
        <%}%>

    </body>
</html>
<%@include file="Components/bodyFinal.jsp"%>
