<%@tag description="User Menu" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="hidden md:flex items-center justify-end md:flex-1 lg:w-0">
	<div class="relative inline-block text-left">
		<div>
			<button id="accountb"
				class="hover:text-gray-300 text-white inline-flex justify-center w-full px-4 py-2 text-sm font-medium focus:rounded-md"
				aria-expanded="true" aria-haspopup="true">
				<c:out value="${sessionScope.LoggedIn.username}" />
				<svg class="-mr-1 ml-2 h-5 w-5" xmlns="http://www.w3.org/2000/svg"
					viewBox="0 0 20 20" fill="currentColor" aria-hidden="true">
			                  <path fill-rule="evenodd"
						d="M5.293 7.293a1 1 0 011.414 0L10 10.586l3.293-3.293a1 1 0 111.414 1.414l-4 4a1 1 0 01-1.414 0l-4-4a1 1 0 010-1.414z"
						clip-rule="evenodd"></path>
			                </svg>
			</button>
		</div>
		<div id="account"
			class="hidden origin-top-right absolute right-0 mt-2 w-56 rounded-md shadow-lg bg-black ring-1 ring-black ring-opacity-5 focus:outline-none"
			role="menu" aria-orientation="vertical" aria-labelledby="menu-button"
			tabindex="-1">
			<div class="py-1" role="none">
				<a href="myaccount.jsp"
					class="font-medium hover:text-gray-300 text-white block px-4 py-2 text-sm"
					role="menuitem" tabindex="-1" id="menu-item-0">My Account</a> 
				<p
					class="logout cursor-pointer font-medium hover:text-gray-300 text-white block px-4 py-2 text-sm"
					role="menuitem" tabindex="-1" id="menu-item-1">Logout</p>
			</div>
		</div>
	</div>
</div>