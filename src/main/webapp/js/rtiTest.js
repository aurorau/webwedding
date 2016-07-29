
var orientation=-1;
var eventType = -1;
var getScreenWidth=0;
var getScreenHeight=0;
var previouseScrollTime = 0;
var previouseTouchTime = 0;
var previouseClickTime = 0;
var previouseSwapTime = 0;
var coordinateX = 0;
var coordinateY = 0;
var getBrowserWidth=0;
var getBrowserHeight=0;
var tagName = -1;
var elementId = -1;
var elementClass = -1;
var elementHeight = -1;
var elementWidth = -1;
var elementOffsetTop = -1;
var elementOffsetLeft = -1;
var numberOfFingers = 0;
var zoomEvent = -1;
var scrollTopPx=-1;
var elementScrollTop = -1;
var viewportHeight = -1;
var viewportWidth = -1;
var timeZoneOffset = -1;
var globalEventType= -1;
var imageName = -1;

$(document).ready(function() {
	clearValues();
	eventType = "RF";
	numberOfFingers = 0;
	sendEventDetailsToController();
	setInterval(function(){ 
		//heartBeat();
	},20000);
});

function heartBeat(){
	var sessionID = -1;
	sessionID = sessionStorage.getItem('sessionID');
	setTimeZoneInCookie();
	$.get('http://192.168.1.2:8088/RealTimeInvestigator/api/heartBeat', {
		sessionID : sessionID,
		timeZoneOffset : timeZoneOffset
	}, function(data) {
		console.log(data.status);
	});
}

function identifyDeviceWidthHeight(){
	var deviceMinWidthStatus = window.matchMedia('(min-device-width: '+screen.width+'px)').matches;
	var deviceMinHeightStatus = window.matchMedia('(min-device-height:'+screen.height+'px)').matches;
	
	var deviceMaxWidthStatus = window.matchMedia('(max-device-width: '+screen.width+'px)').matches;
	var deviceMaxHeightStatus = window.matchMedia('(max-device-height:'+screen.height+'px)').matches;
	
	var orientationLand  = window.matchMedia("(orientation: landscape)").matches;

	//for laptop and Desktop
	if((screen.width > screen.height) && orientationLand){
		if(deviceMinWidthStatus && deviceMaxWidthStatus && deviceMinHeightStatus && deviceMaxHeightStatus){
			getProperHeightWidth();
		} else {
			getFraudHeightWidth("mx");
		}
	} else if((screen.width < screen.height) && !orientationLand){
		if(deviceMinWidthStatus && deviceMaxWidthStatus && deviceMinHeightStatus && deviceMaxHeightStatus){
			getProperHeightWidth();
		} else {
			getFraudHeightWidth("mx");
		}

	} else {
		getFraudHeightWidth("s");
	}

	//for tablet and mobile
	if((screen.width < screen.height) && !orientationLand){
		if(deviceMinWidthStatus && deviceMaxWidthStatus && deviceMinHeightStatus && deviceMaxHeightStatus){
			getProperHeightWidth();
		} else {
			getFraudHeightWidth("mx");
		}
	}
	viewportHeight =window.innerHeight;
	viewportWidth = window.innerWidth;
}

function getProperHeightWidth(){
	getScreenWidth = screen.width;
	getScreenHeight = screen.height;
}

function getFraudHeightWidth(status){
	getScreenWidth = -100;
	getScreenHeight = -100;
}

$(document).on('touchstart', function(e){
	eventType = "TS";
	coordinateX = Math.round(e.originalEvent.touches[0].clientX);
	coordinateY = Math.round(e.originalEvent.touches[0].clientY);
	eventTriggredPositionDetails(e);
	sendEventDetailsToController();
});

$(document).on('touchmove', function(e){
	eventType = "TM";
	coordinateX = Math.round(e.originalEvent.touches[0].clientX);
	coordinateY = Math.round(e.originalEvent.touches[0].clientY);
	eventTriggredPositionDetails(e);
	sendEventDetailsToController();
});

$(document).on('touchend', function(e){
	eventType = "TE";
	coordinateX = Math.round(e.originalEvent.touches[0].clientX);
	coordinateY = Math.round(e.originalEvent.touches[0].clientY);
	eventTriggredPositionDetails(e);
	sendEventDetailsToController();
});

$(document).on('click', function(e){
	eventType = "LC";
	coordinateX = Math.round(e.clientX);
	coordinateY = Math.round(e.clientY);
	eventTriggredPositionDetails(e);
	sendEventDetailsToController();
});

