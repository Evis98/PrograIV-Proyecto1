
<%@page import="pagina.presentation.registro.Model"%>
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
        <title>Clave</title>
    </head>
    <body>
        <%@ include file="/presentation/Header.jsp" %>
        
      <%  Model model = (Model) request.getAttribute("model");
            String clave = model.getClave(); %>
        
 <div id="o" class="overlay"></div>
 <div id="p" class="popup">
 <h2>Su código de matricula es:</h2>
 <h2><%=clave %></h2>
 </div>
 <form name="form" action="/Matricula/presentation/show" method="post" > 
     <button> Regresar </button>
 
 </form>
        <%@ include file="/presentation/Footer.jsp" %> 
    </body>
</html>
