<%@page import="pagina.presentation.login.Model"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
 <%@ include file="/presentation/Head.jsp" %>
</head>
<body >
  
    <%@ include file="/presentation/Header.jsp" %>

        
        <form name="form" action="/Matricula/presentation/login/login" method="post" > 
            <div class="panel" style="width:30%;">
                <div class="fila encabezado">Login</div>
                <div class="fila">
                       <div class="etiqueta">Cedula</div>
                      <div class="campo"><input placeholder="Cedula" type="text" name="cedula"></div>
                </div>
                <div class="fila">
                  <div class="etiqueta">Clave</div>
                  <div class="campo"><input placeholder="Clave" type="password" name="clave"></div>
                </div>
                <div class="fila encabezado"><button  style="margin-bottom: 15px">Ingresar</button>  </div> 
            </div>
                </form>
           
        <form action="/Matricula/presentation/registro/View.jsp">
            <div class="panel" style="width:30%;">
                <div class="fila encabezado">¿No estás registrado?</div>
                <div class="fila encabezado"><button  style="margin-bottom: 15px">Registrar estudiante</button>  </div>
            </div> 
        </form>
     
                

    <%@ include file="/presentation/Footer.jsp" %>                  
</body>
</html>
