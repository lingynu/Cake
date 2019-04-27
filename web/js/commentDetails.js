$(document).ready(function () {
    var n = $("#score").val()
    var num = parseFloat(n) * 2
    $("td:lt(" + num + "):even").css("background-image","url(/images/s_l_o.png)")
    $("td:lt(" + num + "):odd").css("background-image","url(/images/s_r_o.png)")

    $(".form-horizontal").submit(function () {
        var replyContent = $("#replyContent").val()
        var commentId = $("#commentId").val()
        if (replyContent != null){
            $.ajax({
                async:false,
                type:"post",
                url:"/CommentServlet?method=submitCommentReply",
                data:{
                    userId:1,
                    cakeId:1,
                    commentId:commentId,
                    replyContent:replyContent
                },
                success: function (data) {
                    var jsonObj = $.parseJSON(data)
                    console.log(data)
                    console.log(jsonObj)
                    if (jsonObj != null){
                        $(".li:last-child").append("<li class=\"li\">\n" +
                        "                                <div class=\"lidiv\">\n" +
                        "                                 " + jsonObj.replyNickName + " :&nbsp;&nbsp;" + jsonObj.content +"\n" +
                        "                                </div>\n" +
                        "                          </li>")
                        alert("回复成功")
                    }else {
                        alert("请填写回复！！！")
                    }
                }
            })

            return false;
        }
    })
})