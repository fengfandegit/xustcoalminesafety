/*
			 抽采计量数据
			 * */
			$("#w-jiliang").click(function(){
				$.ajax({
					type:"get",
					url:url+"/judge/info?callback=?",
					async:true,
					dataType:"jsonp",
					jsonpCallback:"callback",
					success:function(data){
						var input_group = $(".choucaijiliang").find(".input-group");
						$(input_group[0].children[0]).after('<input type="text" class="form-control"  value='+data.extraction_rate+'>');
						$(input_group[1].children[0]).after('<input type="text" class="form-control"  value='+data.extraction_num+'>');
						$(input_group[2].children[0]).after('<input type="text" class="form-control"  value='+data.time+'>');
					}
				});
			})
			//点击保存
			$(".choucaijiliang .btn-primary").click(function(){
				$.ajax({
					type:"get",
					url:url+"/judge/info1?callback=?",
					async:true,
					data:{
						"id":"f139b3ce-c00c-4d8a-xf2e-7s5d2298537d98",
						"extraction_rate":parseFloat($(".form-control").eq(0).val()),
						"extraction_num":parseFloat($(".form-control").eq(1).val()),
						"time":parseInt($(".form-control").eq(2).val()),
						
					},
					dataType:"jsonp",
					jsonpCallback:"callback",
					success:function(){
						
					}
				});
			})