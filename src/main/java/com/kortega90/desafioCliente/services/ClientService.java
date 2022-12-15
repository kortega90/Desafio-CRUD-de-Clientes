package com.kortega90.desafioCliente.services;


import com.kortega90.desafioCliente.dto.ClientDTO;
import com.kortega90.desafioCliente.entities.Client;
import com.kortega90.desafioCliente.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientRepository repository;

    @Transactional(readOnly = true)
    public ClientDTO findById (Long id) {
        Client client = repository.findById(id).get();
        return new ClientDTO(client);
    }
    @Transactional(readOnly = true)
    public List<ClientDTO> findAll () {
        List <Client> rst = repository.findAll();
        return rst.stream().map(x -> new ClientDTO(x)).toList();
    }
}
