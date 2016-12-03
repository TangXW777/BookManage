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
    
    <title>My JSP 'add.jsp' starting page</title>
    
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
  <h2>增加图书</h2>
  <form action="book/add" method="post">
  	<table border="1">
  		<tr>
  			<th>书名:</th>
  			<td><input type="text" name="book.bookname" /></td>
  		</tr>
  		<tr>
  			<th>作者:</th>
  			<td><input type="text" name="book.author" /></td>
  		</tr>
  		<tr>
  			<th>分类:</th>
  			<td>
  			<select name="book.bookType.bookTypeId">
  			<s:iterator value="#request.bookTypeList" var="bookType">
  				<option value="<s:property value="#bookType.bookTypeId"/>"><s:property value="#bookType.typeName"/></option>
  			</s:iterator>
  		  </select></td>
  		</tr>
  		<tr>
  			<th>出版社:</th>
  			<td><input type="text" name="book.publish" /></td>
  		</tr>
  		<tr>
  			<th>价格:</th>
  			<td><input type="text" name="book.price" /></td>
  		</tr>
  		<tr><td colspan="2" align="center"><input type="submit" value="提交"/></td></tr>
  	</table>
  </form>
  </body>
</html>
