package mceletronics.dao;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import mceletronics.entities.Product;
import mceletronics.util.Db;




public class ProductDAO {
	private static  Connection connection  = Db.getConnection();
	
	
	public static Product addProduct(String name, String category, Double price, Integer quantity, String description,InputStream input) {
		try {
			PreparedStatement pStmt = connection.prepareStatement("insert into products(name, category, price, quantity, description) values (?, ?,?, ?, ?)",
					Statement.RETURN_GENERATED_KEYS);
			pStmt.setString(1, name);
			pStmt.setString(2, category);
			pStmt.setDouble(3, price);
			pStmt.setInt(4, quantity);
			pStmt.setString(5, description);
			
			pStmt.executeUpdate();
			ResultSet rs = pStmt.getGeneratedKeys();
			if (rs.next()) {
				uploadFile(input, rs.getInt("id") );
				new Product(rs.getInt("id"), rs.getString("name"), rs.getString("category"),rs.getDouble("price"),rs.getInt("quantity"), rs.getString("description"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}
	public static Product updateProduct(int id, String name, String category, Double price, Integer quantity, String description, InputStream input) {
		try {
			PreparedStatement pStmt = connection.prepareStatement("update products set name=?, category=?, price=?, quantity=?, description=? where id=?",
					Statement.RETURN_GENERATED_KEYS);
			pStmt.setString(1, name);
			pStmt.setString(2, category);
			pStmt.setDouble(3, price);
			pStmt.setInt(4, quantity);
			pStmt.setString(5, description);
			pStmt.setInt(6, id);
			pStmt.executeUpdate();
			ResultSet rs = pStmt.getGeneratedKeys();
			if (rs.next()) {
				if(input != null)
					uploadFile(input, rs.getInt("id"));
				new Product(rs.getInt("id"), rs.getString("name"), rs.getString("category"),rs.getDouble("price"),rs.getInt("quantity"), rs.getString("description"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}
	private static void uploadFile(InputStream uploadedInputStream, int id) {
		try {
			InputStream inputStream = Db.class.getClassLoader().getResourceAsStream("upload.properties");
			Properties prop = new Properties();
			prop.load(inputStream);
			String folder = prop.getProperty("folder");
			String filePath = folder + (id+".png");
			saveFile(uploadedInputStream, filePath);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private static void saveFile(InputStream uploadedInputStream, String serverLocation) {

		try {
			OutputStream outpuStream = new FileOutputStream(new File(serverLocation));
			int read = 0;
			byte[] bytes = new byte[1024];

			outpuStream = new FileOutputStream(new File(serverLocation));
			while ((read = uploadedInputStream.read(bytes)) != -1) {
				outpuStream.write(bytes, 0, read);
			}
			outpuStream.flush();
			outpuStream.close();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}
	
	public static Product getProductByName(String name) {
		try {
			PreparedStatement pStmt = connection.prepareStatement("select * from products where name=?");
			pStmt.setString(1, name);
			ResultSet rs = pStmt.executeQuery();
			if (rs.next()) {
				new Product(rs.getInt("id"), rs.getString("name"), rs.getString("category"),rs.getDouble("price"),rs.getInt("quantity"), rs.getString("description"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}
	public static Product getProduct(int id) {
		try {
			PreparedStatement pStmt = connection.prepareStatement("select * from products where id=?");
			pStmt.setInt(1, id);
			ResultSet rs = pStmt.executeQuery();
			if (rs.next()) {
				return new Product(rs.getInt("id"), rs.getString("name"), rs.getString("category"),rs.getDouble("price"),rs.getInt("quantity"),rs.getString("description"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}
	public static void deleteProduct(int id) {
		try {
			PreparedStatement pStmt = connection.prepareStatement("delete from products where id=?");
			pStmt.setInt(1, id);
			pStmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static List<Product> getAllProducts() {
		List<Product> products = new ArrayList<Product>();
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("select * from products order by id");
			while (rs.next()) {
				Product product =  new Product(rs.getInt("id"), rs.getString("name"), rs.getString("category"),rs.getDouble("price"),rs.getInt("quantity"),rs.getString("description"));
				products.add(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return products;
	}
	
	
}
