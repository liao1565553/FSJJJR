<%@ page language="java" import="java.util.*,java.text.SimpleDateFormat"
	contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<title>资源管理</title>
<!-- 引入在线编辑器配置文件 -->
<script type="text/javascript" charset="utf-8"
	src="<%=path%>/admin/ueditor/ueditor.config.js"></script>
<!-- 引入在线编辑器源码文件 -->
<script type="text/javascript" charset="utf-8"
	src="<%=path%>/admin/ueditor/ueditor.all.min.js"></script>
<!-- 引入在线编辑器语言包文件，避免在IE下因为加载语言失败导致编辑器加载失败 -->
<script type="text/javascript" charset="utf-8"
	src="<%=path%>/admin/ueditor/lang/zh-cn/zh-cn.js"></script>
<!-- 定义在线编辑器名 -->
<script type="text/javascript">
	var editor = new UE.ui.Editor();
	editor.render("newsaddeditor");
</script>
</body>


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
	<div id="navi">
		<div id='naviDiv'>
			<span><img src="../images/arror.gif" width="7" height="11"
				border="0" alt=""></span>&nbsp;资源管理&nbsp; <span><img
					src="../images/arror.gif" width="7" height="11" border="0" alt=""></span>&nbsp;<a
				href="<%=path%>/resources/Resources_query.action">资源列表</a>&nbsp;
			
		</div>
	</div>
	<div id="mainContainer">
		<!-- 从session中获取学生集合 -->
		<strong>添加资源资料</strong>
		<hr>

		<form name="addForm" action="<%=path%>/UpLoad.action?types=resources&operation=add"
			method="post" enctype="multipart/form-data">
			<table width="750">
				<tr>
					<td width="12%">资源标题：</td>
					<td><input type="text" name="title" /></td>
				</tr>
				<tr>
					<td>资源类别：</td>
					<td><SELECT NAME="type" size=1>
							<c:forEach items="${Type_list}" var="tl">
								<option value="${tl.type}">${tl.type}</option>
							</c:forEach>
					</SELECT></td>
				</tr>
				<tr>
					<td>添加日期：</td>
					<%
						SimpleDateFormat sbr = new SimpleDateFormat("yyyy-MM-dd");
						String date1 = sbr.format(new Date());
					%>
					<td><input name="datetime" type="text" value="<%=date1%>" /></td>
				</tr>

				<tr>
					<td>上传资源：</td>
					<td><input type="file" name="paths"></td>
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