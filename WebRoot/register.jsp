<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	//request.setCharacterEncoding("UTF-8");
	//response.setContentType("text/html;charset=UTF-8");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

<title>德玛西亚</title>
<style type="text/css">
form {
	width: 1366px;
	padding-left: 450px;
}
</style>
</head>
<body>
	<h3 align="center">学生信息注册</h3>
	<form name="stu" method="post" action="<%=path%>/operation/Users_add.action">
		<table>
			<tr>
				<td>电话：</td>
				<td><input type="text" name="phone"></td>
			</tr>
			<tr>
				<td>身份证：</td>
				<td><input type="text" name="uidcard"></td>
			</tr>
			<tr>
				<td>昵称：</td>
				<td><input type="text" name="username"></td>
			</tr>
			<tr>
				<td>性别：</td>
				<td><input type="radio" name="sex" checked="checked" value="男">男
					<input type="radio" name="sex" value="女">女</td>
			</tr>
			<tr>
				<td>上传照片:</td>
				<td colspan="2"><input type="file"></td>
			</tr>
			<tr>
				<td>密码:</td>
				<td><input type="password" name="password"></td>
			</tr>
			<tr>
				<td><input type="submit" value=" 提交" /><input type="reset"
					value="取消" /></td>
			</tr>
		</table>
	</form>
</body>
</html>
