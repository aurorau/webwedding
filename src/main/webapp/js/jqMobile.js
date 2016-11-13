var eventType = -1;

$(document).on("pagecreate","#page-top",function(){
  $("div").on("click",function(){
	  eventType = "LC"
  });        
  
  $("div").on("tap",function(){
	  eventType="TAP";
  }); 
  
});

function sendEventDetailsToController () {
	var eventType = null;
	$.post('http://192.168.1.2:8088/RealTimeInvestigator/api/postEventDetails', {
		eventType : eventType
	}, function(data) {
		if (data.status == 'success') {
			
		} else {
			console.log(data.status);
		}
	});
}