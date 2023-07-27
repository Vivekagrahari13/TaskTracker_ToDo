package com.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.entity.ToDoTask;
import com.helper.FactoryProvider;

/**
 * Servlet implementation class DeleteServ
 */
public class DeleteServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteServ() {
		super();
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			int noteId = Integer.parseInt(request.getParameter("note_id").trim());
			Session session = FactoryProvider.getFactory().openSession();
			Transaction trx = session.beginTransaction();
			ToDoTask toDo = (ToDoTask) session.get(ToDoTask.class, noteId);
			if (toDo != null) {
				session.delete(toDo);
				trx.commit();
			}
			response.sendRedirect("all_notes.jsp");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
