<%@page import="com.entity.ToDoTask"%>
<%@page import="com.helper.FactoryProvider"%>
<%@page import="org.hibernate.Session"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1" />
<title>Update Note page</title>
<%@include file="all_js_css.jsp"%>
</head>
<body>
	<div class="container">
		<%@include file="navbar.jsp"%>
		<br />
		<h1>Update your notes here-</h1>
		<% int noteId = Integer.parseInt(request.getParameter("note_id").trim());
      Session s = FactoryProvider.getFactory().openSession(); ToDoTask toDo =
      (ToDoTask) s.get(ToDoTask.class, noteId); %>

		<form action="UpdateServlet" method="post">
			<input value="<%=toDo.getId()%>" name="noteId" type="hidden" />
			<div class="form-group">
				<label for="title">Note Title</label> <input name="title"
					type="text" class="form-control" id="title"
					aria-describedby="emailHelp" placeholder="Enter title here"
					required value="<%=toDo.getTitle()%>" />
			</div>
			<div class="form-group">
				<label for="exampleInputPassword1">Note Content</label>
				<textarea name="content" id="your content"
					placeholder="Enter your content here" class="form-control"
					style="height: 200px" required>
					<%=toDo.getContent()%>
					</textarea>
			</div>
			<div class="container text-center">
				<button type="submit" class="btn btn-primary">Apply</button>
			</div>
		</form>
	</div>
</body>
</html>