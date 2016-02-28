<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<display:table name="districtTable" cellspacing="0" requestURI="./districtSetUp/getDistrictDetailsTable" id="districtTable" sort="external" partialList="true" size="${size}" pagesize="${gridSize}" export="false">

	 <display:column property="districtCode"  headerClass="text-left" class="text-left dynamic-tr" title="District Code"/>
     <display:column property="districtName"  headerClass="text-left" class="text-left dynamic-tr" title="District Name"/>
     <display:column  sortable="false" headerClass="text-center" title="Action" media="html">
		<div class="text-center">
			<button onclick="districtDetailsEdit(${districtTable.DDID})"  class="edit-btn btn btn-primary"><span class="fa fa-edit"> </span>Edit</button>
			<button  onclick="districtDetailsDelete(${districtTable.DDID})" class="delete-btn btn btn-danger"><span class="fa fa-close"></span>Delete</button>
		</div>
	</display:column>
	<display:setProperty name="basic.empty.showtable" value="true" />
	<display:setProperty name="basic.msg.empty_list" value="" />
</display:table>
