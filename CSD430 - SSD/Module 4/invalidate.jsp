<%@page language="java" session="true" %>
<%@ page import = " java.util.* " %>
<%

session.invalidate();
response.sendRedirect("index.jsp");

%>