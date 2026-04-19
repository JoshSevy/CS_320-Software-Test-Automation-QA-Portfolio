import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * Unit tests for the ContactService class.
 *
 * These tests verify that the ContactService class satisfies all rubric requirements:
 * - add contacts with a unique contact ID
 * - delete contacts using a contact ID
 * - update contact fields (firstName, lastName, phone, address) using a contact ID
 *
 * These tests also confirm that invalid operations, such as adding duplicate IDs,
 * are correctly rejected.
 */
public class ContactServiceTest {

    /**
     * Verifies that a valid contact can be added to the service
     * and retrieved by its unique contact ID.
     */
    @Test
    public void testAddContact() {
        // Arrange
        ContactService service = new ContactService();
        Contact contact = new Contact("12345", "John", "Smith", "1234567890", "123 Main St");

        // Act
        service.addContact(contact);

        // Assert
        assertEquals(contact, service.getContact("12345"));
    }

    /**
     * Verifies that the service rejects adding a second contact
     * with a duplicate contact ID.
     */
    @Test
    public void testAddContactWithDuplicateIdFails() {
        // Arrange
        ContactService service = new ContactService();
        Contact contact1 = new Contact("12345", "John", "Smith", "1234567890", "123 Main St");
        Contact contact2 = new Contact("12345", "Jane", "Doe", "0987654321", "456 Oak St");

        service.addContact(contact1);

        // Act
        // Assertion captures duplicate add call.

        // Assert
        assertThrows(IllegalArgumentException.class, () -> {
            service.addContact(contact2);
        });
    }

    /**
     * Verifies that a second unique contact can be added without triggering the duplicate check.
     */
    @Test
    public void testAddSecondUniqueContact() {
        // Arrange
        ContactService service = new ContactService();
        Contact contact1 = new Contact("12345", "John", "Smith", "1234567890", "123 Main St");
        Contact contact2 = new Contact("54321", "Jane", "Doe", "0987654321", "456 Oak St");

        // Act
        service.addContact(contact1);
        service.addContact(contact2);

        // Assert
        assertEquals(contact1, service.getContact("12345"));
        assertEquals(contact2, service.getContact("54321"));
    }

    /**
     * Verifies that a contact can be deleted using its contact ID.
     * After deletion, the contact should no longer be found in the service.
     */
    @Test
    public void testDeleteContact() {
        // Arrange
        ContactService service = new ContactService();
        Contact contact = new Contact("12345", "John", "Smith", "1234567890", "123 Main St");

        service.addContact(contact);

        // Act
        service.deleteContact("12345");

        // Assert
        assertThrows(IllegalArgumentException.class, () -> {
            service.getContact("12345");
        });
    }

    /**
     * Verifies that attempting to delete a contact with a non-existent contact ID
     * results in an exception.
     *
     * This ensures the service correctly enforces the requirement that delete
     * operations must be performed only on valid, existing contact IDs.
     */
    @Test
    public void testDeleteContactWithInvalidIdFails() {
        // Arrange
        ContactService service = new ContactService();

        // Act
        // Assertion captures invalid delete call.

        // Assert
        assertThrows(IllegalArgumentException.class, () -> {
            service.deleteContact("99999");
        });
    }

    /**
     * Verifies that the firstName field can be updated using the contact ID.
     */
    @Test
    public void testUpdateFirstName() {
        // Arrange
        ContactService service = new ContactService();
        Contact contact = new Contact("12345", "John", "Smith", "1234567890", "123 Main St");

        service.addContact(contact);

        // Act
        service.updateFirstName("12345", "Jane");

        // Assert
        assertEquals("Jane", service.getContact("12345").getFirstName());
    }

    /**
     * Verifies that the lastName field can be updated using the contact ID.
     */
    @Test
    public void testUpdateLastName() {
        // Arrange
        ContactService service = new ContactService();
        Contact contact = new Contact("12345", "John", "Smith", "1234567890", "123 Main St");

        service.addContact(contact);

        // Act
        service.updateLastName("12345", "Doe");

        // Assert
        assertEquals("Doe", service.getContact("12345").getLastName());
    }

