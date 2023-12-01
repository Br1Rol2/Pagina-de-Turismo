<%@page import="java.util.List"%>
<%@page import="logica.Paquete"%>
<%@page import="logica.SalidasTuristicas"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.time.LocalDate"%>
<%@page import="controladores.ISistema"%>
<%@page import="controladores.Fabrica"%>
<%@include file="Components/header.jsp"%>
<%@include file="Components/bodyPrincipal.jsp"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    String nombreS = request.getParameter("nombre");
    if (!(logged && sys.getTipo(usuarioLoggeado.getNick()).equals("turista"))) {
        response.sendError(401, "Debes estar logeado como turista para usar esta pagina");
        return;
    }
    if (nombreS == null) {
        response.sendRedirect("actividadestur");
        return;
    }
    SalidasTuristicas salida = sys.getSalidaFromBD(nombreS);
    if (salida == null) {
        response.sendError(404);
        return;
    }
    if (sys.estaInscritoTuristaSalida(usuarioLoggeado.getCorreo(), nombreS)) {
%>
<h1>Ya estas inscrito a esa salida</h1>
<a href="actividadestur" class="btn btn-primary mt-3">Seleccionar otra salida</a>
<%
        return;
    }
    if (salida.getCantidadMaximaTuristas() <= salida.getCantInscritos()) {

%>
<h1>Ya se alcanzó la capacidad máxima de la salida</h1>
<a href="actividadestur" class="btn btn-primary mt-3">Seleccionar otra salida</a>
<% return;
    }
    if (!salida.estaVigente()) {
%>
<h1>La salida no esta vigente</h1>
<a href="actividadestur" class="btn btn-primary mt-3">Seleccionar otra salida</a>
<% return;
    }
%>


<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Inscripcion salida</title>
</head>

<h1>Inscribirse a <%= nombreS%> </h1>
<form action="inscripcionsalida" method="post" id="formInscr">
    <input hidden name="nombreSalida" value="<%= nombreS%>">
    <input hidden name="mailTur" value="<%= usuarioLoggeado.getCorreo()%>">
    
    <input hidden name="tipoInscr" id="tipoInscr" value="">
    <input hidden name="paqueteSeleccionado" id="paqueteSeleccionado" value="">
    <input type="number" min="1" value="1" placeholder="Cantidad de turistas" name="cantidad" id="cantidad" class="form-control" >

    <select class="custom-select" name="tipoPago" id="tipoPago">
        <option value="general">General</option>
        <option value="paquete">Por paquete</option>
    </select>

    <select  class="custom-select" name="paquetes" id="paquetes">
        <option value="">Seleccione un paquete</option>
        <%
        List<String> paqs = sys.listarPaqInscritoTurContieneAct(usuarioLoggeado.getCorreo(), salida.getActividadAsociada().getNombre());
        
        for(String p: paqs){
            
        %>
        <option value="<%=p%>"><%=p%></option>
        <%}%>
    </select>
    <button>Enviar</button>
</form>

<%@include file="Components/bodyFinal.jsp"%>

<script>
    let tipoPago = document.getElementById("tipoPago");
    let paqSelect = $("#paquetes");
    paqSelect.hide();
    tipoPago.addEventListener("change",function( e ){
        $("#tipoInscr").val( tipoPago.value  );
        if(tipoPago.value ==="paquete"){
            paqSelect.show();
        }else{
            paqSelect.hide();
        }
        
    });
    
    document.getElementById("paquetes").addEventListener("change", function(e) {

        $("#paqueteSeleccionado").val(paqSelect.val());

    });
    
    document.getElementById("formInscr").addEventListener("submit", function(e) {
        if(tipoPago.value ==="paquete" && paqSelect.val() ===""){
            alert("Selecciona un paquete por favor");
            e.preventDefault();
            return;
        }
        
    });
</script>