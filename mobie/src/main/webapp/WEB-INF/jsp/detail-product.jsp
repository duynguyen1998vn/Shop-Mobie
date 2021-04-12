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
</head>
<body>

	<div class="container" style="padding-top:5rem">
		<div class="card mb-3" style="width: 50em; height: 70em; margin: auto">
			<img class="card-img-top" src="${product.img}" alt="Card image cap">
			<div class="card-body">
				<h4 class="card-title">${product.name}</h4>
				<p class="card-text">${product.description}</p>
				<p class="card-text">${product.price}$</p>
				<p class="card-text">Type: ${product.type}</p>
				<p class="card-text">Brand: ${product.brand}</p>
				<a href="/buy/${product.id}" class="btn btn-primary">Buy</a>
			</div>
		</div>
	</div>
</body>
</html>