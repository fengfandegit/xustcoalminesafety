/*预警信息报表*/
			var Chart1 = echarts.init(document.getElementById("nongdu"),'dark');
			var Chart2 = echarts.init(document.getElementById("liuliang"),'dark');
			var Chart3 = echarts.init(document.getElementById("wendu"),'dark');
			var Chart4 = echarts.init(document.getElementById("fuya"),'dark');
			var Option1 = {
				//设置全局背景色
				backgroundColor: 'rgba(0,0,0,0.1)',
				
				//定义一个标题
				title:{
					text:"瓦斯浓度图"
				},
				legend:{
					data:['瓦斯浓度']
				},
				xAxis:{
					data:[]
				},
				yAxis:{
					 axisLabel:{show:true},//y轴文字
			        axisLine: {show: true},//y轴线是否显示
			    },
			    tooltip : {//鼠标移入折点显示悬浮框
			       show:true,
					formatter:'系列名：{a}<br />时间：{b}<br />数值：{c}'
				},
				//name=legend.data才能显示图例
				series:[{
					name:"瓦斯浓度",
					type:'line',
					data:[],
					areaStyle: {normal: {//设置线下面部分颜色渐变
			            color: new echarts.graphic.LinearGradient(
			                0, 0, 0, 1,
			                [
			                    {offset: 0, color: '#3e4abb'},
			                    {offset: 0.5, color: '#222f77'},
			                    {offset: 1, color: '#182250'}
			                ]
			            )
			        }},
			        
			        symbol: 'emptyCircle',     //设定为空心点
			        
			        itemStyle:{
			            normal:{
			                color:'#595de4',//折点颜色
			                lineStyle:{
			                    color:'#595de4',//折线颜色
			                    width:'2'
			                }
			            }
			        }
				}]
			};
			Chart1.setOption(Option1);
			var Option2 = {
				//设置全局背景色
				backgroundColor: 'rgba(0,0,0,0.1)',
				
				//定义一个标题
				title:{
					text:"瓦斯流量图"
				},
				legend:{
					data:['瓦斯流量']
				},
				xAxis:{
					data:[]
				},
				yAxis:{
					 axisLabel:{show:true},//y轴文字
			        axisLine: {show: true},//y轴线是否显示
			    },
			    tooltip : {//鼠标移入折点显示悬浮框
			       show:true,
					formatter:'系列名：{a}<br />时间：{b}<br />数值：{c}'
				},
				//name=legend.data才能显示图例
				series:[{
					name:"瓦斯流量",
					type:'line',
					data:[],
					areaStyle: {normal: {//设置线下面部分颜色渐变
			            color: new echarts.graphic.LinearGradient(
			                0, 0, 0, 1,
			                [
			                    {offset: 0, color: '#3e4abb'},
			                    {offset: 0.5, color: '#222f77'},
			                    {offset: 1, color: '#182250'}
			                ]
			            )
			        }},
			        
			        symbol: 'emptyCircle',     //设定为空心点
			        
			        itemStyle:{
			            normal:{
			                color:'#595de4',//折点颜色
			                lineStyle:{
			                    color:'#595de4',//折线颜色
			                    width:'2'
			                }
			            }
			        }
				}]
			};
			Chart2.setOption(Option2);
			var Option3 = {
				//设置全局背景色
				backgroundColor: 'rgba(0,0,0,0.1)',
				
				//定义一个标题
				title:{
					text:"管道温度图"
				},
				legend:{
					data:['管道温度']
				},
				xAxis:{
					data:[]
				},
				yAxis:{
					 axisLabel:{show:true},//y轴文字
			        axisLine: {show: true},//y轴线是否显示
			    },
			    tooltip : {//鼠标移入折点显示悬浮框
			       show:true,
					formatter:'系列名：{a}<br />时间：{b}<br />数值：{c}'
				},
				//name=legend.data才能显示图例
				series:[{
					name:"管道温度",
					type:'line',
					data:[],
					areaStyle: {normal: {//设置线下面部分颜色渐变
			            color: new echarts.graphic.LinearGradient(
			                0, 0, 0, 1,
			                [
			                    {offset: 0, color: '#3e4abb'},
			                    {offset: 0.5, color: '#222f77'},
			                    {offset: 1, color: '#182250'}
			                ]
			            )
			        }},
			        
			        symbol: 'emptyCircle',     //设定为空心点
			        
			        itemStyle:{
			            normal:{
			                color:'#595de4',//折点颜色
			                lineStyle:{
			                    color:'#595de4',//折线颜色
			                    width:'2'
			                }
			            }
			        }
				}]
			};
			Chart3.setOption(Option3);
			var Option4 = {
				//设置全局背景色
				backgroundColor: 'rgba(0,0,0,0.1)',
				
				//定义一个标题
				title:{
					text:"管道负压图"
				},
				legend:{
					data:['管道负压']
				},
				xAxis:{
					data:[]
				},
				yAxis:{
					 axisLabel:{show:true},//y轴文字
			        axisLine: {show: true},//y轴线是否显示
			    },
			    tooltip : {//鼠标移入折点显示悬浮框
			       show:true,
					formatter:'系列名：{a}<br />时间：{b}<br />数值：{c}'
				},
				//name=legend.data才能显示图例
				series:[{
					name:"管道负压",
					type:'line',
					data:[],
					areaStyle: {normal: {//设置线下面部分颜色渐变
			            color: new echarts.graphic.LinearGradient(
			                0, 0, 0, 1,
			                [
			                    {offset: 0, color: '#3e4abb'},
			                    {offset: 0.5, color: '#222f77'},
			                    {offset: 1, color: '#182250'}
			                ]
			            )
			        }},
			        
			        symbol: 'emptyCircle',     //设定为空心点
			        
			        itemStyle:{
			            normal:{
			                color:'#595de4',//折点颜色
			                lineStyle:{
			                    color:'#595de4',//折线颜色
			                    width:'2'
			                }
			            }
			        }
				}]
			};
			Chart4.setOption(Option4);
			var time1=[];    //时间数组（实际用来盛放X轴坐标值）
        	 var num1=[];    //数据数组（实际用来盛放Y坐标值）
        	 var time2 = [];
        	 var num2 = [];
        	 var time3 = [];
        	 var num3 = [];
        	 var time4 = [];
        	 var num4 = [];
        	 //点击查询
			$(".chaxunjilu .btn-warning").click(function(){
				$(".chaxunjilu .table").css("display","block");
				var no = '0-16通道分站';
				if($(".chaxunjilu select").val()=='0-16通道分站'){
					no = '1_1_1_1';
				}else if($(".chaxunjilu select").val()=="1-4通道分站"){
					no='2_2_2_2';
				}
				var starttime = $("#time_1").val();
				starttime = starttime.substring(0,10);
				var arr = starttime.split("-");
				starttime = arr.join("");
				var endtime = $("#time_2").val();
				endtime = endtime.substring(0,10);
				var arr = endtime.split("-");
				endtime = arr.join("");
				$.ajax({
					type:"get",
					url:url+"/readdata/gethistorydata?callback=?",
					data:{
						"no":no,
						"type":'1_2_3_4',
						"id":'1_1_1_1',
						"starttime":starttime,
						"endtime":endtime,
						"black":"h1"
					},
					dataType:"jsonp",
					jsonpCallback:"callback",
					success:function(res){
						for(var i=0;i<res.S1_1_1.length;i++){
								var str = res.S1_1_1[i].date;
								str1 = str.substring(0,10);
								var arr = str1.split("_");
								str1 = arr.join("/");
								str2 = str.substring(11);
								var arr1 = str2.split("_");
								str2 = arr1.join(":");
								time1.push(str1+" "+str2);
							}
							for(var i=0;i<res.S1_1_1.length;i++){
								num1.push(res.S1_1_1[i].values);
							}
							
							for(var i=0;i<res.S1_2_1.length;i++){
								var str = res.S1_2_1[i].date;
								str1 = str.substring(0,10);
								var arr = str1.split("_");
								str1 = arr.join("/");
								str2 = str.substring(11);
								var arr1 = str2.split("_");
								str2 = arr1.join(":");
								time2.push(str1+" "+str2);
							}
							for(var i=0;i<res.S1_2_1.length;i++){
								num2.push(res.S1_2_1[i].values);
							}
							for(var i=0;i<res.S1_3_1.length;i++){
								var str = res.S1_3_1[i].date;
								str1 = str.substring(0,10);
								var arr = str1.split("_");
								str1 = arr.join("/");
								str2 = str.substring(11);
								var arr1 = str2.split("_");
								str2 = arr1.join(":");
								time3.push(str1+" "+str2);
							}
							for(var i=0;i<res.S1_3_1.length;i++){
								num3.push(res.S1_3_1[i].values);
							}
							for(var i=0;i<res.S1_4_1.length;i++){
								var str = res.S1_4_1[i].date;
								str1 = str.substring(0,10);
								var arr = str1.split("_");
								str1 = arr.join("/");
								str2 = str.substring(11);
								var arr1 = str2.split("_");
								str2 = arr1.join(":");
								time4.push(str1+" "+str2);
							}
							for(var i=0;i<res.S1_4_1.length;i++){
								num4.push(res.S1_4_1[i].values);
							}
							Chart1.setOption({//加载数据图表
								xAxis:{
									data: time1
								},
								series:[{
									name:"瓦斯浓度",
									data:num1
								}]
							})
							Chart2.setOption({//加载数据图表
								xAxis:{
									data: time2
								},
								series:[{
									name:"瓦斯流量",
									data:num2
								}]
							})
							Chart3.setOption({//加载数据图表
								xAxis:{
									data: time3
								},
								series:[{
									name:"管道温度",
									data:num3
								}]
							})
							Chart4.setOption({//加载数据图表
								xAxis:{
									data: time4
								},
								series:[{
									name:"管道负压",
									data:num4
								}]
							})
					}
				});
			})
			//点击导出excel按钮
			var idTmr; 
			 //获取当前浏览器类型 
			  function getExplorer() { 
			   var explorer = window.navigator.userAgent ; 
			   //ie 
			   if (explorer.indexOf("MSIE") >= 0) { 
			    return 'ie'; 
			   } 
			   //firefox 
			   else if (explorer.indexOf("Firefox") >= 0) { 
			    return 'Firefox'; 
			   } 
			   //Chrome 
			   else if(explorer.indexOf("Chrome") >= 0){ 
			    return 'Chrome'; 
			   } 
			   //Opera 
			   else if(explorer.indexOf("Opera") >= 0){ 
			    return 'Opera'; 
			   } 
			   //Safari 
			   else if(explorer.indexOf("Safari") >= 0){ 
			    return 'Safari'; 
			   } 
			  } 
			 //获取到类型需要判断当前浏览器需要调用的方法，目前项目中火狐，谷歌，360没有问题 
			  //win10自带的IE无法导出 
			  function exportExcel(tableid) { //整个表格拷贝到excel中
			   if(getExplorer()=='ie') 
			   { 
			    var curTbl = document.getElementById(tableid); 
			     //创建AX对象excel
			    var oXL = new ActiveXObject("Excel.Application"); 
			   //获取workbook对象
			    var oWB = oXL.Workbooks.Add(); 
			     //激活当前sheet
			    var xlsheet = oWB.Worksheets(1);
			   //把表格中的内容移到TextRange中
			    var sel = document.body.createTextRange(); 
			    sel.moveToElementText(curTbl); 
			    //全选TextRange中的内容
			    sel.select(); 
			   //复制TextRange中的内容
			    sel.execCommand("Copy");
			    //粘贴到活动的excel中
			    xlsheet.Paste(); 
			    //设置excel可见属性
			    oXL.Visible = true; 
			  
			    try { 
			     var fname = oXL.Application.GetSaveAsFilename("Excel.xls", "Excel Spreadsheets (*.xls), *.xls"); 
			    } catch (e) { 
			     print("Nested catch caught " + e); 
			    } finally { 
			     oWB.SaveAs(fname); 
			     oWB.Close(savechanges = false); 
			     oXL.Quit(); 
			     oXL = null; 
			     idTmr = window.setInterval("Cleanup();", 1); 
			    } 
			  
			   } 
			   else 
			   { 
			    tableToExcel(tableid) 
			   } 
			  } 
			  function Cleanup() { 
			   window.clearInterval(idTmr); 
			   CollectGarbage(); 
			  } 
			   //判断浏览器后调用的方法，把table的id传入即可 
			  var tableToExcel = (function() { 
			   var uri = 'data:application/vnd.ms-excel;base64,', 
			    template = '<html><head><meta charset="UTF-8"></head><body><table border="1">{table}</table></body></html>', 
			    base64 = function(s) { 
			    	return window.btoa(unescape(encodeURIComponent(s))) 
			    },
			    format = function(s, c) { 
			      	return s.replace(/{(\w+)}/g, 
			        function(m, p) {
			        	return c[p]; 
			        }) 
			    }
			   	return function(table, name) { 
			    	if (!table.nodeType){
			    		table = document.getElementById(table);//table就是传入的tableid
			    	}
			    	var ctx = {
			    		worksheet: name || 'Worksheet', table: table.innerHTML
			    	}
			    	window.location.href = uri + base64(format(template, ctx)); 
			   } 
			  })() 