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
<link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- Theme CSS -->
<link href="css/freelancer.min.css" rel="stylesheet">
<link href="css/freelancer.css" rel="stylesheet">
<link href="css/star-rating.css" rel="stylesheet">

<!-- Custom Fonts -->
<link href="vendor/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<link href="https://fonts.googleapis.com/css?family=Montserrat:400,700"
	rel="stylesheet" type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic"
	rel="stylesheet" type="text/css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">


<link href="css/login-navbar.css" rel="stylesheet">
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
							<div id="uai" data-uai="${school.code_uai}">Code UAI :
								${school.code_uai}</div>
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
							data-toggle="modal" data-target="#commentModal">Laisser
							votre avis</button>
					</div>
					<div class="panel-body">
						<c:forEach var="rating" items="${ratings}">
							<div class="list-group-item"
								style="margin-top: 5px; margin-bottom: 5px">
								<span class="label label-success "></span> <span
									class="commentaire"><strong>${cookie.firstname.value}
										: </strong></span><span class="commentaire">${rating.comment}</span>
								<c:forEach var='i' begin='${rating.rating+1}' end='5'>
									<span class="fa fa-star-o" style="float: right;"></span>
								</c:forEach>
								<c:forEach var='i' begin='1' end='${rating.rating}'>
									<span class="fa fa-star" style="float: right;"></span>
								</c:forEach>
								<span class="badge temps">${rating.date}</span>
							</div>
						</c:forEach>
					</div>
				</div>
			</div>
		</div>

		<div id="commentModal" class="modal fade" role="dialog">
			<div class="modal-dialog modal-lg">

				<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">Laisser votre avis</h4>
					</div>
					<div class="modal-body">
						<form action="leave_comment">
							<div class="form-group">
								<label for="message-text" class="form-control-label">Note
									:</label>
								<div class="star-rating">
									<span class="fa fa-star-o" data-rating="1"></span> <span
										class="fa fa-star-o" data-rating="2"></span> <span
										class="fa fa-star-o" data-rating="3"></span> <span
										class="fa fa-star-o" data-rating="4"></span> <span
										class="fa fa-star-o" data-rating="5"></span> <input
										id="rating" type="hidden" name="whatever1"
										class="rating-value" value="3">
								</div>
							</div>
							<div class="form-group">
								<label for="message-text" class="form-control-label">Commentaire
									:</label>
								<textarea id="comment" class="form-control"></textarea>
							</div>
						</form>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">Fermer</button>
						<button id="send_comment" type="button" class="btn btn-primary"
							data-dismiss="modal">Valider</button>
					</div>
				</div>

			</div>
		</div>
	</div>

	<div id="footer"></div>

	<script src="vendor/popper/popper.min.js"></script>
	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.min.js"></script>
	<script src="vendor/js/js.cookie.js"></script>
	<script src="js/showNavbar.js"></script>
	<script src="js/showFooter.js"></script>
	<script src="js/school.js"></script>
	<script src="js/maps.js"></script>
	<script
		src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCbgwCBsZf0bxYm-FbYX8ljeTtkajKnfv8&callback=initMap"
		async defer>
		
	</script>
</body>
</html>