package kr.or.connect.todo.dto;

public class TodoDto {
	private long id;
	private String name;
	private String regDate;
	private int sequence;
	private String title;
	private String type;
	
	public TodoDto() {
		
	}
	public TodoDto(String name, String title, int sequence) {
		super();
		this.name =	name;
		this.title = title;
		this.sequence = sequence;
	}
	public TodoDto(long id, String title, String name, int sequence, String type, String regDate) {
		super();
		this.id =	id;
		this.title = title;
		this.name =	name;
		this.sequence =	sequence;
		this.type = type;
		this.regDate = regDate;
	}
	public long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getRegDate() {
		return regDate;
	}
	public int getSequence() {
		return sequence;
	}
	public String getTitle() {
		return title;
	}
	public String getType() {
		return type;
	}
	public void setId(long id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public void setSequence(int sequence) {
		this.sequence = sequence;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "TodoDto [id=" + id + ", name=" + name + ", regDate=" + regDate + ", sequence=" + sequence + ", title="
				+ title + ", type=" + type + "]";
	}
}
