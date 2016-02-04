
var map;
var colorMap;
$(document).ready(function() {
	$.ajaxSetup ({
	    // Disable caching of AJAX responses
	    cache: false
	});
	loadCategoryDetails();
	loadImageCategoryDetails();
	loadDistrictDetails();
	loadCompanyDetailsTableW2();
	map = new Map();
	colorMap = new Map();
	$('#cart-value').text(0);
	validationHide();
	validationHideInAdd();
	loadAdds();
	clearValuesInSupplierDetails();
	clearValuesInAddDetails();
	$('#serviceCategoryDD').val('');
	$('#districtDD').val('');
	$('#budgetId').val('');
	successMsgHide();
});

function successMsgHide(){
	$('#unsuccess').hide();
	$('#success').hide();
	$('#unsuccessInAdd').hide();
	$('#successInAdd').hide();
}

function loadCategoryDetails() {
	$.ajax({
        type: "GET",
        url: "supplierCategorySetUp/getAllCategories",
        success: function(data) {
        	if(data.result != null) {
        		setViewServiceTable(data.result);
        		setCategoryDropDown(data.result)
        		for(var x=0 ; x< data.result.length ; x++ ){
        			$('#serviceCategoryDD').append(new Option(''+data.result[x].scName+'',''+data.result[x].scid+''))
        		}
        	}
        }
	});
}

function setCategoryDropDown(categoryList){
	 $.each(categoryList, function (index, category){
		 $('#categoryMainDropDown').append("<li onclick='setSetviceType("+category.scid+")'><a href=#portfolio>"+category.scName+"</a></li>");
	 });
}
function setViewServiceTable(categoryList){

	 $.each(categoryList, function (index, category){
		if(index % 3 == 0) {
			$('#serviceCategoryDynamicTableW2').append(
					"<tr id=tr_"+index+">" +
						"<td onclick='setSetviceType("+category.scid+")'><a href=#portfolio>"+category.scName+"</a></td>" +
					"</tr>");
		} else {
			var y = index%3;
			var t= (index-y);
			$('#tr_'+t).append(
					"<td onclick='setSetviceType("+category.scid+")'><a href=#portfolio>"+category.scName+"</a></td>");
					
		}
		

	});

}

function setSetviceType(value){
	$('#serviceCategoryDD').val(value);
	loadCompanyDetailsTableW2();
}

function loadDistrictDetails(){
	$.ajax({
        type: "GET",
        url: "districtSetUp/getAllDistricts",
        success: function(data) {
        	if(data.result != null) {
        		for(var x=0 ; x< data.result.length ; x++ ){
        			$('#districtDD').append(new Option(''+data.result[x].districtName+'',''+data.result[x].ddid+''))
        		}
        	}
        }
	});
}

function loadCompanyDetailsTableW2() {
	var serviceCategoryDD =$('#serviceCategoryDD').val();
	var districtDD = $('#districtDD').val();
	var budgetId =  $('#budgetId').val().trim();
		
	var q ='';
	var formdata = 'ajax=true&serviceCategoryDD='+serviceCategoryDD+'&districtDD='+districtDD+'&budgetId='+budgetId;
	$.ajax({
        type: "GET",
        url: "companyDetailsController/getCompanyDetailsTableW2",
        data: formdata,
        success: function(data) {
          $("#dynamicCompanyTableW2").html(data);
       	  $("#dynamicCompanyTableW2").displayTagAjax();
       	  removeTableText('dynamicCompanyTableW2');
       	  setTimeout(function(){
    		$('.pagebanner').hide();
       	  }, 2000);
       	  //companyColor();
        }
	});
}

