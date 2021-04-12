package com.asm3.mobie.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.asm3.mobie.connection.MyConnection;
import com.asm3.mobie.model.Product;

public class ProductDAO {
	static Connection connect = MyConnection.connect();

	// Lay toan bo danh sach product
	public static ArrayList<Product> listProduct() {
		ArrayList<Product> arrResult = new ArrayList<Product>();
		Product product;
		String sql = "SELECT * FROM Products";
		try {
			Statement stmt = (Statement) connect.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				product = new Product();
				product.setId(rs.getInt("product_id"));
				product.setName(rs.getString("product_name"));
				product.setDescription(rs.getString("product_des"));
				product.setPrice(rs.getFloat("product_price"));
				product.setImg(rs.getString("product_img_source"));
				product.setType(rs.getString("product_type"));
				product.setBrand(rs.getString("product_brand"));
				arrResult.add(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return arrResult;
	}

	// Lay danh sach product theo tu khoa tim kiem
	public static ArrayList<Product> searchListProduct(String keySearch) {
		ArrayList<Product> arrResult = new ArrayList<Product>();
		Product product;
		String sql = "SELECT * FROM Products P WHERE P.product_name LIKE '%" + keySearch + "%'";//tim san pham co ten co chua tu khoa tim kiem
		try {
			Statement stmt = (Statement) connect.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				product = new Product();
				product.setId(rs.getInt("product_id"));
				product.setName(rs.getString("product_name"));
				product.setDescription(rs.getString("product_des"));
				product.setPrice(rs.getFloat("product_price"));
				product.setImg(rs.getString("product_img_source"));
				product.setType(rs.getString("product_type"));
				product.setBrand(rs.getString("product_brand"));
				arrResult.add(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return arrResult;
	}

	//Hàm lấy sản phẩm để show tất cả thông tin
	public static Product getProductById(int id) throws SQLException {
		Product product = new Product();
		String sql = "SELECT * FROM Products P Where P.product_id = " + id;
		Statement stm = connect.createStatement();
		ResultSet rs = stm.executeQuery(sql);
		while (rs.next()) {
			product = new Product();
			product.setId(rs.getInt("product_id"));
			product.setName(rs.getString("product_name"));
			product.setDescription(rs.getString("product_des"));
			product.setPrice(rs.getFloat("product_price"));
			product.setImg(rs.getString("product_img_source"));
			product.setType(rs.getString("product_type"));
			product.setBrand(rs.getString("product_brand"));
		}
		return product;
	}

	public static ArrayList<Product> convertIdToProduct(ArrayList<Integer> arrInput) throws SQLException {
		ArrayList<Product> arrProduct = new ArrayList<Product>();
		Product product;
		ResultSet rs;
		Statement stm = connect.createStatement();
		String sql = "SELECT * FROM Products P WHERE P.product_id =";
		for (int i = 0; i < arrInput.size(); i++) {
			sql += arrInput.get(i);
			rs = stm.executeQuery(sql);

			while (rs.next()) {
				product = new Product();
				product = new Product();
				product.setId(rs.getInt("product_id"));
				product.setName(rs.getString("product_name"));
				product.setDescription(rs.getString("product_des"));
				product.setPrice(rs.getFloat("product_price"));
				product.setImg(rs.getString("product_img_source"));
				product.setType(rs.getString("product_type"));
				product.setBrand(rs.getString("product_brand"));
				arrProduct.add(product);
			}
			sql = "SELECT * FROM Products P WHERE P.product_id =";
		}
		return arrProduct;

	}
}
