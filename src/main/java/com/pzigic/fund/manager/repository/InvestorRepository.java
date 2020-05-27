package com.pzigic.fund.manager.repository;

import com.pzigic.fund.manager.entity.Investor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Set;

public interface InvestorRepository extends JpaRepository<Investor, Long> {

    @Query("SELECT i FROM Investor i INNER JOIN Client c ON c.client_id = i.client WHERE i.client IS :id")
    Set<Investor> getFundsOfClient(@Param("id") Long Id);

}
