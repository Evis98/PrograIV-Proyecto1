<%@page import="pagina.logica.Profesor"%>
<%@page import="pagina.presentation.administrador.profesores.Model"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="pagina.logica.Curso"%>
<%
    Model model = (Model) request.getAttribute("model");
    List<Profesor> profesores = model.getProfesores();
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
 <%@ include file="/presentation/Head.jsp" %>
 <title>Principal</title> 
</head>
<body >
    <%@ include file="/presentation/Header.jsp" %>

    <div style="width:50%;margin:auto;">
        <h1>Profesores en sistema</h1>     
    
        <table border = "1">
            <thead>
                <tr> <td>ID</td> <td>Apellido</td>  <td>Nombre</td> <td>Email</td> <td>Area</td> </tr>
            </thead>
            <tbody>
                        <% for(Profesor p:profesores){%>
                <tr> 
                        <td><%=p.getUsuario_cedula()%> </td>
                        <td><%=p.getApellidos()%> </td>\
                        <td><%=p.getNombre()%> </td>
                        <td><%=p.getMail()%> </td>
                        <td><%=p.getEspecialidad()%></td></tr> 
                
                        <%}%>
            </tbody>
        </table>          
    </div> 
            <br>
  

    <div class="fila encabezado">            </form>
                <form action="/Matricula/presentation/usuario/administrador/profesores/registro/show">
    <input type="submit" value="Agregar Profesor" />
</form> </div>
     <%@ include file="/presentation/Footer.jsp" %>
</body>
</html>

