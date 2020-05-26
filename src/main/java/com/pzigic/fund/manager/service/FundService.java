package com.pzigic.fund.manager.service;

import com.pzigic.fund.manager.repository.ClientRepository;
import com.pzigic.fund.manager.repository.FundRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class FundService {

    @Autowired
    private FundRepository fundRepository;
}
