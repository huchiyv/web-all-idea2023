function checkUsername(){
    var reg=/^\w{6,16}$/
    var inputEle=document.getElementById("username")
    var result= reg.test(inputEle.value)
    console.log(inputEle.value)
    var hintInfo=document.getElementById("checkUsernameInfo")
    console.log(result)
    if(result){
        hintInfo.innerText="用户名格式正确"

        //格式正确之后，继续校验用户名是否被占用
        var request =new XMLHttpRequest();
        //设置回调函数，设置响应回来的信息如何处理
        request.onreadystatechange=function (){
            if(request.readyState==4&&request.status==200){
                //alert("后端响应了")
                //console.log(hintInfo.innerText=request.responseText)
                //将json转成对象
                var result=JSON.parse(request.responseText)
                if(result.code!=200){
                    hintInfo.innerText="用户名已被占用"
                }else{
                    hintInfo.innerText="可用"
                }

            }
        }
        //设置请求方式和请求的资源路径
        request.open("get","/user/checkUserNameUsed?username="+inputEle.value)
        //发送请求
        request.send()
    }else{
        hintInfo.innerText="用户名格式错误"
    }

    console.log(hintInfo.innerText)
    return result
}

function checkPassword(){
    var reg=/^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,20}$/
    var inputEle=document.getElementById("password")
    var result= reg.test(inputEle.value)
    var result= reg.test(inputEle.value)
    console.log(inputEle.value)
    var hintInfo=document.getElementById("checkPasswordInfo")
    console.log(result)
    if(result){
        hintInfo.innerText="密码格式正确"
    }else{
        hintInfo.innerText="密码格式错误"
    }
    console.log(hintInfo.innerText)
    return result
}

function checkLogin(){
    var nameResult=checkUsername()
    var passwordResult=checkPassword()
    if(nameResult&&passwordResult){
        alert("成功")
        return true
    }else{
        alert("错误的用户名或密码,请检查")
        return false
    }

}

function checkPassword2(){
    var inputEle1=document.getElementById("password")
    var inputEle2=document.getElementById("password2")
    var hintInfo2=document.getElementById("checkPasswordInfo2")
    
    if(inputEle1.value===inputEle2.value){
        hintInfo2.innerText="ok"
        return true
    }else{
        hintInfo2.innerText="两次输入密码不一致"
        return false
    }
}

function checkRegister(){
    return checkLogin()&&checkPassword2()
}

