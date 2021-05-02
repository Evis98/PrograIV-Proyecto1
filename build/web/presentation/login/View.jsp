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

        <% Model model= (Model) request.getAttribute("model"); %>
        <% Map<String,String> errores = (Map<String,String>) request.getAttribute("errores"); %>
        <% Map<String,String[]> form = (errores==null)?this.getForm(model):request.getParameterMap();%>
        
        <form name="form" action="/Matricula/presentation/login/login" method="post" > 
            <div class="panel" style="width:30%;">
                <div class="fila encabezado">Login</div>
                <div class="fila">
                       <div class="etiqueta">Cedula</div>
                      <div class="campo"><input class="<%=erroneo("cedula",errores)%>" placeholder="Cedula del usuario" type="text" name="cedula" value="<%=form.get("cedula")[0]%>" title="<%=title("cedula",errores)%>"></div>
                </div>
                <div class="fila">
                  <div class="etiqueta">Clave</div>
                  <div class="campo"><input class="<%=erroneo("clave",errores)%>" placeholder="Clave del usuario" type="password" name="clave" value="<%=form.get("clave")[0]%>" title="<%=title("clave",errores)%>"></div>
                </div>
                <div class="fila encabezado"><button  style="margin-bottom: 15px">Ingresar</button>  </div> 
                
                
            </div>
        </form>
                <form action="/Matricula/presentation/registro/View.jsp">
    <input type="submit" value="Registro" />
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
       values.put("cedula", new String[]{model.getCurrent().getCedula()});
       values.put("clave", new String[]{model.getCurrent().getClave()});
       return values;
    }
    
%> 