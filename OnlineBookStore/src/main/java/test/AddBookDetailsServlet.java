package test;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/add")
public class AddBookDetailsServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req,HttpServletResponse res)
	throws ServletException,IOException{
		HttpSession hs = req.getSession(false);
		if(hs==null) {
			req.setAttribute("msg", "Session Expired...<br>");
			RequestDispatcher rd = req.getRequestDispatcher("Home.jsp");
			rd.forward(req, res);
		}else {
			BookBean bb = new BookBean();
			bb.setCode(req.getParameter("code"));
			bb.setName(req.getParameter("name"));
			bb.setAuthor(req.getParameter("author"));
			bb.setPrice(Float.parseFloat(req.getParameter("price")));
			bb.setQty(Integer.parseInt(req.getParameter("qty")));
			int k = new AddBookDetailsDAO().insert(bb);
			if(k>0) {
				req.setAttribute("msg", "Book Details added Successfully...<br>");
			}
			req.getRequestDispatcher("AddBookDetails.jsp").forward(req, res);
		}
	}
}
