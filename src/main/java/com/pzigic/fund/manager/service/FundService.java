package com.pzigic.fund.manager.service;

import com.pzigic.fund.manager.common.util.Copy;
import com.pzigic.fund.manager.entity.Fund;
import com.pzigic.fund.manager.repository.ClientRepository;
import com.pzigic.fund.manager.repository.FundRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.NoSuchElementException;

@Service
@Transactional
public class FundService {

    @Autowired
    private FundRepository fundRepository;

    /**
     * find all funds
     *
     * @param xPageable the page, set 'null' to get all data
     * @return the page of fund
     */
    public Page<Fund> findPage(Pageable xPageable) {
        return fundRepository.findAll(xPageable);
    }

    /**
     * find person in object
     *
     * @param xID the person id
     * @return one fund
     */
    public Fund findOneById(Long xID) {
        return fundRepository.findById(xID).orElseThrow(NoSuchElementException::new);
    }

    /**
     * create new fund
     *
     * @param xFund the fund to be create
     * @return created fund
     */
    public Fund create(Fund xFund) {
        return fundRepository.save(xFund);
    }

    /**
     * update all field in fund by id
     *
     * @param xID     the fund id
     * @param xFund fund to be update
     * @return updated fund
     */
    public Fund update(Long xID, Fund xFund) {
        xFund.setFund_id(xID);
        return fundRepository.save(xFund);
    }

    /**
     * patch specific field in fund by id
     *
     * @param xID     the fund id
     * @param xFund fund to be update
     * @return updated fund
     */
    public Fund patch(Long xID, Fund xFund) {
        Fund fund = findOneById(xID);
        Copy.copyNonNullProperties(xFund, fund);

        return fundRepository.save(fund);
    }
}
