<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@page session="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@page import="palmeri_11.User" %>
<jsp:useBean id='dataManager' scope='application' class='palmeri_11.DatabaseManager' />
<t:Layout>
	<div class="p-2 flex-grow flex flex-col">
		<h1 class="text-2xl">All Signed Up Users</h1>
		<button class="m-4 md:w-1/3 mx-auto p-3 rounded-md bg-blue-500 hover:bg-blue-400 text-white font-bold border border-blue-800" id="loadUsers">Load Users</button>
		<c:if test="${sessionScope.UserList != null}">
		<div class="overflow-x-auto max-w-sm sm:max-w-md md:max-w-2xl lg:max-w-3xl xl:max-w-5xl 2xl:max-w-7xl mx-auto">
		<table class="table-auto">
		  	<thead class="bg-white border-b">
		  		<tr>
		  			<th class="text-sm font-medium text-gray-900 px-6 py-4 text-left">ID</th>
		  			<th class="text-sm font-medium text-gray-900 px-6 py-4 text-left">Firstname</th>
		  			<th class="text-sm font-medium text-gray-900 px-6 py-4 text-left">Lastname</th>
		  			<th class="text-sm font-medium text-gray-900 px-6 py-4 text-left">Username</th>
		  			<th class="text-sm font-medium text-gray-900 px-6 py-4 text-left">Password</th>
		  			<th class="text-sm font-medium text-gray-900 px-6 py-4 text-left">Email</th>
		  			<th class="text-sm font-medium text-gray-900 px-6 py-4 text-left">Phone</th>
		  			<th class="text-sm font-medium text-gray-900 px-6 py-4 text-left">Home Address</th>
		  			<th class="text-sm font-medium text-gray-900 px-6 py-4 text-left">State</th>
		  			<th class="text-sm font-medium text-gray-900 px-6 py-4 text-left">Favorite Color</th>
		  			<th class="text-sm font-medium text-gray-900 px-6 py-4 text-left">Joined</th>
		  			<th class="text-sm font-medium text-gray-900 px-6 py-4 text-left">Role</th>
		  			<th class="text-sm font-medium text-gray-900 px-6 py-4 text-left">Admin</th>
		  		</tr>
		  	</thead>
		  	<tbody>
			<c:forEach items="${sessionScope.UserList}" var="i" varStatus="loop">
				<c:if test="${loop.getCount() % 2 != 0}">
					<tr class="bg-gray-100 border-b">
	    			<td class="px-6 py-4 whitespace-nowrap text-sm font-medium text-gray-900"><c:out value="${i.id}" /></td>
	    			<td class="text-sm text-gray-900 font-light px-6 py-4 whitespace-nowrap"><c:out value="${i.firstname}" /></td>
	    			<td class="text-sm text-gray-900 font-light px-6 py-4 whitespace-nowrap"><c:out value="${i.lastname}" /></td>
	    			<td class="text-sm text-gray-900 font-light px-6 py-4 whitespace-nowrap"><c:out value="${i.username}" /></td>
	    			<td class="text-sm text-gray-900 font-light px-6 py-4 whitespace-nowrap"><c:out value="${i.password}" /></td>
	    			<td class="text-sm text-gray-900 font-light px-6 py-4 whitespace-nowrap"><c:out value="${i.email}" /></td>
	    			<td class="text-sm text-gray-900 font-light px-6 py-4 whitespace-nowrap"><c:out value="${i.phone}" /></td>
	    			<td class="text-sm text-gray-900 font-light px-6 py-4 whitespace-nowrap"><c:out value="${i.home}" /></td>
	    			<td class="text-sm text-gray-900 font-light px-6 py-4 whitespace-nowrap"><c:out value="${i.state}" /></td>
	    			<td class="text-sm text-gray-900 font-light px-6 py-4 whitespace-nowrap"><c:out value="${i.color}" /></td>
	    			<td class="text-sm text-gray-900 font-light px-6 py-4 whitespace-nowrap"><c:out value="${i.joindate}" /></td>
	    			<td class="text-sm text-gray-900 font-light px-6 py-4 whitespace-nowrap"><c:out value="${i.role}" /></td>
	    			<td class="text-sm text-gray-900 font-light px-6 py-4 whitespace-nowrap"><c:out value="${i.admin}" /></td>
    				</tr>
				</c:if>
				<c:if test="${loop.getCount() % 2 == 0}">
					<tr class="bg-white border-b">
	    			<td class="px-6 py-4 whitespace-nowrap text-sm font-medium text-gray-900"><c:out value="${i.id}" /></td>
	    			<td class="text-sm text-gray-900 font-light px-6 py-4 whitespace-nowrap"><c:out value="${i.firstname}" /></td>
	    			<td class="text-sm text-gray-900 font-light px-6 py-4 whitespace-nowrap"><c:out value="${i.lastname}" /></td>
	    			<td class="text-sm text-gray-900 font-light px-6 py-4 whitespace-nowrap"><c:out value="${i.username}" /></td>
	    			<td class="text-sm text-gray-900 font-light px-6 py-4 whitespace-nowrap"><c:out value="${i.password}" /></td>
	    			<td class="text-sm text-gray-900 font-light px-6 py-4 whitespace-nowrap"><c:out value="${i.email}" /></td>
	    			<td class="text-sm text-gray-900 font-light px-6 py-4 whitespace-nowrap"><c:out value="${i.phone}" /></td>
	    			<td class="text-sm text-gray-900 font-light px-6 py-4 whitespace-nowrap"><c:out value="${i.home}" /></td>
	    			<td class="text-sm text-gray-900 font-light px-6 py-4 whitespace-nowrap"><c:out value="${i.state}" /></td>
	    			<td class="text-sm text-gray-900 font-light px-6 py-4 whitespace-nowrap"><c:out value="${i.color}" /></td>
	    			<td class="text-sm text-gray-900 font-light px-6 py-4 whitespace-nowrap"><c:out value="${i.joindate}" /></td>
	    			<td class="text-sm text-gray-900 font-light px-6 py-4 whitespace-nowrap"><c:out value="${i.role}" /></td>
	    			<td class="text-sm text-gray-900 font-light px-6 py-4 whitespace-nowrap"><c:out value="${i.admin}" /></td>
    				</tr>
				</c:if>
			</c:forEach>
			</tbody>
	  </table>
	  </div>
		</c:if>
	</div>
	
	<script>
	$('#loadUsers').click(function(e) {
		e.preventDefault();
    	$.ajax({
			type: 'post',
			url: 'AllUsers',
			success: function(response) {
				swal({
				  title: "Success",
				  text: "Found all Users",
				  icon: "success",
				}).then(function() {window.location.href = 'users.jsp'});
			},
			error: function(response) {
				swal({
				  title: "Error",
				  text: "Failed to get Users",
				  icon: "error",
				});
			}
		})
    });
	</script>
</t:Layout>