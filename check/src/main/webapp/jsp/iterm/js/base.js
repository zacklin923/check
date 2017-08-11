/**
 * Created by Administrator on 2017/7/8.
 */
//*公共js效果*/
$(function () {
  
    /*点击隐藏菜单栏结束*/
    /*菜单切换样式*/
    $(".myself-menu>li").on("click", function () {
        $(this).addClass("active").siblings().removeClass("active");

    });
    /*菜单切换样式*/

    /*tab栏切换效果*/

    $(".menutab>li").bind({
        click: function () {
        	 var num = $(this).index();
        	 if (num === 1) {
                 $("#myapps>ul>li").css({
                     "display": "none"
                 });

                 $(".iterm1").show();
             } else if (num === 2) {
                 $("#myapps>ul>li").css({
                     "display": "none"
                 })
                 $(".iterm2").show()
             } else if (num === 3) {
                 $("#myapps>ul>li").css({
                     "display": "none"
                 });
                 $(".iterm3").show();
             } else if (num === 4) {
                 $("#myapps>ul>li").css({
                     "display": "none"
                 })
                 $(".iterm4").show();
             } else if (num === 5) {
                 $("#myapps>ul>li").css({
                     "display": "none"
                 })
                 $(".iterm5").show();
             }
            $(this).css({
                    "background": "rgb(290, 180, 0)",
                    "color": "white"
                }
            ).siblings().css({
                    "background": "white",
                    "color": "black"
                })
        },
        mouseenter: function () {
            $(this).css({
                    "background": "rgb(290, 180, 0)",
                    "color": "white"
                }
            ).siblings().css({
                    "background": "white",
                    "color": "black"
                })
        },
        mouseleave: function () {
            $(this).css({
                "background": "white",
                "color": "black"
            }).parent().children().first().css({
                "background": "rgb(290, 180, 0)",
                "color": "white"
            })


        }
    });
    /*tab的全部点击效果*/
    $(".menutab>li:first-child").click(function () {
        $("#myapps>ul>li").css({
            "display":"block"
        })

    });
    /*tab的全部点击效果*/
    /**/
    /*tab栏切换效果*/
    /*input的点击事件*/
    $("input").focusin(function () {
        $(this).css({
            "border":"1px solid #05A4E3"
        })
    });

    $("input").blur(function () {
        $(this).css({
            "border":"1px solid #ccc"
        })
    });

    /*input的点击事件*/
    $("textarea").focusin(function () {
        $(this).css({
            "border":"1px solid #05A4E3"
        })
    });

    $("textarea").blur(function () {
        $(this).css({
            "border":"1px solid #ccc"
        })
    }); 
});





