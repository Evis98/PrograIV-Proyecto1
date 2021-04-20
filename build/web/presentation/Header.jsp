<%@page import="banca.logic.Usuario"%>
<% Usuario usuario=  (Usuario) session.getAttribute("usuario");  %>

<header>
    <div class="logo">
        <span>Banco Santander</span>
        <img src="/Matricula/images/logo.png">
    </div> 
    <div class="menu">
        <ul> 
              <li>
                <a href="/Matricula/presentation/Index.jsp">Inicio</a>
              </li>
                        <% if (usuario!=null){ %>
                <li>
                  <a href="/Matricula/presentation/cliente/cuentas/show">Cuentas</a>
                  <ul>  <!--submenu --> </ul>
                </li>                        
                <li >
                  <a  href="/Matricula/presentation/cliente/datos/show">User:<%=usuario.getCedula()%></a>
                  <ul>  <!--submenu --> </ul>
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

