package com.asm3.mobie.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.asm3.mobie.dao.OrderDAO;
import com.asm3.mobie.dao.ProductDAO;
import com.asm3.mobie.dao.UserDAO;
import com.asm3.mobie.model.Order;
import com.asm3.mobie.model.Product;

@Controller
public class OperationController {

	@GetMapping(value = "/login")
	private String login() {
		return "form";
	}
	

	@PostMapping(value = "/login")
	private String submitFormLogin(HttpServletRequest request, Model model, HttpSession session) throws SQLException {
		String account = request.getParameter("account");
		String password = request.getParameter("password");
		if (UserDAO.checkAccount(account, password)) {
			session.setAttribute("userMail", account);// Lưu giá trị User Mail để sau này sử dụng
			model.addAttribute("BODY", "body.jsp");
			model.addAttribute("LIST_PRODUCT",session.getAttribute("ListProduct"));
			model.addAttribute("LOGIN", "Log Out");
			return "home";
		} else {
			model.addAttribute("MESSAGE", "Wrong Account Or Password !!!");
			return "form";
		}
	}
	
	@PostMapping(value = "/create-account")
	private String createAccount(HttpServletRequest request, Model model, HttpSession session) throws SQLException {
		String account = request.getParameter("accountRegis");
		String password = request.getParameter("passwordRegis");
		String name = request.getParameter("nameRegis");
		String address = request.getParameter("addressRegis");
		String phone = request.getParameter("phoneRegis");
		UserDAO.registerForAccount(account, password, name, address, phone);

		model.addAttribute("LOGIN", "Sign In");
		model.addAttribute("LIST_PRODUCT", session.getAttribute("ListProduct"));
		model.addAttribute("BODY", "body.jsp");// chọn body.jsp là phần thân của web
		return "home";
	}

	@GetMapping(value = "/search")
	private String searchProduct(HttpServletRequest request, Model model) {
		String searchKey = request.getParameter("searchKey");
		ArrayList<Product> listProduct = ProductDAO.searchListProduct(searchKey.toLowerCase());
		if (listProduct.size() == 0) {
			model.addAttribute("BODY", "body.jsp");
			model.addAttribute("MESSAGE", "NOT FOUND ,Please Search Again !!!!!");//Neu khong co san pham thong bao loi
		} else {
			model.addAttribute("BODY", "body.jsp");
			model.addAttribute("LIST_PRODUCT", listProduct);
		}
		return "home";
	}

	@GetMapping(value = "/detail-product/{idProduct}")
	private String detailProduct(@PathVariable("idProduct") int idProduct, HttpServletRequest request, Model model)
			throws SQLException {
		model.addAttribute("product", ProductDAO.getProductById(idProduct));
		model.addAttribute("BODY", "detail-product.jsp");//chọn detail-product.jsp là phần thân của trang home.jsp
		return "home";
	}

	@GetMapping(value = "/buy/{idProduct}")
	private String saveToShoppingCarts(@PathVariable("idProduct") int idProduct, Model model, HttpSession session)
			throws SQLException {
		if(session.getAttribute("userMail")==null) {
			model.addAttribute("MESSAGE","Please Login");
			return "form";
		}
		else {
		OrderDAO.insetProductToCart(idProduct, session.getAttribute("userMail").toString());
		model.addAttribute("BODY", "body.jsp");
		model.addAttribute("LIST_PRODUCT", session.getAttribute("ListProduct"));
		model.addAttribute("LOGIN", "Log Out");
		return "home";
		}
	}

	@GetMapping(value = "/my-cart")
	private String goToMyCart(Model model, HttpSession session) throws SQLException {
		if(session.getAttribute("userMail")==null) {
			
			model.addAttribute("MESSAGE","Please Login");
			return "form";
		}else {
			
		float totalPrice = 0;//Tổng giá sản phẩm trong giỏ hàng , Tổng hợp nhiều order_id theo usermail là giỏ hàng
		
		ArrayList<Order> arrOrder = OrderDAO.getOrderOfEmail(session.getAttribute("userMail").toString());
		ArrayList<Product> arrProduct = OrderDAO.getProductInCart(arrOrder);//arrOrder chứa order_id dựa vào đó lấy ra danh sách phẩm ở Order_detail
		
		for (Product p : OrderDAO.getProductInCart(arrOrder)) {//Tính tổng giá
			totalPrice += p.getPrice();
		}

		model.addAttribute("LIST_PRODUCT_CART", arrProduct);
		model.addAttribute("TOTAL_PRICE", totalPrice);
		return "my-cart";
		}
	}

