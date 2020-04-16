package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginFilter implements Filter{

	@Override
	public void destroy() {		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest rs = (HttpServletRequest) request;
		HttpServletResponse rsp = (HttpServletResponse) response;
		String uri =  rs.getRequestURI();
		if(uri.contains("login")) {
			chain.doFilter(request, response);
			return;
		}
		HttpSession session = rs.getSession();
		String user = (String) session.getAttribute("user");
		if(user==null) {
			rsp.sendRedirect("login.jsp");
		}else {
			chain.doFilter(rs, rsp);
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
