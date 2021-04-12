<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">

		<a class="navbar-brand" href="/home"><img
			src="https://i.pinimg.com/originals/59/26/3a/59263a1c263ade9bbaed2edd7caff2af.jpg"
			alt="Logo" style="width: 40px;"></a>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active"><a class="nav-link" href="/home">Home
						<span class="sr-only">(current)</span>
				</a></li>
				<li class="nav-item"><a class="nav-link" href="/login">${LOGIN}</a></li>

				<li class="nav-item"><a class="navbar-brand" href="/my-cart"><img
			src="https://png.pngtree.com/png-clipart/20200224/original/pngtree-cart-plain-shoping-trolly-icon-vector-illustration-for-web-png-image_5225644.jpg"
			alt="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRROFzSMFPOvBqnKUy7H4azxttJwkeNAENEHQ&usqp=CAU" style="width: 40px;"></a></li>
			<li class="nav-item"><a class="nav-link" href="/" >Note</a></li>
			</ul>
			<form class="form-inline my-2 my-lg-0" action="/search">
				<input class="form-control mr-sm-2" type="search"
					placeholder="Search" aria-label="Search" name="searchKey">
				<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
			</form>
		</div>
	</nav>

</body>
</html>