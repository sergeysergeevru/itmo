package com;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class utfTableServlet extends HttpServlet implements Servlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/plain");
		int start = Integer.parseInt(req.getParameter("start")), finish = Integer
				.parseInt(req.getParameter("finish"));
		if (start < 0 || start > finish || finish < 0 || finish > 65535
				|| start > 65535) {
			resp.getWriter().println("Incorrect input data!");
		} else {
			resp.getWriter().println("<table class=\"table\">");
			int k = 1;
			for (int i = start; i <= finish; i++) {
				k = k % 10;
				if (k == 1)
					resp.getWriter().println("<tr>");
				resp.getWriter().println("<td>" + (char) i + "</td>");
				if (k == 0)
					resp.getWriter().println("</tr>");
				k++;
			}
			resp.getWriter().println("</table>");
		}

	}
}
