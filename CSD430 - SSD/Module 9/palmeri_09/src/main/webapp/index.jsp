<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Module 9 Examples</title>
</head>
<body>
	<%
		ArrayList<String> list = new ArrayList<String>();
		list.add("Hello");
		list.add("Hi");
		list.add("Welcome");
		list.add("Bienvenue");
		list.add("こんにちは");
		request.setAttribute("list", list);
	%>
	<c:forEach items="${list}" var="i">
		<c:out value="${i}" /><br/>
	</c:forEach>
</body>
</html>