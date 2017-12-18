<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main"/>
		<title>Welcome to Grails</title>
	<link rel="stylesheet" href="${resource(dir: 'css', file: 'main.css')}" type="text/css">
		
		
	</head>
	<body>
	<a href="#page-body" class="skip"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
	
		<div id="controller-list" role="navigation">
			<ul>
				<g:each var="c" in="${grailsApplication.controllerClasses.sort { it.fullName } }">
					<li class="controller"><g:link controller="${c.logicalPropertyName}">${c.fullName}</g:link></li>
				</g:each>
			</ul>
		</div>
			
	</body>
</html>
