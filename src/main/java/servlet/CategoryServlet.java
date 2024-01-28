package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import controller.CategoryController;
import dao.Category;

@WebServlet(urlPatterns = "/category")
public class CategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
			String categoryName=request.getParameter("name");		
			
			CategoryController.addCategory(categoryName);
			response.sendRedirect("/blog/categoryadd.jsp");
		
		
		
		
	}

}
