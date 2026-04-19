import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;


class AppointmentTest {
	private Date validDate;
	private Date pastDate;
	
	private static final String MOCK_APPOINTMENT_ID = "12345";
	private static final String MOCK_APPOINTMENT_ID_MAX = "0123456789";
	private static final String MOCK_APPOINTMENT_ID_TOO_LONG = "0123456789A"; 
	private static final String MOCK_DESCRIPTION = "I am a valid description.";
	private static final String MOCK_DESCRIPTION_MAX = "12345678901234567890123456789012345678901234567890";
	private static final String MOCK_DESCRIPTION_TOO_LONG = "012345678901234567890123456789012345678901234567890A";
	
	private Appointment appointment;
	
	@BeforeEach
	void setUp() throws Exception {
		// Create valid future date instance
		validDate = new Date(System.currentTimeMillis() + 10000);
		
		// Create invalid past date instance
		pastDate = new Date(System.currentTimeMillis() - 10000);
	}
	
	// No tear down needed class instances will be in individual tests.

	// Validate a valid appointment can be created
	@Test
	void testValidAppointmentCreation() {
		// Arrange
		appointment = new Appointment(MOCK_APPOINTMENT_ID, validDate, MOCK_DESCRIPTION);
		
		// Act
		String foundAppointmentId = appointment.getAppointmentId();
		Date foundAppointmentDate = appointment.getAppointmentDate();
		String foundDescription = appointment.getDescription();

		// Assert
		assertEquals(MOCK_APPOINTMENT_ID, foundAppointmentId, "Appointment ID should match input.");
		assertEquals(validDate, foundAppointmentDate, "Appointment Date should match input.");
		assertEquals(MOCK_DESCRIPTION, foundDescription, "Appointment Description should match input.");
	}
	
	// Validate an Appointment ID can be 10 characters.
	@Test
	void testAppointmentIdWithTenCharacters() {
		// Arrange
		appointment = new Appointment(MOCK_APPOINTMENT_ID_MAX, validDate, MOCK_DESCRIPTION);
		
		// Act
		String foundAppointmentId = appointment.getAppointmentId();
		Date foundAppointmentDate = appointment.getAppointmentDate();
		String foundDescription = appointment.getDescription();

		// Assert
		assertEquals(MOCK_APPOINTMENT_ID_MAX, foundAppointmentId, "Appointment ID should match input and valid with 10 characters.");
		assertEquals(validDate, foundAppointmentDate, "Appointment Date should match input.");
		assertEquals(MOCK_DESCRIPTION, foundDescription, "Appointment Description should match input.");
	}
	
	// Negative Test: appointment ID cannot be null
	@Test
	public void testAppointmentIdCannotBeNull() {
		// Arrange
		// validDate and MOCK_DESCRIPTION come from test constants and setUp.

		// Act
		// Assertion captures the constructor call.

		// Assert
		assertThrows(IllegalArgumentException.class, () -> {
			new Appointment(null, validDate, MOCK_DESCRIPTION);
		}, "Should throw error if Appointment ID is null.");
	}
	
	// Negative Test: appointment ID cannot exceed 10 characters
	@Test
	public void testAppointmentIdTooLong() {
		// Arrange
		// validDate and MOCK_DESCRIPTION come from test constants and setUp.

		// Act
		// Assertion captures the constructor call.

		// Assert
		assertThrows(IllegalArgumentException.class, () -> {
			new Appointment(MOCK_APPOINTMENT_ID_TOO_LONG, validDate, MOCK_DESCRIPTION);
		}, "Should throw error if Appointment ID exceeds 10 characters.");
	}
	
	// Negative Test: appointment Date cannot be null
	@Test
	public void testAppointmentDateCannotBeNull() {
		// Arrange
		// MOCK_APPOINTMENT_ID and MOCK_DESCRIPTION come from test constants.

		// Act
		// Assertion captures the constructor call.

		// Assert
		assertThrows(IllegalArgumentException.class, () -> {
			new Appointment(MOCK_APPOINTMENT_ID, null, MOCK_DESCRIPTION);
		}, "Should throw error if Appointment Date is null.");
	}
	
	// Negative Test: appointment Date cannot be in the past
	@Test
	public void testAppointmentDateCannotBeInThePast() {
		// Arrange
		// pastDate is initialized in setUp.

		// Act
		// Assertion captures the constructor call.

		// Assert
		assertThrows(IllegalArgumentException.class, () -> {
			new Appointment(MOCK_APPOINTMENT_ID, pastDate, MOCK_DESCRIPTION);
		}, "Should throw error if Appointment Date cannot be in the past.");
	}
	
	// Validate an Appointment Description can be 50 characters.
		@Test
		void testAppointmentDescriptionWithFiftyCharacters() {
			// Arrange
			appointment = new Appointment(MOCK_APPOINTMENT_ID, validDate, MOCK_DESCRIPTION_MAX);
			
			// Act
			String foundAppointmentId = appointment.getAppointmentId();
			Date foundAppointmentDate = appointment.getAppointmentDate();
			String foundDescription = appointment.getDescription();

			// Assert
			assertEquals(MOCK_APPOINTMENT_ID, foundAppointmentId, "Appointment ID should match input.");
			assertEquals(validDate, foundAppointmentDate, "Appointment Date should match input.");
			assertEquals(MOCK_DESCRIPTION_MAX, foundDescription, "Appointment Description should match input and valid with 50 characters.");
		}
	
	// Negative Test: description cannot be null
	@Test
	public void testAppointmentDescriptionCannotBeNull() {
		// Arrange
		// MOCK_APPOINTMENT_ID and validDate come from test constants and setUp.

		// Act
		// Assertion captures the constructor call.

		// Assert
		assertThrows(IllegalArgumentException.class, () -> {
			new Appointment(MOCK_APPOINTMENT_ID, validDate, null);
		}, "Should throw error if Appointment Description is null.");
	}
	
	// Negative Test: description cannot exceed 50 characters
	@Test
	public void testAppointmentDescriptionTooLong() {
		// Arrange
		// MOCK_APPOINTMENT_ID and validDate come from test constants and setUp.

		// Act
		// Assertion captures the constructor call.

		// Assert
		assertThrows(IllegalArgumentException.class, () -> {
			new Appointment(MOCK_APPOINTMENT_ID, validDate, MOCK_DESCRIPTION_TOO_LONG);
		}, "Should throw error if Appointment Description exceeds 50 characters.");
	}
}
