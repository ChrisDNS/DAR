var map;
var callbackGoogleMaps = false;
// var callbackCodeAddress = false;

var home = {
	lat : "",
	lon : ""
};

var school = {
	lat : $('#lat').data('lat'),
	lon : $('#lon').data('lon')
}

function showGoogleMaps() {
	callbackGoogleMaps = true;
}

$(document).ready(function() {
	if (Cookies.get('email') == null || Cookies.get('email') == "") {
		alert("Vous n'êtes pas connecté.");
	} else
		codeAddress(Cookies.get('address'));

});

function codeAddress(address) {
	geocoder = new google.maps.Geocoder;
	geocoder.geocode({
		'address' : address

	}, function(results, status) {
		if (status == 'OK') {
			home.lat = results[0].geometry.location.lat();
			home.lon = results[0].geometry.location.lng();

			initMap(school);

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

function initMap(school) {
	var currentSchool = {
		lat : parseFloat(school.lat),
		lon : parseFloat(school.lon)
	};

	map = new google.maps.Map(document.getElementById('map'), {
		center : new google.maps.LatLng(school.lat, school.lon),
		zoom : 12
	});

	var infoWindow = new google.maps.InfoWindow({
		map : map
	});

	if (navigator.geolocation) {
		navigator.geolocation.getCurrentPosition(function(position) {
			var pos = {
				lat : school.lat,
				lng : school.lon
			};

			infoWindow.setPosition(pos);
			infoWindow.setContent('Lieu trouvé.');
			map.setCenter(pos);

			setMarker(home);
			setMarker(school);

			calculateDistance(new google.maps.LatLng(home.lat, home.lon),
					new google.maps.LatLng(school.lat, school.lon), 'WALKING');
			showDistance(new google.maps.LatLng(home.lat, home.lon),
					new google.maps.LatLng(school.lat, school.lon));

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
					'<strong>DE </strong>' + origin
							+ '<br><strong> A </strong>' + destination
							+ ' : <br>' + '<strong>'
							+ response.rows[0].elements[0].distance.text
							+ '<\strong>' + ' en : '
							+ $('#mode option:selected').val());
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

function successCallback(position) {
	map.panTo(new google.maps.LatLng(position.coords.latitude,
			position.coords.longitude));
	var marker = new google.maps.Marker({
		position : new google.maps.LatLng(position.coords.latitude,
				position.coords.longitude),
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