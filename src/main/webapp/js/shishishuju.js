/*实时数据显示相关js*/
			$(".but1").click(function(){
				$(".parent").show();
				$("#div2").hide();
				
			})
			//分站显示的按钮
			$(".but2").click(function(){
				$("#div2").show();
				$(".parent").hide();
				$.ajax({
					type:"get",
					url:url+"/readdata/getzhan?callback=?",
					dataType:'jsonp',
					jsonpCallback:"callback",
					success:function(data){
						for(var i=0;i<data.values.length;i++){
							var str = "<tr><td>"+data.values[i].id+"</td><td>"+data.values[i].panqu+"</td><td>"+data.values[i].choucainame+"</td><td>"+data.values[i].installaction+"</td><td>"+data.values[i].mixnum+"</td><td>"+data.values[i].jueya+"</td><td>"+data.values[i].fuya+"</td><td>"+data.values[i].wendu+"</td><td>"+data.values[i].chunliuliang+"</td><td>"+data.values[i].sunliulangleiji+"</td><td>"+data.values[i].riliuliangleiji+"</td><td>"+data.values[i].chunliuliangshilieji+"</td><td>"+data.values[i].chunliuliangrileiji+"</td><td>"+data.values[i].chunliuliangyueleiji+"</td></tr>"
							$("#div2 tbody").append(str);
						}
					}
				});
			})
			var chart1 = echarts.init(document.getElementById("qx1"),'dark');
			var chart2 = echarts.init(document.getElementById("qx2"),'dark');
			var chart4 = echarts.init(document.getElementById("qx4"),'dark');
			var chart3 = echarts.init(document.getElementById("qx3"),'dark');
			var option1 = {
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
			chart1.setOption(option1);
			var option2 = {
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
			chart2.setOption(option2);
			var option3 = {
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
			chart3.setOption(option3);
			var option4 = {
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
			chart4.setOption(option4);
			
			//chart1.showLoading();
			 var times1=[];    //时间数组（实际用来盛放X轴坐标值）
        	 var nums1=[];    //数据数组（实际用来盛放Y坐标值）
        	 var times2 = [];
        	 var nums2 = [];
        	 var times3 = [];
        	 var nums3 = [];
        	 var times4 = [];
        	 var nums4 = [];
			$(".but").click(function(){
				//获取分站类型
				//alert($(".shishishuju .fz").val());
				var no = '0-16通道分站';
				if($(".shishishuju .fz").val()=='0-16通道分站'){
					no = '1_1_1_1';
				}else if($(".shishishuju .fz").val()=="1-4通道分站"){
					no='2_2_2_2';
				}
				$.ajax({
						type:"get",
						url:url+"/readdata/getnowdata/?callback=?",
						async:true,
						data:{
							"no":no,
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
								times1.push(str1+" "+str2);
							}
							for(var i=0;i<res.S1_1_1.length;i++){
								nums1.push(res.S1_1_1[i].values.toFixed(3));
							}
							
							for(var i=0;i<res.S1_2_1.length;i++){
								var str = res.S1_2_1[i].date;
								str1 = str.substring(0,10);
								var arr = str1.split("_");
								str1 = arr.join("/");
								str2 = str.substring(11);
								var arr1 = str2.split("_");
								str2 = arr1.join(":");
								times3.push(str1+" "+str2);
							}
							for(var i=0;i<res.S1_2_1.length;i++){
								nums3.push(res.S1_2_1[i].values.toFixed(3));
							}
							for(var i=0;i<res.S1_3_1.length;i++){
								var str = res.S1_3_1[i].date;
								str1 = str.substring(0,10);
								var arr = str1.split("_");
								str1 = arr.join("/");
								str2 = str.substring(11);
								var arr1 = str2.split("_");
								str2 = arr1.join(":");
								times2.push(str1+" "+str2);
							}
							for(var i=0;i<res.S1_3_1.length;i++){
								nums2.push(res.S1_3_1[i].values.toFixed(3));
							}
							for(var i=0;i<res.S1_4_1.length;i++){
								var str = res.S1_4_1[i].date;
								str1 = str.substring(0,10);
								var arr = str1.split("_");
								str1 = arr.join("/");
								str2 = str.substring(11);
								var arr1 = str2.split("_");
								str2 = arr1.join(":");
								times4.push(str1+" "+str2);
							}
							for(var i=0;i<res.S1_4_1.length;i++){
								nums4.push(res.S1_4_1[i].values);
							}
							//chart1.hideLoading(); //隐藏加载动画
							chart1.setOption({//加载数据图表
								xAxis:{
									data: times1
								},
								series:[{
									name:"瓦斯浓度",
									data:nums1
								}]
							})
							chart2.setOption({//加载数据图表
								xAxis:{
									data: times2
								},
								series:[{
									name:"瓦斯流量",
									data:nums2
								}]
							})
							chart3.setOption({//加载数据图表
								xAxis:{
									data: times3
								},
								series:[{
									name:"管道温度",
									data:nums3
								}]
							})
							chart4.setOption({//加载数据图表
								xAxis:{
									data: times4
								},
								series:[{
									name:"管道负压",
									data:nums4
								}]
							})
						},
						error:function(errorMsg){
							//alert("图表数据请求失败");
							chart1.hideLoading();
						}
				});
				setInterval(function(){
					$.ajax({
						type:"get",
						url:url+"/readdata/getnowdata/?callback=?",
						async:true,
						data:{
							"no":no,
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
								times1.push(str1+" "+str2);
							}
							for(var i=0;i<res.S1_1_1.length;i++){
								nums1.push(res.S1_1_1[i].values.toFixed(3));
							}
							
							for(var i=0;i<res.S1_2_1.length;i++){
								var str = res.S1_2_1[i].date;
								str1 = str.substring(0,10);
								var arr = str1.split("_");
								str1 = arr.join("/");
								str2 = str.substring(11);
								var arr1 = str2.split("_");
								str2 = arr1.join(":");
								times3.push(str1+" "+str2);
							}
							for(var i=0;i<res.S1_2_1.length;i++){
								nums3.push(res.S1_2_1[i].values.toFixed(3));
							}
							for(var i=0;i<res.S1_3_1.length;i++){
								var str = res.S1_3_1[i].date;
								str1 = str.substring(0,10);
								var arr = str1.split("_");
								str1 = arr.join("/");
								str2 = str.substring(11);
								var arr1 = str2.split("_");
								str2 = arr1.join(":");
								times2.push(str1+" "+str2);
							}
							for(var i=0;i<res.S1_3_1.length;i++){
								nums2.push(res.S1_3_1[i].values.toFixed(3));
							}
							for(var i=0;i<res.S1_4_1.length;i++){
								var str = res.S1_4_1[i].date;
								str1 = str.substring(0,10);
								var arr = str1.split("_");
								str1 = arr.join("/");
								str2 = str.substring(11);
								var arr1 = str2.split("_");
								str2 = arr1.join(":");
								times4.push(str1+" "+str2);
							}
							for(var i=0;i<res.S1_4_1.length;i++){
								nums4.push(res.S1_4_1[i].values);
							}
							//chart1.hideLoading(); //隐藏加载动画
							chart1.setOption({//加载数据图表
								xAxis:{
									data: times1
								},
								series:[{
									name:"瓦斯浓度",
									data:nums1
								}]
							})
							chart2.setOption({//加载数据图表
								xAxis:{
									data: times2
								},
								series:[{
									name:"瓦斯流量",
									data:nums2
								}]
							})
							chart3.setOption({//加载数据图表
								xAxis:{
									data: times3
								},
								series:[{
									name:"管道温度",
									data:nums3
								}]
							})
							chart4.setOption({//加载数据图表
								xAxis:{
									data: times4
								},
								series:[{
									name:"管道负压",
									data:nums4
								}]
							})
						},
						error:function(errorMsg){
							//alert("图表数据请求失败");
							chart1.hideLoading();
						}
					});
				},6000);
			})
			
			
			