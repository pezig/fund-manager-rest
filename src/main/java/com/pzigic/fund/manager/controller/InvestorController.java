package com.pzigic.fund.manager.controller;

import com.pzigic.fund.manager.common.Constant;
import com.pzigic.fund.manager.entity.Investor;
import com.pzigic.fund.manager.service.InvestorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@Slf4j
@RestController
@RequestMapping(value = Constant.PATH_INVESTOR)
public class InvestorController {
    
    @Autowired
    private InvestorService investorService;

    @GetMapping
    ResponseEntity<Page> findPage(Pageable pageable) {
        return ResponseEntity.ok(investorService.findPage(pageable));
    }

    @GetMapping(value = Constant.PATH_VARIABLE_ID)
    ResponseEntity<?> findInvestorsOfClient(@PathVariable("id") Long id) {
        Set<Investor> investors = investorService.findFundsOfClient(id);
        if(investors.size() > 0){
            return ResponseEntity.ok(investors);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @PostMapping
    Investor create(@RequestBody @Validated Investor investor) {
        return investorService.create(investor);
    }

    @PutMapping(value = Constant.PATH_VARIABLE_ID)
    ResponseEntity<Investor> update(@PathVariable("id") Long id, @RequestBody @Validated Investor investor) {
        return ResponseEntity.ok(investorService.update(id, investor));
    }

    @PatchMapping(value = Constant.PATH_VARIABLE_ID)
    ResponseEntity<Investor> patch(@PathVariable("id") Long id, @RequestBody @Validated Investor investor) {
        return ResponseEntity.ok(investorService.patch(id, investor));
    }
}
