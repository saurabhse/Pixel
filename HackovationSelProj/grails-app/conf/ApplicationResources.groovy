modules = {
    application {
        resource url:'js/application.js'
    }
	
	appgraph {
		resource url:'css/bootstrap.min.css', disposition: 'head'
		resource url:'js/jquery.js', disposition: 'head'
		resource url:'js/highcharts.js', disposition: 'head'
		
		
	}
	
	appgrid {
		resource url:'css/ext-all.css', disposition: 'head'
		resource url:'js/ext-all-debug.js', disposition: 'head'
	}
	
	custom {
		
		resource url:'js/graphkamlesh.js'
		
	}
	
	custom_1 {
		
		resource url:'js/graphkamlesh_1.js'
		
	}
}