

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import palmeri_08.DatabaseManager;

/**
 * Servlet implementation class ResetDatabase
 */
@WebServlet("/ResetDatabase")
public class ResetDatabase extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
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
			
			s.addBatch("DROP DATABASE IF EXISTS mod8");
			s.addBatch("CREATE DATABASE mod8");
			s.addBatch(
				"CREATE TABLE mod8.users" +
					"(id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY," +
					"username VARCHAR(70) NOT NULL," +
					"password VARCHAR(70) NOT NULL," +
					"email VARCHAR(70) NOT NULL," +
					"UNIQUE (username)" +
				")"
			);
			
			//INSERT SAMPLE DATA
			s.addBatch("INSERT INTO mod8.users (username, password, email) VALUES ('JPalmeri', 'dgfmkm4#$%dm11!', 'JPalmeri@gmail.com')");
			
			s.executeBatch();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/");
		dispatcher.forward(request, response);
		
		doGet(request, response);
	}

}
