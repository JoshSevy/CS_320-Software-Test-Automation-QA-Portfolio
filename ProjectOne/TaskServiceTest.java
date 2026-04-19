import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TaskServiceTest {
	private static final String TEST_TASK_ID_ONE = "1234";
	private static final String TEST_TASK_ID_TWO = "4321";
	private static final String TEST_TASK_NAME_ONE = "Joshua";
	private static final String TEST_TASK_NAME_TWO = "Nicole";
	private static final String TEST_TASK_DESCRIPTION = "This is a test description.";
	private static final String TEST_TASK_DESCRIPTION_ALT = "Alternate test description";
	private static final String TEST_TASK_NAME_TOO_LONG = "This task name is longer than twenty";
	private static final String TEST_TASK_DESCRIPTION_TOO_LONG =
			"This description is definitely longer than fifty characters total.";

	private TaskService taskService;
	private Task taskOne;

	@BeforeEach
	void setUp() {
		// Start each test with a clean service and one valid task.
		taskService = new TaskService();
		taskOne = new Task(TEST_TASK_ID_ONE, TEST_TASK_NAME_ONE, TEST_TASK_DESCRIPTION);
	}

	@AfterEach
	void tearDown() {
		// Clear references so each test is fully independent.
		taskService = null;
		taskOne = null;
	}

	// Add should store tasks in the map by ID.
	@Test
	public void testAddTask() {
		// Arrange
		Task taskTwo = new Task(TEST_TASK_ID_TWO, TEST_TASK_NAME_TWO, TEST_TASK_DESCRIPTION);

		// Act
		taskService.addTask(taskOne);
		taskService.addTask(taskTwo);

		// Assert
		assertEquals(taskOne, taskService.getTask(TEST_TASK_ID_ONE), "Task Service should have taskOne in Task Map.");
		assertEquals(taskTwo, taskService.getTask(TEST_TASK_ID_TWO), "Task Service should have taskTwo in Task Map.");
	}

	// Add should fail when an ID is already in use.
	@Test
	public void testTaskAddDuplicateId() {
		// Arrange
		Task duplicateIdTask = new Task(TEST_TASK_ID_ONE, TEST_TASK_NAME_TWO, TEST_TASK_DESCRIPTION);
		taskService.addTask(taskOne);

		// Act
		// Assertion captures duplicate add call.

		// Assert
		assertThrows(IllegalArgumentException.class,
				() -> taskService.addTask(duplicateIdTask),
				"Should throw error if duplicate taskId used when trying to add task.");
	}

	// Add should fail when the incoming task is null.
	@Test
	public void testAddNullTask() {
		// Arrange
		// No additional setup needed.

		// Act
		// Assertion captures null add call.

		// Assert
		assertThrows(IllegalArgumentException.class,
				() -> taskService.addTask(null),
				"Should throw error if task is null");
	}

	// Delete should remove an existing task when we pass its ID.
	@Test
	public void testDeleteTaskById() {
		// Arrange
		taskService.addTask(taskOne);

		// Act
		taskService.deleteTask(TEST_TASK_ID_ONE);

		// Assert
		assertNull(taskService.getTask(TEST_TASK_ID_ONE), "Removed task should be null from getTask.");
	}

	// Delete should fail when the ID does not exist in the map.
	@Test
	public void testDeleteTaskInvalidId() {
		// Arrange
		taskService.addTask(taskOne);

		// Act
		// Assertion captures invalid delete call.

		// Assert
		assertThrows(IllegalArgumentException.class,
				() -> taskService.deleteTask(TEST_TASK_ID_TWO),
				"Should throw error if taskId is not in tasks Map");
	}

	// Delete should fail when taskId is null.
	@Test
	public void testDeleteTaskNullId() {
		// Arrange
		taskService.addTask(taskOne);

		// Act
		// Assertion captures null-ID delete call.

		// Assert
		assertThrows(IllegalArgumentException.class,
				() -> taskService.deleteTask(null),
				"Should throw error if taskId is null");
	}

	// Delete should fail if we try to delete the same task twice.
	@Test
	public void testDeleteTaskTwice() {
		// Arrange
		taskService.addTask(taskOne);
		taskService.deleteTask(TEST_TASK_ID_ONE);

		// Act
		// Assertion captures second delete call.

		// Assert
		assertThrows(IllegalArgumentException.class,
				() -> taskService.deleteTask(TEST_TASK_ID_ONE),
				"Should throw error when deleting a task that was already removed");
	}

	// Update name should fail if the new name is null.
	@Test
	public void testUpdateNameNullCase() {
		// Arrange
		taskService.addTask(taskOne);

		// Act
		// Assertion captures invalid update call.

		// Assert
		assertThrows(IllegalArgumentException.class,
				() -> taskService.updateTaskName(TEST_TASK_ID_ONE, null),
				"Should throw error if updated name is null");
	}

	// Update name should fail if the new name is longer than 20 chars.
	@Test
	public void testUpdateNameTooLongCase() {
		// Arrange
		taskService.addTask(taskOne);

		// Act
		// Assertion captures invalid update call.

		// Assert
		assertThrows(IllegalArgumentException.class,
				() -> taskService.updateTaskName(TEST_TASK_ID_ONE, TEST_TASK_NAME_TOO_LONG),
				"Should throw error if updated name has more than 20 characters");
	}

	// Update description should fail if the new description is null.
	@Test
	public void testUpdateDescriptionNullCase() {
		// Arrange
		taskService.addTask(taskOne);

		// Act
		// Assertion captures invalid update call.

		// Assert
		assertThrows(IllegalArgumentException.class,
				() -> taskService.updateTaskDescription(TEST_TASK_ID_ONE, null),
				"Should throw error if updated description is null");
	}

	// Update description should fail if the new description is longer than 50 chars.
	@Test
	public void testUpdateDescriptionTooLongCase() {
		// Arrange
		taskService.addTask(taskOne);

		// Act
		// Assertion captures invalid update call.

		// Assert
		assertThrows(IllegalArgumentException.class,
				() -> taskService.updateTaskDescription(TEST_TASK_ID_ONE, TEST_TASK_DESCRIPTION_TOO_LONG),
				"Should throw error if updated description has more than 50 characters");
	}

	// Update name should work for a valid task ID.
	@Test
	public void testUpdateTaskName() {
		// Arrange
		taskService.addTask(taskOne);

		// Act
		taskService.updateTaskName(TEST_TASK_ID_ONE, TEST_TASK_NAME_TWO);

		// Assert
		assertEquals(TEST_TASK_NAME_TWO, taskService.getTask(TEST_TASK_ID_ONE).getName(), "Task should be updated with new name.");
	}

	// Update name should fail for an unknown ID.
	@Test
	public void testUpdateNameInvalidId() {
		// Arrange
		taskService.addTask(taskOne);

		// Act
		// Assertion captures invalid-ID update call.

		// Assert
		assertThrows(IllegalArgumentException.class,
				() -> taskService.updateTaskName(TEST_TASK_ID_TWO, TEST_TASK_NAME_TWO),
				"Should throw error if taskId is invalid");
	}

	// Update name should fail if taskId is null.
	@Test
	public void testUpdateNameNullId() {
		// Arrange
		taskService.addTask(taskOne);

		// Act
		// Assertion captures null-ID update call.

		// Assert
		assertThrows(IllegalArgumentException.class,
				() -> taskService.updateTaskName(null, TEST_TASK_NAME_TWO),
				"Should throw error if taskId is null");
	}

	// Update description should work for a valid task ID.
	@Test
	public void testUpdateTaskDescription() {
		// Arrange
		taskService.addTask(taskOne);

		// Act
		taskService.updateTaskDescription(TEST_TASK_ID_ONE, TEST_TASK_DESCRIPTION_ALT);

		// Assert
		assertEquals(TEST_TASK_DESCRIPTION_ALT, taskService.getTask(TEST_TASK_ID_ONE).getDescription(), "Should display updated task description.");
	}

	// Update description should fail for an unknown ID.
	@Test
	public void testUpdateDescriptionInvalidId() {
		// Arrange
		taskService.addTask(taskOne);

		// Act
		// Assertion captures invalid-ID update call.

		// Assert
		assertThrows(IllegalArgumentException.class,
				() -> taskService.updateTaskDescription(TEST_TASK_ID_TWO, TEST_TASK_NAME_TWO),
				"Should throw error if taskId is invalid");
	}

	// Update description should fail if taskId is null.
	@Test
	public void testUpdateDescriptionNullId() {
		// Arrange
		taskService.addTask(taskOne);

		// Act
		// Assertion captures null-ID update call.

		// Assert
		assertThrows(IllegalArgumentException.class,
				() -> taskService.updateTaskDescription(null, TEST_TASK_DESCRIPTION_ALT),
				"Should throw error if taskId is null");
	}

	// Get should return the task for the matching ID.
	@Test
	public void testGetTaskFromTasks() {
		// Arrange
		taskService.addTask(taskOne);

		// Act
		Task foundTask = taskService.getTask(TEST_TASK_ID_ONE);

		// Assert
		assertEquals(taskOne, foundTask, "Should get task by taskId from Task Service.");
	}

	// Get should return null when ID does not exist.
	@Test
	public void testGetTaskUnknownIdReturnsNull() {
		// Arrange
		taskService.addTask(taskOne);

		// Act
		Task foundTask = taskService.getTask(TEST_TASK_ID_TWO);

		// Assert
		assertNull(foundTask, "Unknown taskId should return null.");
	}

	// Get should return null when taskId is null.
	@Test
	public void testGetTaskNullIdReturnsNull() {
		// Arrange
		taskService.addTask(taskOne);

		// Act
		Task foundTask = taskService.getTask(null);

		// Assert
		assertNull(foundTask, "Null taskId should return null.");
	}

	// After deleting a task, the same ID can be used again for a new task.
	@Test
	public void testAddSameIdAfterDelete() {
		// Arrange
		Task replacementTask = new Task(TEST_TASK_ID_ONE, TEST_TASK_NAME_TWO, TEST_TASK_DESCRIPTION_ALT);

		// Act
		taskService.addTask(taskOne);
		taskService.deleteTask(TEST_TASK_ID_ONE);
		taskService.addTask(replacementTask);

		// Assert
		assertEquals(replacementTask, taskService.getTask(TEST_TASK_ID_ONE),
				"Service should allow same ID again after the old task is deleted.");
	}
}
