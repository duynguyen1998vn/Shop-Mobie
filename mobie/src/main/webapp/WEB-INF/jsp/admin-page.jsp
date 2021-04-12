<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">

<!-- jQuery and JS bundle w/ Popper.js -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
	integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx"
	crossorigin="anonymous"></script>
<style>
<%@ include file="/WEB-INF/jsp/css/admin-page.css"%></style>
</head>
<body>

	<div class="vertical-nav bg-white" id="sidebar">
		<div class="py-4 px-3 mb-4 bg-light">
			<div class="media d-flex align-items-center">
				<img
					src="https://i.pinimg.com/originals/98/a3/c5/98a3c583ff9bc2efee03061f74d538ca.jpg"
					alt="..." width="65"
					class="mr-3 rounded-circle img-thumbnail shadow-sm">
				<div class="media-body">
					<h4 class="m-0">ADMIN</h4>
					<p class="font-weight-light text-muted mb-0">Web developer</p>
				</div>
			</div>
		</div>

		<p
			class="text-gray font-weight-bold text-uppercase px-3 small pb-4 mb-0">Nav</p>

		<ul class="nav flex-column bg-white mb-0">
			<li class="nav-item"><a href="/home"
				class="nav-link text-dark font-italic bg-light"> <i
					class="fa fa-th-large mr-3 text-primary fa-fw"></i> Home
			</a></li>
			<li class="nav-item"><a href="#"
				class="nav-link text-dark font-italic"> <i
					class="fa fa-address-card mr-3 text-primary fa-fw"></i> About
			</a></li>
			<li class="nav-item"><a href="#"
				class="nav-link text-dark font-italic"> <i
					class="fa fa-cubes mr-3 text-primary fa-fw"></i> contact
			</a></li>
		</ul>


		<div class="container">
			<table class="table">
				<thead>
					<tr>
						<th>Firstname</th>
						<th>Lastname</th>
						<th>Email</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>Default</td>
						<td>Defaultson</td>
						<td>def@somemail.com</td>
					</tr>
					<tr class="success">
						<td>Success</td>
						<td>Doe</td>
						<td>john@example.com</td>
					</tr>
					<tr class="danger">
						<td>Danger</td>
						<td>Moe</td>
						<td>mary@example.com</td>
					</tr>
					<tr class="info">
						<td>Info</td>
						<td>Dooley</td>
						<td>july@example.com</td>
					</tr>
					<tr class="warning">
						<td>Warning</td>
						<td>Refs</td>
						<td>bo@example.com</td>
					</tr>
					<tr class="active">
						<td>Active</td>
						<td>Activeson</td>
						<td>act@example.com</td>
					</tr>
				</tbody>
			</table>
		</div>
		<!-- End demo content -->
		<script type="text/javascript">
			$(function() {
				// Sidebar toggle behavior
				$('#sidebarCollapse').on('click', function() {
					$('#sidebar, #content').toggleClass('active');
				});
			});
		</script>
</body>
</html>