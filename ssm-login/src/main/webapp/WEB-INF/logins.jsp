<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/bootstrap-3.3.7-dist/css/bootstrap.css">
<script src="<%=request.getContextPath()%>/bootstrap-3.3.7-dist/js/jquery-1.11.3.js"></script>
<script src="<%=request.getContextPath()%>/bootstrap-3.3.7-dist/js/bootstrap.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/login.js"></script>
 
</head>
<body>
<div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column">
			<form id="loginForm" class="form-horizontal" role="form">
				<div class="form-group">
					 <label for="inputEmail3" class="col-sm-2 control-label" >账号:</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" name="uname" id="inputEmail3" />
					</div>
				</div>
				<div class="form-group">
					 <label for="inputPassword3" class="col-sm-2 control-label">密码:</label>
					<div class="col-sm-10">
						<input type="password" class="form-control" name="upwd" id="inputPassword3" />
					</div>
				</div>
				<div class="form-group">
					 <label for="inputPassword3" class="col-sm-2 control-label">验证码:</label>
					<div class="col-sm-10">
						<input name="volidImgText" id="volidImgTextId"/>
						<img id='volidImg'  onclick='flushImg()' src="<%=request.getContextPath()%>/authImg" height="20" width="100"/>
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<div class="checkbox">
							 <label><input type="checkbox" />记住密码</label>
						</div>
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						 <button type="button" class="btn btn-default" onclick="login()">登录</button>
					</div>
				</div>
			</form>
	</div>
</div>
</div>
</body>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.10.2.js"></script>
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
	        	alert(data);
	        if(data==0){
	        	location.href="<%=request.getContextPath()%>/passport/toHome.do";
	        }else{
	        	alert("登陆失败!请重新登录!");
	        }
	        	
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