package com;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class Array1Servlet extends HttpServlet implements Servlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/plain");
		int[][] mas = new int[8][5];
		resp.getWriter().print("<br>");
		for(int i=0;i<8;i++)
		{
			for(int j=0;j<5;j++)
			{
				mas[i][j] = Math.round(10+(int)(Math.random()*89));
				resp.getWriter().print(mas[i][j]+" ");
			}
			resp.getWriter().println("<br>");
		}
			
	}

}
