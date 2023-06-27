<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@page session="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<t:Layout>
	<div class="p-2 flex-grow flex flex-col">
		<c:if test="${sessionScope.LoggedIn.username == null}">
			<c:redirect url="/"/>
		</c:if>

		<c:if test="${sessionScope.LoggedIn.username != null}">
			<p class="text-2xl">Welcome <c:out value="${sessionScope.LoggedIn.username}" /></p>
			<div class="text-start flex flex-col md:w-2/3 bg-zinc-200 text-black rounded-md mx-auto p-4 my-3">
				<p>ID: <c:out value="${sessionScope.LoggedIn.id}" /></p>
				<p>Username: <c:out value="${sessionScope.LoggedIn.username}" /></p>
				<p>Firstname: <c:out value="${sessionScope.LoggedIn.firstname}" /></p>
				<p>Lastname: <c:out value="${sessionScope.LoggedIn.lastname}" /></p>
				<p>Password: <c:out value="${sessionScope.LoggedIn.password}" /></p>
				<p>Email: <c:out value="${sessionScope.LoggedIn.email}" /></p>
				<p>Phone #: <c:out value="${sessionScope.LoggedIn.phone}" /></p>
				<p>Home Address: <c:out value="${sessionScope.LoggedIn.home}" /></p>
				<p>State: <c:out value="${sessionScope.LoggedIn.state}" /></p>
				<p>Favorite Color: <c:out value="${sessionScope.LoggedIn.color}" /></p>
				<p>Join Date: <c:out value="${sessionScope.LoggedIn.joindate}" /></p>
				<p>Account Role/Group: <c:out value="${sessionScope.LoggedIn.role}" /></p>
				<p>Admin Status: <c:out value="${sessionScope.LoggedIn.admin}" /></p>
				<div class="flex flex-row items-end content-end justify-end gap-4">
					<div>
						<p id="deleteAccount" class="p-2 cursor-pointer rounded-md bg-red-500 hover:bg-red-400 text-white border border-black">Delete Account</p>
					</div>
					<div>
						<p id="editAccount" class="p-2 cursor-pointer rounded-md bg-blue-500 hover:bg-blue-400 text-white border border-black">Edit Account</p>
					</div>
				</div>
			</div>
		</c:if>
		
	</div>
	<script>
		$('#deleteAccount').click(function() {
			swal({
				  title: "Are you sure?",
				  text: "This action is irreversible!",
				  icon: "warning",
				  buttons: true,
				  showCancelButton: true,
				  showCloseButton: true,
				  dangerMode: true
				}).then((confirm) => {
				  if (confirm) {
					  $.ajax({
							type: 'post',
							url: 'DeleteAccount',
							data: `<c:out value="${sessionScope.LoggedIn}" />`,
							success: function(response) {
								swal({
								  title: "Success",
								  text: "Your account was deleted",
								  icon: "success",
								}).then(function() {window.location.href = 'index.jsp'});
							},
							error: function(response) {
								swal({
								  title: "Error",
								  text: "Failed to Delete Account (Uh Oh...)",
								  icon: "error",
								});
							}
						})
					  } else {
					    swal("Your account was not deleted");
					  }
					});
		})
	</script>
</t:Layout>