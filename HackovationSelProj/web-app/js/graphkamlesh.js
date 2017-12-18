/**
 * 
 */

     $(function() {
        var backgroundColor;
       // $('#btn').click(function(){
          $.ajax({
            url : 'http://localhost:8080/HackovationSelProj/report/reportGraphData',//'data.json',  // change url here
            contentType : 'json',
            success : function(res){
              var pieChartData =[],columnChartData = [];
              columnChartData.category = [];
              columnChartData.data = [];
                res.data.forEach(function(item){
                    pieChartData.push({name : item["BrandName"], y : item["Quantity"]});
                    columnChartData.category.push(item["BrandName"]);
                    columnChartData.data.push({
                        name: item["BrandName"],
                        data: [item["Quantity"]]
                    })  
                })
                drawTable(res);
                drawPieChart('#chart1',res.Data_title,pieChartData);
                drawColumnChart('#chart2',res.Data_title,columnChartData);
            },
            error : function(){
              alert('error');
            }
          });
       // });
      
      function drawTable(res){
         var response = res.data;
              $('h1').html(res.Data_title);
              var tr = '<tr>'
              for (var j = 0; j < Object.keys(response[0]).length; j++) {
                   var th = '<th>';
                   th+= Object.keys(response[0])[j] + '</th>';
                   tr+=th;
              };
              tr+= '</tr>'; 
               $('thead').append(tr);
              for (var i = 0; i < response.length; i++) {
                var tr = '<tr>';
                for (var j = 0; j < Object.keys(response[i]).length; j++) {
                   var td = '<td style="color:'+res.color+'">';
                   td+= response[i][Object.keys(response[i])[j]] + '</td>';
                   tr+=td;
                };
                tr+='</tr>';
                 $('tbody').append(tr);
              };
      }

      function drawPieChart(id,title,data){
          $(id).highcharts({
             chart: {
                 type: 'pie',
                 options3d: {
                     enabled: true,
                     alpha: 45,
                     beta: 0
                 },
             },
             title: {
                 text: title
             },
             tooltip: {
                 pointFormat: '{series.name}: <b>{point.percentage:.2f}%</b>'
             },
             legend: {
                 align: 'right',
                 verticalAlign: 'top',
                 layout: 'vertical',
                 x: 0,
                 y: 100
             },
             plotOptions: {
                 pie: {
                     allowPointSelect: true,
                     cursor: 'pointer',
                     depth: 35,
                     dataLabels: {
                         enabled: true,
                         format: '<b>{point.percentage:.2f}%</b>',
                         distance: -50,
                         color: 'black'
                     },
                      showInLegend: true
                 }
             },
             series: [{
                 type: 'pie',
                 name: title,
                 data: data
             }],
             func: function(chart) {
                 window.setTimeout(function() {
                     chart.reflow();
                 }, 3000);
             }
         });
      }

      function drawColumnChart(id,title,data){
           $(id).highcharts({
                  chart: {
                      type: 'column',
                      height:300 
                  },
                  credits : {
                    enabled : false
                  },
                  title: {
                      text: title
                  },
                  xAxis: {
                    categories: data.category,
                    crosshair: true
                  },
                  yAxis: {
                      title: {
                          text: 'Numbers Sold'
                      }

                  },
                
                  plotOptions: {
                      series: {
                          borderWidth: 0,
                          dataLabels: {
                              enabled: true,
                              format: '{point.y}'
                          }
                      },
                      showInLegend: true
                  },

                  tooltip: {
                      headerFormat: '<span style="font-size:11px">{series.name}</span><br>',
                      pointFormat: '<span style="color:{point.color}">{point.name}</span>: <b>{point.y}</b> of total<br/>'
                  },
                  series: data.data
              });
           $(window).trigger("resize");
           
        }
       
     })
	