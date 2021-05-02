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
package pagina.presentation.administrador.profesores.registro;


import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import pagina.logica.Profesor;



@WebServlet(name = "RegistroProfesoresController", urlPatterns = {"/presentation/usuario/administrador/profesores/registro/show","/presentation/usuario/administrador/profesores/registro/add"})
public class Controller extends HttpServlet {             
    
  protected void processRequest(HttpServletRequest request, 
                                HttpServletResponse response)
         throws ServletException, IOException {

        request.setAttribute("model", new Model());
        
        String viewUrl="";     
        switch (request.getServletPath()) {
          case "/presentation/usuario/administrador/profesores/registro/show":
              viewUrl = this.show(request);
              break;
          case "/presentation/usuario/administrador/profesores/registro/add":
              viewUrl = this.add(request);
              break;
        }          
        request.getRequestDispatcher(viewUrl).forward( request, response); 
  }

    public String show(HttpServletRequest request) {
        return this.showAction(request);
    }
    
    public String showAction(HttpServletRequest request) {
      pagina.presentation.administrador.profesores.registro.Model model= (pagina.presentation.administrador.profesores.registro.Model) request.getAttribute("model");
        model.getCurrent().setUsuario_cedula("");
        model.getCurrent().setApellidos("");
        model.getCurrent().setNombre("");
        model.getCurrent().setMail("");
        model.getCurrent().setEspecialidad("");
        return "/presentation/usuario/administrador/profesores/registro/View.jsp";
    }
    
       void updateModel(HttpServletRequest request){
       pagina.presentation.administrador.profesores.registro.Model model= (pagina.presentation.administrador.profesores.registro.Model) request.getAttribute("model");
       
        model.getCurrent().setUsuario_cedula(request.getParameter("cedula"));
        model.getCurrent().setApellidos(request.getParameter("apellidos"));
        model.getCurrent().setNombre(request.getParameter("nombre"));
        model.getCurrent().setMail(request.getParameter("mail"));
        model.getCurrent().setEspecialidad(request.getParameter("especialidad"));


   }
       


    private String add(HttpServletRequest request) {
        try{
            Map<String,String> errores =  this.validar(request);
            if(errores.isEmpty()){
                this.updateModel(request);          
                return this.addAction(request);
            }
            else{
                request.setAttribute("errores", errores);
                return "/presentation/Index.jsp"; 
            }            
        }
        catch(Exception e){
            return "/presentation/Error.jsp";            
        }   
    }
            

    Map<String,String> validar(HttpServletRequest request){
        Map<String,String> errores = new HashMap<>();
        if (request.getParameter("cedula").isEmpty()){
            errores.put("cedula","Cedula requerida");
        }
        if (request.getParameter("apellidos").isEmpty()){
            errores.put("apellidos","Clave requerida");
        }
        if (request.getParameter("nombre").isEmpty()){
            errores.put("nombre","Cedula requerida");
        }
        if (request.getParameter("mail").isEmpty()){
            errores.put("mail","Clave requerida");
        }
        if (request.getParameter("especialidad").isEmpty()){
            errores.put("especialidad","Clave requerida");
        }
        return errores;
    }
    

        
    public String addAction(HttpServletRequest request) {
        pagina.presentation.administrador.profesores.registro.Model model= (pagina.presentation.administrador.profesores.registro.Model) request.getAttribute("model");
        pagina.logica.Model  domainModel = pagina.logica.Model.instance();
        
        HttpSession session = request.getSession(true);
        try {
            Profesor nuevo = model.getCurrent();
            session.setAttribute("profesor", nuevo);
            domainModel.profesoresAdd(nuevo);
            String viewUrl="";
            viewUrl="/presentation/Index.jsp";
            return viewUrl;
        } catch (Exception ex) {
            Map<String,String> errores = new HashMap<>();
            request.setAttribute("errores", errores);
            errores.put("id","Usuario o clave incorrectos");
            errores.put("nombre","Usuario o clave incorrectos");
            errores.put("email","Usuario o clave incorrectos");
            errores.put("telefono","Usuario o clave incorrectos");
            return "/presentation/registro/View.jsp"; 
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
