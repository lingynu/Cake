$(document).ready(function () {
    /*为表单元素添加失去焦点事件*/
    $("form input").blur(function () {
        /*  var parent=$(this).parent();*/
        console.log("name1")
        /* parent.find(".msg").remove();/!*删除以前的提醒元素(find();查找匹配元素集中元素的所有匹配元素)*!/*/
        /*验证姓名*/
        console.log("name2")
        if($(this).is(".name")){
            console.log("name")
            var nameVal=$.trim(this.value);/*原生js去空格方式：this.replace(/(^\s*)|(\s*$)/g, "")*/
            console.log(nameVal + "11")
            var regName=/[~#^$@%&!*()<>:;'"{}【】  ]/;
            if(nameVal==""||nameVal.length<2||regName.test(nameVal)){
                console.log('error')
                var errorMsg = " 姓名非空，长度2位以上，不包含特殊字符！";
                $(".tip").eq(0).css({"color":"red","font-size":"5%"});
                $(".tip").eq(0).text(errorMsg);
            }
            else{
                var okMsg="输入正确";
                $(".tip").eq(0).css("color","green");
                $(".tip").eq(0).text(okMsg);
            }
        }
        /*验证用户名*/
        if($(this).is(".nickname")){
            console.log("name")
            var nameVal=$.trim(this.value);/*原生js去空格方式：this.replace(/(^\s*)|(\s*$)/g, "")*/
        console.log(nameVal + "11")
        if(nameVal==""||nameVal.length<2){
            console.log('error')
            var errorMsg = " 用户名非空，长度2位以上，包含任何字符！";
            $(".tip").eq(1).css({"color":"red","font-size":"5%"});
            $(".tip").eq(1).text(errorMsg);
        }
        else{
            var okMsg="输入正确";
            $(".tip").eq(1).css("color","green");
            $(".tip").eq(1).text(okMsg);
        }
    }
        /*验证手机号*/
        if($(this).is(".phone")){
            var phoneVal=$.trim(this.value);/*原生js去空格方式：this.replace(/(^\s*)|(\s*$)/g, "")*/
        console.log(phoneVal + "aaaaa");
        var regPhone=/^1[34578]\d{9}$/;
        if(phoneVal==""||(phoneVal != "" && !regPhone.test(phoneVal))){
            console.log('error'+"aaaaa");
            var errorMsg = " 手机号输入错误！";
            $(".tip").eq(2).css({"color":"red","font-size":"5%"});
            $(".tip").eq(2).text(errorMsg);
            console.log("hahaahah");
        }
        else{
            var okMsg="输入正确";
            $(".tip").eq(2).css("color","green");
            $(".tip").eq(2).text(okMsg);
        }

    }

        /*验证邮箱*/
     /*   if($(this).is(".email")){
            var emailVal=$.trim(this.value);/!*原生js去空格方式：this.replace(/(^\s*)|(\s*$)/g, "")*!/
        console.log(emailVal + "aaaaa");
        var regEmail=/.+@.+\.[a-zA-Z]{2,4}$/;
        if(emailVal==""||(emailVal != "" && !regEmail.test(emailVal))){
            console.log('error'+"aaaaa");
            var errorMsg = " 邮箱格式错误！";
            $(".tip").eq(3).css({"color":"red","font-size":"5%"});
            $(".tip").eq(3).text(errorMsg);
            console.log("hahaahah");
        }
        else{
            var okMsg="输入正确";
            $(".tip").eq(3).css("color","green");
            $(".tip").eq(3).text(okMsg);
        }

    }*/
         /*验证密码*/
        if($(this).is(".password")){
            var passwordVal=$.trim(this.value);/*/!*原生js去空格方式：this.replace(/(^\s*)|(\s*$)/g, "")*!/*/
        if(passwordVal==""){
            $(".tip").eq(4).css({"color":"red","font-size":"5%"});
            $(".tip").eq(4).text("密码为空！");
        }
        else{
            var okMsg="输入正确";
            $(".tip").eq(4).css("color","green");
            $(".tip").eq(4).text(okMsg);
        }

    }
         /*验证密码是否一致*/
        if($(this).is(".passwordcheck")){
            var passwordVal1=$.trim(this.value);/*/!*原生js去空格方式：this.replace(/(^\s*)|(\s*$)/g, "")*!/*/
            if(passwordVal1==""||(passwordVal1!=""&&$(".password").val() != $(".passwordcheck").val())){
                $(".tip").eq(5).css({"color":"red","font-size":"5%"});
                $(".tip").eq(5).text("密码为空或密码不一致！");
            }
            else{
                var okMsg="输入正确";
                $(".tip").eq(5).css("color","green");
                $(".tip").eq(5).text(okMsg);
            }

        }
    })
    /*表单验证*/
    $("#regiForm").submit(function(e){
      $(" table input").each(function () {
          if($(" table input").val()==""){
              alert("登入失败！");
              e.preventDefault();
              return false;
          }else{
          }

          })
        var list=$(".tip");
        for(var i=0;i<list.length;i++){
            var color=$(".tip").eq(i).css("color");
            if(color=="rgb(255, 0, 0)"){
                console.log("登入失败");
                alert("登入失败！");
                e.preventDefault();
                break;

            }else {
                console.log("登入成功" + $(this).css("color") + "    " + color);

            }
        }
      })


    $(".a-upload").on("change","input[type='file']",function(){
        var filePath=$(this).val();
        if(filePath.indexOf("jpg")!=-1 || filePath.indexOf("png")!=-1){
            $(".fileerrorTip").html("").hide();
            var arr=filePath.split('\\');
            var fileName=arr[arr.length-1];
            $(".showFileName").html(fileName);
        }else{
            $(".showFileName").html("");
            $(".fileerrorTip").html("您未上传文件，或者您上传文件类型有误！").show();
            return false
        }
    })











});
