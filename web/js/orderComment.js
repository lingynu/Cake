$(document).ready(function(){
    $("td").mouseover(function(){
        var num = $(this).index() + 1
        var score = num * 0.5
        $("td:lt(" + num + "):even").css("background-image","url(/images/s_l_o.png)")
        $("td:lt(" + num + "):odd").css("background-image","url(/images/s_r_o.png)")

        $("#score").val(score)
    })

    $("td").mouseout(function(){
        var num = $(this).index() + 1
        $("td:lt(" + num + "):even").css("background-image","url(/images/s_l_g.png)")
        $("td:lt(" + num + "):odd").css("background-image","url(/images/s_r_g.png)")
    })

    $("td").click(function(){
        var num = $(this).index() + 1
        var score = num * 0.5
        $("#score").val(score)
        $("td").unbind()
    })
})