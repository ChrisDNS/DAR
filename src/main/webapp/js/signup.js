var schools = [1,2,3];
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
				email : $('#mail').val(),
				password : $('#pwd').val(),
				address : $('#address').val(),
				town : $('#town').val(),
				schools: schools
			}

		}).done(function(data) {
			if (data.success) {
				var user = JSON.parse(data.user);
				//login(user.mail);
			} else {
				$('div #error').html(data.message);
				$('div #error').show();
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