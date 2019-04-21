$(document).ready(function() {
    $("#login").click(function () {
        var userId = $("#userId").val();
        var password = $("#password").val();
        if(userId == null){
            $("#userId").attr('placeholder','用户id不能为空！');
            return;
        }
        if(password == null){
            $("#password").attr('placeholder','密码不能为空！');
            return;
        }

        $.ajax({
            type:"post",
            url:"UserServlet?method=login",
            data:{
                userId: userId,
                password: password
            },
            dataType: "text",
            success: function (data) {
                console.log(data+"4444");
                alert("succes");
                $("#loginDiv").hide();
                $("#userDivv").append(data);

            }
        })
    })
})

