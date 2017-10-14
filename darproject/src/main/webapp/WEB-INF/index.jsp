<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="fr">
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<title>PariSup' !</title>

<!-- Bootstrap core CSS -->
<link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<!-- Custom styles for this template -->
<link href="css/one-page-wonder.css" rel="stylesheet">
<link href="css/login-navbar.css" rel="stylesheet">
</head>

<body>

	<div id="navbar"></div>

	<!-- Header -->
	<header class="masthead">
		<div class="overlay">
			<div class="container">
				<h1 class="display-1 text-white">PariSup'</h1>
				<h2 class="display-4 text-white">Les études supérieures en un
					clic !</h2>
			</div>
		</div>
	</header>

	<!-- Home -->
	<section>
		<div class="container">
			<div class="row align-items-center">
				<div class="col-md-6 order-2">
					<div class="p-5">
						<img class="img-fluid rounded-circle"
							src="https://unsplash.it/500/500?image=836" alt="">
					</div>
				</div>
				<div class="col-md-6 order-1">
					<div class="p-5">
						<h2 class="display-4">Vous êtes à la recherche une école
							supérieure ? Comparez !</h2>
						<p>Notre plateforme propose aux futurs étudiants de trouver
							l'école correspondant le mieux à leurs attentes. Un outils de
							recherche est à votre disposition afin de rechercher des écoles
							selon des critères particuliers. Chaque école possède sa propre
							fiche d'information, des évaluations, ainsi qu'un réseau
							regroupant un grand nombre 'anciens étudiants !</p>
					</div>
				</div>
			</div>
		</div>
	</section>

	<section>
		<div class="container">
			<div class="row align-items-center">
				<div class="col-md-6">
					<div class="p-5">
						<img class="img-fluid rounded-circle"
							src="https://unsplash.it/500/500?image=452" alt="">
					</div>
				</div>
				<div class="col-md-6">
					<div class="p-5">
						<h2 class="display-4">Vous êtiez ou êtes actuellement dans
							une école ? Partagez !</h2>
						<p>Si vous avez déjà tenté l'expérience dans une école, il est
							possible d'aider les nouveaux arrivants en répondant à leurs
							questions, en les conseillants, et en évaluant l'école.</p>
					</div>
				</div>
			</div>
		</div>
	</section>

	<section>
		<div class="container">
			<div class="row align-items-center">
				<div class="col-md-6 order-2">
					<div class="p-5">
						<img class="img-fluid rounded-circle"
							src="https://unsplash.it/500/500?image=453" alt="">
					</div>
				</div>
				<div class="col-md-6 order-1">
					<div class="p-5">
						<h2 class="display-4">Un réseau social pour chaque école</h2>
						<p>Chaque école a son propre réseau social qui permet la
							communication entre ancients et nouveaux ou futurs étudiants.
							Pour rejoindre un réseau, il faut être inscrit. Dans votre
							profil, vous pouvez précisez les écoles que vous avez ou êtes en
							train de fréquenter, ce qui aura pour effet de vous ajouter
							automatiquement dans le réseau associé à l'école.</p>
					</div>
				</div>
			</div>
		</div>
	</section>

	<!-- Footer -->
	<footer class="py-5 bg-dark">
		<div class="container">
			<p class="m-0 text-center text-white">Copyright &copy; 2017
				Christopher Dionisio, Marie Laporte, Belynda Hamaz</p>
		</div>
		<!-- /.container -->
	</footer>

	<!-- Bootstrap core JavaScript -->
	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="vendor/popper/popper.min.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.min.js"></script>
	<script src="vendor/js/js.cookie.js"></script>
	<script>
		(function() {
			var login = Cookies.get('login');
			if (login == null || login == "")
				$("#navbar").load("html/navbar.html");
			else
				$("#navbar").load("html/navbarConnected.html");
		})();

		$(document).ready(function() {
			$('#connect').click(function(e) {
				e.preventDefault();

				$.ajax({
					type : 'POST',
					url : 'login',
					data : {
						login : $('#login').val(),
						password : $('#password').val()
					}
				}).done(function(data) {
					if (data.success) {
						var user = JSON.parse(data.user);
						Cookies.set('login', user.login);
						//ajouter autres données dans le cookie si necessaire
						location.reload();
					} else
						console.log(data.message);
				}).fail(function() {
					alert("Server not responding.");
				});
			});
		});
	</script>
</body>
</html>