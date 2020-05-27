package com.pzigic.fund.manager.service;

import com.pzigic.fund.manager.common.util.Copy;
import com.pzigic.fund.manager.entity.Investor;
import com.pzigic.fund.manager.repository.InvestorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.NoSuchElementException;
import java.util.Set;

@Service
@Transactional
public class InvestorService {

    @Autowired
    private InvestorRepository investorRepository;

    /**
     * find all investors
     *
     * @param xPageable the page, set 'null' to get all data
     * @return the page of investor
     */
    public Page<Investor> findPage(Pageable xPageable) {
        return investorRepository.findAll(xPageable);
    }

    /**
     * find person in object
     *
     * @param xID the person id
     * @return one investor
     */
    public Investor findOneById(Long xID) {
        return investorRepository.findById(xID).orElseThrow(NoSuchElementException::new);
    }

    /**
     * find person in object
     *
     * @param xID the client id
     * @return 0 or more investors
     */
    public Set<Investor> findFundsOfClient(Long xID) {
        return investorRepository.getFundsOfClient(xID);
    }

    /**
     * create new investor
     *
     * @param xInvestor the investor to be create
     * @return created investor
     */
    public Investor create(Investor xInvestor) {
        System.out.println(xInvestor);


        return investorRepository.save(xInvestor);
    }

    /**
     * update all field in investor by id
     *
     * @param xID     the investor id
     * @param xInvestor investor to be update
     * @return updated investor
     */
    public Investor update(Long xID, Investor xInvestor) {
        xInvestor.setInvestor_id(xID);
        return investorRepository.save(xInvestor);
    }

    /**
     * patch specific field in investor by id
     *
     * @param xID     the investor id
     * @param xInvestor investor to be update
     * @return updated investor
     */
    public Investor patch(Long xID, Investor xInvestor) {
        Investor investor = findOneById(xID);
        Copy.copyNonNullProperties(xInvestor, investor);

        return investorRepository.save(investor);
    }
}
