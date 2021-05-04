<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        
        <%@ include file="/presentation/Head.jsp" %>
        <title>Registro</title>
    </head>
    <body>
        <%@ include file="/presentation/Header.jsp" %>

         <form name="form" action="/Matricula/presentation/usuario/administrador/grupos/registro/add" method="post" > 
            <div class="panel" style="width:30%;">

                <div class="fila encabezado">Nuevo grupo</div>
                <div class="fila">
                            <div class="etiqueta">ID de Grupo</div>
                      <div class="campo"><input placeholder="Grupo" type="text" name="grupo"></div>
                <div class="fila">
                            <div class="etiqueta">ID de Curso</div>
                      <div class="campo"><input placeholder="Curso" type="text" name="curso"></div>
                <div class="fila">
                            <div class="etiqueta">Horario</div>
                      <div class="campo"><input placeholder="Horario" type="text" name="horario"></div> 
                <div class="fila">
                            <div class="etiqueta">ID de Profesor</div>
                      <div class="campo"><input placeholder="Profesor" type="text" name="profesor"></div> 
                <div class="fila encabezado"><button  style="margin-bottom: 15px"> Registrar </button> </div>
            </div>
        </form>

        <%@ include file="/presentation/Footer.jsp" %> 
    </body>
</html>