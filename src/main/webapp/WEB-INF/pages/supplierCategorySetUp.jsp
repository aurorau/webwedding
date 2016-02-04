<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>

<!-- Bootstrap Core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href='css/common-style.css' rel='stylesheet' type='text/css'>

<script src="js/jquery.js"></script>
<script src="js/common.js"></script>
<script src="js/jquery.displaytag-ajax-1.2.js"></script>
<script src="js/backOfficeJS/supplierCategorySetUp.js"></script>
<html>
<head>
<title>Supplier Category</title>
</head>
<body>
	<div>
		<div style="width:20%;float: left">
		<h3><a href="backOffice">W2-Back Office</a></h3>
			<div>
				<ul><a href="#">Article Details</a></ul>
				<ul><a href="districtSetUp">District Details</a></ul>
				<ul><b>Supplier Category</b></ul>
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
			<h3>Supplier Category</h3>	
				<table style="float: right">
					<tr>
						<td><input type="text" id="supplierCategorySearchId" placeholder="Search and Filter"/></td>
						<td><button onclick="loadSupplierCategoryTable()">Search</button></td>
					</tr>
				</table>
			</div>
			
			<div id="supplierCategoryTableDivId" >
				<button id="addNewsupplierCategory" onclick="newsupplierCategory()">Add new</button>
					<table id="supplierCategoryDynamicTable">
				
					</table>
			</div>
			<div id="supplierCategoryFormDivId">
			<input type="hidden" id="hiddenSCID" />
				<table>
					<tr>
						<td>Category Type :</td>
						<td><input type="text" id="supplierCategoryTypeId" placeholder="Supplier Category Type"></td>
					</tr>
					<tr>
						<td>Category Name :</td>
						<td><input type="text" id="supplierCategoryNameId" placeholder="Supplier Category Name"></td>
					</tr>
					<tr>
						<td></td>
						<td>
							<button id="supplierCategoryClearBtn" >Clear</button>
							<button id="supplierCategorySaveBtn" onclick="supplierCategorySave()">Save</button>
						</td>
					</tr>
				</table>
			</div>
		</div>
	</div>
</body>
</html>