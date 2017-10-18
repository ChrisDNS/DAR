(function() {
	var login = Cookies.get('login');
	if (login == null || login == "")
		$("#navbar").load("html/navbar.html");
	else
		$("#navbar").load("html/navbarConnected.html");
})();