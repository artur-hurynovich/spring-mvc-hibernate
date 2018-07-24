<%@ page language = "java" contentType = "text/html; charset=UTF-8" pageEncoding = "UTF-8" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
		<title>Read review</title>
		<link rel = "stylesheet" href = "resources/css/bootstrap.min.css" type = "text/css">
		<link rel = "stylesheet" href = "resources/css/main.css" type = "text/css">
	</head>
	<body>
		Read review:
		<form action = "edit" id = "editForm">
			<input type = "hidden" name = "reviewId" value = "${review.id}">
			<table style = "width: 50%">
				<tr>
					<td>
						Title:
					</td>
					<td>
						<input style = "width: 100%" type = "text" name = "title" value = "${review.title}" required>
					</td>
				</tr>
				<tr>
					<td>
						Text:
					</td>
					<td>
						<textarea style = "width: 100%" rows = "10" name = "text" required>${review.text}</textarea>
					</td>
				</tr>	
			</table>
		</form>
		<input type = "submit" class = "btn" form = "editForm" value = "Save">
		<input type = "button" class = "btn" value = "Back" onclick = "history.back()">
	</body>
</html>