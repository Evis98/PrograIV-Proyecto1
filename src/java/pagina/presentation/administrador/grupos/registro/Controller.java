/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pagina.presentation.administrador.grupos.registro;


import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import pagina.logica.Grupo;



@WebServlet(name = "RegistroGruposController", urlPatterns = {"/presentation/usuario/administrador/grupos/registro/show","/presentation/usuario/administrador/grupos/registro/add"})
public class Controller extends HttpServlet {             
    
  protected void processRequest(HttpServletRequest request, 
                                HttpServletResponse response)
         throws ServletException, IOException {

        request.setAttribute("model", new Model());
        
        String viewUrl="";     
        switch (request.getServletPath()) {
          case "/presentation/usuario/administrador/grupos/registro/show":
              viewUrl = this.show(request);
              break;
          case "/presentation/usuario/administrador/grupos/registro/add":
              viewUrl = this.register(request);
              break;
        }          
        request.getRequestDispatcher(viewUrl).forward( request, response); 
  }

    public String show(HttpServletRequest request) {
        return this.showAction(request);
    }
    
    public String showAction(HttpServletRequest request) {
      pagina.presentation.administrador.grupos.registro.Model model= (pagina.presentation.administrador.grupos.registro.Model) request.getAttribute("model");
        model.getCurrent().setId_grupo("");
        model.getCurrent().setId_curso("");
        model.getCurrent().setHorario("");
        model.getCurrent().setProfesor_de_curso("");
        return "/presentation/usuario/administrador/grupos/registro/View.jsp";
    }
    
       void updateModel(HttpServletRequest request){
       pagina.presentation.administrador.grupos.registro.Model model= (pagina.presentation.administrador.grupos.registro.Model) request.getAttribute("model");
       
        model.getCurrent().setId_grupo(request.getParameter("grupo"));
        model.getCurrent().setId_curso(request.getParameter("curso"));
        model.getCurrent().setHorario(request.getParameter("horario"));
        model.getCurrent().setProfesor_de_curso(request.getParameter("profesor"));
   }        

    Map<String,String> validar(HttpServletRequest request){
        Map<String,String> errores = new HashMap<>();
        if (request.getParameter("grupo").isEmpty()){
            errores.put("grupo","No. de grupo requerido");
        }
        if (request.getParameter("curso").isEmpty()){
            errores.put("curso","No. de curso requerido");
        }
        if (request.getParameter("horario").isEmpty()){
            errores.put("horario","Horario requerido");
        }
        if (request.getParameter("profesor").isEmpty()){
            errores.put("profesor","Profesor requerido");
        }
        return errores;
    }
    
    private String register(HttpServletRequest request) {
        try {
            Map<String, String> errores = this.validar(request);
            if (errores.isEmpty()) {
                this.updateModel(request);
                return this.registerAction(request);
            } else {
                request.setAttribute("errores", errores);
                return "/presentation/show";
            }
        } catch (Exception e) {
            return "/presentation/show";
        }
    }
    
    public String registerAction(HttpServletRequest request) {
        Model model = (Model) request.getAttribute("model");
        pagina.logica.Model domainModel = pagina.logica.Model.instance();
        Grupo aux = model.getCurrent();
        try {
            domainModel.getServGrupo().insertarGrupo(aux);
              
                return "/presentation/show";
            
        } catch (Exception exception) {
            System.out.println(exception.getClass().getCanonicalName());
            Map<String, String> errores = new HashMap<>();
            request.setAttribute("errores", errores);
            errores.put("id_grupo", "Grupo existente");
            return "/presentation/registro/show";
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