/**
 * Created by Administrator on 2017/7/8.
 */
//*����jsЧ��*/
$(function () {
    /*������ز˵���*/
    var index = 0;
    $(".next").click(function () {
        index++;
        if (index % 2 !== 0) {
            $("#sidebar").hide();
            $("#main").css({
                'marginLeft': "-200px"
            });
            $(this).css({
                "transform": "rotate(90deg)"
            })
        } else if (index % 2 === 0) {
            $("#sidebar").css({
                "display": "block"
            });
            $("#main").css({
                'marginLeft': "0"
            });
            $(this).css({
                "transform": "rotate(-90deg)"
            })
        }

    });
    /*������ز˵�������*/
    /*�˵��л���ʽ*/
    $(".myself-menu>li").on("click", function () {
        $(this).addClass("active").siblings().removeClass("active");
        var num = $(this).index()
        console.log(num);
        if (num === 0) {
            $("#myapps>ul>li").css({
                "display": "none"
            });

            $(".iterm1").show();
        } else if (num === 1) {
            $("#myapps>ul>li").css({
                "display": "none"
            })
            $(".iterm2").show()
        } else if (num === 2) {
            $("#myapps>ul>li").css({
                "display": "none"
            });
            $(".iterm3").show();
        } else if (num === 3) {
            $("#myapps>ul>li").css({
                "display": "none"
            })
            $(".iterm4").show();
        } else if (num === 4) {
            $("#myapps>ul>li").css({
                "display": "none"
            })
            $(".iterm5").show();
        }

    });
    /*�˵��л���ʽ*/

    /*tab���л�Ч��*/

    $(".menutab>li").bind({
        click: function () {
            $(this).css({
                    "background": "#228BD4",
                    "color": "white"
                }
            ).siblings().css({
                    "background": "white",
                    "color": "black"
                })
        },
        mouseenter: function () {
            $(this).css({
                    "background": "#228BD4",
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
                "background": "#228BD4",
                "color": "white"
            })


        }
    });
    /*tab��ȫ�����Ч��*/
    $(".menutab>li:first-child").click(function () {
        $("#myapps>ul>li").css({
            "display":"block"
        })

    });
    /*tab��ȫ�����Ч��*/
    /**/
    /*tab���л�Ч��*/
    /*input�ĵ���¼�*/
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


});




