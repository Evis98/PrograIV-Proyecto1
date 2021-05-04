<%-- 
    Document   : View
    Created on : 25/04/2021, 12:12:13 AM
    Author     : Ivan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@ include file="/presentation/Head.jsp" %>
        <title>Registro</title>
    </head>
    <body>
        <%@ include file="/presentation/Header.jsp" %>
         
         <form name="form" action="/Matricula/presentation/usuario/administrador/cursos/registro/add" method="post" > 
            <div class="panel" style="width:30%;">
                
                <div class="fila encabezado">Nuevo curso</div>
                <div class="fila">
                            <div class="etiqueta">ID</div>
                      <div class="campo"><input placeholder="Id" type="text" name="id"></div>
                <div class="fila">
                            <div class="etiqueta">Nombre</div>
                      <div class="campo"><input placeholder="Nombre" type="text" name="nombre"></div>
                <div class="fila">
                            <div class="etiqueta">Temática</div>
                      <div class="campo"><input placeholder="Temática" type="text" name="tematica"></div>
                <div class="fila">
                            <div class="etiqueta">Costo</div>
                      <div class="campo"><input placeholder="Costo" type="text" name="costo"></div>
                <div class="fila">
                            <div class="etiqueta">En Oferta</div>
                      <span class="radio"><input type="radio" name="enOferta" value="true"></span><span>Sí</span> 
                      <span class="radio"><input type="radio" name="enOferta" value="false" checked></span><span>No</span> 
                  </div>
                <div class="fila">
                            <div class="etiqueta">Abierta</div>
                      <span class="radio"><input type="radio" name="abierto" value="true" checked></span><span>Sí</span> 
                      <span class="radio"><input type="radio" name="abierto" value="false"></span><span>No</span> 
                  </div>      
                <div class="fila encabezado"><button  style="margin-bottom: 15px"> Registrar </button> </div>
            </div>
        </form>
         
         
        <%@ include file="/presentation/Footer.jsp" %> 
    </body>
</html>
