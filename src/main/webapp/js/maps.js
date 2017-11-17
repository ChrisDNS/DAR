var map;
var callbackGoogleMaps = false;
var home = {
	lat : "",
	lon : ""
};

function showGoogleMaps() {
	callbackGoogleMaps = true;
}

$(document).ready(function() {
	var school = {
		lat : $('#lat').data('lat'),
		lon : $('#lon').data('lon')
	}

	if (callbackGoogleMaps)
		initMap(school);
});

function codeAddress(address) {
	geocoder = new google.maps.Geocoder;
	geocoder.geocode({
		'address' : address

	}, function(results, status) {
		if (status == 'OK') {
			home.lat = results[0].geometry.location.lat();
			home.lon = results[0].geometry.location.lng();

			setMarker(home);

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
				lat : position.coords.latitude,
				lng : position.coords.longitude
			};

			infoWindow.setPosition(pos);
			infoWindow.setContent('Lieu trouvé.');
			map.setCenter(pos);

			setMarker(school);
			codeAddress(Cookies.get('address'));

			distance(new google.maps.LatLng(48.891304999, 2.3529866999),
					new google.maps.LatLng(school.lat, school.lon));
			
			showDistance(new google.maps.LatLng(48.891304999, 2.3529866999), new google.maps.LatLng(school.lat, school.lon));

		}, function() {
			handleLocationError(true, infoWindow, map.getCenter());
		});

	} else
		handleLocationError(false, infoWindow, map.getCenter());
}

function distance(from, to) {
	var service = new google.maps.DistanceMatrixService;
	service.getDistanceMatrix({
		origins : [ from ],
		destinations : [ to ],
		travelMode : 'WALKING',
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
					'de ' + origin + ' à ' + destination + ' : '
							+ response.rows[0].elements[0].distance.text);
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
			directionsDisplay.setDirections(response);
		} else {
			window.alert('Directions request failed due to ' + status);
		}
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