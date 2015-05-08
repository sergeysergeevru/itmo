package com;

import java.io.IOException;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class Project3Servlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/plain");
		double N=Double.parseDouble(req.getParameter("N")), M=Double.parseDouble(req.getParameter("M"));
		if(Math.abs(N-10)>Math.abs(M-10)){
			resp.getWriter().println(M);
			}
		else{
			resp.getWriter().println(N);
		}
	}
}
