
var map;
var colorMap;
$(document).ready(function() {
	$.ajaxSetup ({
	    // Disable caching of AJAX responses
	    cache: false
	});
	loadCategoryDetails();
	loadDistrictDetails();
	loadCompanyDetailsTableW2();
	map = new Map();
	colorMap = new Map();
	$('#cart-value').text(0);
});


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
       	  companyColor();
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
				
				if(data.result.companyImageUrls.length > 0) {
					setImageForCompanyGallery(data.result.companyImageUrls);
				}

				$('#comapnyNameW2').text(data.result.companyName);
				$('#companyAddW2').text(data.result.companyAddress);
				$('#companyEmailW2').text(data.result.companyEmail);
				$('#companyTpW2').text(data.result.companyTp1);
				$('#companyWebW2').text(data.result.companyWebURl);
				$('#companyFbW2').text(data.result.companyFbPage);
				$('#priceW2').text(data.result.budget);
				$('#companyOwnerW2').text(data.result.supplierPersonalDetailsFName);
			}
		} else {
			console.log(data.status);
		}
	});
}

function setImageForCompanyGallery(urls) {
	
	$.each(urls, function(index, url){
		if(index == 0) {
			$('#itemActiveDiv').append("<img src=./fileUploadController/imageDownloader?fileName="+url+">");
		} else {
			$('#companyProfileImageGallery').append("<div class=item>" +
					"<img src=./fileUploadController/imageDownloader?fileName="+url+">" +
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
