/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pagina.presentation.administrador.cursos;



import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import pagina.logica.Curso;



@WebServlet(name = "AdministradorCursosController", urlPatterns = {"/presentation/usuario/administrador/cursos/show","/presentation/usuario/administrador/cursos/grupos"})
public class Controller extends HttpServlet {
    
  protected void processRequest(HttpServletRequest request, 
                                HttpServletResponse response)
         throws ServletException, IOException {

        request.setAttribute("model", new Model());
        
        String viewUrl="";     
        switch (request.getServletPath()) {
          case "/presentation/usuario/administrador/cursos/show":
              viewUrl = this.show(request);
              break;
          case "/presentation/usuario/administrador/cursos/grupos":
              viewUrl = this.showG(request);
              break;
        }          
        request.getRequestDispatcher(viewUrl).forward( request, response); 
  }
 public String showG(HttpServletRequest request) {
        return this.showGrupos(request);
    }
        public String showGrupos(HttpServletRequest request) {
         pagina.presentation.administrador.cursos.Model model= (pagina.presentation.administrador.cursos.Model) request.getAttribute("model");
         
        pagina.logica.Model domainModel = pagina.logica.Model.instance(); 
        //model.setSeleccionado(domainModel.getServCurso().obtenerCurso(request.getParameter("id")).get());
        model.setCursos(domainModel.getServCurso().obtenerListaCursos());
        model.setGrupos(domainModel.getServGrupo().obtenerListaGrupos(request.getParameter("id")));
        /*pagina.logica.Model domainModel = pagina.logica.Model.instance();
        model.setSeleccionado(domainModel.getCurso(request.getParameter("id")));
        model.setCursos(domainModel.cursosList());
        model.setGrupos(model.getSeleccionado().getGrupos());*/
         return "/presentation/usuario/administrador/cursos/View.jsp";
    }
    public String show(HttpServletRequest request) {
        return this.showAction(request);
    }
    
    public String showAction(HttpServletRequest request) {
        Model model = (Model) request.getAttribute("model");
        pagina.logica.Model domainModel = pagina.logica.Model.instance();
        try {        
            model.setCursos(domainModel.getServCurso().obtenerListaCursos());
            return "/presentation/usuario/administrador/cursos/View.jsp";
        } catch (Exception ex) {
            return "";
        }
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
