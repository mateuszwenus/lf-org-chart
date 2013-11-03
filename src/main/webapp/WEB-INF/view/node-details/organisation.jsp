<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<h3>Organization details</h3>
<aui:fieldset column="true">
	<aui:field-wrapper label="organization-id">${organization.organizationId}&nbsp;</aui:field-wrapper>
	<aui:field-wrapper label="organization-name">${organization.name}&nbsp;</aui:field-wrapper>
</aui:fieldset>
