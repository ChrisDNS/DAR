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

<link href="css/login-navbar.css" rel="stylesheet">
</head>

<body id="no-top">

	<div id="navbar"></div>

	<div class="signupForm">
		<h1 class="text-muted">
			<c:choose>
				<c:when test="${user==null}">
			        Inscription
			    </c:when>
				<c:otherwise>
			        Mon compte
			    </c:otherwise>
			</c:choose>
		</h1>
		<form class="form-horizontal">
			<div class="form-group">
				<label class="control-label col-sm-5" for="firstName">Prénom:</label>
				<div class="col-sm-3">
					<c:choose>
						<c:when test="${user==null}">
							<c:set value="" var="firstName"></c:set>
						</c:when>
						<c:otherwise>
							<c:set value="${user.firstname}" var="firstName"></c:set>
						</c:otherwise>
					</c:choose>
					<input type="text" class="form-control" id="firstName"
						placeholder="Entrer votre prénom" value="${firstName}">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-5" for="name">Nom:</label>
				<div class="col-sm-3">
					<c:choose>
						<c:when test="${user==null}">
							<c:set value="" var="lastName"></c:set>
						</c:when>
						<c:otherwise>
							<c:set value="${user.lastname}" var="lastName"></c:set>
						</c:otherwise>
					</c:choose>
					<input type="text" class="form-control" id="name"
						placeholder="Entrer votre nom" value="${lastName}">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-5" for="mail">Email:</label>
				<div class="col-sm-3">
					<c:choose>
						<c:when test="${user==null}">
							<c:set value="" var="email"></c:set>
						</c:when>
						<c:otherwise>
							<c:set value="${user.email}" var="email"></c:set>
						</c:otherwise>
					</c:choose>
					<input type="email" class="form-control" id="mail"
						placeholder="Entrer votre adresse électronique" value="${email}">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-5" for="confmail">Confirmation
					de l'email:</label>
				<div class="col-sm-3">
					<input type="email" class="form-control" id="confmail"
						placeholder="Confirmer votre adresse électronique"
						value="${email}">
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
				<label class="control-label col-sm-5" for="confpwd">Confirmation
					du mot de passe:</label>
				<div class="col-sm-3">
					<input type="password" class="form-control" id="confpwd"
						placeholder="Confirmer votre mot de passe">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-5" for="address">Adresse:*</label>
				<div class="col-sm-3">
					<c:choose>
						<c:when test="${user==null}">
							<c:set value="" var="address"></c:set>
						</c:when>
						<c:otherwise>
							<c:set value="${user.address}" var="address"></c:set>
						</c:otherwise>
					</c:choose>
					<input type="text" class="form-control" id="address"
						placeholder="Entrer votre addresse" value="${address}">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-5" for="town">Ville:*</label>
				<div class="col-sm-3">
					<c:choose>
						<c:when test="${user==null}">
							<c:set value="" var="town"></c:set>
						</c:when>
						<c:otherwise>
							<c:set value="${user.town}" var="town"></c:set>
						</c:otherwise>
					</c:choose>
					<input type="text" class="form-control" id="town"
						placeholder="Entrer votre ville" value="${town}">
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-12">
					<label class="control-label col-sm-5">Anciennes et / ou
						récente(s) école(s) fréquentée(s):*</label>
					<div class="col-sm-3" style="text-align: left;">
						<select class="fixed-size" id="allSchoolsList" name="school">
							<c:forEach items="${schools}" var="school">
								<option value="${school.id}"><c:out value="${school}" /></option>
							</c:forEach>
						</select>
						<button onclick="addSchool()" type="button"
							class="btn btn-primary">Ajouter</button>
						<div>
							<p id="schoolsp">Liste complète :</p>
							<ul class="list-group" id="schoolsList"></ul>
						</div>
					</div>
				</div>
			</div>
			<c:if test="${user}==null">
				<div class="form-group">
					<div class="col-sm-11">
						<div class="checkbox">
							<label><input type="checkbox"> Se souvenir</label>
						</div>
					</div>
				</div>
			</c:if>
			<p class="text-warning signupInfos">Les champs * sont optionnels
				mais serviront à perfectionner vos recherches et/ou relations avec
				les autres étudiants.</p>
			<p class="text-warning signupInfos">Les anciennes et / ou
				récente(s) école(s) fréquentée(s) vous feront automatiquement
				rejoindre les réseaux associés.</p>
			<div id="error"
				style="text-align: center; display: none; color: red;"
				class="alert alert-error"></div>
			<div class="form-group">
				<div class="col-sm-12">
					<c:choose>
						<c:when test="${user==null}">
							<button id="sign" type="submit" class="btn btn-success">Inscription</button>
						</c:when>
						<c:otherwise>
							<button id="modify" type="submit" class="btn btn-success">Modifier</button>
						</c:otherwise>
					</c:choose>
				</div>
			</div>
		</form>
	</div>

	<div id="footer"></div>

	<script src="vendor/popper/popper.min.js"></script>
	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.min.js"></script>
	<script src="vendor/js/js.cookie.js"></script>
	<script src="js/showNavbar.js"></script>
	<script src="js/showFooter.js"></script>

	<script type="text/javascript">		
		var schools = [
		    <c:forEach items="${selectedSchools}" var="schoole" varStatus="status">
		    	'${schoole.idSchool}' <c:if test="${!status.last}">,</c:if>
		    </c:forEach>
		];
	</script>

	<script src="js/signup.js"></script>
</body>
</html>