package test;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/creg")
public class CustomerRegServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req,HttpServletResponse res)
	throws ServletException,IOException{
		CustomerBean cb = new CustomerBean();
		cb.setuName(req.getParameter("uname"));
		cb.setpWord(req.getParameter("pword"));
		cb.setfName(req.getParameter("fname"));
		cb.setlName(req.getParameter("lname"));
		cb.setAddr(req.getParameter("addr"));
		cb.setmId(req.getParameter("mid"));
		cb.setPhNo(Long.parseLong(req.getParameter("phno")));
		int k = new CustRegisterDAO().register(cb);
		if(k>0) {
			req.setAttribute("msg", "Customer Registered Succesfully..<br>");
			RequestDispatcher rd = req.getRequestDispatcher("CustRegister.jsp");
			rd.forward(req, res);
		}
	}
}
