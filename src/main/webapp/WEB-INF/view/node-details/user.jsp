<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<h3>User details</h3>
<aui:fieldset column="true">
	<aui:field-wrapper label="user-id">${user.userId}&nbsp;</aui:field-wrapper>
	<aui:field-wrapper label="user-screen-name">${user.login}&nbsp;</aui:field-wrapper>
	<aui:field-wrapper label="user-email">${user.emailAddress}&nbsp;</aui:field-wrapper>
</aui:fieldset>
<aui:fieldset column="true">
	<aui:field-wrapper label="user-first-name">${user.firstName}&nbsp;</aui:field-wrapper>
	<aui:field-wrapper label="user-middle-name">${user.middleName}&nbsp;</aui:field-wrapper>
	<aui:field-wrapper label="user-last-name">${user.lastName}&nbsp;</aui:field-wrapper>
</aui:fieldset>