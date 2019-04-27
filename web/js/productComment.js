$(document).ready(function () {
    var n = $("#score").val()
    var commentId = $("#commentId").val()
    var num = parseFloat(n) * 2
    $("td:lt(" + num + "):even").css("background-image","url(/images/s_l_o.png)")
    $("td:lt(" + num + "):odd").css("background-image","url(/images/s_r_o.png)")

    $("#like").click(function () {
        $.ajax({
            type:"post",
            url:"/CommentServlet?method=addLikeByCommentId",
            data:{
                commentId:commentId
            },
            success: function (data) {
                console.log(data)
                if (data){
                    var likeNum = $("#likeNum").html() + 1
                    console.log(likeNum)
                    $("#likeNum").html(likeNum)
                    console.log("点赞成功")
                }else {
                    console.log("点赞失败")
                }
            }

        })
    })
})