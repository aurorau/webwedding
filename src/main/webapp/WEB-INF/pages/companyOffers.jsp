<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>

<!-- Bootstrap Core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href='css/backoffice.css' rel='stylesheet' type='text/css'>
<!-- <link href='css/common-style.css' rel='stylesheet' type='text/css'> -->

<!-- Date Picker -->
<link rel="stylesheet" href="https://code.jquery.com/ui/1.11.0/themes/smoothness/jquery-ui.css">

<script src="js/jquery.js"></script>
<script src="js/common.js"></script>
<script src="js/jquery.displaytag-ajax-1.2.js"></script>
<script src="https://code.jquery.com/ui/1.11.0/jquery-ui.js"></script>
<script src="js/backOfficeJS/companyOffersDetails.js"></script>
<html>
<head>
<title>Company Offer Details</title>
</head>
<body>
	<div>
		<div style="width:20%;float: left">
		<h3><a href="backOffice">W2-Back Office</a></h3>
			<div class="menu">
				<ul><a href="#">Article Details</a></ul>
				<ul><a href="districtSetUp">District Details</a></ul>
				<ul><a href="supplierCategorySetUp">Supplier Category</a></ul>
				<ul><a href="imageCategoryController">Image Category</a></ul>
				<ul><a href="addDetailsController">Add Details</a></ul>
				<ul><a href="companyDetailsController">Supplier Company Details</a></ul>
				<ul><a href="companyPackageDetailsController">Company Package Details</a></ul>
				<ul><b>Company Offers Details</b></ul>
				<ul><a href="supplierDetailsController">Supplier Personal Details</a></ul>
				<ul><a href="fileUploadController">File Image Upload</a></ul>
			</div>
		</div>
				
		<div style="width:80%;float: right" id="content">
			<div style="float: left; width:100%">
			<h3>Company Offer Details</h3>	
				<table style="float: left">
					<tbody class="search-body">
						<tr>			
						<td>
							<select id="companyDetailsId" onchange="hideBelow()" class="search-input">
								<option value="">Select Company</option>
							</select>
						</td>
						<td><button onclick="loadCompanyOfferTable()" class="search-btn">Search</button></td>
						</tr>
					</tbody>
				</table>
			</div>
			
			<div id="companyOfferTableDivId" >
				<table id="companyOfferDynamicTable">
				</table>
				<button id="addNewCompanyOffer" onclick="newCompanyOffer()">Add new</button>
			</div>
			<div id="companyOfferFormDivId">
			<input type="hidden" id="hiddenCODID" />
			<table>
				<tr>
					<td>
						<table>
							<tr>
								<td>Offer Name :</td>
								<td><input type="text" id="offerNameId" placeholder="Offer Name"></td>
							</tr>
							<tr>
								<td>Offer Description :</td>
								<td><input type="text" id="offerDescriptionId" placeholder="Offer Desiption"></td>
							</tr>
							<tr>
								<td>Offer Start Date :</td>
								<td><input type="text" class="datepicker" id="offerStartDateId" placeholder="Offer Start Date"></td>
							</tr>
							<tr>
								<td>Offer End Date :</td>
								<td><input type="text" class="datepicker" id="offerEndDateId" placeholder="Offer End Date"></td>
							</tr>
							<tr>
								<td>Offer Status :</td>
								<td><select id="companyOfferStatusId">
									<option value="">Select Status</option>
									<option value="1">Active</option>
									<option value="2">Inactive</option>
								</select></td>
							</tr>
						</table>
					</td>
				</tr>
				
			</table>
				<table>	
					<tr>
						<td></td>
						<td>
							<button id="companyOfferClearBtn" >Clear</button>
							<button id="companyOfferDetailsSaveBtn" onclick="companyOfferSave()">Save</button>
						</td>
					</tr>
				</table>
			</div>
		</div>
	</div>
</body>
  <script>
	  $(function() {
	    $( ".datepicker" ).datepicker({ dateFormat: 'yy-mm-dd' });
	  });
  </script>
</html>