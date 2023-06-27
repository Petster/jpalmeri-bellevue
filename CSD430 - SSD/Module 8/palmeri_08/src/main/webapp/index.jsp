<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@page import="palmeri_08.User" %>
<jsp:useBean id='dataManager' scope='application' class='palmeri_08.DatabaseManager' />
<!doctype html>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="p-4 bg-zinc-700 bg-opacity-60 rounded-md backdrop-filter backdrop-blur-md">
  <form method="post" action="ResetDatabase" class="flex flex-col gap-4 my-4 mt-1">
  	<button class="bg-red-200 hover:bg-red-300 font-bold text-black rounded-md p-2 border border-black" type="submit">Reset Database</button>
  </form>
  <form method="post" action="Register" class="flex flex-col gap-4 my-4">
  	<input required class="bg-red-100 text-black rounded-md p-2" type="text" name="username" placeholder="username" />
  	<input required class="bg-red-100 text-black rounded-md p-2" type="text" name="password" placeholder="password" />
  	<input required class="bg-red-100 text-black rounded-md p-2" type="text" name="email" placeholder="email" />
  	<button class="bg-green-200 hover:bg-green-300 font-bold text-black rounded-md p-2 border border-black" type="submit">Submit</button>
  </form>
  <table class="table-auto w-full">
  	<thead class="bg-white border-b">
  		<tr>
  			<th class="text-sm font-medium text-gray-900 px-6 py-4 text-left">ID</th>
  			<th class="text-sm font-medium text-gray-900 px-6 py-4 text-left">Username</th>
  			<th class="text-sm font-medium text-gray-900 px-6 py-4 text-left">Password</th>
  			<th class="text-sm font-medium text-gray-900 px-6 py-4 text-left">Email</th>
  		</tr>
  	</thead>
  	<tbody>
  	
  <%
  	ArrayList<User> allUsers = dataManager.getAllUser();
    Iterator<User> iterator = allUsers.iterator();
    
    int i = 1;
    while(iterator.hasNext()) {
    	User user = iterator.next();
    	
    	if(i % 2 != 0) {
  %>
    <tr class="bg-gray-100 border-b">
    	<td class="px-6 py-4 whitespace-nowrap text-sm font-medium text-gray-900"><%= user.getId() %></td>
    	<td class="text-sm text-gray-900 font-light px-6 py-4 whitespace-nowrap"><%= user.getUsername() %></td>
    	<td class="text-sm text-gray-900 font-light px-6 py-4 whitespace-nowrap"><%= user.getPassword() %></td>
    	<td class="text-sm text-gray-900 font-light px-6 py-4 whitespace-nowrap"><%= user.getEmail() %></td>
    </tr>
  <% } else { %>
  	<tr class="bg-white border-b">
    	<td class="px-6 py-4 whitespace-nowrap text-sm font-medium text-gray-900"><%= user.getId() %></td>
    	<td class="text-sm text-gray-900 font-light px-6 py-4 whitespace-nowrap"><%= user.getUsername() %></td>
    	<td class="text-sm text-gray-900 font-light px-6 py-4 whitespace-nowrap"><%= user.getPassword() %></td>
    	<td class="text-sm text-gray-900 font-light px-6 py-4 whitespace-nowrap"><%= user.getEmail() %></td>
    </tr>
  <% }} %>
  	</tbody>
  </table>
</body>
</html>