<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page session="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<c:if test="${sessionScope.LoggedIn.username != null}">
	<c:redirect url="/myaccount.jsp"/>
</c:if>
<t:Layout>
	<div class="p-2 flex-grow flex flex-col text-start">
		<form id="userFormLogin" class="flex flex-col w-2/3 mx-auto gap-4">
			<div class="flex flex-col text-start">
				<label class="text-xl" for="username">Username</label>
				<input required class="p-2 rounded-md text-lg text-black" type="text" name="username" />
			</div>
			<div class="flex flex-col text-start">
				<label class="text-xl" for="password">Password</label>
				<input required class="p-2 rounded-md text-lg text-black" type="password" name="password" />
			</div>
			<div class="flex flex-col text-start">
				<button id="submitLoginUser" type="button" class="p-2 rounded-md bg-green-500 hover:bg-green-600 border border-black text-xl font-bold text-white">Login</button>
			</div>
		</form>
	</div>
</t:Layout>