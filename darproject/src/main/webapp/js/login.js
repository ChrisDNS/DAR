$(document).ready(function() {
	$('#connect').click(function(e) {
		e.preventDefault();

		$.ajax({
			type : 'POST',
			url : 'login',
			data : {
				login : $('#login').val(),
				password : $('#password').val()
			}
		
		}).done(function(data) {
			if (data.success) {
				var user = JSON.parse(data.user);
				Cookies.set('login', user.login);
				//ajouter autres données dans le cookie si necessaire
				location.reload();
			} else
				$('#error').show();
			
		}).fail(function() {
			alert("Server not responding.");
		});
	});
});