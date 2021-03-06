/**
 * Add a new school in the list and update graphics
 */
function addSchool() {

	// Stock the new ID if not already in
	var id = $('#allSchoolsList option:selected').val();
	if (schools.indexOf(id) == -1)
		schools.push(id);

	updateSchools();
}

/**
 * Delete a particular school in the list and update graphics
 * @param i
 */
function removeSchool(i) {
	schools.splice(i, 1);
	updateSchools();
}

/**
 * Update the graphics according to the schools variable
 */
function updateSchools() {
	var id, i, l = schools.length;
	console.log(schools);
	var ul = $('#schoolsList'), select;
	var html = "";

	if (l == 0)
		html = '<li class="list-group-item list-group-item-warning">Aucune école</li>';
	else {
		// For each ids, display the name of the school
		for (i = 0; i < l; i++) {
			id = schools[i];
			select = $('#allSchoolsList option[value=' + id + ']');
			html += '<a href=search?id='
					+ id
					+ '><div class="col-sm-10" style="padding:0;"><li style="margin-bottom:10px;" class="list-group-item list-group-item-info">'
					+ select.text()
					+ '</li></div></a><div class="col-sm-2"><button onclick="removeSchool('
					+ i
					+ ')" type="button" class="btn btn-primary"><span class="glyphicon glyphicon-trash"></span></button></div>'

		}
	}

	ul.html(html);
}

/**
 * Get all the datas in the forms
 *
 * @param sParam
 * @returns the first parameter string
 */
function getDatas() {
	return {
		firstName : $('#firstName').val(),
		name : $('#name').val(),
		email : $('#mail').val(),
		confemail : $('#confmail').val(),
		password : $('#pwd').val(),
		confpassword : $('#confpwd').val(),
		address : $('#address').val(),
		town : $('#town').val(),
		schools : schools
	};
}

$(document).ready(function() {
	updateSchools();

	// When trying to sign up
	$('#sign').click(function(e) {
		e.preventDefault();

		$.ajax({
			type : 'POST',
			url : 'signup',
			data : getDatas()
		}).done(function(data) {
			if (data.success) {
				var user = JSON.parse(data.user);
				window.location.assign("/");
				login(user);
				
				var win = document.getElementById('ifrm');
				win.contentWindow.postMessage(Cookies.get('id'), "http://pokecard.herokuapp.com/semestre2");
		
				function receiveMessage(event) {
					if (event.origin !== "http://pokecard.herokuapp.com/semestre2")
						return;
					
					alert(event.data);
				}
		
				window.addEventListener("message", receiveMessage, false);
				
			} else {
				$('div #error').html(data.message);
				$('div #error').show();
			}

		}).fail(function() {
			alert("Server not responding.");
		});
	});

	// When trying to modify account
	$('#modify').click(function(e) {
		e.preventDefault();

		$.ajax({
			type : 'POST',
			url : 'account',
			data : getDatas()
		}).done(function(data) {
			if (data.success) {
				var user = JSON.parse(data.user);
				login(user);
				$('div #error').hide();
				alert("Vos informations ont été enregistrées avec succès.");

			} else {
				$('div #error').html(data.message);
				$('div #error').show();
			}

		}).fail(function() {
			alert("Server not responding.");
		});
	});
});