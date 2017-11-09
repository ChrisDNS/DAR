$(document).ready(function() {
	$('#connect').click(function(e) {
		e.preventDefault();

		$.ajax({
			type : 'POST',
			url : 'login',
			data : {
				email : $('#email').val(),
				password : $('#password').val()
			}

		}).done(function(data) {
			if (data.success) {
				var user = JSON.parse(data.user);
				login(user);
			} else {
				$('#error').html(data.message);
				$('#error').show();
			}

		}).fail(function() {
			alert("Server not responding.");
		});
	});
});

function login(user) {
	Cookies.set('email', user.email);
	Cookies.set('firstname', user.firstname);
	Cookies.set('lastname', user.lastname);
	location.reload();
}