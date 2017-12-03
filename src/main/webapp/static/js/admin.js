$(document).ready(function(){
	//登陆
	$("#loginForm").submit(function(){
		//md5加密
	    md5pwd();
	});
});

//md5加密
function md5pwd() {
	var pwd = MD5(MD5($("#password").val())
			+ $.trim($("#userName").val()).toLowerCase());
	$("#password").val(pwd)
}