$(document).ready(function() {
	
        $('.resetDB').click(function(e) {
			e.preventDefault();
        	$.ajax({
				type: 'post',
				url: 'ResetDatabase',
				success: function(response) {
					swal({
					  title: "Success",
					  text: "Database Reset",
					  icon: "success",
					}).then(function() {window.location.href = 'index.jsp'});
				},
				error: function(response) {
					swal({
					  title: "Error",
					  text: "Failed to Reset Database",
					  icon: "error",
					});
				}
			})
        });
        
         $('#submitUserCreate').click(function(e) {
			e.preventDefault();
        	$.ajax({
				type: 'post',
				url: 'Register',
				data: $('#userForm').serialize(),
				success: function(response) {
					swal({
					  title: "Success",
					  text: "Account Created",
					  icon: "success",
					}).then(function() {window.location.href = 'login.jsp'});
				},
				error: function(response) {
					swal({
					  title: "Error",
					  text: "Failed to Create Account Try Again",
					  icon: "error",
					});
				}
			})
        });
        
         $('#submitLoginUser').click(function(e) {
			e.preventDefault();
        	$.ajax({
				type: 'post',
				url: 'Login',
				data: $('#userFormLogin').serialize(),
				success: function(response) {
					window.location.href = 'index.jsp';
				},
				error: function(response) {
					swal({
					  title: "Error",
					  text: "Failed to Login (Check username and password)",
					  icon: "error",
					});
				}
			})
        });
        
        $('.logout').click(function(e) {
			e.preventDefault();
        	$.ajax({
				type: 'post',
				url: 'Logout',
				success: function(response) {
					swal({
					  title: "Success",
					  text: "You are now Logged Out",
					  icon: "success",
					}).then(function() {window.location.href = 'login.jsp'});
				},
				error: function(response) {
					swal({
					  title: "Error",
					  text: "Failed to Logout (Uh Oh...)",
					  icon: "error",
					});
				}
			})
        });
});