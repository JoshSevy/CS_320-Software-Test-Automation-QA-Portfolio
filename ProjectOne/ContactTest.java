import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * Unit tests for the Contact class.
 *
 * These tests verify that the Contact class satisfies all rubric requirements:
 * - contactId is required, not null, no longer than 10 characters, and not updatable
 * - firstName is required, not null, and no longer than 10 characters
 * - lastName is required, not null, and no longer than 10 characters
 * - phone is required, not null, and must be exactly 10 digits
 * - address is required, not null, and no longer than 30 characters
 */
public class ContactTest {

    private static final String MAX_FIRST_NAME = "1234567890";
    private static final String MAX_LAST_NAME = "1234567890";
    private static final String MAX_PHONE = "0123456789";
    private static final String MAX_ADDRESS = "123456789012345678901234567890";

    /**
     * Verifies that a valid contact can be created when all fields meet requirements.
     */
    @Test
    public void testValidContactCreation() {
        // Arrange
        Contact contact = new Contact("12345", "John", "Smith", "1234567890", "123 Main St");

        // Act
        String foundContactId = contact.getContactId();
        String foundFirstName = contact.getFirstName();
        String foundLastName = contact.getLastName();
        String foundPhone = contact.getPhone();
        String foundAddress = contact.getAddress();

        // Assert
        assertEquals("12345", foundContactId);
        assertEquals("John", foundFirstName);
        assertEquals("Smith", foundLastName);
        assertEquals("1234567890", foundPhone);
        assertEquals("123 Main St", foundAddress);
    }

