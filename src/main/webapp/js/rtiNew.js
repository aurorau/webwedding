
var leftClickCount=0;
var rightClickCount=0;
var zoomCount=0;
var scrollCount=0;
var keyPressCount=0;
var scrollEvent=false;
var tapsEvent=false;
var dbClickCount=0;
var orientation;
var eventType;
var TEVENT=null;
var getScreenWidth=0;
var getScreenHeight=0;
var zoomEvent=null;
var touchX=0;
var touchY=0;
var clickX=0;
var clickY=0;
var eventStartTime=0;
var eventEndTime=0;
var previouseScrollTime = 0;
var previousKey = 'NotYet';
var previouseLeftClickTime = 0;
var globalDBClickEvent = 0;
var zoomInCount = 0;
var zoomOutCount = 0;
var previouseTouchTime = 0;
var previousePosition = 0;
var coordinateX = 0;
var coordinateY = 0;
var getBrowserWidth=0;
var getBrowserHeight=0;
var tagName;
var elementId;
var elementClass;
var elementHeight;
var elementWidth;
var elementOffsetTop;
var elementOffsetLeft;
var numberOfFingers = 0;
var zoomEvent = -1;
var scrollTopPx=-1;
var elementScrollTop = -1;
var viewportHeight = -1;
var viewportWidth = -1;

$(document).ready(function() {

	setInterval(function(){ 
		//heartBeat();
	},10000);
	zoomEvent = 0;
	identifyDeviceWidthHeight();
	
/*	$("#content").click(function(event) {
	    //alert(this.innerHTML);
		var x = $("#content").offset();
	    alert("Top: " + x.top + " Left: " + x.left);
	});*/
	
});

/*if (window.matchMedia("(min-width: 400px)").matches) {
	   the viewport is at least 400 pixels wide 
	} else {
	   the viewport is less than 400 pixels wide 
	}*/


function identifyDeviceWidthHeight(){
	//getProperHeightWidth();
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
/*	console.log("deviceMinWidthStatus :"+deviceMinWidthStatus+"\ndeviceMinHeightStatus :"+deviceMinHeightStatus+"\norientaton :"+orientaton);
	console.log("///////////////////");
	console.log("deviceMaxWidthStatus :"+deviceMaxWidthStatus+"\ndeviceMaxWidthStatus :"+deviceMaxWidthStatus+"\norientaton :"+orientaton);
	var browserWidthStatus = window.matchMedia("(min-width: 1366px)").matches;
	var browserHeightStatus = window.matchMedia("(min-height: 768px)").matches;*/
}


function getProperHeightWidth(){
	//$('#searchKeyId').val(geoplugin_countryName()+'/'+geoplugin_region());
	getScreenWidth = screen.width;
	getScreenHeight = screen.height;
}

function getFraudHeightWidth(status){
	getScreenWidth = screen.width+status;
	getScreenHeight = screen.height+status;
}


function getLeftRightClick(e) {

	//eventTriggredPositionDetails(e);
	
/*	if(e.which == 1) {
		coordinateX = e.clientX;
		coordinateY = e.clientY;
		
		console.log("page Y :"+e.pageY); //relative to the html docuemnt
		console.log("client Y :"+e.clientY); //relative to the browser
		console.log("screen Y :"+e.screenY); //relative to the device
		
		
		eventType = "LC";
		
		setTimeout(function(){
			if(eventType == "LC") {
				sendEventDetailsToController();
			}
	    },1000);
	}*/
	if(e.which == 2) {
		
	}
	if(e.which == 3 || e.which == null) {
		coordinateX = e.clientX; //e.screenX;
		coordinateY = e.clientY;
		eventType = "RC";
		sendEventDetailsToController();
	}
}
/*$(document).on("pagecreate",function(){
	catchTapFunction();
	catchScrollEvent();
});*/

/*function catchScrollEvent () {
	$(document).on("scrollstop",function(){
		scrollCount = scrollCount+1;
	});
}*/

