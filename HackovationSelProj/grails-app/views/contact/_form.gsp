<%@ page import="hackovationselproj.Contact" %>

<table>
	<tr>
		<td>
			<div class="fieldcontain ${hasErrors(bean: contactInstance, field: 'firstName', 'error')} ">
				<label for="firstName">
					<g:message code="contact.firstName.label" default="First Name" />
					
				</label>
				<g:textField name="firstName" value="${contactInstance?.firstName}"/>
			</div>
		</td>
		<td>
			<div class="fieldcontain ${hasErrors(bean: contactInstance, field: 'lastName', 'error')} ">
				<label for="lastName">
					<g:message code="contact.lastName.label" default="Last Name" />
					
				</label>
				<g:textField name="lastName" value="${contactInstance?.lastName}"/>
			</div>
		</td>
	</tr>
	<tr>
		<td>
			<div class="fieldcontain ${hasErrors(bean: contactInstance, field: 'contactNum', 'error')} required">
				<label for="contactNum">
					<g:message code="contact.contactNum.label" default="Contact Num" />
					<span class="required-indicator">*</span>
				</label>
				<g:field name="contactNum" type="number" value="${contactInstance.contactNum}" required=""/>
			</div>

		</td>
		<td>
			<div class="fieldcontain ${hasErrors(bean: contactInstance, field: 'dob', 'error')} ">
				<label for="dob">
					<g:message code="contact.dob.label" default="Dob" />
					
				</label>
				<g:textField name="dob" value="${contactInstance?.dob}"/>
			</div>
		</td>
	</tr>	
	<tr>
		<td>
			<div class="fieldcontain ${hasErrors(bean: contactInstance, field: 'sex', 'error')} ">
				<label for="sex">
					<g:message code="contact.sex.label" default="Sex" />
					
				</label>
				<g:textField name="sex" value="${contactInstance?.sex}"/>
			</div>
		</td>
		<td>
			<div class="fieldcontain ${hasErrors(bean: contactInstance, field: 'occupation', 'error')} ">
				<label for="occupation">
					<g:message code="contact.occupation.label" default="Occupation" />
					
				</label>
				<g:textField name="occupation" value="${contactInstance?.occupation}"/>
			</div>
		</td>
	</tr>		
	<tr>
		<td>
			<div class="fieldcontain ${hasErrors(bean: contactInstance, field: 'contactId', 'error')} ">
				<label for="contactId">
					<g:message code="contact.contactId.label" default="Contact Id" />
					
				</label>
				<g:textField name="contactId" value="${contactInstance?.contactId}"/>
			</div>
		</td>
		<td>
			<div class="fieldcontain ${hasErrors(bean: contactInstance, field: 'address', 'error')} ">
				<label for="address">
					<g:message code="contact.address.label" default="Address" />
					
				</label>
				<g:textField name="address" value="${contactInstance?.address}"/>
			</div>
		</td>
	</tr>		
</table>













