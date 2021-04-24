<%@page import="pagina.logica.Usuario"%>
<% Usuario usuario=  (Usuario) session.getAttribute("usuario");  %>

<header>
    <div class="logo">
        <span>CursosLibres.com</span>

        
    </div> 
    <div class="menu">
        <ul> 
              <li>
                <a href="/Matricula/presentation/Index.jsp">Inicio</a>
                <li>
                     <a href="/Matricula/presentation/cursos/View.jsp">Cursos</a>
                </li>
              </li>
                        <% if (usuario!=null){ %>
                <li >
                  <a  href="/Matricula/presentation/estudiante/datos/show">Usuario:<%=usuario.getCedula()%></a>
  
                  <ul>  <!--submenu --></ul>
                </li> 
                <li >
                  <a  href="/Matricula/presentation/login/logout">Logout</a>
                  <ul>  <!--submenu --> </ul>
                </li>
                        <% } %>
                        <% if (usuario==null){%>
                <li>
                  <a href="/Matricula/presentation/login/show">Login</a>
                </li>


                        <% }%>
            </ul> 
    </div>
  </header>