$(document).on('dblclick',function(e){
	eventType = "DC";
	coordinateX = e.clientX;
	coordinateY = e.clientY;
	sendEventDetailsToController();
});

function touchTest(e){
	if (e.originalEvent) {
        if (e.originalEvent.touches && e.originalEvent.touches.length) {
            alert("touches"+e.originalEvent.touches.length);
        } else if (e.originalEvent.changedTouches && e.originalEvent.changedTouches.length) {
        	alert("changedTouches"+ e.originalEvent.changedTouches);
        }
    }
}

$(document).on('touchstart', function(e){
/*	TEVENT = e;
	
	var currentTouchTime = Date.now();
	var touchTimeDiffer = (currentTouchTime - previouseTouchTime);
	
	//touchTest(e);
	
	if(touchTimeDiffer < 400) {
		eventType = "TZE";
		coordinateX = e.originalEvent.touches[0].clientX;
		coordinateY = e.originalEvent.touches[0].clientY;
		//sendEventDetailsToController();
		setTimeout(function(){
			if(eventType == "TZE" || eventType == "SE") {
				eventType = 'TZE';
				sendEventDetailsToController();
			} 
	    },400);
	} else {
		eventType = "TE";
		coordinateX = e.originalEvent.touches[0].clientX;
		coordinateY = e.originalEvent.touches[0].clientY;
		//sendEventDetailsToController();
		setTimeout(function(){
			if(eventType == "TE") {
				sendEventDetailsToController();
			}
	    },400);
	}
	previouseTouchTime = currentTouchTime;*/
	
	
/*	touchX = e.originalEvent.touches[0].pageX;
	touchY = e.originalEvent.touches[0].pageY;*/
	
/*	touchX = e.originalEvent.touches[0].clientX;
	touchY = e.originalEvent.touches[0].clientY;*/
	numberOfFingers = e.originalEvent.touches.length;
	eventType = "TS";
	coordinateX = e.originalEvent.touches[0].clientX;
	coordinateY = e.originalEvent.touches[0].clientY;
	eventTriggredPositionDetails(e);
	sendEventDetailsToController();
	 
});

$(document).on('touchmove', function(e){
	eventType = "TM";
	numberOfFingers = e.originalEvent.touches.length;
	coordinateX = e.originalEvent.touches[0].clientX;
	coordinateY = e.originalEvent.touches[0].clientY;
	eventTriggredPositionDetails(e);
	sendEventDetailsToController();
/*	setTimeout(function(){
		if(eventType == "TM") {
			sendEventDetailsToController();
		}
    },500);*/
});

$(document).on('click', function(e){
/*	getLeftRightClick(e);
	
	if(eventType != 'RC') {
		eventType = "LC";
		coordinateX = e.clientX;
		coordinateY = e.clientY;
		eventTriggredPositionDetails(e);
		
		if(e.originalEvent.touches) {
			numberOfFingers = e.originalEvent.touches.length;
		}
		
		sendEventDetailsToController();
	}*/
	
	if(e.which == 1) {
		eventType = "LC";
		coordinateX = e.clientX;
		coordinateY = e.clientY;
		eventTriggredPositionDetails(e);
		
		if(e.originalEvent.touches) {
			numberOfFingers = e.originalEvent.touches.length;
		}
		sendEventDetailsToController();
	}else if(e.which == 3){
		eventType = "RC";
		coordinateX = e.clientX;
		coordinateY = e.clientY;
		eventTriggredPositionDetails(e);
		
		if(e.originalEvent.touches) {
			numberOfFingers = e.originalEvent.touches.length;
		}
		
		sendEventDetailsToController();
	} else {
		eventType = "TC";
		coordinateX = e.clientX;
		coordinateY = e.clientY;
		eventTriggredPositionDetails(e);
		
		if(e.originalEvent.touches) {
			numberOfFingers = e.originalEvent.touches.length;
		}
		
		sendEventDetailsToController();
	}

});

