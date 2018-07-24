<%@ page language = "java" contentType = "text/html; charset=UTF-8" pageEncoding = "UTF-8" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
		<title>Reviews</title>
		<link rel = "stylesheet" href = "resources/css/bootstrap.min.css" type = "text/css">
		<link rel = "stylesheet" href = "resources/css/main.css" type = "text/css">
		<script src = "https://code.jquery.com/jquery-3.3.1.js"></script>
		<script src = "https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
		<script src = "https://stackpath.bootstrapcdn.com/bootstrap/4.1.2/js/bootstrap.min.js"></script>
	</head>
	<body>
		<form action = "newReview" style = "margin: 0">
			<span>Create new review:</span>
			<input type = "submit" class = "btn" value = "New review">
		</form>
		<br>
		<c:choose>
			<c:when test = "${not empty reviews}">
				<table style = "width: 50%">
					<tr>
						<th>
							Title
						</th>
						<th>
							Text
						</th>
						<th>
							Date
						</th>
						<th>
							Author
						</th>
						<th>
						<th>
						<th>
					</tr>
					<c:forEach var = "review" items = "${reviews}">
						<tr>
							<td>
								${review.titlePreview}
							</td>
							<td>
								${review.textPreview}
							</td>
							<td>
								${review.date}
							</td>
							<td>
								${review.authorName}
							</td>
							<td>
								<form action = "readReview" style = "margin: 0">
									<input type = "hidden" name = "reviewId" value = "${review.id}">
									<input type = "submit" class = "btn" value = "Read">
								</form>
							</td>
							<td>
								<form action = "editReview" style = "margin: 0">
									<input type = "hidden" name = "reviewId" value = "${review.id}">
									<input type = "submit" class = "btn" value = "Edit">
								</form>
							</td>
							<td>
								<input type = "submit" class = "btn" data-toggle = "modal" data-target = "#reviewDeleteModal" 
								data-review-id = "${review.id}" value = "Delete">
							</td>
						</tr>
					</c:forEach>
				</table>
			</c:when>
			<c:otherwise>
				<h4>Reviews not found!</h4>
			</c:otherwise>
		</c:choose>
		<div class = "modal fade" id = "reviewDeleteModal" role = "dialog">
  			<div class = "modal-dialog modal-dialog-centered" role = "document">
  				<div class = "modal-content">
    				<div class = "modal-body">
     					Are you sure you want to delete review?
    				</div>
    				<div class = "modal-footer">
    					<form action = "delete" method = "post" style = "margin: 0">
							<input type = "hidden" name = "reviewId">
							<input type = "submit" class = "btn" value = "Delete">
						</form>
						<input type = "submit" class = "btn" value = "Cancel" data-dismiss = "modal">
    				</div>
    			</div>
  			</div>
		</div>
		<script type = "text/javascript">
			$('#reviewDeleteModal').on('show.bs.modal', function(e) {
				var reviewId = $(e.relatedTarget).data('review-id');
			    $(e.currentTarget).find('input[name="reviewId"]').val(reviewId);
			});
		</script>
	</body>
</html>