<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   <head>
      <title>Debug JSP Actions</title>
   </head>

   <body>
         <h2>Using JavaBeans in JSP</h2>
         <jsp:useBean id="test" class="mod8debug.TestBean" /> <% //capitalize the B in bean and add an ID, the only required attribute %>
         <jsp:setProperty name="test"  property="message" value="Hello Test Bean!" /> <% //add a value tag to actually Set the property to something %>
         <p>Reading Message:</p>
         <jsp:getProperty name="test" property="message" />
   </body>
</html>