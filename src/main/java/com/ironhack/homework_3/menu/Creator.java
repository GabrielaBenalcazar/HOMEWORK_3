package com.ironhack.homework_3.menu;
import com.ironhack.homework_3.repository.*;
import lombok.Getter;
import com.ironhack.homework_3.model.*;
import com.ironhack.homework_3.style.Style;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.NoSuchElementException;

@Getter
@Setter

@Component
public class Creator {

        // Añadido los repositories para data
    final AccountRepository accountRepository;
    final SalesRepsRepository salesRepsRepository;
    final ContactRepository contactRepository;
    final LeadRepository leadRepository;
    final OpportunityRepository opportunityRepository;

    @Autowired
    Data data;

        private Input input;
        private Printer printer;

        // Añadido el constructor con los repositories
    @Autowired
    public Creator(AccountRepository accountRepository, SalesRepsRepository salesRepRepository, ContactRepository contactRepository, LeadRepository leadRepository, OpportunityRepository opportunityRepository, Input input, Printer printer) {
        this.accountRepository = accountRepository;
        this.salesRepsRepository = salesRepsRepository;
        this.contactRepository = contactRepository;
        this.leadRepository = leadRepository;
        this.opportunityRepository = opportunityRepository;
        this.input = input;
        this.printer = printer;
    }



    // Method used to create a SALES REP independently
     public void createSalesRep(){


         // New SALES REP Object saved in database
         // Print a SALES REP creation message
     }

    // Method used to create an ACCOUNT independently or when a LEAD is converted
    public void createAccount() {

        // New ACCOUNT Object saved in database
        // Print an ACCOUNT creation message


    }

    // Method used to create a LEAD independently
    public void createLead() {
        // First it is checked if there is any Sales Rep as we need to associate one to our Lead.
        // Then, the user is asked for all the necessary info

    }


    // Method used to create a CONTACT independently
      public void createContact() {
          // First it is checked if there is any Lead and any Account as we need to associate one of each to our Contact.
          // Then, the user is asked for all the necessary info
          // New CONTACT Object saved in database
          // Print a CONTACT creation message


      }

    //  Method that creates a CONTACT automatically when LEAD is converted, creating a new ACCOUNT
    public void createContact(Lead lead) {
        // This method is implemented right after the createAccount(Lead lead) method, triggered by the "convert <id number>" command.
        // This means that the Account associated is the last one saved in the accountRepository.

        // New CONTACT Object saved in database with the LEAD information
        // Print a CONTACT creation message
    }



    //  Method that creates a CONTACT automatically when LEAD is converted, selecting an existing ACCOUNT
    public void createContact(Lead lead, Account account) {
        // This method is triggered by selecting that you do not want to create a new Account
        // New CONTACT Object saved in database with the LEAD information
        // Print a CONTACT creation message
    }


    // Method used when an OPPORTUNITY is created independently
    public void createOpportunity() {
        // First it is checked if there is any Contact and Sales Rep as we need to associate one of each to our Opportunity.

        // Then, the user is asked for all the necessary info
        // Since decisionMaker and opportunity have a oneToOne relationship, it must be ensured that the contact exists
        // and is not previously linked to any other opportunity.

        // Determine whether or not that contact exists in the database
        // Determine if the contact has been previously linked to another opportunity
        // Ask if the user wants to come back to the main menu

        // New OPPORTUNITY Object saved in database
        // Print an OPPORTUNITY creation message

    }

    // Method that creates an OPPORTUNITY when LEAD is converted, creating a new ACCOUNT
    public void createOpportunityByLeadConversion(Lead lead) {

        // This method is implemented right after the createContact(Lead lead) method and the createAccount(Lead lead) method,
        // triggered by the "convert <id number>" command. This means that the Contact associated with this Opportunity is the
        // last one saved in the contactRepository and the Account associated is the last one saved in the accountRepository.
        // New OPPORTUNITY Object saved in database

        // Print an OPPORTUNITY creation message

    }

