package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.book;
import service.IUserService;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public LoginServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");  
		IUserService service = new service.impl.UserServiceImpl();
		String uname=request.getParameter("uname");
		String pwd=request.getParameter("pwd");
		HttpSession session=request.getSession();
		if(service.login(uname,pwd)>0) {
			session.setAttribute("user",uname);
			List<book>	list =service.selectAll();
			request.setAttribute("list", list);
	        request.getRequestDispatcher("index.jsp").forward(request, response);
		}else {
			response.sendRedirect("login.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
