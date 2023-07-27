<%@page import="com.entity.ToDoTask"%>
<%@page import="java.util.List"%>
<%@page import="org.hibernate.Query"%>
<%@page import="com.helper.FactoryProvider"%>
<%@page import="org.hibernate.Session"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View All Notes</title>
<%@include file="all_js_css.jsp"%>

</head>
<body>
	<div class="container">
		<%@include file="navbar.jsp"%>
		<br>
		<h1 class="text-uppercase" style="text-decoration: underline;">All
			Notes</h1>
		<div class="row">
			<div class="col">
				<%
				Session s = FactoryProvider.getFactory().openSession();
				Query q = s.createQuery("from ToDoTask");
				List<ToDoTask> list = q.list();
				for (ToDoTask note : list) {
				%>
				<div class="card text-white bg-info mb-3 mt-3">
					<div class="container text-center">
						<img class="card-img-top m-3" style="max-width: 75px"
							src="img/notes.png" alt="Card image cap">
					</div>
					<div class="card-body px-5" style="text-align: justify">
						<h5 class="card-title"><%=note.getTitle()%></h5>
						<p class="card-text">
							<%=note.getContent()%>
						</p>

						<p style="color: black">
							<b><%=note.getDate()%><b></b>
						</p>

						<div class="container text-center">
							<a href="DeleteServ?note_id=<%=note.getId()%>"
								class="btn btn-danger">Delete</a> <a
								href="edit.jsp?note_id=<%=note.getId()%>"
								class="btn btn-secondary">Update</a>
						</div>
					</div>
				</div>
				<%
				}
				s.close();
				%>

				<!-- out.println(note.getId()+" : "+note.getTitle()+"<br>"); -->

			</div>
		</div>


	</div>
</body>
</html>