package com;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class hexUtfTableServlet extends HttpServlet implements Servlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/plain");
		int start = Integer.parseInt(req.getParameter("start")), finish = Integer
				.parseInt(req.getParameter("finish"));
		if (start < 0 || start > finish || finish < 0 || finish > 65535
				|| start > 65535) {
			resp.getWriter().println("Incorrect input data!");
		} else {
			resp.getWriter().println("<table class=\"table table-bordered\">");
			resp.getWriter().println("<tr><th>Char</th><th>Dec</th><th>hex</th><th>Char</th><th>Dec</th><th>hex</th></tr>");
			int k = 1;
			for (int i = start; i <= finish; i++) {
				k = k % 2;
				if (k == 1)
					resp.getWriter().println("<tr>");
				resp.getWriter().println(
						"<td>" + "" + (char) i + "</td><td> " + i + "</td><td> 0x" + toHex(i)
								+ "</td>");
				if (k == 0)
					resp.getWriter().println("</tr>");
				k++;
			}
			resp.getWriter().println("</table>");
		}

	}

	private String toHex(int x) {
		String res = "", cres = "";
		while (x > 0) {
			res = res + hexChar(x % 16);
			x = x / 16;
		}
		for (int i = res.length() - 1; i >= 0; i--)
			cres = cres + res.charAt(i);
		return cres;
	}

	private char hexChar(int x) {
		char res = '0';
		if (x < 10 && x >= 0)
			res = (char) ((int) res + x);
		if (x < 16 && x >= 10)
			res = (char) ((int) 'A' + x - 10);
		return res;
	}

}
