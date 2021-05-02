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
package pagina.presentation.administrador.cursos.registro;


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



@WebServlet(name = "RegistroCursosController", urlPatterns = {"/presentation/usuario/administrador/cursos/registro/show","/presentation/usuario/administrador/cursos/registro/add"})
public class Controller extends HttpServlet {             
    
  protected void processRequest(HttpServletRequest request, 
                                HttpServletResponse response)
         throws ServletException, IOException {

        request.setAttribute("model", new Model());
        
        String viewUrl="";     
        switch (request.getServletPath()) {
          case "/presentation/usuario/administrador/cursos/registro/show":
              viewUrl = this.show(request);
              break;
          case "/presentation/usuario/administrador/cursos/registro/add":
              viewUrl = this.add(request);
              break;
        }          
        request.getRequestDispatcher(viewUrl).forward( request, response); 
  }

    public String show(HttpServletRequest request) {
        return this.showAction(request);
    }
    
    public String showAction(HttpServletRequest request) {
      pagina.presentation.administrador.cursos.registro.Model model= (pagina.presentation.administrador.cursos.registro.Model) request.getAttribute("model");
        model.getCurrent().setId_curso("");
        model.getCurrent().setNombre("");
        model.getCurrent().setTematica("");
        model.getCurrent().setCosto("");
        model.getCurrent().setEnOferta("");
        model.getCurrent().setAbierto("");
        return "/presentation/usuario/administrador/cursos/registro/View.jsp";
    }
    
       void updateModel(HttpServletRequest request){
       pagina.presentation.administrador.cursos.registro.Model model= (pagina.presentation.administrador.cursos.registro.Model) request.getAttribute("model");
       
        model.getCurrent().setId_curso(request.getParameter("id"));
        model.getCurrent().setNombre(request.getParameter("nombre"));
        model.getCurrent().setTematica(request.getParameter("tematica"));
        model.getCurrent().setCosto(request.getParameter("costo"));
        model.getCurrent().setEnOferta(request.getParameter("enOferta"));
       model.getCurrent().setAbierto(request.getParameter("abierto"));

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
        if (request.getParameter("id").isEmpty()){
            errores.put("id","Cedula requerida");
        }
        if (request.getParameter("nombre").isEmpty()){
            errores.put("nombre","Clave requerida");
        }
        if (request.getParameter("tematica").isEmpty()){
            errores.put("tematica","Cedula requerida");
        }
        if (request.getParameter("costo").isEmpty()){
            errores.put("costo","Clave requerida");
        }
        return errores;
    }
    
  
        
    public String addAction(HttpServletRequest request) {
        pagina.presentation.administrador.cursos.registro.Model model= (pagina.presentation.administrador.cursos.registro.Model) request.getAttribute("model");
        pagina.logica.Model  domainModel = pagina.logica.Model.instance();
        
        HttpSession session = request.getSession(true);
        try {
            Curso nuevo = model.getCurrent();
            session.setAttribute("curso", nuevo);
            domainModel.cursoAdd(nuevo);
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
