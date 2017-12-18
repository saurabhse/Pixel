<%@ page import="hackovationselproj.Vehicle" %>

<table>
	<tr>
		<td>
			<div class="fieldcontain ${hasErrors(bean: vehicleInstance, field: 'VIN', 'error')} required">
			<label for="VIN"  style="width:250px">
				<g:message code="vehicle.VIN.label" default="Vehicle Identification Number" />
				<span class="required-indicator">*</span>
			</label>
			<g:textField name="VIN" value="${vehicleInstance.VIN}"/>
			</div>
		</td>
		<td>
			<div class="fieldcontain ${hasErrors(bean: vehicleInstance, field: 'vehBody', 'error')} ">
				<label for="vehBody"  style="width:250px">
				<g:message code="vehicle.vehBody.label" default="Vehicle Body" />
				</label>
			<g:textField name="vehBody" value="${vehicleInstance?.vehBody}"/>
			</div>
			
		</td>
	</tr>
		<tr>
		<td>
			<div class="fieldcontain ${hasErrors(bean: vehicleInstance, field: 'vehColor', 'error')} ">
				<label for="vehColor" style="width:250px">
					<g:message code="vehicle.vehColor.label" default="Vehicle Color" />
					
				</label>
				<g:textField name="vehColor" value="${vehicleInstance?.vehColor}"/>
			</div>
		</td>
		<td>
			<div class="fieldcontain ${hasErrors(bean: vehicleInstance, field: 'vehEngineSize', 'error')} ">
				<label for="vehEngineSize"  style="width:250px">
					<g:message code="vehicle.vehEngineSize.label" default="Vehicle Engine Size" />
					
				</label>
				<g:textField name="vehEngineSize" value="${vehicleInstance?.vehEngineSize}"/>
			</div>
		</td>
	</tr>
	
	<tr>
		<td>
			<div class="fieldcontain ${hasErrors(bean: vehicleInstance, field: 'vehType', 'error')} ">
				<label for="vehType" style="width:250px">
					<g:message code="vehicle.vehType.label" default="Vehicle Type" />
				</label>
				<g:select id="vehType" name="vehType" from="['HatchBack','SUV','SEDAN','XUV','LUV']" required="" value="${vehicleInstance?.vehType}" class="many-to-one"/>
			</div>
		</td>
		<td>
			<div class="fieldcontain ${hasErrors(bean: vehicleInstance, field: 'vehFuelType', 'error')} ">
				<label for="vehFuelType"  style="width:250px">
					<g:message code="vehicle.vehFuelType.label" default="Vehicle Fuel Type" />
				</label>
				<g:select id="vehFuelType" name="vehFuelType" from="['Petrol','Diesel']" required="" value="${vehicleInstance?.vehFuelType}" class="many-to-one"/>
			</div>
		</td>
	</tr>
		
	<tr>
		<td>
			<div class="fieldcontain ${hasErrors(bean: vehicleInstance, field: 'vehMaker', 'error')} required">
				<label for="vehMaker" style="width:250px">
					<g:message code="vehicle.vehMaker.label" default="Vehicle Maker" />
					<span class="required-indicator">*</span>
				</label>
				<g:select id="vehMaker" name="vehMaker.id" from="${hackovationselproj.VehicleMaker.list()}" optionKey="id" required="" value="${vehicleInstance?.vehMaker?.id}" class="many-to-one"/>
			</div>
		</td>
		<td>
			<div class="fieldcontain ${hasErrors(bean: vehicleInstance, field: 'vehModel', 'error')} required">
				<label for="vehModel"  style="width:250px">
					<g:message code="vehicle.vehModel.label" default="Vehice Model" />
					<span class="required-indicator">*</span>
				</label>
				<g:select id="vehModel" name="vehModel.id" from="${hackovationselproj.VehicleModel.list()}" optionKey="id" required="" value="${vehicleInstance?.vehModel?.id}" class="many-to-one"/>
			</div>
		</td>
	</tr>
	
		<tr>
		<td>
			<div class="fieldcontain ${hasErrors(bean: vehicleInstance, field: 'owner', 'error')} required">
				<label for="owner" style="width:250px">
					<g:message code="vehicle.owner.label" default="Vehicle Owner" />
					<span class="required-indicator">*</span>
				</label>
				<g:select id="owner" name="owner.id" from="${hackovationselproj.Contact.list()}" optionKey="id" required="" value="${vehicleInstance?.owner?.id}" class="many-to-one"/>
			</div>
		</td>
		<td>
			<div class="fieldcontain ${hasErrors(bean: vehicleInstance, field: 'yearOfManufacture', 'error')} ">
				<label for="yearOfManufacture"  style="width:250px">
					<g:message code="vehicle.yearOfManufacture.label" default="Year Of Manufacture" />
				</label>
				<g:select id="yearOfManufacture" name="yearOfManufacture" from="[1985,1986,1987,1988,1989,1990,1991,1992,1993,1994,1995,1996,1997,1998,1999,2000,2001,2002,2003,2004,2005,2006,2007,2008,2009,2010,2011,2012,2013,2014,2015]" required="" value="${vehicleInstance?.yearOfManufacture}" class="many-to-one"/>
			</div>
		</td>
	</tr>
	
	<tr>
		<td>
			<div class="fieldcontain ${hasErrors(bean: vehicleInstance, field: 'vehSeatingCapacity', 'error')} required">
				<label for="vehSeatingCapacity" style="width:250px">
					<g:message code="vehicle.vehSeatingCapacity.label" default="Vehicle Seating Capacity" />
					<span class="required-indicator">*</span>
				</label>
				<g:select id="vehSeatingCapacity" name="vehSeatingCapacity" from="[1,2,3,4,5,6,7,8,9,10,11,12,13,14,15]" required="" value="${vehicleInstance?.vehSeatingCapacity}" class="many-to-one"/>
			</div>
		</td>
		<td>
			<div class="fieldcontain ${hasErrors(bean: vehicleInstance, field: 'vehWeight', 'error')} required">
				<label for="vehWeight"  style="width:250px">
					<g:message code="vehicle.vehWeight.label" default="Vehicle Weight" />
					<span class="required-indicator">*</span>
				</label>
				<g:textField name="vehWeight" value="${vehicleInstance?.vehWeight}"/>
			</div>
		</td>
	</tr>
</table>
