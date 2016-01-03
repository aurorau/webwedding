<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>
<!-- Bootstrap Core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">

<link href='css/common-style.css' rel='stylesheet' type='text/css'>

<script src="js/jquery.js"></script>
<script src="js/common.js"></script>
<script src="js/jquery.displaytag-ajax-1.2.js"></script>
<script src="js/backOfficeJS/districtDetailsSetUp.js"></script>
<html>
<head>
</head>
<body>
	<div>
		<div style="width:20%;float: left">
		<h3>W2-Back Office</h3>
			<div>
				<ul><a href="#">Article Set up</a></ul>
				<ul><a >District Details</a></ul>
				<ul><a href="#">Category Gallery</a></ul>
				<ul><a href="#">Company Category</a></ul>
				<ul><a href="#">Company Comments</a></ul>
				<ul><a href="supplierCategorySetUp">Supplier Category</a></ul>
				<ul><a href="#">Supplier Company Details</a></ul>
				<ul><a href="#">Supplier Personal Details</a></ul>
			</div>
		</div>
					
		<div style="width:80%;float: right" id="content">
			<div style="float: left; width:100%">
			<h3>District Details</h3>
				<table style="float: right">
					<tr>
						<td><input type="text" id="districtDetailsSearchId" placeholder="Search and Filter"/></td>
						<td><button onclick="loadDistrictDetailsTable()">Search</button></td>
					</tr>
				</table>
			</div>
			
			<div id="districtTableDivId" >
				<button id="addNewDistrict" onclick="newDistrictDetails()">Add new</button>
					<table id="dristrictDynamicTable">
				
					</table>
			</div>
			<div id="districtFormDivId">
			<input type="hidden" id="hiddenDDID" />
				<table>
					<tr>
						<td>District Code :</td>
						<td><input type="text" id="districtCodeId" title="District Code"></td>
					</tr>
					<tr>
						<td>District Name :</td>
						<td><input type="text" id="districtNameId" title="District Name"></td>
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