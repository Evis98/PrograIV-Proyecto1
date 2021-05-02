<%@page import="pagina.presentation.estudiante.cursos.Model"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="pagina.logica.Curso"%>
<%
    Model model = (Model) request.getAttribute("model");
    List<Curso> cursos = model.getCursos();
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
        <h1>Historial de Cursos del estudiante</h1>     
    
        <table border = "1">
            <thead>
                <tr> <td>ID</td> <td>Nombre</td>  <td>Tematica</td> <td>Costo</td> <td>Oferta</td> <td>Abierto</td> </tr>
            </thead>
            <tbody>
                        <% for(Curso c:cursos){%>
                <tr> <td><a href="/Matricula/presentation/usuario/estudiante/cursos/show">
                        <%=c.getId_curso()%> </td>
                        <td><%=c.getNombre()%> </td> 
                        <td><%=c.getTematica()%> </td> 
                        <td><%=c.getCosto()%> </td> 
                        <td><%=c.isEnOferta()%> </td> 
                        <td><%=c.isAbierto()%></td></tr> 
<!--                         <tr> <td><form action="/Guia/presentation/cliente/cuenta/show">
                                    <input type="hidden" name="numeroFld" value=""> 
                                    <button class="link-button">  </button> </form> </td>  
                            <td></td></tr>  -->              
                        <%}%>
            </tbody>
        </table>          
    </div> 
            <br>
  
    <div class="fila encabezado"><button  style="margin-bottom: 15px">Generar PDF</button> </div>
     <%@ include file="/presentation/Footer.jsp" %>
</body>
</html>

