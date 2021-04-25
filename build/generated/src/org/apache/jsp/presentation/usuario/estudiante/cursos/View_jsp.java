package org.apache.jsp.presentation.usuario.estudiante.cursos;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import pagina.presentation.estudiante.cursos.Model;
import java.util.List;
import java.util.ArrayList;
import pagina.logica.Curso;
import pagina.logica.Usuario;

public final class View_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

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

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");

    Model model = (Model) request.getAttribute("model");
    List<Curso> cursos = model.getCursos();

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write(" ");
      out.write("<link href=\"/Matricula/css/menu.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("<link href=\"/Matricula/css/style.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\n");
      out.write(" <title>Principal</title> \n");
      out.write("</head>\n");
      out.write("<body >\n");
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
      out.write("\n");
      out.write("\n");
      out.write("    <div style=\"width:50%;margin:auto;\">\n");
      out.write("        <h1>Listado de Cuentas del Cliente</h1>     \n");
      out.write("    \n");
      out.write("        <table>\n");
      out.write("            <thead>\n");
      out.write("                <tr> <td>ID</td> <td>Nombre</td>  <td>Tematica</td> <td>Costo</td> <td>Oferta</td> <td>Abierto</td> </tr>\n");
      out.write("            </thead>\n");
      out.write("            <tbody>\n");
      out.write("                        ");
 for(Curso c:cursos){
      out.write("\n");
      out.write("                <tr> <td><a href=\"/Matricula/presentation/usuario/estudiante/cursos/show\"");
      out.print(c.getId_curso());
      out.write('"');
      out.write('>');
      out.print(c.getNombre());
      out.write(" </td>  \n");
      out.write("                        <td>");
      out.print(c.getId_curso());
      out.write("</td></tr> \n");
      out.write("<!--                         <tr> <td><form action=\"/Guia/presentation/cliente/cuenta/show\">\n");
      out.write("                                    <input type=\"hidden\" name=\"numeroFld\" value=\"");
      out.print(c.getNombre());
      out.write("\"> \n");
      out.write("                                    <button class=\"link-button\"> ");
      out.print(c.getNombre());
      out.write(" </button> </form> </td>  \n");
      out.write("                            <td>");
      out.print(c.getId_curso());
      out.write("</td></tr>  -->              \n");
      out.write("                        ");
}
      out.write("\n");
      out.write("            </tbody>\n");
      out.write("        </table>          \n");
      out.write("    </div> \n");
      out.write("  \n");
      out.write("   \n");
      out.write("     ");
      out.write("\r\n");
      out.write("<footer>\r\n");
      out.write("    <h5>CursosLibres.com ©2021.</h5>\r\n");
      out.write("</footer>");
      out.write("\n");
      out.write("</html>\n");
      out.write("\n");
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
