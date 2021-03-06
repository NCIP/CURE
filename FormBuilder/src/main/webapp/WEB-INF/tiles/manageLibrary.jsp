<%--
Copyright (C) 2013 HealthCare IT, Inc. - All Rights Reserved
Unauthorized copying or redistribution of this file in source and binary forms via any medium is strictly prohibited
Proprietary and confidential
--%>
<%@ include file="/WEB-INF/includes/taglibs.jsp" %>

<%@ page import="com.healthcit.cacure.utils.Constants"%>
	<c:set var="formListUrl">${appPath}/<%= Constants.QUESTIONNAIREFORM_LISTING_URI %></c:set>
	<c:set var="currentUser" value="${pageContext.request.userPrincipal.name}" />
	<table class="border" width="800" border="0" cellpadding="0" cellspacing="0">
        <tr>
          <td height="20">&nbsp;</td>
        </tr>
		<tr class="d0">
			<td colspan="2" style="width:4%"></td>
			<td align="left" width="180"><h4>Name</h4></td>
			<td align="left" width="230" ><h4>Description</h4></td>
			<td align="left" width="80" ><h4>Author</h4></td>
			<td align="left" width="100" ><h4>Last Update</h4></td>
		</tr>
		<c:forEach items="${modules}" var="current" varStatus="cnt">
	        <c:choose>
	          <c:when test="${(cnt.count % 2) == 0}"><c:set var="rowClassName" value="d0"/></c:when>
	          <c:otherwise><c:set var="rowClassName" value="d1"/></c:otherwise>
	        </c:choose>
	        <tr class="d1" >
				<td style="width:2%;" valign="middle">
					<c:url var="deleteModule" value="<%= Constants.MODULE_LISTING_URI %>" context="${appPath}">
						<c:param name="moduleId" value="${current.id}" />
						<c:param name="delete" value="true" />
					</c:url>
					<a href="${deleteModule}" style="visibility:${(empty current.forms && current.author.userName == currentUser) ? 'visible' : 'hidden'};" onclick="return confirmDelete();">
						<img src="images/delete.png" title="delete" height="18" width="18" border="0"/>
					</a>
				</td>
				<td style="width:2%;" style="vertical-align:middle;" valign="middle">
					<c:url var="moduleEditUrl" value="<%= Constants.MODULE_EDIT_URI %>" context="${appPath}">
						<c:param name="id" value="${current.id}" />
					</c:url>
					<a href="${moduleEditUrl}" >
						<img src="images/edit.png" height="18" width="18" alt="Edit" style="border:none;"/>
					</a>
				</td>
	          <td>
	             <a href="${formListUrl}?moduleId=${current.id}" /><c:out value="${current.description}" /></a>
	          </td>
	          <td><c:out value="${current.comments}" /></td>
	          <td><c:out value="${current.author.userName}" /></td>
			  <td><fmt:formatDate value="${current.updateDate}" type="both"
              		timeStyle="short" dateStyle="short" />
              </td>
	        </tr>
	   </c:forEach>
 </table>

