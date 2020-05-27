package com.pzigic.fund.manager.repository;

import com.pzigic.fund.manager.entity.Fund;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FundRepository extends JpaRepository<Fund, Long> {
}
