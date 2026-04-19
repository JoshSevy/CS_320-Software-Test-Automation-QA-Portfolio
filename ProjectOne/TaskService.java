import java.util.HashMap;
import java.util.Map;

/**
 * TaskService storing Task objects in Map
 */
public class TaskService {
	/**
	 * Using Map and HashMap to keep IDs unique and not allow duplicated keys
	 */
	private final Map<String, Task> tasks = new HashMap<>();
	
	/**
	 * Method to add task to tasks Map
	 * @param task
	 */
	public void addTask(Task task) {
		// Checking task isn't null short circuit if current task null.
		if (task == null) {
			throw new IllegalArgumentException("Task cannot be null.");
		}
		
		// Checking if tasks already contains id short circuit to prevent task being overwritten
		if (tasks.containsKey(task.getTaskId())) {
			throw new IllegalArgumentException("Task ID must be unique.");
		}
		tasks.put(task.getTaskId(), task);
	}
	
	/**
	 * Remove task from tasks Map
	 * @param taskId
	 */
	public void deleteTask(String taskId) {
		if (!tasks.containsKey(taskId)) {
			throw new IllegalArgumentException("Task ID not found.");
		}
		tasks.remove(taskId);
	}
	
	/**
	 * Update task name
	 * @param taskId
	 * @param name
	 */
	public void updateTaskName(String taskId, String name) {
		// Get task from tasks Map
		Task task = tasks.get(taskId);
		
		// If task is null short circuit return exception
		if (task == null) {
			throw new IllegalArgumentException("Task not found.");
		}
		// Update selected task with new name
		task.setName(name);
	}
	
	/**
	 * Update task description
	 * @param taskId
	 * @param desc
	 */
	public void updateTaskDescription(String taskId, String desc) {
		// Get task from tasks Map
		Task task = tasks.get(taskId);
		// If task is null short circuit return exception
		if (task == null) {
			throw new IllegalArgumentException("Task not found.");
		}
		// Update selected task with new description
		task.setDescription(desc);
	}
	
	/**
	 * Get task from Map using taskId
	 * @param taskId
	 * @return
	 */
	public Task getTask(String taskId) {
		return tasks.get(taskId);
	}
}
