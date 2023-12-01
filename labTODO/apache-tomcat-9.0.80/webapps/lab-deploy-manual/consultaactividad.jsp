<%@page import="java.util.List"%>
<%@page import="logica.Categoria"%>
<%@page import="datatypes.DataActividad"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.time.LocalDate"%>
<%@page import="controladores.ISistema"%>
<%@page import="controladores.Fabrica"%>
<%@page import="datatypes.DataUsuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="Components/header.jsp"%>
<%@include file="Components/bodyPrincipal.jsp"%>
<%
    String nombreActividad = (String) request.getParameter("actNombre");
    DataActividad act = null;
    try {
        act = sys.infoActividad(nombreActividad);
    } catch (Exception e) {}
    LocalDate fecha = act.getFechaAlta();
    

%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Actividad <%= nombreActividad %></title>
</head>
<body>
<h3>Actividad: <%= nombreActividad %></h3>
<br>
<% if (act.getImagen() != null) { %>
    <img class="imgPerfil" src="<%= act.getImagen() %>"/>
<% } %>
<p>Departamento: <%= (act.getDepartamento()) %></p>
<p>Ciudad: <%= act.getCiudad()%></p>
<p>Nombre: <%= act.getNombre() %></p>
<p>Descripcion: <%= act.getDescripcion() %></p>
<p>Duracion: <%= act.getDuracionHoras() %></p>
<p>Costo por Turista: <%= act.getCostoPorTurista() %></p>
<p>Fecha de Alta: <%= act.getFechaAlta() %></p>
<br>
<h4>Categorias:</h4>
<ol>
<%
List<String> cat = sys.getAllCatsdeActFromBD(nombreActividad);
            for (String categoria : cat) {
                %>
                <li><%= categoria %></li>
                <%
            }
%>
</ol> 
<h4>Paquetes:</h4>    
<ol>
<%
List<String> paqs = sys.getAllPaqsdeActFromBD(nombreActividad);
            for (String paquetes : paqs) {
                %>
                <li><%= paquetes %></li><a href="paquetes?nombrePaq=<%= paquetes %>">+Info</a>
                <%
            }
%>
</ol>
<h4>Salidas:</h4>    
<ol>
<%
List<String> sal = sys.getAllSaldeActFromBD(nombreActividad);
            for (String salidas : sal) {
                %>
                <li><%= salidas %></li><a href="salida?nombre=<%= salidas %>">+Info</a>
                <%
            }
%>
</ol>       
</body>
</html>
<%@include file="Components/bodyFinal.jsp"%>
