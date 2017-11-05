$(document).ready(function() {
	$('#sign').click(function(e) {
		e.preventDefault();

		$.ajax({
			type : 'POST',
			url : 'signingup',
			data : {
				firstName : $('#firstName').val(),
				name : $('#name').val(),
				mail : $('#mail').val(),
				password : $('#pwd').val(),
				adress : $('#adress').val(),
				town : $('#town').val(),
				schools: []
			}

		}).done(function(data) {
			if (data.success) {
				var user = JSON.parse(data.user);
				//login(user.mail);
			} else {
				$('#error').html(data.message);
				$('#error').show();
			}

		}).fail(function() {
			alert("Server not responding.");
		});
	});
});