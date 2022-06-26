package com.ironhack.homework_3.main;

import com.ironhack.homework_3.menu.Menu;
import com.ironhack.homework_3.menu.Printer;
import com.ironhack.homework_3.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Main {

    @Autowired
    private static AccountRepository accountRepository;
    @Autowired
    private static SalesRepsRepository salesRepsRepository;
    @Autowired
    private static ContactRepository contactRepository;
    @Autowired
    private static LeadRepository leadRepository;
    @Autowired
    private static OpportunityRepository opportunityRepository;



    public static void main(String[] args) throws InterruptedException {
        Menu menu = new Menu(accountRepository, salesRepsRepository, contactRepository, leadRepository, opportunityRepository);
        Printer printer = new Printer();
        printer.welcomeMessage();
        menu.controlLoop();

    }

}
