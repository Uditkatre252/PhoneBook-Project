import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PhoneBook {

    // Using HashMap to store name and phone number
    private Map<String, String> contacts;

    public PhoneBook() {
        contacts = new HashMap<>();
    }

    // Add a new contact
    public void addContact(String name, String phoneNumber) {
        contacts.put(name, phoneNumber);
        System.out.println("Contact added: " + name + " - " + phoneNumber);
    }

    // Delete a contact by name
    public void deleteContact(String name) {
        if (contacts.containsKey(name)) {
            contacts.remove(name);
            System.out.println("Contact deleted: " + name);
        } else {
            System.out.println("Contact not found: " + name);
        }
    }

    // Update a contact's phone number by name
    public void updateContact(String name, String newPhoneNumber) {
        if (contacts.containsKey(name)) {
            contacts.put(name, newPhoneNumber);
            System.out.println("Contact updated: " + name + " - " + newPhoneNumber);
        } else {
            System.out.println("Contact not found: " + name);
        }
    }

    // Search for a contact by name
    public void searchContact(String name) {
        if (contacts.containsKey(name)) {
            System.out.println("Contact found: " + name + " - " + contacts.get(name));
        } else {
            System.out.println("Contact not found: " + name);
        }
    }

    // Display all contacts
    public void displayAllContacts() {
        if (contacts.isEmpty()) {
            System.out.println("Phone book is empty.");
        } else {
            System.out.println("All contacts:");
            for (Map.Entry<String, String> entry : contacts.entrySet()) {
                System.out.println(entry.getKey() + " - " + entry.getValue());
            }
        }
    }

    // Count total contacts
    public void countContacts() {
        System.out.println("Total contacts: " + contacts.size());
    }

    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Phone Book Menu ---");
            System.out.println("1. Add Contact");
            System.out.println("2. Delete Contact");
            System.out.println("3. Update Contact");
            System.out.println("4. Search Contact");
            System.out.println("5. Display All Contacts");
            System.out.println("6. Count Contacts");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter phone number: ");
                    String phoneNumber = scanner.nextLine();
                    phoneBook.addContact(name, phoneNumber);
                    break;
                case 2:
                    System.out.print("Enter name to delete: ");
                    String deleteName = scanner.nextLine();
                    phoneBook.deleteContact(deleteName);
                    break;
                case 3:
                    System.out.print("Enter name to update: ");
                    String updateName = scanner.nextLine();
                    System.out.print("Enter new phone number: ");
                    String newPhoneNumber = scanner.nextLine();
                    phoneBook.updateContact(updateName, newPhoneNumber);
                    break;
                case 4:
                    System.out.print("Enter name to search: ");
                    String searchName = scanner.nextLine();
                    phoneBook.searchContact(searchName);
                    break;
                case 5:
                    phoneBook.displayAllContacts();
                    break;
                case 6:
                    phoneBook.countContacts();
                    break;
                case 7:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 7);

        scanner.close();
    }
}
