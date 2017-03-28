<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags"%>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
	<meta http-equiv="content-type" content="text/html;charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="<%=path%>/admin/css/default.css" />
<style type="text/css">
* {
    background: none repeat scroll 0 0 transparent;
    border: 0 none;
    margin: 0;
    padding: 0;
    vertical-align: baseline;
	font-family:微软雅黑;
}
#navi{
	width:100%;
	position:relative;
	word-wrap:break-word;
	border-bottom:1px solid #065FB9;
	margin:0;
	padding:0;
	height:40px;
	line-height:40px;
	vertical-align:middle;
    background-image: -moz-linear-gradient(top,#EBEBEB, #BFBFBF);
    background-image: -webkit-gradient(linear, left top, left bottom, color-stop(0, #EBEBEB),color-stop(1, 
#BFBFBF));
}
#naviDiv{
	font-size:14px;
	color:#333;
	padding-left:10px;
}
#tips{
	margin-top:10px;
	width:100%;
	height:40px;
}
#buttonGroup{
	padding-left:10px;
	float:left;
	height:35px;
}
.button{
	float:left;
	margin-right:10px;
	padding-left:10px;
	padding-right:10px;
	font-size:14px;
	width:70px;
	height:30px;
	line-height:30px;
	vertical-align:middle;
	text-align:center;
	cursor:pointer;
    border-color: #77D1F6;
    border-width: 1px;
    border-style: solid;
    border-radius: 6px 6px;
    -moz-box-shadow: 2px 2px 4px #282828;
    -webkit-box-shadow: 2px 2px 4px #282828;
    background-image: -moz-linear-gradient(top,#EBEBEB, #BFBFBF);
    background-image: -webkit-gradient(linear, left top, left bottom, color-stop(0, #EBEBEB),color-stop(1, #BFBFBF));
}
#mainContainer{
	padding-left:10px;
	padding-right:10px;
	text-align:center;
	width:98%;
	font-size:14px;
	font-family:微软雅黑;
}
</style>
<body>
<div id="navi">
	<div id='naviDiv'>
		<span><img src="../images/arror.gif" width="7" height="11" border="0" alt=""></span>&nbsp;<a href="<%=path%>/admin/students/Students_add.jsp"></a>学生管理<span>&nbsp;
		<span><img src="../images/arror.gif" width="7" height="11" border="0" alt=""></span>&nbsp;<a href="./admin/students/Students_query.action">学生列表</a><span>&nbsp;
	</div>
</div>
<div id="tips">
	<div id="buttonGroup">
		<div class="button" onmouseout="this.style.backgroundColor='';this.style.fontWeight='normal'" onmouseover="this.style.backgroundColor='#77D1F6';this.style.fontWeight='bold'">
			<a href="<%=path%>/admin/students/Students_add.jsp">添加学生</a>
		</div>
		<div class="button" onmouseout="this.style.backgroundColor='';this.style.fontWeight='normal'" onmouseover="this.style.backgroundColor='#77D1F6';this.style.fontWeight='bold'">
			<a>查找学生</a>
		</div>
	</div>
</div>
<div id="mainContainer">
<!-- 从session中获取学生集合 -->
<table class="default" width="100%">
	<col width="10%">
	<col width="20%">
	<col width="5%">
	<col width="20%">
	<col width="30%">
	<col width="15%">
	<tr class="title">
		<td>学号</td>
		<td>姓名</td>
		<td>性别</td>
		<td>出生日期</td>
		<td>地址</td>
		<td>操作</td>
	</tr>
	
	<!-- 遍历开始-->
	<!-- s:iterator   表示迭代标签	 -->
	<!--  value表示从哪个地方获得遍历的集合 value="#session.students_list"    -->
    <!--   因为students_list放在session中，要通过上下文栈获得，因此用#，然后带上session.students_list-->
	<!--   var表示取出的每一个对象命名为stu,可以被调用。  -->
	<s:iterator value="#attr.list_page" var="stu">
		<tr class="list">
			<td><s:property value="#stu.sid"/></td>
			<td><a href="./students/Students_modify.action?sid=<s:property value="#stu.sid"/>"><s:property value="#stu.sname"/></a></td>
			<td><s:property value="#stu.gender"/></td>
			<td><s:date name="#stu.birthday" format="yyyy年MM月dd日"/></td>
			<td><s:property value="#stu.address"/></td>
			<td><a href="./students/Students_modify.action?sid=<s:property value="#stu.sid"/>" >修改    </a>
			<a href="./students/Students_delete.action?sid=<s:property value="#stu.sid"/>" onclick="javascript: return confirm('真的要删除吗？');">     删除</a></td>
		</tr>
	</s:iterator>
	<!-- 遍历结束 -->
</table>

  <div class="page">
   		共${pageCount}页，当前是第${pageNumber}页
  		 <br>
		<c:if test="${pageNumber>1 }">
			<a href="./students/Students_query.action?pageNumber=1">首页</a>
			<a href="./students/Students_query.action?pageNumber=${pageNumber-1}">上一页</a>
		</c:if>
		<c:if test="${pageNumber!=pageCount}">
			<a href="./students/Students_query.action?pageNumber=${pageNumber+1}">下一页</a>
			<a href="./students/Students_query.action?pageNumber=${pageCount}">末页</a>
		</c:if>
   </div>
</div><!-- mainContainer结束 -->
</body>
</html>