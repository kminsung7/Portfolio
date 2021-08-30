package kr.or.connect.todo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import kr.or.connect.todo.dto.TodoDto;

public class TodoDao {
	private static String dburl="jdbc:mysql://localhost:3306/connectdb?serverTimezone=Asia/Seoul&useSSL=false";
	private static String dbUser="connectuser";
	private static String dbpasswd="connect123!@#";
	
	public int addTodo(TodoDto todoDto) {
		int insertCnt = 0;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String sql = "insert into todo(title, name, sequence) values(?, ?, ?);";
		try(Connection conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
				PreparedStatement ps = conn.prepareStatement(sql);){
			
			ps.setString(1, todoDto.getTitle());
			ps.setString(2, todoDto.getName());
			ps.setInt(3, todoDto.getSequence());
			
			insertCnt = ps.executeUpdate();
		
		}catch (Exception e) {
			e.printStackTrace();
		}
		return insertCnt;
	}
	
	public List<TodoDto> getTodos() {
		List<TodoDto> list = new ArrayList<>();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		String sql = "select id, title, name, sequence, type, date_format(regdate, '%Y-%m-%d') from todo order by regdate;";
		try (Connection conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
				PreparedStatement ps = conn.prepareStatement(sql)) {

			try (ResultSet rs = ps.executeQuery()) {

				while (rs.next()) {
					long id = rs.getLong(1);
					String title = rs.getString(2);
					String name = rs.getString(3);
					int sequence = rs.getInt(4);
					String type = rs.getString(5);
					String regDate = rs.getString(6);
					
					TodoDto todoDto = new TodoDto(id, title, name, sequence, type, regDate);
					list.add(todoDto);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return list;
	}
	
	public int updateTodo (String type, int id) {
		int updateCnt = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String sql = "update todo set type = ?, regdate = now() where id = ?;";//날짜 최신화 리스트 마지막으로 보내기 위해
		try(Connection conn = DriverManager.getConnection(dburl,dbUser,dbpasswd);
				PreparedStatement ps = conn.prepareStatement(sql);){
			
			ps.setString(1, type);
			ps.setLong(2, id);
			
			updateCnt = ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return updateCnt;
	}
}
