package org.apache.jsp.presentation.usuario.administrador.datos;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.HashMap;
import java.util.Map;
import pagina.presentation.administrador.datos.Model;
import pagina.logica.Usuario;

public final class View_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


    private String erroneo(String campo, Map<String,String> errores){
      if ( (errores!=null) && (errores.get(campo)!=null) )
        return "is-invalid";
      else
        return "";
    }

    private String title(String campo, Map<String,String> errores){
      if ( (errores!=null) && (errores.get(campo)!=null) )
        return errores.get(campo);
      else
        return "";
    }

    private Map<String,String[]> getForm(Model model){
       Map<String,String[]> values = new HashMap<>();
       values.put("cedulaFld", new String[]{model.getCurrent().getCedula()});
       values.put("nombreFld", new String[]{model.getCurrent().getNombre()});
       return values;
    }
    

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(3);
    _jspx_dependants.add("/presentation/Head.jsp");
    _jspx_dependants.add("/presentation/Header.jsp");
    _jspx_dependants.add("/presentation/Footer.jsp");
  }

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write(" ");
      out.write("<link href=\"/Matricula/css/menu.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("<link href=\"/Matricula/css/style.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body >\r\n");
      out.write("  \r\n");
      out.write("    ");
      out.write('\r');
      out.write('\n');
 Usuario usuario=  (Usuario) session.getAttribute("usuario");  
      out.write("\r\n");
      out.write("\r\n");
      out.write("<header>\r\n");
      out.write("    <div class=\"logo\">\r\n");
      out.write("        <span>CursosLibres.com</span>\r\n");
      out.write("\r\n");
      out.write("        \r\n");
      out.write("    </div> \r\n");
      out.write("    <div class=\"menu\">\r\n");
      out.write("        <ul> \r\n");
      out.write("              <li>\r\n");
      out.write("                <a href=\"/Matricula/presentation/Index.jsp\">Inicio</a>\r\n");
      out.write("                <li>\r\n");
      out.write("                     <a href=\"/Matricula/presentation/cursos/View.jsp\">Cursos</a>\r\n");
      out.write("                </li>\r\n");
      out.write("                    </li>\r\n");
      out.write("                        ");
 if (usuario!=null){ 
      out.write("\r\n");
      out.write("                        ");
 if (usuario.getTipo()== 1){
      out.write("\r\n");
      out.write("                    <li >\r\n");
      out.write("                     <a  href=\"/Matricula/presentation/usuario/estudiante/datos/show\">Usuario:");
      out.print(usuario.getCedula());
      out.write("</a>\r\n");
      out.write("  \r\n");
      out.write("                  <ul>  <!--submenu --></ul>\r\n");
      out.write("                </li>\r\n");
      out.write("                <li >\r\n");
      out.write("                  <a  href=\"/Matricula/presentation/usuario/estudiante/cursos/show\">Cursos Matriculados</a>\r\n");
      out.write("  \r\n");
      out.write("                  <ul>  <!--submenu --></ul>\r\n");
      out.write("                </li> \r\n");
      out.write("                        ");
 } 
      out.write("\r\n");
      out.write("                       ");
 if (usuario.getTipo()== 2){
      out.write("\r\n");
      out.write("                <li >\r\n");
      out.write("                  <a  href=\"/Matricula/presentation/usuario/profesor/datos/show\">Usuario:");
      out.print(usuario.getCedula());
      out.write("</a>\r\n");
      out.write("  \r\n");
      out.write("                  <ul>  <!--submenu --></ul>\r\n");
      out.write("                </li> \r\n");
      out.write("                        ");
 } 
      out.write("\r\n");
      out.write("                    ");
 if (usuario.getTipo()== 3){
      out.write("\r\n");
      out.write("                <li >\r\n");
      out.write("                  <a  href=\"/Matricula/presentation/usuario/administrador/datos/show\">Usuario:");
      out.print(usuario.getCedula());
      out.write("</a>\r\n");
      out.write("  \r\n");
      out.write("                  <ul>  <!--submenu --></ul>\r\n");
      out.write("                </li> \r\n");
      out.write("                        ");
 } 
      out.write("\r\n");
      out.write("                        \r\n");
      out.write("                <li >\r\n");
      out.write("                  <a  href=\"/Matricula/presentation/login/logout\">Logout</a>\r\n");
      out.write("                  <ul>  <!--submenu --> </ul>\r\n");
      out.write("                </li>\r\n");
      out.write("                        ");
 } 
      out.write("\r\n");
      out.write("                        \r\n");
      out.write("     \r\n");
      out.write("                        ");
 if (usuario==null){
      out.write("\r\n");
      out.write("                <li>\r\n");
      out.write("                  <a href=\"/Matricula/presentation/login/show\">Login</a>\r\n");
      out.write("                </li>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                        ");
 }
      out.write("\r\n");
      out.write("            </ul> \r\n");
      out.write("    </div>\r\n");
      out.write("  </header>");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        ");
 Model model= (Model) request.getAttribute("model"); 
      out.write("\r\n");
      out.write("        ");
 Map<String,String> errores = (Map<String,String>) request.getAttribute("errores"); 
      out.write("\r\n");
      out.write("        ");
 Map<String,String[]> form = (errores==null)?this.getForm(model):request.getParameterMap();
      out.write("\r\n");
      out.write("        \r\n");
      out.write("        <form name=\"form\" action=\"/Matricula/presentation/profesor/datos/update\" method=\"post\" > \r\n");
      out.write("            <div class=\"panel\" style=\"width:30%;\">\r\n");
      out.write("                <div class=\"fila encabezado\">Datos</div>\r\n");
      out.write("                <div class=\"fila\">\r\n");
      out.write("                       <div class=\"etiqueta\">Cedula</div>\r\n");
      out.write("                      <div class=\"campo\">");
      out.print(model.getCurrent().getCedula());
      out.write("</div>\r\n");
      out.write("                <div class=\"fila\">\r\n");
      out.write("                       <div class=\"etiqueta\">Apellido</div>\r\n");
      out.write("                      <div class=\"campo\">");
      out.print(model.getCurrent().getApellidos());
      out.write("</div>\r\n");
      out.write("                 <div class=\"fila\">\r\n");
      out.write("                       <div class=\"etiqueta\">Nombre</div>\r\n");
      out.write("                      <div class=\"campo\">");
      out.print(model.getCurrent().getNombre());
      out.write("</div>\r\n");
      out.write("               \r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"fila\">\r\n");
      out.write("                  <div class=\"etiqueta\">Nombre</div>\r\n");
      out.write("                  <div class=\"campo\"><input class=\"");
      out.print(erroneo("nombreFld",errores));
      out.write("\" placeholder=\"Nombre del usuario\" type=\"text\" name=\"nombreFld\" value=\"");
      out.print(form.get("nombreFld")[0]);
      out.write("\" title=\"");
      out.print(title("nombreFld",errores));
      out.write("\"></div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"fila encabezado\"><button  style=\"margin-bottom: 15px\">Actualzar</button> </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </form>\r\n");
      out.write("    ");
      out.write("\r\n");
      out.write("<footer>\r\n");
      out.write("    <h5>CursosLibres.com ©2021.</h5>\r\n");
      out.write("</footer>");
      out.write("                  \r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
      out.write(' ');
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
