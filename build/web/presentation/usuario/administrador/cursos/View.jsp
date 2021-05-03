<%-- 
    Document   : View
    Created on : 25/04/2021, 12:11:56 AM
    Author     : Ivan
--%>


<%@page import="pagina.logica.Profesor"%>
<%@page import="pagina.logica.Grupo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="pagina.logica.Curso"%>
<%@page import="pagina.presentation.administrador.cursos.Model"%>
<%@page import="java.util.List"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    Model model = (Model) request.getAttribute("model");

    List<Curso> cursos = model.getCursos();
    List<Curso> cursoVista = new ArrayList();
    List<Grupo> grupos = model.getGrupos();

   
%>
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
    <br><br>
        <div class="col-md-4">
            <form action="" method= "get">
                <input type="text" class ="form-control" name ="q" placeholder ="Search here..."/>
            </form>
        </div>
    
        
                   <%       
            String query = request.getParameter("q");
            if(query != null){
            for(Curso a:cursos){
                if(a.getNombre().contains(query) || a.getTematica().contains(query))
                {
                    cursoVista.add(a);
                }
            }
            }else{
                cursoVista = cursos;
                
} %>
        
        <div><h1>Cursos: </h1></div>
                                  <div class="fila encabezado">               </form>
                <form action="/Matricula/presentation/usuario/administrador/cursos/registro/show">
    <input type="submit" value="Agregar Curso" />
    </form>
    </div>
        
        <div class="table">
	<div class="thead">
		<div class="tr">
			<div class="td">ID</div>
			<div class="td">Nombre</div>
			<div class="td">Tematica</div>
			<div class="td">Costo</div>
			<div class="td">Oferta</div>
                        <div class="td">Abierto</div>
                        <div class="td">Grupos</div>
		</div>
	</div>
	<div class="tbody">                
                        <% for(Curso c:cursoVista){%>
		<form class="tr" action="/Matricula/presentation/usuario/administrador/cursos/grupos" method="post">
			<div class="td"><%=c.getId_curso()%></div>
                        <input type="hidden" name="id" value="<%=c.getId_curso()%>" />
			<div class="td"><%=c.getNombre()%></div>
			<div class="td"><%=c.getTematica()%></div>
			<div class="td"><%=c.getCosto()%></div>
                        <div class="td"><%=c.isEnOferta()%></div>
                        <div class="td"><%=c.isEnOferta()%></div>
			<div class="td action"><button style="margin-bottom: 15px">Ver Grupos</button></div>
		</form>
                        <%}%> 
		
	</div>
</div>
                      <div><h1>Horarios: </h1></div>
                      <div class="fila encabezado">               </form
                                      <form action="https://media.tenor.com/images/a5939482ebfca35f320f08c0a3dc6150/tenor.gif">
    <input type="submit" value="Agregar Grupo" />
                </form>
    </div>
        
    <div class="table">
	<div class="thead">
		<div class="tr">
			<div class="td">Horario</div>
			<div class="td">Profesor</div>
		</div>
	</div>
	<div class="tbody">                
                        <% for(Grupo g:grupos){%>
		<form class="tr">
			<div class="td"><%=g.getHorario()%></div>
			<div class="td"><%=g.getProfesor_de_curso()%></div>
		</form>
                        <%}%> 
		
	</div>
</div>                  

                   
                                                  

  <br><br>

     <%@ include file="/presentation/Footer.jsp" %>
</html>
