package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.entity.ToDoTask;
import com.helper.FactoryProvider;

/**
 * Servlet implementation class ServletNoteSave
 */
public class ServletNoteSave extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletNoteSave() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = null;
		try {
			out = response.getWriter();
			response.setContentType("text/html");
			// tile, content
			String title = request.getParameter("title");
			String content = request.getParameter("content");

			ToDoTask note = new ToDoTask(title, content, new Date());
			Session session = FactoryProvider.getFactory().openSession();

			Transaction trx = session.beginTransaction();
			session.save(note);
			trx.commit();
			session.close();
			out.print("<body style='background-color:#bada55;'></body>");
			out.print("<div style='display: flex; flex-direction: column; justify-content: center; align-items: center; height: 100vh;'>");
			out.print("<h1 style='text-align:center; color:white;'>Note Added Successfully</h1>");
			out.print("<h2 style='text-align:center;'><a href='all_notes.jsp'>View All Notes</a></h2>");
out.print("</div>");
		} catch (Exception e) {
			out.print(e);
			e.printStackTrace();

		}
	}

}
