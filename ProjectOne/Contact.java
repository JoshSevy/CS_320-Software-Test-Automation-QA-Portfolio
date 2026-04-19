/**
 * The Contact class represents a single contact within the application.
 *
 * This class enforces all required constraints defined in the project rubric:
 * - contactId: required, unique (handled by service), not null, max length 10, not updatable
 * - firstName: required, not null, max length 10
 * - lastName: required, not null, max length 10
 * - phone: required, not null, exactly 10 digits
 * - address: required, not null, max length 30
 */
public class Contact {
    // Unique contact ID (immutable after creation)
    private final String contactId;
    // Contact first name (max length 10, not null)
    private String firstName;
    // Contact last name (max length 10, not null)
    private String lastName;
    // Contact phone number (exactly 10 digits, not null)
    private String phone;
    // Contact address (max length 30, not null)
    private String address;

    /**
     * Constructor initializes a Contact object and validates all fields
     * according to the project requirements.
     */
    public Contact(String contactId, String firstName, String lastName, String phone, String address) {
        validateContactId(contactId);
        validateFirstName(firstName);
        validateLastName(lastName);
        validatePhone(phone);
        validateAddress(address);

        this.contactId = contactId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
    }

    /**
     * Returns the contact ID.
     * This field is immutable and cannot be updated after creation.
     */
    public String getContactId() {
        return contactId;
    }

    /**
     * Returns the first name.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Updates the first name after validating constraints:
     * - must not be null
     * - must not exceed 10 characters
     */
    public void setFirstName(String firstName) {
        validateFirstName(firstName);
        this.firstName = firstName;
    }

    /**
     * Returns the last name.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Updates the last name after validating constraints:
     * - must not be null
     * - must not exceed 10 characters
     */
    public void setLastName(String lastName) {
        validateLastName(lastName);
        this.lastName = lastName;
    }

    /**
     * Returns the phone number.
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Updates the phone number after validating constraints:
     * - must not be null
     * - must be exactly 10 digits
     */
    public void setPhone(String phone) {
        validatePhone(phone);
        this.phone = phone;
    }

    /**
     * Returns the address.
     */
    public String getAddress() {
        return address;
    }

    /**
     * Updates the address after validating constraints:
     * - must not be null
     * - must not exceed 30 characters
     */
    public void setAddress(String address) {
        validateAddress(address);
        this.address = address;
    }

    /**
     * Validates contact ID:
     * - must not be null
     * - must not exceed 10 characters
     */
    private void validateContactId(String contactId) {
        if (contactId == null || contactId.length() > 10) {
            throw new IllegalArgumentException("Invalid contact ID");
        }
    }

    /**
     * Validates first name:
     * - must not be null
     * - must not exceed 10 characters
     */
    private void validateFirstName(String firstName) {
        if (firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException("Invalid first name");
        }
    }

    /**
     * Validates last name:
     * - must not be null
     * - must not exceed 10 characters
     */
    private void validateLastName(String lastName) {
        if (lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException("Invalid last name");
        }
    }

    /**
     * Validates phone number:
     * - must not be null
     * - must be exactly 10 digits (numeric only)
     */
    private void validatePhone(String phone) {
        if (phone == null || !phone.matches("\\d{10}")) {
            throw new IllegalArgumentException("Invalid phone number");
        }
    }

    /**
     * Validates address:
     * - must not be null
     * - must not exceed 30 characters
     */
    private void validateAddress(String address) {
        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException("Invalid address");
        }
    }
}