    /**
     * Verifies that the phone field can be updated using the contact ID.
     */
    @Test
    public void testUpdatePhone() {
        // Arrange
        ContactService service = new ContactService();
        Contact contact = new Contact("12345", "John", "Smith", "1234567890", "123 Main St");

        service.addContact(contact);

        // Act
        service.updatePhone("12345", "0987654321");

        // Assert
        assertEquals("0987654321", service.getContact("12345").getPhone());
    }

    /**
     * Verifies that the address field can be updated using the contact ID.
     */
    @Test
    public void testUpdateAddress() {
        // Arrange
        ContactService service = new ContactService();
        Contact contact = new Contact("12345", "John", "Smith", "1234567890", "123 Main St");

        service.addContact(contact);

        // Act
        service.updateAddress("12345", "456 Oak Street");

        // Assert
        assertEquals("456 Oak Street", service.getContact("12345").getAddress());
    }

    /**
     * Verifies that the service rejects adding a null contact.
     */
    @Test
    public void testAddNullContactFails() {
        // Arrange
        ContactService service = new ContactService();

        // Act
        // Assertion captures null add call.

        // Assert
        assertThrows(IllegalArgumentException.class, () -> {
            service.addContact(null);
        });
    }

    /**
     * Verifies that requesting a missing contact ID throws an exception.
     */
    @Test
    public void testGetContactWithInvalidIdFails() {
        // Arrange
        ContactService service = new ContactService();

        // Act
        // Assertion captures invalid get call.

        // Assert
        assertThrows(IllegalArgumentException.class, () -> {
            service.getContact("99999");
        });
    }

    /**
     * Verifies that firstName updates fail when the contact ID does not exist.
     */
    @Test
    public void testUpdateFirstNameWithInvalidIdFails() {
        // Arrange
        ContactService service = new ContactService();
        Contact contact = new Contact("12345", "John", "Smith", "1234567890", "123 Main St");

        service.addContact(contact);

        // Act
        // Assertion captures invalid-ID update call.

        // Assert
        assertThrows(IllegalArgumentException.class, () -> {
            service.updateFirstName("99999", "Jane");
        });
    }

    /**
     * Verifies that lastName updates fail when the contact ID does not exist.
     */
    @Test
    public void testUpdateLastNameWithInvalidIdFails() {
        // Arrange
        ContactService service = new ContactService();
        Contact contact = new Contact("12345", "John", "Smith", "1234567890", "123 Main St");

        service.addContact(contact);

        // Act
        // Assertion captures invalid-ID update call.

        // Assert
        assertThrows(IllegalArgumentException.class, () -> {
            service.updateLastName("99999", "Doe");
        });
    }

    /**
     * Verifies that phone updates fail when the contact ID does not exist.
     */
    @Test
    public void testUpdatePhoneWithInvalidIdFails() {
        // Arrange
        ContactService service = new ContactService();
        Contact contact = new Contact("12345", "John", "Smith", "1234567890", "123 Main St");

        service.addContact(contact);

        // Act
        // Assertion captures invalid-ID update call.

        // Assert
        assertThrows(IllegalArgumentException.class, () -> {
            service.updatePhone("99999", "0987654321");
        });
    }

    /**
     * Verifies that address updates fail when the contact ID does not exist.
     */
    @Test
    public void testUpdateAddressWithInvalidIdFails() {
        // Arrange
        ContactService service = new ContactService();
        Contact contact = new Contact("12345", "John", "Smith", "1234567890", "123 Main St");

        service.addContact(contact);

        // Act
        // Assertion captures invalid-ID update call.

        // Assert
        assertThrows(IllegalArgumentException.class, () -> {
            service.updateAddress("99999", "456 Oak Street");
        });
    }
}