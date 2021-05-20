<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>

	<form method="post" action="addSeries">
		<input type="text" name="id"><br>
		<input type="text" name="name"><br>
		<input type="text" name="seasons"><br>
		<input type="text" name="episodes"><br>
		<input type="text" name="rating"><br>
		<input type="submit"><br>
	</form>
	
	<form id="formUpdate">
<!-- 		<input type="hidden" name="_method" value="PUT" > -->
		<input type="text" name="id"><br>
		<input type="text" name="name"><br>
		<input type="text" name="seasons"><br>
		<input type="text" name="episodes"><br>
		<input type="text" name="rating"><br>
		<input type="submit"><br>
	
	</form>
	<script>
	$("#formUpdate").on("submit",function(e){
		var dataForm=$("#formUpdate").serialize();
		alert(dataForm);
		$.ajax({
			type: "PUT",
			url: "update",
			data: dataForm,
			dataType: "text"
		})
	})
	</script>
</body>
</html>