<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<display:table name="supplierCategoryTable" class="tblDisplay display table table-bordered table-striped dynamic-table display_header_class" cellspacing="0" requestURI="./supplierCategorySetUp/getSupplierCategoryTable" id="supplierCategoryTable" sort="external" partialList="true" size="${size}" pagesize="${gridSize}" export="false">

	 <display:column property="scType"  headerClass="text-left sortable sorted order1" class="text-left" title="Category Type"/>
     <display:column property="scName" headerClass="text-left sortable sorted order1" class="text-left" title="Category Name"/>
     <display:column  sortable="false" headerClass="text-center sortable sorted order1" title="Action" media="html" class="action">
		<div class="text-center">
			<button onclick="supplierCategoryEdit(${supplierCategoryTable.SCID})" class="edit-btn btn btn-primary"><span class="fa fa-edit"> </span>Edit</button>
			<button  onclick="supplierCategoryDelete(${supplierCategoryTable.SCID})" class="delete-btn btn btn-danger"><span class="fa fa-close"></span>Delete</button>
		</div>
	</display:column>
	<display:setProperty name="basic.empty.showtable" value="true" />
	<display:setProperty name="basic.msg.empty_list" value="" />
</display:table>