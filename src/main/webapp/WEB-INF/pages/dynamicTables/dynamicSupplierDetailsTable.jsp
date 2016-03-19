<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<display:table name="supplierDetailsTable" class="tblDisplay display table table-bordered table-striped dynamic-table display_header_class" cellspacing="0" requestURI="./supplierDetailsController/getSupplierDetailsTable" id="supplierDetailsTable" sort="external" partialList="true" size="${size}" pagesize="${gridSize}" export="false">

	 <display:column property="supplierFirstName" sortable="false" sortName="supplierFirstName" headerClass="text-left sortable sorted order1" class="text-left" title="First Name"/>
     <display:column property="supplierLastName" sortable="false" sortName="supplierLastName" headerClass="text-left sortable sorted order1" class="text-left" title="Last Name"/>
     <display:column property="supplierEmail" sortable="false" sortName="supplierEmail" headerClass="text-left sortable sorted order1" class="text-left" title="E mail"/>
     <display:column property="supplierTp1" sortable="false" sortName="supplierTp1" headerClass="text-left sortable sorted order1" class="text-left" title="TP 1"/>
    <%--  <display:column property="supplierType" sortable="false" sortName="supplierType" headerClass="text-left sortable sorted order1" class="text-left" title="Type"/> --%>
     <display:column property="status" sortable="false" sortName="status" headerClass="text-left sortable sorted order1" class="text-left" title="Status"/>
     <display:column  sortable="false" headerClass="text-center sortable sorted order1" title="Action" media="html" class="action">
		<div class="text-center">
			<button onclick="supplierDetailsEdit(${supplierDetailsTable.SPDID})" class="edit-btn btn btn-primary"><span class="fa fa-edit"> </span>Edit</button>
			<button  onclick="supplierDetailsDelete(${supplierDetailsTable.SPDID})" class="delete-btn btn btn-danger"><span class="fa fa-close"></span>Delete</button>
		</div>
	</display:column>
	<display:setProperty name="basic.empty.showtable" value="true" />
	<display:setProperty name="basic.msg.empty_list" value="" />
</display:table>