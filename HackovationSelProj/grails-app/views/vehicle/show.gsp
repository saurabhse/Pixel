
<%@ page import="hackovationselproj.Vehicle" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'vehicle.label', default: 'Vehicle')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-vehicle" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-vehicle" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list vehicle">
			
				<g:if test="${vehicleInstance?.VIN}">
				<li class="fieldcontain">
					<span id="VIN-label" class="property-label"><g:message code="vehicle.VIN.label" default="VIN" /></span>
					
						<span class="property-value" aria-labelledby="VIN-label"><g:fieldValue bean="${vehicleInstance}" field="VIN"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${vehicleInstance?.owner}">
				<li class="fieldcontain">
					<span id="owner-label" class="property-label"><g:message code="vehicle.owner.label" default="Owner" /></span>
					
						<span class="property-value" aria-labelledby="owner-label"><g:link controller="contact" action="show" id="${vehicleInstance?.owner?.id}">${vehicleInstance?.owner?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${vehicleInstance?.registrants}">
				<li class="fieldcontain">
					<span id="registrants-label" class="property-label"><g:message code="vehicle.registrants.label" default="Registrants" /></span>
					
						<g:each in="${vehicleInstance.registrants}" var="r">
						<span class="property-value" aria-labelledby="registrants-label"><g:link controller="registrant" action="show" id="${r.id}">${r?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${vehicleInstance?.vehBody}">
				<li class="fieldcontain">
					<span id="vehBody-label" class="property-label"><g:message code="vehicle.vehBody.label" default="Veh Body" /></span>
					
						<span class="property-value" aria-labelledby="vehBody-label"><g:fieldValue bean="${vehicleInstance}" field="vehBody"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${vehicleInstance?.vehColor}">
				<li class="fieldcontain">
					<span id="vehColor-label" class="property-label"><g:message code="vehicle.vehColor.label" default="Veh Color" /></span>
					
						<span class="property-value" aria-labelledby="vehColor-label"><g:fieldValue bean="${vehicleInstance}" field="vehColor"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${vehicleInstance?.vehEngineSize}">
				<li class="fieldcontain">
					<span id="vehEngineSize-label" class="property-label"><g:message code="vehicle.vehEngineSize.label" default="Veh Engine Size" /></span>
					
						<span class="property-value" aria-labelledby="vehEngineSize-label"><g:fieldValue bean="${vehicleInstance}" field="vehEngineSize"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${vehicleInstance?.vehFuelType}">
				<li class="fieldcontain">
					<span id="vehFuelType-label" class="property-label"><g:message code="vehicle.vehFuelType.label" default="Veh Fuel Type" /></span>
					
						<span class="property-value" aria-labelledby="vehFuelType-label"><g:fieldValue bean="${vehicleInstance}" field="vehFuelType"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${vehicleInstance?.vehMaker}">
				<li class="fieldcontain">
					<span id="vehMaker-label" class="property-label"><g:message code="vehicle.vehMaker.label" default="Veh Maker" /></span>
					
						<span class="property-value" aria-labelledby="vehMaker-label"><g:link controller="vehicleMaker" action="show" id="${vehicleInstance?.vehMaker?.id}">${vehicleInstance?.vehMaker?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${vehicleInstance?.vehModel}">
				<li class="fieldcontain">
					<span id="vehModel-label" class="property-label"><g:message code="vehicle.vehModel.label" default="Veh Model" /></span>
					
						<span class="property-value" aria-labelledby="vehModel-label"><g:link controller="vehicleModel" action="show" id="${vehicleInstance?.vehModel?.id}">${vehicleInstance?.vehModel?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
			
			
				<g:if test="${vehicleInstance?.vehSeatingCapacity}">
				<li class="fieldcontain">
					<span id="vehSeatingCapacity-label" class="property-label"><g:message code="vehicle.vehSeatingCapacity.label" default="Veh Seating Capacity" /></span>
					
						<span class="property-value" aria-labelledby="vehSeatingCapacity-label"><g:fieldValue bean="${vehicleInstance}" field="vehSeatingCapacity"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${vehicleInstance?.vehType}">
				<li class="fieldcontain">
					<span id="vehType-label" class="property-label"><g:message code="vehicle.vehType.label" default="Veh Type" /></span>
					
						<span class="property-value" aria-labelledby="vehType-label"><g:fieldValue bean="${vehicleInstance}" field="vehType"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${vehicleInstance?.vehWeight}">
				<li class="fieldcontain">
					<span id="vehWeight-label" class="property-label"><g:message code="vehicle.vehWeight.label" default="Veh Weight" /></span>
					
						<span class="property-value" aria-labelledby="vehWeight-label"><g:fieldValue bean="${vehicleInstance}" field="vehWeight"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${vehicleInstance?.yearOfManufacture}">
				<li class="fieldcontain">
					<span id="yearOfManufacture-label" class="property-label"><g:message code="vehicle.yearOfManufacture.label" default="Year Of Manufacture" /></span>
					
						<span class="property-value" aria-labelledby="yearOfManufacture-label"><g:fieldValue bean="${vehicleInstance}" field="yearOfManufacture"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${vehicleInstance?.id}" />
					<g:link class="edit" action="edit" id="${vehicleInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
