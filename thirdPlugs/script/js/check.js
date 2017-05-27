function checkInfo(data){
	var obj = eval(data);
	if(data.msg == 0){
		alert("注册成功");
	}else if(data.msg == 1){
		alert("用户名已存在");
	}
}