/*
			 钻孔施工信息相关js
			 * */
			$("#w-zuankong").click(function(){
				$.ajax({
					type:"get",
					url:url+"/judge/info?callback=?",
					async:true,
					dataType:"jsonp",
					jsonpCallback:"callback",
					success:function(data){
						var input_group = $(".zuankong").find(".input-group");
						$(input_group[0].children[0]).after('<input type="text" class="form-control"  value='+data.diameter+'>');
						$(input_group[1].children[0]).after('<input type="text" class="form-control"  value='+data.spacing+'>');
						$(input_group[2].children[0]).after('<input type="text" class="form-control"  value='+data.coordinate+'>');
						$(input_group[3].children[0]).after('<input type="text" class="form-control"  value='+data.position2+'>');
						$(input_group[4].children[0]).after('<input type="text" class="form-control"  value='+data.angle+'>');
						$(input_group[5].children[0]).after('<input type="text" class="form-control"  value='+data.depth+'>');
					}
				});
			})
			//点击保存
			$(".zuankong .btn-primary").click(function(){
				$.ajax({
					type:"get",
					url:url+"/judge/info1?callback=?",
					async:true,
					data:{
						"id":"f139b3ce-c00c-4d8a-xf2e-7s5d2298537d98",
						"diameter":parseFloat($(".form-control").eq(0).val()),
						"spacing":parseFloat($(".form-control").eq(1).val()),
						"coordinate":$(".form-control").eq(2).val(),
						"position2":$(".form-control").eq(3).val(),
						"angle":parseInt($(".form-control").eq(4).val()),
						"depth":parseFloat($(".form-control").eq(5).val())
					},
					dataType:"jsonp",
					jsonpCallback:"callback",
					success:function(){
						
					}
				});
			})