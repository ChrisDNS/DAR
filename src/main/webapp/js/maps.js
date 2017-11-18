var map;
var callbackGoogleMaps = false;

var home = {
	lat : "",
	lon : ""
};

var currentSchool = {
	lat : parseFloat($('#lat').data('lat')),
	lon : parseFloat($('#lon').data('lon'))
}

function showGoogleMaps() {
	callbackGoogleMaps = true;
}

$(document).ready(
function() {
	if (Cookies.get('email') == null || Cookies.get('email') == "") {
		alert('Vous n\'êtes pas connecté.');
		$("#output").html(
				'Vous devez être connecté pour accéder à ce service.');
		initMap(false);

	} else {
		if(Cookies.get('address') == null || Cookies.get('address') == "")
			initMap(false);
		else {
			codeAddress(Cookies.get('address'));
			$("#output").html('Vous n\'avez pas entré d\'adresse lors de votre inscription.');
		}
	}

});

function codeAddress(address) {
	geocoder = new google.maps.Geocoder;
	geocoder.geocode({
		'address' : address

	}, function(results, status) {
		if (status == 'OK') {
			home.lat = results[0].geometry.location.lat();
			home.lon = results[0].geometry.location.lng();

			initMap(true);

		} else
			alert('Le geocoding n\'a pas fonctionné: ' + status);
	});
}

function showDistance(origin, destination) {
	var directionsDisplay = new google.maps.DirectionsRenderer;
	var directionsService = new google.maps.DirectionsService;
	directionsDisplay.setMap(map);

	$('#mode').on(
			'change',
			function() {
				calculateAndDisplayRoute(origin, destination,
						directionsService, directionsDisplay);
			});
}

function initMap(bool) {
	map = new google.maps.Map(document.getElementById('map'), {
		center : new google.maps.LatLng(currentSchool.lat, currentSchool.lon),
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
			infoWindow.setContent('Lieu trouvé.');
			map.setCenter(pos);

			setMarker(home);
			setMarker(currentSchool);

			if (bool) {
				calculateDistance(new google.maps.LatLng(home.lat, home.lon),
						new google.maps.LatLng(currentSchool.lat,
								currentSchool.lon), 'WALKING');
				showDistance(new google.maps.LatLng(home.lat, home.lon),
						new google.maps.LatLng(currentSchool.lat,
								currentSchool.lon));
			}

		}, function() {
			handleLocationError(true, infoWindow, map.getCenter());
		});

	} else
		handleLocationError(false, infoWindow, map.getCenter());
}

function calculateDistance(from, to, mode) {
	var service = new google.maps.DistanceMatrixService;
	service.getDistanceMatrix({
		origins : [ from ],
		destinations : [ to ],
		travelMode : mode,
		unitSystem : google.maps.UnitSystem.METRIC,
		avoidHighways : false,
		avoidTolls : false

	}, function(response, status) {
		if (status !== 'OK')
			alert('Erreur : ' + status);

		else {
			var origin = response.originAddresses[0];
			var destination = response.destinationAddresses[0];
			$("#output").html(
					'<strong>DE </strong>' + origin + '<strong> A </strong>'
							+ destination + ' : <br>' + '<strong> Trajet : '
							+ response.rows[0].elements[0].distance.text
							+ ' <\strong>' + '('
							+ $('#mode option:selected').val() + ')'
							+ '<br> <strong>Temps : <\strong>'
							+ response.rows[0].elements[0].duration.text);
		}
	});
}

function calculateAndDisplayRoute(ori, dest, directionsService,
		directionsDisplay) {
	var selectedMode = $('#mode option:selected').val();

	directionsService.route({
		origin : {
			lat : ori.lat(),
			lng : ori.lng()
		},
		destination : {
			lat : dest.lat(),
			lng : dest.lng()
		},
		travelMode : google.maps.TravelMode[selectedMode]

	}, function(response, status) {
		if (status == 'OK') {
			calculateDistance(ori, dest, selectedMode);
			directionsDisplay.setDirections(response);

		} else
			window.alert('La reqûete des directions à échouer à cause de '
					+ status);
	});
}

function setMarker(place) {
	var marker = new google.maps.Marker({
		position : new google.maps.LatLng(place.lat, place.lon),
		map : map,
		animation : google.maps.Animation.DROP,
	});
}

function handleLocationError(browserHasGeolocation, infoWindow, pos) {
	infoWindow.setPosition(pos);
	infoWindow
			.setContent(browserHasGeolocation ? 'Erreur: le service de géolocalisation n\'a pas fonctionné.'
					: 'Erreur: votre navigateur ne supporte pas la géolocalisation.');
}