<%-- 
    Document   : View
    Created on : 25/04/2021, 12:12:13 AM
    Author     : Ivan
--%>

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

.overlay{
 display: none; position: absolute;
top: 0%; left: 0%;
 width: 100%; height: 100%;
background-color: lightgray;
z-index:1; opacity:.70;
}
 
.popup {
display: none; position: absolute;
top: 10%; left: 25%;
 width: 20%; height: 20%;
padding: 5px;
 border: 5px solid black;
background-color: white;
z-index:2;
}

        </style>
        <%@ include file="/presentation/Head.jsp" %>
        <title>Registro</title>
    </head>
    <body>
        <%@ include file="/presentation/Header.jsp" %>
         
         <form name="form" action="/Matricula/presentation/registro/add" method="post" > 
            <div class="panel" style="width:30%;">
                
                <div class="fila encabezado">Nuevo Estudiante</div>
                <div class="fila">
                            <div class="etiqueta">Cedula</div>
                      <div class="campo"><input placeholder="Cedula" type="text" name="cedula"></div>
                      <div class="fila">
                            <div class="etiqueta">Apellidos</div>
                      <div class="campo"><input placeholder="Apellidos" type="text" name="apellidos"></div>
                <div class="fila">
                            <div class="etiqueta">Nombre</div>
                      <div class="campo"><input placeholder="Nombre" type="text" name="nombre"></div>
                <div class="fila">
                            <div class="etiqueta">Email</div>
                      <div class="campo"><input placeholder="Email" type="text" name="email"></div>
                <div class="fila">
                            <div class="etiqueta">Telefono</div>
                      <div class="campo"><input placeholder="Telefono" type="text" name="telefono"></div>
                <div class="td action">
 <button onclick =
 "document.getElementById('o').style.display='block';
 document.getElementById('p').style.display='block';">
 Matricular</button>
 </div>
 <div id="o" class="overlay"></div>
 <div id="p" class="popup">
 <h2>Su código de matricula es:</h2>
 <h2>2384</h2>
 <button onclick =
 "document.getElementById('o').style.display='none';
 document.getElementById('p').style.display='none';">
 Regresar</button>
 </div>
            </div>
        </form>
         
         
        <%@ include file="/presentation/Footer.jsp" %> 
    </body>
</html>