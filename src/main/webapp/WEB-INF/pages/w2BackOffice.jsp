<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- Bootstrap Core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet"> 
<!-- <link href='css/common-style.css' rel='stylesheet' type='text/css'> -->
<link href='css/backoffice.css' rel='stylesheet' type='text/css'>
<html lang="en">
<script src="js/jquery.js"></script>
<script src="js/smartCSSandJS.js"></script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>W2-Back Office</title>
</head>
<body>
	<div>
		<div style="width:20%;float: left">
		<h3>W2-Back Office</h3>
			<div class="menu">
				<ul><a href="#">Article Details</a></ul>
				<ul><a href="districtSetUp">District Details</a></ul>
				<ul><a href="supplierCategorySetUp">Supplier Category</a></ul>
				<ul><a href="imageCategoryController">Image Category</a></ul>
				<ul><a href="addDetailsController">Add Details</a></ul>
				<ul><a href="companyDetailsController">Supplier Company Details</a></ul>
				<ul><a href="companyPackageDetailsController">Company Package Details</a></ul>
				<ul><a href="companyOfferDetailsController">Company Offer Details</a></ul>
				<ul><a href="supplierDetailsController">Supplier Personal Details</a></ul>
				<ul><a href="fileUploadController">File Image Upload</a></ul>
				
				<!-- <button onclick="removeCSS('css')">Disable CSS</button><button onclick="removeCSS('js')"> Disable JS</button> -->
			</div>
			
		</div>
		<div style="width:80%;float: right" id="content">
		</div>
	</div>
</body>
</html>