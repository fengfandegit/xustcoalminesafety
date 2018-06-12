//传感器管理相关js
			//点击传感器管理时，发起Ajax请求
			$("#w-chuan").click(function(){
				$.ajax({
					type:"get",
					url:url+"/sensor/info?callback=?",
					async:true,
					dataType:"jsonp",
					jsonpCallback:"callback",
					success:function(data){
						for(var i=0;i<data.length;i++){
							var tr = "<tr><td>"+data[i].num+"</td><td>"+data[i].name+"</td><td>"+data[i].model+"</td><td><select><option value="+data[i].type+">"+data[i].type+"</option><option value='瓦斯传感器'>瓦斯传感器</option><option value='温度传感器'>温度传感器</option><option value='流量传感器'>流量传感器</option><option value='负压传感器'>负压传感器</option><option value='风速传感器'>风速传感器</option></select></td><td>"+data[i].unit+"</td><td style='display: none;'>"+data[i].id+"</td><td><input type='button' value='修改'  class='btn btn-primary btn-sm'/></td><td><input type='button' value='删除' class='btn btn-danger btn-sm'/></td></tr>"
							
							$(".chuanganqi tbody").append(tr);
							//$($(".chuanganqi tbody").children("tr")[i].children[4]).html(unit);
							$(".chuanganqi .btn-primary").click(function(){
								//点击修改按钮
								//先保存当前按钮
								var input1 = $(this);
								//找到当前元素的兄弟节点td
								var a = $(this).parent().siblings();
								if(a[0].children.length===0){
							    	a[0].innerHTML="<input type='text' value='"+a[0].innerText+"' class='form-control'/>";
							   	}
								if(a[1].children.length===0){
							    	a[1].innerHTML="<input type='text' value='"+a[1].innerText+"' class='form-control'/>";
							   	}
								if(a[2].children.length===0){
							    	a[2].innerHTML="<input type='text' value='"+a[2].innerText+"' class='form-control'/>";
							   	}
								if(a[4].children.length===0){
							    	a[4].innerHTML="<input type='text' value='"+a[4].innerText+"' class='form-control'/>";
							   	}
								$(this).parent().html("<input type='button' value='保存' class='btn btn-success btn-sm'/><input type='button' value='取消' class='btn btn-warning btn-sm'/>");
								//点击保存按钮
								$(".chuanganqi .btn-success").click(function(){
									//获取td的兄弟节点
									var a = $(this).parent().siblings();
									var td_num = a[0].children[0].value;//编号
									var td_name = a[1].children[0].value;//名称
									var td_xinghao = a[2].children[0].value;//型号
									var td_leixing = a[3].children[0].value;
									var td_danwei = a[4].children[0].value;//单位
									var td_id = a[5].innerHTML;//id
									a[0].innerHTML = td_num;
									a[1].innerHTML = td_name;
									a[2].innerHTML = td_xinghao;
									a[3].innerHTML = td_leixing;
									a[4].innerHTML = td_danwei;
									$(this).parent().html(input1);
									//发起ajax请求
									var url1 = url+"/sensor/info2?callback=?";
								    $.ajax({
								      url:url1,
								      type:"get",
								      data:{
								      	 "id":td_id,
								         "num":parseInt(td_num),
								         "name":td_name,
								         "model":td_xinghao,
								         "type":td_leixing,
								         "unit":td_danwei
								      },
								      datatype:"jsonp",
								      jsonpCallback:"callback",
								      success:function (data) {
								      	
								      	alert("成功");
								      }
								    });
								   
								})
								
								//点击取消按钮
								var b = $(".chuanganqi .btn-warning").parent().siblings();
								var td_num = b[0].children[0].value;//编号
								var td_name = b[1].children[0].value;//名称
								var td_xinghao = b[2].children[0].value;//型号
								var td_danwei = b[4].children[0].value;//单位
								$(".chuanganqi .btn-warning").click(function(){
									var a = $(this).parent().siblings();
									a[0].innerHTML = td_num;
									a[1].innerHTML = td_name;
									a[2].innerHTML = td_xinghao;
									a[4].innerHTML = td_danwei;
									$(this).parent().html("<input type='button' value='修改' class='btn btn-primary btn-sm'/>");
								})
							})
							//点击删除按钮
							$(".chuanganqi .btn-danger").click(function(){
								$(this).parent().parent().remove();
								$.ajax({
									type:"get",
									url:url+"/sensor/info3?callback=?",
									async:true,
									data:{
										id:$(this).parent().parent().find("td").eq(5).html()
									},
									dataType:'jsonp',
									jsonpCallback:"callback",
									success:function(data){
										
									}
								});
							})
						}
					}
				});
			})
			
			//点击添加按钮
			$(".chuanganqi .btn-default").click(function(){
				var addtr = "<tr></td><td><input type='text' class='form-control'/></td><td><input type='text' class='form-control'/></td><td><input type='text' class='form-control'/></td><td><select><option value='请选择'>请选择</option><option value='瓦斯传感器'>瓦斯传感器</option><option value='温度传感器'>温度传感器</option><option value='流量传感器'>流量传感器</option><option value='负压传感器'>负压传感器</option></select></td><td><input type='text' class='form-control'/></td><td><input type='button' value='保存'  class='btn btn-success btn-sm'/><input type='button' value='取消'  class='btn btn-warning btn-sm'/></td><td><input type='button' value='删除' class='btn btn-danger btn-sm'/></td></tr>";
				$(this).prev().find(".table").append(addtr);
				//点击保存
				$(this).prev().find("tbody tr:last-child").find(".btn-success").click(function(){
					//获取td的兄弟节点
					var a = $(this).parent().siblings();
					var td_num = a[0].children[0].value;//编号
					var td_name = a[1].children[0].value;//名称
					var td_xinghao = a[2].children[0].value;//型号
					var td_leixing = a[3].children[0].value;
					var td_danwei = a[4].children[0].value;//单位
					a[0].innerHTML = td_num;
					a[1].innerHTML = td_name;
					a[2].innerHTML = td_xinghao;
					a[3].innerHTML = td_leixing;
					a[4].innerHTML = td_danwei;
					$(this).parent().html("<input type='button' value='修改'  class='btn btn-primary btn-sm'/>");
					//发起ajax
					var url1 = url+"/sensor/info1?callback=?";
				    $.ajax({
				      url:url1,
				      type:"get",
				      data:{
				         "num":parseInt(td_num),
				         "name":td_name,
				         "model":td_xinghao,
				         "type":td_leixing,
				         "unit":td_danwei
				      },
				      datatype:"jsonp",
				      jsonpCallback:"callback",
				      success:function (data) {
				      }
				    });
				})
				//点击删除
				$(".chuanganqi .btn-danger").click(function(){
					$(this).parent().parent().remove();
					$.ajax({
						type:"get",
						url:"",
						async:true,
						dataType:'json',
						success:function(data){
							
						}
					});
				})
			})