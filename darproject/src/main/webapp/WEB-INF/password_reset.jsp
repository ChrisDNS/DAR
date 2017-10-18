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
			<div class="form-group">
				<label class="control-label col-sm-5" for="firstName"></label>
				<div class="col-sm-3">
					<input type="email" class="form-control" id="email"
						placeholder="Entrer votre adresse électronique">
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-12">
					<button id="reset" type="submit" class="btn btn-success">Envoyer
						email de réinitialisation du mot de passe</button>
				</div>
			</div>

			<div>
				<!-- Footer -->
				<footer class="py-5 bg-dark">
					<div class="container">
						<p class="m-0 text-center text-white">Copyright &copy; 2017
							Christopher Dionisio, Marie Laporte, Belynda Hamaz</p>
					</div>
					<!-- /.container -->
				</footer>
			</div>
		</form>
	</div>

	<!-- Bootstrap core JavaScript -->
	<script src="vendor/popper/popper.min.js"></script>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script src="vendor/js/js.cookie.js"></script>
	<script src="js/showNavbar.js"></script>
	<script src="js/passwordReset.js"></script>
</body>
</html>