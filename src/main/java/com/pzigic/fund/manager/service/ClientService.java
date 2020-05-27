package com.pzigic.fund.manager.service;

import com.pzigic.fund.manager.common.util.Copy;
import com.pzigic.fund.manager.entity.Client;
import com.pzigic.fund.manager.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.NoSuchElementException;

@Service
@Transactional
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    /**
     * find all clients
     *
     * @param xPageable the page, set 'null' to get all data
     * @return the page of client
     */
    public Page<Client> findPage(Pageable xPageable) {
        return clientRepository.findAll(xPageable);
    }

    /**
     * find person in object
     *
     * @param xID the person id
     * @return one client
     */
    public Client findOneById(Long xID) {
        return clientRepository.findById(xID).orElseThrow(NoSuchElementException::new);
    }

    /**
     * create new client
     *
     * @param xClient the client to be create
     * @return created client
     */
    public Client create(Client xClient) {
        return clientRepository.save(xClient);
    }

    /**
     * update all field in client by id
     *
     * @param xID     the client id
     * @param xClient client to be update
     * @return updated client
     */
    public Client update(Long xID, Client xClient) {
        xClient.setClient_id(xID);
        return clientRepository.save(xClient);
    }

    /**
     * patch specific field in client by id
     *
     * @param xID     the client id
     * @param xClient client to be update
     * @return updated client
     */
    public Client patch(Long xID, Client xClient) {
        Client client = findOneById(xID);
        Copy.copyNonNullProperties(xClient, client);

        return clientRepository.save(client);
    }
}
