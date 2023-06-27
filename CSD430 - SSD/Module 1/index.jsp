<html>
<head><title>Random Number</title></head>
<body bgcolor="lightblue">
  <%
    double num = Math.random();
    if(num > 0.5) {
  %>
      <p>Lucky You! Got: <%= num %></p>
  <%
    } else {
  %>
      <p>Unlucky! Got: <%= num %></p>
  <%
    }
  %>
  <a href="<%= request.getRequestURI() %>"><h3>Try Again</h3></a>
</body>
</html>