    // Method that creates an OPPORTUNITY when LEAD is converted, selecting an existing ACCOUNT
    public void createOpportunityByLeadConversion(Lead lead, Account account) {

        // This method is implemented right after the createContact(Lead lead) method triggered by the "convert <id number>" command.
        // This means that the Contact associated with this Opportunity is the last one saved in the contactRepository.
        // New OPPORTUNITY Object saved in database
        // Print an OPPORTUNITY creation message

    }




//       OLDDDD EXAMPLESSS



//        public void createLead() {
//            // Asks user all the necessary info
//            System.out.println(Style.OCHER + "Creating an independent OPPORTUNITY." + Style.DEFAULT);
//            System.out.println("Please input the following:");
//
//            String name;
//            boolean errorName = false;
//            do {
//
//                System.out.println("\nName:");
//                name = input.getString();
//
//                try {
//                    errorName = Validator.isStringValid(name);
//                } catch (IllegalArgumentException e) {
//                    System.out.println("Input is whether empty or too long, or it may contain not valid characters.");
//                }
//
//            } while (!errorName);
//
//
//            String phoneNumber;
//            boolean errorPhone = false;
//            do {
//
//                System.out.println("\nPhone Number:");
//                phoneNumber = input.getString();
//
//                try {
//                    errorPhone = Validator.isPhoneNumberValid(phoneNumber);
//                } catch (IllegalArgumentException e) {
//                    System.out.println("The phone number must have 9 digits. A prefix can be included.");
//                }
//
//            } while (!errorPhone);
//
//
//            String email;
//            boolean errorEmail = false;
//            do {
//
//                System.out.println("\nEmail:");
//                email = input.getString();
//
//                try {
//                    errorEmail = Validator.isEmailValid(email);
//                } catch (IllegalArgumentException e) {
//                    System.out.println("The email address format is not valid.");
//                }
//
//            } while (!errorEmail);
//
//
//            String companyName;
//            boolean errorCompany = false;
//            do {
//
//                System.out.println("\nCompany Name:");
//                companyName = input.getString();
//
//                try {
//                    errorCompany = Validator.isStringValid(companyName);
//                } catch (IllegalArgumentException e) {
//                    System.out.println("Input is whether empty or too long, or it may contain not valid characters.");
//                }
//
//            } while (!errorCompany);
//
//            Lead lead = new Lead(name, phoneNumber, email, companyName);
//
//            // Print a LEAD creation message, using Lead.toString method on the last element of leadsList, newly created
//            System.out.println("\nA new LEAD was created with the following info:");
//            System.out.println(lead);
//
//        }





    // Utility methods  //////    COPY AND PASTE  //////

    // Requests an ACCOUNT id and validates whether or not it exists in the database
    public int getExistingAccount() {

        int idAccount;
        boolean errorAccount = false;
        do {

            System.out.println("\nACCOUNT id:");
            idAccount = input.getIntegerHigherThanZero();

            try {
                accountRepository.findById(idAccount).get();
                errorAccount = true;
            } catch (NoSuchElementException e) {
                System.out.println(Style.RED + "\nThe id entered does not correspond to any account.");
                System.out.println(Style.DEFAULT + "\nPlease, try again.");
            }

        } while (!errorAccount);

        return idAccount;

    }

    // Requests a LEAD id and validates whether or not it exists in the database
    public int getExistingLead() {


    }

    // Requests a LEAD id and validates whether or not it exists in the database
    public int getExistingSalesRep() {

    }


    // _SHOW functionality methods_

    public void printAllAccounts() {
        for (Account account : accountRepository.findAll()) {
            System.out.println(account);
        }
    }

    public void printAllContacts() {
        for (Contact contact : contactRepository.findAll()) {
            System.out.println(contact);
        }
    }

    public void printAllLeads() {
        for (Lead lead : leadRepository.findAll()) {
            System.out.println(lead);
        }
    }

    public void printAllOpportunities() {
        for (Opportunity opportunity : opportunityRepository.findAll()) {
            System.out.println(opportunity);
        }
    }

    public void printAllSalesRep() {
        for (SalesRep salesRep : salesRepsRepository.findAll()) {
            System.out.println(salesRep);
        }
    }

}
