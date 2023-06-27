<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="mobile"
	class="hidden md:hidden lg:hidden absolute top-0 inset-x-0 p-2 transition transform origin-top-right">
	<div
		class="rounded-lg shadow-lg ring-1 ring-black ring-opacity-5 bg-black backdrop-filter backdrop-blur-md bg-opacity-95 text-white divide-y-2 divide-gray-50">
		<div class="pt-5 pb-6 px-5">
			<div class="flex items-center justify-between">
				<div>
					<img class="h-8 w-auto" src="images/logoBright.png" alt="Logo">
				</div>
				<div class="-mr-2">
					<button type="button" onclick="closeMenu()"
						class="bg-white rounded-md p-2 inline-flex items-center justify-center text-gray-400 hover:text-gray-500 hover:bg-gray-100 focus:outline-none focus:ring-2 focus:ring-inset focus:ring-indigo-500">
						<span class="sr-only">Close menu</span>
						<svg class="h-6 w-6" xmlns="http://www.w3.org/2000/svg"
							fill="none" viewBox="0 0 24 24" stroke="currentColor"
							aria-hidden="true">
                <path stroke-linecap="round" stroke-linejoin="round"
								stroke-width="2" d="M6 18L18 6M6 6l12 12"></path>
              </svg>
					</button>
				</div>
			</div>
			<div class="mt-6">
				<nav class="grid gap-y-8">
					<a href="index.jsp"
						class="-m-3 p-3 flex items-right rounded-md hover:bg-gray-800">
						<span class="ml-3 text-base font-medium text-gray-300">
							Home </span>
					</a>
					<p 
						class="resetDB -m-3 p-3 flex items-right rounded-md hover:bg-gray-800">
						<span class="ml-3 text-base font-medium text-gray-300">
							Reset DB </span>
					</p>
					<a href="users.jsp"
						class="-m-3 p-3 flex items-right rounded-md hover:bg-gray-800">
						<span class="ml-3 text-base font-medium text-gray-300">
							Users List </span>
					</a>
					<c:if test="${sessionScope.LoggedIn != null}">
					<a href="notepad.jsp"
						class="-m-3 p-3 flex items-right rounded-md hover:bg-gray-800">
						<span class="ml-3 text-base font-medium text-gray-300">
							Notepad </span>
					</a>
				</c:if>
				</nav>
			</div>
		</div>
		<div class="py-6 px-5 space-y-6 text-white">
			<div class="grid grid-cols-2 gap-y-4 gap-x-8">
				<p class="text-base font-medium text-white">Signed in as
					<c:out value="${sessionScope.LoggedIn.username}" /></p>
				<a href="myaccount.jsp"
					class="-m-3 p-3 flex items-center rounded-md hover:bg-gray-800">
					Account Settings </a> <p
					class="logout -m-3 p-3 flex items-center rounded-md hover:bg-gray-800">
					Logout </p>
			</div>
		</div>
	</div>
</div>