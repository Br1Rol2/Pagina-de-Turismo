<%@page import="logica.EstadoActividad"%>
<%@page import="logica.Departamento"%>
<%@page import="logica.Categoria"%>
<%@page import="java.util.List"%>
<%@page import="logica.ActividadTuristica"%>
<%@page import="controladores.ISistema"%>
<%@page import="controladores.Fabrica"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="Components/header.jsp"%>
<%@include file="Components/bodyPrincipal.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Actividades</title>
</head>
<body>
<form>
    <h1>Actividades</h1>
<h2>Elija si quiere filtrar por categoria o departamento</h2>
<label for="nombreAct" class="form-label">Categorías</label>
    <select id="categorias" name="nombreAct" class="custom-select form-control w-25">
        <%
            String nombrecat = request.getParameter("nombreAct");
            String catNombre=null;
            List<Categoria> cat = sys.getAllCatsFromBD();
            for (Categoria categoria : cat) {
                catNombre = categoria.getNombreCat();
                %>
                <option value="<%= catNombre %>"><%= catNombre %></option>
                <%
            }
        %>
    </select>
    <br>
    <button type="button" onclick="mostrarSeleccion()" class="btn btn-primary mt-3">Seleccionar</button>
    
    <br>    
    
    <label for="nombreDep" class="form-label">Departamentos</label>
    <select id="departamentos" name="nombreDep"class="custom-select form-control w-25">
        <%
            String nombredep = request.getParameter("nombreDep");
            String depNombre=null;
            List<Departamento> dep = sys.getAllDepFromBD();
            for (Departamento deptos : dep) {
                depNombre = deptos.getNombreDepartamento();
                %>
                <option value="<%= depNombre %>"><%= depNombre %></option>
                <%
            }
        %>
    </select>
    <br>
    <button type="button" onclick="mostrarSeleccionDep()" class="btn btn-primary mt-3">Seleccionar</button>
    <br>
    <br>
    <h3>Actividades:</h3>
    </form>

    <script>
        
        
        var selectedValue = "<%= nombrecat %>"; // Almacena el valor seleccionado
        var selectedValue2 = "<%= nombredep %>"; // Almacena el valor seleccionado

        function mostrarSeleccion() {
            // Obtiene el elemento select
            var select = document.getElementById("categorias");
            // Obtiene el valor seleccionado
            selectedValue = select.options[select.selectedIndex].value;

            // Redirige a la página actual con el nombre del paquete seleccionado como parámetro
            window.location.href = "actividadestur?nombreCat=" + selectedValue;
        }
        
        function mostrarSeleccionDep() {
            // Obtiene el elemento select
            var select2 = document.getElementById("departamentos");
            // Obtiene el valor seleccionado
            selectedValue2 = select2.options[select2.selectedIndex].value;

            // Redirige a la página actual con el nombre del paquete seleccionado como parámetro
            window.location.href = "actividadestur?nombreDep=" + selectedValue2;
        }
    </script>
    
    
    
    <ol>
        <%
        String aca = request.getParameter("nombreCat");
        String aca2 = request.getParameter("nombreDep"); 
       
        
        if ((aca == null || aca.isEmpty()) && (aca2==null || aca2.isEmpty())) {
            List<ActividadTuristica> act = sys.getAllActsFromBD();
            for (ActividadTuristica actividades : act) {
                String actNombre = actividades.getNombre();
                %>
                <li><%= actNombre %></li><a href="actividad?actNombre=<%= actNombre %>">+Info</a>
                <%
            }
        }
        else if(aca != null && !aca.isEmpty()){
             System.out.println(aca);
            List<String> listActsCat = sys.getAllActsdeCatFromBD(aca);
            for (String actividades : listActsCat) {
                String actNombre = actividades;
                EstadoActividad confirmada= EstadoActividad.AGREGADA;
                if(sys.selectActFromDB(actNombre)!=null){
                    confirmada= (sys.selectActFromDB(actNombre)).getEstado();
                }
                if(confirmada==EstadoActividad.CONFIRMADA){
                    %>
                    <li><%= actNombre %></li><a href="actividad?actNombre=<%= actNombre %>">+Info</a>
                    <%
                }    
            }
        }else if(aca2 != null && !aca2.isEmpty()){
            List<String> listActsDep = sys.getAllActsdeDepFromBD(aca2);
            for (String actividades : listActsDep){
                String actNombre = actividades;
                EstadoActividad confirmada= EstadoActividad.AGREGADA;
                if(sys.selectActFromDB(actNombre)!=null){
                    confirmada= (sys.selectActFromDB(actNombre)).getEstado();
                }
                if(confirmada==EstadoActividad.CONFIRMADA){
                    %>
                    <li><%= actNombre %></li><a href="actividad?actNombre=<%= actNombre %>">+Info</a>
                    <%
                }    
            }
        }

        %>
    </ol>
</form>
</body>
</html>
<%@include file="Components/bodyFinal.jsp"%>
