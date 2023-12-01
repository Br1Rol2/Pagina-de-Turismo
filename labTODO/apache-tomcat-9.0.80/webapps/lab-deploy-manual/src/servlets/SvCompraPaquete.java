package servlets;

import controladores.Fabrica;
import controladores.ISistema;
import datatypes.DataUsuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logica.Paquete;


@WebServlet(name = "SvCompraPaquete", urlPatterns = {"/comprapaquete"})
public class SvCompraPaquete extends HttpServlet {
  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
    }

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
         request.getRequestDispatcher("/comprapaquete.jsp").forward(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
         ISistema sys = new Fabrica().getSistema();
         
         HttpSession sesion = request.getSession();
         
        Object loggeadoAtributousr = request.getSession().getAttribute("logeado");
        DataUsuario usuarioLoggeadousr = null;
       
        boolean loggedusr = false;
        String nickusr = null;

        if (loggeadoAtributousr != null) {
            loggedusr = (boolean) loggeadoAtributousr;
        }

        if (loggedusr) {
            nickusr = (String) sesion.getAttribute("nick");
            usuarioLoggeadousr = sys.verInfoUsuarioNick(nickusr);

        }
      
       
        String cantidadParam = request.getParameter("Cantidad");
        int cantidad = 0;
        if (cantidadParam != null && !cantidadParam.isEmpty()) {
            
            cantidad = Integer.parseInt(cantidadParam);
            
        }
        
         String vencimi = request.getParameter("Vencimiento");
         
        

         String fechaSalida = request.getParameter("Fecha");
         
       
         String paquete=request.getParameter("nombrePaq");
        //Paquete paq=sys.getPaqFromBD(request.getParameter("paquetes"));
         
       
        Paquete paq; 
        paq=sys.getPaqFromBD(paquete);
         
      
 sys.InscripcionPaquete(paquete,usuarioLoggeadousr.getCorreo(), paq.getDescuento(),cantidad,LocalDate.parse(vencimi), LocalDate.parse(fechaSalida));
       
           response.sendRedirect("comprapaquete.jsp");
      
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