function eventTriggredPositionDetails(e){
	var name = e.target.tagName;
	var id =  e.target.id;
	var clz = $(e.target).attr('class');
	//var hsClz = $(e.target).hasClass();
	
	var x = $("."+clz).offset();
  //  console.log("Top: " + x.top + " Left: " + x.left);
	
	if(id == null || id == ''){
		$(e.target).attr('id',name+'test');
	}
	
	
	console.log("Tag Name :"+name);
	console.log("beforeid :"+id);
	console.log("afterid :"+e.target.id);
	console.log("clz :"+clz);
	//console.log("hsClz :"+hsClz);
	
	var rect = document.getElementById(e.target.id).getBoundingClientRect();
	console.log("Top: " + rect.top);
	console.log("left: " + rect.left);
	console.log("width : " + rect.width );
	console.log("height : " + rect.height );
	
	
	console.log("e.target.attributes :"+e.target.attributes.length);
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
	elementScrollTop = x.top;
	
/*	if(attibuteList.length > 0){
		$.each(attibuteList, function(name, value){
			index = index +1;
			console.log("Attribute Name :"+this.name+"\nAttribute Value :"+this.value+"\n///////////////////////");
			
			if(this.name =='id') {
				var id = this.value.trim();
				if(id.length > 0){
					console.log("Index :"+index);
				} else {
					console.log("DONE :");
					//$(this).setAttribute('id', index);
				}
				$(this).attr("id", index);
				var x = $("."+clzName).offset();
				console.log("Top: " + x.top + " Left: " + x.left);
				setTimeout(function(){
					var rect = document.getElementById(id).getBoundingClientRect();
					console.log("Top: " + rect.top);
					console.log("left: " + rect.left);
					console.log("width : " + rect.width );
					console.log("height : " + rect.height );
				},500);

			}
		});
	}*/
}
/*$(document).on('mousedown',function(e){
	if(TEVENT == null) {
		eventType = e.type;
		getLeftRightClick(e);
	} else{
		TEVENT = null;
	}
});*/

$(window).on("orientationchange",function(event){
	  orientation = event.orientation;
});

//function scrolled() 
$(document).on('scroll',function(e){
	var currentScrollTime = Date.now();
/*	if(eventType == "TZE") {
		eventType = "TZE_SE";
		setScroll(currentScrollTime);
	} else if(eventType == "TE"){
		eventType = "TE_SE";
		setScroll(currentScrollTime);
	} else {
		eventType = "DE_SE";
		setScroll(currentScrollTime);
	}*/
	
	eventType = "SE";
	numberOfFingers = 0;
	if(e.originalEvent.touches) {
		numberOfFingers = e.originalEvent.touches.length;
	}
	setScroll(currentScrollTime);
	
});
function setScroll(currentScrollTime){
	var timeDiffer= (currentScrollTime-previouseScrollTime);
	if(timeDiffer > 100) {
		scrollTopPx = $(document).scrollTop();
		coordinateX = 0;
		coordinateY = 0;
		tagName = 0;
		elementId = 0;
		elementClass = 0;
		elementHeight = 0;
		elementWidth = 0;
		elementOffsetTop = 0;
		elementOffsetLeft = 0;
		sendEventDetailsToController();
/*		setTimeout(function(){
			sendEventDetailsToController();
	    },500);*/
	}
	previouseScrollTime = currentScrollTime;
}
//$(window).on('scroll',scrolled);

$(document).keypress(function(e) {


	if(e.which == 45) { //firefox
		zoomInCount = zoomInCount+1;
		zoomCount = zoomCount+1;
		eventType = "DZE";
		
	} else if( e.which == 43) {//firefox
		zoomOutCount = zoomOutCount+1;
		zoomCount = zoomCount+1;
		eventType = "DZE";
		
	} else {
		eventType = "KP";
	}

/*	if(previousKey == 'NotYet') {
		keyPressCount = keyPressCount+1;
		previousKey = e.which;
		eventType = "KP";
	} else if (e.which != previousKey) {
		keyPressCount = keyPressCount+1;
		eventType = "KP";
	}*/
	sendEventDetailsToController();
});

