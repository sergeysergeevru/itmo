package com;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class TestServlet extends HttpServlet implements Servlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/plain");
		double  a=Double.parseDouble(req.getParameter("A")),
				b=Double.parseDouble(req.getParameter("B")),
				c=Double.parseDouble(req.getParameter("C"));
		double d=b*b-4*a*c;
		if((d>=0) && (a!=0))
		{
			resp.getWriter().print("x1="+(-b+Math.sqrt(d))/2/a+" "+("x1="+(-b-Math.sqrt(d))/2/a));
		}
		else
		{
			resp.getWriter().print("-");
		}
	}

}
