package kanban;

public class KanbanEntryDone {
	String toDoName;
	String message;
	String location; 
	Integer id;
	Integer priority;
	
	public KanbanEntryDone(Integer id,String toDoName,String message, String location,Integer priority) {
		super();
		this.toDoName = toDoName;
		this.message = message;
		this.location = location;
		this.id = id;
		this.priority = priority;
	}
	public String getToDoName() {
		return toDoName;
	}
	public void setToDoName(String toDoName) {
		this.toDoName = toDoName;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getPriority() {
		return priority;
	}
	public void setPriority(Integer priority) {
		this.priority = priority;
	}
}
