

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import palmeri_11.DatabaseManager;
import palmeri_11.User;

/**
 * Servlet implementation class GetNotepad
 */
@WebServlet("/GetNotepad")
public class GetNotepad extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetNotepad() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DatabaseManager dbm = new DatabaseManager();
		HttpSession session = request.getSession();
		User loggedIn = (User)session.getAttribute("LoggedIn");
		
		try {
			String notepad = dbm.getNotepad(loggedIn);
			if(notepad != null) {
				session.setAttribute("Notepad", notepad);
				PrintWriter out = response.getWriter();
				response.setContentType("application/json");
				Gson gson = new Gson();
				JsonObject myObj = new JsonObject();
				
				JsonElement sendNote = gson.toJsonTree(notepad);
				myObj.addProperty("success", true);
				myObj.add("notepad", sendNote);
				out.println(myObj.toString());
				out.close();
			} else {
				String message = "Could not get Notepad";
				response.sendError(500, message);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		
		doGet(request, response);
	}

}
