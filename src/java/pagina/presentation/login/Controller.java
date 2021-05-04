package pagina.presentation.login;

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
 * Proyecto 1 Estudiantes: Crystian Chininin Barrantes 115920081 Eva Durán
 * Escobar 117130031 Miguel Montero Arce 402440709
 *
 */
@WebServlet(name = "LoginController", urlPatterns = {"/presentation/login/show", "/presentation/login/login", "/presentation/login/logout"})
public class Controller extends HttpServlet {

    protected void processRequest(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        request.setAttribute("model", new Model());

        String viewUrl = "";
        switch (request.getServletPath()) {
            case "/presentation/login/show":
                viewUrl = this.show(request);
                break;
            case "/presentation/login/login":
                viewUrl = this.login(request);
                break;
            case "/presentation/login/logout":
                viewUrl = this.logout(request);
                break;
        }
        request.getRequestDispatcher(viewUrl).forward(request, response);
    }

    private String login(HttpServletRequest request) {
        try {
            Map<String, String> errores = this.validar(request);
            if (errores.isEmpty()) {
                this.updateModel(request);
                return this.loginAction(request);
            } else {
                request.setAttribute("errores", errores);
                return "/presentation/login/show";
            }
        } catch (Exception e) {
            return "/presentation/login/show";
        }
    }

    Map<String, String> validar(HttpServletRequest request) {
        Map<String, String> errores = new HashMap<>();
        if (request.getParameter("cedula").isEmpty()) {
            errores.put("cedula", "Cedula requerida");
        }

        if (request.getParameter("clave").isEmpty()) {
            errores.put("clave", "Clave requerida");
        }
        return errores;
    }

    void updateModel(HttpServletRequest request) {
        pagina.presentation.login.Model model = (pagina.presentation.login.Model) request.getAttribute("model");
        model.getCurrent().setCedula(request.getParameter("cedula"));
        model.getCurrent().setClave(request.getParameter("clave"));
    }

    public String loginAction(HttpServletRequest request) {
        pagina.presentation.login.Model model = (pagina.presentation.login.Model) request.getAttribute("model");
        pagina.logica.Model domainModel = pagina.logica.Model.instance();
        HttpSession session = request.getSession(true);
        String aux = model.getCurrent().getCedula();
        try {
            domainModel.getServUsuario().obtenerUsuario(aux)
                    .ifPresent(e -> request.setAttribute("usuario", (Usuario) e));
            Usuario real = (Usuario) request.getAttribute("usuario");
            String viewUrl = "";
            if (real.getClave() == null ? request.getParameter("clave") == null : real.getClave().equals(request.getParameter("clave"))) {

                switch (real.getRol_fk()) {
                    case 1:
                        viewUrl = "/presentation/show";
                        break;
                    case 2:
                        viewUrl = "/presentation/show";
                        break;
                    case 3:
                        viewUrl = "/presentation/show";
                        break;
                }
                session.setAttribute("usuario", real);
                return viewUrl;
            } else {
                Map<String, String> errores = new HashMap<>();
                request.setAttribute("errores", errores);
                errores.put("clave", "Clave incorrecta");
                return "/presentation/login/show";
            }
        } catch (Exception exception) {
            System.out.println(exception.getClass().getCanonicalName());
            Map<String, String> errores = new HashMap<>();
            request.setAttribute("errores", errores);
            errores.put("cedula", "Usuario incorrecto");
            return "/presentation/login/show";
        }
    }

    public String logout(HttpServletRequest request) {
        return this.logoutAction(request);
    }

    public String logoutAction(HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        pagina.presentation.login.Model model = (pagina.presentation.login.Model) request.getAttribute("model");
        model.getCurrent().setCedula("");
        model.getCurrent().setClave("");
        session.removeAttribute("usuario");
        session.invalidate();
        return "/presentation/show";
    }

    public String show(HttpServletRequest request) {
        return this.showAction(request);
    }

    public String showAction(HttpServletRequest request) {
        pagina.presentation.login.Model model = (pagina.presentation.login.Model) request.getAttribute("model");
        model.getCurrent().setCedula("");
        model.getCurrent().setClave("");
        return "/presentation/login/View.jsp";
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
