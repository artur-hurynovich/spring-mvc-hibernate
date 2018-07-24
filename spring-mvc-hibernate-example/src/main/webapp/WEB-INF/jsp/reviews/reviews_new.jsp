<%@ page language = "java" contentType = "text/html; charset=UTF-8" pageEncoding = "UTF-8" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
		<title>New review</title>
		<link rel = "stylesheet" href = "resources/css/bootstrap.min.css" type = "text/css">
		<link rel = "stylesheet" href = "resources/css/main.css" type = "text/css">
	</head>
	<body>
		New review:
		<form action = "new" id = "newForm" method = "post">
			<table style = "width: 50%">
				<tr>
					<td>
						Title:
					</td>
					<td>
						<input style = "width: 100%" type = "text" name = "title" required>
					</td>
				</tr>
				<tr>
					<td>
						Text:
					</td>
					<td>
						<textarea style = "width: 100%" rows = "10" name = "text" required></textarea>
					</td>
				</tr>	
				<tr>
					<td>
						Author:
					</td>
					<td>
						<input style = "width: 100%" type = "text" name = "authorName" required>
					</td>
				</tr>
			</table>
		</form>
		<input type = "submit" class = "btn" form = "newForm" value = "Save">
		<input type = "button" class = "btn" value = "Cancel" onclick = "history.back()">
	</body>
</html>