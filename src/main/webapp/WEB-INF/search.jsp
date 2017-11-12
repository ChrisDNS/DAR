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
<link href="css/search.css" rel="stylesheet">


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

<body id="page-top" class="index">

	<div id="navbar"></div>
	<div class="row">

		<section class="content">
			<div class="col-md-8 col-md-offset-2">
				<div class="panel panel-default">
					<div class="panel-body">

						<div class="pull-right">
							<div class="btn-group">
								<!-- 
								<button type="button" class="btn btn-success btn-filter"
									data-target="pagado">Par note</button>
									
									
								<button type="button" class="btn btn-warning btn-filter"
									data-target="pendiente">Pendiente</button>
								<button type="button" class="btn btn-danger btn-filter"
									data-target="cancelado">Cancelado</button>
								<button type="button" class="btn btn-default btn-filter"
									data-target="all">Todos</button>
									-->
									
									<form action="${pageContext.request.contextPath}/search" method="post">
  									 	 <input type="submit" name="button1" value="Button 1"class="btn btn-success btn-filter"
									data-target="pagado" />
    									 <input type="submit" name="button2" value="Button 2" class="btn btn-danger btn-filter"
									data-target="cancelado" />
   										 <input type="submit" name="button3" value="Button 3" class="btn btn-default btn-filter"
									data-target="all" />
									</form>
							</div>
						</div>

						<div class="table-container">
							<table class="table table-filter">
								<tbody>


									<c:forEach var="school" items="${schoolList}">
										<tr data-status="pagado">
											<td>
												<div class="ckbox">
													<input type="checkbox" id="checkbox1"> <label
														for="checkbox1"></label>
												</div>
											</td>
											<td><a href="javascript:;" class="star"> <i
													class="glyphicon glyphicon-star"></i>
											</a></td>
											<td>
												<div class="media">

													<div class="media-body">
														<span class="media-meta pull-right">Febrero 13,
															2016</span>
														<h4 class="title">
															${school.nom} <span class="pull-right pagado">(Pagado)</span>
														</h4>
														<p class="summary">${school.commune}</p>
														<p class="summary">${school.type_d_etablissement}</p>

													</div>
												</div>
											</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>

						<%--For displaying Previous link except for the 1st page --%>
						<c:if test="${currentPage != 1}">
							<td><a href="search?page=${currentPage - 1}">Previous</a></td>
						</c:if>

						<%--For displaying Page numbers. 
	The when condition does not display a link for the current page--%>
						<div class="table-container">
							<table class="table table-filter">
								<tbody>
									<tr>
										<c:forEach begin="1" end="${noOfPages}" var="i">
											<c:choose>
												<c:when test="${currentPage eq i}">
													<td>${i}</td>
												</c:when>
												<c:otherwise>
													<td><a href="search?page=${i}">${i}</a></td>
												</c:otherwise>
											</c:choose>
										</c:forEach>
									</tr>
								</tbody>
							</table>
						</div>

						<%--For displaying Next link --%>
						<c:if test="${currentPage lt noOfPages}">
							<td><a href="search?page=${currentPage + 1}">Next</a></td>
						</c:if>
					</div>
				</div>
			</div>
		</section>

	</div>

	<div id="footer"></div>

	<!-- jQuery -->
	<script src="vendor/jquery/jquery.min.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="vendor/bootstrap/js/bootstrap.min.js"></script>

	<script src="vendor/popper/popper.min.js"></script>
	<script src="vendor/js/js.cookie.js"></script>
	<script src="js/showNavbar.js"></script>
	<script src="js/showFooter.js"></script>
	<script src="js/search.js"></script>
</body>

</html>