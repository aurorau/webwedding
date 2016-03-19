<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>
<!-- Bootstrap Core CSS -->
 <link href="css/bootstrap.min.css" rel="stylesheet">
<!--<link href='css/common-style.css' rel='stylesheet' type='text/css'> -->
<link href='css/backoffice.css' rel='stylesheet' type='text/css'>

<script src="js/jquery.js"></script>
<script src="js/common.js"></script>
<script src="js/jquery.displaytag-ajax-1.2.js"></script>
<script src="js/backOfficeJS/districtDetailsSetUp.js"></script>
<html>
<head>
<title>District Details</title>
</head>
<body>
	<div>
		<div style="width:20%;float: left">
		<h3><a href="backOffice">W2-Back Office</a></h3>
			<div class="menu">
				<ul><a href="#">Article Details</a></ul>
				<ul><b>District Details</b></ul>
				<ul><a href="supplierCategorySetUp">Supplier Category</a></ul>
				<ul><a href="imageCategoryController">Image Category</a></ul>
				<ul><a href="addDetailsController">Add Details</a></ul>
				<ul><a href="companyDetailsController">Supplier Company Details</a></ul>
				<ul><a href="companyPackageDetailsController">Company Package Details</a></ul>
				<ul><a href="companyOfferDetailsController">Company Offers Details</a></ul>
				<ul><a href="supplierDetailsController">Supplier Personal Details</a></ul>
				<ul><a href="fileUploadController">File Image Upload</a></ul>
			</div>
		</div>
					
		<div style="width:80%;float: right" id="content">
			<div style="float: left; width:100%">
			<h3>District Details</h3>
				<table style="float: right">
					<tbody class="search-body">
						<tr>
							<td><input type="text" id="districtDetailsSearchId" placeholder="Search and Filter" class="search-input"/></td>
							<td><button onclick="loadDistrictDetailsTable()" class="search-btn">Search</button></td>
						</tr>
					</tbody>
				</table>
			</div>
			
			<div id="districtTableDivId" >
				<button id="addNewDistrict" onclick="newDistrictDetails()">Add new</button>
					<table id="dristrictDynamicTable" class="dynamic-table">
				
					</table>
			</div>
			<div id="districtFormDivId">
			<input type="hidden" id="hiddenDDID" />
				<table>
					<tr>
						<td>District Code :</td>
						<td><input type="text" id="districtCodeId" placeholder="District Code"></td>
					</tr>
					<tr>
						<td>District Name :</td>
						<td><input type="text" id="districtNameId" placeholder="District Name"></td>
					</tr>
					<tr>
						<td></td>
						<td>
							<button id="districtDetailsClearBtn" >Clear</button>
							<button id="districtDetailsSaveBtn" onclick="districtDetailsSave()">Save</button>
						</td>
					</tr>
				</table>
			</div>
		</div>
	</div>
</body>
</html>