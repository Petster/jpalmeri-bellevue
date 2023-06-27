<%@page language="java" session="true" %>
<%@page import="java.util.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Module 4 - Session Test</title>
</head>
<body>
    <%
        if(session.getAttribute("firstname") != null) {
            String firstname = (String)session.getAttribute("firstname");
            String lastname = (String)session.getAttribute("lastname");
            String email = (String)session.getAttribute("email");
            String locale = (String)session.getAttribute("locale");
            Enumeration headers = (Enumeration)session.getAttribute("headers");
    %>
        <h1>Hello <%= firstname + " " + lastname %></h1>
        <p>This page demonstrates that your data was saved through the session variable</p>
        <br/>
        <a href="index.jsp" class="logout-button">Home</a>
    <%
        } else {
            response.sendRedirect("index.jsp?error='Not Logged In'");
        }
    %>
</body>
</html>