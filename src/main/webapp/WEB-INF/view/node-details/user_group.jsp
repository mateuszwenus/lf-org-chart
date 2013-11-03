<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<h3>User Group details</h3>
<aui:fieldset column="true">
	<aui:field-wrapper label="user-group-id">${userGroup.userGroupId}&nbsp;</aui:field-wrapper>
	<aui:field-wrapper label="user-group-name">${userGroup.name}&nbsp;</aui:field-wrapper>
</aui:fieldset>
