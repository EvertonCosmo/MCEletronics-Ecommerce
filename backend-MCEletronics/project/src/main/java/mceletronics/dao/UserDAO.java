package mceletronics.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import mceletronics.entities.User;
import mceletronics.util.Db;


public class UserDAO {

	private static Connection connection = Db.getConnection();

	public static User addUser( String username, String password) {
		try {
			PreparedStatement pStmt = connection.prepareStatement("insert into users(username, password) values (?, ?)",
					Statement.RETURN_GENERATED_KEYS);
			pStmt.setString(1, username);
			pStmt.setString(2, password);
			pStmt.executeUpdate();
			ResultSet rs = pStmt.getGeneratedKeys();
			
			if (rs.next()) {
				
				return new User(rs.getInt("id"), rs.getString("username"), rs.getString("password"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
//			e.getSQLState();
		}

		return null;
	}

	public static User updateUser(int id, String username, String password) {
		try {
			PreparedStatement pStmt = connection.prepareStatement("update users set username=?, password=? where id=?",
					Statement.RETURN_GENERATED_KEYS);
			pStmt.setString(1, username);
//			pStmt.setString(2, email);
			pStmt.setString(2, password);
			pStmt.setInt(3, id);
			pStmt.executeUpdate();
			ResultSet rs = pStmt.getGeneratedKeys();
			if (rs.next()) {
				
//					uploadFile(input, rs.getInt("id"));
				return new User(rs.getInt("id"), rs.getString("username"), rs.getString("password"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public static void deleteUser(int id) {
		try {
			PreparedStatement pStmt = connection.prepareStatement("delete from users where id=?");
			pStmt.setInt(1, id);
			pStmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static List<User> getAllUsers() {
		List<User> users = new ArrayList<User>();
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("select * from users order by id");
			while (rs.next()) {
				User user = new User(rs.getInt("id"),rs.getString("username"), rs.getString("password"));
				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return users;
	}

	public static User getUser(int id) {
		try {
			PreparedStatement pStmt = connection.prepareStatement("select * from users where id=?");
			pStmt.setInt(1, id);
			ResultSet rs = pStmt.executeQuery();
			if (rs.next()) {
				return new User(rs.getInt("id"),rs.getString("username"),  rs.getString("password"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public static User getUserByUsername(String username) {
		try {
			PreparedStatement pStmt = connection.prepareStatement("select * from users where username=?");
			pStmt.setString(1, username);
			ResultSet rs = pStmt.executeQuery();
			if (rs.next()) {
				return new User(rs.getInt("id"), rs.getString("username"), rs.getString("password"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}


}
