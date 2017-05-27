function qiandao(data){
	var obj = eval(data);
	var UserName = obj.msg;
	document.getElementById("signin").innerText = UserName ;
}