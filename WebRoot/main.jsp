<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'main.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <h2>主页面--展示全部图书</h2>
  <table border="1">	
  	<tr>
  		<th>书名</th>
  		<th>作者</th>
  		<th>分类</th>
  		<th>出版社</th>
  		<th>价格</th>
  		<th>修改</th>
  		<th>删除</th>
  	</tr>
	<s:iterator value="bookList" var="list">
	<tr>
		<td><s:property value="#list.bookname"/></td>
		<td><s:property value="#list.author"/></td>
		<td><s:property value="#list.bookType.typeName"/></td>
		<td><s:property value="#list.publish"/></td>
		<td><s:property value="#list.price"/></td>
		<td><a href="book/preModify?bookid=<s:property value="#list.bookid"/>">修改</a></td>
		<td><a href="book/delete?bookid=<s:property value="#list.bookid"/>">删除</a></td>
	</tr>
	</s:iterator>
	<tr><td colspan="7"><a href="book/preAdd">增加</a></td></tr>
  </table>
  <s:debug />
  </body>
</html>
