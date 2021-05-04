/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pagina.presentation.registro;

/**
 *
 * @author PC
 */


import pagina.logica.Estudiante;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import pagina.logica.Usuario;

/**
 *
 * @author jsanchez
 */
@WebServlet(name = "RegistroController", urlPatterns = {"/presentation/registro/add","/presentation/registro/show"})
public class Controller extends HttpServlet {

  protected void processRequest(HttpServletRequest request, 
                                HttpServletResponse response)
         throws ServletException, IOException {
      
        request.setAttribute("model", new Model()); 
        
        String viewUrl="";
        switch(request.getServletPath()){
            case "/presentation/registro/add":
                viewUrl=this.register(request);
                break;     
            case "/presentation/registro/show":
                viewUrl=this.show(request);
                break;

        }
        request.getRequestDispatcher(viewUrl).forward( request, response); 
  }
  
  public String show(HttpServletRequest request) {
        return this.showAction(request);
    }
    public String showAction(HttpServletRequest request) {
        pagina.presentation.registro.Model model= (pagina.presentation.registro.Model) request.getAttribute("model");
        model.getCurrent().setUsuario_cedula("");
        model.getCurrent().setNombre("");
        model.getCurrent().setMail("");
        model.getCurrent().setTelefono("");
        return "/presentation/registro/View.jsp";
    }
    



    
    Map<String,String> validar(HttpServletRequest request){
        Map<String,String> errores = new HashMap<>();
        if (request.getParameter("cedula").isEmpty()){
            errores.put("cedula","Cedula requerida");
        }
        if (request.getParameter("nombre").isEmpty()){
            errores.put("nombre","Nombre requerida");
        }
        if (request.getParameter("email").isEmpty()){
            errores.put("email","Email requerida");
        }
        if (request.getParameter("telefono").isEmpty()){
            errores.put("telefono","Telefono requerida");
        }
        return errores;
    }
    
     void updateModel(HttpServletRequest request){
      Model model = (Model) request.getAttribute("model");
      Estudiante est = new Estudiante();
      String aux =  model.generaClave();
      
      Usuario user = new Usuario(
              request.getParameter("cedula"),
              aux,1
      
      );
       est = new Estudiante(
      user.getCedula(),
              request.getParameter("apellidos"),
              request.getParameter("nombre"),              
              request.getParameter("telefono"),
              request.getParameter("email"),
              user
      
        
      );
       model.setCurrent(est);
       model.setClave(aux);
      
   }
    private String register(HttpServletRequest request) {
        try {
            Map<String, String> errores = this.validar(request);
            if (errores.isEmpty()) {
                this.updateModel(request);
                return this.registerAction(request);
            } else {
                request.setAttribute("errores", errores);
                return "/presentation/registro/show";
            }
        } catch (Exception e) {
            return "/presentation/registro/show";
        }
    }

    public String registerAction(HttpServletRequest request) {
        Model model = (Model) request.getAttribute("model");
        pagina.logica.Model domainModel = pagina.logica.Model.instance();
        Estudiante aux = model.getCurrent();
        try {
            Usuario id = null;
            
            try {
                id = domainModel.getServUsuario().obtenerUsuario(aux.getUsuario().getCedula()).get();
            } catch (Exception ex) {
                System.err.printf("Excepción: '%s'%n", ex.getMessage());
            }

            if (id == null ) {
                domainModel.getServEstudiante().insertarEstudiante(aux);
              
                return "/presentation/registro/Clave.jsp";
            } else {
                throw new Exception();
            }
        } catch (Exception exception) {
            System.out.println(exception.getClass().getCanonicalName());
            Map<String, String> errores = new HashMap<>();
            request.setAttribute("errores", errores);
            errores.put("cedula", "Usuario existente");
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
