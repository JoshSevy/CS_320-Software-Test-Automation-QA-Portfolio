import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TaskTest {
	private static final String MOCK_TASK_ID = "Test1234";
	private static final String MOCK_NAME = "Joshua";
	private static final String MOCK_DESCRIPTION = "This is a test.";
	private static final String MOCK_TASK_ID_MAX = "1234567890";
	private static final String MOCK_NAME_MAX = "12345678901234567890";
	private static final String MOCK_DESCRIPTION_MAX = "12345678901234567890123456789012345678901234567890";
	private static final String MOCK_TASK_ID_TOO_LONG = "12345678901";
	private static final String MOCK_NAME_TOO_LONG = "123456789012345678901";
	private static final String MOCK_DESC_TOO_LONG = "123456789012345678901234567890123456789012345678901";

	private Task task;

	@BeforeEach
	void setUp() {
		// Start each test with one valid task object.
		task = new Task(MOCK_TASK_ID, MOCK_NAME, MOCK_DESCRIPTION);
	}

	@AfterEach
	void tearDown() {
		// Clear the reference after each test.
		task = null;
	}

	// Happy path: valid values should build a task object.
	@Test
	public void testValidTaskClassInstanceCreation() {
		// Arrange
		// task is created in setUp.

		// Act
		String foundTaskId = task.getTaskId();
		String foundName = task.getName();
		String foundDescription = task.getDescription();

		// Assert
		assertEquals(MOCK_TASK_ID, foundTaskId, "Task ID should match constructor input.");
		assertEquals(MOCK_NAME, foundName, "Name should match constructor input.");
		assertEquals(MOCK_DESCRIPTION, foundDescription, "Description should match constructor input.");
	}

	// Task ID is required.
	@Test
	public void testTaskIdNullCase() {
		// Arrange
		// MOCK_NAME and MOCK_DESCRIPTION come from test constants.

		// Act
		// Assertion captures constructor call.

		// Assert
		assertThrows(IllegalArgumentException.class,
				() -> new Task(null, MOCK_NAME, MOCK_DESCRIPTION),
				"Should throw error if taskId is null");
	}

	// Task ID max length is 10.
	@Test
	public void testTaskIdTooLongCase() {
		// Arrange
		// MOCK_NAME and MOCK_DESCRIPTION come from test constants.

		// Act
		// Assertion captures constructor call.

		// Assert
		assertThrows(IllegalArgumentException.class,
				() -> new Task(MOCK_TASK_ID_TOO_LONG, MOCK_NAME, MOCK_DESCRIPTION),
				"Should throw error if taskId has more than 10 characters");
	}

	// Task ID should allow exactly 10 characters.
	@Test
	public void testTaskIdAtMaxLengthCase() {
		// Act
		Task maxIdTask = new Task(MOCK_TASK_ID_MAX, MOCK_NAME, MOCK_DESCRIPTION);

		// Assert
		assertEquals(MOCK_TASK_ID_MAX, maxIdTask.getTaskId(), "Task ID with 10 characters should be valid.");
	}

	// Name is required.
	@Test
	public void testNameNullCase() {
		// Arrange
		// MOCK_TASK_ID and MOCK_DESCRIPTION come from test constants.

		// Act
		// Assertion captures constructor call.

		// Assert
		assertThrows(IllegalArgumentException.class,
				() -> new Task(MOCK_TASK_ID, null, MOCK_DESCRIPTION),
				"Should throw error if name is null");
	}

	// Name max length is 20.
	@Test
	public void testNameTooLongCase() {
		// Arrange
		// MOCK_TASK_ID and MOCK_DESCRIPTION come from test constants.

		// Act
		// Assertion captures constructor call.

		// Assert
		assertThrows(IllegalArgumentException.class,
				() -> new Task(MOCK_TASK_ID, MOCK_NAME_TOO_LONG, MOCK_DESCRIPTION),
				"Should throw error if name has more than 20 characters");
	}

	// Name should allow exactly 20 characters.
	@Test
	public void testNameAtMaxLengthCase() {
		// Act
		Task maxNameTask = new Task(MOCK_TASK_ID, MOCK_NAME_MAX, MOCK_DESCRIPTION);

		// Assert
		assertEquals(MOCK_NAME_MAX, maxNameTask.getName(), "Name with 20 characters should be valid.");
	}

	// Description is required.
	@Test
	public void testDescriptionNullCase() {
		// Arrange
		// MOCK_TASK_ID and MOCK_NAME come from test constants.

		// Act
		// Assertion captures constructor call.

		// Assert
		assertThrows(IllegalArgumentException.class,
				() -> new Task(MOCK_TASK_ID, MOCK_NAME, null),
				"Should throw error if description is null");
	}

	// Description max length is 50.
	@Test
	public void testDescriptionTooLongCase() {
		// Arrange
		// MOCK_TASK_ID and MOCK_NAME come from test constants.

		// Act
		// Assertion captures constructor call.

		// Assert
		assertThrows(IllegalArgumentException.class,
				() -> new Task(MOCK_TASK_ID, MOCK_NAME, MOCK_DESC_TOO_LONG),
				"Should throw error if description has more than 50 characters");
	}

	// Description should allow exactly 50 characters.
	@Test
	public void testDescriptionAtMaxLengthCase() {
		// Act
		Task maxDescriptionTask = new Task(MOCK_TASK_ID, MOCK_NAME, MOCK_DESCRIPTION_MAX);

		// Assert
		assertEquals(MOCK_DESCRIPTION_MAX, maxDescriptionTask.getDescription(),
				"Description with 50 characters should be valid.");
	}

	// Name should update when the value is valid.
	@Test
	public void testUpdateName() {
		// Arrange
		String newName = "Josh";

		// Act
		task.setName(newName);

		// Assert
		assertEquals(newName, task.getName(), "Should update existing name.");
	}

	// Updating name should fail when new value is null.
	@Test
	public void testUpdateNameNullCase() {
		// Arrange
		// task is initialized in setUp.

		// Act
		// Assertion captures setter call.

		// Assert
		assertThrows(IllegalArgumentException.class,
				() -> task.setName(null),
				"Should throw error if updated name is null.");
	}

	// Updating name should fail when new value is longer than 20.
	@Test
	public void testUpdateNameTooLongCase() {
		// Arrange
		// task is initialized in setUp.

		// Act
		// Assertion captures setter call.

		// Assert
		assertThrows(IllegalArgumentException.class,
				() -> task.setName(MOCK_NAME_TOO_LONG),
				"Should throw error if updated name has more than 20 characters.");
	}

	// Description should update when the value is valid.
	@Test
	public void testUpdateDescription() {
		// Arrange
		String newDescription = "Updated description";

		// Act
		task.setDescription(newDescription);

		// Assert
		assertEquals(newDescription, task.getDescription(), "Should update existing description.");
	}

	// Updating description should fail when new value is null.
	@Test
	public void testUpdateDescriptionNullCase() {
		// Arrange
		// task is initialized in setUp.

		// Act
		// Assertion captures setter call.

		// Assert
		assertThrows(IllegalArgumentException.class,
				() -> task.setDescription(null),
				"Should throw error if updated description is null.");
	}

	// Updating description should fail when new value is longer than 50.
	@Test
	public void testUpdateDescriptionTooLongCase() {
		// Arrange
		// task is initialized in setUp.

		// Act
		// Assertion captures setter call.

		// Assert
		assertThrows(IllegalArgumentException.class,
				() -> task.setDescription(MOCK_DESC_TOO_LONG),
				"Should throw error if updated description has more than 50 characters.");
	}
}
