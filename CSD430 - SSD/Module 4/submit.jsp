<%@page language="java" session="true" %>
<%@ page import = " java.util.* " %>
<%
String firstname = request.getParameter("firstname");
String lastname = request.getParameter("lastname");
String email = request.getParameter("email");

session.setAttribute("firstname", firstname);
session.setAttribute("lastname", lastname);
session.setAttribute("email", email);
session.setAttribute("locale", request.getLocale().toString());
session.setAttribute("headers", request.getHeaderNames());

out.print("Your Data has been stored in the Session! <br/>");

Enumeration<String> attributes = request.getSession().getAttributeNames();
while (attributes.hasMoreElements()) {
    String attribute = (String) attributes.nextElement();
    out.println(attribute + " : "+request.getSession().getAttribute(attribute) + "<br/>");
}



out.print("<a href='index.jsp'>Home Page</a>");

%>