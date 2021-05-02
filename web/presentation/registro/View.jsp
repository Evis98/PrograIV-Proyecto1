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
         
         <form name="form" action="/Matricula/presentation/registro/add" method="post" > 
            <div class="panel" style="width:30%;">
                
                <div class="fila encabezado">Nuevo Estudiante</div>
                <div class="fila">
                            <div class="etiqueta">ID</div>
                      <div class="campo"><input placeholder="Id" type="text" name="id"></div>
                <div class="fila">
                            <div class="etiqueta">Nombre</div>
                      <div class="campo"><input placeholder="Nombre" type="text" name="nombre"></div>
                <div class="fila">
                            <div class="etiqueta">Email</div>
                      <div class="campo"><input placeholder="Temática" type="text" name="email"></div>
                <div class="fila">
                            <div class="etiqueta">Telefono</div>
                      <div class="campo"><input placeholder="Costo" type="text" name="telefono"></div>
                <div class="fila encabezado"><button  style="margin-bottom: 15px"> Registrar </button> </div>
            </div>
        </form>
         
         
        <%@ include file="/presentation/Footer.jsp" %> 
    </body>
</html>