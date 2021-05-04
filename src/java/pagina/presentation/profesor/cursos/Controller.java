package pagina.presentation.profesor.cursos;

import pagina.logica.Usuario;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import pagina.logica.Curso;
import pagina.logica.Grupo;
import pagina.logica.Notas;
import pagina.logica.Profesor;


@WebServlet(name = "ProfesorCursosController", urlPatterns = {"/presentation/usuario/profesor/cursos/show","/presentation/usuario/profesor/cursos/notas","/presentation/usuario/profesor/cursos/modificar"})
public class Controller extends HttpServlet {
    
  protected void processRequest(HttpServletRequest request, 
                                HttpServletResponse response)
         throws ServletException, IOException {

        request.setAttribute("model", new Model());
        
        String viewUrl="";     
        switch (request.getServletPath()) {
          case "/presentation/usuario/profesor/cursos/show":
              viewUrl = this.show(request);
              break;
             
        case "/presentation/usuario/profesor/cursos/notas":
              viewUrl = this.showG(request);
              break;
              
        case "/presentation/usuario/profesor/cursos/modificar":
              viewUrl = this.update(request);
              break;
        }      
        request.getRequestDispatcher(viewUrl).forward( request, response); 
  }

    public String show(HttpServletRequest request) {
        return this.showAction(request);
    }
    
    
    public String showAction(HttpServletRequest request) {
        pagina.presentation.profesor.cursos.Model model= (pagina.presentation.profesor.cursos.Model) request.getAttribute("model");
        pagina.logica.Model domainModel = pagina.logica.Model.instance();
        HttpSession session = request.getSession(true);
 
        Usuario usuario = (Usuario) session.getAttribute("usuario");
        Profesor profesor;
        try {

        } catch (Exception ex) {
            profesor=null;
        }
        try {        
            model.setGrupos(domainModel.getServGrupo().obtenerListaGruposP(usuario.getCedula()));
            model.seleccionado = new Grupo();
//            model.se = new Notas();
            return "/presentation/usuario/profesor/cursos/View.jsp";
        } catch (Exception ex) {
            return "";
        }
    }
      public String showG(HttpServletRequest request) {
        return this.showGrupos(request);
    }

        public String showGrupos(HttpServletRequest request) {
            
        pagina.presentation.profesor.cursos.Model model= (pagina.presentation.profesor.cursos.Model) request.getAttribute("model");
        pagina.logica.Model domainModel = pagina.logica.Model.instance();
        HttpSession session = request.getSession(true);
 
        Usuario usuario = (Usuario) session.getAttribute("usuario");
        
               
           
             model.setSeleccionado(domainModel.getServGrupo().obtenerGrupo(request.getParameter("id")).get());
              model.setGrupos(domainModel.getServGrupo().obtenerListaGruposP(usuario.getCedula()));
              model.setNota(domainModel.getServNotas().obtenerListaNotasG(request.getParameter("id")));
//            model.seleccionado = new Curso();
            return "/presentation/usuario/profesor/cursos/View.jsp";
        
        }
        
    private String update(HttpServletRequest request) {
     
            return this.updateAction(request);
            
        
    }


    public String updateAction(HttpServletRequest request) {

        pagina.logica.Model domainModel = pagina.logica.Model.instance();
        String idG = request.getParameter("idGrupo");
        String idE = request.getParameter("idEstudiante");
        String n = request.getParameter("nota");
        HttpSession session = request.getSession(true);
        
           
            domainModel.getServNotas().modificarNotas(idG,idE,n);
          
            return "/presentation/usuario/profesor/cursos/show";
        
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
