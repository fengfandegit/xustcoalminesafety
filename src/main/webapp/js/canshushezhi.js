	//参数设置的ajax
			$("#w-can").click(function(){
				$.ajax({
					type:"get",
					url:url+"/setting/param?callback=?",
					async:true,
					dataType:"jsonp",
					jsonpCallback:"callback",
					success:function(data){
						var input_group = $(".canshushezhi").find(".input-group");
						$(input_group[0].children[0]).after("<input type='text' placeholder='请输入矿井名称' class='form-control' value="+data.name+">");
						$(input_group[1].children[0]).after("<input type='text' placeholder='请输入设计生产能力' class='form-control' value="+data.design_production_capacity+">");
						$(input_group[2].children[0]).after("<input type='text' placeholder='请输入回风量' class='form-control' value="+data.air_intake+">");
						$(input_group[3].children[0]).after("<input type='text' placeholder='请输入核定生产能力' class='form-control' value="+data.verification_production_capacity+">");
						$(input_group[4].children[0]).after("<input type='text' placeholder='请输入进风量' class='form-control' value="+data.air_velocity+">");
						$(input_group[5].children[0]).after("<input type='text' placeholder='请输入瓦斯绝对涌出量' class='form-control' value="+data.wasijueduiyongchuliang+">");
						$(input_group[6].children[0]).after("<input type='text' placeholder='请输入瓦斯相对涌出量' class='form-control' value="+data.wasixiangduiyongchuliang+">");
						$(input_group[7].children[0]).after("<input type='text' placeholder='请输入煤层原始瓦斯压力' class='form-control' value="+data.meicengyuanshiwasiyali+">");
						$(input_group[8].children[0]).after("<input type='text' placeholder='请输入煤层原始瓦斯含量' class='form-control' value="+data.meicengyuanshiwasihanliang+">");
						$(input_group[9].children[0]).after("<input type='text' placeholder='请输入媒体破坏类型' class='form-control' value="+data.meicengpohuaileixing+">");
						$(input_group[10].children[0]).after("<input type='text' placeholder='请输入瓦斯放散初速度' class='form-control' value="+data.wasifangsanchusudu+">");
						$(input_group[11].children[0]).after("<input type='text' placeholder='请输入煤层坚固性系数' class='form-control' value="+data.coal_seam+">");
						$(input_group[12].children[0]).after("<input type='text' placeholder='请输入煤层透气性系数' class='form-control' value="+data.meicengtouqixingxishu+">");
						$(input_group[13].children[0]).after("<input type='text' placeholder='请输入地质构造' class='form-control' value="+data.geological_structure+">");
					}
				});
			})
			//点击保存按钮
			$(".canshushezhi .btn-success").click(function(){
				var form_control = $(".canshushezhi .form-control");
				//alert(typeof $(form_control[0]).val());
				$.ajax({
					type:"post",
					url:url+"/setting/param3?callback=?",
					data:{
						"id":"0d46ecf2-315f-4b54-8f54-d7c1f88783ec",
						"name":$(form_control[0]).val(),
						"air_intake":$(form_control[2]).val(),
						"air_velocity": $(form_control[4]).val(),
					    "coal_seam": $(form_control[11]).val(),
					    "geological_structure": $(form_control[13]).val(),
					    "design_production_capacity": $(form_control[1]).val(),
					    "verification_production_capacity": $(form_control[3]).val(),
					    "meicengyuanshiwasihanliang":$(form_control[8]).val(),
					    "wasifangsanchusudu": $(form_control[10]).val(),
					    "meicengtouqixingxishu": $(form_control[12]).val(),
					    "wasijueduiyongchuliang": $(form_control[5]).val(),
					    "meicengyuanshiwasiyali": $(form_control[7]).val(),
					    "meicengpohuaileixing": $(form_control[9]).val(),
					    "wasixiangduiyongchuliang":$(form_control[6]).val()
					},
					async:true,
					dataType:"jsonp",
					jsonpCallback:"callback",
					success:function(data){
					}
				});
			})
			
			