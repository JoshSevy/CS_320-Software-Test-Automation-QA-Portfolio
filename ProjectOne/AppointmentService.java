import java.util.HashMap;
import java.util.Map;

/**
 * Service Object for managing Appointment objects in memory.
 */
public class AppointmentService {
	private final Map<String, Appointment> appointments = new HashMap<>();
	
	/**
	 * Adds valid appointment if ID is unique
	 * @param appointment
	 */
	public void addAppointment(Appointment appointment) {
		// Null check appointment
		if (appointment == null) {
			throw new IllegalArgumentException("Appointment cannot be null.");
		}
		
		// Check appointment ID is unique
		if (appointments.containsKey(appointment.getAppointmentId())) {
			throw new IllegalArgumentException("Appointment ID must be unique.");
		}
		
		// Add appointment with unique ID to appointments Map.
		appointments.put(appointment.getAppointmentId(), appointment);
	}
	
	/**
	 * Deletes an appointment by appointment ID
	 * @param appointmentId
	 */
	public void deleteAppointment(String appointmentId) {
		// Check that appointment is in appointments before removal
		if (!appointments.containsKey(appointmentId)) {
			throw new IllegalArgumentException("Invalid Appointment ID");
		}
		
		appointments.remove(appointmentId);
	}
	
	public Appointment getAppointment(String appointmentId) {
		// Consider adding check or returning null if appointment not in appointments
		return appointments.get(appointmentId);
	}

}
