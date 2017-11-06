var schools = [];
var allSchools = [{id:1}];

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
				address : $('#address').val(),
				town : $('#town').val(),
				schools: schools.join(";")
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

function addSchool() {
	var index = $('#allSchoolsList').prop('selectedIndex');
	var school = allSchools[index];
	var id = school.id;

	if (schools.indexOf(id) == -1)
		schools.push(id);
}