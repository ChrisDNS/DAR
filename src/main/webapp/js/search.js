$(document).ready(function() {
	$('#search_form .btn').click(function() {
		console.log($(this).attr('name'));
		$.ajax({
			type : 'GET',
			url : 'search',
			data : {
				value : $(this).attr('name')
			}

		}).done(function(data) {

		}).fail(function() {
			alert("Le serveur ne répond pas.");
		});
	});
});