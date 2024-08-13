/**
 * Katherine (Katie) Barrett
 * EN.605.201.81.SU24
 * Assignment #11 Part 1
 * 
 * References used for this assignment: 
 * Module 11 Office Hours Presentation
 * Module 11 Lectures A-E
 * Module 10 Presentation/Lectures/Assignment for file reading/writing
 */

import java.util.*;
import java.io.*;

public class ContactList {

    public static void main (String [] args){
        Scanner input = new Scanner(System.in);
        String fileName;
        TreeMap<String, Contact> allContacts = new TreeMap<>();

        // Prompt user for the name of the contact list file
        System.out.println("Please enter the name of the contact list file:");
        fileName = input.nextLine();

        // Load contacts from the file
        loadContacts(fileName, allContacts);

        int response = 0;
        while (response != 4) {
            System.out.println("1: Display contact information\n" +
                               "2: Add a contact\n" +
                               "3: Remove a contact\n" +
                               "4: Save contact list and exit\n" +
                               "Selection: ");
            response = input.nextInt();
            input.nextLine(); // Consume newline character
            System.out.println();

            switch (response) {
                case 1:
                    // Display all contacts
                    for (Contact contact : allContacts.values()) {
                        System.out.println(contact);
                    }
                    System.out.println();
                    break;

                case 2:
                    // Initialize necessary variables
                    String firstNameTemp;
                    String lastNameTemp;
                    String companyTemp;
                    String phoneTemp;
                    String emailTemp;
                    int choice = 1;

                    // Add a contact
                    while (choice == 1) {
                        System.out.println("Enter first name:");
                        firstNameTemp = input.nextLine();
                        System.out.println("Enter last name:");
                        lastNameTemp = input.nextLine();
                        System.out.println("Enter company:");
                        companyTemp = input.nextLine();
                        System.out.println("Enter phone:");
                        phoneTemp = input.nextLine();
                        System.out.println("Enter email:");
                        emailTemp = input.nextLine();

                        Contact contactTemp = new Contact(firstNameTemp, lastNameTemp, companyTemp, phoneTemp, emailTemp);
                        allContacts.put(lastNameTemp, contactTemp);

                        System.out.println("Do you want to add another contact? (yes=1, no=0)");
                        choice = input.nextInt();
                        input.nextLine(); // Consume newline character
                    }
                    break;

                case 3:
                    // Remove a contact
                    System.out.println("Enter the last name of the contact to remove:");
                    String lastNameToRemove = input.nextLine();
                    if (allContacts.containsKey(lastNameToRemove)) {
                        allContacts.remove(lastNameToRemove);
                        System.out.println("Contact removed.\n");
                    } else {
                        System.out.println("Contact not found.\n");
                    }
                    break;

                case 4:
                    // Save contact list to the file
                    try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
                        for (Contact contact : allContacts.values()) {
                            writer.write(contact.toString());
                            writer.newLine();
                        }
                        System.out.println("Contact list saved to " + fileName);
                    } catch (IOException e) {
                        System.out.println("IO Exception caught: " + e);
                    }
                    break;

                default:
                    System.out.println("Invalid selection. Please try again.");
                    break;
            }
        }
        input.close();
    }

    // Method to load contacts from a file
    private static void loadContacts(String fileName, TreeMap<String, Contact> allContacts) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Parsing is based on the format (which is used in the toString method for writing to the contact list file): 
                // "Name: first last, Company: company, Phone: phone, Email: email"
                String[] parts = line.split(", ");
                String[] namePart = parts[0].substring(6).split(" ");
                String firstName = namePart[0];
                String lastName = namePart[1];
                String company = parts[1].substring(9);
                String phone = parts[2].substring(7);
                String email = parts[3].substring(7);

                Contact contact = new Contact(firstName, lastName, company, phone, email);
                allContacts.put(lastName, contact);
            }
        } catch (IOException e) {
            System.out.println("IO Exception caught: " + e);
            System.exit(1);
        }
    }
}