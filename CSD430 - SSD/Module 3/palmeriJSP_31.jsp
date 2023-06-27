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
        int array[] = new int[10];
        Random rand = new Random();

        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt(50);
        }

        for(int i = 0; i < array.length; i++) {
            String result;

            if(array[i] % 2 == 0) {
                result = "Even";
            } else {
                result = "Odd";
            }
            out.println(array[i] + " " + result);
            out.println("<br/>");
        }
    %>
</body>
</html>