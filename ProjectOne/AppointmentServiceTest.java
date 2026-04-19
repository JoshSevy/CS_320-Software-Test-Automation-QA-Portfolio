import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;



class AppointmentServiceTest {
	private AppointmentService appointmentService;
	private Appointment appointmentOne;
	private Appointment appointmentTwo;
	private Date validDate;
	
	private static String APPOINTMENT_ONE_ID = "12345";
	private static String APPOINTMENT_TWO_ID = "54321";
	private static String APPOINTMENT_DESC = "Test description";
	

	@BeforeEach
	void setUp() throws Exception {
		appointmentService = new AppointmentService();
		// Create valid future date instance
		validDate = new Date(System.currentTimeMillis() + 10000);
		
		appointmentOne = new Appointment(APPOINTMENT_ONE_ID, validDate, APPOINTMENT_DESC);
		appointmentTwo = new Appointment(APPOINTMENT_TWO_ID, validDate, APPOINTMENT_DESC);
	}
	
	// Should add a valid appointment to service
	@Test
	public void testAddAppointment() {
		// Arrange
		// appointmentOne is initialized in setUp.

		// Act
		appointmentService.addAppointment(appointmentOne);
		
		// Assert
		assertEquals(appointmentOne, appointmentService.getAppointment(APPOINTMENT_ONE_ID), "Should be able to retrieve added appointment by ID.");
	}
	
	// Negative Test: Should not be able to add a null appointment
	@Test
	public void testAddNullAppointment() {
		// Arrange
		// No additional setup needed.

		// Act
		// Assertion captures the service call.

		// Assert
		assertThrows(IllegalArgumentException.class, () -> {
			appointmentService.addAppointment(null);
		}, "Should throw error when adding a null appointment");
	}
	
	// Negative Test: Should not be able to add duplicate appointment
	@Test
	public void testAddDuplicateAppointment() {
		// Arrange
		// Add first appointment so duplicate add can be validated.
		appointmentService.addAppointment(appointmentOne);

		// Act
		// Assertion captures the duplicate add call.

		// Assert
		assertThrows(IllegalArgumentException.class, () -> {
			appointmentService.addAppointment(appointmentOne);
		}, "Should throw error when adding an appointment with already existing ID");
	}
	
	// Should be able to delete appointment by ID
	@Test
	public void testDeleteAppointment() {
		// Arrange
		appointmentService.addAppointment(appointmentOne);
		
		// Act
		Appointment foundBeforeDelete = appointmentService.getAppointment(APPOINTMENT_ONE_ID);
		appointmentService.deleteAppointment(APPOINTMENT_ONE_ID);
		Appointment foundAfterDelete = appointmentService.getAppointment(APPOINTMENT_ONE_ID);

		// Assert
		assertEquals(appointmentOne, foundBeforeDelete, "Should add appointment to service");
		assertNull(foundAfterDelete, "Appointment should be removed after delete appointment.");
	}
	
	
	// Negative Test: Should throw error when deleting with invalid ID.
	@Test
	public void testDeleteAppointmentInvalidId() {
		// Arrange
		appointmentService.addAppointment(appointmentOne);
		
		// Act
		// Assertion captures invalid delete call.

		// Assert
		assertThrows(IllegalArgumentException.class, () -> {
			appointmentService.deleteAppointment(APPOINTMENT_TWO_ID);
		}, "Should throw error when deleting with an invalid ID.");
	}
}
