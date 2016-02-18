// when click cart button in services, it changes the background color and when reverts, it reverts the background color again.
/*$("#add-to-cart1").click(function(){
     if($(this).hasClass("add-to-cart")){
         $(this).removeClass('add-to-cart').addClass('add-to-cart-click');
     }
     else if ($(this).hasClass("add-to-cart-click")){
          $(this).removeClass('add-to-cart-click').addClass('add-to-cart');
     }
     else {
         
     }
});*/

// ads column
if ($(window).width() <= 991) {
   $(".ads").addClass("col-sm-4 col-xs-6");
}

// translate
$("#translate-english").hide();

$("#translate-sinhala").click(function(){
    $("#translate-sinhala").hide();
    $("#translate-english").show();
});  

$("#translate-english").click(function(){
    $("#translate-english").hide();
    $("#translate-sinhala").show();
});
    
// remove background color of badget (top bar)    

$(document).ready(function(e) {
    //e.preventDefault();
	//open calculator dropdown when click calculator budget button

});
//close topbar when select an item (991px below)
var window_width = $(window).width();
if(window_width < 768) {
    $('.dropdown-menu,.dropdown .caret').hide();
    $('.navbar-collapse a, .nav-cart, .btn-ad-top').click(function(){
        $(".navbar-collapse").collapse('hide');
    });  
    $('.change-link').click(function(){
        $(this).attr('href','#portfolio').removeAttr('data-toggle aria-haspopup'); 
    });
}



                         
