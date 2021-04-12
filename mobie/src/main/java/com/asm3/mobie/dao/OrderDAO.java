package com.asm3.mobie.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.asm3.mobie.connection.MyConnection;
import com.asm3.mobie.model.Order;
import com.asm3.mobie.model.Product;

public class OrderDAO {
	static Connection connect = MyConnection.connect();
	
	//Hàm insert vào giỏ hàng dùng product ID và User Mail
	public static void insetProductToCart(int productId, String userMail) throws SQLException {
		int newOrderId = -1;
		String sql = "INSERT INTO Orders VALUES('" + userMail + "'," + 0 + ",'" + java.time.LocalDate.now() + "',' ','"
				+ UserDAO.getUserByemail(userMail).getAddress() + "')";
		
		//Ta phải insert vào 2 bảng là Orders và Orders_detail nên phải lấy dc Order_id tại thời điểm insert
		PreparedStatement pstm = connect.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);//Dùng để Lấy Order_ID 
		pstm.execute();
		ResultSet rs = pstm.getGeneratedKeys();
		if (rs.next()) {
			newOrderId = rs.getInt(1);
		}
		sql = "INSERT INTO Orders_detail VALUES(" + newOrderId + "," + productId + ",1,"
				+ ProductDAO.getProductById(productId).getPrice() + ")";
		Statement stm = connect.createStatement();
		stm.executeUpdate(sql);
	}

	public static ArrayList<Integer> getIdProductInCart(String email) {
		ArrayList<Integer> arrResult = new ArrayList<Integer>();
		String sql = "SELECT OD.product_id FROM Orders O INNER JOIN Orders_detail OD ON O.user_mail ='" + email
				+ "' AND O.order_id = OD.order_id";
		try {
			Statement stm = connect.createStatement();
			ResultSet rs = stm.executeQuery(sql);

			while (rs.next()) {
				arrResult.add(rs.getInt("product_id"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return arrResult;
	}
	
	//Hàm lấy giỏ hàng của Khách hạn cụ thể dựa vào user mail
	public static ArrayList<Order> getOrderOfEmail(String email) throws SQLException {
		ArrayList<Order> arrResult = new ArrayList<Order>();
		Order order;
		String sql = "SELECT OD.product_id,O.order_id,O.order_status FROM Orders O INNER JOIN Orders_detail OD ON O.user_mail = '" 
		+ email + "' AND O.order_id = OD.order_id";
		Statement stm = connect.createStatement();

		ResultSet rs = stm.executeQuery(sql);
		while (rs.next()) {
			order = new Order();
			order.setIdOrder(rs.getInt("order_id"));
			order.setOrderStatus(rs.getInt("order_status"));
			order.setIdProduct(rs.getInt("product_id"));
			arrResult.add(order);
		}
		return arrResult;
	}

	public static ArrayList<Product> getProductInCart(ArrayList<Order> arrInput) throws SQLException {
		ArrayList<Integer> arrIdProduct = new ArrayList<Integer>();
		ResultSet rs;
		String sql = "SELECT OD.product_id FROM Orders_detail OD WHERE OD.order_id = ";
		Statement stm = connect.createStatement();
		for (int i = 0; i < arrInput.size(); i++) {
			sql += arrInput.get(i).getIdOrder();
			rs = stm.executeQuery(sql);
			while (rs.next()) {
				arrIdProduct.add(rs.getInt("product_id"));
			}
			sql = "SELECT * FROM Orders_detail OD WHERE OD.order_id = ";
		}
		return ProductDAO.convertIdToProduct(arrIdProduct);
	}
	
	//Tìm trong danh sách order , trả về orderID có chứa sản phẩm bị xóa
	public static Integer findOrderIdDelete(ArrayList<Order> arrInput, int idProductDelete) {
		Integer result = -1;
		for (int i = 0; i < arrInput.size(); i++) {
			if (arrInput.get(i).getIdProduct() == idProductDelete) {
				result = arrInput.get(i).getIdOrder();
			}
		}
		return result;
	}
	
	//Xóa Order_detail dựa vào id order và id product , xóa ở Order dựa vào id_order 
	public static void deleteProductInCart(int idOrder,int idProduct) throws SQLException {
		String sql1 ="DELETE FROM Orders_detail  WHERE order_id ="+idOrder +" AND product_id = "+idProduct;
		String sql2 = "DELETE FROM Orders  WHERE order_id = "+idOrder;
		Statement stm = connect.createStatement();
		stm.executeUpdate(sql1);
		stm.executeUpdate(sql2);
	}

}
