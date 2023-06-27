<%@ page language="java" contentType="text/html; charset=UTF-8"

    pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>

<head>

<meta charset="UTF-8">

<title>Debug Program</title>

</head>

<body>

<jsp:useBean id="object" class="Beans.Test" scope="session"/>

<jsp:setProperty name="object" property="k" value="15"/>

<jsp:getProperty name="object" property="k"/>

</body>

</html>