package kr.or.connect.todo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.connect.todo.dao.TodoDao;

@WebServlet("/type")
public class TodoTypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TodoTypeServlet() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String beforType = request.getParameter("type");
		String type = "";
		int id = Integer.parseInt(request.getParameter("id"));
		
		if(beforType.equals("TODO")) {
			type = "DOING";
		}else {
			type = "DONE";
		}
		
		TodoDao todoDao = new TodoDao();
		todoDao.updateTodo(type, id);
		
		out.print("success");
	}

}
