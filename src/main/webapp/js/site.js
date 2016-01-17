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
if ($(window).width() < 991) {
   $(".ads").addClass("col-sm-4");
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
});



                         
