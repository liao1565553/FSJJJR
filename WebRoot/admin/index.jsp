<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	// response.write(path+"/users/Users_login.jsp");
	out.println("path:" + path);
	response.sendRedirect(path + "/admin/users/logout.jsp");
%>