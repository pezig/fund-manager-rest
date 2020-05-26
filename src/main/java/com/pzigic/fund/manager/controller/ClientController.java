package com.pzigic.fund.manager.controller;

import com.pzigic.fund.manager.common.Constant;
import com.pzigic.fund.manager.entity.Client;
import com.pzigic.fund.manager.service.ClientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(value = Constant.PATH_CLIENT)
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping
    ResponseEntity<Page> findPage(Pageable pageable) {
        return ResponseEntity.ok(clientService.findPage(pageable));
    }

    @PostMapping
    Client create(@RequestBody @Validated Client client) {
        return clientService.create(client);
    }

    @PutMapping(value = Constant.PATH_VARIABLE_ID)
    ResponseEntity<Client> update(@PathVariable("id") Long id, @RequestBody @Validated Client client) {
        return ResponseEntity.ok(clientService.update(id, client));
    }

    @PatchMapping(value = Constant.PATH_VARIABLE_ID)
    ResponseEntity<Client> patch(@PathVariable("id") Long id, @RequestBody @Validated Client client) {
        return ResponseEntity.ok(clientService.patch(id, client));
    }



}
