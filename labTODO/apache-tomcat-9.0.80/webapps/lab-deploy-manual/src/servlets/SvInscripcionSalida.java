/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import controladores.Fabrica;
import controladores.ISistema;
import datatypes.DataUsuario;
import excepciones.UsuarioNoExisteException;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logica.Inscripcion_paquete;
import logica.SalidasTuristicas;
import logica.Turista;
import logica.Usuario;

/**
 *
 * @author samuel
 */
@WebServlet(name = "SvInscripcionSalida", urlPatterns = {"/inscripcionsalida"})
public class SvInscripcionSalida extends HttpServlet {

    ISistema sys = new Fabrica().getSistema();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

        request.getRequestDispatcher("/inscripcionsalida.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        String mailTurista = request.getParameter("mailTur");
        String cant = request.getParameter("cantidad");
        String nombre = request.getParameter("nombreSalida");

        if (mailTurista == null || cant == null || nombre == null) {
            response.sendError(400, "Campos no validos");
            return;
        }
        try {
            DataUsuario usr = sys.verInfoUsuario(mailTurista);
        } catch (UsuarioNoExisteException ex) {
            response.sendError(400, "usuario no encontrado");
            return;
        }
        SalidasTuristicas salida = sys.getSalidaFromBD(nombre);
        
        if (salida == null) {
            response.sendError(400, "Salida no encontrada");
            return;
        }
        
        String actividad = salida.getActividadAsociada().getNombre();
        
        if (sys.estaInscritoTuristaSalida(mailTurista, nombre)) {
            response.sendError(400, "Ya estas inscrito");
            return;
        }
        if (salida.getCantidadMaximaTuristas() <= (salida.getCantInscritos() + Integer.parseInt(cant))) {
            response.sendError(400, "Capacidad de salida maxima alcanzada");
            return;
        }
        if (!salida.estaVigente()) {
            response.sendError(400, "La salida no esta vigente");
            return;
        }
        int cantidad = Integer.parseInt(cant);
        String tipoInscr = request.getParameter("tipoInscr");
        String nombrePaq = request.getParameter("paqueteSeleccionado");
        double costo = cantidad * (salida.getActividadAsociada().getCostoPorTurista());
        if (tipoInscr.equals("paquete")) {
            Turista tur = (Turista) Usuario.obtenerUsuario(mailTurista);
            Collection<Inscripcion_paquete> inscripciones = tur.getInscripcionpaquete();

            for (Inscripcion_paquete ins : inscripciones) {
                if (ins.getPaquete().getNombre_paquete().equals(nombrePaq)) {
                    //SI EN EL PAQUETE NO SON SUFICIENTES LAS INSCRIPCIONES
                    if ( !ins.quedanXPuestos(cantidad, actividad) ) {
                        response.sendError(400, "Capacidad del paquete maxima alcanzada para esa actividad");
                        
                        return;

                    }
                    
                    costo = costo * ins.getPaquete().getDescuento();
                    
                    ins.aumentarCantInscrUsadas(cantidad,actividad);

                    sys.mergeInscrPaq(ins);
                    break;
                }
                


            }
                sys.inscripcionSalida(mailTurista, nombre, cantidad, LocalDate.now());
                sys.confirmarInscripcion(Integer.parseInt(cant),  costo,"paquete");
        } else {
            sys.inscripcionSalida(mailTurista, nombre, cantidad, LocalDate.now());
            sys.confirmarInscripcion(cantidad, costo, "general");

        }
        response.sendRedirect("index?msg=inscripcionsalida");
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
