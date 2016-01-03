$(document).ready(function() {
	$('#districtFormDivId').hide();
	//loadDistrictDetailsTable();
})

function loadDistrictDetailsTable() {
	var q =$('#districtDetailsSearchId').val();
	
	var formdata = 'ajax=true&q='+encodeURIComponent(q).replace("'", "%27");
	$.ajax({
        type: "GET",
        url: "districtSetUp/getDistrictDetailsTable",
        data: formdata,
        success: function(data) {
          $("#dristrictDynamicTable").html(data);
       	  $("#dristrictDynamicTable").displayTagAjax();
       	  removeTableText('dristrictDynamicTable');
        }
	});
}

function newDistrictDetails() {
	$('#districtFormDivId').show();
}

function districtDetailsSave() {
	var hiddenDDID = $('#hiddenDDID').val();
	var districtCode = $('#districtCodeId').val();
	var districtName = $('#districtNameId').val();
	
	$.post('districtSetUp/saveDistrictDetails', {
		hiddenDDID : hiddenDDID,
		districtCode : districtCode,
		districtName : districtName
	}, function(data) {
		if (data.status == 'success') {
			console.log(data.status);
		} else {
			console.log(data.status);
		}
	});
}