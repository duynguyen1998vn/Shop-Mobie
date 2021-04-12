<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 

<!DOCTYPE html>
<html lang="vi">
<head>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>


<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="keywords"
	content="unique login form,leamug login form,boostrap login form,responsive login form,free css html login form,download login form">
<meta name="author" content="leamug">
<title>FORM LOGIN</title>
<link href="css/style.css" rel="stylesheet" id="style">
<!-- Bootstrap core Library -->
<link
	href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<!-- Google font -->
<link href="https://fonts.googleapis.com/css?family=Dancing+Script"
	rel="stylesheet">
<!-- Font Awesome-->
<link
	href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css"
	rel="stylesheet">
	
<style><%@include file="/WEB-INF/jsp/css/form.css"%></style>
</head>
<body>
<a class="btn btn-dark" href="/home" style="margin:10px 0 0 10px;">Home</a> 
	<div class="login-reg-panel">
		<div class="login-info-box">
			<h2>Have an account?</h2>
			<label id="label-register" for="log-reg-show">Login</label> <input
				type="radio" name="active-log-panel" id="log-reg-show"
				checked="checked">
		</div>

		<div class="register-info-box">
			<h2>Don't have an account?</h2>
			<label id="label-login" for="log-login-show">Register</label> <input
				type="radio" name="active-log-panel" id="log-login-show">
		</div>

		<div class="white-panel">
			<div class="login-show">
				<form action="/login" method="POST">
					<h2 style="color: red;font-size: 22px;text-align: center;">${MESSAGE}</h2>
					<h2>LOGIN</h2>
					<input type="text" placeholder="Acount" name="account"> <input
						type="password" placeholder="Password" name="password"> <input
						type="submit" value="Login">
				</form>
			</div>
			 <div class="register-show">
				 <form action="/create-account" method="POST">
					<h2>REGISTER</h2>
					<input type="text" placeholder="Acount" name="accountRegis"> 
					<input type="password" placeholder="Password" name="passwordRegis">
					<input type="text" placeholder="Your Name" name="nameRegis">
					<input type="text" placeholder="Your Address" name="addressRegis">
					<input type="text" placeholder="Your Phone" name="phoneRegis">
					<input type="submit" value="Register">
				</form>
			</div> 
		</div>
	</div>

	<script type="text/javascript">
		$(document).ready(function() {
			$('.login-info-box').fadeOut();
			$('.login-show').addClass('show-log-panel');
		});

		$('.login-reg-panel input[type="radio"]').on('change', function() {
			if ($('#log-login-show').is(':checked')) {
				$('.register-info-box').fadeOut();
				$('.login-info-box').fadeIn();

				$('.white-panel').addClass('right-log');
				$('.register-show').addClass('show-log-panel');
				$('.login-show').removeClass('show-log-panel');

			} else if ($('#log-reg-show').is(':checked')) {
				$('.register-info-box').fadeIn();
				$('.login-info-box').fadeOut();

				$('.white-panel').removeClass('right-log');

				$('.login-show').addClass('show-log-panel');
				$('.register-show').removeClass('show-log-panel');
			}
		});
	</script>
</body>
</html>


