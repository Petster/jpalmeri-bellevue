<%@page language="java" contentType="text/html"%>
<%@page import="eshop.beans.CartItem"%>
<%@page import="java.util.Hashtable"%>
<%
  String base = (String)application.getAttribute("base");
  String imageURL = (String)application.getAttribute("imageURL");
  %>
<div class="header">
  <div class="logo">
    <a class="link2" style="color: white!important" href="<%=base%>">e-Shopping Center</a>
    </div>
  <div class="cart">
  <%
  @SuppressWarnings("unchecked")
  int cartSize;
  Hashtable<String, CartItem> shoppingCart = (Hashtable<String, CartItem>)session.getAttribute("shoppingCart");
  if(shoppingCart != null && !shoppingCart.isEmpty()) {
	  cartSize = shoppingCart.size();
  } else {
	  cartSize = 0;
  }
  %>
    <a class="link2" style="position: relative" href="<%=base%>?action=showCart">Show Cart
      <img src="<%=imageURL%>cart.gif" border="0"/>
      <p style="position: absolute; top: 5px; right: 15px; background: red; border-radius: 100px; width:25px; height: 25px; color: white; text-align: center"><%= cartSize %></p>
    </a>
    </div>
  </div>