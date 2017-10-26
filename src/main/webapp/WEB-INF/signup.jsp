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
		<h1 class="text-muted">Inscription</h1>
		<form class="form-horizontal">
			<div class="form-group">
				<label class="control-label col-sm-5" for="firstName">Prénom:</label>
				<div class="col-sm-3">
					<input type="text" class="form-control" id="firstName"
						placeholder="Entrer votre prénom">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-5" for="name">Nom:</label>
				<div class="col-sm-3">
					<input type="text" class="form-control" id="name"
						placeholder="Entrer votre nom">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-5" for="email">Mail:</label>
				<div class="col-sm-3">
					<input type="email" class="form-control" id="email"
						placeholder="Entrer votre adresse électronique">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-5" for="pwd">Mot de
					passe:</label>
				<div class="col-sm-3">
					<input type="password" class="form-control" id="pwd"
						placeholder="Entrer votre mot de passe">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-5" for="adress">Adresse:*</label>
				<div class="col-sm-3">
					<input type="text" class="form-control" id="adress"
						placeholder="Entrer votre addresse">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-5" for="town">Ville:*</label>
				<div class="col-sm-3">
					<input type="text" class="form-control" id="town"
						placeholder="Entrer votre ville">
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-12">
					<label class="control-label col-sm-5" for="email">Anciennes
						et / ou récente(s) école(s) fréquentée(s):*</label>
					<div class="col-sm-11">
						<p>TODO</p>
					</div>
				</div>
			</div>
			<p class="text-warning signupInfos">Les champs * sont optionnels.</p>
			<div class="form-group">
				<div class="col-sm-11">
					<div class="checkbox">
						<label><input type="checkbox"> Se souvenir</label>
					</div>
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-12">
					<button type="submit" class="btn btn-success">Inscription</button>
				</div>
			</div>
		</form>
		<div>

			<!-- Footer -->
			<footer class="py-5 bg-dark">
				<div class="container">
					<p class="m-0 text-center text-white">Copyright &copy; 2017
						Christopher Dionisio, Marie Laporte, Belynda Hamaz</p>
				</div>
				<!-- /.container -->
			</footer>

			<!-- Bootstrap core JavaScript -->
			<script src="vendor/popper/popper.min.js"></script>
			<script
				src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
			<script
				src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
			<script src="vendor/js/js.cookie.js"></script>
			<script src="js/showNavbar.js"></script>
			<script src="js/login.js"></script>
</body>
</html>