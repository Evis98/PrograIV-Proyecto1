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

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <style>
.link-button { 
     background: none;
     border: none;
     color: #0066ff;
     text-decoration: underline;
     cursor: pointer; 
}

.table
{
	display:table;
	border-collapse:separate;
	border-spacing:2px;
}
.thead
{
	display:table-header-group;
	color:white;
	font-weight:bold;
	background-color:grey;
}
.tbody
{
	display:table-row-group;
}
.tr
{
	display:table-row;
}
.td
{
	display:table-cell;
	border:1px solid black;
	padding:1px;
}
.tr.editing .td INPUT
{
	width:100px;
}
</style>
 <%@ include file="/presentation/Head.jsp" %>
 <title>Principal</title> 
</head>
<body >
    <%@ include file="/presentation/Header.jsp" %>
<%
    Model model = (Model) request.getAttribute("model");
    List<Grupo> grupos = model.getGrupos();

%>
 
        <h1>Grupos asignados</h1>     
    
  <!--String id_grupo, String id_curso_de_grupo, String horario, String profesor_de_curso-->
                       
<div class="table">
	<div class="thead">
		<div class="tr">
			<div class="td">ID grupo</div>
			<div class="td">ID curso</div>
			<div class="td">Horario</div>
			<div class="td">Profesor</div>
		</div>
	</div>
	<div class="tbody">                
                        <% for(Grupo g:grupos){%>
		<form class="tr" action="/Matricula/presentation/grupos" method="post">
			<div class="td"><%= g.getId_grupo()%></div>
			<div class="td"><%= g.getId_curso() %></div>
			<div class="td"><%=g.getHorario()%></div>
			<div class="td"><%=g.getProfesor_de_curso()%></div>
  
		</form>
                        <%}%> 
	</div>
</div>
 


     <%@ include file="/presentation/Footer.jsp" %>
</body>
</html>