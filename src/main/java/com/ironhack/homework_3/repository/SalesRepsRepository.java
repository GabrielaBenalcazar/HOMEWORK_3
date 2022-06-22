package com.ironhack.homework_3.repository;

import com.ironhack.homework_3.model.SalesRep;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalesRepsRepository extends JpaRepository<SalesRep, Integer> {

}
