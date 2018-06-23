package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.NotesDAO;
import com.domain.Note;

/**
 * Servlet implementation class FindControllerServlet
 */
//@WebServlet("/FindControllerServlet")
public class FindControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Content-type", "text/html;charset=GBK");
		response.setCharacterEncoding("GBK");
		String id_str  = request.getParameter("id");
//		int id = Integer.parseInt(id_str);
		int id = Integer.valueOf(id_str).intValue();
		NotesDAO notesDAO = new NotesDAO();
		Note note = notesDAO.find(id);
		request.setAttribute("note", note);
//		response.sendRedirect("../showList.jsp");每次请求都会重新创建request
		request.getRequestDispatcher("../showList.jsp").forward(request, response);
	}

}
