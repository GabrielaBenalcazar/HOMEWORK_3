package com.ironhack.homework_3.repository;

import com.ironhack.homework_3.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {

        //    The mean employeeCount can be displayed by typing “Mean EmployeeCount”
        @Query("SELECT AVG(employeeCount) FROM Account")
        Integer  meanEmployeeCount();

        //    The median employeeCount can be displayed by typing “Median EmployeeCount”
        @Query("SELECT employeeCount AS ec FROM Account " +  "ORDER BY ec")
        List<Integer> EmployeeCountList();

//        int medianEmployeeCount(); ????????????


        //    The maximum employeeCount can be displayed by typing “Max EmployeeCount”
        @Query("SELECT MAX(employeeCount) FROM Account")
        Integer maxEmployeeCount();

        //    The minimum employeeCount can be displayed by typing “Min EmployeeCount”
        @Query("SELECT MIN(employeeCount) FROM Account")
        Integer minEmployeeCount();




}
