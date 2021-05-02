<%-- 
    Document   : View
    Created on : Apr 28, 2021, 10:52:57 AM
    Author     : Cristian
--%>
<%@page import="pagina.logica.Profesor"%>
<%@page import="pagina.logica.Grupo"%>
<%@page import="pagina.presentation.profesor.cursos.Model"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="pagina.logica.Curso"%>
<%
    Model model = (Model) request.getAttribute("model");
    List<Curso> cursos = model.getCursos();
    List<Grupo> grupos = new ArrayList();
    Grupo g1 = new Grupo("08:00 am", 40103);
    Grupo g2 = new Grupo("10:00 am", 40106);
    Grupo g3 = new Grupo("1:00 pm", 50932);
    grupos.add(g1);
    grupos.add(g2);
    grupos.add(g3);
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

 
        <h1>Cursos asignados</h1>     
    
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
 
                    
                        <div><h1>Grupos </h1></div>
                        
                        
                        <table id = "table" border = "1">
            <thead>
                <tr> <td>Horario</td> <td>NRC</td> </tr>
            </thead>
            <tbody>
            
                        <% for(Grupo g:grupos){%>
                        <tr> 
                            
                        <td><%=g.getHorario()%> </td>
                        <td><%=g.getId_grupo()%> </td> 

<!--                         <tr> <td><form action="/Guia/presentation/cliente/cuenta/show">
                                    <input type="hidden" name="numeroFld" value=""> 
                                    <button class="link-button">  </button> </form> </td>  
                            <td></td></tr>  -->              
                        <%}%> 
                        
                        
            </tbody>   
        </table>  


     <%@ include file="/presentation/Footer.jsp" %>
</body>
</html>