/*报警信息显示相关js*/
			//初始化图标标签
			$("#w-baojing").click(function(){
				var mychart1 = echarts.init(document.getElementById("mychart1"),'dark');
				var mychart2 = echarts.init(document.getElementById("mychart2"),'dark');
				var mychart3 = echarts.init(document.getElementById("mychart3"),'dark');
				var mychart4 = echarts.init(document.getElementById("mychart4"),'dark');
					var myoptions1 = {
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
					mychart1.setOption(myoptions1);
					var myoptions2 = {
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
					mychart2.setOption(myoptions2);
					var myoptions3 = {
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
					mychart3.setOption(myoptions3);
					var myoptions4 = {
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
					mychart4.setOption(myoptions4);
				 var _times1=[];    //时间数组（实际用来盛放X轴坐标值）
	        	 var _nums1=[];    //数据数组（实际用来盛放Y坐标值）
	        	 var _times2 = [];
	        	 var _nums2 = [];
	        	 var _times3 = [];
	        	 var _nums3 = [];
	        	 var _times4 = [];
	        	 var _nums4 = [];
					//获取分站类型
					//alert($(".shishishuju .fz").val());
					$.ajax({
							type:"get",
							url:url+"/readdata/getnowdata/?callback=?",
							async:true,
							data:{
								"no":'1_1_1_1',
								"type":'1_2_3_4',
								"id":'1_1_1_1',
								
							},
							dataType:"jsonp",
							jsonpCallback:"callback",
							success:function(res){
								//拿到数据进行展示
								for(var i=0;i<res.S1_1_1.length;i++){
									var str = res.S1_1_1[i].date;
									str1 = str.substring(0,10);
									var arr = str1.split("_");
									str1 = arr.join("/");
									str2 = str.substring(11);
									var arr1 = str2.split("_");
									str2 = arr1.join(":");
									_times1.push(str1+" "+str2);
								}
								for(var i=0;i<res.S1_1_1.length;i++){
									_nums1.push(res.S1_1_1[i].values.toFixed(3));
								}
								
								for(var i=0;i<res.S1_2_1.length;i++){
									var str = res.S1_2_1[i].date;
									str1 = str.substring(0,10);
									var arr = str1.split("_");
									str1 = arr.join("/");
									str2 = str.substring(11);
									var arr1 = str2.split("_");
									str2 = arr1.join(":");
									_times3.push(str1+" "+str2);
								}
								for(var i=0;i<res.S1_2_1.length;i++){
									_nums3.push(res.S1_2_1[i].values.toFixed(3));
								}
								for(var i=0;i<res.S1_3_1.length;i++){
									var str = res.S1_3_1[i].date;
									str1 = str.substring(0,10);
									var arr = str1.split("_");
									str1 = arr.join("/");
									str2 = str.substring(11);
									var arr1 = str2.split("_");
									str2 = arr1.join(":");
									_times2.push(str1+" "+str2);
								}
								for(var i=0;i<res.S1_3_1.length;i++){
									_nums2.push(res.S1_3_1[i].values.toFixed(3));
								}
								for(var i=0;i<res.S1_4_1.length;i++){
									var str = res.S1_4_1[i].date;
									str1 = str.substring(0,10);
									var arr = str1.split("_");
									str1 = arr.join("/");
									str2 = str.substring(11);
									var arr1 = str2.split("_");
									str2 = arr1.join(":");
									_times4.push(str1+" "+str2);
								}
								for(var i=0;i<res.S1_4_1.length;i++){
									_nums4.push(res.S1_4_1[i].values);
								}
								//chart1.hideLoading(); //隐藏加载动画
								mychart1.setOption({//加载数据图表
									xAxis:{
										data: _times1
									},
									series:[{
										name:"瓦斯浓度",
										data:_nums1
									}]
								})
								mychart2.setOption({//加载数据图表
									xAxis:{
										data: _times2
									},
									series:[{
										name:"瓦斯流量",
										data:_nums2
									}]
								})
								mychart3.setOption({//加载数据图表
									xAxis:{
										data: _times3
									},
									series:[{
										name:"管道温度",
										data:_nums3
									}]
								})
								mychart4.setOption({//加载数据图表
									xAxis:{
										data: _times4
									},
									series:[{
										name:"管道负压",
										data:_nums4
									}]
								})
							},
							error:function(errorMsg){
								//alert("图表数据请求失败");
								chart1.hideLoading();
							}
			})
	});
			