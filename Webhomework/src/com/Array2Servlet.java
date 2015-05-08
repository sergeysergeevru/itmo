package com;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class Array2Servlet extends HttpServlet implements Servlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/plain");
		int[][] mas = new int[5][8];
		resp.getWriter().print("<br>");
		int max = -99;
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 8; j++) {
				mas[i][j] = Math.round(10 + (int) (Math.random() * 89));
				if (max < mas[i][j])
					max = mas[i][j];
				resp.getWriter().print(mas[i][j] + " ");
			}
			resp.getWriter().println("<br>");// Max="+max

		}
		resp.getWriter().println("<br>Max="+max);// 

	}

}
