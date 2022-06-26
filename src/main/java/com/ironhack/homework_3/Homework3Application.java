package com.ironhack.homework_3;

import com.ironhack.homework_3.menu.Menu;
import com.ironhack.homework_3.menu.Printer;
import com.ironhack.homework_3.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class Homework3Application {

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
		SpringApplication.run(Homework3Application.class, args);
		Menu menu = new Menu(accountRepository, salesRepsRepository, contactRepository, leadRepository, opportunityRepository);
		Printer printer = new Printer();
		printer.welcomeMessage();
		menu.controlLoop();

	}
//
//	public static void main(String[] args) {
//
//		SpringApplication.run(Homework3Application.class, args);
//	}

}
