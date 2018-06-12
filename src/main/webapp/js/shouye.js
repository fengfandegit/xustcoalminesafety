/*首页的js*/
			//初始化echarts实例
		    var myChart = echarts.init(document.getElementById('shouye'),'dark');
		    var myChart1 = echarts.init(document.getElementById('shouye1'),'dark');
		    var myChart2 = echarts.init(document.getElementById('shouye2'),'dark');
		    var myChart3 = echarts.init(document.getElementById('shouye3'),'dark');
		    var base = + new Date(2018,4,01);
		    var oneDay = 24*3600*1000;
		    var date = [];
		    var data = [Math.random()*150];
		    var now = new Date(base);
		    var day = 30;
		    function addData(shift){
		        now = [now.getFullYear(),now.getMonth()+1,now.getDate()].join('/');        
		        date.push(now);        
		        data.push((Math.random()-0.5)*10+data[data.length-1]);
		        if (shift) {
		            console.log(data);
		            date.shift();
		            data.shift();
		        }
		        now = new Date(+new Date(now)+oneDay);        
		    }
		
		    for (var i = 0; i < day; i++) {
		        addData();
		    }
		    //设置图标配置项
		    myChart.setOption({
		    	//设置全局背景色
				backgroundColor: 'rgba(0,0,0,0.1)',
		        title:{
		            text:'30天内数据实时更新'
		        },
		        xAxis:{
		            type:"category",
		            boundaryGap:false,
		            data:date
		        },
		        yAxis:{
		            boundaryGap:[0,'100%'],
		            type:'value'
		        },
		        series:[{
		            name:'成交',
		            type:'line',
		            smooth:true, //数据光滑过度
		            symbol:'none', //下一个数据点
		            stack:'a',
		            areaStyle:{
		                normal:{
		                    color:'red'
		                }
		            },
		            data:data,
			        markLine: {
	                    data: [{
	                        type: 'average',
	                        name: '平均值'
	                    }]
	                }
			          
		        }]
		    })
		    setInterval(function(){
		        addData(true);
		        myChart.setOption({
		            xAxis:{
		                data:date
		            },
		            series:[{
		                name:'成交',
		                data:data
		            }]
		        });
		    },2000)
			
			 function addData(shift){
		        now = [now.getFullYear(),now.getMonth()+1,now.getDate()].join('/');        
		        date.push(now);        
		        data.push((Math.random()-0.5)*10+data[data.length-1]);
		        if (shift) {
		            console.log(data);
		            date.shift();
		            data.shift();
		        }
		        now = new Date(+new Date(now)+oneDay);        
		    }
		
		    for (var i = 0; i < day; i++) {
		        addData();
		    }
		    //设置图标配置项
		    myChart3.setOption({
		    	//设置全局背景色
				backgroundColor: 'rgba(0,0,0,0.1)',
		        title:{
		            text:'30天内数据实时更新'
		        },
		        xAxis:{
		            type:"category",
		            boundaryGap:false,
		            data:date
		        },
		        yAxis:{
		            boundaryGap:[0,'100%'],
		            type:'value'
		        },
		        
		        series:[{
		            name:'成交',
		            type:'line',
		            smooth:true, //数据光滑过度
		            symbol:'none', //下一个数据点
		            stack:'a',
		            areaStyle:{
		                normal:{
		                    color:'blue'
		                }
		            },
		            data:data,
		            markLine: {
	                    data: [{
	                        type: 'average',
	                        name: '平均值'
	                    }]
	                }
		        }]
		    })
		    setInterval(function(){
		        addData(true);
		        myChart3.setOption({
		            xAxis:{
		                data:date
		            },
		            series:[{
		                name:'成交',
		                data:data
		            }]
		        });
		    },2000)
			function addData(shift){
		        now = [now.getFullYear(),now.getMonth()+1,now.getDate()].join('/');        
		        date.push(now);        
		        data.push((Math.random()-0.5)*10+data[data.length-1]);
		        if (shift) {
		            console.log(data);
		            date.shift();
		            data.shift();
		        }
		        now = new Date(+new Date(now)+oneDay);        
		    }
		
		    for (var i = 0; i < day; i++) {
		        addData();
		    }