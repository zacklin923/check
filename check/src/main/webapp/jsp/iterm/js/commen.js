/**
 * Created by Administrator on 2017/7/26.
 */
$(function () {
    var index = 0;
    $(".self-tool-btn").on("click", function () {
        index++;
        if (index % 2 !== 0) {
            $("#mypanel").panel("collapse",true);
            $("#dg").datagrid("resize");
            $(".myself_btn").html("展开")
        } else if (index % 2 === 0) {
            $("#mypanel").panel("expand" ,true);
//                    $("#mypanel").show("speed");
            $("#dg").datagrid("resize");
            $(".myself_btn").html("收缩")

        }

    });
    $("#mypanel").panel({
        onCollapse:function() {
            $('#dg').datagrid('resize');
        },
        onExpand:function() {
            $('#dg').datagrid('resize');
        }
    });

})
