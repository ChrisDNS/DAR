var $star_rating = $('.star-rating .fa');

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

$(document).ready(function() {		
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
});