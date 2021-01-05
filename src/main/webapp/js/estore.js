$(function(){
	$('.carousel').carousel({

		interval: 3000

	})
	$('.collapse').first().removeClass('on');
	$('.collapse').first().addClass('in');
	
	$('.body .menu ul li').click(function(){
		$('.collapse').removeClass('in');
		var text=$(this).attr('herf');
		$(text).addClass('in');
	});
	$('.booknum').on('click',function(event){
		console.log('start');
		if($(event.target).is($('.add'))) {
			var value=$(this).find('.value');
			var num=parseInt(value.text());
			value.text(num+1);
			
		}else if($(event.target).is($('.sub'))) {
			var value=$(this).find('.value');
			var num=parseInt(value.text());
			value.text(num-1);
			
		}
	});
	$('.viewbook .book-message #box dd').click(function(){
		$('.viewbook .book-message #box dd').removeClass('active');
		$(this).addClass('active');
	});
	$('#typeMenu').collapse('hide')
	
})

