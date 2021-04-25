<%-- 
    Document   : View
    Created on : Apr 21, 2021, 1:28:03 PM
    Author     : Cristian
--%>

<%@page import="pagina.logica.Curso"%>
<%@page import="pagina.presentation.cursos.Model"%>
<%@page import="java.util.List"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Model model = (Model) request.getAttribute("model");
    List<Curso> cursos = model.getCursos();
%>
<!DOCTYPE html>
<html>
<head>
 <%@ include file="/presentation/Head.jsp" %>
 <title>Principal</title> 
</head>
<body >
    <%@ include file="/presentation/Header.jsp" %>

    <table>
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
  
   
     <%@ include file="/presentation/Footer.jsp" %>
</html>
