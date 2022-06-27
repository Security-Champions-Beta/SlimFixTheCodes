<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="we45.training.labs.User"%>
<%@page import="java.util.Iterator"%> 
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page import="org.owasp.encoder.Encode" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Users</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    </head>
    <body class="container">
        <br>
        <div class="card">
            <h5 class="card-header">
                Users
                <a class="btn btn-primary float-right" href="/SQLInjection/sqli">Create</a>
            </h5>
            <div class="card-body">
                <h5 class="card-title"></h5>
                <table class="table">
                    <tr>
                        <form action="insecure" method="post">
                            <td colspan='2'>
                                <input type="text" class="form-control" name="fname" placeHolder="Search by first name">	    
                            </td>
                            <td>
                                <button type="submit" class="btn btn-primary">Submit</button>
                            </td>
                        </form>
                    </tr>
                    <tr>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Email</th>
                    </tr>
                    <%  
                      List<User> list = (List) request.getAttribute("users");
                      for(User user : list){
                    %>
                    <tr>
                        <td><%=Encode.forHtml(user.getFname())%></td>
                        <td><%=Encode.forHtml(user.getLname())%></td>
                        <td><%=Encode.forHtml(user.getEmail())%></td>
                    </tr>
                    <% } %>
                </table>
            </div>
        </div>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" ></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    </body>
</html>