package com.servlets;

import java.io.IOException;
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
 * Servlet implementation class UpdateServlet
 */
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {

			String title = request.getParameter("title");
			String content = request.getParameter("content");
			int noteId = Integer.parseInt(request.getParameter("noteId").trim());
			Session s = FactoryProvider.getFactory().openSession();
			Transaction trx = s.beginTransaction();
			ToDoTask toDo = (ToDoTask) s.get(ToDoTask.class, noteId);

			toDo.setTitle(title);
			toDo.setContent(content);
			//toDo.setDate(new Date());

			trx.commit();
			s.close();
			response.sendRedirect("all_notes.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
