<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Module 3</title>
</head>
<body bgcolor="lightblue">
    <%
        String array[] = new String[10];
        Random rand = new Random();
        String letters = "abcdefghijklmnopqrstuvwxyz";

        for (int i = 0; i < array.length; i++) {
            int num = rand.nextInt(letters.length());
            array[i] = letters.substring(num, num+1);
        }

        for(int i = 0; i < array.length; i++) {
            out.println(array[i]);
            out.println("<br/>");
        }
    %>
</body>
</html>