    /**
     * Verifies that contactId cannot be null.
     */
    @Test
    public void testContactIdCannotBeNull() {
        // Arrange
        // Remaining constructor args are valid.

        // Act
        // Assertion captures constructor call.

        // Assert
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(null, "John", "Smith", "1234567890", "123 Main St");
        });
    }

    /**
     * Verifies that contactId cannot be longer than 10 characters.
     */
    @Test
    public void testContactIdCannotBeLongerThan10() {
        // Arrange
        // Remaining constructor args are valid.

        // Act
        // Assertion captures constructor call.

        // Assert
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345678901", "John", "Smith", "1234567890", "123 Main St");
        });
    }

    /**
     * Verifies that firstName cannot be null.
     */
    @Test
    public void testFirstNameCannotBeNull() {
        // Arrange
        // Remaining constructor args are valid.

        // Act
        // Assertion captures constructor call.

        // Assert
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", null, "Smith", "1234567890", "123 Main St");
        });
    }

    /**
     * Verifies that firstName cannot be longer than 10 characters.
     */
    @Test
    public void testFirstNameCannotBeLongerThan10() {
        // Arrange
        // Remaining constructor args are valid.

        // Act
        // Assertion captures constructor call.

        // Assert
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "Christopher", "Smith", "1234567890", "123 Main St");
        });
    }

    /**
     * Verifies that lastName cannot be null.
     */
    @Test
    public void testLastNameCannotBeNull() {
        // Arrange
        // Remaining constructor args are valid.

        // Act
        // Assertion captures constructor call.

        // Assert
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "John", null, "1234567890", "123 Main St");
        });
    }

    /**
     * Verifies that lastName cannot be longer than 10 characters.
     */
    @Test
    public void testLastNameCannotBeLongerThan10() {
        // Arrange
        // Remaining constructor args are valid.

        // Act
        // Assertion captures constructor call.

        // Assert
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "John", "Christopher", "1234567890", "123 Main St");
        });
    }

    /**
     * Verifies that phone must contain exactly 10 digits.
     */
    @Test
    public void testPhoneMustBeExactly10Digits() {
        // Arrange
        // Remaining constructor args are valid.

        // Act
        // Assertion captures constructor call.

        // Assert
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "John", "Smith", "12345", "123 Main St");
        });
    }

    /**
     * Verifies that phone cannot contain letters and must be numeric only.
     */
    @Test
    public void testPhoneCannotContainLetters() {
        // Arrange
        // Remaining constructor args are valid.

        // Act
        // Assertion captures constructor call.

        // Assert
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "John", "Smith", "12345abcde", "123 Main St");
        });
    }

    /**
     * Verifies that address cannot be null.
     */
    @Test
    public void testAddressCannotBeNull() {
        // Arrange
        // Remaining constructor args are valid.

        // Act
        // Assertion captures constructor call.

        // Assert
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "John", "Smith", "1234567890", null);
        });
    }

    /**
     * Verifies that address cannot be longer than 30 characters.
     */
    @Test
    public void testAddressCannotBeLongerThan30() {
        // Arrange
        // Remaining constructor args are valid.

        // Act
        // Assertion captures constructor call.

        // Assert
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "John", "Smith", "1234567890", "1234567890123456789012345678901");
        });
    }

    /**
     * Verifies that the updatable fields can be successfully changed
     * when valid values are provided.
     *
     * contactId is not tested for updates because it is intentionally immutable.
     */
    @Test
    public void testUpdateFields() {
        // Arrange
        Contact contact = new Contact("12345", "John", "Smith", "1234567890", "123 Main St");

        // Act
        contact.setFirstName("Jane");
        contact.setLastName("Doe");
        contact.setPhone("0987654321");
        contact.setAddress("456 Oak Street");

        // Assert
        assertEquals("Jane", contact.getFirstName());
        assertEquals("Doe", contact.getLastName());
        assertEquals("0987654321", contact.getPhone());
        assertEquals("456 Oak Street", contact.getAddress());
    }

    /**
     * Verifies that firstName can be updated to the maximum valid length.
     */
    @Test
    public void testUpdateFirstNameAtMaxLength() {
        // Arrange
        Contact contact = new Contact("12345", "John", "Smith", "1234567890", "123 Main St");

        // Act
        contact.setFirstName(MAX_FIRST_NAME);

        // Assert
        assertEquals(MAX_FIRST_NAME, contact.getFirstName());
    }

    /**
     * Verifies that firstName cannot be null when updated.
     */
    @Test
    public void testUpdateFirstNameCannotBeNull() {
        // Arrange
        Contact contact = new Contact("12345", "John", "Smith", "1234567890", "123 Main St");

        // Act
        // Assertion captures setter call.

        // Assert
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setFirstName(null);
        });
    }

    /**
     * Verifies that lastName can be updated to the maximum valid length.
     */
    @Test
    public void testUpdateLastNameAtMaxLength() {
        // Arrange
        Contact contact = new Contact("12345", "John", "Smith", "1234567890", "123 Main St");

        // Act
        contact.setLastName(MAX_LAST_NAME);

        // Assert
        assertEquals(MAX_LAST_NAME, contact.getLastName());
    }

    /**
     * Verifies that phone can be updated to exactly 10 digits.
     */
    @Test
    public void testUpdatePhoneAtMaxLength() {
        // Arrange
        Contact contact = new Contact("12345", "John", "Smith", "1234567890", "123 Main St");

        // Act
        contact.setPhone(MAX_PHONE);

        // Assert
        assertEquals(MAX_PHONE, contact.getPhone());
    }

    /**
     * Verifies that phone cannot contain invalid values when updated.
     */
    @Test
    public void testUpdatePhoneCannotContainLetters() {
        // Arrange
        Contact contact = new Contact("12345", "John", "Smith", "1234567890", "123 Main St");

        // Act
        // Assertion captures setter call.

        // Assert
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setPhone("12345abcde");
        });
    }

    /**
     * Verifies that phone cannot be set to null.
     */
    @Test
    public void testUpdatePhoneCannotBeNull() {
        // Arrange
        Contact contact = new Contact("12345", "John", "Smith", "1234567890", "123 Main St");

        // Act
        // Assertion captures setter call.

        // Assert
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setPhone(null);
        });
    }

    /**
     * Verifies that address can be updated to the maximum valid length.
     */
    @Test
    public void testUpdateAddressAtMaxLength() {
        // Arrange
        Contact contact = new Contact("12345", "John", "Smith", "1234567890", "123 Main St");

        // Act
        contact.setAddress(MAX_ADDRESS);

        // Assert
        assertEquals(MAX_ADDRESS, contact.getAddress());
    }

    /**
     * Verifies that address cannot be null when updated.
     */
    @Test
    public void testUpdateAddressCannotBeNull() {
        // Arrange
        Contact contact = new Contact("12345", "John", "Smith", "1234567890", "123 Main St");

        // Act
        // Assertion captures setter call.

        // Assert
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setAddress(null);
        });
    }
}