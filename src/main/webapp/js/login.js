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

				var ifrm = document.createElement("iframe");
				ifrm.setAttribute("id", "ifrm");
				ifrm.setAttribute("name", "ifrm");
				ifrm.setAttribute("src", "http://localhost:9090");
				ifrm.style.width = "100px";
				ifrm.style.height = "100px";

				document.body.appendChild(ifrm);

				location.href = "/";

			} else {
				$('#error').html(data.message);
				$('#error').show();
			}

		}).fail(function() {
			alert("Server not responding.");
		});
	});
});

/**
 * Add some cookies needed for authentification
 */
function login(user) {
	Cookies.set('id', user.id);
	Cookies.set('email', user.email);
	Cookies.set('firstname', user.firstname);
	Cookies.set('lastname', user.lastname);
	Cookies.set('address', user.address);
}