$(document).ready(function() {
	$('#error').hide();

	$('#change').click(function(e) {
		e.preventDefault();
		
		$.ajax({
			type : 'POST',
			url : 'password_reset',
			data : {
				pwd : $('#pwd').val(),
				pwdConfirm : $('#pwdConfirm').val(),
				email : $('#mail').attr('placeholder'),
				value : $('#change').attr('id'),
				token : getURLParameter('token')
			}

		}).done(function(data) {
			if (data.success)
				location.href = "/";
			else
				$("#error").show();

		}).fail(function() {
			alert("Le serveur ne répond pas.");
		});
	});
});