package servlets;

import controladores.Fabrica;
import controladores.ISistema;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;
import java.time.LocalTime;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import logica.RutaProyecto;
import logica.SalidasTuristicas;

/*
 * @author facu
 */
@MultipartConfig
@WebServlet(name = "SvAltaSalidaTuristica", urlPatterns = {"/SvAltaSalidaTuristica"})
public class SvAltaSalidaTuristica extends HttpServlet {

    ISistema sys = new Fabrica().getSistema();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

        request.getRequestDispatcher("/AltaSalidaTuristica.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

        String nombre = request.getParameter("nombre");
        String lugar = request.getParameter("lugar");

        String cantidadParam = request.getParameter("cantidad");
        int cantidad = 0;
        if (cantidadParam != null && !cantidadParam.isEmpty()) {
            cantidad = Integer.parseInt(cantidadParam);
        }

        String fechaSalida = request.getParameter("fechaSalida");
        String nombreActividad = request.getParameter("nombreActividad");
        String nombreDepartamento = request.getParameter("nombreDepartamento");
        String horaParam = request.getParameter("hora");

        if (nombre == null || lugar == null || cantidadParam == null || fechaSalida == null || nombreActividad == null || horaParam == null) {
            response.sendError(400, "Faltan campos");
            return;
        }
        SalidasTuristicas control = sys.getSalidaFromBD(nombre);
        if (control != null) {
            response.sendError(400, "Salida ya existente");
            return;
        }

        if (nombre.equals("") || lugar.equals("") || cantidadParam.equals("") || fechaSalida.equals("") || nombreActividad.equals("") || horaParam.equals("")) {
            response.sendError(400, "Faltan campos");
            return;
        }

        LocalTime hora = LocalTime.parse(horaParam);

        // Manejo de la imagen
        Part filePart = request.getPart("imagen");
        String rutaimg = null;
        String imageFormat = null;
        if (filePart != null) {
            String fileName = nombre;  // Cambiar el nombre de la imagen como prefieras
            String contentType = filePart.getContentType();
            String[] contentParts = contentType.split("/");
            imageFormat = contentParts[1];
            fileName = fileName + "." + imageFormat;

            String uploadPath = RutaProyecto.getRuta() + "imagenes_salidas/" + fileName;  // Cambiar la ruta a donde deseas guardar las imágenes
            rutaimg = "imagenes_salidas/" + fileName;  // Ruta relativa donde se guardará en la base de datos

            try (InputStream input = filePart.getInputStream()) {
                Files.copy(input, Paths.get(uploadPath), StandardCopyOption.REPLACE_EXISTING);
            }
        }

        if (imageFormat.equals("octet-stream")) {
            rutaimg = null;
        }
        // Luego, puedes guardar la salida turística con la ruta de la imagen en la base de datos
        sys.AltaSalidaTuristicaDepto(nombre, lugar, cantidad, LocalDate.now(), LocalDate.parse(fechaSalida), nombreActividad, nombreDepartamento, rutaimg, hora);

        response.sendRedirect("index.jsp?msg=altasalida");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
