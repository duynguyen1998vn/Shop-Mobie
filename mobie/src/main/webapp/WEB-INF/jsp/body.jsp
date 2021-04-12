<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- CSS -->
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
	<h3 style="color: red;font-size: 25px;text-align: center;margin-top:50px ">${MESSAGE}</h3>
	<div class="container">
		<div class="row">
			<c:forEach items="${LIST_PRODUCT}" var="product">
				<div class="col" style="padding-top: 3rem">
					<div class="card" style="width: 20rem; height: 33rem">
						<img class="card-img-top" src="${product.img}"
							alt="Card image cap">
						<div class="card-body">
							<h5 class="card-title">${product.name}</h5>
							<p class="card-text">${product.description}</p>
							<a href="/buy/${product.id}" class="btn btn-primary">Buy</a> <a
								href="/detail-product/${product.id}" class="btn btn-dark"
								style="float: right;">Detail</a>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>

	
</body>
</html>