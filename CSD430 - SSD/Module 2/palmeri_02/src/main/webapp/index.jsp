<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page import="java.util.*" %>
<html>
 <head>
 <title>Hello World dynamic HTML</title>
 </head>
 <body>
 Hello World!
 <%
 String userAgent = request.getHeader("user-agent");
 out.println("<br/>user-agent " + userAgent);
 String myName = "Jason";
 %>
 
 <h1>Hello <%= myName %></h1>
 
 <ul>
 <c:forEach var="i" begin="0" end="6">
 	<li><c:out value="${i}" /></li>
 </c:forEach>
 </ul>
 
 <%
 	Date date = new Date();
 %>
 <h1>Today is <%= date %></h1>
 
 <%
   out.println("Your IP address is " + request.getRemoteAddr());
 %>
 
 
 <%-- jsp comment! hello --%>
 </body>
</html>