function checkUsername(){
    var reg=/^\w{6,16}$/
    var inputEle=document.getElementById("username")
    var result= reg.test(inputEle.value)
    console.log(inputEle.value)
    var hintInfo=document.getElementById("checkUsernameInfo")
    console.log(result)
    if(result){
        hintInfo.innerText="用户名格式正确"
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
        alert("登录成功")
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

