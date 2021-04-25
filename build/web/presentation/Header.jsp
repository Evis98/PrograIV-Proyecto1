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
                        <% if (usuario.getTipo()== 1){%>
                    <li >
                     <a  href="/Matricula/presentation/usuario/estudiante/datos/show">Usuario:<%=usuario.getCedula()%></a>
  
                  <ul>  <!--submenu --></ul>
                </li>
                <li >
                  <a  href="/Matricula/presentation/usuario/estudiante/cursos/show">Cursos Matriculados</a>
  
                  <ul>  <!--submenu --></ul>
                </li> 
                        <% } %>
                       <% if (usuario.getTipo()== 2){%>
                <li >
                  <a  href="/Matricula/presentation/usuario/profesor/datos/show">Usuario:<%=usuario.getCedula()%></a>
  
                  <ul>  <!--submenu --></ul>
                </li> 
                        <% } %>
                    <% if (usuario.getTipo()== 3){%>
                <li >
                  <a  href="/Matricula/presentation/usuario/administrador/datos/show">Usuario:<%=usuario.getCedula()%></a>
  
                  <ul>  <!--submenu --></ul>
                </li> 
                <li >
                  <a  href="/Matricula/presentation/usuario/administrador/cursos/show">Registro de nuevos cursos</a>
  
                  <ul>  <!--submenu --></ul>
                </li>
                <li >
                  <a  href="/Matricula/presentation/usuario/administrador/profesores/show">Registro de nuevos profesores</a>
  
                  <ul>  <!--submenu --></ul>
                </li>
                        <% } %>
                        
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