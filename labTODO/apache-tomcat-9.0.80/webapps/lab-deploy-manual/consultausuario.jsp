<%@page import="logica.EstadoActividad"%>
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
    String nickUsuario = (String) request.getParameter("nick");
    
    DataUsuario usr = null;
    try {
        usr = sys.verInfoUsuarioNick(nickUsuario);
    } catch (Exception e) {}
    LocalDate fecha = LocalDate.parse(usr.getFecNac());
    // Define un formato personalizado "dia-mes-año"
    DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    // Formatea la fecha en el formato deseado
    String fecnac = fecha.format(formato);
%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Usuario <%= nickUsuario %></title>
</head>
<body>
<% if (usr.getImagenP() != null) { %>
    <img class="imgPerfil" src="<%= usr.getImagenP() %>"/>
<% } %>
<h1><%= nickUsuario %></h1>
<p>Email: <%= usr.getCorreo() %></p>
<p>Tipo: <%= usr.getTipo() %></p>
<p>Nombre: <%= usr.getNombre() %></p>
<p>Apellido: <%= usr.getApellido() %></p>
<p>Fecha de Nacimiento: <%= fecnac %></p>
<% if (usr.getTipo().equals("Turista")) { %>
    <p>Nacionalidad: <%= usr.getNacionalidad() %></p>
<% } else if (usr.getTipo().equals("Proveedor")) { %>
    <p>Descripcion: <%= usr.getDescripcion() %></p>
    <p>Sitio web: <a href="<%= usr.GetWeb() %>" target="blank"> <%= usr.GetWeb() %></a></p>
    <p>Actividades que provee:</p>
    <ul>
    <% Proveedor p =(Proveedor ) Proveedor.obtenerUsuario(usr.getCorreo());
        Collection<ActividadTuristica> acts = p.getActTuristica();
        String estado = "";
        for(ActividadTuristica act : acts){
        if(act.getEstado() == EstadoActividad.CONFIRMADA || usr.getNick().equals(nick)){
        if(usr.getNick().equals(nick)){
        estado =" -Estado: "+ act.getEstado().toString();
        }
    %>    

    <li><%= act.getNombre()%> <%=estado%> <a href="actividad?actNombre=<%=act.getNombre()%>">-Info</a></li>
            <%} }%>
<% } %>
</ul>
</body>
</html>
<%@include file="Components/bodyFinal.jsp"%>
