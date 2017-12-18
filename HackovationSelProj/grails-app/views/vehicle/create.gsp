<%@ page import="hackovationselproj.Vehicle" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'vehicle.label', default: 'Vehicle')}" />
		<title>Register Your Vehicle</title>
	</head>
	<body>
		<a href="#create-vehicle" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<br>
			<h1 align="center">Register Your Vehicle</h1>
			<br>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<g:hasErrors bean="${vehicleInstance}">
			<ul class="errors" role="alert">
				<g:eachError bean="${vehicleInstance}" var="error">
				<li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
				</g:eachError>
			</ul>
			</g:hasErrors>
			<g:form action="save" >
				<fieldset class="form">
					<g:render template="form"/>
				</fieldset>
				<div align="center">
					<g:submitButton name="create" class="save" value="Register" />
				</div><br><br><br>
			</g:form>
		
	</body>
</html>
