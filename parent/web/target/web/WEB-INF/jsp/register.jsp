<%@ page language="java" pageEncoding="UTF-8"%>  

<%  
	String path = request.getContextPath();  
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  
%>  

<!DOCTYPE html>  
<html>  
	<head>  
		<base href="<%=basePath%>">  
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  

		<link rel="stylesheet" type="text/css" href="Public/easyUI/themes/bootstrap/easyui.css">  
		<link rel="stylesheet" type="text/css" href="Public/easyUI/themes/icon.css">  
		<link rel="stylesheet" type="text/css" href="Public/tpl/base/style.css">  

		<script type="text/javascript" src="Public/easyUI/jquery.min.js"></script>  
		<script type="text/javascript" src="Public/easyUI/jquery.easyui.min.js"></script>  
		<script type="text/javascript">  
  
		</script>  
	</head>  

	<body>  
			<form action="/ssm/register" method="post">
				姓名：<input type="text" name="name"/><br>
				年龄 ：<input type="text" name="age"/><br>
				<input type="hidden" name="bxtoken" value="${bxtoken}">
				<input type="submit" value="注册">
			</form>
			
	</body>  

</html>  