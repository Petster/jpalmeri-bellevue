package palmeri_11;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;
import palmeri_11.DatabaseManager;

public class DatabaseManager {

	private String dbURL = "jdbc:mysql://localhost:3306";
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
		
		String sql = "INSERT INTO `mod11`.`users` (username, password, email, phone, firstname, lastname, homeaddress, state, color) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		String message = "";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2,  user.getPassword());
			ps.setString(3,  user.getEmail());
			ps.setString(4,  user.getPhone());
			ps.setString(5, user.getFirstname());
			ps.setString(6, user.getLastname());
			ps.setString(7,  user.getHome());
			ps.setString(8,  user.getState());
			ps.setString(9,  user.getColor());
			int rowsAffected = ps.executeUpdate();
			
			User createNotepad = loginUser(user.getUsername(), user.getPassword());
			sql = "INSERT INTO `mod11`.`notepad` (user_id, notepad) VALUES (?, ?)";
			PreparedStatement nps = conn.prepareStatement(sql);
			nps.setInt(1, createNotepad.getId());
			nps.setString(2, "Hello World!");
			int rowsAffectedd = nps.executeUpdate();
			
		} catch(SQLIntegrityConstraintViolationException e) {
			message = "Failed to create user: Username already exists";
			return message;
		} catch (SQLException e) {
			System.out.println("N" + e);
		}
		message = "User creation successful";
		return message;
	}
	
	public User loginUser(String username, String password) {
		loadDriver(dbDriver);
		Connection conn = getConnection();
		String sql = "SELECT * FROM `mod11`.`users` WHERE username='"+username+"' AND password='"+password+"'";
		User loggedIn = new User();
		try {
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery(sql);
			if(rs.next()) {
				String testPassword = rs.getString(5).trim();
				if(testPassword.equals(password.trim())) {
					loggedIn.setId(rs.getInt(1));
					loggedIn.setFirstname(rs.getString(2));
					loggedIn.setLastname(rs.getString(3));
					loggedIn.setUsername(rs.getString(4));
					loggedIn.setPassword(rs.getString(5));
					loggedIn.setEmail(rs.getString(6));
					loggedIn.setPhone(rs.getString(7));
					loggedIn.setHome(rs.getString(8));
					loggedIn.setState(rs.getString(9));
					loggedIn.setColor(rs.getString(10));
					loggedIn.setJoindate(rs.getString(11));
					loggedIn.setRole(rs.getString(12));
					loggedIn.setAdmin(rs.getInt(13));
				} else {
					return null;
				}
			} else {
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return loggedIn;		
	}
	
	public String getNotepad(User loggedIn) {
		loadDriver(dbDriver);
		Connection conn = getConnection();
		String sql = "SELECT notepad FROM `mod11`.`notepad` WHERE user_id='"+loggedIn.getId()+"'";
		String notepad = "";
		
		try {
			Statement s = conn.createStatement();
			ResultSet r = s.executeQuery(sql);
			try {
				while(r.next()) {
					notepad = r.getString("notepad");
				}
			} catch (Exception e) {
				System.out.println("E" + e);
			}
		} catch (SQLException e) {
			System.out.println("R" + e);
		}
		
		return notepad;
	}
	
	public void updateNotepad(String newPad, User loggedIn) {
		loadDriver(dbDriver);
		Connection conn = getConnection();
		String sql = "UPDATE `mod11`.`notepad` SET notepad='"+newPad+"' WHERE user_id='"+loggedIn.getId()+"'";
		
		try {
			Statement s = conn.createStatement();
			s.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println("R" + e);
		}
		
	}
	
	public Boolean deleteUser(User loggedIn) {
		loadDriver(dbDriver);
		Connection conn = getConnection();
		Boolean deleted = false;
		String sql = "DELETE FROM `mod11`.`notepad` WHERE user_id='"+loggedIn.getId()+"'";
		
		try {
			Statement s = conn.createStatement();
			s.executeUpdate(sql);
			sql = "DELETE FROM `mod11`.`users` WHERE username='"+loggedIn.getUsername()+"' AND password='"+loggedIn.getPassword()+"'";
			s.executeUpdate(sql);
			deleted = true;
		} catch (SQLException e) {
			System.out.println(e);
		}
		
		return deleted;
	}
	
	public ArrayList<User> getAllUser() {
		ArrayList<User> users = new ArrayList<User>();
		loadDriver(dbDriver);
		Connection conn = getConnection();
		
		String sql = "SELECT * FROM `mod11`.`users`";
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
					user.setPhone(r.getString("phone"));
					user.setJoindate(r.getString("joindate"));
					user.setRole(r.getString("role"));
					user.setAdmin(r.getInt("isAdmin"));
					user.setFirstname(r.getString("firstname"));
					user.setLastname(r.getString("lastname"));
					user.setHome(r.getString("homeaddress"));
					user.setState(r.getString("state"));
					user.setColor(r.getString("color"));
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
