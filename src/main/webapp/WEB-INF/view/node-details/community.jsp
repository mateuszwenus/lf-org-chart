<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<h3>Community details</h3>
<aui:fieldset column="true">
	<aui:field-wrapper label="community-id">${community.groupId}&nbsp;</aui:field-wrapper>
	<aui:field-wrapper label="community-name">${community.name}&nbsp;</aui:field-wrapper>
</aui:fieldset>
