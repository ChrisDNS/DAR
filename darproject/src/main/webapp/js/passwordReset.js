$(document).ready(function() {
	$('#reset').click(function(e) {
		e.preventDefault();

		$.ajax({
			type : 'POST',
			url : 'password_reset',
			data : {
				email : $('#email').val(),
			}
		}).done(function(data) {
		}).fail(function() {
			alert("Server not responding.");
		});
	});
});