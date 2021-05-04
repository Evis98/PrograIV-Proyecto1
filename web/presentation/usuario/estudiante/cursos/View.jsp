<%@page import="pagina.logica.Notas"%>
<%@page import="pagina.presentation.estudiante.cursos.Model"%>
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
    List<Notas> cursos = model.getCursos();
    String cedulaEstudiante = "";
    cedulaEstudiante = usuario.getCedula();
    %>

        <h1>Historial de Cursos del estudiante</h1>     
        
        
        <div class="table">
	<div class="thead">
		<div class="tr">
			<div class="td">ID Curso</div>
			<div class="td">ID Grupo</div>
			<div class="td">Cedula Profesor</div>
			<div class="td">Horario</div>
			<div class="td">Nota</div>
		</div>
	</div>
	<div class="tbody">                
                        <% for(Notas n:cursos){%>
		<form class="tr" action="/Matricula/presentation/grupos" method="post">
			<div class="td"><%=n.getId_curso()%></div>
			<div class="td"><%=n.getId_grupo()%></div>
			<div class="td"><%=n.getId_profesor()%></div>
			<div class="td"><%=n.getHorario()%></div>
                        <div class="td"><%=n.getNota()%></div>
		</form>
                        <%}%> 
		
	</div>
</div>
           

            <br>
  
    <form action="/Matricula/presentation/usuario/estudiante/cursos/print">
            <div class="panel" style="width:30%;">
                <input type="hidden" name="id" value="<%= cedulaEstudiante%>">
                <div class="fila encabezado"><button  style="margin-bottom: 15px">PDF</button>  </div>
            </div> 
        </form>
     <%@ include file="/presentation/Footer.jsp" %>
</body>
</html>

