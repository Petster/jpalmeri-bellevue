<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@page session="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<t:Layout>
	<div class="p-2 flex-grow flex flex-col">
		<h1 class="text-2xl">Welcome to Module 11</h1>
		<c:if test="${sessionScope.LoggedIn.username != null}">
			<p>Currently Logged in as: <c:out value="${sessionScope.LoggedIn.username}" /></p>
		</c:if>
		<c:if test="${!sessionScope.LoggedIn.username == null}">
			<p>Not Logged In</p>
		</c:if>
		<strong>If this is your first time launching the site click "Reset DB" above to create the SQL table</strong>
	</div>
</t:Layout>