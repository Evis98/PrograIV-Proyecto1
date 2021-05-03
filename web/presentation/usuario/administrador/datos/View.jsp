<%-- 
    Document   : View
    Created on : 23/04/2021, 03:17:00 PM
    Author     : PC
--%>

<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="pagina.presentation.administrador.datos.Model"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
 <%@ include file="/presentation/Head.jsp" %>
</head>
<body >
  
    <%@ include file="/presentation/Header.jsp" %>

        <% Model model= (Model) request.getAttribute("model"); %>
        <% Map<String,String> errores = (Map<String,String>) request.getAttribute("errores"); %>
        <% Map<String,String[]> form = (errores==null)?this.getForm(model):request.getParameterMap();%>
        
        <form name="form" action="/Matricula/presentation/profesor/datos/update" method="post" > 
            <div class="panel" style="width:30%;">
                <div class="fila encabezado">Datos</div>
                <div class="fila">
                       <div class="etiqueta">Cedula</div>
                      <div class="campo"><%=model.getCurrent().getUsuario_cedula()%></div>
                                            </div>
                <div class="fila">
                       <div class="etiqueta">Apellido</div>
                      <div class="campo"><%=model.getCurrent().getApellidos()%></div>
                                            </div>
                 <div class="fila">
                       <div class="etiqueta">Nombre</div>
                      <div class="campo"><%=model.getCurrent().getNombre()%></div>                
            </div>
                                  </div>
        </form>
    <%@ include file="/presentation/Footer.jsp" %>                  
</body>
</html>
<%!
    private String erroneo(String campo, Map<String,String> errores){
      if ( (errores!=null) && (errores.get(campo)!=null) )
        return "is-invalid";
      else
        return "";
    }

    private String title(String campo, Map<String,String> errores){
      if ( (errores!=null) && (errores.get(campo)!=null) )
        return errores.get(campo);
      else
        return "";
    }

    private Map<String,String[]> getForm(Model model){
       Map<String,String[]> values = new HashMap<>();
       values.put("cedulaFld", new String[]{model.getCurrent().getUsuario_cedula()});
       values.put("nombreFld", new String[]{model.getCurrent().getNombre()});
       return values;
    }
    
%> 