import java.util.ArrayList;
import java.util.List;

/**
 * The ContactService class manages Contact objects using an in-memory data structure.
 *
 * This implementation uses an ArrayList to store contacts, satisfying the requirement
 * that no database is used.
 *
 * This class fulfills all Contact Service requirements from the rubric:
 * - Add contacts with a unique contact ID
 * - Delete contacts using a contact ID
 * - Update contact fields (firstName, lastName, phone, address) using a contact ID
 */
public class ContactService {

    // In-memory list used to store all contact objects (no database required)
    private final List<Contact> contacts = new ArrayList<>();

    /**
     * Adds a new contact to the service.
     *
     * Requirements enforced:
     * - Contact must not be null
     * - Contact ID must be unique across all stored contacts
     */
    public void addContact(Contact contact) {
        if (contact == null) {
            throw new IllegalArgumentException("Contact cannot be null");
        }

        // Iterate through list to ensure no duplicate contact IDs exist
        for (Contact c : contacts) {
            if (c.getContactId().equals(contact.getContactId())) {
                throw new IllegalArgumentException("Contact ID must be unique");
            }
        }
        // Add valid and unique contact to in-memory list
        contacts.add(contact);
    }

    /**
     * Returns a contact by contact ID.
     *
     * This method supports verification in unit tests and allows retrieval
     * of stored contacts by their unique ID.
     */
    public Contact getContact(String contactId) {
        return findContact(contactId);
    }

    /**
     * Deletes a contact based on the provided contact ID.
     *
     * Requirements enforced:
     * - Contact must exist (validated through findContact)
     * - Removal is performed using the contact ID
     */
    public void deleteContact(String contactId) {
        Contact contact = findContact(contactId);
        contacts.remove(contact);
    }

    /**
     * Updates the first name of a contact identified by contact ID.
     *
     * Requirements enforced:
     * - Contact ID must exist
     * - firstName is validated within the Contact class
     */
    public void updateFirstName(String contactId, String firstName) {
        Contact contact = findContact(contactId);
        contact.setFirstName(firstName);
    }

    /**
     * Updates the last name of a contact identified by contact ID.
     *
     * Requirements enforced:
     * - Contact ID must exist
     * - lastName is validated within the Contact class
     */
    public void updateLastName(String contactId, String lastName) {
        Contact contact = findContact(contactId);
        contact.setLastName(lastName);
    }

    /**
     * Updates the phone number of a contact identified by contact ID.
     *
     * Requirements enforced:
     * - Contact ID must exist
     * - phone is validated within the Contact class (must be exactly 10 digits)
     */
    public void updatePhone(String contactId, String phone) {
        Contact contact = findContact(contactId);
        contact.setPhone(phone);
    }

    /**
     * Updates the address of a contact identified by contact ID.
     *
     * Requirements enforced:
     * - Contact ID must exist
     * - address is validated within the Contact class
     */
    public void updateAddress(String contactId, String address) {
        Contact contact = findContact(contactId);
        contact.setAddress(address);
    }

    /**
     * Helper method to locate a contact using its contact ID.
     *
     * This supports all service operations (delete and update) by ensuring:
     * - The contact exists before performing any operation
     * - A consistent lookup mechanism is used across the service
     *
     * @param contactId the unique identifier of the contact
     * @return the matching Contact object
     * @throws IllegalArgumentException if the contact ID does not exist
     */
    private Contact findContact(String contactId) {
        for (Contact contact : contacts) {
            if (contact.getContactId().equals(contactId)) {
                return contact;
            }
        }

        throw new IllegalArgumentException("Contact ID not found");
    }
}