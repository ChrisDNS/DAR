function getURLParameter(sParam) {
	var sPageURL = window.location.search.substring(1);
	var sURLVariables = sPageURL.split('&');

	for (var i = 0; i < sURLVariables.length; i++) {
		var sParameterName = sURLVariables[i].split('=');
		if (sParameterName[0] == sParam)
			return sParameterName[1];
	}
}

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