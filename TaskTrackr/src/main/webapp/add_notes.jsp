<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<title>Add tasks</title>
<%@include file="all_js_css.jsp"%>

</head>
<body>

	<div class="container">
		<%@include file="navbar.jsp"%>
		<br>
		<h1>Please fill your note details.</h1>
		<br>
		<!-- This is form to add task-->
		<form action="ServletNoteSave" method="post">
			<div class="form-group">
				<label for="title">Note Title</label> <input name="title"
					type="text" class="form-control" id="title"
					aria-describedby="emailHelp" placeholder="Enter title here"
					required>

			</div>
			<div class="form-group">
				<label for="exampleInputPassword1">Note Content</label>
				<textarea name="content" id="your content"
					placeholder="Enter your content here" class="form-control"
					style="height: 200px;" required></textarea>
			</div>
			<div class="container text-center">
				<button type="submit" class="btn btn-primary">Add</button>
			</div>
		</form>
	</div>

</body>
</html>