<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<title>Ext JS in Action Chapter 08</title>
<meta name="layout" content="main">
<r:require module="appgrid"/>
</head>
<body>

<script type="text/javascript">
Ext.onReady(function() {
    var remoteJsonStore =  Ext.create('Ext.data.Store', {
         fields: [],
         proxy: {
             type: 'ajax',
             url: 'reportExtGridData',
             reader: {
                 type: 'json',
                 rootProperty: 'records'
             }
         },
         autoLoad: true
     });

    var columnModel = [
		{
		    header    : 'First Name',
		    dataIndex : 'firstName',
		    sortable  : true, flex : 1
		    
		},
        {
            header    : 'Last Name',
            dataIndex : 'lastName',
            sortable  : true, flex : 1
            
        },
        
        {
            header    : 'Address',
            dataIndex : 'address',
            sortable  : true, flex : 1
            
        },
        {
            header    : 'Occupation',
            dataIndex : 'occupation',
            sortable  : true, flex : 1
            
        },
        {
            header    : 'Gender',
            dataIndex : 'sex',
            sortable  : true, flex : 1
        }
    ];

      Ext.create('Ext.grid.Panel', {
        title: 'User Data',
        store: remoteJsonStore,
        columns: columnModel,
        height:500,
        width: '100%',
        renderTo: Ext.getBody()
    });

});
</script>
</body>
</html>
