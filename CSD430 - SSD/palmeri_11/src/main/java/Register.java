

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import palmeri_11.DatabaseManager;
import palmeri_11.User;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
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
		ArrayList<String> submitData = new ArrayList<String>();
		submitData.add(request.getParameter("username"));
		submitData.add(request.getParameter("password"));
		submitData.add(request.getParameter("email"));
		submitData.add(request.getParameter("phone"));
		submitData.add(request.getParameter("firstname"));
		submitData.add(request.getParameter("lastname"));
		submitData.add(request.getParameter("homeaddress"));
		submitData.add(request.getParameter("state"));
		submitData.add(request.getParameter("color"));
		
		User newUser = new User(submitData.get(0), submitData.get(1), submitData.get(2), submitData.get(3), submitData.get(4), submitData.get(5), submitData.get(6), submitData.get(7), submitData.get(8));
		
		DatabaseManager dbm = new DatabaseManager();
		String userResponse = dbm.createUser(newUser);
		
		System.out.println(userResponse);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/");
		dispatcher.forward(request, response);
		
		doGet(request, response);
	}

}
