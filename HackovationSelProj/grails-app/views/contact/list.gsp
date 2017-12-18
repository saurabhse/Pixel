
<%@ page import="hackovationselproj.Contact" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'contact.label', default: 'Contact')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-contact" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-contact" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="address" title="${message(code: 'contact.address.label', default: 'Address')}" />
					
						<g:sortableColumn property="contactId" title="${message(code: 'contact.contactId.label', default: 'Contact Id')}" />
					
						<g:sortableColumn property="contactNum" title="${message(code: 'contact.contactNum.label', default: 'Contact Num')}" />
					
						<g:sortableColumn property="dob" title="${message(code: 'contact.dob.label', default: 'Dob')}" />
					
						<g:sortableColumn property="firstName" title="${message(code: 'contact.firstName.label', default: 'First Name')}" />
					
						<g:sortableColumn property="lastName" title="${message(code: 'contact.lastName.label', default: 'Last Name')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${contactInstanceList}" status="i" var="contactInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${contactInstance.id}">${fieldValue(bean: contactInstance, field: "address")}</g:link></td>
					
						<td>${fieldValue(bean: contactInstance, field: "contactId")}</td>
					
						<td>${fieldValue(bean: contactInstance, field: "contactNum")}</td>
					
						<td>${fieldValue(bean: contactInstance, field: "dob")}</td>
					
						<td>${fieldValue(bean: contactInstance, field: "firstName")}</td>
					
						<td>${fieldValue(bean: contactInstance, field: "lastName")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${contactInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
