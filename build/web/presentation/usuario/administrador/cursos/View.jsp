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
    List<Grupo> grupos = new ArrayList();
    Grupo g1 = new Grupo("08:00 am", new Profesor("Jose Sanchez"));
    Grupo g2 = new Grupo("10:00 am", new Profesor("Jose Sanchez"));
    Grupo g3 = new Grupo("1:00 pm", new Profesor("Georges"));
    grupos.add(g1);
    grupos.add(g2);
    grupos.add(g3);
   
%>
<!DOCTYPE html>
<html>
<head>
 <%@ include file="/presentation/Head.jsp" %>
 <title>Principal</title> 
</head>
<body >
    
    <%@ include file="/presentation/Header.jsp" %>
    <br><br>
        <div class="col-md-4">
            <form action="" method= "get">
                <input type="text" class ="form-control" name ="q" placeholder ="Search here..."/>
        </div>
        
  
        
        <div><h1>Cursos: </h1></div>
    <table id = "table" border = "1">
            <thead>
                <tr> <td>ID</td> <td>Nombre</td>  <td>Tematica</td> <td>Costo</td> <td>Oferta</td> <td>Abierto</td> </tr>
            </thead>
            <tbody>
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
            
                        <% for(Curso c:cursoVista){%>
                        <tr> 
                            
                        <td><%=c.getId_curso()%> </td>
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
        
                        <div><h1>Horarios: </h1></div>
                        
                        
                        <table id = "table" border = "1">
            <thead>
                <tr> <td>Horario</td> <td>Profesor</td> </tr>
            </thead>
            <tbody>
            
                        <% for(Grupo g:grupos){%>
                        <tr> 
                            
                        <td><%=g.getHorario()%> </td>
                        <td><%=g.getProfesor_de_curso().getNombre()%> </td> 

<!--                         <tr> <td><form action="/Guia/presentation/cliente/cuenta/show">
                                    <input type="hidden" name="numeroFld" value=""> 
                                    <button class="link-button">  </button> </form> </td>  
                            <td></td></tr>  -->              
                        <%}%> 
                        
                        
            </tbody>   
        </table>  
                        
                          <div class="fila encabezado">               </form>
                <form action="/Matricula/presentation/usuario/administrador/cursos/registro/show">
    <input type="submit" value="Agregar Curso" />
    
</form>
        </div>
  <br><br>

     <%@ include file="/presentation/Footer.jsp" %>
</html>
