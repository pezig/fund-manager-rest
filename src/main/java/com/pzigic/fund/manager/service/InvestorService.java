package com.pzigic.fund.manager.service;

import com.pzigic.fund.manager.repository.ClientRepository;
import com.pzigic.fund.manager.repository.InvestorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class InvestorService {

    @Autowired
    private InvestorRepository investorRepository;
}
