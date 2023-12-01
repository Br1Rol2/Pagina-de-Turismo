<%@page import="webservice.EstadoActividad"%>
<%@page import="webservice.Departamento"%>
<%@page import="webservice.Categoria"%>
<%@page import="java.util.List"%>
<%@page import="webservice.ActividadTuristica"%>

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
                    
                    String buscoCat = request.getParameter("nombreCat");
                    
                    String catNombre = null;
                    List<Categoria> cat = sys.getAllCatsFromBD();
                    for (Categoria categoria : cat) {
                    
                        catNombre = categoria.getNombreCat();
                %>
                <option value="<%= catNombre%>"<%if(catNombre.equals(buscoCat)){%> selected <%}%>><%= catNombre%></option>
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
                    String depNombre = null;
                    List<Departamento> dep = sys.getAllDepFromBD();
                    for (Departamento deptos : dep) {
                        depNombre = deptos.getNombreDepartamento();
                %>
                <option value="<%= depNombre%>"<%if(depNombre.equals(nombredep)){%> selected <%}%>><%= depNombre%></option>
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


            var selectedValue = "<%= nombrecat%>"; // Almacena el valor seleccionado
            var selectedValue2 = "<%= nombredep%>"; // Almacena el valor seleccionado

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
                List<String> actsFav = null;
                if (logged && sys.getTipo(usuarioLoggeado.getNick()).equals("turista")) {
                    actsFav = sys.getActsFavoritasUsr(usuarioLoggeado.getCorreo());
                }

                if ((aca == null || aca.isEmpty()) && (aca2 == null || aca2.isEmpty())) {
                    List<ActividadTuristica> act = sys.getAllActsFromBD();
                    for (ActividadTuristica actividades : act) {
                        String actNombre = actividades.getNombre();


            %>

            <li><%= actNombre%></li><a href="actividad?actNombre=<%= actNombre%>">+Info</a>
                <%if (logged && sys.getTipo(usuarioLoggeado.getNick()).equals("turista")) {
                        boolean esFavorita = actsFav.contains(actNombre);

                        String clase = "fas fa-regular fa-heart";
                        String color = "";
                        if (esFavorita) {
                            clase = "fas fa-solid fa-heart";
                            color = "style=\"color: #e01b24;\"";
                        }

                %>
            <button onclick="toggleFav('<%=actNombre%>',<%=esFavorita%>)" id="toggleFav-<%=actNombre%>"><i class="<%= clase%>" <%=color%>></i></button>
                <%}%>
                <%
                    }
                } else if (aca != null && !aca.isEmpty()) {
                    System.out.println(aca);
                    List<String> listActsCat = sys.getAllActsdeCatFromBD(aca);
                    for (String actividades : listActsCat) {
                        String actNombre = actividades;
                        EstadoActividad confirmada = EstadoActividad.AGREGADA;
                        if (sys.selectActFromDB(actNombre) != null) {
                            confirmada = (sys.selectActFromDB(actNombre)).getEstado();
                        }
                        if (confirmada == EstadoActividad.CONFIRMADA) {
                %>
            <li><%= actNombre%></li><a href="actividad?actNombre=<%= actNombre%>">+Info</a>
                <%if (logged && sys.getTipo(usuarioLoggeado.getNick()).equals("turista")) {
                        boolean esFavorita = actsFav.contains(actNombre);

                        String clase = "fas fa-regular fa-heart";
                        String color = "";
                        if (esFavorita) {
                            clase = "fas fa-solid fa-heart";
                            color = "style=\"color: #e01b24;\"";
                        }

                %>
            <button onclick="toggleFav('<%=actNombre%>',<%=esFavorita%>)" id="toggleFav-<%=actNombre%>"><i class="<%= clase%>" <%=color%>></i></button>
                <%}%>
                <%
                        }
                    }
                } else if (aca2 != null && !aca2.isEmpty()) {
                    List<String> listActsDep = sys.getAllActsdeDepFromBD(aca2);
                    for (String actividades : listActsDep) {
                        String actNombre = actividades;
                        EstadoActividad confirmada = EstadoActividad.AGREGADA;
                        if (sys.selectActFromDB(actNombre) != null) {
                            confirmada = (sys.selectActFromDB(actNombre)).getEstado();
                        }
                        if (confirmada == EstadoActividad.CONFIRMADA) {
                %>
            <li><%= actNombre%></li><a href="actividad?actNombre=<%= actNombre%>">+Info</a>

            <%if (logged && sys.getTipo(usuarioLoggeado.getNick()).equals("turista")) {
                    boolean esFavorita = actsFav.contains(actNombre);

                    String clase = "fas fa-regular fa-heart";
                    String color = "";
                    if (esFavorita) {
                        clase = "fas fa-solid fa-heart";
                        color = "style=\"color: #e01b24;\"";
                    }

            %>
            <button onclick="toggleFav('<%=actNombre%>',<%=esFavorita%>)" id="toggleFav-<%=actNombre%>" ><i class="<%= clase%>" <%=color%>></i></button>
                <%}%>
                <%
                            }
                        }
                    }

                %>
        </ol>
    </form>
    <script>

        function toggleFav(nombreAct, favorito) {
            // Supongamos que favorito es un booleano que indica si la actividad es favorita o no.
            //var favorito = true; // Cambiar según el estado actual.

            // Cambiar el estado de favorito.
            favorito = !favorito;
            favorito = document.getElementById("toggleFav-" + nombreAct).innerHTML === '<i class="fas fa-regular fa-heart"></i>';
            // Crear un objeto de datos para enviar al servidor.
            var data = {
                nombreAct: nombreAct,
                favorito: favorito
            };

            // Enviar la solicitud AJAX.
            $.ajax({
                type: "POST", // Puedes utilizar "GET" o "POST" según la configuración de tu servlet.
                url: "SvCambiarActFavorita", // Reemplaza con la URL de tu servlet.
                data: data,
                success: function (response) {
                    // Maneja la respuesta del servidor si es necesario.
                    console.log(response);
                },
                error: function (xhr, status, error) {
                    // Maneja errores si es necesario.
                    console.error(error);
                }
            });
            if (favorito) {
                document.getElementById("toggleFav-" + nombreAct).innerHTML = '<i class="fas fa-solid fa-heart" style="color: #e01b24;"></i>';
            } else {
                document.getElementById("toggleFav-" + nombreAct).innerHTML = '<i class="fas fa-regular fa-heart"></i>';

            }

        }


    </script>
</body>
</html>
<%@include file="Components/bodyFinal.jsp"%>