var getCurrentTime=function() {
	var d = new Date();
	/*	var time = d.getDate() + ":"+d.getHours() + ":" + d.getMinutes() + ":" + d.getSeconds();
	return time;*/
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

function sendData() {
    setTimeout(function(){
    	//sendDataToController();
    }, 500);
}

function sendEventDetailsToController () {
	var eventTriggeredTime = getCurrentTime();
	identifyDeviceWidthHeight();
	var screenHeight = getScreenHeight;
	var screenWidth = getScreenWidth;
	var sessionID = sessionStorage.getItem('sessionID');
		//sessionStorage.getItem('sessionID');
	//$('#hiddenSessionId').val(sessionID);
	
	//console.log("Hidden Session Id :"+$('#hiddenSessionId').val());
	
	$.post('RTIController/postEventDetails', {
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
		elementScrollTop : elementScrollTop,
		viewportHeight : viewportHeight,
		viewportWidth : viewportWidth,
		eventTriggeredTime : eventTriggeredTime
	}, function(data) {
		if (data.status == 'success') {
			if(data.result !=  null) {
				sessionStorage.setItem('sessionID', data.result);
				clearValues();
				//$('#hiddenSessionId').val(data.result);
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
	getScreenHeight = -1;
	getScreenWidth = -1;
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
	elementScrollTop = -1;
}
function sendDataToController() {
	var userAgent = navigator.userAgent;
	var innerWidth = $(window).innerWidth();
	var dataSubmitTime = getCurrentTime();
	
	var latitude = geoplugin_latitude();
	var longitude = geoplugin_longitude();
	
/*	console.log("Latitude :"+geoplugin_latitude());
	console.log("Longitude :"+geoplugin_longitude());*/
	
	
	//alert(window.devicePixelRatio+"\n"+window.screen.width);
	
/*	console.log("Country Name : " + geoplugin_countryName());
	console.log("Country Code :"+geoplugin_countryCode());
	console.log("Continent Code :"+geoplugin_continentCode());
	console.log("Region :"+geoplugin_region());
	console.log("City :"+geoplugin_city());
	console.log("Latitude :"+geoplugin_latitude());
	console.log("Longitude :"+geoplugin_longitude());
	console.log("Currency Symbol :"+geoplugin_currencySymbol());
	console.log("Currency Code :"+geoplugin_currencyCode());*/
	
	//var location = $('#searchKeyId').val();
	var languages = navigator.language;
	var referer = document.referrer;
	
	$.post('getHeaderString', {
		userAgent : userAgent,
		location : location,
		latitude : latitude,
		longitude : longitude,
		touchCount : touchCount,
		leftClickCount : leftClickCount,
		zoomInCount : zoomInCount,
		scrollCount : scrollCount,
		keyPressCount : keyPressCount,
		scrollEvent : scrollEvent,
		tapsEvent : tapsEvent,
		orientation : orientation,
		rightClickCount : rightClickCount,
		dbClickCount : dbClickCount,
		eventType : eventType,
		zoomOutCount : zoomOutCount,
		screenWidth : screenWidth,
		touchX : touchX,
		touchY : touchY,
		clickX : clickX,
		clickY : clickY,
		location : location,
		languages : languages,
		referer : referer,
		screenHeight : screenHeight,
		zoomCount : zoomCount,
		dataSubmitTime : dataSubmitTime
	}, function(data) {
/*		if (data.status == 'success') {
			
		} else {
			console.log(data.status);
		}*/
	});
}
function getLocation() {
	navigator.geolocation.getCurrentPosition(foundLocation, noLocation);
    function foundLocation(position) {
    	var lat = position.coords.latitude;
    	var long = position.coords.longitude;
    	console.log("Position :"+position);
    	console.log("LAT : "+lat +", LONG : "+long);
    }

    function noLocation() {
    	console.log('Could not find location');
    }
}