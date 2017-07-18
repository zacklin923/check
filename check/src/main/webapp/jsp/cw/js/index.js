	$(function () {
		/*点击隐藏菜单栏*/
		var index = 0;
		$(".next").click(function(){
			index++;
			if(index%2!==0){
				$("#sidebar").hide();
				$("#main").css({
					'marginLeft':"-200px"
				});
			}else if(index%2===0){
				$("#sidebar").css({
					"display":"block"
				});
				$("#main").css({
					'marginLeft':"0"
				});

			}

		});
		/*点击隐藏菜单栏结束*/
		/*菜单切换样式*/
		$(".myself-menu>li").on("click", function () {
			$(this).addClass("active").siblings().removeClass("active");
			var num = $(this).index()
			console.log(num);
			if(num===0){
				$("#myapps>ul>li").css({
					"display":"none"
				});

				$(".iterm1").show();
			}else if(num===1){
				$("#myapps>ul>li").css({
					"display":"none"
				})
				$(".iterm2").show()
			}else if(num===2){
				$("#myapps>ul>li").css({
					"display":"none"
				});
				$(".iterm3").show();
			}else if(num===3){
				$("#myapps>ul>li").css({
					"display":"none"
				})
				$(".iterm4").show();
			}else if(num===4){
				$("#myapps>ul>li").css({
					"display":"none"
				})
				$(".iterm5").show();
			}

		});
		/*菜单切换样式*/

		/*tab栏切换效果*/

		$(".menutab>li").bind({
			click: function () {
				$(this).css({
								"background":"#228BD4",
								"color":"white"
						}

						).siblings().css({
								"background":"white",
								"color":"black"
							})
			},
			mouseover: function () {
				$(this).css({
						"background":"#228BD4",
						"color":"white"
					}

				).siblings().css({
						"background":"white",
						"color":"black"
					})
			}
		});
		/**/
		/*tab栏切换效果*/

		/*tab栏显示效果*/
			$(".menutab:first-child").click(function () {
				console.log("aaa");
				$("#myapps>ul>li").css({
					"display":"block"
				})
			});
		/*tab栏显示效果*/

	});




