<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/js/artDialog-master/ui-dialog.css">

</head>
<body>

	<form id="loginForm">
			用户名:<input name="uname"/><br>
			密码:<input type='password'  name='upwd'/><br>
			验证码：<input name="volidImgText" id="volidImgTextId"/>
			<img id='volidImg'  onclick='flushImg()' src="<%=request.getContextPath()%>/authImg" height="20" width="100"/>
			<br>
			<input  type="button" value="登陆" onclick="login()"/>
	</form>
</body>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.10.2.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/artDialog-master/dialog-min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/login.js"></script>
<script type="text/javascript">
//登陆
function login(){
	if($("#volidImgTextId").val() != ""){
		$.ajax({
	        url: "<%=request.getContextPath()%>/passport/login.do",
	        type:"post",
	        data:$("#loginForm").serialize(),
	        dataType:"json",//规定返回值格式
	      	async:false,//同步上传
	        success:function (data){//成功回调函数
	        	alert(data==0?"成功":"失败");
	        	location.href="<%=request.getContextPath()%>/passport/toHome.do";
	        },
	        error :function(data){//错误回调函数
	            console.info(data)
	        }
		});
		return;
	}
	alert("请填写验证码");
	
}

</script>
</html>