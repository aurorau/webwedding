<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>

<!-- Bootstrap Core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<!-- <link href='css/common-style.css' rel='stylesheet' type='text/css'> -->
<link href='css/backoffice.css' rel='stylesheet' type='text/css'>

<script src="js/jquery.js"></script>
<script src="js/common.js"></script>
<script src="js/jquery.displaytag-ajax-1.2.js"></script>
<script src="https://code.jquery.com/ui/1.11.0/jquery-ui.js"></script>
<script src="js/fileUpload/jquery.iframe-transport.js"></script>
<script src="js/fileUpload/jquery.fileupload.js"></script>
<script src="js/backOfficeJS/imageCategory.js"></script>
<html>
<head>
<title>Image Category</title>
</head>
<body>
	<div>
		<div style="width:20%;float: left">
		<h3><a href="backOffice">W2-Back Office</a></h3>
			<div class="menu">
				<ul><a href="#">Article Details</a></ul>
				<ul><a href="districtSetUp">District Details</a></ul>
				<ul><a href="supplierCategorySetUp">Supplier Category</a></ul>
				<ul><b>Image Category</b></ul>
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
			<h3>Image Category</h3>	
				<table style="float: right">
					<tbody class="search-body">
						<tr>
							<td><input type="text" id="imageCategorySearchId" placeholder="Search and Filter" class="search-input"/></td>
							<td><button onclick="loadImageCategoryTable()" class="search-btn">Search</button></td>
						</tr>
					</tbody>
				</table>
			</div>
			
			<div id="imageCategoryTableDivId" >
				<button id="addNewImageCategory" onclick="newImageCategory()">Add new</button>
					<table id="imageCategoryDynamicTable">
				
					</table>
			</div>
			<div id="imageCategoryFormDivId">
			<input type="hidden" id="hiddenICID"/>
				<table>
					<tr>
						<td>Image Category Type :</td>
						<td><input type="text" id="imageCategoryTypeId" placeholder="Image Category Type"></td>
					</tr>
					<tr>
						<td>Image Category Name :</td>
						<td><input type="text" id="imageCategoryNameId" placeholder="Image Category Name"></td>
					</tr>
					<tr>
						<td>Image Category Logo :</td>
							<td><input id="fileupload" type="file">
						</td>
					</tr>	
					<tr>
						<td></td>
						<td><input type="hidden" id="fileHiddenUrl"></td>
					</tr>
					<tr>
						<td></td>
						<td>
							<button id="imageCategoryClearBtn" >Clear</button>
							<button id="imageCategorySaveBtn" onclick="imageCategorySave()">Save</button>
						</td>
					</tr>
				</table>
			</div>
		</div>
	</div>
</body>
</html>