package eshop;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import eshop.model.DataManager;

@WebServlet(name = "ShopServlet", urlPatterns = {"/shop/*"})
public class ShopServlet extends javax.servlet.http.HttpServlet
    implements javax.servlet.Servlet {
  private static final long serialVersionUID = 1L;

  public ShopServlet() {
    super();
    }

  public void init(ServletConfig config) throws ServletException {
    System.out.println("*** initializing controller servlet.");
    super.init(config);

    DataManager dataManager = new DataManager();
    
    String dburl = config.getInitParameter("dbURL");
    String dbuser = config.getInitParameter("dbUserName");
    String dbpass = config.getInitParameter("dbPassword");
    
    dataManager.setDbURL(dburl);
    dataManager.setDbUserName(dbuser);
    dataManager.setDbPassword(dbpass);

    ServletContext context = config.getServletContext();
    context.setAttribute("base", config.getInitParameter("base"));
    context.setAttribute("imageURL", config.getInitParameter("imageURL"));
    context.setAttribute("dataManager", dataManager);

    try {  // load the database JDBC driver
      Class.forName("com.mysql.cj.jdbc.Driver");
      }
    catch (ClassNotFoundException e) {
      System.out.println(e.toString());
      }
   }

  protected void doGet(HttpServletRequest request,
      HttpServletResponse response) throws ServletException, IOException {
    doPost(request, response);
    }

  protected void doPost(HttpServletRequest request,
      HttpServletResponse response) throws ServletException, IOException {
    String base = "/jsp/";
    String url = base + "index.jsp";
    String action = request.getParameter("action");
    if (action != null) {
        switch (action) {
        case "search":
          url = base + "SearchOutcome.jsp";
          break;
        case "selectCatalog":
          url = base + "SelectCatalog.jsp";
          break;
        case "bookDetails":
          url = base + "BookDetails.jsp";
          break;
        case "checkOut":
          url = base + "Checkout.jsp";
          break;
        case "orderConfirmation":
          url = base + "OrderConfirmation.jsp";
          break;
        default:
          if (action.matches("(showCart|(add|update|delete)Item)"))
            url = base + "ShoppingCart.jsp";
          break;
        }
      }
    RequestDispatcher requestDispatcher =
      getServletContext().getRequestDispatcher(url);
    requestDispatcher.forward(request, response);
    }
  }
