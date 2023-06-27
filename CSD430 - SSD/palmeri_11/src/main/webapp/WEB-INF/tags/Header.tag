<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@tag description="Page Header" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<header
	class="relative bg-black backdrop-filter backdrop-blur-md bg-opacity-50 z-50">
	<div class="max-w-7xl mx-auto px-4 sm:px-6">
		<div
			class="flex justify-between items-center py-6 md:justify-start md:space-x-10">
			<div class="flex justify-start lg:w-0 lg:flex-1">
				<a href=""> <span class="sr-only">Jason Palmeri Logo</span> <img
					class="h-8 w-auto sm:h-10" src="images/logoBright.png" alt="">
				</a>
			</div>
			<div class="-mr-2 -my-2 md:hidden">
				<button onclick="openMenu()" type="button"
					class="bg-white rounded-md p-2 inline-flex items-center justify-center text-gray-400 hover:text-gray-500 hover:bg-gray-100 focus:outline-none focus:ring-2 focus:ring-inset focus:ring-indigo-500"
					aria-expanded="false">
					<span class="sr-only">Open menu</span>
					<svg class="h-6 w-6" xmlns="http://www.w3.org/2000/svg" fill="none"
						viewBox="0 0 24 24" stroke="currentColor" aria-hidden="true">
			            <path stroke-linecap="round" stroke-linejoin="round"
							stroke-width="2" d="M4 6h16M4 12h16M4 18h16"></path>
			          </svg>
				</button>
			</div>
			<nav class="hidden md:flex space-x-10">
				<a href="index.jsp" class="text-base font-medium text-white hover:text-gray-300">Home</a>
				<p class="resetDB cursor-pointer text-base font-medium text-white hover:text-gray-300">Reset DB</p>
				<a href="users.jsp" class="text-base font-medium text-white hover:text-gray-300">Users List</a>
				<c:if test="${sessionScope.LoggedIn != null}">
					<a href="notepad.jsp" class="text-base font-medium text-white hover:text-gray-300">Notepad</a>
				</c:if>
			</nav>
			<c:if test="${sessionScope.LoggedIn != null}">
				<t:User></t:User>
			</c:if>
			<c:if test="${sessionScope.LoggedIn == null}">
				<t:Login></t:Login>
			</c:if>
		</div>
	</div>
	<c:if test="${sessionScope.LoggedIn != null}">
		<t:MobileMenuUser></t:MobileMenuUser>
	</c:if>
	<c:if test="${sessionScope.LoggedIn == null}">
		<t:MobileMenuLogin></t:MobileMenuLogin>
	</c:if>
</header>