// $(document).ready(function() {
//
//     $("#confirmPay").click(function () {
//         var orderId=$("p").eq(0).val();
//         $.ajax({
//             type: "post",
//             url: "OrderServlet?method=updateOrder",
//             dataType: "text",
//             data: {
//                 orderId: orderId,
//                 status: "已付款"
//             },
//             success: function (data) {
//                 if(data=="true")
//                     alert("付款成功");
//                 else
//                     alert("付款失败");
//             }
//         })
//     })
// })

function goPay() {
    var orderId=$("#idSpan").html();
    console.log(orderId);
    $.ajax({
        type: "post",
        url: "OrderServlet?method=updateOrder",
        data: {
            orderId: orderId,
            status: "已付款"
        },
        success: function (data) {
            console.log(data);
            var result=data;
            if(result==1){
                $("#statusP").text("已付款");
                alert("付款成功");
                $("#confirmPay").css({"display":"none"});

            }
            else
                alert("付款失败");
        }
    })

}