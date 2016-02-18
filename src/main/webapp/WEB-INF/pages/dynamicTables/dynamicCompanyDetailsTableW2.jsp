<%-- <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> --%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<display:table style="width:100%" name="companyDetailsTableW2" requestURI="./companyDetailsController/getCompanyDetailsTableW2" id="companyDetailsTableW2" sort="external" partialList="true" size="${size}" pagesize="${gridSize}" export="false">
	<display:column class="service-list">
<!-- 	<div style="margin-bottom : 20px; background-color:#fff; border:none;"> -->
	<table style="margin-bottom: 30px;box-shadow: 0px 2px 5px 1px rgba(0, 0, 0, 0.15);">
		<tr>
		    <td rowspan=4 class="company-logo">
		    	<img src="./fileUploadController/imageDownloader1?ITID=${companyDetailsTableW2.ITID}" class="img-responsive" alt="" width="203px">
		       <!--  <img src="img/portfolio/hilton.jpg" class="img-responsive" alt="" width="203px"> -->
		    </td>
		    <td colspan=2 class="company" style="width:73%">
		        <span class="company-name">${companyDetailsTableW2.companyName}</span>
		        <!-- <span class="company-location">&nbsp;&ndash;&nbsp;Wadduwa</span> -->
		    </td>
		</tr>
		<tr>
		    <td class="padding-left20 sub-heading">Our Packages</td>
		    <c:if test="${companyDetailsTableW2.packageCount > 0}">
		    	<td>Currently we have ${companyDetailsTableW2.packageCount} packages for you</td>
		    </c:if>
		    <c:if test="${companyDetailsTableW2.packageCount == 0}">
		    	<td>Currently we do not have any package for you</td>
		    </c:if>
		</tr>
		<tr>
		    <td class="border-bottom"></td>
		    <td class="border-bottom">
<!-- 			    <span>package2</span>
			    <span>&nbsp;and more...</span> -->
		    </td>
		</tr>
		<tr>
		    <td class="padding-left20 sub-heading border-bottom">Special Offers</td>
		    <td class="border-bottom">
		    	<c:if test="${companyDetailsTableW2.offerAvailable == true}">
		    		<span class="label label-success offers">Available</span>
		    	</c:if>
			    <c:if test="${companyDetailsTableW2.offerAvailable == false}">
		    		<span class="label label-danger offers">Unavailable</span>
		    	</c:if>
			    
		    </td>
		</tr>
		<tr>
		    <td class="price"><span>Rs.</span><span class="price">${companyDetailsTableW2.budget}</span><span>*</span><span class="fa fa-long-arrow-up margin-left10"></span>
		    </td>
		    <td colspan=2 class="padding-left20">
		        <button class="btn btn-success btn-sm pull-right margin-right10" data-target="#service1" data-toggle="modal" onclick="getCompanyDetailsW2(${companyDetailsTableW2.SCDID})"><span class="fa fa-eye"></span>View More</button>
		
		        <button class="btn btn-sm cal-budget" onclick="addToCart('${companyDetailsTableW2.SCDID}','${companyDetailsTableW2.companyName}','${companyDetailsTableW2.budget}')"><span class="fa fa-calculator"></span>Calculate Budget</button>
		
		    </td>
		
		</tr>
		</table>
<!-- 		<br> -->
<!-- 		</div> -->
		<!-- <div class="clearfix"></div> -->
	</display:column>
	<display:setProperty name="basic.empty.showtable" value="true" />
	<display:setProperty name="basic.msg.empty_list" value="" />
</display:table>
<script type="text/javascript">

	$(document).ready(function() {
		$('.pagebanner').hide();
		//alert($('.pagebanner').text());
	});
     	 
</script>