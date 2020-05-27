package com.pzigic.fund.manager.controller;

import com.pzigic.fund.manager.common.Constant;
import com.pzigic.fund.manager.entity.Fund;
import com.pzigic.fund.manager.service.FundService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(value = Constant.PATH_FUND)
public class FundController {
    @Autowired
    private FundService fundService;

    @GetMapping
    ResponseEntity<Page> findPage(Pageable pageable) {
        return ResponseEntity.ok(fundService.findPage(pageable));
    }

    @PostMapping
    Fund create(@RequestBody @Validated Fund fund) {
        return fundService.create(fund);
    }

    @PutMapping(value = Constant.PATH_VARIABLE_ID)
    ResponseEntity<Fund> update(@PathVariable("id") Long id, @RequestBody @Validated Fund fund) {
        return ResponseEntity.ok(fundService.update(id, fund));
    }

    @PatchMapping(value = Constant.PATH_VARIABLE_ID)
    ResponseEntity<Fund> patch(@PathVariable("id") Long id, @RequestBody @Validated Fund fund) {
        return ResponseEntity.ok(fundService.patch(id, fund));
    }
}
