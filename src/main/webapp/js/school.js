var $star_rating = $('.star-rating .fa');

var data = {
	uai : $('#uai').data('uai'),
	action : ""
}

/**
 * Sets rating stars.
 */
var setRatingStar = function() {
	return $star_rating
			.each(function() {
				if (parseInt($star_rating.siblings('input.rating-value').val()) >= parseInt($(
						this).data('rating')))
					return $(this).removeClass('fa-star-o').addClass('fa-star');
				else
					return $(this).removeClass('fa-star').addClass('fa-star-o');
			});
};

/**
 * Adds school to user favourites.
 *
 * @param data
 * @returns
 */
function addToFav(data) {	
	$.ajax({
		type : 'POST',
		url : '/set_favourite',
		data : data
		
	}).done(function(data) {
		alert("Ajouté aux favoris.");
		$('#fav_span').data('action', 'fav');
		$('#fav_span').removeClass('fa-star-o');
		
	}).fail(function() {
		alert("Le serveur ne répond pas.");
	});
}

/**
 * Deletes school from user favourites.
 * 
 * @param data
 * @returns
 */
function deleteFromFav(data) {
	$.ajax({
		type : 'POST',
		url : '/set_favourite',
		data : data
		
	}).done(function(data) {
		alert("Supprimé des favoris.");
		$('#fav_span').data('action', 'not_fav');
		$('#fav_span').removeClass("fa-star");

	}).fail(function() {
		alert("Le serveur ne répond pas.");
	});
}

/**
 * Checks if school is in user favourites.
 * 
 * @param data
 * @returns
 */
function isInFav(data) {
	$.ajax({
		type : 'POST',
		url : '/set_favourite',
		data : data
		
	}).done(function(data) {		
		if(data.success) {
			$('#fav_span').data('action', 'fav');
			$('#fav_span').addClass('active-3');
			$('#fav_span').addClass('fa-star');
			$('#fav_span').removeClass('fa-star-o');
			console.log("oui");
			
		} else {
			$('#fav_span').data('action', 'not_fav');
			$('#fav_span').removeClass("fa-star");
			console.log("non");

		}

	}).fail(function() {
		alert("Vous n'êtes pas connecté.");
	});
}

$(document).ready(function() {
	if(Cookies.get('email') == null || Cookies.get('email') == "") {
		$('#leave_comment').hide();
		$('#fav_button').hide();
	} else
		isInFav(data);
		
	setRatingStar();
	
	var ratingStarValue = $star_rating.siblings('input.rating-value').val();
	$star_rating.on('click', function() {
		ratingStarValue = $(this).data('rating');
		$star_rating.siblings('input.rating-value').val($(this).data('rating'));
		
		return setRatingStar();
	});

	$('#send_comment').click(function(e) {
		e.preventDefault();
		
		$.ajax({
			type : 'POST',
			url : '/leave_comment',
			data : {
				comment : $('#comment').val(),
				rating : ratingStarValue,
				uai : $('#uai').data('uai'),
			}

		}).done(function(data) {
			location.reload();
			
		}).fail(function() {
			alert("Le serveur ne répond pas.");
		});
	});
	
	$('#fav_button').click(function(e) {
		e.preventDefault();
		if ($('#fav_span').hasClass("fa-star")) {
				$('#fav_span').removeClass('active')
			setTimeout(function() {
				$('#fav_span').removeClass('active-2')
			}, 30)
				$('#fav_span').removeClass('active-3')
			setTimeout(function() {
				$('#fav_span').removeClass('fa-star')
				$('#fav_span').addClass('fa-star-o')
			}, 15)
			
			data.action = 'not_fav';
			deleteFromFav(data);
									
		} else {
			$('#fav_span').addClass('active');
			$('#fav_span').addClass('active-2');
			setTimeout(function() {
				$('#fav_span').addClass('fa-star')
				$('#fav_span').removeClass('fa-star-o')
			}, 150)
			setTimeout(function() {
				$('#fav_span').addClass('active-3')
			}, 150)
			
			data.action = 'fav';
			addToFav(data);
		}
	})
});