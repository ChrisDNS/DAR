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
		        ifrm.setAttribute("src", "http://localhost:9090");
		        ifrm.setAttribute("name", "ifrm");
		        ifrm.style.width = "100px";
		        ifrm.style.height = "100px";
		        document.body.appendChild(ifrm);
		        
				var win = document.getElementById('ifrm');
				
				win.addEventListener("load", function() {
					win.contentWindow.postMessage("message", "http://localhost:9090");
					console.log("fefefe");
		
					function receiveMessage(event) {
						if (event.origin !== "http://localhost:9090")
							return;
						
						alert(event.data);
					}
		
					window.addEventListener("message", receiveMessage, false);
				});
				
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