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


        <h1>Historial de Cursos del estudiante</h1>     
        
        
        <div class="table">
	<div class="thead">
		<div class="tr">
			<div class="td">ID</div>
			<div class="td">Nombre</div>
			<div class="td">Tematica</div>
			<div class="td">Costo</div>
			<div class="td">Oferta</div>
                        <div class="td">Abierto</div>
		</div>
	</div>
	<div class="tbody">                
                        <% for(Curso c:cursos){%>
		<form class="tr" action="/Matricula/presentation/grupos" method="post">
			<div class="td"><%=c.getId_curso()%></div>
			<div class="td"><%=c.getNombre()%></div>
			<div class="td"><%=c.getTematica()%></div>
			<div class="td"><%=c.getCosto()%></div>
                        <div class="td"><%=c.isEnOferta()%></div>
                        <div class="td"><%=c.isEnOferta()%></div>
		</form>
                        <%}%> 
		
	</div>
</div>
           

            <br>
  
    <div class="fila encabezado"><button  style="margin-bottom: 15px">Generar PDF</button> </div>
     <%@ include file="/presentation/Footer.jsp" %>
</body>
</html>

