<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<h3>Team details</h3>
<aui:fieldset column="true">
	<aui:field-wrapper label="team-id">${team.teamId}&nbsp;</aui:field-wrapper>
	<aui:field-wrapper label="name">${team.name}&nbsp;</aui:field-wrapper>
</aui:fieldset>
