package test;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/custLogin")
public class CustomerLoginServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req,HttpServletResponse res)
	throws ServletException,IOException{
		CustomerBean cb = new CustomerLoginDAO().clogin(req.getParameter("uname"),
									req.getParameter("pword"));
		if(cb==null) {
			req.setAttribute("msg", "Invalid Login Process..<br>");
			req.getRequestDispatcher("Home.jsp").forward(req, res);
		}else {
			HttpSession hs = req.getSession();
			hs.setAttribute("cbean", cb);
			req.getRequestDispatcher("CustomerLogin.jsp").forward(req, res);
		}
	}
}
