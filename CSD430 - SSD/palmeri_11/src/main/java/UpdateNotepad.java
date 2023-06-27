

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import palmeri_11.DatabaseManager;
import palmeri_11.User;

/**
 * Servlet implementation class UpdateNotepad
 */
@WebServlet("/UpdateNotepad")
public class UpdateNotepad extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateNotepad() {
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
		User loggedIn = (User)session.getAttribute("LoggedIn");
		String notepadTextarea = request.getParameter("notepadTextarea");
		Boolean worked = false;
		
		try {
			dbm.updateNotepad(notepadTextarea, loggedIn);
			worked = true;
		} catch (Exception e) {
			System.out.println(e);
		}

		if(worked == true) {
			String message = "Notepad Updated";
			response.sendError(200);
		} else {
			String message = "Could not update Notepad";
			response.sendError(500, message);
		}
		
		doGet(request, response);
	}

}
