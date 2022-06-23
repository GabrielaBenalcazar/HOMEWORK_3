package com.ironhack.homework_3.main;

import com.ironhack.homework_3.menu.Menu;
import com.ironhack.homework_3.menu.Printer;
import com.ironhack.homework_3.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Main {

    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private SalesRepsRepository salesRepsRepository;
    @Autowired
    private ContactRepository contactRepository;
    @Autowired
    private LeadRepository leadRepository;
    @Autowired
    private OpportunityRepository opportunityRepository;



    public static void main(String[] args) throws InterruptedException {
        Menu menu = new Menu(accountRepository, salesRepsRepository, contactRepository, leadRepository, opportunityRepository);
        Printer printer = new Printer();
        printer.welcomeMessage();
        menu.controlLoop();

    }

}
