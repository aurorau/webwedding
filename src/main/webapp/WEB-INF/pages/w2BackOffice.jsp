<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="en">
<script src="js/jquery.js"></script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>W2-Back Office</title>
</head>
<body>
	<div>
		<div style="width:20%;float: left">
		<h3>W2-Back Office</h3>
			<div>
				<ul><a href="#">Article Details</a></ul>
				<ul><a href="districtSetUp">District Details</a></ul>
				<ul><a href="#">Company Comments</a></ul>
				<ul><a href="supplierCategorySetUp">Supplier Category</a></ul>
				<ul><a href="imageCategoryController">Image Category</a></ul>
				<ul><a href="addDetailsController">Add Details</a></ul>
				<ul><a href="companyDetailsController">Supplier Company Details</a></ul>
				<ul><a href="supplierDetailsController">Supplier Personal Details</a></ul>
				<ul><a href="fileUploadController">File Image Upload</a></ul>
			</div>
		</div>
		<div style="width:80%;float: right" id="content">
		</div>
	</div>
</body>
</html>