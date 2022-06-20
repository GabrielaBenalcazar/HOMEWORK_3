package com.ironhack.homework_3.repository;

import com.ironhack.homework_3.model.Account;
import com.ironhack.homework_3.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer> {
}
