/*
			 调控命令管理
			 * */
			$("#w-tiaokong").click(function(){
				$.ajax({
					type:"get",
					url:url+"/judge/info?callback=?",
					async:true,
					dataType:'jsonp',
					jaonpCallback:"callback",
					success:function(data){
						var aspan = $(".tiaokong").find("span");
						$(aspan[0]).html(data.add_press);
						$(aspan[1]).html(data.time);
						$(aspan[2]).html(data.distance);
						$(aspan[3]).html(data.wind_num);
					}
				});
			})