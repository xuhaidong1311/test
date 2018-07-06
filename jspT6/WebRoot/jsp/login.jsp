<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>登录页面</title>
	<link href="../css/style.css" rel="stylesheet" type="text/css"/>
  </head>
  
<body>
	<form action="../LoginServlet" method="post">
		<div class="contain">
			<div class="login">
				<ul>
					<li><input name="account" type="text" class="login-one"/></li>
					<li><input name="password" type="password" class="login-two"/></li>
					<li>&nbsp;&nbsp;<input name="" type="image" src="../images/Login.gif" onclick="alert('用户【convser】恭喜你登录成功')"/>
						&nbsp;&nbsp;<input name="" type="image" src="../images/rer.gif" /></li>
				</ul>
			</div>
		</div>
	</form>    
</body>
</html>
