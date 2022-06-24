package com.ironhack.homework_3.menu;
import com.ironhack.homework_3.enums.Industry;
import com.ironhack.homework_3.enums.Product;
import com.ironhack.homework_3.repository.*;
import lombok.Getter;
import com.ironhack.homework_3.model.*;
import com.ironhack.homework_3.style.Style;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.server.DelegatingServerHttpResponse;
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
    public Creator(AccountRepository accountRepository, SalesRepsRepository salesRepsRepository, ContactRepository contactRepository, LeadRepository leadRepository, OpportunityRepository opportunityRepository, Input input, Printer printer) {
        this.accountRepository = accountRepository;
        this.salesRepsRepository = salesRepsRepository;
        this.contactRepository = contactRepository;
        this.leadRepository = leadRepository;
        this.opportunityRepository = opportunityRepository;
        this.input = input;
        this.printer = printer;
    }


    // Method used to create a SALES REP independently
    public void createSalesRep() {
        // Comunicar con la consola para pedir los datos
        System.out.println("\n" + Style.OCHER + "CREATE SALES REP" + Style.DEFAULT);

        // DAtos necesarios con un loop -- do while ---
        String name;
        boolean errorName = false;
        do {

            System.out.println("\nName:");
            name = input.getString();

            try {
                errorName = Validator.isStringValid(name);
            } catch (IllegalArgumentException e) {
                System.out.println("Input is whether empty or too long, or it may contain not valid characters.");
            }

        } while (!errorName);


        // New SALES REP Object saved in database
        SalesRep salesRep = new SalesRep(name);
        salesRepsRepository.save(salesRep);

        // Print a SALES REP creation message
        System.out.println("\n" + Style.OCHER + "SALES REP CREATED" + Style.DEFAULT);
        System.out.println(salesRep);
    }

    // Method used to create an ACCOUNT independently or when a LEAD is converted
    public void createAccount() {
        // New ACCOUNT Object saved in database
        System.out.println("\n" + Style.OCHER + "CREATE ACCOUNT" + Style.DEFAULT);

        String companyName;
        boolean errorName = false;
        do {

            System.out.println("\nCompany Name:");
            companyName = input.getString();

            try {
                errorName = Validator.isStringValid(companyName);
            } catch (IllegalArgumentException e) {
                System.out.println("Input is whether empty or too long, or it may contain not valid characters.");
            }

        } while (!errorName);

        System.out.println("\nChoose Industry:");
        Industry industry = Input.getIndustry();  //**********************Es un enumerado, revisar función getIndustry()

        System.out.println("\nWrite the number of Employees:");
        int employeeCount = Input.getIntegerHigherThanZero();
        //
        System.out.println("\n" + Style.OCHER + "PLEASE INTRODUCE A CITY" + Style.DEFAULT);

        String city;
        boolean errorName = false;
        do {
            System.out.println("\nCity:");
            city = input.getString();
            try {
                errorName = Validator.isStringValid(city);
            } catch (IllegalArgumentException e) {
                System.out.println("Input is whether empty or too long, or it may contain not valid characters.");
            }
        } while (!errorName);

        System.out.println("\n" + Style.OCHER + "PLEASE INTRODUCE THE COUNTRY" + Style.DEFAULT);
        String country;
        boolean errorName = false;
        do {
            System.out.println("\nCountry:");
            country = input.getString();
            try {
                errorName = Validator.isStringValid(country);
            } catch (IllegalArgumentException e) {
                System.out.println("Input is whether empty or too long, or it may contain not valid characters.");
            }
        } while (!errorName);

        // New ACCOUNT Object saved in database
        Account account = new Account(companyName, industry, employeeCount, city, country);
        accountRepository.save(account);

        // Print an ACCOUNT creation message
        System.out.println("\n" + Style.OCHER + "ACCOUNT CREATED" + Style.DEFAULT);
        System.out.println(account);
    }

    // Method used to create a LEAD independently
    public void createLead() {
        // First it is checked if there is any Sales Rep as we need to associate one to our Lead.
        if (salesRepsRepository.count() == 0) {
            System.out.println("\n" + Style.OCHER + "NO SALES REPS FOUND" + Style.DEFAULT);
            System.out.println("\n" + Style.OCHER + "PLEASE CREATE A SALES REP" + Style.DEFAULT);
            // Then, the user is asked for all the necessary info
        }
        return;
    } else

    {
        System.out.println("\n" + Style.OCHER + "CREATING A NEW SALES REP" + Style.DEFAULT);
    }

    // Comunicar con la consola para pedir los datos
    String name;
    boolean errorName = false;
                do

    {
        System.out.println("\nName:");
        name = input.getString();
        try {
            errorName = Validator.isStringValid(name);
        } catch (IllegalArgumentException e) {
            System.out.println("Input is whether empty or too long, or it may contain not valid characters.");
        }
    } while(!errorName);

    String phoneNumber;
    boolean errorPhone = false;
        do
        {
            System.out.println("\nPhone Number:");
            phoneNumber = input.getString();
            try {
                errorPhone = Validator.isPhoneNumberValid(phoneNumber);
            } catch (IllegalArgumentException e) {
                System.out.println("Input has not correct format.");
            }
        } while(!errorPhone);
    String email;
    boolean errorEmail = false;
        do
    {
        System.out.println("\nemail:");
        email = input.getString();
        try {
            errorEmail = Validator.isEmailValid(email);
        } catch (IllegalArgumentException e) {
            System.out.println("Input has not correct format.");
        }
    } while(!errorEmail);

    String companyName;
    boolean errorName = false;
        do {
        System.out.println("\nCompany name:");
        companyName = input.getString();
        try {
            errorName = Validator.isStringValid(companyName);
        } catch (IllegalArgumentException e) {
            System.out.println("Input is whether empty or too long, or it may contain not valid characters.");
        }
    } while (!errorName);

    int salesRepId=getSalesRepId();  //**********************Crear función

    // New LEAD Object saved in database
    Lead lead = new Lead(name, phoneNumber, email, companyName, salesRepsRepository.findById(salesRepId).get());
        leadRepository.save(lead);

    // Print an ACCOUNT creation message
        System.out.println("\n" + Style.OCHER + "NEW LEAD CREATED" + Style.DEFAULT);
        System.out.println(lead);
}

    // Method used to create a CONTACT independently

    public void createContact() {
      // First it is checked if there is any Lead and any Account as we need to associate one of each to our Contact.
        if (leadRepository.count() == 0) {
            System.out.println("\n" + Style.OCHER + "NO LEADS FOUND" + Style.DEFAULT);
            System.out.println("\n" + Style.OCHER + "PLEASE CREATE A LEAD" + Style.DEFAULT);
            // Then, the user is asked for all the necessary info
        } else if (accountRepository.count() == 0) {
            System.out.println("\n" + Style.OCHER + "NO ACCOUNTS FOUND" + Style.DEFAULT);
            System.out.println("\n" + Style.OCHER + "PLEASE CREATE AN ACCOUNT" + Style.DEFAULT);
        } else {
            System.out.println("\n" + Style.OCHER + "CREATING A NEW CONTACT" + Style.DEFAULT);
        }
        return;

        int LeadId=getExistingLead(); //**********************Chequear funciones**********
        int AccountId=getExistingAccount();

        // New CONTACT Object saved in database
        Contact contact = new Contact(LeadId, AccountId);  ///**********************Chequear funciones**********
        contactRepository.save(contact);
        // Print a CONTACT creation message
        System.out.println("\n" + Style.OCHER + "CONTACT CREATED" + Style.DEFAULT);
        System.out.println(contact);

      }

    //  Method that creates a CONTACT automatically when LEAD is converted, creating a new ACCOUNT
    public void createContact(Lead lead) {
        // This method is implemented right after the createAccount(Lead lead) method, triggered by the "convert <id number>" command.
        // This means that the Account associated is the last one saved in the accountRepository.
        // New CONTACT Object saved in database with the LEAD information
        // Print a CONTACT creation message

        // New CONTACT Object saved in database
        Contact contact = new Contact(LeadId, AccountId);  ///**********************Chequear funciones**********
        contactRepository.save(contact);
        // Print a CONTACT creation message
        System.out.println("\n" + Style.OCHER + "CONTACT CREATED" + Style.DEFAULT);
        System.out.println(contact);
    }

    //  Method that creates a CONTACT automatically when LEAD is converted, selecting an existing ACCOUNT
    public void createContact(Lead lead, Account account) {
        // This method is triggered by selecting that you do not want to create a new Account
        // New CONTACT Object saved in database with the LEAD information
        // Print a CONTACT creation message

        // New CONTACT Object saved in database
        Contact contact = new Contact(LeadId, AccountId);  ///**********************Chequear funciones**********
        contactRepository.save(contact);
        // Print a CONTACT creation message
        System.out.println("\n" + Style.OCHER + "CONTACT CREATED" + Style.DEFAULT);
        System.out.println(contact);
    }

    // Method used when an OPPORTUNITY is created independently   //*******************PDTE**********************
    public void createOpportunity() {
        // First it is checked if there is any Contact and Sales Rep as we need to associate one of each to our Opportunity.
        if (contactRepository.count() == 0) {
            System.out.println("\n" + Style.OCHER + "NO CONTACTS FOUND" + Style.DEFAULT);
            System.out.println("\n" + Style.OCHER + "PLEASE CREATE A CONTACT" + Style.DEFAULT);
            // Then, the user is asked for all the necessary info
        } else if (salesRepsRepository.count() == 0) {
            System.out.println("\n" + Style.OCHER + "NO SALES REPS FOUND" + Style.DEFAULT);
            System.out.println("\n" + Style.OCHER + "PLEASE CREATE A SALES REP" + Style.DEFAULT);
            // Then, the user is asked for all the necessary info
        } else {
            System.out.println("\n" + Style.OCHER + "CREATING A NEW OPPORTUNITY" + Style.DEFAULT);
        }
        // Then, the user is asked for all the necessary info
        // Since decisionMaker and opportunity have a oneToOne relationship, it must be ensured that the contact exists and is not previously linked to any other opportunity.

        // Determine whether or not that contact exists in the database
        // Determine if the contact has been previously linked to another opportunity
        // Ask if the user wants to come back to the main menu

        // New OPPORTUNITY Object saved in database
        // Print an OPPORTUNITY creation message
    }
