<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>成员管理</title>
<!-- 引入在线编辑器 -->
<script type="text/javascript" charset="utf-8"
	src="../ueditor/ueditor.config.js"></script>
<script type="text/javascript" charset="utf-8"
	src="../ueditor/ueditor.all.min.js"></script>
<script type="text/javascript" charset="utf-8"
	src="../ueditor/lang/zh-cn/zh-cn.js"></script>
<!--  	
    <script type="text/javascript">
		var ue = UE.getEditor('addeditor').setHeight(250);
	</script>
-->
</head>

<style type="text/css">
* {
	background: none repeat scroll 0 0 transparent;
	border: 1 none;
	margin: 0;
	padding: 0;
	vertical-align: baseline;
	font-family: 微软雅黑;
}

#navi {
	width: 100%;
	position: relative;
	word-wrap: break-word;
	border-bottom: 1px solid #065FB9;
	margin: 0;
	padding: 0;
	height: 40px;
	line-height: 40px;
	vertical-align: middle;
	background-image: -moz-linear-gradient(top, #EBEBEB, #BFBFBF);
	background-image: -webkit-gradient(linear, left top, left bottom, color-stop(0, #EBEBEB),
		color-stop(1, #BFBFBF));
}

#naviDiv {
	font-size: 14px;
	color: #333;
	padding-left: 10px;
}

#tips {
	margin-top: 10px;
	width: 100%;
	height: 40px;
}

#buttonGroup {
	padding-left: 10px;
	float: left;
	height: 35px;
}

.button {
	margin-top: 5px;
	padding-left: 10px;
	padding-right: 10px;
	font-size: 16px;
	width: 120px;
	height: 35px;
	line-height: 30px;
	vertical-align: middle;
	text-align: center;
	cursor: pointer;
	border-color: #77D1F6;
	border-width: 1px;
	border-style: solid;
	border-radius: 6px 6px;
	-moz-box-shadow: 2px 2px 4px #282828;
	-webkit-box-shadow: 2px 2px 4px #282828;
	background-image: -moz-linear-gradient(top, #EBEBEB, #BFBFBF);
	background-image: -webkit-gradient(linear, left top, left bottom, color-stop(0, #EBEBEB),
		color-stop(1, #BFBFBF));
}

#mainContainer {
	padding-left: 10px;
	padding-right: 10px;
	text-align: left;
	width: 98%;
	font-size: 16px;
}
</style>
<body>
	<script type="text/javascript" src="../js/Calendar3.js"></script>

	<div id="navi">
		<div id='naviDiv'>
			<span><img src="../images/arror.gif" width="7" height="11"
				border="0" alt=""></span>&nbsp;成员管理&nbsp; <span><img
				src="../images/arror.gif" width="7" height="11" border="0" alt=""></span>&nbsp;<a
				href="<%=path%>/admin/Users_query.action">成员列表</a>&nbsp;
		</div>
	</div>

	<div id="mainContainer">
		<!-- 从session中获取集合 -->
		<strong>添加成员资料</strong>
		<hr>
		<form name="addForm" action="<%=path%>/admin/Users_add.action"
			method="post">
			<table width="750px">
				<tr>
					<td width="30%">电话：</td>
					<td><input type="text" name="phone"
						value='<s:property value="#attr.users.phone"/>' /></td>
				</tr>
				<tr>
					<td width="30%">审核是否通过：</td>
					<td><input type="text" name="isflag"
						value='<s:property value="#attr.users.isflag"/>' /></td>
				</tr>
				<tr>
					<td width="30%">身份证号：</td>
					<td><input type="text" name="uidcard"
						value='<s:property value="#attr.users.uidcard"/>' /></td>
				</tr>
				<tr>
					<td width="30%">邮箱：</td>
					<td><input type="text" name="email"
						value='<s:property value="#attr.users.email"/>' /></td>
				</tr>
				<tr>
					<td width="30%">真实姓名：</td>
					<td><input type="text" name="realname"
						value='<s:property value="#attr.users.realname"/>' /></td>
				</tr>
				<tr>
					<td width="30%">昵称：</td>
					<td><input type="text" name="username"
						value='<s:property value="#attr.users.username"/>' /></td>
				</tr>
				<tr>
					<td width="30%">密码：</td>
					<td><input type="text" name="password"
						value='<s:property value="#attr.users.password"/>' /></td>
				</tr>
				<tr>
					<td>性别：</td>
					<td><s:if test='%{#attr.users.sex=="男"}'>
							<input type="radio" name="sex" value="男" checked="checked" />男
         <input type="radio" name="sex" value="女" />女
      </s:if> <s:else>
							<input type="radio" name="sex" value="男" />男
         <input type="radio" name="sex" value="女" checked="checked" />女
      </s:else></td>
				</tr>

				<tr>
					<td width="30%">地址：</td>
					<td><input type="text" name="address"
						value='<s:property value="#attr.users.address"/>' /></td>
				</tr>
				<tr>
					<td width="30%">职位：</td>
					<td><input type="text" name="job"
						value='<s:property value="#attr.users.job"/>' /></td>
				</tr>
				<tr>
					<td width="30%">可用金额：</td>
					<td><input type="text" name="money"
						value='<s:property value="#attr.users.money"/>' /></td>
				</tr>
				<tr>
					<td width="30%">注册时间：</td>
					<td><input type="text" name="registrationtime"
						value='<s:property value="#attr.users.registrationtime"/>' /></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input class="button"
						type="submit" value="添加"></td>
				</tr>
			</table>
		</form>
	</div>
	<!-- mainContainer结束 -->

</body>
</html>