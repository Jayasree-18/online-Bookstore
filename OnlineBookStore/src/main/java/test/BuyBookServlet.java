package test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/buy")
public class BuyBookServlet extends HttpServlet {
	@SuppressWarnings("unchecked")
	@Override
	protected void doGet(HttpServletRequest req,HttpServletResponse res)
	throws ServletException,IOException{
		HttpSession hs = req.getSession();
		if(hs==null) {
			req.setAttribute("msg", "Session Expired..<br>");
			req.getRequestDispatcher("Home.jsp").forward(req, res);			
		}else {
			String bCode = req.getParameter("bcode");
			ArrayList<BookBean> al = (ArrayList<BookBean>)hs.getAttribute("alist");
			Iterator<BookBean> it = al.iterator();
			BookBean bb = null;
			while(it.hasNext()) {
				bb = it.next();
				if(bCode.equals(bb.getCode())) {
					break;
				}
			}
			req.setAttribute("bbean", bb);
			req.getRequestDispatcher("BuyBook.jsp").forward(req, res);
		}
	}
}
