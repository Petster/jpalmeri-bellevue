<%@page language="java" contentType="text/html"%>
<%@page trimDirectiveWhitespaces="true"%>
<%@page session="true" import="java.util.Vector, ebookshop.Book"%>
<html>
<head>
<title>E-Bookshop</title>
<style type="text/css">
body {
	background-color: gray;
	font-size: 10pt;
}

H1 {
	font-size: 20pt;
}

table {
	background-color: white;
}
</style>
</head>
<body>
	<H1>Your online Bookshop</H1>
	<hr />
	<% //creating the booklist array and setting it equal to the "ebookshop.list" session variable
		//which is set on line 66 of ShoppingServlet.java
  Vector booklist =
      (Vector<ebookshop.Book>)session.getAttribute("ebookshop.list");
  if (booklist == null) {
	  //if there are no books in the booklist redirect to /eshop to add books
    response.sendRedirect("/ebookshop/eshop");
    }
  else {
  %>
	<form name="addForm" action="eshop" method="POST">
		<input type="hidden" name="do_this" value="add"> Book: <select
			name=book>
			<% //create an option for each book in the dropdown
        for (int i = 0; i < booklist.size(); i++) {
          out.println("<option>" + (String)booklist.elementAt(i) + "</option>");
          }
  %>
		</select> Quantity: <input type="text" name="qty" size="3" value="1"> <input
			type="submit" value="Add to Cart">
	</form>
	<p />
	<%
		//create list of items in cart
		//methods for this start occuring on line 92+ of ShoppingServlet.java starting with the remove method
    Vector<ebookshop.Book> shoplist =
        (Vector<ebookshop.Book>)session.getAttribute("ebookshop.cart");
    if (shoplist != null  &&  shoplist.size() > 0) {
  %>
	<table border="1" cellpadding="2">
		<tr>
			<td>TITLE</td>
			<td>PRICE</td>
			<td>QUANTITY</td>
			<td></td>
		</tr>
		<% //display all books in the booklist
      for (int i = 0; i < shoplist.size(); i++) {
        Book aBook = shoplist.elementAt(i);
  %>
		<tr>
			<form name="removeForm" action="eshop" method="POST">
				<input type="hidden" name="position" value="<%=i%>"> <input
					type="hidden" name="do_this" value="remove">
				<td><%=aBook.getTitle()%></td>
				<td align="right">$<%=aBook.getPrice()%></td>
				<td align="right"><%=aBook.getQuantity()%></td>
				<td><input type="submit" value="Remove from Cart"></td>
			</form>
		</tr>
		<%
        }
  %>
	</table>
	<p />
	<% //a hidden input sends to ShoppingServlet to run a do_this function with value "checkout" %>
	<form name="checkoutForm" action="eshop" method="POST">
		<input type="hidden" name="do_this" value="checkout"> <input
			type="submit" value="Checkout">
	</form>
	<%
      } 
    } 
  %>
</body>
</html>