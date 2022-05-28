<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="org.owasp.encoder.Encode" %>    
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="Pragma" content="no-cache">
        <meta http-equiv="Expires" content="0">
        <meta http-equiv="Cache-Control" content="no-store, no-cache, must-revalidate">
        <title>ReflectedXSS</title>      
        <link href="/ReflectedXSS/bootstrap.min.css" rel="stylesheet" type="text/css">        
    </head>
    <body class="container">
        <br>
        <div class="card">
            <h5 class="card-header">
                ReflectedXSS                
            </h5>
            <div class="card-body">
                

                <%if(request.getParameter("name")==null)  { %>

                <h1>Hello John Doe!</h1>

                <% } else { %>

                <h1>Hello <%=Encode.forHtml(request.getParameter("name"))%>!</h1>

                <% } %>
            </div>
        </div>
        <script src="/ReflectedXSS/jquery-3.3.1.slim.min.js"></script>
        <script src="/ReflectedXSS/popper.min.js"></script>
        <script src="/ReflectedXSS/bootstrap.min.js"></script>      
    </body>
</html>