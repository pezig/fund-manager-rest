package com.pzigic.fund.manager.repository;

import com.pzigic.fund.manager.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvestorRepository extends JpaRepository<Person, Long> {
}