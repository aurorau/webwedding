
$(document).ready(function() {
	$.ajaxSetup ({
	    // Disable caching of AJAX responses
	    cache: false
	});
	//$("#cssId").val("Disable CSS");
});

/*function removeCSS () {
	
	removejscssfile("style.css", "css");
}*/


function removeCSS(type){
	
	var formdata = new FormData();
	formdata.append("type", type);
	
	$.ajax({
        type: "POST",
        url: "JSorCSSDisabled",
        data: formdata,
        dataType: 'json',
        contentType: false,
        processData: false,
        success: function(data) {
        	if(data.status == 'css'){
        		//$("#cssId").val("Enable CSS");
        	}
        },
        error: function(){
        	console.log(data.status);
        }
	});
}


function removejscssfile(filename, filetype){
	console.log("Done");
    var targetelement=(filetype=="js")? "script" : (filetype=="css")? "link" : "none" //determine element type to create nodelist from
    var targetattr=(filetype=="js")? "src" : (filetype=="css")? "href" : "none" //determine corresponding attribute to test for
    var allsuspects=document.getElementsByTagName(targetelement)
    for (var i=allsuspects.length; i>=0; i--){ //search backwards within nodelist for matching elements to remove
    if (allsuspects[i] && allsuspects[i].getAttribute(targetattr)!=null && allsuspects[i].getAttribute(targetattr).indexOf(filename)!=-1)
        allsuspects[i].parentNode.removeChild(allsuspects[i]) //remove element by calling parentNode.removeChild()
    }
}