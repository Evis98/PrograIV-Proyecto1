<%@page import="java.util.HashMap"%>
<%@page import="banca.logic.Model"%>

<%@page import="java.util.Map"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
 <%@ include file="/presentation/Head.jsp" %>
 <title>Principal</title> 
</head>
<body >
    <%@ include file="/presentation/Header.jsp" %>

   <div><H1 >Bienvenido a CursosLibres.com</H1></div>

        <form name="form" method="post" > 
            <div class="panel" style="width:30%;">
                <div class="fila encabezado">Login</div>
                <div class="fila">
                       <div class="etiqueta">Cedula</div>
                      <div class="campo"><input type ="text" id="Cedula del usuario" type="text" name="cedulaFld"></div>
                </div>
                <div class="fila">
                  <div class="etiqueta">Clave</div>
                  <div class="campo"><input type = "text" id="Clave del usuario" type="password" name="claveFld" ></div>
                </div>
                <div class="fila encabezado"><button  style="margin-bottom: 15px">Ingresar</button> </div>
            </div>
            </form>
     <!--
    <div><img src="/Matricula/images/logo.png" style="margin-left: 50px; height: 200px;">  </div>
    <div> <H1 >Su confianza es nuestro valor...</H1></div>
    <div><img src="/Matricula/images/people.png" style="margin-left: 50px; height: 200px;" > 
        <img src="/Matricula/images/tarjeta.png" style="margin-left: 200px;height: 200px;"></div>
   -->
     <%@ include file="/presentation/Footer.jsp" %>

</body>
</html>