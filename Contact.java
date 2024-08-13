/**
 * Katherine (Katie) Barrett
 * EN.605.201.81.SU24
 * Assignment #11 Part 1
 * 
 * References used for this assignment: 
 * Module 11 Office Hours Presentation
 * Module 11 Lectures A-E
 */

 public class Contact {

    // Instance variables to store contact information
    private String first;   // First name of the contact
    private String last;    // Last name of the contact
    private String company; // Company where the contact works
    private String phone;   // Phone number of the contact
    private String email;   // Email address of the contact

    // Parameterized constructor to initialize a Contact with all details
    public Contact(String first, String last, String company, String phone, String email) {
        this.first = first;
        this.last = last;
        this.company = company;
        this.phone = phone;
        this.email = email;
    }

    // Default constructor with default values for a Contact
    public Contact() {
        this("<unknown>", "<unknown>", "<unknown>", "<unknown>", "<unknown>");
    }

    // Getter for the first name
    public String getFirst() {
        return first;
    }

    // Setter for the first name
    public void setFirst(String first) {
        this.first = first;
    }

    // Getter for the last name
    public String getLast() {
        return last;
    }

    // Setter for the last name
    public void setLast(String last) {
        this.last = last;
    }

    // Getter for the company name
    public String getCompany() {
        return company;
    }

    // Setter for the company name
    public void setCompany(String company) {
        this.company = company;
    }

    // Getter for the phone number
    public String getPhone() {
        return phone;
    }

    // Setter for the phone number
    public void setPhone(String phone) {
        this.phone = phone;
    }

    // Getter for the email address
    public String getEmail() {
        return email;
    }

    // Setter for the email address
    public void setEmail(String email) {
        this.email = email;
    }

    // Returns a string representation of the contact in a readable format
    public String toString() {
        return String.format("Name: %s %s, Company: %s, Phone: %s, Email: %s",
                            first, last, company, phone, email);
    }
}