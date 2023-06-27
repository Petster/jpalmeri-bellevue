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
	<h1 class="text-3xl text-center">Create an Account!</h1>
		<form id="userForm" class="flex flex-col md:w-2/3 mx-auto gap-4 bg-zinc-500 bg-opacity-50 p-4 rounded-md">
			<div class="flex flex-row text-start justify-between gap-4 flex-wrap">
				<div class="flex flex-col grow">
					<label class="text-xl" for="firstname">Firstname</label>
					<input required class="p-2 rounded-md text-lg text-black" type="text" name="firstname" />
				</div>
				<div class="flex flex-col grow">
					<label class="text-xl" for="lastname">Lastname</label>
					<input required class="p-2 rounded-md text-lg text-black" type="text" name="lastname" />	
				</div>
			</div>
			<div class="flex flex-col text-start">
				<label class="text-xl" for="username">Username</label>
				<input required class="p-2 rounded-md text-lg text-black" type="text" name="username" />
			</div>
			<div class="flex flex-col text-start">
				<label class="text-xl" for="password">Password</label>
				<input required class="p-2 rounded-md text-lg text-black" type="passowrd" name="password" />
			</div>
			<div class="flex flex-col text-start">
				<label class="text-xl" for="email">Email</label>
				<input required class="p-2 rounded-md text-lg text-black" type="text" name="email" />
			</div>
			<div class="flex flex-col text-start">
				<label class="text-xl" for="phone">Phone</label>
				<input required class="p-2 rounded-md text-lg text-black" type="text" name="phone" />
			</div>
			<div class="flex flex-col text-start">
				<label class="text-xl" for="homeaddress">Home Address</label>
				<input required class="p-2 rounded-md text-lg text-black" type="text" name="homeaddress" />
			</div>
			<div class="flex flex-col text-start">
				<label class="text-xl" for="state">State</label>
				<input required class="p-2 rounded-md text-lg text-black" type="text" name="state" />
			</div>
			<div class="flex flex-col text-start">
				<label class="text-xl" for="color">Favorite Color</label>
				<select required class="p-2 rounded-md text-lg text-black" name="color">
					<option class="p-2" selected>Choose a Color</option>
					<option class="p-2 bg-red-500" value="Red">Red</option>
					<option class="p-2 bg-blue-500" value="Blue">Blue</option>
					<option class="p-2 bg-green-500" value="Green">Green</option>
					<option class="p-2 bg-pink-500" value="Pink">Pink</option>
					<option class="p-2 bg-orange-500" value="Orange">Orange</option>
					<option class="p-2 bg-purple-500" value="Purple">Purple</option>
					<option class="p-2 bg-yellow-500" value="Yellow">Yellow</option>
				</select>
			</div>
			<div class="flex flex-col text-start">
				<button id="submitUserCreate" type="button" class="p-2 rounded-md bg-green-500 hover:bg-green-600 border border-black text-xl font-bold text-white">Create User</button>
			</div>
		</form>
	</div>
</t:Layout>