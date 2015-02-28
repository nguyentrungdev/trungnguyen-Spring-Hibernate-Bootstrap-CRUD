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
	<div class="container">
		<div class="row">
			<div class="alert alert-success alert-dismissible col-sm-5 hide" role="alert">
			  <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
			  <strong>Success!</strong> Applicant Email updated successfully.
			</div>
			<c:url var="formAction" value="${formAction}" ></c:url>
			<form:form action="${formAction}" commandName="applicantEmail" method="POST" class="form-horizontal" id="applicantEmail" >
				<div class="col-sm-12">
					<div class="panel panel-default">
						<div class="panel-heading"> 
							Applicant Email Infomation
						</div>
						<div class="panel-body">
						<!-- panel body -->
							<div class="col-sm-6">
							<!--  <div class="row"> -->
								<div class="form-group required">
									<form:label path="subject" for="subject" class="control-label col-sm-3"><spring:message text="Subject"/></form:label>
									<div class="col-sm-9">
										<form:input type="text" path="subject" class="form-control" placeholder="" />
									</div>
								</div>
								
								<div class="form-group required">
									<form:label path="contentHTML" for="contentHTML" class="control-label col-sm-3 text-default"><spring:message text="Content"/></form:label>
									<div class="col-sm-9">
										<form:textarea path="contentHTML" class="form-control" placeholder="HTML/Text Content"/>
									</div>
								</div>
								
								<div class="form-group required">
									<form:label path="createdDate" for="createdDate" class="control-label col-sm-3"><spring:message text="Created Date"/></form:label>
									<div class="col-sm-9">
										<form:input path="createdDate" id="createdDate" class="form-control" placeholder="mm/dd/yyy" />
									</div>
								</div>
								
								<div class="form-group">
									<form:label path="numberOfAttachmentFile" for="numberOfAttachmentFile" class="control-label col-sm-3"><spring:message text="Number of Attachment File"/></form:label>
									<div class="col-sm-9">
										<form:input type="number" min="0" max="100" path="numberOfAttachmentFile" class="form-control" placeholder=""/>
									</div>
								</div>
								
								<div class="form-group  ">
									<form:label path="status" for="status" class="control-label col-sm-3"><spring:message text="Status"/></form:label>
									<div class="col-sm-9">
										<form:select path="status" items="${statusList}" class="form-control" />
									</div>
								</div>
								
								<div class="form-group  ">
									<form:label path="codeQuestionnare" for="codeQuestionnare" class="control-label col-sm-3"><spring:message text="Code Questionnare"/></form:label>
									<div class="col-sm-9">
										<form:input type="text" path="codeQuestionnare" class="form-control" placeholder=""/>
									</div>
								</div>
								
								
								<!--/div> -->
								</div><!-- End .col-sm-6 #1-->
								<div class="col-sm-6">
									<div class="form-group required">
										<form:label path="sendFrom" for="sendFrom" class="control-label col-sm-3"><spring:message text="Send From"/></form:label>
										<div class="col-sm-9">
											<form:input type="email" path="sendFrom" class="form-control" placeholder="Send from"/>
										</div>
									</div>
									
									<div class="form-group  ">
										<form:label path="applicantName" for="applicantName" class="control-label col-sm-3"><spring:message text="Applicant Name"/></form:label>
										<div class="col-sm-9">
											<form:input type="text" path="applicantName" class="form-control" placeholder=""/>
										</div>
									</div>
									
									<div class="form-group  ">
										<form:label path="applicantPosition" for="applicantPosition" class="control-label col-sm-3"><spring:message text="Applicant Position"/></form:label>
										<div class="col-sm-9">
											<form:input type="text" path="applicantPosition" class="form-control" placeholder=""/>
										</div>
									</div>
								</div><!-- End .col-sm-6 #2 -->
								<div class="row">
									<div class="col-xs-12 col-sm-12 col-sm-offset-1">
										<c:if test="${pageAction eq 'add'}">
											<input type="button" class="btn btn-success" value="Add" onclick="submitForm('add');">
										</c:if>
										<c:if test="${pageAction eq 'update'}">
											<input type="button" class="btn btn-info" value="Update" id="updateBtn">
										</c:if>
											<a class="btn btn-link" href="<c:url value="/" />">Back</a>
									</div>
								</div><!-- End .row button -->
						<!-- END panel body -->
						</div>
					</div>
				</div>
				<input type="hidden" name="pageAction" id="pageAction" value="add" />
			</form:form>
		</div>
	</div>
	<!-- jQuery library -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
	<!-- jQuery UI -->
	<script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.3/jquery-ui.min.js"></script>
	<!-- Latest compiled JavaScript -->
	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
	<script>
		$(function() {
			$('#createdDate').datepicker({
				format: 'mm-dd-yyyy'
			});
			$('#createdDate').datepicker('setDate', new Date());
			var jQForm = $('#applicantEmail');
			$('#updateBtn').click(function(){
				$.ajax({
		            type: jQForm.attr('method'),
		            url: jQForm.attr('action'),
		            data: jQForm.serialize(),
		            success: function (data) {
		                var success = JSON.parse(data);
		                if (success) {
		                	$('.alert-success').removeClass('hide');
		                }
		            },
		        	error: function(jqXHR, textStatus, errorThrown) {
		        		
		        	}
		        });
	
			})
		})
		
		function submitForm(pageAction) {
			var form = document.getElementById('applicantEmail');
			document.getElementById('pageAction').value = pageAction; //Not yet used
			if (!checkInput())
				return;
			form.submit();
		}
		
		function checkInput() {
			var hasError = false;
			if (document.getElementById('subject').value == '') {
				$(".form-group:has(#subject)").addClass('has-error');
				hasError = true;
			} else
				$(".form-group:has(#subject)").removeClass('has-error');
				
			if (document.getElementById('contentHTML').value == '') {
				$('.form-group:has(#contentHTML)').addClass('has-error');
				hasError = true;
			} else
				$('.form-group:has(#contentHTML)').removeClass('has-error');
			
			if (document.getElementById('createdDate').value == '') {
				$(".form-group:has(#createdDate)").addClass('has-error')
				hasError = true;
			} else 
				$(".form-group:has(#createdDate)").removeClass('has-error');
			
			if (document.getElementById('sendFrom').value == '') {
				$('.form-group:has(#sendFrom)').addClass('has-error');
				hasError = true;
			} else
				$('.form-group:has(#sendFrom)').removeClass('has-error');
			return !hasError;
		}
	</script>
</body>
</html>