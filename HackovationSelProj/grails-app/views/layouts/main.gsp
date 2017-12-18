<!DOCTYPE html>
<!--[if lt IE 7 ]> <html lang="en" class="no-js ie6"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="no-js ie7"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="no-js ie8"> <![endif]-->
<!--[if IE 9 ]>    <html lang="en" class="no-js ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!--> <html lang="en" class="no-js"><!--<![endif]-->
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<title><g:layoutTitle default="Grails"/></title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link rel="shortcut icon" href="${resource(dir: 'images', file: 'favicon.ico')}" type="image/x-icon">
		<link rel="apple-touch-icon" href="${resource(dir: 'images', file: 'apple-touch-icon.png')}">
		<link rel="apple-touch-icon" sizes="114x114" href="${resource(dir: 'images', file: 'apple-touch-icon-retina.png')}">
		<link rel="stylesheet" href="${resource(dir: 'css', file: 'main.css')}" type="text/css">
		<link rel="stylesheet" href="${resource(dir: 'css', file: 'mobile.css')}" type="text/css">
		<g:layoutHead/>
		<r:layoutResources />
	</head>
	<body>
		<div id="grailsLogo" role="banner" align="center"><a href="http://grails.org"><img width="1200" height="180" src="${resource(dir: 'images', file: 'carrrr.gif')}" alt="Grails"/></a>
		</div>
			<div id="menuHeader">
				<ul>
				<li><a href="/HackovationSelProj">Home</a></li>
				<li><a href="/HackovationSelProj/Contact/create">Create User Profile</a></li>
				<li><a href="/HackovationSelProj/Vehicle/create">Register Your Car</a></li>
				<li><a href="/HackovationSelProj/Vehicle/show">View Your Car Registration</a></li>
				<li><a href="/HackovationSelProj/Report/reportGrid">User Report (Grid)</a></li>
				<li><a href="/HackovationSelProj/Report/reportGraph">Vehicle Report (Graphs)</a></li>
				</ul>
			</div>
		
		<g:layoutBody/>
		
		<div class="footer" role="contentinfo"></div>
		<div id="spinner" class="spinner" style="display:none;"><g:message code="spinner.alt" default="Loading&hellip;"/></div>
		<g:javascript library="application"/>
		<r:layoutResources />
	</body>
</html>