//*************************************************************************************************************************

    // Method that creates an OPPORTUNITY when LEAD is converted, creating a new ACCOUNT
    public void createOpportunityByLeadConversion(Lead lead) {

        // This method is implemented right after the createContact(Lead lead) method and the createAccount(Lead lead) method, triggered by the "convert <id number>" command. This means that the Contact associated with this Opportunity is the
        // last one saved in the contactRepository and the Account associated is the last one saved in the accountRepository.
        System.out.println("\n" + Style.OCHER + "ADDITIONAL INFO" + Style.DEFAULT);
        System.out.println("\n" + Style.OCHER + "PRODUCT TYPE" + Style.DEFAULT);
        Product product=input.chooseProduct();
        System.out.println("\n" + Style.OCHER + "TRUCKS NUMBER" + Style.DEFAULT);
        int quantity=input.getIntegerHigherThanZero();
        //*************************************************************************************************************************
        Opportunity opportunity = new Opportunity(contactRepository.findById(contactId).get(),accountRepository.findById(accountId).get(), lead, product, quantity);

        // New OPPORTUNITY Object saved in database
        opportunityRepository.save(opportunity);

        // Print an OPPORTUNITY creation message
        System.out.println("\n" + Style.OCHER + "OPPORTUNITY CREATED" + Style.DEFAULT);
        System.out.println(opportunity);
    }

    // Method that creates an OPPORTUNITY when LEAD is converted, selecting an existing ACCOUNT
    public void createOpportunityByLeadConversion(Lead lead, Account account) {

        // This method is implemented right after the createContact(Lead lead) method triggered by the "convert <id number>" command.
        System.out.println("\n" + Style.OCHER + "ADDITIONAL INFO" + Style.DEFAULT);
        System.out.println("\n" + Style.OCHER + "PRODUCT TYPE" + Style.DEFAULT);
        Product product=input.chooseProduct();
        System.out.println("\n" + Style.OCHER + "TRUCKS NUMBER" + Style.DEFAULT);
        int quantity=input.getIntegerHigherThanZero();
        //*************************************************************************************************************************
Opportunity opportunity = new Opportunity(contactRepository.findById(contactId).get(),accountRepository.findById(accountId).get(), lead, product, quantity);
        // New OPPORTUNITY Object saved in database
        opportunityRepository.save(opportunity);
        // Print an OPPORTUNITY creation message
        System.out.println("\n" + Style.OCHER + "OPPORTUNITY CREATED" + Style.DEFAULT);
        System.out.println(opportunity);

    }





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
