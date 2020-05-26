package com.pzigic.fund.manager.repository;

import com.pzigic.fund.manager.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
