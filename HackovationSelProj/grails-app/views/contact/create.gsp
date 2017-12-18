<%@ page import="hackovationselproj.Contact" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'contact.label', default: 'Contact')}" />
		<title>Create User Profile</title>
	</head>
	<body>
		<a href="#create-contact" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<br/>
			<h1 align = "center">Create User Profile</h1>
			<br/>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<g:hasErrors bean="${contactInstance}">
			<ul class="errors" role="alert">
				<g:eachError bean="${contactInstance}" var="error">
				<li>
					 <g:message code="contact.firstName.maxSize.error" default="Skip to content&hellip;"/>
					<%--<g:message code="contact.firstName.alpha.error" default="Skip to content&hellip;"/>--%>
				</li>
				</g:eachError>
			</ul>
			</g:hasErrors>
			<g:form action="save" >
				<fieldset class="form">
					<g:render template="form"/>
				</fieldset>
				<div align="center">
					<g:submitButton name="create" class="save" value="Create Profile" />
				
		</div>
			</g:form>
			
			<br/><br/><br/>
	</body>
</html>
