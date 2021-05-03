/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pagina.presentation;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pagina.logica.Curso;


@WebServlet(name = "InicioController", urlPatterns = {"/presentation/show","/presentation/grupos"})
public class Controller extends HttpServlet {
    
  protected void processRequest(HttpServletRequest request, 
                                HttpServletResponse response)
         throws ServletException, IOException {

        request.setAttribute("model", new Model());
        
        String viewUrl="";     
        switch (request.getServletPath()) {
          case "/presentation/show":
              viewUrl = this.show(request);
              break;
          case "/presentation/grupos":
              viewUrl = this.showG(request);
              break;
        }          
        request.getRequestDispatcher(viewUrl).forward( request, response); 
  }

    public String show(HttpServletRequest request) {
        return this.showAction(request);
    }
     public String showG(HttpServletRequest request) {
        return this.showGrupos(request);
    }

        public String showGrupos(HttpServletRequest request) {
         pagina.presentation.Model model= (pagina.presentation.Model) request.getAttribute("model");
        pagina.logica.Model domainModel = pagina.logica.Model.instance(); 
        //model.setSeleccionado(domainModel.getServCurso().obtenerCurso(request.getParameter("id")).get());
        model.setCursos(domainModel.getServCurso().obtenerListaCursos());
        model.setGrupos(domainModel.getServGrupo().obtenerListaGrupos(request.getParameter("id")));
         return "/presentation/Index.jsp";
    }


    public String showAction(HttpServletRequest request) {
        pagina.presentation.Model model= (pagina.presentation.Model) request.getAttribute("model");
        pagina.logica.Model domainModel = pagina.logica.Model.instance();
        model.setCursos(domainModel.getServCurso().obtenerListaCursos());
        model.setGrupos(new ArrayList());
       model.setSeleccionado(new Curso());
        return "/presentation/Index.jsp";
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
