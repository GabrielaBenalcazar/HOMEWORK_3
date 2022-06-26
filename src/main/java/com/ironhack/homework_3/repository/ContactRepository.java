package com.ironhack.homework_3.repository;

import com.ironhack.homework_3.model.Account;
import com.ironhack.homework_3.model.Contact;
import com.ironhack.homework_3.model.SalesRep;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer> {
    Optional<Contact> findFirstByNameAndPhoneNumberAndEmailAndCompanyName(String name, String phoneNumber, String email, String companyName);
    Optional<Contact> findById(Integer id, SalesRep salesRep, Account account);
}