function getCompanyDetailsW2(scid) {
	var hiddenSCDID = scid;
	$.get('companyDetailsController/getCompanyDetailsBySCDID', {
		hiddenSCDID : hiddenSCDID
	}, function(data) {
		if (data.status == 'success') {
			if(data.result != null) {
				$('.item active').html('');
				$('.item').html('');
				
				if(data.result.companyDetails.companyImageIds.length > 0) {
					setImageForCompanyGallery(data.result.companyDetails.companyImageIds);
				}

				$('#comapnyNameW2').text(data.result.companyDetails.companyName);
				$('#companyAddW2').text(data.result.companyDetails.companyAddress);
				$('#companyEmailW2').text(data.result.companyDetails.companyEmail);
				$('#companyTpW2').text(data.result.companyDetails.companyTp1);
				$('#companyWebW2').text(data.result.companyDetails.companyWebURl);
				$('#companyFbW2').text(data.result.companyDetails.companyFbPage);
				$('#priceW2').text(data.result.companyDetails.budget);
				$('#companyOwnerW2').text(data.result.companyDetails.supplierPersonalDetailsFName);
				$('#companyDescription').text(data.result.companyDetails.companyDescription);
				
				
				if(data.result.packages.length > 0) {
					$('#packageDetailsDivId').html('');
					setPackageDetails(data.result.packages);
				} else {
					$('#packageDetailsDivId').html('');
					$('#packageDetailsDivId').append("" +
							"<tr>" +
							"<td><div class=col-xs-6 col-sm-3 col-lg-3 text-left><label class=control-label>No Packages Available</label></div></td>" +
							"</tr>");
				}
				if(data.result.offers.length > 0) {
					$('#offerDetailsTableId').html('');
					setOfferDetails(data.result.offers);
				} else {
					$('#offerDetailsTableId').html('');
					$('#offerDetailsTableId').append("" +
							"<tr>" +
							"<td><div class=col-xs-6 col-sm-3 col-lg-3 text-left><label class=control-label>No Offers Available</label></div></td>" +
							"</tr>");
				}
			}
		} else {
			console.log(data.status);
		}
	});
}

function setOfferDetails(offers){
	$.each(offers, function(index, value){	
		$('#offerDetailsTableId').append("" +
			"<tr>" +
			"<td><label class=control-label>"+value.offerName+"</label></td>" +
			"<td><label class=control-label>"+value.offerDescription+"</label></td>" +
			"<td style=align:right><label class=control-label>Until :"+value.offerEndDate+"</label></td>" +
			"</tr>");
	});
}

function setPackageDetails(packages) {
	$.each(packages, function(index, value){	
		$('#packageDetailsDivId').append("" +
			"<tr>" +
			"<td><div class=col-xs-6 col-sm-3 col-lg-3 text-left><label class=control-label>"+value.packageName+"</label></div></td>" +
			"<td><div class=col-xs-6 col-sm-3 col-lg-3 text-left><label class=control-label>"+value.packageDescription+"</label></div></td>" +
			"</tr>");
	});
}

function setImageForCompanyGallery(ids) {
	
	$.each(ids, function(index, id){
		if(index == 0) {
			$('#itemActiveDiv').append("<img src=./fileUploadController/fileDownloader?UFID="+id+">");
		} else {
			$('#companyProfileImageGallery').append("<div class=item>" +
					"<img src=./fileUploadController/fileDownloader?UFID="+id+">" +
			"</div>");	
		}

	});
}

function addToCart(id, companyName, budget){

	if(map.has(companyName)){
		map.delete(companyName);
	} else {
		map.set(companyName,budget);
	}
	var mapSize = map.size;
	$('#cart-value').text(mapSize);
	
	if(mapSize > 0 ) {
		$('#cart-value').addClass('add-to-cart-click');
	}
	if(mapSize == 0 ) {
		$('#cart-value').removeClass('add-to-cart-click');
	}
	
	if(colorMap.has(companyName)) {
		colorMap.delete(companyName);
		$('#'+id).removeClass('add-to-cart-click').addClass('add-to-cart');
	} else {
		colorMap.set(companyName,id);
		$('#'+id).removeClass('add-to-cart').addClass('add-to-cart-click');
	}
}

function companyColor() {
	colorMap.forEach(function (value, key) {
		$('#'+value).removeClass('add-to-cart').addClass('add-to-cart-click');
	});
}

function displayBudget() {
	var totalBudget = 0;
	var arr = new Array();
	//clear();
	var mapSize = map.size;
	$('#budgetTableId').html('');
	
	map.forEach(function (value, key) {
		totalBudget += parseInt(value);
		$('#budgetTableId').append(
			"<tr>" +
				"<td>"+key+"</td>" +
				"<td>"+value+".00</td>" +
			"</tr>");
	});
	$('#budgetTableId').append(
			"<tr>" +
				"<td>Total Budget</td>" +
				"<td id=total>"+totalBudget+".00</td>" +
			"</tr>");
}

