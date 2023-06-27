import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import palmeri_11.DatabaseManager;

/**
 * Servlet implementation class ResetDatabase
 */
@WebServlet("/ResetDatabase")
public class ResetDatabase extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static boolean worked = false;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResetDatabase() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DatabaseManager dbm = new DatabaseManager();
		Connection conn = dbm.getConnection();
		Statement s = null;
		
		
		try {
			s = conn.createStatement();
			
			s.addBatch("DROP DATABASE IF EXISTS mod11");
			s.addBatch("CREATE DATABASE mod11");
			s.addBatch(
				"CREATE TABLE mod11.users" +
					"(id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY," +
					"firstname VARCHAR(70) NOT NULL," +
					"lastname VARCHAR(70) NOT NULL," +
					"username VARCHAR(70) NOT NULL," +
					"password VARCHAR(70) NOT NULL," +
					"email VARCHAR(70) NOT NULL," +
					"phone VARCHAR(15) NOT NULL," +
					"homeaddress VARCHAR(155) NOT NULL," +
					"state VARCHAR(25) NOT NULL," +
					"color VARCHAR(55) NOT NULL," +
					"joindate DATE NOT NULL DEFAULT (CURRENT_DATE)," +
					"role VARCHAR(70) NOT NULL DEFAULT 'Standard'," +
					"isAdmin INTEGER NOT NULL DEFAULT 0," + 
					"UNIQUE (username)" +
				")"
			);
			s.addBatch(
					"CREATE TABLE mod11.notepad" +
						"(id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY," +
						"user_id INTEGER NOT NULL," +
						"notepad LONGTEXT NOT NULL," +
						"FOREIGN KEY (user_id) REFERENCES users(id)" +
					")"
				);
			
			//INSERT SAMPLE DATA
			s.addBatch("INSERT INTO mod11.users (firstname, lastname, username, password, email, phone, homeaddress, state, color, isAdmin) VALUES ('Jason', 'Palmeri', 'JPalmeri', 'dgfmkm4#$%dm11!', 'JPalmeri@gmail.com', '1234567890', '15 Bergundi Lane', 'RI', 'Blue', 1)");
			s.addBatch("INSERT INTO mod11.notepad (user_id, notepad) VALUES (1, 'Hello World!')");
			
			s.executeBatch();
			worked = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		HttpSession session = request.getSession();
		response.setContentType("text/plain");
		if(worked) {
			response.setStatus(200);
			session.invalidate();
		} else {
			String message = "Could not Reset DB";
			response.sendError(500, message);
		}
		
		doGet(request, response);
	}

}
