<%@page language="java" session="true" %>
<%@page import="java.util.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Module 4</title>
    <style>
        .form-container {
            margin: 0 auto;
            width: 50%;
            display: flex;
            flex-direction: column;
            border: 1px solid black;
        }
        .form-item-container {
            display: flex;
            flex-direction: column;
            padding: 10px;
            flex-grow: 1;
        }
        .form-button {
            padding: 15px;
            background: green;
            color: white;
            font-weight: bold;
        }
        .form-button:hover {
            background: rgb(5, 183, 5);
            cursor: pointer;
        }
        .logout-button {
            padding: 10px;
            border: black solid 1px;
            cursor: pointer;
            color: white;
            font-weight: bold;
            background: #858585;
        }
        .logout-button:hover {
            background: #c6c6c6;
            color: black;
        }
        .header-value {
            padding: 8px;
            background: gray;
            border: black solid 1px;
            margin: 5px;
        }
        table, th, td {
            border:1px solid black;
        }
    </style>
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
        <h1>Welcome <%= firstname + " " + lastname %></h1>
        <a href="anotherpage.jsp">Test Session Variable Here!</a>
        <p>Locale: <%= locale %></p>
        <p>Your E-mail: <%= email %></p>
        <table>
            <thead>
                <th>Header Name</th>
                <th>Header Value</th>
            </thead>
        <%
            while(headers.hasMoreElements()) {
                out.println("<tr>");
                String hName = (String)headers.nextElement();
                out.println("<td>" + hName + "</td>");
                Enumeration hValues = request.getHeaders(hName);
                while(hValues.hasMoreElements()) {
                    out.println("<td>"+hValues.nextElement()+"</td>");
                }
                out.println("</tr>");
            }
        %>
        </table>
        <br/>
        <a href="invalidate.jsp" class="logout-button">Logout</a>
    <%
        } else {
    %>
        <form class="form-container" action="submit.jsp">
            <h1>Sign In</h1>
            <div class="form-item-container">
                <label for="firstname">First Name</label>
                <input required type="text" id="firstname" name="firstname" placeholder="John" />
            </div>
            <div class="form-item-container">
                <label for="lastname">Last Name</label>
                <input required type="text" id="lastname" name="lastname" placeholder="Doe" />
            </div>
            <div class="form-item-container">
                <label for="email">E-mail</label>
                <input required type="text" id="email" name="email" placeholder="JohnDoe@example.com" />
            </div>
            <div class="form-item-container">
                <button class="form-button" type="submit">Submit</button>
            </div>
        </form>
    <%
        }
    %>
</body>
</html>