function saveAddDetailsW2(){
	var hiddenAID = '';
	var supplierName = $('#nameInAdd').val().trim();
	var supplierTp = $('#phoneInAdd').val().trim();
	var supplierEmail = $('#emailInAdd').val().trim();
	var status = '2';
	var activePeriod = '1';
	var date =  moment().format('YYYY-MM-DD');
	var addDescription = $('#descriptionInAdd').val().trim();
	var registeredDate = date;
	var activeDate = date;
	
	if(checkValidationInAddDetails()) {
		$.post('addDetailsController/saveAddDetailsW2', {
			hiddenAID : hiddenAID,
			supplierName : supplierName,
			supplierTp : supplierTp,
			supplierEmail : supplierEmail,
			status : status,
			addDescription : addDescription,
			registeredDate : registeredDate,
			activeDate : activeDate,
			activePeriod : activePeriod
		}, function(data) {
			if (data.status == 'saved') {
				$('#successInAdd').show();
				clearValuesInAddDetails();
			} else {
				$('#unsuccessInAdd').show();	
				setTimeout(function(){
					$('#unsuccessInAdd').hide();
			    },10000);
				console.log(data.status);
			}
		});
	} else {
		//alert("Fill required fields ");
	}
}

function clearValuesInAddDetails(){
	$('#nameInAdd').val('');
	$('#phoneInAdd').val('');
	$('#emailInAdd').val('');
	$('#descriptionInAdd').val('');
	setTimeout(function(){
		$('#successInAdd').hide();
    },10000);
}
var checkValidationInAddDetails = function (){
	var status = true;
	
	var supplierName = $('#nameInAdd').val().trim();
	var supplierTp = $('#phoneInAdd').val().trim();
	var supplierEmail = $('#emailInAdd').val().trim();
	
	if(supplierEmail == ''){
		$('#emailValidationInAdd').text("Please enter your email.");
		$('#emailValidationInAdd').show();
		status = false;
	} else {
		var regex ;
		if(supplierEmail != ''){
			//emailArrayList.push(candidateEmailAddress);
			regex = /^([a-zA-Z0-9_\.\-\+])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
			
			if(!regex.test(supplierEmail)) {
				$('#emailValidationInAdd').text("Please enter valid email.");
				$('#emailValidationInAdd').show();
				status = false;
			}
		}
	}
	if(supplierName == ''){
		$('#nameValidationInAdd').text("Please enter your first name.");
		$('#nameValidationInAdd').show();
		status = false;
	}
	if(supplierTp == ''){
		$('#phoneValidationInAdd').text("Please enter your phone number.");
		$('#phoneValidationInAdd').show();
		status = false;
	}
	
	return status;
}

function validationHideInAdd(){
	$('#emailValidationInAdd').hide();
	$('#nameValidationInAdd').hide();
	$('#phoneValidationInAdd').hide();
}

function saveSupplierDetailsW2(){
	var hiddenSPDID = '';
	var fname = $('#firstNameInPS').val().trim();
	var lname = $('#lastNameInPS').val().trim();
	var tp1 = $('#phoneInPS').val().trim();
	var email = $('#emailInPS').val().trim();
	var status = '2';
	var address = $('#addressInPS').val().trim();
	var description = $('#messageInPS').val().trim();
	
	if(checkValidationInSupplierRegistration()) {
		$.post('supplierDetailsController/saveSupplierDetails', {
			hiddenSPDID : hiddenSPDID,
			fname : fname,
			lname : lname,
			tp1 : tp1,
			email : email,
			status : status,
			address : address,
			description : description
		}, function(data) {
			if (data.status == 'saved') {
				$('#success').show();
				clearValuesInSupplierDetails();
			} else {
				$('#unsuccess').show();	
				setTimeout(function(){
					$('#unsuccess').hide();
			    },10000);
				console.log(data.status);
			}
		});
	} else {
		//alert("Fill required fields ");
	}
}

