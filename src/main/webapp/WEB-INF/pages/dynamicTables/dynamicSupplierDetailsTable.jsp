<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<display:table name="supplierDetailsTable" class="tblDisplay display table table-bordered table-striped dynamic-table display_header_class" cellspacing="0" requestURI="./supplierDetailsController/getSupplierDetailsTable" id="supplierDetailsTable" sort="external" partialList="true" size="${size}" pagesize="${gridSize}" export="false">

	 <display:column property="supplierFirstName" sortable="true" sortName="supplierFirstName" headerClass="text-left sortable sorted order1" class="text-left" title="First Name"/>
     <display:column property="supplierLastName" sortable="true" sortName="supplierLastName" headerClass="text-left sortable sorted order1" class="text-left" title="Last Name"/>
     <display:column property="supplierEmail" sortable="true" sortName="supplierEmail" headerClass="text-left sortable sorted order1" class="text-left" title="E mail"/>
     <display:column property="supplierTp1" sortable="true" sortName="supplierTp1" headerClass="text-left sortable sorted order1" class="text-left" title="TP 1"/>
     <display:column property="supplierTp2" sortable="true" sortName="supplierTp2" headerClass="text-left sortable sorted order1" class="text-left" title="TP 2"/>
     <display:column property="supplierSkypeAddress" sortable="true" sortName="supplierSkypeAddress" headerClass="text-left sortable sorted order1" class="text-left" title="Skype"/>
     <display:column  sortable="false" headerClass="text-center sortable sorted order1" title="Action" media="html">
		<div class="text-center">
			<button onclick="supplierDetailsEdit(${supplierDetailsTable.SPDID})" class="edit-btn"><span class="fa fa-edit"> </span>Edit</button>
			<button  onclick="supplierDetailsDelete(${supplierDetailsTable.SPDID})" class="delete-btn"><span class="fa fa-close"></span>Delete</button>
		</div>
	</display:column>
	<display:setProperty name="basic.empty.showtable" value="true" />
	<display:setProperty name="basic.msg.empty_list" value="" />
</display:table>