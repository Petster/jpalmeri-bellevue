package palmeri_08;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;

public class DatabaseManager {

	private String dbURL = "jdbc:mysql://localhost:3333";
	private String dbName = "root";
	private String dbPass = "root";
	private String dbDriver = "com.mysql.cj.jdbc.Driver";
	
	public void loadDriver(String dbDriver) {
		try {
			Class.forName(dbDriver);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() {
		loadDriver(dbDriver);
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(dbURL, dbName, dbPass);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public String createUser(User user) {
		loadDriver(dbDriver);
		Connection conn = getConnection();
		
		String sql = "INSERT INTO `mod8`.`users` (username, password, email) VALUES (?, ?, ?)";
		String message = "";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getEmail());
			int rowsAffected = ps.executeUpdate();
		} catch(SQLIntegrityConstraintViolationException e) {
			message = "Failed to create user: Username already exists";
			return message;
		} catch (SQLException e) {
			System.out.println("N" + e);
		}
		message = "User creation successful";
		return message;
	}
	
	public ArrayList<User> getAllUser() {
		ArrayList<User> users = new ArrayList<User>();
		loadDriver(dbDriver);
		Connection conn = getConnection();
		
		String sql = "SELECT * FROM `mod8`.`users`";
		Statement s;
		try {
			s = conn.createStatement();
			ResultSet r = s.executeQuery(sql);
			try {
				while(r.next()) {
					User user = new User();
					user.setId(r.getInt("id"));
					user.setUsername(r.getString("username"));
					user.setPassword(r.getString("password"));
					user.setEmail(r.getString("email"));
					users.add(user);
				}
			} catch (Exception e) {
				System.out.println("E" + e);
			}
		} catch (SQLException e) {
			System.out.println("R" + e);
		}
		return users;
	}
}
