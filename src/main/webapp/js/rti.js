

var orientation;
var eventType;
var TEVENT=null;
var screenWidth = 0;
var screenHeight = 0;
var previouseScrollTime = 0;
var previouseTouchTime = 0;
var coordinateX = 0;
var coordinateY = 0;

$(document).ready(function() {
	needed();
});


function needed(){
	screenWidth = screen.width;
	screenHeight = screen.height;
}

function getLeftRightClick(e) {
	if(e.which == 1) {
		coordinateX = e.screenX;
		coordinateY = e.screenY;
		eventType = "LC";

		setTimeout(function(){
			if(eventType == "LC") {
				sendEventDetailsToController();
			}
	    },1000);
	}
	if(e.which == 2) {
		
	}
	if(e.which == 3 || e.which == null) {
		coordinateX = e.screenX;
		coordinateY = e.screenY;
		eventType = "RC";
		sendEventDetailsToController();
	}
}

$(document).dblclick(function(e){
	eventType = "DC";
	
	coordinateX = e.screenX;
	coordinateY = e.screenY;
	sendEventDetailsToController();
});

$(document).on('touchstart', function(e){
	TEVENT = e;
	
	var currentTouchTime = Date.now();
	var touchTimeDiffer = (currentTouchTime - previouseTouchTime);

	if(touchTimeDiffer < 400) {
		eventType = "TZE";
		coordinateX = e.originalEvent.touches[0].clientX;
		coordinateY = e.originalEvent.touches[0].clientY;
		sendEventDetailsToController();
	} else {
		eventType = "TE";
		coordinateX = e.originalEvent.touches[0].clientX;
		coordinateY = e.originalEvent.touches[0].clientY;
		setTimeout(function(){
			if(eventType == "TE") {
				sendEventDetailsToController();
			}
	    },500);
	}
	previouseTouchTime = currentTouchTime;
});
$(document).on('mousedown',function(e){
	if(TEVENT == null) {
		eventType = e.type;
		getLeftRightClick(e);
	} else{
		TEVENT = null;
	}
});

$(window).on("orientationchange",function(event){
	  orientation = event.orientation;
});

function scrolled() {
	var currentScrollTime = Date.now();
	if(eventType != "TZE") {
		eventType = "SE";
		var timeDiffer= (currentScrollTime-previouseScrollTime);
		if(timeDiffer > 100) {
			coordinateX = 0;
			coordinateY = 0;
			sendEventDetailsToController();
		}
		previouseScrollTime = currentScrollTime;
	}
	
}

$(window).on('scroll',scrolled);

$(document).keypress(function(e) {
	if(e.which == 45) { //firefox
		eventType = "DZE";
		
	} else if( e.which == 43) {//firefox
		eventType = "DZE";
		
	} else {
		eventType = "KP";
	}
	sendEventDetailsToController();
});

var getCurrentTime=function() {
	var d = new Date();
	  var hours = d.getHours();
	  var minutes = d.getMinutes();
	  var seconds = d.getSeconds();
	  var ampm = hours >= 12 ? 'pm' : 'am';
	  hours = hours % 12;
	  hours = hours ? hours : 12; // the hour '0' should be '12'
	  minutes = minutes < 10 ? '0'+minutes : minutes;
	  var strTime = hours + ':' + minutes + ':'+seconds + ' ' + ampm;
	  return strTime;
}


function sendEventDetailsToController () {
	var eventTriggeredTime = getCurrentTime();
	screenHeight = screen.height;
	screenWidth = screen.width;
	var sessionID = sessionStorage.getItem('sessionID');
	
	console.log("Host name :"+document.location.hostname);
	console.log("Protocol :"+document.location.protocol);
	console.log("Port :"+document.location.port);
	
	$.post('http://aurorarti.herokuapp.com/postEventDetails', {
		eventType : eventType,
		coordinateX : coordinateX,
		coordinateY : coordinateY,
		screenHeight : screenHeight,
		screenWidth : screenWidth,
		orientation : orientation,
		sessionID : sessionID,
		eventTriggeredTime : eventTriggeredTime
	}, function(data) {
		if (data.status == 'success') {
			if(data.result !=  null) {
				sessionStorage.setItem('sessionID', data.result);
			}
			
		} else {
			console.log(data.status);
		}
	});
}