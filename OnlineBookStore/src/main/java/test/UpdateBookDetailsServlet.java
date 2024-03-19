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
@WebServlet("/update")
public class UpdateBookDetailsServlet extends HttpServlet {
	@SuppressWarnings("unchecked")
	@Override
	protected void doPost(HttpServletRequest req,HttpServletResponse res)
	throws ServletException,IOException{
		HttpSession hs = req.getSession();
		if(hs==null) {
			req.setAttribute("msg", "Session Expired..<br>");
			req.getRequestDispatcher("Home.jsp").forward(req, res);
		}else {
			String bCode = req.getParameter("bcode");
			ArrayList<BookBean> al = (ArrayList<BookBean>)hs.getAttribute("alist");
			BookBean bb = null;
			Iterator<BookBean> it = al.iterator();
			while(it.hasNext()) {
				bb=it.next();
				if(bCode.equals(bb.getCode())) {
					break;
				}
			}
			bb.setPrice(Float.parseFloat(req.getParameter("bprice")));
			bb.setQty(Integer.parseInt(req.getParameter("bqty")));
			int k = new UpdateBookDetailsDAO().update(bb);
			if(k>0) {
				req.setAttribute("msg", "Book Details Updated Succesfully..<br>");
				req.getRequestDispatcher("UpdateBookDetails.jsp").forward(req, res);
			}
		}
	}
}
