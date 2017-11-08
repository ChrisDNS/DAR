<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>PariSup' !</title>

<!-- Bootstrap Core CSS -->
<link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- Theme CSS -->
<link href="css/freelancer.min.css" rel="stylesheet">
<link href="css/freelancer.css" rel="stylesheet">

<!-- Custom Fonts -->
<link href="vendor/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<link href="https://fonts.googleapis.com/css?family=Montserrat:400,700"
	rel="stylesheet" type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic"
	rel="stylesheet" type="text/css">

<link href="css/login-navbar.css" rel="stylesheet">
</head>

<body id="no-top">
	<div id="navbar"></div>

	<div class="signupForm">
		<h1 class="text-muted">Mot de passe oublié</h1>
		<form class="form-horizontal">
			<div id="info" class="alert alert-info col-sm-4 col-md-offset-4"></div>
			<div class="form-group">
				<div class="col-sm-4 col-md-offset-4">
					<input id="mail" type="email" name="reset" class="form-control"
						placeholder="Entrez votre adresse électronique">
				</div>
			</div>
			<div class="col-md-4 col-md-offset-4">
				<button id="reset" class="btn btn-success btn-md">Envoyer
					l'email de réinitialisation du mot de passe</button>
			</div>
		</form>
	</div>

	<!-- Bootstrap core JavaScript -->
	<script src="vendor/popper/popper.min.js"></script>
	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.min.js"></script>
	<script src="vendor/js/js.cookie.js"></script>
	<script src="js/showNavbar.js"></script>
	<script>
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
						$('#info').html(data.message);
						$('.form-group').hide();
						$('#info').show();
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
	</script>
</body>
</html>