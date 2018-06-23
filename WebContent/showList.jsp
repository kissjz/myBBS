<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@ page import=" com.domain.Note, java.util.*,javax.servlet.*" %>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>通过id来查找</h1>

	<table border="1" width="700">
		<tr>
 			<th width="30">id</th>
			<th width="100">留言标题</th>
			<th width="200">内容</th>
			<th width="50">作者姓名</th>
			<th width="200">发布时间</th>
		</tr>
		<%
		Note note = (Note)request.getAttribute("note");
		if(note != null){
		%>
		<tr>
  			<td><%= note.getId() %></td>
			<td><%= note.getTitle() %></td>
			<td><%= note.getContent() %></td>
			<td><%= note.getAuthor() %></td>
			<td><%= note.getCreateTime() %></td>
		</tr>
		<%
		}
		%>
	</table>
</body>
</html>