

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import palmeri_11.DatabaseManager;
import palmeri_11.User;

/**
 * Servlet implementation class AllUsers
 */
@WebServlet("/AllUsers")
public class AllUsers extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AllUsers() {
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
		HttpSession session = request.getSession();
		
		ArrayList<User> users = new ArrayList<User>();
		
		try {
			users = dbm.getAllUser();
			if(users != null) {
				session.setAttribute("UserList", users);
			} else {
				String message = "Could not get all Users";
				response.sendError(500, message);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		
		doGet(request, response);
	}

}
