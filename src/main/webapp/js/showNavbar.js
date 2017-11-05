(function() {
	var email = Cookies.get('email');
	if (email == null || email == "")
		$("#navbar").load("html/navbar.html");
	else
		$("#navbar").load("html/navbarConnected.html");
})();