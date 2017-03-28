<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生管理</title>
<!-- 引入在线编辑器 -->
<script type="text/javascript" charset="utf-8"	src="../ueditor/ueditor.config.js"></script>
<script type="text/javascript" charset="utf-8"	src="../ueditor/ueditor.all.min.js"></script>
<script type="text/javascript" charset="utf-8"	src="../ueditor/lang/zh-cn/zh-cn.js"></script>
</head>

<link rel="stylesheet" type="text/css" href="../css/default.css" />
<style type="text/css">
* {
    background: none repeat scroll 0 0 transparent;
    border: 1 none;
    margin: 0;
    padding: 0;
    vertical-align: baseline;
	font-family:微软雅黑;
	font-size:14px;
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
	margin-top:5px;
	padding-left:10px;
	padding-right:10px;
	font-size:16px;
	width:120px;
	height:35px;
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
	text-align:left;
	width:98%;
	font-size:16px;
}
</style>
<body>
<script type="text/javascript" src="../js/Calendar3.js"></script>

<div id="navi">
	<div id='naviDiv'>
		<span><img src="../images/arror.gif" width="7" height="11" border="0" alt=""></span>&nbsp;学生管理<span>&nbsp;
		<span><img src="../images/arror.gif" width="7" height="11" border="0" alt=""></span>&nbsp;<a href="<%=path%>/students/Students_query.action">学生列表</a><span>&nbsp;
	</div>
</div>

<div id="mainContainer">
<!-- 从session中获取学生集合 -->
<strong>修改学生资料</strong>
<hr>
<form name="addForm" action="<%=path%>/students/Students_save.action" method="post">
<table width="750px" >
  <tr>
    <td width="12%">学号：</td>
    <td><input type="text" name="sid" value='<s:property value="#attr.modify_students.sid"/>'  readonly="readonly"/></td>
  </tr>
  <tr>
    <td width="12%">姓名：</td>
    <td><input type="text" name="sname" value='<s:property value="#attr.modify_students.sname"/>'/></td>
  </tr>
  <tr>
    <td>性别：</td>
    <td>
      <s:if test='%{#attr.modify_students.gender=="男"}'>
         <input type="radio" name="gender" value="男" checked="checked"/>男
         <input type="radio" name="gender" value="女"/>女
      </s:if>
      <s:else>
         <input type="radio" name="gender" value="男" />男
         <input type="radio" name="gender" value="女" checked="checked"/>女
      </s:else>
      </td>
  </tr>
  <tr>
    <td>出生日期：</td>
    <td><input name="birthday" type="text" id="control_date" size="20"
      maxlength="10" onclick="new Calendar().show(this);" readonly="readonly" 
      value="<s:date name="#attr.modify_students.birthday" format="yyyy-MM-dd"/>"
      />
    </td>
  </tr>
  <tr>
    <td>地址：</td>
    <td><input type="text" name="address" value='<s:property value="#attr.modify_students.address"/>'/></td>
  </tr>
  <!--  
   <tr>
    <td>个人简介：</td>
    <td><input type="text" name="content" value='<s:property value="#attr.modify_students.content"/>'/></td>
  </tr>
  -->  
 
		  <tr><td valign="top">个人简介：</td>
	 			<td> 
		 			<div>详情</div>
			    		<div>
			        		<script id="modieditor" type="text/plain" name="content" >
                                  "<s:property value="#attr.modify_students.content"/>  "
                            </script>
                            
                            <script type="text/javascript">
								var ue = UE.getEditor("modieditor").setHeight(220);
							</script>
	                        <script type="text/javascript">  
	                          var editor=new UE.ui.Editor();
	                          editor.render("modieditor")	                       
	                        </script>
			    		</div>
	 			</td>
	 		</tr> 
 <!-- 
 <tr> 
 	<td valign="top">个人简介：</td>
 <td> 
 	<div>详情</label></div>
			<script id="modieditor" type="text/plain" name="content"  style="width:660px;height:220px;">er</script>
	    
	         <script type="text/javascript">  
	                 var editor=new UE.ui.Editor();
	                 editor.render("modieditor")	                       
	          </script>
	    
			  <script id="editor" type="text/plain" style="width:660px;height:220px;" name="content" value='<s:property value="#attr.modify_students.content"/>'/></script>
		      <textarea id="editor1" name="content" value='<s:property value="#attr.modify_students.content"/>'/></textarea>
	</div>
 </td>
 </tr> -->

  <tr>
    <td colspan="2" align="center"><input class="button" type="submit" value="修改"></td>
  </tr>
</table>
</form>


</div>
</body>
</html>