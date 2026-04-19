import java.util.Date;

/**
 * Appointment Class for mobile application
 */
public class Appointment {
	// Required unique ID immutable and <= 10 characters
	private String appointmentId;
	// Required Date >= currentDate
	private Date appointmentDate;
	// Required Length <= 50 characters
	private String description;
	
	/**
	 * Creates a new Appointment Object and validates required inputs.
	 * 
	 * @param appointmentId
	 * @param appointmentDate
	 * @param description
	 */
	public Appointment(String appointmentId, Date appointmentDate, String description) {
		// Appointment ID is a required field. Is immutable, must be 10 characters or less and cannot be null.
		if (appointmentId == null || appointmentId.length() > 10) {
			throw new IllegalArgumentException("Appointment Id must not be null or greater than 10 characters");
		}
		
		// Appointment Date is a required field. Date cannot be null and Date cannot be in the past.
		if (appointmentDate == null || appointmentDate.before(new Date())) {
			throw new IllegalArgumentException("Appointment Date must not be null and cannot be a Date in the past.");
		}
		
		// Description is a required field. Description cannot be null and must be 50 characters or less.
		if (description == null || description.length() > 50) {
			throw new IllegalArgumentException("Description must not be null and must be 50 characters or less.");
		}
		this.appointmentId = appointmentId;
		this.appointmentDate = appointmentDate;
		this.description = description;
	}
	
	/**
	 * Getter for appointment Id
	 */
	public String getAppointmentId() {
		return this.appointmentId;
	}
	
	/**
	 * Getter for appointment Date
	 */
	public Date getAppointmentDate() {
		return this.appointmentDate;
	}
	
	/**
	 * Getter for appointment description
	 */
	public String getDescription() {
		return this.description;
	}

}
