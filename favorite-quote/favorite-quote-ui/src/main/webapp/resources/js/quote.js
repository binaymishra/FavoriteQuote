/**
 * Binay Mishra
 */
$(document).ready(function() {
	$('quote_button').click(function(event){
		event.defaultPrevented();
		alert('Button is clicked.')
	});
	
});

 function animation(){ 
	 var current = $('#quote .show'); 
	 var next =  current.next().length ? current.next() :current.siblings().first();
	 	current.hide()
	 		.removeClass('show'); 
	 	next.fadeIn()
	 		.addClass('show');
	 setTimeout(animation, 2000); 
 }
