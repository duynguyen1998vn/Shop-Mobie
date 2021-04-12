<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
</head>
<body>
<div style="background-image:url('https://thuphaplaotroc.files.wordpress.com/2014/03/light-wood-background.jpg');height: 800px">
	<a class="btn btn-dark" href="/home" style="margin:10px 0 0 10px;">Home</a> 
	<div class="container">
		<div class="col" style="margin-top: 10rem;">
			<div class="alert alert-dark" role="alert">Em dùng DB được cung
				cấp</div>
			<div class="alert alert-dark" role="alert">Database Trong Table
				Orders_detail biến price_product mentor sửa kiểu dữ liệu thành float dùm em với ạ, ban đầu là kiểu int sẽ mâu thuẫn vs price trong bảng Product
				</div>
				<div class="alert alert-dark" role="alert">Em dùng session để lưu trữ danh sách sản phẩm , để không cần phải xuống ĐB lấy lại
				 nên phải đi qua trang home thì danh sách sản phẩm mới tồn tại</div>
				<div class="alert alert-dark" role="alert">Em có thêm 1 Số chức năng như : Xóa giỏ hàng,Thanh Toán,Dùng Code giảm giá, 
				nhưng DB hk có Bảng code nên em set cứng , Mentor nhập TRUONGDUY sẽ được sale 50%</div>		
		</div>
	</div>
	<a style="float: right;" href="https://www.facebook.com/truongduy.nguyen.52090/" class="btn btn-primary">Contact Facebook</a>
	</div>
</body>
</html>