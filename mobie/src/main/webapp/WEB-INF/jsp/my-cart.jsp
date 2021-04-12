<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
</head>
<body>
	<div class="container">
		<div class="card shopping-cart">
			<div class="card-header bg-dark text-light">
				<i class="fa fa-shopping-cart" aria-hidden="true"></i> Your Cart <a
					href="" class="btn btn-outline-info btn-sm pull-right"
					style="float: right;">Continue Shopping</a>
				<div class="clearfix"></div>
			</div>
			<div class="card-body">
				<!-- PRODUCT -->
				<c:forEach items="${LIST_PRODUCT_CART}" var="product">

					<div class="row">
						<div class="col-12 col-sm-12 col-md-2 text-center">
							<img class="img-responsive" src="${product.img}" alt="prewiew"
								width="120" height="80">
						</div>
						<div class="col-12 text-sm-center col-sm-12 text-md-left col-md-6">
							<h4 class="product-name">
								<strong>${product.name}</strong>
							</h4>
							<h4>
								<small>${product.description}</small>
							</h4>
						</div>
						<div
							class="col-12 col-sm-12 text-sm-center col-md-4 text-md-right row">
							<div class="col-3 col-sm-3 col-md-6 text-md-right"
								style="padding-top: 5px">
								<h6>
									<strong>${product.price}<span class="text-muted">$</span></strong>
								</h6>
							</div>

							<div class="col-2 col-sm-2 col-md-2 text-right">
								<form action="/delete-product" method="GET">
									<input type="hidden" value="${product.id}" name="idProduct">
									<input type="submit" class="btn btn-outline-danger btn-xs"
										value="Delete">
								</form>
							</div>
						</div>
					</div>
					<hr>
				</c:forEach>
			</div>


			<div class="card-footer">
				<div class="coupon col-md-5 col-sm-5 no-padding-left pull-left">
					<div class="row">
						<form action="/cart/use-code" method="GET">
							<div class="col-6">
								<input type="text" class="form-control"
									placeholder="Discount Code" name="code">
							</div><br>
							<div class="col-6">
								<input type="submit" class="btn btn-dark"
									value="Use Code">
							</div>
						</form>
					</div>
				</div>
			
				<div class="pull-right" style="margin: 20px">
					<a href="/pay" class="btn btn-success pull-right">Pay</a>
					<div class="pull-right" style="margin: 5px">
						Total price: <b>${TOTAL_PRICE} $</b>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>