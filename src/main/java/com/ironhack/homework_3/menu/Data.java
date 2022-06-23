package com.ironhack.homework_3.menu;

import com.ironhack.homework_3.repository.*;
import com.ironhack.homework_3.style.Style;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Data {

    final AccountRepository accountRepository;
    final SalesRepsRepository salesRepRepository;
    final ContactRepository contactRepository;
    final LeadRepository leadRepository;
    final OpportunityRepository opportunityRepository;

    @Autowired
    public Data(AccountRepository accountRepository, SalesRepsRepository salesRepRepository, ContactRepository contactRepository, LeadRepository leadRepository, OpportunityRepository opportunityRepository) {
        this.accountRepository = accountRepository;
        this.salesRepsRepository = salesRepsRepository;
        this.contactRepository = contactRepository;
        this.leadRepository = leadRepository;
        this.opportunityRepository = opportunityRepository;
    }

    List<SalesRep> salesRepList;
    List<Lead> leadList;
    List<Contact> contactList;
    List<Opportunity> opportunityList;
    List<Account> accountList;

    // When this method is called, it populates the mySQL database with some sample data
    public void populateRepos() {

        accountList = accountRepository.saveAll(List.of(
        ));

        salesRepList = salesRepRepository.saveAll(List.of(

        ));

        contactList = contactRepository.saveAll(List.of(
          ));

        leadList = leadRepository.saveAll(List.of(

        ));

        opportunityList = opportunityRepository.saveAll(List.of
        );

        System.out.println(Style.OCHER + "\nDATA SUCCESSFULLY IMPLEMENTED\n" + Style.DEFAULT);
    }

    public void cleanAllTables(){
        accountRepository.deleteAll();
        contactRepository.deleteAll();
        opportunityRepository.deleteAll();
        leadRepository.deleteAll();
        salesRepRepository.deleteAll();

        System.out.println(Style.OCHER + "\nDATA SUCCESSFULLY DELETED\n" + Style.DEFAULT);
    }
}
