<%@page import="pagina.logica.Profesor"%>
<%@page import="pagina.presentation.administrador.profesores.Model"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="pagina.logica.Curso"%>
<%
    Model model = (Model) request.getAttribute("model");
    List<Profesor> profesores = model.getProfesores();
    List<Profesor> profesorVista = new ArrayList<>();
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
    
         <div class="col-md-4">
            <form action="" method= "get">
                <input type="text" class ="form-control" name ="q" placeholder ="Search here..."/>
            </form>
        </div> 
                         <%       
            String query = request.getParameter("q");
            if(query != null){
            for(Profesor p:profesores){
                if(p.getUsuario_cedula().contains(query) || p.getNombre().contains(query))
                {
                    profesorVista.add(p);
                }
            }
            }else{
                profesorVista = profesores;
                
} %>

        <div><h1>Profesores: </h1></div>
<div class="table">
	<div class="thead">
		<div class="tr">
			<div class="td">ID</div>
			<div class="td">Apellido</div>
			<div class="td">Nombre</div>
			<div class="td">Email</div>
			<div class="td">Area</div>
		</div>
	</div>
	<div class="tbody">                
                        <% for(Profesor p:profesorVista){%>
		<div class="tr">
			<div class="td"><%=p.getUsuario_cedula()%></div>
			<div class="td"><%=p.getApellidos()%></div>
			<div class="td"><%=p.getNombre()%></div>
			<div class="td"><%=p.getMail()%></div>
                        <div class="td"><%=p.getEspecialidad()%></div>
                        <%}%> 
		
	</div>
</div>
</div>

    <div class="fila encabezado">           
                <form action="/Matricula/presentation/usuario/administrador/profesores/registro/show">
    <input type="submit" value="Agregar Profesor" />
</form> </div>
     <%@ include file="/presentation/Footer.jsp" %>
</body>
</html>

