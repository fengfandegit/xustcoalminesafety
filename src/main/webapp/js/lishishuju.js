/*历史数据相关js*/
			var chart5 = echarts.init(document.getElementById("fenxi1"),'dark');
			var chart6 = echarts.init(document.getElementById("fenxi2"),'dark');
			var chart8 = echarts.init(document.getElementById("fenxi4"),'dark');
			var chart7 = echarts.init(document.getElementById("fenxi3"),'dark');
			var option5 = {
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
			chart5.setOption(option5);
			var option6 = {
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
			chart6.setOption(option6);
			var option7 = {
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
			chart7.setOption(option7);
			var option8 = {
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
			chart8.setOption(option8);
			var times5=[];    //时间数组（实际用来盛放X轴坐标值）
        	 var nums5=[];    //数据数组（实际用来盛放Y坐标值）
        	 var times6 = [];
        	 var nums6 = [];
        	 var times8 = [];
        	 var nums8 = [];
        	 var times7 = [];
        	 var nums7 = [];
			$(".lishishuju .btn-warning").click(function(){
				//获取到选择条件的值
				var no = '0-16通道分站';
				if($(".lishishuju .fz").val()=='0-16通道分站'){
					no = '1_1_1_1';
				}else if($(".lishishuju .fz").val()=="1-4通道分站"){
					no='2_2_2_2';
				}
				var starttime = $("#time1").val();
				starttime = starttime.substring(0,10);
				var arr = starttime.split("-");
				starttime = arr.join("");
				var endtime = $("#time2").val();
				endtime = endtime.substring(0,10);
				var arr = endtime.split("-");
				endtime = arr.join("");
				var jiange = $(".jiange").val();
				$.ajax({
					type:"get",
					url:url+"/readdata/gethistorydata?callback=?",
					async:true,
					data:{
						"no":no,
						"type":"1_2_3_4",
						"id":"1_1_1_1",
						"starttime":starttime,
						"endtime":endtime,
						"black":jiange
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
								times5.push(str1+" "+str2);
							}
							for(var i=0;i<res.S1_1_1.length;i++){
								nums5.push(res.S1_1_1[i].values);
							}
							
							for(var i=0;i<res.S1_2_1.length;i++){
								var str = res.S1_2_1[i].date;
								str1 = str.substring(0,10);
								var arr = str1.split("_");
								str1 = arr.join("/");
								str2 = str.substring(11);
								var arr1 = str2.split("_");
								str2 = arr1.join(":");
								times6.push(str1+" "+str2);
							}
							for(var i=0;i<res.S1_2_1.length;i++){
								nums6.push(res.S1_2_1[i].values);
							}
							for(var i=0;i<res.S1_3_1.length;i++){
								var str = res.S1_3_1[i].date;
								str1 = str.substring(0,10);
								var arr = str1.split("_");
								str1 = arr.join("/");
								str2 = str.substring(11);
								var arr1 = str2.split("_");
								str2 = arr1.join(":");
								times7.push(str1+" "+str2);
							}
							for(var i=0;i<res.S1_3_1.length;i++){
								nums7.push(res.S1_3_1[i].values);
							}
							for(var i=0;i<res.S1_4_1.length;i++){
								var str = res.S1_4_1[i].date;
								str1 = str.substring(0,10);
								var arr = str1.split("_");
								str1 = arr.join("/");
								str2 = str.substring(11);
								var arr1 = str2.split("_");
								str2 = arr1.join(":");
								times8.push(str1+" "+str2);
							}
							for(var i=0;i<res.S1_4_1.length;i++){
								nums8.push(res.S1_4_1[i].values);
							}
							chart5.setOption({//加载数据图表
								xAxis:{
									data: times5
								},
								series:[{
									name:"瓦斯浓度",
									data:nums5
								}]
							})
							chart6.setOption({//加载数据图表
								xAxis:{
									data: times6
								},
								series:[{
									name:"瓦斯流量",
									data:nums6
								}]
							})
							chart7.setOption({//加载数据图表
								xAxis:{
									data: times7
								},
								series:[{
									name:"管道温度",
									data:nums7
								}]
							})
							chart8.setOption({//加载数据图表
								xAxis:{
									data: times8
								},
								series:[{
									name:"管道负压",
									data:nums8
								}]
							})
					}
				});
			})
			