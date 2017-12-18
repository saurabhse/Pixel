
<%@ page import="hackovationselproj.Vehicle" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'vehicle.label', default: 'Vehicle')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-vehicle" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-vehicle" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="VIN" title="${message(code: 'vehicle.VIN.label', default: 'VIN')}" />
					
						<th><g:message code="vehicle.owner.label" default="Owner" /></th>
					
						<g:sortableColumn property="vehBody" title="${message(code: 'vehicle.vehBody.label', default: 'Veh Body')}" />
					
						<g:sortableColumn property="vehColor" title="${message(code: 'vehicle.vehColor.label', default: 'Veh Color')}" />
					
						<g:sortableColumn property="vehEngineSize" title="${message(code: 'vehicle.vehEngineSize.label', default: 'Veh Engine Size')}" />
					
						<g:sortableColumn property="vehFuelType" title="${message(code: 'vehicle.vehFuelType.label', default: 'Veh Fuel Type')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${vehicleInstanceList}" status="i" var="vehicleInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${vehicleInstance.id}">${fieldValue(bean: vehicleInstance, field: "VIN")}</g:link></td>
					
						<td>${fieldValue(bean: vehicleInstance, field: "owner")}</td>
					
						<td>${fieldValue(bean: vehicleInstance, field: "vehBody")}</td>
					
						<td>${fieldValue(bean: vehicleInstance, field: "vehColor")}</td>
					
						<td>${fieldValue(bean: vehicleInstance, field: "vehEngineSize")}</td>
					
						<td>${fieldValue(bean: vehicleInstance, field: "vehFuelType")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${vehicleInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
