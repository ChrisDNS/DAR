<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<title>PariSup'!</title>

<!-- Bootstrap core CSS -->
<link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<!-- Custom styles for this template -->
<link href="css/one-page-wonder.css" rel="stylesheet">
<link href="css/login-navbar.css" rel="stylesheet">
</head>

<body>

	<!-- Navigation -->
	<nav id="navbar"
		class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
		<div class="container">

			<!-- Search for a school -->
			<a class="navbar-brand" href="#">Rechercher une école ou
				université</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarResponsive" aria-controls="navbarResponsive"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarResponsive">
				<ul class="navbar-nav ml-auto">
					+

					<!-- HOME -->
					<li class="nav-item active"><a class="nav-link" href="#">Accueil
							<span class="sr-only">(current)</span>
					</a></li>

					<!-- ABOUT -->
					<li class="nav-item"><a class="nav-link" href="#">À propos</a>
					</li>

					<!-- SIGN UP -->
					<li class="nav-item"><a class="nav-link" href="#">Inscription</a>
					</li>

					<!-- LOGIN -->
					<li class="nav-item dropdown"><a href="#"
						class="nav-link dropdown-toggle" data-toggle="dropdown"><b>Connexion</b>
							<span class="caret"></span></a>
						<ul id="login-dp" class="dropdown-menu">
							<li>
								<div class="row">
									<div class="col-md-12">
										Connexion via
										<div class="social-buttons">
											<a href="#" class="btn btn-fb"><i class="fa fa-facebook"></i>
												Facebook</a> <a href="#" class="btn btn-tw"><i
												class="fa fa-twitter"></i> Twitter</a>
										</div>
										ou
										<form id="form" class="form" role="form" method="post"
											action="/darproject/login" accept-charset="UTF-8"
											id="login-nav">
											<div class="form-group">
												<label class="sr-only" for="login">Pseudo</label> <input
													id="login" type="text" class="form-control" name="login"
													placeholder="Pseudo" required>
											</div>
											<div class="form-group">
												<label class="sr-only" for="password">Mot de passe</label> <input
													id="password" type="password" class="form-control"
													name="password" placeholder="Mot de passe" required>
												<div class="help-block text-right">
													<a href="">Mot de passe oublié ?</a>
												</div>
											</div>
											<div class="form-group">
												<button id="connect" type="submit"
													class="btn btn-primary btn-block">Connexion</button>
											</div>
											<div class="checkbox">
												<label> <input type="checkbox"> Rester
													connecté
												</label>
											</div>
										</form>
									</div>
									<div class="bottom text-center">
										Pas encore inscrit ? <a href="#"><b>Incrivez-vous !</b></a>
									</div>
								</div>
							</li>
						</ul></li>
				</ul>
			</div>
		</div>
	</nav>

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
		$(document).ready(function() {
			$('#connect').click(function() {
				event.preventDefault();

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
						$("#navbar").load("html/navbarConnected.html");
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