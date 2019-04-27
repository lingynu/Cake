$(document).ready(function () {
    var n = $("#score").val()
    var num = parseFloat(n) * 2
    $("td:lt(" + num + "):even").css("background-image","url(/images/s_l_o.png)")
    $("td:lt(" + num + "):odd").css("background-image","url(/images/s_r_o.png)")
})