var checkValidationInSupplierRegistration = function (){
	var status = true;
	
	var fname = $('#firstNameInPS').val().trim();
	var lname = $('#lastNameInPS').val().trim();
	var tp1 = $('#phoneInPS').val().trim();
	var email = $('#emailInPS').val().trim();
	
	if(email == ''){
		$('#emailValidationInPs').text("Please enter your email.");
		$('#emailValidationInPs').show();
		status = false;
	} else {
		var regex ;
		if(email != ''){
			//emailArrayList.push(candidateEmailAddress);
			regex = /^([a-zA-Z0-9_\.\-\+])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
			
			if(!regex.test(email)) {
				$('#emailValidationInPs').text("Please enter valid email.");
				$('#emailValidationInPs').show();
				status = false;
			}
		}
	}
/*	if(type == ''){
		$('#categorylValidation').text("Please select your category.");
		$('#categorylValidation').show();
		status = false;
	}*/
	if(fname == ''){
		$('#firstNameValidationInPs').text("Please enter your first name.");
		$('#firstNameValidationInPs').show();
		status = false;
	}
	if(lname == ''){
		$('#lastNameValidationInPs').text("Please enter your last name.");
		$('#lastNameValidationInPs').show();
		status = false;
	}
	if(tp1 == ''){
		$('#phoneValidationInPs').text("Please enter your phone number.");
		$('#phoneValidationInPs').show();
		status = false;
	}
	
	return status;
}

function clearValuesInSupplierDetails(){
	$('#firstNameInPS').val('');
	$('#lastNameInPS').val('');
	$('#phoneInPS').val('');
	$('#emailInPS').val('');
	$('#addressInPS').val('');
	$('#messageInPS').val('');
	setTimeout(function(){
		$('#success').hide();
    },10000);
}

function validationHide(){
	$('#emailValidationInPs').hide();
	$('#phoneValidationInPs').hide();
	$('#firstNameValidationInPs').hide();
	$('#lastNameValidationInPs').hide();
}
function hideValidation(id){
	$('#'+id).hide();
}
function loadImageCategoryDetails(){
	$.ajax({
        type: "GET",
        url: "imageCategoryController/getAllImageCategories",
        success: function(data) {
        	if(data.result != null) {
        		setProfileGallery(data.result);
        	}
        }
	});
}
function setProfileGallery(imageCategoryList){
	 $.each(imageCategoryList, function (index, imageCategory){
		$('#imageCategoryTableW2').append(
		 	"<div class=portfolio-item>"+
		 		"<a href=#CaterorGallery class=portfolio-link data-toggle=modal onclick=setImageGallaryForCategory("+imageCategory.icid+")>"+
		 			"<div class=portfolio-hover>"+
		 				" <div class=portfolio-hover-content>"+
		 					" <h4>"+imageCategory.icName+"</h4>"+
		 				" </div>"+
		 			"</div>"+
		 			"<img src=./fileUploadController/imageDownloader1?ITID="+imageCategory.itid+" class=gallery>"+
		 		" </a>"+
		 	" </div>");
		});
}

function setImageGallaryForCategory(id){
	var formdata = 'ajax=true&fileImageCategoryId='+id;
	$('#imageCategoryGalleryDivW2').html('');
	$.ajax({
        type: "GET",
        url: "fileUploadController/getImagesByImageCategoryId",
        data: formdata,
        success: function(data) {
        	if(data.result != null) {
        		 $.each(data.result, function (index, imageList){
        				$('#imageCategoryGalleryDivW2').append("<img src=./fileUploadController/fileDownloader?UFID="+imageList.ufid+" class=gallery>");
        		 });
        	}
        }
	});
}

function loadAdds(){
	$.ajax({
        type: "GET",
        url: "addDetailsController/getAllAdds",
        success: function(data) {
        	if(data.result != null) {
        		 $.each(data.result, function (index, addList){
        				$('#ads').append("<div class=ads> "+
        						"<a href=#portfolioModal6 class=portfolio-link data-toggle=modal>"+
        						"<img src=./fileUploadController/imageDownloader1?ITID="+addList.itid+" class=img-responsive width=300>"+
        						"</a>"+
        				"</div>");
        		 });
        	}
        }
	});
}
function checkedInputTypeNumberic(myfield, e, dec) {
	var key;
	var keychar;

	if (window.event)
		key = window.event.keyCode;
	else if (e)
		key = e.which;
	else
		return true;
	keychar = String.fromCharCode(key);

	// control keys
	if ((key == null) || (key == 0) || (key == 8) || (key == 9) || (key == 13)
			|| (key == 27))
		return true;

	// numbers
	else if ((("0123456789").indexOf(keychar) > -1))
		return true;

	// decimal point jump
	else if (dec && (keychar == ".")) {
		myfield.form.elements[dec].focus();
		return false;
	} else
		return false;
}

function limitedLength(fieldId, value){
	var text =$('#'+fieldId).val();
	if(text.length>value){
		$('#'+fieldId).val(text.substring(0, value));
	}
}