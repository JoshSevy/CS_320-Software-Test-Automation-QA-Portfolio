/**
 * Task Class
 */
public class Task {
	private final String taskId;
	private String name;
	private String description;
	
	/**
	 * 
	 * @param taskId
	 * @param name
	 * @param description
	 */
	public Task(String taskId, String name, String description) {
		// Add checks for property conditions
		if (taskId == null || taskId.length() > 10) {
			throw new IllegalArgumentException("ADD UNIQUE ERROR MESSAGE");
		}
		
		if (name == null || name.length() > 20) {
			throw new IllegalArgumentException("ALIGN WITH ERROR MESSAGE BELOW");
		}
		
		if (description == null || description.length() > 50) {
			throw new IllegalArgumentException("ALIGN WITH ERROR MESSAGE BELOW");
		}
		
		
		// Init props
		// taskId required property immutable no longer than 10 characters
		this.taskId = taskId;
		// name no longer than 20 chars non-null
		this.name = name;
		// description no longeer than 50 chars non-null
		this.description = description;
	}
	
	// Getters and Setters
	public String getTaskId() {
		return taskId;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getDescription() {
		return description;
	}
	
	/**
	 * 
	 * @param name
	 */
	public void setName(String name) {
		// Add condition and throw exception (non-null & length < 20)
		if (name == null || name.length() > 20) {
			throw new IllegalArgumentException("TODO: ADD ERROR MESSAGE");
		}
		this.name = name;
	}
	
	/**
	 * 
	 * @param description
	 */
	public void setDescription(String description) {
		if (description == null || description.length() > 50) {
			throw new IllegalArgumentException("TODO: ADD ERROR MESSAGE");
		}
		this.description = description;
	}
}
