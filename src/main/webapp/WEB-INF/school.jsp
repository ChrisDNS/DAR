<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<link href="/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- Theme CSS -->
<link href="/css/freelancer.min.css" rel="stylesheet">
<link href="/css/freelancer.css" rel="stylesheet">

<!-- Custom Fonts -->
<link href="/vendor/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<link href="https://fonts.googleapis.com/css?family=Montserrat:400,700"
	rel="stylesheet" type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic"
	rel="stylesheet" type="text/css">

<link href="/css/login-navbar.css" rel="stylesheet">
<style>
/* Always set the map height explicitly to define the size of the div
       * element that contains the map. */
#map {
	height: 400px;
	width: 550px;
}
/* Optional: Makes the sample page fill the window. */
</style>
</head>

<body id="no-top">
	<div id="navbar"></div>
	<div class="signupForm">
		<h1 class="text-muted">${school.nom}</h1>
	</div>

	<div class="container">
		<div class="row">
			<div class="col-md-6">
				<div class="panel-group">
					<div class="panel panel-default">
						<div class="panel-heading">Informations sur ${school.nom}</div>
						<div class="panel-body">
							<div>Nom : ${school.nom}</div>
							<div>Adresse : ${school.adresse}</div>
							<div>Département : ${school.departement}</div>
							<div>Type d'étabissement : ${school.type_d_etablissement}</div>
							<div>Académie : ${school.academie}</div>
							<div>Sigle : ${school.sigle}</div>
							<div>
								Site internet : <a href="${school.lien_site_onisep_fr}"
									target="_blank">${school.lien_site_onisep_fr}</a>
							</div>
						</div>
					</div>
				</div>
				<div class="panel panel-default">
					<div class="panel-body">
						<div>Connaitre distance maison -> ecole TODO</div>
					</div>
				</div>
			</div>
			<div class="col-md-6">
				<div id="map"></div>
			</div>
		</div>

		<div class="row" style="margin-top: 30px;">
			<div class="col-md-12">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3>Avis</h3>
						<button type="button" class=" btn btn-primary "
							data-toggle="modal" data-target="#affluanceModal">Ajouter
							commentaire</button>
					</div>
					<div class="panel-body">
						<div class="list-group-item">
							<span class="label label-success "></span> <span
								class="commentaire">"Example commentaire"</span><span
								class="badge temps">15h15</span>
						</div>
						<div class="list-group-item">
							<span class="label label-primary"></span> <span
								class="commentaire">"Example commentaire"</span><span
								class="badge temps">12h02</span>
						</div>
					</div>
				</div>
			</div>
		</div>

	</div>

	<div id="footer"></div>

	<script src="/vendor/popper/popper.min.js"></script>
	<script src="/vendor/jquery/jquery.min.js"></script>
	<script src="/vendor/bootstrap/js/bootstrap.min.js"></script>
	<script src="/vendor/js/js.cookie.js"></script>
	<script>
		(function() {
			//  			$('#navbar').load("/html/navbar.html");
			// 			$('#footer').load("/html/footer.html");
		})();
	</script>
	<script>
		var map;
		function initMap() {
			map = new google.maps.Map(document.getElementById('map'), {
				center : {
					lat : -34.397,
					lng : 150.644
				},
				zoom : 12
			});
			var infoWindow = new google.maps.InfoWindow({
				map : map
			});

			if (navigator.geolocation) {
				navigator.geolocation.getCurrentPosition(function(position) {
					var pos = {
						lat : position.coords.latitude,
						lng : position.coords.longitude
					};

					infoWindow.setPosition(pos);
					infoWindow.setContent('Location found.');
					map.setCenter(pos);
				}, function() {
					handleLocationError(true, infoWindow, map.getCenter());
				});
			} else {
				handleLocationError(false, infoWindow, map.getCenter());
			}
		}

		function handleLocationError(browserHasGeolocation, infoWindow, pos) {
			infoWindow.setPosition(pos);
			infoWindow
					.setContent(browserHasGeolocation ? 'Error: The Geolocation service failed.'
							: 'Error: Your browser doesn\'t support geolocation.');
		}
	</script>
	<script
		src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCbgwCBsZf0bxYm-FbYX8ljeTtkajKnfv8&callback=initMap"
		async defer>
		
	</script>
</body>
</html>