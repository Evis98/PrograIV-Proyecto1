package pagina.presentation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pagina.logica.Curso;
import pagina.logica.Notas;

/**
 * Proyecto 1 Estudiantes: Crystian Chininin Barrantes 115920081 Eva Durán
 * Escobar 117130031 Miguel Montero Arce 402440709
 *
 */
@WebServlet(name = "InicioController", urlPatterns = {"/presentation/show", "/presentation/grupos", "/presentation/matricular"})
public class Controller extends HttpServlet {

    protected void processRequest(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        request.setAttribute("model", new Model());

        String viewUrl = "";
        switch (request.getServletPath()) {
            case "/presentation/show":
                viewUrl = this.show(request);
                break;
            case "/presentation/grupos":
                viewUrl = this.showG(request);
                break;
            case "/presentation/matricular":
                viewUrl = this.matricular(request);
                break;
        }
        request.getRequestDispatcher(viewUrl).forward(request, response);
    }

    public String matricular(HttpServletRequest request) {
        return this.matricularGrupo(request);
    }

    public String show(HttpServletRequest request) {
        return this.showAction(request);
    }

    public String showG(HttpServletRequest request) {
        return this.showGrupos(request);
    }

    public String showGrupos(HttpServletRequest request) {
        pagina.presentation.Model model = (pagina.presentation.Model) request.getAttribute("model");
        pagina.logica.Model domainModel = pagina.logica.Model.instance();
        model.setSeleccionado(domainModel.getServCurso().obtenerCurso(request.getParameter("id")).get());
        model.setCursos(domainModel.getServCurso().obtenerListaCursos());
        model.setGrupos(domainModel.getServGrupo().obtenerListaGrupos(request.getParameter("id")));
        return "/presentation/Index.jsp";
    }

    void updateModel(HttpServletRequest request) {

        pagina.presentation.Model model = (pagina.presentation.Model) request.getAttribute("model");
        Notas nota1 = new Notas();

        nota1 = new Notas(
                request.getParameter("idEst"),
                request.getParameter("idGrupo"),
                "No Asignada",
                request.getParameter("idProf"),
                request.getParameter("idCurso"),
                request.getParameter("horario")
        );
        model.setNotaS(nota1);

    }

    private String matricularGrupo(HttpServletRequest request) {
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
        pagina.presentation.Model model = (pagina.presentation.Model) request.getAttribute("model");
        pagina.logica.Model domainModel = pagina.logica.Model.instance();
        Notas aux = model.getNotaS();
        try {
            domainModel.getServNotas().insertarNota(aux);
            return "/presentation/show";

        } catch (Exception exception) {
            System.out.println(exception.getClass().getCanonicalName());
            Map<String, String> errores = new HashMap<>();
            request.setAttribute("errores", errores);
            errores.put("cedula", "Usuario existente");
            return "/presentation/show";
        }
    }

    Map<String, String> validar(HttpServletRequest request) {
        Map<String, String> errores = new HashMap<>();
        if (request.getParameter("idGrupo").isEmpty()) {
            errores.put("id", "Cedula requerida");
        }
        if (request.getParameter("idEst").isEmpty()) {
            errores.put("nombre", "Clave requerida");
        }
        if (request.getParameter("idProf").isEmpty()) {
            errores.put("tematica", "Cedula requerida");
        }
        if (request.getParameter("idCurso").isEmpty()) {
            errores.put("costo", "Clave requerida");
        }
        if (request.getParameter("horario").isEmpty()) {
            errores.put("costo", "Clave requerida");
        }
        return errores;
    }

    public String showAction(HttpServletRequest request) {
        pagina.presentation.Model model = (pagina.presentation.Model) request.getAttribute("model");
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
