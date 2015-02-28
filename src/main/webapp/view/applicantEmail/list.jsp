<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"  %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<!DOCTYPE html">
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Normalize CSS for all browser-->
<link rel="stylesheet" href="<c:url value="/resources/css/normalize.css" />" >
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
<!-- JQuery UI -->
<link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.3/themes/smoothness/jquery-ui.css" />
<!-- Main CSS  -->
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">

<title>Tet practice - TrungNguyen</title>
</head>
<body>
	<c:url var="addURI" value="applicantEmail"></c:url>
	<c:url var="deleteURI" value="/applicantEmails"></c:url>
	
	<div class="container">
		<form action="${deleteURI}" method="post" id="applicantEmails">
			<div class="action-bar row">
				<div class="left-col col-sm-6">
					<a class="btn btn-success" href="<c:url value="${addURI}" />" >Add</a>
					<input type="button"
						class="btn btn-danger" value="Delete" id="deleteBtn">
				</div>
	
			</div>
			<table class="table table-bordered table-striped">
				<thead>
					<tr>
						<th><input type="checkbox" id="checkAll"></th>
						<th>Subject</th>
						<th>Applicant Name</th>
						<th>Send From</th>
						<th>Status</th>
						<th>Created Date</th>
					</tr>
				</thead>
	
				<tbody>
	
					<c:forEach var="applicantEmail" items="${applicantEmailList}" varStatus="c">
						<tr>
							<td><input type="checkbox" value="${applicantEmail.id}"
								name="applicantEmailIds"></td>
							<td><a
								href="<c:url value="/applicantEmail/${applicantEmail.id}"/>">${applicantEmail.subject}</a></td>
							<td>${applicantEmail.applicantName}</td>
							<td>${applicantEmail.sendFrom}</td>
							<td>${applicantEmail.status}</td>
							<td>${applicantEmail.createdDate}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<input type="hidden" id="pageAction" name="pageAction" value="">
		</form>
	</div>
	<!-- jQuery library -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
	<!-- jQuery UI -->
	<script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.3/jquery-ui.min.js"></script>
	<!-- Latest compiled JavaScript -->
	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
	<!-- Bootbox Custom Dialog -->
	<script type="text/javascript"
		src="<c:url value="/resources/js/bootbox.js" />"></script>
	<script>
		$(function() {
			$('#deleteBtn').click(function() {
				bootbox.confirm('Are your sure?',
					function(result) {
					if (result == true) {
						var form = document.getElementById('applicantEmails');
						var pageAction = document.getElementById('pageAction');
						pageAction.value = "delete";
						form.submit();
					}
				});
			});
			
			$("#checkAll").on('change', function() {
				var checkAllValue = $("#checkAll").prop("checked");
				if (checkAllValue == true) {
					$("td input[type='checkbox']").prop("checked", true);
				} else {
					$("td input[type='checkbox']").prop("checked", false);
				}
			});
		})
	</script>
</body>
</html>