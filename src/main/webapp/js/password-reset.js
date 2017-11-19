$(document).ready(function() {
	$('#info').hide();
	$('#info').html("");

	$('#reset').click(function(e) {
		e.preventDefault();

		$.ajax({
			type : 'POST',
			url : 'password_reset',
			data : {
				mail : $('#mail').val(),
				value : $("#mail").attr("name")
			}

		}).done(function(data) {
			if (data.success) {
				alert("Le service de mail étant payant avec notre hébergeur Heroku, nous avons décidé de retirer cette fonctionnalité.\n" +
						"Veuillez nous en excuser.");
				location.href = "/";
//				location.href += "?token=" + data.token;
//				$('.form-group').hide();
//				$('#reset').hide();

			} else {
				$('#info').html(data.message);
				$('#info').show();
			}

		}).fail(function() {
			alert("Server not responding.");
		});
	});
});