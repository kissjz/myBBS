<%@ page language="java" import="java.util.*" pageEncoding="GB2312"%>
<%@ page import="com.dao.NotesDAO, com.domain.Note, java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <title>留言信息列表</title>
</head>
<body>
	<h2>所有留言信息如下： </h2><br />
	
	<form name="forml2" action="./servlet/FindControllerServlet" method="POST">
	<fieldset>
	<legend>请输入查询的ID:</legend>
	ID:<br>
	<input type="text" name="id" value="">
	<br>
	<input type="submit" value="Submit"></fieldset>
	</form> 
	
	<table border="1" width="700">
		<tr>
			<th width="30">id</th>
			<th width="100">留言标题</th>
			<th width="200">内容</th>
			<th width="50">作者姓名</th>
			<th width="200">发布时间</th>
		</tr>
		<%
		NotesDAO notesDAO = new NotesDAO();
		ArrayList<Note> list = notesDAO.findAll();
		Iterator<Note> noteIt = list.iterator();
		while(noteIt.hasNext()) {
			Note tn = (Note)noteIt.next();
		%>
		<tr>
			<td><%= tn.getId() %>
			<td><%= tn.getTitle() %></td>
			<td><%= tn.getContent() %></td>
			<td><%= tn.getAuthor() %></td>
			<td><%= tn.getCreateTime() %></td>
		</tr>
		<%
		}
		%>
	</table>
</body>
</html>