$(document).on('scroll',function(e){
	
	var currentScrollTime = Date.now();

	numberOfFingers = 0;
	if(e.originalEvent.touches) {
		numberOfFingers = e.originalEvent.touches.length;
	}
	scrollTopPx = $(window).scrollTop();
	//if(globalEventType != 'TS' && globalEventType != 'TM' && globalEventType != "STZE" && globalEventType != "TZE" ){
		setScroll(currentScrollTime);
	//} 
});
function setScroll(currentScrollTime){
	var timeDiffer= (currentScrollTime-previouseScrollTime);
	if(timeDiffer > 100) {
		coordinateX = 0;
		coordinateY = 0;
		//globalEventType = "SE";
		eventType = "SE";
		sendEventDetailsToController();
	}
	previouseScrollTime = currentScrollTime;
}

$(document).keypress(function(e) {
	eventType = "KP";
	coordinateX = Math.round(e.clientX);
	coordinateY = Math.round(e.clientY);
	eventTriggredPositionDetails(e);
	sendEventDetailsToController();
});


function eventTriggredPositionDetails(e){
	var name = e.target.tagName;
	var id =  e.target.id;
	var clz = $(e.target).attr('class');
	if(name == "IMG"){
		imageName = $(e.target).attr('src');
	}
	if(id == null || id == ''){
		var ran =  Math.floor((Math.random() * 15 + 0));
		$(e.target).attr('id',name+'_RAN_'+ran);
	}
	
	if(document.getElementById(e.target.id).getBoundingClientRect()) {
		var rect = document.getElementById(e.target.id).getBoundingClientRect();
	}
	var attibuteList = e.target.attributes;
	var index =0;
	
	tagName = name;
	
	elementId = e.target.id;
	elementClass = $(e.target).attr('class');
	elementHeight = rect.height;
	elementWidth = rect.width;
	elementOffsetTop = rect.top;
	elementOffsetLeft = rect.left;
	
	var x = $("#"+e.target.id).offset();
	elementScrollTop = Math.round(x.top);
}

$(window).on("orientationchange",function(event){
	  orientation = event.orientation;
});

var getCurrentTime=function() {
	var d = new Date();
	  var year = d.getFullYear();
	  var month = d.getMonth() + 1;
	  var day = d.getDate();
	  var hours = d.getHours();
	  var minutes = d.getMinutes();
	  var seconds = d.getSeconds();
	  var milSec = d.getMilliseconds(); 
	  minutes = minutes < 10 ? '0'+minutes : minutes;
	  var strTime = year +'-'+month+'-'+day+' ' +hours + ':' + minutes + ':'+seconds+'.'+milSec;
	  return strTime;
}


function sendEventDetailsToController () {

	var eventTriggeredTime = getCurrentTime();
	var sessionID = sessionStorage.getItem('sessionID');
	identifyDeviceWidthHeight();
	screenHeight = getScreenHeight;
	screenWidth = getScreenWidth;
	setTimeZoneInCookie();
	var country = "America/Los_Angeles";
	//http://aurorarti.herokuapp.com
	//http://192.168.1.2:8088/RealTimeInvestigator
	$.post('http://192.168.1.2:8088/RealTimeInvestigator/api/postEventDetails', {
		eventType : eventType,
		coordinateX : coordinateX,
		coordinateY : coordinateY,
		screenHeight : screenHeight,
		screenWidth : screenWidth,
		orientation : orientation,
		sessionID : sessionID,
		tagName : tagName,
		elementId : elementId,
		elementClass : elementClass,
		elementHeight : elementHeight,
		elementWidth : elementWidth,
		elementOffsetTop : elementOffsetTop,
		elementOffsetLeft : elementOffsetLeft,
		numberOfFingers : numberOfFingers,
		scrollTopPx : scrollTopPx,
		viewportHeight : viewportHeight,
		viewportWidth : viewportWidth,
		elementScrollTop : elementScrollTop,
		country : country,
		timeZoneOffset : timeZoneOffset,
		imageName : imageName,
		eventTriggeredTime : eventTriggeredTime
	}, function(data) {
		if (data.status == 'success') {
			if(data.responce !=  null) {
				sessionStorage.setItem('sessionID', data.responce);
			}
			
		} else {
			console.log(data.status);
		}
	});
	clearValues();
}

function clearValues() {
	eventType = -1;
	coordinateX = -1;
	coordinateY = -1;
	screenHeight = -1;
	screenWidth = -1;
	orientation = -1;
	sessionID = -1;
	tagName = -1;
	elementId = -1;
	elementClass = -1;
	elementHeight = -1;
	elementWidth = -1;
	elementOffsetTop = -1;
	elementOffsetLeft = -1;
	numberOfFingers = -1;
	scrollTopPx = -1;
	eventTriggeredTime = -1;
	viewportHeight = -1;
	viewportWidth = -1;
	elementScrollTop = -1;
	timeZoneOffset = -1;
	imageName = -1 ;
}

function setTimeZoneInCookie() {
    var _myDate = new Date();
    var _offset = _myDate.getTimezoneOffset();
    timeZoneOffset = _offset;
}