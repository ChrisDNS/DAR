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
							<div class="row">
								<div id="custom-search-input">
									<div class="input-group col-md-12">
										<form action="${pageContext.request.contextPath}/search"
											method="get" role="search"
											style="width: 15em; margin: 0.3em 2em;">
											<div class="input-group">
												<input type="text" name="searchValue" class="form-control"
													placeholder="search">
												<div class="input-group-btn">
													<button type="submit" name="search" value="search"
														class="btn btn-default">
														<span class="glyphicon glyphicon-search"></span>
													</button>
												</div>
											</div>
										</form>
									</div>
								</div>
							</div>
						</div>

						<div class="container">
							<div class="btn-group">
								<form id="search_form" action="search" method="get">
									<p>Trier par :</p>
									<input type="submit" name="filter" value="alpha"
										class="btn btn-success btn-filter" data-target="pagado" /> <input
										type="submit" name="filter" value="note"
										class="btn btn-danger btn-filter" data-target="cancelado" />
									<p>Type d'établissement :</p>
									<input type="submit" name="filter" value="ecoles"
										class="btn btn-success btn-filter" data-target="pagado" /> <input
										type="submit" name="filter" value="instituts"
										class="btn btn-danger btn-filter" data-target="cancelado" />
									<input type="submit" name="filter" value="ufr"
										class="btn btn-success btn-filter" data-target="pagado" /> <input
										type="submit" name="filter" value="autre"
										class="btn btn-danger btn-filter" data-target="cancelado" />
								</form>
							</div>
						</div>

						<div class="table-container">
							<table class="table table-filter">
								<tbody>
									<c:set var="count" value="0" scope="page" />
									<c:forEach var="school" items="${schoolList}">
										<c:set var="count" value="${count + 1}" scope="page" />
										<tr data-status="pagado">
											<td><c:choose>
													<c:when test="${school.value < 1}">
														<div class="pull-left">
															<div class="pull-left"
																style="width: 35px; line-height: 1;">
																<div style="height: 9px; margin: 5px 0;">
																	1 <span class="glyphicon glyphicon-star"></span>
																</div>
															</div>
															<div class="pull-left" style="width: 180px;">
																<div class="progress"
																	style="height: 9px; margin: 8px 0;">
																	<div class="progress-bar progress-bar-danger"
																		role="progressbar" aria-valuenow="1" aria-valuemin="0"
																		aria-valuemax="5" style="width: 20%">
																		<span class="sr-only">80% Complete (danger)</span>
																	</div>
																</div>
															</div>

														</div>
														<br />
													</c:when>
													<c:when test="${school.value < 2 && school.value > 1}">
														<div class="pull-left">
															<div class="pull-left"
																style="width: 35px; line-height: 1;">
																<div style="height: 9px; margin: 5px 0;">
																	2 <span class="glyphicon glyphicon-star"></span>
																</div>
															</div>
															<div class="pull-left" style="width: 180px;">
																<div class="progress"
																	style="height: 9px; margin: 8px 0;">
																	<div class="progress-bar progress-bar-warning"
																		role="progressbar" aria-valuenow="2" aria-valuemin="0"
																		aria-valuemax="5" style="width: 40%">
																		<span class="sr-only">80% Complete (danger)</span>
																	</div>
																</div>
															</div>

														</div>

													</c:when>
													<c:when test="${school.value < 3 && school.value > 2 }">
														<div class="pull-left">
															<div class="pull-left"
																style="width: 35px; line-height: 1;">
																<div style="height: 9px; margin: 5px 0;">
																	3 <span class="glyphicon glyphicon-star"></span>
																</div>
															</div>
															<div class="pull-left" style="width: 180px;">
																<div class="progress"
																	style="height: 9px; margin: 8px 0;">
																	<div class="progress-bar progress-bar-info"
																		role="progressbar" aria-valuenow="3" aria-valuemin="0"
																		aria-valuemax="5" style="width: 60%">
																		<span class="sr-only">80% Complete (danger)</span>
																	</div>
																</div>
															</div>

														</div>

													</c:when>
													<c:when test="${school.value < 4 && school.value > 3 }">
														<div class="pull-left">
															<div class="pull-left"
																style="width: 35px; line-height: 1;">
																<div style="height: 9px; margin: 5px 0;">
																	4 <span class="glyphicon glyphicon-star"></span>
																</div>
															</div>
															<div class="pull-left" style="width: 180px;">
																<div class="progress"
																	style="height: 9px; margin: 8px 0;">
																	<div class="progress-bar progress-bar-primary"
																		role="progressbar" aria-valuenow="4" aria-valuemin="0"
																		aria-valuemax="5" style="width: 80%">
																		<span class="sr-only">80% Complete (danger)</span>
																	</div>
																</div>
															</div>

														</div>

													</c:when>

													<c:otherwise>
														<div class="pull-left">
															<div class="pull-left"
																style="width: 35px; line-height: 1;">
																<div style="height: 9px; margin: 5px 0;">
																	5 <span class="glyphicon glyphicon-star"></span>
																</div>
															</div>
															<div class="pull-left" style="width: 180px;">
																<div class="progress"
																	style="height: 9px; margin: 8px 0;">
																	<div class="progress-bar progress-bar-success"
																		role="progressbar" aria-valuenow="5" aria-valuemin="0"
																		aria-valuemax="5" style="width: 1000%">
																		<span class="sr-only">80% Complete (danger)</span>
																	</div>
																</div>
															</div>

														</div>
													</c:otherwise>
												</c:choose></td>
											<td>
												<div class="media">
													<h4 class="title">
														<a id="show_school" href="search?id=${school.key.id}">${school.key.nom}</a>
													</h4>
													<p class="summary">${school.key.commune}</p>
													<p class="summary">${school.key.type_d_etablissement}</p>
													<p class="summary">${school.key.universite}</p>

												</div>
											</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>

						<%--For displaying Previous link except for the 1st page --%>
						<form action="${pageContext.request.contextPath}/search"
							method="get">
							<c:if test="${currentPage != 1}">
								<td><a href="search?page=${currentPage - 1}">Previous</a></td>
							</c:if>
						</form>

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
													<form action="${pageContext.request.contextPath}/search"
														method="get">
														<input type="submit" name="page" value="${i}" />
														<%-- <a href="search?page=${i}">${i}</a> --%>
													</form>
												</c:otherwise>
											</c:choose>
										</c:forEach>
									</tr>
								</tbody>
							</table>
						</div>

						<%--For displaying Next link --%>
						<form action="${pageContext.request.contextPath}/search"
							method="get">
							<c:if test="${currentPage lt noOfPages}">
								<input type="submit" name="page" value="${currentPage + 1}" />

								<%--<td><a href="search?page=${currentPage + 1}">Next</a></td>--%>
							</c:if>
						</form>
					</div>
				</div>
			</div>
		</section>

	</div>

	<div id="footer"></div>

	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.min.js"></script>
	<script src="vendor/popper/popper.min.js"></script>
	<script src="vendor/js/js.cookie.js"></script>
	<script src="js/showNavbar.js"></script>
	<script src="js/showFooter.js"></script>
</body>

</html>