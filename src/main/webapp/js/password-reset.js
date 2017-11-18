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
				location.href += "?token=" + data.token;
				$('.form-group').hide();
				$('#reset').hide();

			} else {
				$('#info').html(data.message);
				$('#info').show();
			}

		}).fail(function() {
			alert("Server not responding.");
		});
	});
});