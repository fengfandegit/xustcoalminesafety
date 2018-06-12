/*
			 * 分站管理相关js
			 * 
			*/
			
			$("#w-fen").click(function(){
				$.ajax({
					type:"get",
					url:url+"/substation/info?callback=?",
					async:true,
					dataType:'jsonp',
					jsonpCallback:"callback",
					success:function(data){
						for(var i=0;i<data.length;i++){
							var tr = '<tr><td>'+data[i].num+'</td><td>'+data[i].position1+'</td><td><select><option value='+data[i].type+'>'+data[i].type+'</option><option value="0-16通道分站">0-16通道分站</option><option value="1-4通道分站">1-4通道分站</option></select></td><td style="display: none;">'+data[i].id+'</td><td><input type="button" value="修改" class="btn btn-primary btn-sm"/></td><td><input type="button" value="删除" class="btn btn-danger btn-sm"/></td></tr>'
							$(".fenzhan tbody").append(tr);
							//点击修改按钮
							$(".fenzhan .btn-primary").click(function(){
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
								$(this).parent().html("<input type='button' value='保存' class='btn btn-success btn-sm'/><input type='button' value='取消' class='btn btn-warning btn-sm'/>");
								//点击保存按钮
								$(".fenzhan .btn-success").click(function(){
									//获取td的兄弟节点
									var a = $(this).parent().siblings();
									var td_num = a[0].children[0].value;//编号
									var td_name = a[1].children[0].value;//位置
									var td_xinghao = a[2].children[0].value;//类型
									var td_id = a[3].innerHTML;//id
									a[0].innerHTML = td_num;
									a[1].innerHTML = td_name;
									a[2].innerHTML = td_xinghao;
									$(this).parent().html(input1);
									//发起ajax请求
									var url1 = url+"/substation/info2?callback=?";
								    $.ajax({
								      url:url1,
								      type:"get",
								      data:{
								      	"id":td_id,
								         "num":parseInt(td_num),
								         "position1":td_name,
								         "type":td_xinghao,
								      },
								      datatype:"jsonp",
								      jsonpCallback:"callback",
								      success:function (data) {
								      }
								    });
								   
								})
								
								//点击取消按钮
								var b = $(".fenzhan .btn-warning").parent().siblings();
								var td_num = b[0].children[0].value;//编号
								var td_name = b[1].children[0].value;//名称
								var td_xinghao = b[2].children[0].value;//型号
								$(".fenzhan .btn-warning").click(function(){
									var a = $(this).parent().siblings();
									a[0].innerHTML = td_num;
									a[1].innerHTML = td_name;
									a[2].innerHTML = td_xinghao;
									
									$(this).parent().html("<input type='button' value='修改' class='btn btn-primary btn-sm'/>");
								})
								
							})
						}
						//点击删除按钮
						$(".fenzhan .btn-danger").click(function(){
							$(this).parent().parent().remove();
							$.ajax({
								type:"get",
								url:url+"/substation/info3?callback=?",
								async:true,
								data:{
									id:$(this).parent().parent().find("td").eq(3).html()
								},
								dataType:'jsonp',
								jsonpCallback:"callback",
								success:function(data){
									
								}
							});
						})
					}
				});
			})
			
			//点击添加按钮
			$(".fenzhan .btn-default").click(function(){
				var addtr = "<tr></td><td><input type='text' class='form-control'/></td><td><input type='text' class='form-control'/></td><td><select><option value='请选择'>请选择</option><option value='0-16通道分站'>0-16通道分站</option><option value='1-4通道分站'>1-4通道分站</option></select></td><td><input type='button' value='保存'  class='btn btn-success btn-sm'/><input type='button' value='取消'  class='btn btn-warning btn-sm'/></td><td><input type='button' value='删除' class='btn btn-danger btn-sm'/></td></tr>";
				$(this).prev().find(".table").append(addtr);
				//点击保存
				$(this).prev().find("tbody tr:last-child").find(".btn-success").click(function(){
					//获取td的兄弟节点
					var a = $(this).parent().siblings();
					var td_num = a[0].children[0].value;//编号
					var td_name = a[1].children[0].value;//位置
					var td_xinghao = a[2].children[0].value;//类型
					var td_id = a[3].innerHTML;//id
					a[0].innerHTML = td_num;
					a[1].innerHTML = td_name;
					a[2].innerHTML = td_xinghao;
					$(this).parent().html("<input type='button' value='修改'  class='btn btn-primary btn-sm'/>");
					//发起ajax请求
					var url1 = url+"/substation/info1?callback=?";
				    $.ajax({
				      url:url1,
				      type:"get",
				      data:{
				         "num":parseInt(td_num),
				         "position1":td_name,
				         "type":td_xinghao,
				      },
				      datatype:"jsonp",
				      jsonpCallback:"callback",
				      success:function (data) {
				         
				      }
				    });
				})
				//点击删除
				$(".fenzhan .btn-danger").click(function(){
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