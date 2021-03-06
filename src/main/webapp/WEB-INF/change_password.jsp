<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="fr">

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

</head>

<body id="no-top">
	<div id="navbar"></div>

	<div class="signupForm">
		<h1 class="text-muted">Réinitialisation du mot de passe</h1>
		<form class="form-horizontal">
			<div class="form-group">
				<div id="error" class="alert alert-danger col-sm-4 col-md-offset-4">Les
					mots de passe ne correspondent pas.</div>
				<label class="control-label col-sm-5" for="mail"></label>
				<div class="col-sm-4 col-md-offset-4">
					<input id="mail" type="email" class="form-control"
						placeholder="<c:out value="${email}" />" readonly>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-5" for="newPwd"></label>
				<div class="col-sm-4 col-md-offset-4">
					<input id="pwd" type="password" class="form-control"
						placeholder="Nouveau mot de passe">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-5" for="newPwd"></label>
				<div class="col-sm-4 col-md-offset-4">
					<input id="pwdConfirm" type="password" class="form-control"
						placeholder="Confirmer le nouveau mot de passe">
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-4 col-md-offset-4">
					<button id="change" class="btn btn-success">Changer le mot
						de passe</button>
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
	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.min.js"></script>
	<script src="vendor/js/js.cookie.js"></script>
	<script src="js/utils.js"></script>
	<script src="js/change-password.js"></script>
</body>
</html>