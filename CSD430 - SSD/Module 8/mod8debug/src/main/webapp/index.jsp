<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   <head>
      <title>Debug JSP Actions</title>
   </head>

   <body>
         <h2>Using JavaBeans in JSP</h2>
         <jsp:usebean class="mod8debug.TestBean" />
         <jsp:setProperty name="test"  property="message" />
         <p>Reading Message:</p>
         <jsp:getProperty name="test" property="message" />
   </body>
</html>