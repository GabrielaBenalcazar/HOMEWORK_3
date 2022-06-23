package com.ironhack.homework_3.repository;

import com.ironhack.homework_3.model.Account;
import com.ironhack.homework_3.model.Contact;
import com.ironhack.homework_3.model.Opportunity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OpportunityRepository extends JpaRepository<Opportunity, Integer> {


    Optional<Opportunity> findByDecisionMaker(Contact contact);

    @Query
    String[][] reportOpportunityByProduct();

    @Query
    String[][] reportClosedWonOpportunityByProduct();

    @Query
    String[][] reportClosedLostOpportunityByProduct();

    @Query
    String[][] reportOpenOpportunityByProduct();

    @Query
    String[][] reportOpportunitiesByCountry();

    @Query
    String[][] reportClosedWonOpportunitiesByCountry();

    @Query
    String[][] reportClosedLostOpportunitiesByCountry();

    @Query
    String[][] reportOpenOpportunitiesByCountry();

    @Query
    String[][] reportOpportunitiesByCity();

    @Query
    String[][] reportClosedWonOpportunitiesByCity();

    @Query
    String[][] reportClosedLostOpportunitiesByCity();

    @Query
    String[][] reportOpenOpportunitiesByCity();

    @Query
    String[][] reportOpportunitiesByIndustry();

    @Query
    String[][] reportClosedWonOpportunitiesByIndustry();

    @Query
    String[][] reportClosedLostOpportunitiesByIndustry();

    @Query
    String[][] reportOpenOpportunitiesByIndustry();

    // Mean quantity of products ordered
    @Query
    double meanQuantity();

    // Median quantity of products ordered
    @Query
    double medianQuantity();

    // Maximum number of orders placed in one opportunity
    @Query
    int maxQuantity();

    // Minimum number of orders placed in one opportunity
    @Query
    int minQuantity();

    // Mean number of Opportunities associated with an Account
    @Query
    double meanOppsPerAccount();

    // Median number of Opportunities associated with an Account
    @Query
    double medianOppsPerAccount();

    // Maximum number of Opportunities associated with an Account
    @Query
    int maxOppsPerAccount();

    // Minimum number of Opportunities associated with an Account
    @Query int minOppsPerAccount();

}
