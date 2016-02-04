<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<display:table name="addDetailsTable" class="tblDisplay display table table-bordered table-striped dynamic-table display_header_class" cellspacing="0" requestURI="./addDetailsController/getAddDetailTable" id="addDetailsTable" sort="external" partialList="true" size="${size}" pagesize="${gridSize}" export="false">

	 <display:column title="Add Image" headerClass="text-left">	 
		<div class="col-md-12">
			<div class="col-md-2">
				<c:if test="${addDetailsTable.ITID != '0'}">
					<img src="./fileUploadController/imageDownloader1?ITID=${addDetailsTable.ITID}" width="80" height="60" alt="Logo">
				</c:if>
				<c:if test="${addDetailsTable.ITID == '0'}">
					No Image
				</c:if>
				<%-- <img src="./fileUploadController/imageDownloader1?ITID=${addDetailsTable.ITID}" width="80" height="60" alt="Logo"> --%>
			</div>
		</div>
	 </display:column>

	 <display:column property="addSupplierName" sortable="false" sortName="addSupplierName" headerClass="text-left sortable sorted order1" class="text-left" title="Owner Name"/>
     <display:column property="addSupplierTp" sortable="false" sortName="addSupplierTp" headerClass="text-left sortable sorted order1" class="text-left" title="Owner TP"/>
     <display:column property="addRegisteredDate" sortable="false" sortName="addRegisteredDate" headerClass="text-left sortable sorted order1" class="text-left" title="Reg Date"/>
     <display:column property="addStatus" sortable="false" sortName="addStatus" headerClass="text-left sortable sorted order1" class="text-left" title="Status"/>
<%--      <display:column property="supplierTp2" sortable="true" sortName="supplierTp2" headerClass="text-left sortable sorted order1" class="text-left" title="TP 2"/>
     <display:column property="supplierSkypeAddress" sortable="true" sortName="supplierSkypeAddress" headerClass="text-left sortable sorted order1" class="text-left" title="Skype"/> --%>
     <display:column  sortable="false" headerClass="text-center sortable sorted order1" title="Action" media="html">
		<div class="text-center">
			<%-- <button  onclick="companyDetailsView(${companyDetailsTable.SCDID})" class="view-btn"><span class="fa fa-view"></span>View</button> --%>
			<button onclick="addDetailsEdit(${addDetailsTable.AID})" class="edit-btn btn btn-primary"><span class="fa fa-edit"> </span>Edit</button>
			<button  onclick="addDetailsDelete(${addDetailsTable.AID})" class="delete-btn btn btn-danger"><span class="fa fa-close"></span>Delete</button>
		</div>
	</display:column>
	<display:setProperty name="basic.empty.showtable" value="true" />
	<display:setProperty name="basic.msg.empty_list" value="" />
</display:table>