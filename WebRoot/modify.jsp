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
    
    <title>My JSP 'modify.jsp' starting page</title>
    
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
  <h2>修改图书</h2>
  <form action="book/modify" method="post">
  		  <input type="hidden" name="book.bookid" value="<s:property value="#request.book.bookid"/>"/>
  	书名：<input type="text" name="book.bookname" value="<s:property value="#request.book.bookname"/>" /><br/>
  	作者：<input type="text" name="book.author" value="<s:property value="#request.book.author"/>" /><br/>
  	分类：<select name="book.bookType.bookTypeId">
  			<s:iterator value="#request.bookTypeList" var="bookType">
  				<option value="<s:property value="#bookType.bookTypeId"/>"><s:property value="#bookType.typeName"/></option>
  			</s:iterator>
  		  </select><br/>
  	出版社：<input type="text" name="book.publish" value="<s:property value="#request.book.publish"/>" /><br/>
  	价格：<input type="text" name="book.price" value="<s:property value="#request.book.price"/>" /><br/>
  	<input type="submit" value="提交" />
  </form>
  <s:debug/>
  </body>
</html>