	@GetMapping(value = "/delete-product")
	private String deleteProductCart(HttpServletRequest request, Model model, HttpSession session) throws SQLException {
		float totalPrice = 0;//Xóa xong phải tính giá lại 
		int idProductDelete = Integer.parseInt(request.getParameter("idProduct"));//lấy id product bị xóa
		
		ArrayList<Order> arrOrder = OrderDAO.getOrderOfEmail(session.getAttribute("userMail").toString());//lấy danh sách đơn hàng của user đó
		
		//Tìm trong danh sách đơn hàng xem trùng vs ID sản phẩm bị xóa => tiến hành xóa
		OrderDAO.deleteProductInCart(OrderDAO.findOrderIdDelete(arrOrder, idProductDelete), idProductDelete);
		
		//cập nhật tổng giá và update lại danh sách trong giỏ hàng
		arrOrder = OrderDAO.getOrderOfEmail((session.getAttribute("userMail").toString()));
		for (Product p : OrderDAO.getProductInCart(arrOrder)) {//cập nhật tổng giá 
			totalPrice += p.getPrice();
		}
		model.addAttribute("LIST_PRODUCT_CART", OrderDAO.getProductInCart(arrOrder));
		model.addAttribute("LIST_ORDER", arrOrder);
		model.addAttribute("TOTAL_PRICE", totalPrice);
		return "my-cart";
	}
	
	// hàm sử dụng code để giảm giá , nếu code là TRUONGDUY thì sale 50% 
	@GetMapping(value = "/cart/use-code")
	private String delete(HttpServletRequest request, Model model, HttpSession session) throws SQLException {
		//Tiến hành lấy danh sách và tính tổng giá lại sau đó dùng model đẩy lên nhưng /2
		float totalPrice = 0;
		ArrayList<Order> arrOrder = OrderDAO.getOrderOfEmail(session.getAttribute("userMail").toString());
		arrOrder = OrderDAO.getOrderOfEmail(session.getAttribute("userMail").toString());
		for (Product p : OrderDAO.getProductInCart(arrOrder)) {
			totalPrice += p.getPrice();
		}
		//Lấy code và so sánh nếu đúng giá /2
		String code = request.getParameter("code");
		if (code.equals("TRUONGDUY")) {
			model.addAttribute("TOTAL_PRICE", totalPrice / 2);
		} else
			model.addAttribute("TOTAL_PRICE", totalPrice);
		
		model.addAttribute("LIST_PRODUCT_CART", OrderDAO.getProductInCart(arrOrder));
		return "my-cart";
	}
	
	@GetMapping(value = "/pay")
		private String pay(Model model,HttpSession session) throws SQLException {
			model.addAttribute("MESSAGE","Mua Thành Công");
			model.addAttribute("LOGIN", "Log Out");
			
			model.addAttribute("LIST_PRODUCT", session.getAttribute("ListProduct"));
			model.addAttribute("BODY", "body.jsp");//chọn body.jsp là phần thân của web
			ArrayList<Order> arrOrder = OrderDAO.getOrderOfEmail(session.getAttribute("userMail").toString());
			ArrayList<Integer> arrIdProductDelete = OrderDAO.getIdProductInCart(session.getAttribute("userMail").toString());
			for(int i=0;i<arrIdProductDelete.size();i++) {
				OrderDAO.deleteProductInCart(OrderDAO.findOrderIdDelete(arrOrder, arrIdProductDelete.get(i)), arrIdProductDelete.get(i));
			}
			
			return "home";
	}

}
