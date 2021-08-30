package kr.or.connect.todo.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.connect.todo.dao.TodoDao;
import kr.or.connect.todo.dto.TodoDto;

@WebServlet("/add")
public class TodoAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public TodoAddServlet() {
        super();
    }    
    
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8"); // submit에서 post방식으로 요청할 경우 받을때 이 코드를 추가해야 utf-8로 인코딩 하여 받을 수 있다.
		
		String todo = request.getParameter("todo"); // submit으로 전달된 값은 getParameter로 받는다.
		String name = request.getParameter("name");
		int sequence = Integer.parseInt(request.getParameter("sequence"));
		
		TodoDto todoDto = new TodoDto(name, todo, sequence);
		TodoDao todoDao = new TodoDao();
		
		todoDao.addTodo(todoDto);
		response.sendRedirect("http://localhost:8000/main");
	}

}
