/*调控命令管理*/
			$(".choucaipinggu .btn-default").click(function(){
				//获取所有的form-control
				if($(".choucaipinggu .form-control").eq(0).val()!=""&&parseFloat($(".choucaipinggu .form-control").eq(0).val())<1){
					$(".choucaipinggu .btn-success").eq(0).css("display","block");
					$(".choucaipinggu .btn-danger").eq(0).css("display","none");
				}else{
					$(".choucaipinggu .btn-success").eq(0).css("display","none");
					$(".choucaipinggu .btn-danger").eq(0).css("display","block");
				}
				if($(".choucaipinggu .form-control").eq(1).val()!=""&&parseFloat($(".choucaipinggu .form-control").eq(1).val())>27.13){
					$(".choucaipinggu .btn-success").eq(1).css("display","block");
					$(".choucaipinggu .btn-danger").eq(1).css("display","none");
				}else{
					$(".choucaipinggu .btn-success").eq(1).css("display","none");
					$(".choucaipinggu .btn-danger").eq(1).css("display","block");
				}
				if($(".choucaipinggu .form-control").eq(2).val()!=""&&parseFloat($(".choucaipinggu .form-control").eq(2).val())>=35){
					$(".choucaipinggu .btn-success").eq(2).css("display","block");
					$(".choucaipinggu .btn-danger").eq(2).css("display","none");
				}else{
					$(".choucaipinggu .btn-success").eq(2).css("display","none");
					$(".choucaipinggu .btn-danger").eq(2).css("display","block");
				}
				if(parseFloat($(".choucaipinggu .form-control").eq(0).val())<1&&parseFloat($(".choucaipinggu .form-control").eq(1).val())>27.13&&parseFloat($(".choucaipinggu .form-control").eq(2).val())>=35){
					$(".choucaipinggu .btn-success").eq(3).css("display","block");
					$(".choucaipinggu .btn-danger").eq(3).css("display","none");
				}else{
					$(".choucaipinggu .btn-success").eq(3).css("display","none");
					$(".choucaipinggu .btn-danger").eq(3).css("display","block");
				}
			});