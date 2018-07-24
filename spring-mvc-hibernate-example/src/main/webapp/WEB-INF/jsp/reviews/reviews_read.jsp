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
		<table style = "width: 50%">
			<tr>
				<td>
					ID:
				</td>
				<td>
					<input style = "width: 100%" type = "text" value = "${review.id}" readonly>
				</td>
			</tr>
			<tr>
				<td>
					Title:
				</td>
				<td>
					<input style = "width: 100%" type = "text" value = "${review.title}" readonly>
				</td>
			</tr>
			<tr>
				<td>
					Text:
				</td>
				<td>
					<textarea style = "width: 100%" rows = "10" readonly>${review.text}</textarea>
				</td>
			</tr>	
			<tr>
				<td>
					Date:
				</td>
				<td>
					<input style = "width: 100%" type = "text" value = "${review.date}" readonly>
				</td>
			</tr>
			<tr>
				<td>
					Author:
				</td>
				<td>
					<input style = "width: 100%" type = "text" value = "${review.authorName}" readonly>
				</td>
			</tr>
		</table>
		<br>
		<input type = "button" class = "btn" value = "Back" onclick = "history.back()">
	</body>
</html>