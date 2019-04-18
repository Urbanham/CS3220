package toDo;

public class ToDoListEntry implements Comparable<ToDoListEntry> {
	String toDoName;
	Boolean completed; 
	Integer id;
	
	  public Integer getId()
	    {
	        return id;
	    }

	    public void setId( Integer id )
	    {
	        this.id = id;
	    }

	public String getToDoName() {
		return toDoName;
	}

	public Boolean getCompleted() {
		return completed;
	}

	public void setCompleted(Boolean completed) {
		this.completed = completed;
	}

	public void setToDoName(String toDoName) {
		this.toDoName = toDoName;
	
	}

	public ToDoListEntry(Integer id,String toDoName,Boolean completed) {
		super();
		this.toDoName = toDoName;
		this.id = id;
		this.completed = completed;
		
	}

	@Override
	public int compareTo(ToDoListEntry other) {
		
		return toDoName.compareTo(other.toDoName);
	}


	
}
